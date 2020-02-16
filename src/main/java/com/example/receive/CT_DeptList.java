package com.example.receive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by wang bin
 */
@XmlRootElement(name="CT_DeptList")
@XmlAccessorType(XmlAccessType.NONE)
public class CT_DeptList {

    @XmlElement(name = "CT_Dept")
    private CT_Dept CT_Dept;

    public com.example.receive.CT_Dept getCT_Dept() {
        return CT_Dept;
    }

    public void setCT_Dept(com.example.receive.CT_Dept CT_Dept) {
        this.CT_Dept = CT_Dept;
    }
}
