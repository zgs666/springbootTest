package com.zgs.es.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author zgs
 * @date 2021年12月02日 17:28:00
 */
@Slf4j
public class EsTest_Doc_Update {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        UpdateRequest request = new UpdateRequest();
        request.index("zgs").id("1001");
        request.doc(XContentType.JSON,"name","张帅11");
        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
        log.info("###########################"+response.getGetResult());
        client.close();
    }
}
