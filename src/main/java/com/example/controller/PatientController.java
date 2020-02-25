package com.example.controller;


import com.alibaba.druid.util.StringUtils;
import com.example.domain.JsonResponse;
import com.example.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * 患者
 * */
@RestController
public class PatientController {

    @Autowired
    PatientService patientService;
    /**
     * 查询患者信息 2020/0225
     */

    @PostMapping("/patient/queryPatient")
    public JsonResponse queryPatient(@RequestBody Map request) throws Exception {
        String HospitalCode = request.get("HospitalCode").toString();
        String PATPatientID = request.get("PATPatientID").toString();
        String PATTelephone = request.get("PATTelephone").toString();
        String PATIdentityNum = request.get("PATIdentityNum").toString();
        if(StringUtils.isEmpty(HospitalCode) ){
            return  JsonResponse.fail("参数异常");
        }
        if(StringUtils.isEmpty(PATPatientID)&&StringUtils.isEmpty(PATIdentityNum) ){
            return  JsonResponse.fail("参数异常");
        }

        return  new JsonResponse(patientService.queryPatient(HospitalCode,PATPatientID,PATTelephone,PATIdentityNum));
    }

}
