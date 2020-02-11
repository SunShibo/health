package com.example.dao;

import com.example.domain.Address;

/**
 * (Address)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-11 21:41:17
 */
public interface AddressDao {
    /**
     * 新增数据
     *
     * @param address 实例对象
     * @return 影响行数
     */
    int insert(Address address);

}