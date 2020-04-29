package com.example.domain.sub;

import java.io.Serializable;

/**
 * (ProductRelationProject)实体类
 *
 * @author makejava
 * @since 2020-04-29 11:28:11
 */
public class ProductRelationProject implements Serializable {
    private static final long serialVersionUID = -68093022791940811L;

    
    private String oeoritarid;
    /**
    * 数量
    */
    private String oeoritarquantity;
    /**
    * 项目名称
    */
    private String oeoritarcode;
    /**
    * 项目代码
    */
    private String oeoritardesc;
    /**
    * 项目价格
    */
    private String oeoritarprice;
    /**
    * 优惠价格
    */
    private String oeoritarintraprince;


    public String getOeoritarid() {
        return oeoritarid;
    }

    public void setOeoritarid(String oeoritarid) {
        this.oeoritarid = oeoritarid;
    }

    public String getOeoritarquantity() {
        return oeoritarquantity;
    }

    public void setOeoritarquantity(String oeoritarquantity) {
        this.oeoritarquantity = oeoritarquantity;
    }

    public String getOeoritarcode() {
        return oeoritarcode;
    }

    public void setOeoritarcode(String oeoritarcode) {
        this.oeoritarcode = oeoritarcode;
    }

    public String getOeoritardesc() {
        return oeoritardesc;
    }

    public void setOeoritardesc(String oeoritardesc) {
        this.oeoritardesc = oeoritardesc;
    }

    public String getOeoritarprice() {
        return oeoritarprice;
    }

    public void setOeoritarprice(String oeoritarprice) {
        this.oeoritarprice = oeoritarprice;
    }

    public String getOeoritarintraprince() {
        return oeoritarintraprince;
    }

    public void setOeoritarintraprince(String oeoritarintraprince) {
        this.oeoritarintraprince = oeoritarintraprince;
    }

}