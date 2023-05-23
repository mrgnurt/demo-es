# Demo Elasticsearch

# Install ES
`docker run -p 127.0.0.1:9200:9200 -p 127.0.0.1:9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.17.10`

### How to run application
`docker build -t demo-es .`

`docker run -p 8080:8080 -d demo-es`
