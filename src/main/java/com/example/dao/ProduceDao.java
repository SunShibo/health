package com.example.dao;

import com.example.domain.sub.PRDAssociationINFO;
import com.example.domain.sub.PRDOeoriTar;
import com.example.domain.sub.Product;
import com.example.domain.sub.ProductPackage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProduceDao {

    void insertProduce(ProductPackage p);

    void insertProduceInfo(PRDAssociationINFO p);

    void insertProduceProject(PRDOeoriTar p);

    List<Product> queryProduct(@Param("hospitalCode") String hospitalCode);

}
