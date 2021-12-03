package com.zgs.es.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;

/**
 * @author zgs
 * @date 2021年12月03日 16:08:00
 */
@Slf4j
public class EsTest_Doc_Fuzzy_Get {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost",9200,"http")));
        try{
            SearchRequest request = new SearchRequest();
            request.indices("zgs");
            SearchSourceBuilder builder = new SearchSourceBuilder();
            FuzzyQueryBuilder queryBuilder = QueryBuilders.fuzzyQuery("name", "张帅").fuzziness(Fuzziness.ONE);
            builder.query(queryBuilder);
            request.source(builder);
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            SearchHits hits = response.getHits();
            log.info("##################################getTotalHits:"+hits.getTotalHits());
            log.info("##################################getTook:"+response.getTook());
            for (SearchHit hit : hits) {
                log.info("#####################hit:"+hit.getSourceAsString());
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }finally {
            client.close();
        }
    }
}
