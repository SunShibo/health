package com.example.api;

import com.alibaba.druid.util.StringUtils;
import com.example.dao.ProjectDao;
import com.example.domain.ResponseBuild;
import com.example.domain.sub.ProductRequest;
import com.example.receive.DivisionRequest;
import com.example.receive.PersonnelRequest;
import com.example.receive.ProjectRequest;
import com.example.receive.Request;
import com.example.service.*;
import com.example.service.util.XmlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jws.WebService;
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

    @Resource
    private ProjectService projectService;

    @Resource
    private ProduceService produceService;
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
                log.info("个人体检接收接口");
                result = patientService.insert(param);
            }else if(code.equals("BOE0189")){
                String rep = null;
                Request request1 = XmlUtils.xmlToObject(Request.class, param);
                rep = doctorsService.insertDoctor(request1);
                return rep;
            }else if(code.equals("MS003")){
                log.info("科室字典接收接口");
                String rep = null;
                DivisionRequest req = XmlUtils.xmlToObject(DivisionRequest.class, param);
                log.info("测试数据:{}",req.getDivisionBody().getdT_DeptList().getCT_Dept().getBusinessFieldCode());
                rep = divisionService.insert(req);
                return rep;

            }else if(code.equals("MS004")){
                log.info("人员字典接收接口");
                String rep = null;
                PersonnelRequest req = XmlUtils.xmlToObject(PersonnelRequest.class, param);
                log.info("测试数据:{}",req.getPersonnelDody().getCt_careProvList().getCt_careProv().getBusinessFieldCode());
                rep = personneService.insert(req);
                return rep;
            }else if(code.equals("BOE0279")){
                log.info("体检项目细项对照关系推送");
                String rep = null;
                ProjectRequest req = XmlUtils.xmlToObject(ProjectRequest.class, param);
                rep = projectService.insertProject(req);
                return rep;
            }else if(code.equals("BOE0151")){
                log.info("产品套餐推送");
                String rep = null;
                ProductRequest req = XmlUtils.xmlToObject(ProductRequest.class, param);
                rep = produceService.insProduce(req);
                return rep;
            }
            else{
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