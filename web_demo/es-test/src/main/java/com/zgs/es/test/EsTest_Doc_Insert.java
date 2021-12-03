package com.zgs.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author zgs
 * @date 2021年12月02日 16:24:00
 */
@Slf4j
public class EsTest_Doc_Insert {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        IndexRequest request = new IndexRequest();
        request.index("zgs").id("1001");

        ZgsVo zgsVo = new ZgsVo();
        zgsVo.setName("张贵松");
        zgsVo.setAge(24);
        zgsVo.setSex("男");
        //转换为json
        ObjectMapper mappers = new ObjectMapper();
        String zgsJson = mappers.writeValueAsString(zgsVo);
        request.source(zgsJson, XContentType.JSON);

        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        log.info("########################"+response.getResult());
        client.close();
    }
}
