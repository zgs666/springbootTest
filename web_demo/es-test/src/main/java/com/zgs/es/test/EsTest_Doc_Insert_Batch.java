package com.zgs.es.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author zgs
 * @date 2021年12月02日 17:55:00
 */
@Slf4j
public class EsTest_Doc_Insert_Batch {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(new IndexRequest().index("zgs").id("1002").source(XContentType.JSON,"name","张帅1","age",20,"sex","男"));
        bulkRequest.add(new IndexRequest().index("zgs").id("1003").source(XContentType.JSON,"name","张帅2","age",21,"sex","女"));
        bulkRequest.add(new IndexRequest().index("zgs").id("1004").source(XContentType.JSON,"name","张帅3","age",22,"sex","男"));
        bulkRequest.add(new IndexRequest().index("zgs").id("1005").source(XContentType.JSON,"name","张帅4","age",23,"sex","男"));
        bulkRequest.add(new IndexRequest().index("zgs").id("1006").source(XContentType.JSON,"name","张帅5","age",24,"sex","女"));
        bulkRequest.add(new IndexRequest().index("zgs").id("1007").source(XContentType.JSON,"name","张帅6","age",25,"sex","男"));
        BulkResponse response = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        log.info("#########################"+response.getIngestTook());
        log.info("#########################"+response.getItems());
        client.close();
    }
}
