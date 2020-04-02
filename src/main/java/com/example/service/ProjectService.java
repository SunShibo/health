package com.example.service;

import com.example.dao.ProjectDao;
import com.example.domain.Project;
import com.example.domain.ResponseBuild;
import com.example.receive.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectService {


    @Resource
    private ProjectDao projectDao;

    public String insertProject(ProjectRequest request){
        if(request!=null){
            CT_PE_OrderDetailRelate project = request.getBody().getCt_pe_orderDetailRelate();
            project.setMessageID(request.getHeader().getMessageID());
            project.setSourceSystem(request.getHeader().getSourceSystem());
            projectDao.insertProject(project);
            if(project.getItemDetailList().getItemDetail()!=null && project.getItemDetailList().getItemDetail().size()>0){
                for(ItemDetail itemDetail:project.getItemDetailList().getItemDetail() ){
                    itemDetail.setpId(project.getId());
                    projectDao.insertRelation(itemDetail);
                }
            }

        }


        return  ResponseBuild.success();
    }


    public List<Project> getProjectRelation(){
        return  projectDao.getProjectRelation();
    }

}
