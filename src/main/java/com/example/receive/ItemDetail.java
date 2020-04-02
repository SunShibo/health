package com.example.receive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ItemDetail")
@XmlAccessorType(XmlAccessType.NONE)
public class ItemDetail {

    private Long pId;
    @XmlElement(name = "ODR_ItemDetailCode")
    private String ODR_ItemDetailCode;
    @XmlElement(name = "ODR_ItemDetailDesc")
    private String ODR_ItemDetailDesc;
    @XmlElement(name = "ODR_Sequence")
    private String ODR_Sequence;
    @XmlElement(name = "ODR_Required")
    private String ODR_Required;


    public String getODR_ItemDetailCode() {
        return ODR_ItemDetailCode;
    }

    public void setODR_ItemDetailCode(String ODR_ItemDetailCode) {
        this.ODR_ItemDetailCode = ODR_ItemDetailCode;
    }

    public String getODR_ItemDetailDesc() {
        return ODR_ItemDetailDesc;
    }

    public void setODR_ItemDetailDesc(String ODR_ItemDetailDesc) {
        this.ODR_ItemDetailDesc = ODR_ItemDetailDesc;
    }

    public String getODR_Sequence() {
        return ODR_Sequence;
    }

    public void setODR_Sequence(String ODR_Sequence) {
        this.ODR_Sequence = ODR_Sequence;
    }

    public String getODR_Required() {
        return ODR_Required;
    }

    public void setODR_Required(String ODR_Required) {
        this.ODR_Required = ODR_Required;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }
}
