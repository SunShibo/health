package com.example.dao;

import com.example.domain.Contacts;


/**
 * (Contacts)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-11 21:41:52
 */
public interface ContactsDao {

    /**
     * 新增数据
     *
     * @param contacts 实例对象
     * @return 影响行数
     */
    int insert(Contacts contacts);


}