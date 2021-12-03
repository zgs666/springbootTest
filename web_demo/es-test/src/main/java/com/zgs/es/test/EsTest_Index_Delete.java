package com.zgs.es.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

/**
 * @author zgs
 * @date 2021年12月02日 15:41:00
 */
@Slf4j
public class EsTest_Index_Delete {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder
                (new HttpHost("localhost",9200,"http"))
        );
        //删除索引

        DeleteIndexRequest request = new DeleteIndexRequest("zgs1");
        AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
        log.info("#########################"+response.isAcknowledged());
        client.close();
    }
}
