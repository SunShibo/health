package com.example.receive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Body")
@XmlAccessorType(XmlAccessType.NONE)
public class OrderDetailBody {

    @XmlElement(name = "CT_PE_OrderDetailRelate")
    private CT_PE_OrderDetailRelate ct_pe_orderDetailRelate;



    public CT_PE_OrderDetailRelate getCt_pe_orderDetailRelate() {
        return ct_pe_orderDetailRelate;
    }

    public void setCt_pe_orderDetailRelate(CT_PE_OrderDetailRelate ct_pe_orderDetailRelate) {
        this.ct_pe_orderDetailRelate = ct_pe_orderDetailRelate;
    }
}
