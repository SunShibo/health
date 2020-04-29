package com.example.domain.sub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PRDOeoriTar")
@XmlAccessorType(XmlAccessType.FIELD)
public class PRDOeoriTar {
    private Integer pId;
    @XmlElement(name = "OeoriTarId")
    private String OeoriTarId;  //项目id
    @XmlElement(name = "OeoriTarQuantity")
    private String OeoriTarQuantity;//数量
    @XmlElement(name = "OeoriTarCode")
    private String OeoriTarCode;//项目名称
    @XmlElement(name = "OeoriTarDesc")
    private String OeoriTarDesc;//项目代码
    @XmlElement(name = "OeoriTarPrice")
    private String OeoriTarPrice;//项目价格
    @XmlElement(name = "OeoriTarIntraPrince")
    private String OeoriTarIntraPrince;//优惠价格


    public String getOeoriTarId() {
        return OeoriTarId;
    }

    public void setOeoriTarId(String oeoriTarId) {
        OeoriTarId = oeoriTarId;
    }

    public String getOeoriTarQuantity() {
        return OeoriTarQuantity;
    }

    public void setOeoriTarQuantity(String oeoriTarQuantity) {
        OeoriTarQuantity = oeoriTarQuantity;
    }

    public String getOeoriTarCode() {
        return OeoriTarCode;
    }

    public void setOeoriTarCode(String oeoriTarCode) {
        OeoriTarCode = oeoriTarCode;
    }

    public String getOeoriTarDesc() {
        return OeoriTarDesc;
    }

    public void setOeoriTarDesc(String oeoriTarDesc) {
        OeoriTarDesc = oeoriTarDesc;
    }

    public String getOeoriTarPrice() {
        return OeoriTarPrice;
    }

    public void setOeoriTarPrice(String oeoriTarPrice) {
        OeoriTarPrice = oeoriTarPrice;
    }

    public String getOeoriTarIntraPrince() {
        return OeoriTarIntraPrince;
    }

    public void setOeoriTarIntraPrince(String oeoriTarIntraPrince) {
        OeoriTarIntraPrince = oeoriTarIntraPrince;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }
}
