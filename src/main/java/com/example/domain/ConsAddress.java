package com.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PATRelation")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConsAddress {

    private Long id;
    private Long contsId;
    @XmlElement(name = "PATRelationAddressDesc")
    private String PATRelationAddressDesc; //患者联系人地址
    @XmlElement(name = "PATRelationHouseNum")
    private String PATRelationHouseNum; //患者联系人地址-门牌号码
    @XmlElement(name = "PATRelationVillage")
    private String PATRelationVillage; //患者联系人地址-村（街、路、弄等）
    @XmlElement(name = "PATRelationCountryside")
    private String PATRelationCountryside; //患者联系人地址-乡（镇、街道办事处）
    @XmlElement(name = "PATRelationCountyCode")
    private String PATRelationCountyCode; //患者联系人地址-县（区）代码
    @XmlElement(name = "PATRelationCountyDesc")
    private String PATRelationCountyDesc; //患者联系人地址-县（区）描述
    @XmlElement(name = "PATRelationCityCode")
    private String PATRelationCityCode; //患者联系人地址-市（地区）代码
    @XmlElement(name = "PATRelationCityDesc")
    private String PATRelationCityDesc; //患者联系人地址-市（地区）描述
    @XmlElement(name = "PATRelationProvinceCode")
    private String PATRelationProvinceCode; //患者联系人地址-省（自治区、直辖市）
    @XmlElement(name = "PATRelationProvinceDesc")
    private String PATRelationProvinceDesc; //患者联系人地址-省（自治区、直辖市）描述
    @XmlElement(name = "PATRelationPostalCode")
    private String PATRelationPostalCode; //患者联系人地址邮政编码


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContsId() {
        return contsId;
    }

    public void setContsId(Long contsId) {
        this.contsId = contsId;
    }

    public String getPATRelationAddressDesc() {
        return PATRelationAddressDesc;
    }

    public void setPATRelationAddressDesc(String PATRelationAddressDesc) {
        this.PATRelationAddressDesc = PATRelationAddressDesc;
    }

    public String getPATRelationHouseNum() {
        return PATRelationHouseNum;
    }

    public void setPATRelationHouseNum(String PATRelationHouseNum) {
        this.PATRelationHouseNum = PATRelationHouseNum;
    }

    public String getPATRelationVillage() {
        return PATRelationVillage;
    }

    public void setPATRelationVillage(String PATRelationVillage) {
        this.PATRelationVillage = PATRelationVillage;
    }

    public String getPATRelationCountryside() {
        return PATRelationCountryside;
    }

    public void setPATRelationCountryside(String PATRelationCountryside) {
        this.PATRelationCountryside = PATRelationCountryside;
    }

    public String getPATRelationCountyCode() {
        return PATRelationCountyCode;
    }

    public void setPATRelationCountyCode(String PATRelationCountyCode) {
        this.PATRelationCountyCode = PATRelationCountyCode;
    }

    public String getPATRelationCountyDesc() {
        return PATRelationCountyDesc;
    }

    public void setPATRelationCountyDesc(String PATRelationCountyDesc) {
        this.PATRelationCountyDesc = PATRelationCountyDesc;
    }

    public String getPATRelationCityCode() {
        return PATRelationCityCode;
    }

    public void setPATRelationCityCode(String PATRelationCityCode) {
        this.PATRelationCityCode = PATRelationCityCode;
    }

    public String getPATRelationCityDesc() {
        return PATRelationCityDesc;
    }

    public void setPATRelationCityDesc(String PATRelationCityDesc) {
        this.PATRelationCityDesc = PATRelationCityDesc;
    }

    public String getPATRelationProvinceDesc() {
        return PATRelationProvinceDesc;
    }

    public void setPATRelationProvinceDesc(String PATRelationProvinceDesc) {
        this.PATRelationProvinceDesc = PATRelationProvinceDesc;
    }

    public String getPATRelationPostalCode() {
        return PATRelationPostalCode;
    }

    public void setPATRelationPostalCode(String PATRelationPostalCode) {
        this.PATRelationPostalCode = PATRelationPostalCode;
    }

    public String getPATRelationProvinceCode() {
        return PATRelationProvinceCode;
    }

    public void setPATRelationProvinceCode(String PATRelationProvinceCode) {
        this.PATRelationProvinceCode = PATRelationProvinceCode;
    }
}
