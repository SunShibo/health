package com.example.dao;

import com.example.domain.Certificate;
import com.example.domain.Certificates;

/**
 * (Certificate)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-11 21:41:26
 */
public interface CertificateDao {


    /**
     * 新增数据
     *
     * @param certificate 实例对象
     * @return 影响行数
     */
    int insert(Certificates certificate);


}