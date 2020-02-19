package com.example.api;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.druid.util.StringUtils;
import com.example.controller.RequestController;
import com.example.domain.Patient;
import com.example.domain.Response;
import com.example.domain.ResponseBuild;
import com.example.receive.DivisionRequest;
import com.example.receive.PersonnelRequest;
import com.example.receive.Request;
import com.example.service.DivisionService;
import com.example.service.DoctorsService;
import com.example.service.PatientService;
import com.example.service.PersonneService;
import com.example.service.util.XmlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

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



    static final Logger log = LoggerFactory.getLogger(CommonServiceImp.class);


    @Resource
    private DoctorsService doctorsService;

    @Resource
    private DivisionService divisionService;

    @Resource
    private PersonneService personneService;


    @Override
    public String synPatient(String code, String param) {
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
            }else if(code.equals("BOE0189")){

                log.info("个人体检接收接口");
                InputStream ins = null;
                String rep = null;


                Request request1 = XmlUtils.xmlToObject(Request.class, param);
                rep = doctorsService.insertDoctor(request1);
                return rep;
            }else if(code.equals("MS003")){
                log.info("科室字典接收接口");
                InputStream ins = null;
                String rep = null;

                DivisionRequest req = XmlUtils.xmlToObject(DivisionRequest.class, param);
                log.info("测试数据:{}",req.getDivisionBody().getdT_DeptList().getCT_Dept().getBusinessFieldCode());
                rep = divisionService.insert(req);
                return rep;

            }else if(code.equals("MS004")){
                log.info("人员字典接收接口");
                InputStream ins = null;
                String rep = null;

                PersonnelRequest req = XmlUtils.xmlToObject(PersonnelRequest.class, param);
                log.info("测试数据:{}",req.getPersonnelDody().getCt_careProvList().getCt_careProv().getBusinessFieldCode());
                rep = personneService.insert(req);
                return rep;
            }else{
                return ResponseBuild.failure("没有找到接口代码");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return  ResponseBuild.failure("发生异常");
        }
        return  result;
    }


    /**
     * @功能 读取流
     * @param inStream
     * @return 字节数组
     * @throws Exception
     */
    public static byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        outSteam.close();
        inStream.close();
        return outSteam.toByteArray();
    }
 
}