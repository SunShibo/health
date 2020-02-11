package com.example.domain;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

/**
 * (Patient)实体类
 *
 * @author makejava
 * @since 2020-02-11 16:12:21
 */
@XmlRootElement(name="PATAddress")
@XmlAccessorType(XmlAccessType.FIELD)
public class Patient {

    @XmlElement(name = "PATAddressList")
    private PATAddressList PATAddressList;

    public com.example.domain.PATAddressList getPATAddressList() {
        return PATAddressList;
    }

    public void setPATAddressList(com.example.domain.PATAddressList PATAddressList) {
        this.PATAddressList = PATAddressList;
    }

    @XmlElement(name = "PATIdentityList")
    private Certificate certificate;

    @XmlElement(name = "PATRelationList")
    private PATRelationList patRelationList;

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public PATRelationList getPatRelationList() {
        return patRelationList;
    }

    public void setPatRelationList(PATRelationList patRelationList) {
        this.patRelationList = patRelationList;
    }

    /**
    * 患者信息
    */
    private Long id;
    /**
    * 消息来源
    */
    private String sourcesystem;
    /**
    * 消息ID
    */
    private String messageid;
    /**
    * 患者主索引
    */
    @XmlElement(name = "PATPatientID")
    private String patpatientid;
    /**
    * 患者姓名
    */

   @XmlElement(name = "PATPatientName")
    private String patpatientname;
    /**
    * 患者出生日期
    */
    @XmlElement(name = "PATDob")
    private Date patdob;
    /**
    * 年龄
    */
    @XmlElement(name = "PATAge")
    private String patage;
    /**
    * 患者性别代码
    */
    @XmlElement(name = "PATSexCode")
    private String patsexcode;
    /**
    * 患者性别描述
    */
    @XmlElement(name = "PATSexDesc")
    private String patsexdesc;
    /**
    * 患者婚姻状况代码
    */
    @XmlElement(name = "PATMaritalStatusCode")
    private String patmaritalstatuscode;
    /**
    * 患者婚姻状况描述
    */
    @XmlElement(name = "PATMaritalStatusDesc")
    private String patmaritalstatusdesc;
    /**
    * 患者民族代码
    */
    @XmlElement(name = "PATNationCode")
    private String patnationcode;
    /**
    * 患者民族描述
    */
    @XmlElement(name = "PATNationDesc")
    private String patnationdesc;
    /**
    * 患者国籍代码
    */
    @XmlElement(name = "PATCountryCode")
    private String patcountrycode;
    /**
    * 患者国籍描述
    */
    @XmlElement(name = "PATCountryDesc")
    private String patcountrydesc;
    /**
    * 患者死亡日期
    */
    @XmlElement(name = "PATDeceasedDate")
    private Date patdeceaseddate;
    /**
    * 患者死亡时间
    */
    @XmlElement(name = "PATDeceasedTime")
    private Date patdeceasedtime;
    /**
    * 患者健康卡号
    */
    @XmlElement(name = "PATHealthCardID")
    private String pathealthcardid;
    /**
    * 患者母亲ID
    */
    @XmlElement(name = "PATMotherID")
    private String patmotherid;
    /**
    * 患者职业代码
    */
    @XmlElement(name = "PATOccupationCode")
    private String patoccupationcode;
    /**
    * 患者职业描述
    */
    @XmlElement(name = "PATOccupationDesc")
    private String patoccupationdesc;
    /**
    * 患者工作单位名称
    */

    @XmlElement(name = "PATWorkPlaceName")
    private String patworkplacename;
    /**
    * 患者工作单位电话号码
    */
    @XmlElement(name = "PATWorkPlaceTelNum")
    private String patworkplacetelnum;
    /**
    * 患者联系电话
    */
    @XmlElement(name = "PATTelephone")
    private String pattelephone;
    /**
    * 患者备注
    */
    @XmlElement(name = "PATRemarks")
    private String patremarks;
    /**
    * 最后更新人编码
    */
    @XmlElement(name = "UpdateUserCode")
    private String updateusercode;
    /**
    * 最后更新人描述
    */
    @XmlElement(name = "UpdateUserDesc")
    private String updateuserdesc;
    /**
    * 最后更新日期
    */
    @XmlElement(name = "UpdateDate")
    private Date updatedate;
    /**
    * 最后更新时间
    */

    @XmlElement(name = "UpdateTime")
    private Date updatetime;
    /**
    * 业务域代码
    */
    @XmlElement(name = "BusinessFieldCode")
    private String businessfieldcode;
    /**
    * 医院编码
    */
    @XmlElement(name = "HospitalCode")
    private String hospitalcode;
    /**
    * 患者病案号
    */
    @XmlElement(name = "PATDocumentNo")
    private String patdocumentno;
    /**
    * 医院(现在只有一个未来对接多个医院）
    */
    private String hospital;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPatpatientid() {
        return patpatientid;
    }

