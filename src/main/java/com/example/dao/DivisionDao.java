package com.example.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by wang bin
 */
public interface DivisionDao {

    int insert(@Param("SourceSystem")String SourceSystem, @Param("MessageID")String MessageID,
               @Param("CTD_Code")String CTD_Code,@Param("CTD_Desc")String CTD_Desc,
               @Param("CTD_CategoryCode")String CTD_CategoryCode, @Param("CTD_Phonetic")String CTD_Phonetic,
               @Param("CTD_WardFlag")String CTD_WardFlag, @Param("BusinessFieldCode")String BusinessFieldCode,
               @Param("CTD_CreatDate")String CTD_CreatDate, @Param("CTD_CreatTime")String CTD_CreatTime,
               @Param("CTD_UpdateDate")String CTD_UpdateDate, @Param("CTD_UpdateTime")String CTD_UpdateTime,
               @Param("CTD_OriginalCode")String CTD_OriginalCode, @Param("CTD_OriginalDesc")String CTD_OriginalDesc,
               @Param("CTD_Remarks")String CTD_Remarks, @Param("CTD_StartDate")String CTD_StartDate,
               @Param("CTD_EndDate")String CTD_EndDate, @Param("CTD_CodesystemCode")String CTD_CodesystemCode,
               @Param("CTD_OfficeAddress")String CTD_OfficeAddress, @Param("CTD_OfficePhone")String CTD_OfficePhone,
               @Param("CTD_UpdateUserCode")String CTD_UpdateUserCode, @Param("CTD_HosCode")String CTD_HosCode,
               @Param("CTD_DepartmentGroup")String CTD_DepartmentGroup, @Param("CTD_AdmType")String CTD_AdmType,
               @Param("CTD_ParentCode")String CTD_ParentCode, @Param("CTD_Status")String CTD_Status);


}
