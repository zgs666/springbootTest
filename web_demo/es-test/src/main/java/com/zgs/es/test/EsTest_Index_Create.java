package com.zgs.es.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

/**
 * @author zgs
 * @date 2021年12月01日 18:01:00
 */
@Slf4j
public class EsTest_Index_Create {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );
        //创建索引
        CreateIndexRequest request = new CreateIndexRequest("zgs");
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        log.info("-----------"+response.toString());
        boolean acknowledged = response.isAcknowledged();
        System.out.println("acknowledged-------"+acknowledged);
        client.close();
    }
}
