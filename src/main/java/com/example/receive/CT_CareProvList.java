package com.example.receive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by wang bin
 */
@XmlRootElement(name="CT_CareProvList")
@XmlAccessorType(XmlAccessType.NONE)
public class CT_CareProvList {

    @XmlElement(name = "CT_CareProv")
    private CT_CareProv ct_careProv;

    public CT_CareProv getCt_careProv() {
        return ct_careProv;
    }

    public void setCt_careProv(CT_CareProv ct_careProv) {
        this.ct_careProv = ct_careProv;
    }
}
