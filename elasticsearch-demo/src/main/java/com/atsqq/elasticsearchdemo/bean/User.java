package com.atsqq.elasticsearchdemo.bean;

import com.sun.tracing.dtrace.ArgsAttributes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
@Document(indexName = "user",type = "info",shards = 3,replicas = 1)
@Data
//声明无参构造器
@NoArgsConstructor
//全参构造
@AllArgsConstructor
public class User {
    //主键更具主键id查询数据
    @Id
    private Long id;
    //type对应索引库中的数据类型
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String name;
    @Field(type = FieldType.Integer)
    private Integer age;
    @Field(type = FieldType.Keyword,index = false)
    private String password;
}
