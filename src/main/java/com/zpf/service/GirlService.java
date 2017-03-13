package com.zpf.service;

import com.zpf.dto.girl;
import com.zpf.dto.girlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LoseMyself
 * on 2017/3/13   14:42
 */
@Service
public class GirlService {

    @Autowired
    private girlRepository girlRepository;

    @Transactional
    public  void insertTwo(){
        girl girl1 = new girl().setAge(new Long(18)).setCupSize("A");
        girlRepository.save(girl1);

        girl girl2 = new girl().setAge(new Long(18)).setCupSize("B");
        girlRepository.save(girl2);
    }
}
