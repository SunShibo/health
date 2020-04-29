package com.example.domain.sub;

import java.io.Serializable;
import java.util.List;

/**
 * (Product)实体类
 *
 * @author makejava
 * @since 2020-04-29 11:27:42
 */
public class Product implements Serializable {
    private static final long serialVersionUID = 830128422814354000L;

    /**
    * 产品编码
    */
    private String prdproductid;
    /**
    * 产品名称
    */
    private String prdname;
    /**
    * 产品通用名称
    */
    private String prdgenericname;
    /**
    * 产品别名
    */
    private String prdalias;
    /**
    * 计价单位代码
    */
    private String prddefaultuomcode;
    /**
    * 计价单位名称
    */
    private String prddefaultuomdesc;
    /**
    * 支持小数
    */
    private String prdquantitydecimal;
    /**
    * 是否可自主定价
    */
    private String prdindependentpricing;
    /**
    * 产品大类代码
    */
    private String prdcategorycode;
    /**
    * 产品大类名称
    */
    private String prdcategoryname;
    /**
    * 产品子类代码
    */
    private String prdsubcategorycode;
    /**
    * 产品子类名称
    */
    private String prdsubcategorydesc;
    /**
    * 规格
    */
    private String prdspecification;
    /**
    * 剂型
    */
    private String prddosageforms;
    /**
    * 套餐类型  5：体检套餐 10：月子套餐 15：会籍套餐
    */
    private String prdpackagetype;
    /**
    * 套餐概要
    */
    private String prdpackagebrief;
    /**
    * 套餐适用性别   5：男  6:女 10：女已婚 15：女未婚 20：通用
    */
    private String prdpackagesex;
    /**
    * 适用范围  5：个人  10：团体 15：团体活动
    */
    private String prdpackagerange;
    /**
    * 标签描述
    */
    private String prdpackagelabelname;
    /**
    * 用法
    */
    private String prdusage;
    /**
    * 所属医院代码
    */
    private String prdbusinessunitcode;
    /**
    * 所属医院名称
    */
    private String prdbusinessunitdesc;
    /**
    * 价格，原价
    */
    private String prdprice;
    /**
    * 结算价格，售价    体检套餐使用
    */
    private String strikeprice;
    /**
    * 状态 可用：0   停用：1    停售：2
    */
    private String prdstatus;
    /**
    * 所属级别 科级：5    院级：10   集团级：15
    */
    private String prdownlevel;
    /**
    * 部门代码 主数据代码
    */
    private String prddeptcode;
    /**
    * 部门名称
    */
    private String prddeptdesc;
    /**
    * 套餐等级 5:普通;10:VIP
    */
    private String prdproductlevel;
    /**
    * 是否单独售卖  1:单独售卖；0：非单独售卖
    */
    private String prdissellseparately;
    /**
    * 说明
    */
    private String prddescription;
    /**
    * 请求系统
    */
    private String sourcesystem;
    /**
    * 消息id
    */
    private String messageid;

    /**
     * 产品详情
     */
    private List<ProductInfo> ProductInfo;


    public String getPrdproductid() {
        return prdproductid;
    }

    public void setPrdproductid(String prdproductid) {
        this.prdproductid = prdproductid;
    }

    public String getPrdname() {
        return prdname;
    }

    public void setPrdname(String prdname) {
        this.prdname = prdname;
    }

    public String getPrdgenericname() {
        return prdgenericname;
    }

    public void setPrdgenericname(String prdgenericname) {
        this.prdgenericname = prdgenericname;
    }

    public String getPrdalias() {
        return prdalias;
    }

    public void setPrdalias(String prdalias) {
        this.prdalias = prdalias;
    }

    public String getPrddefaultuomcode() {
        return prddefaultuomcode;
    }

    public void setPrddefaultuomcode(String prddefaultuomcode) {
        this.prddefaultuomcode = prddefaultuomcode;
    }

    public String getPrddefaultuomdesc() {
        return prddefaultuomdesc;
    }

    public void setPrddefaultuomdesc(String prddefaultuomdesc) {
        this.prddefaultuomdesc = prddefaultuomdesc;
    }

    public String getPrdquantitydecimal() {
        return prdquantitydecimal;
    }

    public void setPrdquantitydecimal(String prdquantitydecimal) {
        this.prdquantitydecimal = prdquantitydecimal;
    }

    public String getPrdindependentpricing() {
        return prdindependentpricing;
    }

    public void setPrdindependentpricing(String prdindependentpricing) {
        this.prdindependentpricing = prdindependentpricing;
    }

    public String getPrdcategorycode() {
        return prdcategorycode;
    }

    public void setPrdcategorycode(String prdcategorycode) {
        this.prdcategorycode = prdcategorycode;
    }