    public void setPatpatientid(String patpatientid) {
        this.patpatientid = patpatientid;
    }

    public String getPatpatientname() {
        return patpatientname;
    }

    public void setPatpatientname(String patpatientname) {
        this.patpatientname = patpatientname;
    }

    public Date getPatdob() {
        return patdob;
    }

    public void setPatdob(Date patdob) {
        this.patdob = patdob;
    }

    public String getPatage() {
        return patage;
    }

    public void setPatage(String patage) {
        this.patage = patage;
    }

    public String getPatsexcode() {
        return patsexcode;
    }

    public void setPatsexcode(String patsexcode) {
        this.patsexcode = patsexcode;
    }

    public String getPatsexdesc() {
        return patsexdesc;
    }

    public void setPatsexdesc(String patsexdesc) {
        this.patsexdesc = patsexdesc;
    }

    public String getPatmaritalstatuscode() {
        return patmaritalstatuscode;
    }

    public void setPatmaritalstatuscode(String patmaritalstatuscode) {
        this.patmaritalstatuscode = patmaritalstatuscode;
    }

    public String getPatmaritalstatusdesc() {
        return patmaritalstatusdesc;
    }

    public void setPatmaritalstatusdesc(String patmaritalstatusdesc) {
        this.patmaritalstatusdesc = patmaritalstatusdesc;
    }

    public String getPatnationcode() {
        return patnationcode;
    }

    public void setPatnationcode(String patnationcode) {
        this.patnationcode = patnationcode;
    }

    public String getPatnationdesc() {
        return patnationdesc;
    }

    public void setPatnationdesc(String patnationdesc) {
        this.patnationdesc = patnationdesc;
    }

    public String getPatcountrycode() {
        return patcountrycode;
    }

    public void setPatcountrycode(String patcountrycode) {
        this.patcountrycode = patcountrycode;
    }

    public String getPatcountrydesc() {
        return patcountrydesc;
    }

    public void setPatcountrydesc(String patcountrydesc) {
        this.patcountrydesc = patcountrydesc;
    }

    public Date getPatdeceaseddate() {
        return patdeceaseddate;
    }

    public void setPatdeceaseddate(Date patdeceaseddate) {
        this.patdeceaseddate = patdeceaseddate;
    }

    public Date getPatdeceasedtime() {
        return patdeceasedtime;
    }

    public void setPatdeceasedtime(Date patdeceasedtime) {
        this.patdeceasedtime = patdeceasedtime;
    }

    public String getPathealthcardid() {
        return pathealthcardid;
    }

    public void setPathealthcardid(String pathealthcardid) {
        this.pathealthcardid = pathealthcardid;
    }

    public String getPatmotherid() {
        return patmotherid;
    }

    public void setPatmotherid(String patmotherid) {
        this.patmotherid = patmotherid;
    }

    public String getPatoccupationcode() {
        return patoccupationcode;
    }

    public void setPatoccupationcode(String patoccupationcode) {
        this.patoccupationcode = patoccupationcode;
    }

    public String getPatoccupationdesc() {
        return patoccupationdesc;
    }

    public void setPatoccupationdesc(String patoccupationdesc) {
        this.patoccupationdesc = patoccupationdesc;
    }

    public String getPatworkplacename() {
        return patworkplacename;
    }

    public void setPatworkplacename(String patworkplacename) {
        this.patworkplacename = patworkplacename;
    }

    public String getPatworkplacetelnum() {
        return patworkplacetelnum;
    }

    public void setPatworkplacetelnum(String patworkplacetelnum) {
        this.patworkplacetelnum = patworkplacetelnum;
    }

    public String getPattelephone() {
        return pattelephone;
    }

    public void setPattelephone(String pattelephone) {
        this.pattelephone = pattelephone;
    }

    public String getPatremarks() {
        return patremarks;
    }

    public void setPatremarks(String patremarks) {
        this.patremarks = patremarks;
    }

    public String getUpdateusercode() {
        return updateusercode;
    }

    public void setUpdateusercode(String updateusercode) {
        this.updateusercode = updateusercode;
    }

    public String getUpdateuserdesc() {
        return updateuserdesc;
    }

    public void setUpdateuserdesc(String updateuserdesc) {
        this.updateuserdesc = updateuserdesc;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Object getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getBusinessfieldcode() {
        return businessfieldcode;
    }

    public void setBusinessfieldcode(String businessfieldcode) {
        this.businessfieldcode = businessfieldcode;
    }

    public String getHospitalcode() {
        return hospitalcode;
    }

    public void setHospitalcode(String hospitalcode) {
        this.hospitalcode = hospitalcode;
    }

    public String getPatdocumentno() {
        return patdocumentno;
    }

    public void setPatdocumentno(String patdocumentno) {
        this.patdocumentno = patdocumentno;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
}