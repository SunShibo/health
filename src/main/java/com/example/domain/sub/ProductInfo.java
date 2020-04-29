package com.example.domain.sub;

import java.io.Serializable;
import java.util.List;

/**
 * (ProductInfo)实体类
 *
 * @author makejava
 * @since 2020-04-29 11:27:58
 */
public class ProductInfo implements Serializable {
    private static final long serialVersionUID = -18738083711741669L;

    /**
    * 产品编码
    */
    private String assproductid;
    /**
    * 数量
    */
    private String assquantity;
    /**
    * 计价单位代码
    */
    private String assuomcode;
    /**
    * 计价单位名称
    */
    private String assuomcodedesc;
    /**
    * 必需产品
    */
    private String assisrequired;
    /**
    * 套餐内价格
    */
    private String assintraprice;

    /**
     * 收费项目关联
     */
    private List<ProductRelationProject> tarList;
    public String getAssproductid() {
        return assproductid;
    }

    public void setAssproductid(String assproductid) {
        this.assproductid = assproductid;
    }

    public String getAssquantity() {
        return assquantity;
    }

    public void setAssquantity(String assquantity) {
        this.assquantity = assquantity;
    }

    public String getAssuomcode() {
        return assuomcode;
    }

    public void setAssuomcode(String assuomcode) {
        this.assuomcode = assuomcode;
    }

    public String getAssuomcodedesc() {
        return assuomcodedesc;
    }

    public void setAssuomcodedesc(String assuomcodedesc) {
        this.assuomcodedesc = assuomcodedesc;
    }

    public String getAssisrequired() {
        return assisrequired;
    }

    public void setAssisrequired(String assisrequired) {
        this.assisrequired = assisrequired;
    }

    public String getAssintraprice() {
        return assintraprice;
    }

    public void setAssintraprice(String assintraprice) {
        this.assintraprice = assintraprice;
    }


    public List<ProductRelationProject> getTarList() {
        return tarList;
    }

    public void setTarList(List<ProductRelationProject> tarList) {
        this.tarList = tarList;
    }
}