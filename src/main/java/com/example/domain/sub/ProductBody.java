package com.example.domain.sub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Body")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductBody {
    @XmlElement(name = "ProductPackageRt")
    private ProductPackage ProductPackageRt;


    public ProductPackage getProductPackageRt() {
        return ProductPackageRt;
    }

    public void setProductPackageRt(ProductPackage productPackageRt) {
        ProductPackageRt = productPackageRt;
    }


}
