package com.zgs.es.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

/**
 * @author zgs
 * @date 2021年12月03日 15:22:00
 */
@Slf4j
public class EsTest_Doc_Filter_Get {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost",9200,"http")));
        try{
            SearchRequest request = new SearchRequest();
            request.indices("zgs");
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            sourceBuilder.query(QueryBuilders.matchAllQuery());
            String[] excludes = {"name"};
            String[] includes = {};
            sourceBuilder.fetchSource(includes,excludes);
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
