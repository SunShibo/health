package com.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 患者地址
 */
@XmlRootElement(name = "PATAddress")
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

    private Long id; //id
    private Long patId;//患者id
    @XmlElement(name = "PATAddressType")
    private String PATAddressType;//地址类别代码
    @XmlElement(name = "PATAddressDesc")
    private String PATAddressDesc;//地址
    @XmlElement(name = "PATHouseNum")
    private String PATHouseNum;//地址-门牌号码
    @XmlElement(name = "PATVillage")
    private String PATVillage;//地址-村（街、路、弄等）
    @XmlElement(name = "PATCountryside")
    private String PATCountryside;//地址-乡（镇、街道办事处）
    @XmlElement(name = "PATCountyCode")
    private String PATCountyCode;//地址-县（区）代码
    @XmlElement(name = "PATCountyDesc")
    private String PATCountyDesc;//地址-县（区）描述
    @XmlElement(name = "PATCityCode")
    private String PATCityCode;//地址-市（地区）代码
    @XmlElement(name = "PATCityDesc")
    private String PATCityDesc;//地址-市（地区）代描述
    @XmlElement(name = "PATProvinceCode")
    private String PATProvinceCode;//地址-省（自治区、直辖市）代码
    @XmlElement(name = "PATProvinceDesc")
    private String PATProvinceDesc;//地址-省（自治区、直辖市）描述
    @XmlElement(name = "PATPostalCode")
    private String PATPostalCode;//地址邮政编码


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatId() {
        return patId;
    }

    public void setPatId(Long patId) {
        this.patId = patId;
    }

    public String getPATAddressType() {
        return PATAddressType;
    }

    public void setPATAddressType(String PATAddressType) {
        this.PATAddressType = PATAddressType;
    }

    public String getPATAddressDesc() {
        return PATAddressDesc;
    }

    public void setPATAddressDesc(String PATAddressDesc) {
        this.PATAddressDesc = PATAddressDesc;
    }

    public String getPATHouseNum() {
        return PATHouseNum;
    }

    public void setPATHouseNum(String PATHouseNum) {
        this.PATHouseNum = PATHouseNum;
    }

    public String getPATVillage() {
        return PATVillage;
    }

    public void setPATVillage(String PATVillage) {
        this.PATVillage = PATVillage;
    }

    public String getPATCountryside() {
        return PATCountryside;
    }

    public void setPATCountryside(String PATCountryside) {
        this.PATCountryside = PATCountryside;
    }

    public String getPATCountyCode() {
        return PATCountyCode;
    }

    public void setPATCountyCode(String PATCountyCode) {
        this.PATCountyCode = PATCountyCode;
    }

    public String getPATCountyDesc() {
        return PATCountyDesc;
    }

    public void setPATCountyDesc(String PATCountyDesc) {
        this.PATCountyDesc = PATCountyDesc;
    }

    public String getPATCityCode() {
        return PATCityCode;
    }

    public void setPATCityCode(String PATCityCode) {
        this.PATCityCode = PATCityCode;
    }

    public String getPATCityDesc() {
        return PATCityDesc;
    }

    public void setPATCityDesc(String PATCityDesc) {
        this.PATCityDesc = PATCityDesc;
    }

    public String getPATProvinceCode() {
        return PATProvinceCode;
    }

    public void setPATProvinceCode(String PATProvinceCode) {
        this.PATProvinceCode = PATProvinceCode;
    }

    public String getPATProvinceDesc() {
        return PATProvinceDesc;
    }

    public void setPATProvinceDesc(String PATProvinceDesc) {
        this.PATProvinceDesc = PATProvinceDesc;
    }

    public String getPATPostalCode() {
        return PATPostalCode;
    }

    public void setPATPostalCode(String PATPostalCode) {
        this.PATPostalCode = PATPostalCode;
    }
}
