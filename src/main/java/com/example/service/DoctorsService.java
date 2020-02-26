package com.example.service;

import com.example.dao.DoctorsDao;
import com.example.domain.Header;
import com.example.domain.Response;
import com.example.domain.ResponseBuild;
import com.example.domain.SBody;
import com.example.receive.Doctor;
import com.example.receive.Request;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wang bin
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DoctorsService {

    @Resource
    private DoctorsDao doctorsDao;

    public String insertDoctor(Request request){
        int inert = doctorsDao.inert(request.getHeader().getSourceSystem(), request.getHeader().getMessageID(),
                request.getBody().getMSMessageRt().getHospitalCode(), request.getBody().getMSMessageRt().getPATPatientID(),
                request.getBody().getMSMessageRt().getMedExamNumber(), request.getBody().getMSMessageRt().getRecordDate(),
                request.getBody().getMSMessageRt().getOEORIOrderItemID(), request.getBody().getMSMessageRt().getOEORIARCItmMastDesc(),
                request.getBody().getMSMessageRt().getTriggerFlag());

        return  ResponseBuild.success();
    }


     public List<Doctor> queryDoctor(String  patpatientID, String hospitalCode, String medExamNumber){
         return  doctorsDao.queryDoctor(patpatientID,hospitalCode,medExamNumber);
     }
}
