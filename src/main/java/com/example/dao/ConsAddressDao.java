package com.example.dao;

import com.example.domain.ConsAddress;




/**
 * (ConsAddress)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-11 21:41:31
 */
public interface ConsAddressDao {

    /**
     * 新增数据
     *
     * @param consAddress 实例对象
     * @return 影响行数
     */
    int insert(ConsAddress consAddress);

}