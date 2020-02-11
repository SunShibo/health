package com.example.dao;


import com.example.domain.Patient;

/**
 * (Patient)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-11 20:52:20
 */
public interface PatientDao {


    /**
     * 新增数据
     *
     * @param patient 实例对象
     * @return 影响行数
     */
    int insert(Patient patient);

}