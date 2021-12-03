package com.zgs.es.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

/**
 * @author zgs
 * @date 2021年12月02日 15:32:00
 */
@Slf4j
public class EsTest_Index_Search {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder
                (new HttpHost("localhost",9200,"http")));

        //查询索引
        GetIndexRequest request = new GetIndexRequest("zgs");
        GetIndexResponse response = client.indices().get(request, RequestOptions.DEFAULT);
        log.info("#########################"+response.getAliases());
        log.info("#########################"+response.getDataStreams());
        log.info("#########################"+response.getMappings());
        log.info("#########################"+response.getSettings());
        client.close();
    }
}
