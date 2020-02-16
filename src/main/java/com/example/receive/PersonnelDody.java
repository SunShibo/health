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
public class PersonnelDody {

    @XmlElement(name = "CT_CareProvList")
    private CT_CareProvList ct_careProvList;

    public CT_CareProvList getCt_careProvList() {
        return ct_careProvList;
    }

    public void setCt_careProvList(CT_CareProvList ct_careProvList) {
        this.ct_careProvList = ct_careProvList;
    }
}
