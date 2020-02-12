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

        String  result = null;
        try {
            if(code.equals("T0004")) {
                result = patientService.insert(param);
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