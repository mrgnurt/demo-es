package com.example.demoes.infrastruture;

import com.example.demoes.model.Transaction;
import com.example.demoes.domain.repository.TransactionPort;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Qualifier("operation")
public class TransactionOperationImpl implements TransactionPort {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;


    @Override
    public List<Transaction> getTransactions(String id, String partnerId) {
        var queryBuilder = QueryBuilders.boolQuery();
        if (id != null) {
            var queryBuilderId = QueryBuilders.termQuery("id", id);
            queryBuilder.must(queryBuilderId);
        }

        if (partnerId != null) {
            var queryBuilderPartnerId = QueryBuilders.termQuery("partnerId", partnerId);
            queryBuilder.must(queryBuilderPartnerId);
        }

        Query searchQuery = new NativeSearchQueryBuilder()
                .withFilter(queryBuilder)
                .withPageable(PageRequest.of(0, 10))
                .build();

        SearchHits<Transaction> searchHits = elasticsearchOperations.search(searchQuery, Transaction.class);
        var results = searchHits.getSearchHits().stream().map(SearchHit::getContent)
                .collect(Collectors.toList());

        return results;
    }

    @Override
    public void indexTransaction(Transaction transaction) {
        IndexQuery indexQuery = new IndexQueryBuilder()
                .withObject(transaction)
                .build();

        elasticsearchOperations.index(indexQuery, IndexCoordinates.of("transaction"));
    }
}
