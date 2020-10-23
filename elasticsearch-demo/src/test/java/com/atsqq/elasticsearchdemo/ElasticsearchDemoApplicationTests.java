package com.atsqq.elasticsearchdemo;

import com.atsqq.elasticsearchdemo.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

@SpringBootTest
class ElasticsearchDemoApplicationTests {

    @Autowired
    ElasticsearchRestTemplate restTemplate;
    @Test
    void contextLoads() {
    }
    @Test
    void createIndex(){
        this.restTemplate.createIndex(User.class);
        this.restTemplate.putMapping(User.class);

//        restTemplate.
    }


}
