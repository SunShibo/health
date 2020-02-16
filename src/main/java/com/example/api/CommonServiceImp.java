package com.example.api;

import javax.annotation.Resource;
import javax.jws.WebService;

import com.alibaba.druid.util.StringUtils;
import com.example.domain.Patient;
import com.example.domain.ResponseBuild;
import com.example.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * 接口实现
 * 
 * @author leftso
 *
 */
@WebService(serviceName = "CommonService", // 与接口中指定的name一致
        targetNamespace = "http://webservice.leftso.com/", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.example.api.CommonService"// 接口地址
)
@Component
public class CommonServiceImp implements CommonService {
    @Resource
    private PatientService  patientService;

    @Override
    public String synPatient(String code,String param) {
        if(StringUtils.isEmpty(code) || StringUtils.isEmpty(param) ){
            return ResponseBuild.failure("参数异常");
        }
        System.err.println(code);
        System.err.println(code);
        System.err.println(code);
        String  result = null;
        try {
            if(code.equals("T0004")) {
                result = patientService.insert(param);
            }else if(code.equals("BOE0074")){//查询历次体检记录,
                result= "<Response>\n" +
                        "    <Header>\n" +
                        "        <SourceSystem></SourceSystem>\n" +
                        "        <MessageID></MessageID>\n" +
                        "    </Header>\n" +
                        "    <Body>\n" +
                        "        <ResultCode>0</ResultCode>\n" +
                        "        <ResultContent>成功</ResultContent>\n" +
                        "        <MedExamRp>\n" +
                        "            <MedExamItem>\n" +
                        "                <PATPATPatientName>mic1</PATPATPatientName>\n" +
                        "                <SexDesc>男</SexDesc>\n" +
                        "                <PATAge>27</PATAge>\n" +
                        "                <MedExamDate>2016-10-20</MedExamDate>\n" +
                        "                <MedExamID>1163</MedExamID>\n" +
                        "                <MedExamReportStatus>已打印</MedExamReportStatus>\n" +
                        "                <MedExamStatus>到达</MedExamStatus>\n" +
                        "                <MedExamReservationDate>2016-10-13</MedExamReservationDate>\n" +
                        "            </MedExamItem>\n" +
                        "            <MedExamItem>\n" +
                        "                <PATPATPatientName>mic1</PATPATPatientName>\n" +
                        "                <SexDesc>男</SexDesc>\n" +
                        "                <PATAge>27</PATAge>\n" +
                        "                <MedExamDate>2016-10-20</MedExamDate>\n" +
                        "                <MedExamID>1163</MedExamID>\n" +
                        "                <MedExamReportStatus>已打印</MedExamReportStatus>\n" +
                        "                <MedExamStatus>到达</MedExamStatus>\n" +
                        "                <MedExamReservationDate>2016-10-13</MedExamReservationDate>\n" +
                        "            </MedExamItem>\n" +
                        "        </MedExamRp>\n" +
                        "    </Body>\n" +
                        "</Response>\n";
                //模拟从东华查询出来的xml数据
            }else{
                return ResponseBuild.failure("没有找到接口代码");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return  ResponseBuild.failure("发生异常");
        }
        return  result;
    }
 
}