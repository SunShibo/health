package com.example.controller;


import com.alibaba.druid.util.StringUtils;
import com.example.domain.JsonResponse;
import com.example.service.DoctorsService;
import com.example.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;


/**
 * 患者
 * */
@RestController
public class PatientController {

    @Autowired
    PatientService patientService;
    @Autowired
    private DoctorsService doctorsService;
    /**
     * 查询患者信息 2020/0225
     */

    @PostMapping("/patient/queryPatient")
    public JsonResponse queryPatient(@RequestBody Map<String,String> request) throws Exception {
        String HospitalCode = request.get("HospitalCode");
        String PATPatientID = request.get("PATPatientID");
        String PATTelephone = request.get("PATTelephone");
        String PATIdentityNum = request.get("PATIdentityNum").toString();
        if(StringUtils.isEmpty(HospitalCode) ){
            return  JsonResponse.fail("参数异常");
        }
        if(StringUtils.isEmpty(PATPatientID)&&StringUtils.isEmpty(PATIdentityNum) ){
            return  JsonResponse.fail("参数异常");
        }

        return  new JsonResponse(patientService.queryPatient(HospitalCode,PATPatientID,PATTelephone,PATIdentityNum));
    }


    /**
     * 健康医嘱
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/physical/medical")
    public JsonResponse medical(@RequestBody Map<String,String> request) throws Exception {
        String PATPatientID = request.get("PATPatientID"); //患者id
        String HospitalCode = request.get("HospitalCode"); //医院编码
        String MedExamNumber = request.get("MedExamNumber"); //体检编码
        if(StringUtils.isEmpty(PATPatientID) || StringUtils.isEmpty(HospitalCode) ){
            return  JsonResponse.fail("参数异常");
        }
        return  new JsonResponse(doctorsService.queryDoctor(PATPatientID,HospitalCode,MedExamNumber));
    }

}
