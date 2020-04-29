package com.example.domain.sub;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="PRDAssociationInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class PRDAssociationINFO {
    private Integer id;
    private Integer pId;
    @XmlElement(name = "AssProductID")
    private  String AssProductID; //产品编码
    @XmlElement(name = "AssQuantity")
    private  String AssQuantity; //数量
    @XmlElement(name = "AssUOMCode")
    private  String AssUOMCode; //计价单位代码
    @XmlElement(name = "AssUOMCodeDesc")
    private  String AssUOMCodeDesc; //计价单位名称
    @XmlElement(name = "AssIsRequired")
    private  String AssIsRequired; //必需产品
    @XmlElement(name = "AssIntraPrice")
    private  String AssIntraPrice; //套餐内价格

    @XmlElement(name = "PRDOeoriTarList")
    private List<PRDOeoriTar> PRDOeoriTarList;


    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getAssProductID() {
        return AssProductID;
    }

    public void setAssProductID(String assProductID) {
        AssProductID = assProductID;
    }

    public String getAssQuantity() {
        return AssQuantity;
    }

    public void setAssQuantity(String assQuantity) {
        AssQuantity = assQuantity;
    }

    public String getAssUOMCode() {
        return AssUOMCode;
    }

    public void setAssUOMCode(String assUOMCode) {
        AssUOMCode = assUOMCode;
    }

    public String getAssUOMCodeDesc() {
        return AssUOMCodeDesc;
    }

    public void setAssUOMCodeDesc(String assUOMCodeDesc) {
        AssUOMCodeDesc = assUOMCodeDesc;
    }

    public String getAssIsRequired() {
        return AssIsRequired;
    }

    public void setAssIsRequired(String assIsRequired) {
        AssIsRequired = assIsRequired;
    }

    public String getAssIntraPrice() {
        return AssIntraPrice;
    }

    public void setAssIntraPrice(String assIntraPrice) {
        AssIntraPrice = assIntraPrice;
    }

    public List<PRDOeoriTar> getPRDOeoriTarList() {
        return PRDOeoriTarList;
    }

    public void setPRDOeoriTarList(List<PRDOeoriTar> PRDOeoriTarList) {
        this.PRDOeoriTarList = PRDOeoriTarList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
