package com.example.dao;

import com.example.receive.PersonnelRequest;
import org.apache.ibatis.annotations.Param;

import javax.websocket.server.PathParam;

/**
 * Created by wang bin
 */
public interface PersonneDao {

    int insert(@Param("SourceSystem") String SourceSystem, @Param("MessageID")String MessageID,
               @Param("CTCP_Code")String CTCP_Code, @Param("CTCP_JobNumber")String CTCP_JobNumber,
               @Param("CTCP_Desc")String CTCP_Desc, @Param("CTCP_Name")String CTCP_Name,
               @Param("CTCP_Spell")String CTCP_Spell, @Param("CTCP_SexCode")String CTCP_SexCode,
               @Param("CTCP_BirthDate")String CTCP_BirthDate, @Param("CTCP_IDCardNO")String CTCP_IDCardNO,
               @Param("CTCP_TitleOfTechCode")String CTCP_TitleOfTechCode, @Param("CTCP_StaffTypeCode")String CTCP_StaffTypeCode,
               @Param("CTCP_CareProvPositionCode")String CTCP_CareProvPositionCode, @Param("CTCP_CareProvTypeCode")String CTCP_CareProvTypeCode,
               @Param("CTCP_DeptCode")String CTCP_DeptCode, @Param("CTCP_BirthPlace")String CTCP_BirthPlace,
               @Param("CTCP_CodesystemCode")String CTCP_CodesystemCode, @Param("CTCP_Remarks")String CTCP_Remarks,
               @Param("CTCP_ExtranetURL")String CTCP_ExtranetURL, @Param("CTCP_PassWord")String CTCP_PassWord,
               @Param("CTCP_UpdateUserCode")String CTCP_UpdateUserCode, @Param("CTCP_CreatDate")String CTCP_CreatDate,
               @Param("CTCP_CreatTime")String CTCP_CreatTime, @Param("BusinessFieldCode")String BusinessFieldCode,
               @Param("CTCP_OriginalCode")String CTCP_OriginalCode, @Param("CTCP_OriginalDesc")String CTCP_OriginalDesc,
               @Param("CTCP_StartDate")String CTCP_StartDate, @Param("CTCP_EndDate")String CTCP_EndDate,
               @Param("CTCP_HosCode")String CTCP_HosCode, @Param("CTCP_Status")String CTCP_Status);
}
