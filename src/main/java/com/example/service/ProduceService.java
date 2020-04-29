package com.example.service;

import com.example.dao.ProduceDao;
import com.example.domain.ResponseBuild;
import com.example.domain.sub.*;
import com.example.service.util.XmlUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProduceService {
    @Resource
    private ProduceDao produceDao;


    public String insProduce(ProductRequest request) {
        ProductPackage productPackageRt = request.getBody().getProductPackageRt();
        productPackageRt.setSourceSystem(request.getHeader().getSourceSystem());
        productPackageRt.setMessageID(request.getHeader().getMessageID());
        produceDao.insertProduce(productPackageRt);
        List<PRDAssociationINFO> prdAssociationInfo = productPackageRt.getPRDAssociationList().getPRDAssociationInfo();
        if (prdAssociationInfo != null && prdAssociationInfo.size() > 0) {
            for (PRDAssociationINFO info : prdAssociationInfo) {
                info.setpId(productPackageRt.getId());
                produceDao.insertProduceInfo(info);
                List<PRDOeoriTar> prdOeoriTarList = info.getPRDOeoriTarList();
                if (prdOeoriTarList != null && prdOeoriTarList.size() > 0) {
                    for (PRDOeoriTar project : prdOeoriTarList) {
                        project.setpId(info.getId());
                        produceDao.insertProduceProject(project);
                    }
                }
            }
        }

        return ResponseBuild.success();
    }


    public List<Product> queryProduct(String hospitalCode) {
       return produceDao.queryProduct(hospitalCode);
    }



}
