package com.zpf.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by LoseMyself
 * on 2017/3/13   13:38
 */
@Entity
public class girl {

    @Id
    @GeneratedValue
    private Long id;

    private String cupSize;

    private Long age;

    public girl(){

    }

    public Long getId() {
        return id;
    }

    public girl setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCupSize() {
        return cupSize;
    }

    public girl setCupSize(String cupSize) {
        this.cupSize = cupSize;
        return this;
    }

    public Long getAge() {
        return age;
    }

    public girl setAge(Long age) {
        this.age = age;
        return this;
    }
}
