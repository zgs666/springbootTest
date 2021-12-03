package com.zgs.es.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author zgs
 * @date 2021年12月02日 17:40:00
 */
@Slf4j
public class EsTest_Doc_Delete {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        DeleteRequest request = new DeleteRequest();
        request.index("zgs").id("1001");
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        log.info("###########################"+response.toString());
        client.close();
    }
}
