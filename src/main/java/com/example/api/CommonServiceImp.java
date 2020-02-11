package com.example.api;

import javax.annotation.Resource;
import javax.jws.WebService;

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
    public String synPatient(String param) {
        String  result = null;
        try {
            result = patientService.insert(param);
        } catch (Exception e) {
            e.printStackTrace();
            return  ResponseBuild.failure("发生异常");
        }
        return  result;
    }
 
}