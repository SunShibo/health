package com.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * (Contacts)实体类
 *
 * @author makejava
 * @since 2020-02-11 19:56:34
 */
@XmlRootElement(name = "PATRelation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Contacts implements Serializable {
    /**
    * 患者联系人
    */
    private Long id;
    /**
    * 患者id
    */
    private Long patid;
    /**
    * 患者联系人关系代码
    */
    @XmlElement(name="PATRelationCode")
    private String patrelationcode;
    /**
    * 患者联系人关系描述
    */
    @XmlElement(name="PATRelationDesc")
    private String patrelationdesc;
    /**
    * 患者联系人姓名
    */
    @XmlElement(name="PATRelationName")
    private String patrelationname;
    /**
    * 患者联系人电话
    */
    @XmlElement(name="PATRelationPhone")
    private String patrelationphone;

    @XmlElement(name = "PATRelationAddressList")
    private PATRelationAddressList  patRelationAddressList;

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

    public String getPatrelationcode() {
        return patrelationcode;
    }

    public void setPatrelationcode(String patrelationcode) {
        this.patrelationcode = patrelationcode;
    }

    public String getPatrelationdesc() {
        return patrelationdesc;
    }

    public void setPatrelationdesc(String patrelationdesc) {
        this.patrelationdesc = patrelationdesc;
    }

    public String getPatrelationname() {
        return patrelationname;
    }

    public void setPatrelationname(String patrelationname) {
        this.patrelationname = patrelationname;
    }

    public String getPatrelationphone() {
        return patrelationphone;
    }

    public void setPatrelationphone(String patrelationphone) {
        this.patrelationphone = patrelationphone;
    }

    public PATRelationAddressList getPatRelationAddressList() {
        return patRelationAddressList;
    }

    public void setPatRelationAddressList(PATRelationAddressList patRelationAddressList) {
        this.patRelationAddressList = patRelationAddressList;
    }
}