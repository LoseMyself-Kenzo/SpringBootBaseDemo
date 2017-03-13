package com.zpf.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by LoseMyself
 * on 2017/3/13   10:00
 */
// 获取properties内对应节点名称
@ConfigurationProperties(prefix = "girl")
// 能直接Autowire注解需加上这个
@Component
public class girlProperties {
    private String cupSize;

    private Integer age;

    public String getCupSize() {
        return cupSize;
    }

    public girlProperties setCupSize(String cupSize) {
        this.cupSize = cupSize;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public girlProperties setAge(Integer age) {
        this.age = age;
        return this;
    }
}
