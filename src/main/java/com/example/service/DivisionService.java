package com.example.service;

import com.example.dao.DivisionDao;
import com.example.domain.Header;
import com.example.domain.Response;
import com.example.domain.SBody;
import com.example.receive.DivisionRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by wang bin
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DivisionService {

    @Resource
    private DivisionDao divisionDao;

    public Response insert(DivisionRequest request) {
        int insert = divisionDao.insert(request.getHeader().getSourceSystem(), request.getHeader().getMessageID(),
                request.getDivisionBody().getdT_DeptList().getCT_Dept().getCTD_Code(), request.getDivisionBody().getdT_DeptList().getCT_Dept().getCTD_Desc(),
                request.getDivisionBody().getdT_DeptList().getCT_Dept().getCTD_CategoryCode(), request.getDivisionBody().getdT_DeptList().getCT_Dept().getCTD_Phonetic(),
                request.getDivisionBody().getdT_DeptList().getCT_Dept().getCTD_WardFlag(), request.getDivisionBody().getdT_DeptList().getCT_Dept().getBusinessFieldCode(),
                request.getDivisionBody().getdT_DeptList().getCT_Dept().getCTD_CreatDate(), request.getDivisionBody().getdT_DeptList().getCT_Dept().getCTD_CreatTime(),
                request.getDivisionBody().getdT_DeptList().getCT_Dept().getCTD_UpdateDate(), request.getDivisionBody().getdT_DeptList().getCT_Dept().getCTD_UpdateTime(),
                request.getDivisionBody().getdT_DeptList().getCT_Dept().getCTD_OriginalCode(), request.getDivisionBody().getdT_DeptList().getCT_Dept().getCTD_OriginalDesc(),
                request.getDivisionBody().getdT_DeptList().getCT_Dept().getCTD_Remarks(), request.getDivisionBody().getdT_DeptList().getCT_Dept().getCTD_StartDate(),
                request.getDivisionBody().getdT_DeptList().getCT_Dept().getCTD_EndDate(), request.getDivisionBody().getdT_DeptList().getCT_Dept().getCTD_CodesystemCode(),
                request.getDivisionBody().getdT_DeptList().getCT_Dept().getCTD_OfficeAddress(), request.getDivisionBody().getdT_DeptList().getCT_Dept().getCTD_OfficePhone(),
                request.getDivisionBody().getdT_DeptList().getCT_Dept().getCTD_UpdateUserCode(), request.getDivisionBody().getdT_DeptList().getCT_Dept().getCTD_HosCode(),
                request.getDivisionBody().getdT_DeptList().getCT_Dept().getCTD_DepartmentGroup(), request.getDivisionBody().getdT_DeptList().getCT_Dept().getCTD_AdmType(),
                request.getDivisionBody().getdT_DeptList().getCT_Dept().getCTD_ParentCode(), request.getDivisionBody().getdT_DeptList().getCT_Dept().getCTD_Status());

        Response response = new Response();
        Header header = new Header();
        header.setMessageID(request.getHeader().getMessageID());
        header.setSourceSystem(request.getHeader().getSourceSystem());
        response.setHeader(header);
        if (insert > 0) {
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
