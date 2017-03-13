package com.zpf.dto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by LoseMyself
 * on 2017/3/13   14:03
 */
// 对象类型,主键类型
public interface girlRepository extends JpaRepository<girl,Long> {

    public List<girl> findByAge(Long age);
}
