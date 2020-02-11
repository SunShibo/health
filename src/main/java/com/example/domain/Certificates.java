package com.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * (Certificate)实体类
 *
 * @author makejava
 * @since 2020-02-11 19:52:07
 */
@XmlRootElement(name = "PATIdentity")
@XmlAccessorType(XmlAccessType.FIELD)
public class Certificates implements Serializable {
    /**
    * 患者证件信息
    */
    private Long id;
    /**
    * 患者id
    */
    private Long patid;
    /**
    * 患者证件号码
    */
    @XmlElement(name = "PATIdentityNum")
    private String patidentitynum;
    /**
    * 患者证件类别代码
    */
    @XmlElement(name = "PATIdTypeCode")
    private String patidtypecode;
    /**
    * 患者证件类别描述
    */
    @XmlElement(name = "PATIdTypeDesc")
    private String patidtypedesc;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatid() {
        return patid;
    }

    public void setPatid(Long patid) {
        this.patid = patid;
    }

    public String getPatidentitynum() {
        return patidentitynum;
    }

    public void setPatidentitynum(String patidentitynum) {
        this.patidentitynum = patidentitynum;
    }

    public String getPatidtypecode() {
        return patidtypecode;
    }

    public void setPatidtypecode(String patidtypecode) {
        this.patidtypecode = patidtypecode;
    }

    public String getPatidtypedesc() {
        return patidtypedesc;
    }

    public void setPatidtypedesc(String patidtypedesc) {
        this.patidtypedesc = patidtypedesc;
    }

}