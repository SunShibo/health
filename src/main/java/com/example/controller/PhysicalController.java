package com.example.controller;


import com.example.domain.InformationReponse;
import com.example.domain.JsonResponse;
import com.example.domain.PatInfo;
import com.example.domain.Physical;
import com.example.service.PhysicalService;
import com.example.service.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * 体检记录
 * */
@RestController
public class PhysicalController {
    @Autowired
    PhysicalService physicalService;
    /**
     * 查询历次体检记录
     * SourceSystem 信息来源
     * MessageID 消息ID
     * PATPatientID 患者主索引 101100000072
     * @return
     */
    @PostMapping("/physical/getList")
    public JsonResponse getPhysicalList(@RequestBody Map<String, Object> params) throws Exception {
        if (params==null|| params.get("PATPatientID")==null){
            return  JsonResponse.fail("参数异常");
        }
        String SourceSystem=MapUtil.getString(params,"SourceSystem");
        String MessageID=MapUtil.getString(params,"MessageID");
        String PATPatientID=MapUtil.getString(params,"PATPatientID");
        List<Physical> physicalList= physicalService.getList(SourceSystem,MessageID,PATPatientID);
        return  new JsonResponse(physicalList);
    }

       /**
     * 查询总检建议
     * SourceSystem 信息来源
     * MessageID 消息ID
     * MedExamID 体检id
     * @return
     */
    @PostMapping("/suggest/get")
    public JsonResponse getSuggest(@RequestBody Map<String, Object> params) throws Exception {
        if (params==null||params.get("MedExamID")==null){
            return  JsonResponse.fail("参数异常");
        }
        String SourceSystem=MapUtil.getString(params,"SourceSystem");
        String MessageID=MapUtil.getString(params,"MessageID");
        Long MedExamID=MapUtil.getLong(params,"MedExamID");
        return  new JsonResponse(physicalService.getSuggest(SourceSystem,MessageID,MedExamID));
    }

    /**
     * 查询报告项目细项结果
     * SourceSystem 信息来源
     * MessageID 消息ID
     * MedExamID 体检id
     * PageNo 页码
     * @return
     */
    @PostMapping("/consequence/get")
    public JsonResponse getConsequence(@RequestBody Map<String, Object> params) throws Exception {
        if (params==null||params.get("MedExamID")==null){
            return  JsonResponse.fail("参数异常");
        }
        String SourceSystem=MapUtil.getString(params,"SourceSystem");
        String MessageID=MapUtil.getString(params,"MessageID");
        Long MedExamID=MapUtil.getLong(params,"MedExamID");
        String PageNo=MapUtil.getString(params,"PageNo");
        return  new JsonResponse(physicalService.getConsequence(SourceSystem,MessageID,MedExamID,PageNo));
    }


    /**
     * 患者基本信息查询
     */
    @PostMapping("/consequence/information")
    public JsonResponse information(@RequestBody Map<String, Object> params) throws Exception {

        if (params==null||params.get("TradeCode")==null|| params.get("HospitalCode")==null || params.get("UserCode")==null
            || params.get("PATCardNum")==null  || params.get("PATPatientID")==null  || params.get("IdentityCardNo")==null
        ){
            return  JsonResponse.fail("参数异常");
        }
        return  new JsonResponse(physicalService.information(params));
    }

    @PostMapping("/test/test")
    public JsonResponse test(){
        PatInfo patInfo = new PatInfo();;
        return  new JsonResponse(patInfo);
    }
}
