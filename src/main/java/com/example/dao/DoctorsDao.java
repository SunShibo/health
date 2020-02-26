package com.example.dao;

import com.example.domain.Request;
import com.example.receive.Doctor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wang bin
 */
public interface DoctorsDao {

    int inert(@Param("SourceSystem")String SourceSystem,@Param("MessageID")String MessageID,
              @Param("HospitalCode")String HospitalCode,@Param("PATPatientID")String PATPatientID,
              @Param("MedExamNumber")String MedExamNumber, @Param("RecordDate")String RecordDate,
              @Param("OEORIOrderItemID")String OEORIOrderItemID, @Param("OEORIARCItmMastDesc")String OEORIARCItmMastDesc,
              @Param("TriggerFlag")String TriggerFlag);

    List<Doctor> queryDoctor(@Param("patpatientID") String patpatientID,@Param("hospitalCode") String hospitalCode,@Param("medExamNumber") String medExamNumber);
}
