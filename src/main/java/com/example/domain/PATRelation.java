package com.example.domain;

import java.util.List;

public class PATRelation {
    /**
     * 患者联系人关系代码
     */
    private String PATRelationCode;
    /**
     * 患者联系人关系描述
     */
    private String PATRelationDesc;
    /**
     * 患者联系人姓名
     */
    private String PATRelationName;
    /**
     * 患者联系人电话
     */
    private String PATRelationPhone;

    /**
     * 患者联系人地址集合
     */
    private List<ConsAddress> IcAddress;


    public String getPATRelationCode() {
        return PATRelationCode;
    }

    public void setPATRelationCode(String PATRelationCode) {
        this.PATRelationCode = PATRelationCode;
    }

    public String getPATRelationDesc() {
        return PATRelationDesc;
    }

    public void setPATRelationDesc(String PATRelationDesc) {
        this.PATRelationDesc = PATRelationDesc;
    }

    public String getPATRelationName() {
        return PATRelationName;
    }

    public void setPATRelationName(String PATRelationName) {
        this.PATRelationName = PATRelationName;
    }

    public String getPATRelationPhone() {
        return PATRelationPhone;
    }

    public void setPATRelationPhone(String PATRelationPhone) {
        this.PATRelationPhone = PATRelationPhone;
    }

    public List<ConsAddress> getIcAddress() {
        return IcAddress;
    }

    public void setIcAddress(List<ConsAddress> icAddress) {
        IcAddress = icAddress;
    }
}
