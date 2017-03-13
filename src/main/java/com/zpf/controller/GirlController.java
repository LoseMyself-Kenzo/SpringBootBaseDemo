package com.zpf.controller;

import com.zpf.dto.girl;
import com.zpf.dto.girlRepository;
import com.zpf.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by LoseMyself
 * on 2017/3/13   13:46
 */
@RestController
public class GirlController {

    @Autowired
    private girlRepository girlRepository;
    @Autowired
    private GirlService girlService;


    // 查询女生列表
    @GetMapping(value= "/girls")
    public List<girl> girls(){
        return girlRepository.findAll();
    }

    // 新增女生列表
    @PostMapping(value = "/girls")
    public girl girlAdd(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Long age){
        girl girl = new girl().setAge(age).setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    // 查询指定id的女生
    @GetMapping(value= "/girls/{id}")
    public girl girlFindOne(@PathVariable("id") Long id){
        return girlRepository.findOne(id);
    }

    //更新
    @PutMapping(value= "/girls/{id}")
    public girl update(@PathVariable("id") Long id,
                       @RequestParam("cupSize") String cupSize,
                       @RequestParam("age") Long age
    ){
        girl girl = new girl().setId(id).setCupSize(cupSize).setAge(age);
        return girlRepository.save(girl);
    }
    // 删除
    @DeleteMapping(value= "/girls/{id}")
    public void delete(@PathVariable("id") Long id){
        girlRepository.delete(id);
    }

    //通过年龄查询女生列表
    @GetMapping(value = "/girls/age/{age}")
    public List<girl> girls(@PathVariable("age") Long age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "girls/add")
    public void addTwo(){
        girlService.insertTwo();
    }
 }
