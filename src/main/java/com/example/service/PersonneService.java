package com.example.service;

import com.example.dao.PersonneDao;
import com.example.domain.Header;
import com.example.domain.Response;
import com.example.domain.ResponseBuild;
import com.example.domain.SBody;
import com.example.receive.PersonnelRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.awt.*;

/**
 * Created by wang bin
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PersonneService {

    @Resource
    private PersonneDao personneDao;

    public String insert(PersonnelRequest request){
        int insert = personneDao.insert(request.getHeader().getSourceSystem(), request.getHeader().getMessageID(),
                request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_Code(), request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_JobNumber(),
                request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_Desc(), request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_Name(),
                request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_Spell(), request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_SexCode(),
                request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_BirthDate(), request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_IDCardNO(),
                request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_TitleOfTechCode(), request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_StaffTypeCode(),
                request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_CareProvPositionCode(), request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_CareProvTypeCode(),
                request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_DeptCode(), request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_BirthPlace(),
                request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_CodesystemCode(), request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_Remarks(),
                request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_ExtranetURL(), request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_PassWord(),
                request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_UpdateUserCode(), request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_CreatDate(),
                request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_CreatTime(), request.getPersonnelDody().getCt_careProvList().getCt_careProv().getBusinessFieldCode(),
                request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_OriginalCode(), request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_OriginalDesc(),
                request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_StartDate(), request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_EndDate(),
                request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_HosCode(), request.getPersonnelDody().getCt_careProvList().getCt_careProv().getCTCP_Status());

        /*Response response = new Response();
        Header header = new Header();
        header.setMessageID( request.getHeader().getMessageID());
        header.setSourceSystem(request.getHeader().getSourceSystem());
        response.setHeader(header);
        if(insert > 0){
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
        return response;*/
        return  ResponseBuild.success();
    }
}
