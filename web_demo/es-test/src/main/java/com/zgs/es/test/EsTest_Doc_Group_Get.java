package com.zgs.es.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

/**
 * @author zgs
 * @date 2021年12月03日 15:41:00
 */
@Slf4j
public class EsTest_Doc_Group_Get {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost",9200,"http")));
        try{
            SearchRequest request = new SearchRequest();
            request.indices("zgs");
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
//            queryBuilder.must(QueryBuilders.matchQuery("age",22));
//            queryBuilder.must(QueryBuilders.matchQuery("name","张帅"));
            queryBuilder.should(QueryBuilders.matchQuery("age","22"));
            queryBuilder.should(QueryBuilders.matchQuery("age","23"));
            sourceBuilder.query(queryBuilder);
            request.source(sourceBuilder);
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            SearchHits hits = response.getHits();
            log.info("##################################getTotalHits:"+hits.getTotalHits());
            log.info("##################################getTook:"+response.getTook());
            for (SearchHit hit : hits) {
                log.info("#####################hit:"+hit.getSourceAsString());
            }
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }finally {
            client.close();
        }
    }
}
