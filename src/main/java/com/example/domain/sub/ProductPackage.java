package com.example.domain.sub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="ProductPackageRt")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductPackage {
    private Integer id;
    @XmlElement(name = "PRDProductID")
    private String PRDProductID; //产品编码
    @XmlElement(name = "PRDName")
    private String PRDName; //产品名称
    @XmlElement(name = "PRDGenericName")
    private String PRDGenericName; //产品通用名称
    @XmlElement(name = "PRDAlias")
    private String PRDAlias;  //产品别名
    @XmlElement(name = "PRDDefaultUOMCode")
    private String PRDDefaultUOMCode; //计价单位代码
    @XmlElement(name = "PRDDefaultUOMDesc")
    private String PRDDefaultUOMDesc; //计价单位名称
    @XmlElement(name = "PRDQuantityDecimal")
    private String PRDQuantityDecimal; //支持小数
    @XmlElement(name = "PRDIndependentPricing")
    private String PRDIndependentPricing; //是否可自主定价
    @XmlElement(name = "PRDCategoryCode")
    private String PRDCategoryCode;  //产品大类代码
    @XmlElement(name = "PRDCategoryName")
    private String PRDCategoryName;  //产品大类名称
    @XmlElement(name = "PRDSubCategoryCode")
    private String PRDSubCategoryCode; //产品子类代码
    @XmlElement(name = "PRDSubCategoryDesc")
    private String PRDSubCategoryDesc; //产品子类名称
    @XmlElement(name = "PRDSpecification")
    private String PRDSpecification; //规格
    @XmlElement(name = "PRDDosageforms")
    private String PRDDosageforms; //剂型
    @XmlElement(name = "PRDPackageType")
    private String PRDPackageType; //套餐类型  5：体检套餐 10：月子套餐 15：会籍套餐
    @XmlElement(name = "PRDPackageBrief")
    private String PRDPackageBrief;//套餐概要
    @XmlElement(name = "PRDPackageSex")
    private String PRDPackageSex;//套餐适用性别   5：男  6:女 10：女已婚 15：女未婚 20：通用
    @XmlElement(name = "PRDPackageRange")
    private String PRDPackageRange;//适用范围  5：个人  10：团体 15：团体活动
    @XmlElement(name = "PRDPackageLabelName")
    private String PRDPackageLabelName;//标签描述
    @XmlElement(name = "PRDUsage")
    private String PRDUsage;//用法
    @XmlElement(name = "PRDBusinessUnitCode")
    private String PRDBusinessUnitCode; //所属医院代码
    @XmlElement(name = "PRDBusinessUnitDesc")
    private String PRDBusinessUnitDesc; //所属医院名称
    @XmlElement(name = "PRDPrice")
    private String PRDPrice; //价格，原价
    @XmlElement(name = "StrikePrice")
    private String StrikePrice; //结算价格，售价    体检套餐使用
    @XmlElement(name = "PRDStatus")
    private String PRDStatus; //状态 可用：0   停用：1    停售：2
    @XmlElement(name = "PRDOwnLevel")
    private String PRDOwnLevel;//所属级别 科级：5    院级：10   集团级：15
    @XmlElement(name = "PRDDeptCode")
    private String PRDDeptCode;//部门代码 主数据代码
    @XmlElement(name = "PRDDeptDesc")
    private String PRDDeptDesc;//部门名称
    @XmlElement(name = "PRDProductLevel")
    private String PRDProductLevel; //套餐等级 5:普通;10:VIP
    @XmlElement(name = "PRDIsSellSeparately")
    private String PRDIsSellSeparately; //是否单独售卖  1:单独售卖；0：非单独售卖
    @XmlElement(name = "PRDDescription")
    private String PRDDescription; //说明
    @XmlElement(name = "PRDAssociationList")
    private PRDAssociation PRDAssociationList;

    private String SourceSystem;


    private String MessageID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPRDProductID() {
        return PRDProductID;
    }

    public void setPRDProductID(String PRDProductID) {
        this.PRDProductID = PRDProductID;
    }

    public String getPRDName() {
        return PRDName;
    }

    public void setPRDName(String PRDName) {
        this.PRDName = PRDName;
    }

    public String getPRDGenericName() {
        return PRDGenericName;
    }

    public void setPRDGenericName(String PRDGenericName) {
        this.PRDGenericName = PRDGenericName;
    }

    public String getPRDAlias() {
        return PRDAlias;
    }

    public void setPRDAlias(String PRDAlias) {
        this.PRDAlias = PRDAlias;
    }

    public String getPRDDefaultUOMCode() {
        return PRDDefaultUOMCode;
    }

    public void setPRDDefaultUOMCode(String PRDDefaultUOMCode) {
        this.PRDDefaultUOMCode = PRDDefaultUOMCode;
    }

    public String getPRDDefaultUOMDesc() {
        return PRDDefaultUOMDesc;
    }

    public void setPRDDefaultUOMDesc(String PRDDefaultUOMDesc) {
        this.PRDDefaultUOMDesc = PRDDefaultUOMDesc;
    }

    public String getPRDQuantityDecimal() {
        return PRDQuantityDecimal;
    }

    public void setPRDQuantityDecimal(String PRDQuantityDecimal) {
        this.PRDQuantityDecimal = PRDQuantityDecimal;
    }

    public String getPRDIndependentPricing() {
        return PRDIndependentPricing;
    }

    public void setPRDIndependentPricing(String PRDIndependentPricing) {
        this.PRDIndependentPricing = PRDIndependentPricing;
    }

    public String getPRDCategoryCode() {
        return PRDCategoryCode;
    }

    public void setPRDCategoryCode(String PRDCategoryCode) {
        this.PRDCategoryCode = PRDCategoryCode;
    }

    public String getPRDCategoryName() {
        return PRDCategoryName;
    }

    public void setPRDCategoryName(String PRDCategoryName) {
        this.PRDCategoryName = PRDCategoryName;
    }

    public String getPRDSubCategoryCode() {
        return PRDSubCategoryCode;
    }

    public void setPRDSubCategoryCode(String PRDSubCategoryCode) {
        this.PRDSubCategoryCode = PRDSubCategoryCode;
    }

    public String getPRDSubCategoryDesc() {
        return PRDSubCategoryDesc;
    }

    public void setPRDSubCategoryDesc(String PRDSubCategoryDesc) {
        this.PRDSubCategoryDesc = PRDSubCategoryDesc;
    }

    public String getPRDSpecification() {
        return PRDSpecification;
    }

    public void setPRDSpecification(String PRDSpecification) {
        this.PRDSpecification = PRDSpecification;
    }

    public String getPRDDosageforms() {
        return PRDDosageforms;
    }

    public void setPRDDosageforms(String PRDDosageforms) {
        this.PRDDosageforms = PRDDosageforms;
    }

    public String getPRDPackageType() {
        return PRDPackageType;
    }

    public void setPRDPackageType(String PRDPackageType) {
        this.PRDPackageType = PRDPackageType;
    }

    public String getPRDPackageBrief() {
        return PRDPackageBrief;
    }

    public void setPRDPackageBrief(String PRDPackageBrief) {
        this.PRDPackageBrief = PRDPackageBrief;
    }

    public String getPRDPackageSex() {
        return PRDPackageSex;
    }

    public void setPRDPackageSex(String PRDPackageSex) {
        this.PRDPackageSex = PRDPackageSex;
    }

    public String getPRDPackageRange() {
        return PRDPackageRange;
    }

    public void setPRDPackageRange(String PRDPackageRange) {
        this.PRDPackageRange = PRDPackageRange;
    }

    public String getPRDPackageLabelName() {
        return PRDPackageLabelName;
    }

    public void setPRDPackageLabelName(String PRDPackageLabelName) {
        this.PRDPackageLabelName = PRDPackageLabelName;
    }

    public String getPRDUsage() {
        return PRDUsage;
    }

    public void setPRDUsage(String PRDUsage) {
        this.PRDUsage = PRDUsage;
    }

    public String getPRDBusinessUnitCode() {
        return PRDBusinessUnitCode;
    }

    public void setPRDBusinessUnitCode(String PRDBusinessUnitCode) {
        this.PRDBusinessUnitCode = PRDBusinessUnitCode;
    }

    public String getPRDBusinessUnitDesc() {
        return PRDBusinessUnitDesc;
    }

    public void setPRDBusinessUnitDesc(String PRDBusinessUnitDesc) {
        this.PRDBusinessUnitDesc = PRDBusinessUnitDesc;
    }

    public String getPRDPrice() {
        return PRDPrice;
    }

    public void setPRDPrice(String PRDPrice) {
        this.PRDPrice = PRDPrice;
    }

    public String getStrikePrice() {
        return StrikePrice;
    }

    public void setStrikePrice(String strikePrice) {
        StrikePrice = strikePrice;
    }

    public String getPRDStatus() {
        return PRDStatus;
    }

    public void setPRDStatus(String PRDStatus) {
        this.PRDStatus = PRDStatus;
    }

    public String getPRDOwnLevel() {
        return PRDOwnLevel;
    }

    public void setPRDOwnLevel(String PRDOwnLevel) {
        this.PRDOwnLevel = PRDOwnLevel;
    }

    public String getPRDDeptCode() {
        return PRDDeptCode;
    }

    public void setPRDDeptCode(String PRDDeptCode) {
        this.PRDDeptCode = PRDDeptCode;
    }

    public String getPRDDeptDesc() {
        return PRDDeptDesc;
    }

    public void setPRDDeptDesc(String PRDDeptDesc) {
        this.PRDDeptDesc = PRDDeptDesc;
    }

    public String getPRDProductLevel() {
        return PRDProductLevel;
    }

    public void setPRDProductLevel(String PRDProductLevel) {
        this.PRDProductLevel = PRDProductLevel;
    }

    public String getPRDIsSellSeparately() {
        return PRDIsSellSeparately;
    }

    public void setPRDIsSellSeparately(String PRDIsSellSeparately) {
        this.PRDIsSellSeparately = PRDIsSellSeparately;
    }

    public String getPRDDescription() {
        return PRDDescription;
    }

    public void setPRDDescription(String PRDDescription) {
        this.PRDDescription = PRDDescription;
    }

    public PRDAssociation getPRDAssociationList() {
        return PRDAssociationList;
    }

    public void setPRDAssociationList(PRDAssociation PRDAssociationList) {
        this.PRDAssociationList = PRDAssociationList;
    }

    public String getSourceSystem() {
        return SourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        SourceSystem = sourceSystem;
    }

    public String getMessageID() {
        return MessageID;
    }

    public void setMessageID(String messageID) {
        MessageID = messageID;
    }
}
