package com.example.receive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="ItemDetailList")
@XmlAccessorType(XmlAccessType.NONE)
public class ItemDetailList {

    @XmlElement(name = "ItemDetail")
    private List<ItemDetail> itemDetail;


    public List<ItemDetail> getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(List<ItemDetail> itemDetail) {
        this.itemDetail = itemDetail;
    }
}