    public String getPrdcategoryname() {
        return prdcategoryname;
    }

    public void setPrdcategoryname(String prdcategoryname) {
        this.prdcategoryname = prdcategoryname;
    }

    public String getPrdsubcategorycode() {
        return prdsubcategorycode;
    }

    public void setPrdsubcategorycode(String prdsubcategorycode) {
        this.prdsubcategorycode = prdsubcategorycode;
    }

    public String getPrdsubcategorydesc() {
        return prdsubcategorydesc;
    }

    public void setPrdsubcategorydesc(String prdsubcategorydesc) {
        this.prdsubcategorydesc = prdsubcategorydesc;
    }

    public String getPrdspecification() {
        return prdspecification;
    }

    public void setPrdspecification(String prdspecification) {
        this.prdspecification = prdspecification;
    }

    public String getPrddosageforms() {
        return prddosageforms;
    }

    public void setPrddosageforms(String prddosageforms) {
        this.prddosageforms = prddosageforms;
    }

    public String getPrdpackagetype() {
        return prdpackagetype;
    }

    public void setPrdpackagetype(String prdpackagetype) {
        this.prdpackagetype = prdpackagetype;
    }

    public String getPrdpackagebrief() {
        return prdpackagebrief;
    }

    public void setPrdpackagebrief(String prdpackagebrief) {
        this.prdpackagebrief = prdpackagebrief;
    }

    public String getPrdpackagesex() {
        return prdpackagesex;
    }

    public void setPrdpackagesex(String prdpackagesex) {
        this.prdpackagesex = prdpackagesex;
    }

    public String getPrdpackagerange() {
        return prdpackagerange;
    }

    public void setPrdpackagerange(String prdpackagerange) {
        this.prdpackagerange = prdpackagerange;
    }

    public String getPrdpackagelabelname() {
        return prdpackagelabelname;
    }

    public void setPrdpackagelabelname(String prdpackagelabelname) {
        this.prdpackagelabelname = prdpackagelabelname;
    }

    public String getPrdusage() {
        return prdusage;
    }

    public void setPrdusage(String prdusage) {
        this.prdusage = prdusage;
    }

    public String getPrdbusinessunitcode() {
        return prdbusinessunitcode;
    }

    public void setPrdbusinessunitcode(String prdbusinessunitcode) {
        this.prdbusinessunitcode = prdbusinessunitcode;
    }

    public String getPrdbusinessunitdesc() {
        return prdbusinessunitdesc;
    }

    public void setPrdbusinessunitdesc(String prdbusinessunitdesc) {
        this.prdbusinessunitdesc = prdbusinessunitdesc;
    }

    public String getPrdprice() {
        return prdprice;
    }

    public void setPrdprice(String prdprice) {
        this.prdprice = prdprice;
    }

    public String getStrikeprice() {
        return strikeprice;
    }

    public void setStrikeprice(String strikeprice) {
        this.strikeprice = strikeprice;
    }

    public String getPrdstatus() {
        return prdstatus;
    }

    public void setPrdstatus(String prdstatus) {
        this.prdstatus = prdstatus;
    }

    public String getPrdownlevel() {
        return prdownlevel;
    }

    public void setPrdownlevel(String prdownlevel) {
        this.prdownlevel = prdownlevel;
    }

    public String getPrddeptcode() {
        return prddeptcode;
    }

    public void setPrddeptcode(String prddeptcode) {
        this.prddeptcode = prddeptcode;
    }

    public String getPrddeptdesc() {
        return prddeptdesc;
    }

    public void setPrddeptdesc(String prddeptdesc) {
        this.prddeptdesc = prddeptdesc;
    }

    public String getPrdproductlevel() {
        return prdproductlevel;
    }

    public void setPrdproductlevel(String prdproductlevel) {
        this.prdproductlevel = prdproductlevel;
    }

    public String getPrdissellseparately() {
        return prdissellseparately;
    }

    public void setPrdissellseparately(String prdissellseparately) {
        this.prdissellseparately = prdissellseparately;
    }

    public String getPrddescription() {
        return prddescription;
    }

    public void setPrddescription(String prddescription) {
        this.prddescription = prddescription;
    }

    public String getSourcesystem() {
        return sourcesystem;
    }

    public void setSourcesystem(String sourcesystem) {
        this.sourcesystem = sourcesystem;
    }

    public String getMessageid() {
        return messageid;
    }

    public void setMessageid(String messageid) {
        this.messageid = messageid;
    }

    public List<com.example.domain.sub.ProductInfo> getProductInfo() {
        return ProductInfo;
    }

    public void setProductInfo(List<com.example.domain.sub.ProductInfo> productInfo) {
        ProductInfo = productInfo;
    }
}