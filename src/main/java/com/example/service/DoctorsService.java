package com.example.service;

import com.example.dao.DoctorsDao;
import com.example.domain.Header;
import com.example.domain.Response;
import com.example.domain.SBody;
import com.example.receive.Request;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by wang bin
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DoctorsService {

    @Resource
    private DoctorsDao doctorsDao;

    public Response insertDoctor(Request request){
        int inert = doctorsDao.inert(request.getHeader().getSourceSystem(), request.getHeader().getMessageID(),
                request.getBody().getMSMessageRt().getHospitalCode(), request.getBody().getMSMessageRt().getPATPatientID(),
                request.getBody().getMSMessageRt().getMedExamNumber(), request.getBody().getMSMessageRt().getRecordDate(),
                request.getBody().getMSMessageRt().getOEORIOrderItemID(), request.getBody().getMSMessageRt().getOEORIARCItmMastDesc(),
                request.getBody().getMSMessageRt().getTriggerFlag());

        Response response = new Response();
        Header header = new Header();
        header.setMessageID( request.getHeader().getMessageID());
        header.setSourceSystem(request.getHeader().getSourceSystem());
        response.setHeader(header);
        if(inert > 0){
            SBody sBody = new SBody();
            sBody.setResultContent("成功");
            sBody.setResultCode("0");
            response.setBody(sBody);
            return response;
        }
        SBody sBody = new SBody();
        sBody.setResultContent("失败");
        sBody.setResultCode("-1");
        response.setBody(sBody);
        return response;
    }
}
