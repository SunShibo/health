package com.example.dao;

import com.example.domain.Project;
import com.example.receive.CT_PE_OrderDetailRelate;
import com.example.receive.ItemDetail;

import java.util.List;

public interface ProjectDao {


    int insertProject(CT_PE_OrderDetailRelate p);

    int insertRelation(ItemDetail p);

    List<Project> getProjectRelation();
}
