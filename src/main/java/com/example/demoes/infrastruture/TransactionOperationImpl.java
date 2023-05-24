package com.example.demoes.infrastruture;

import com.example.demoes.model.Transaction;
import com.example.demoes.port.TransactionPort;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

@Repository
@Qualifier("operation")
public class TransactionOperationImpl implements TransactionPort {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;


    @Override
    public Transaction getTransaction(String id) {
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("_id", id);
        Query searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        SearchHits<Transaction> searchHits = elasticsearchOperations.search(searchQuery, Transaction.class);
        var results = searchHits.getSearchHits().stream().map(SearchHit::getContent)
                .collect(Collectors.toList());

        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public void indexTransaction(Transaction transaction) {
        IndexQuery indexQuery = new IndexQueryBuilder()
                .withObject(transaction)
                .build();
        elasticsearchOperations.index(indexQuery, IndexCoordinates.of("transaction"));
    }
}
