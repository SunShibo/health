package com.example.dao;

import com.example.domain.Consequence;
import com.example.domain.Physical;
import com.example.domain.PhysicalConse;
import com.example.domain.Suggest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import java.util.List;

@Component
public interface PhysicalDAO {
    //获取所有体检记录
    //List<Physical> getPhysical();

    //删除体检记录***全部删除，后期逻辑肯定得变
    Integer delPhysical(Long PATPatientID);

    //增加体检记录
    Integer addPhysical(@Param("physicalList") List<Physical> physicalList);

    //删除体检建议
    Integer delSuggests(Long MedExamID);

    //增加体检建议
    Integer addSuggests(@Param("suggests") List<Suggest> suggests);

    //删除报告明细
    Integer delConsequence(Long MedExamID);

    //增加报告明细
    Integer addConsequence(@Param("consequences") List<Consequence> consequences);

    //删除报告明细
    Integer delPhysicalConse(Long conId);

    //增加报告明细
    Integer addPhysicalConse(@Param("physicalConseList") List<PhysicalConse> physicalConseList);
}
