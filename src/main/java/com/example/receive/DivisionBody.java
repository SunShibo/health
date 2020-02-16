package com.example.receive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by wang bin
 */
@XmlRootElement(name="Body")
@XmlAccessorType(XmlAccessType.NONE)
public class DivisionBody {
    @XmlElement(name = "CT_DeptList")
    private CT_DeptList dT_DeptList;

    public CT_DeptList getdT_DeptList() {
        return dT_DeptList;
    }

    public void setdT_DeptList(CT_DeptList dT_DeptList) {
        this.dT_DeptList = dT_DeptList;
    }
}
