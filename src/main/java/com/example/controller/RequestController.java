package com.example.controller;

import com.example.domain.Header;
import com.example.domain.Response;
import com.example.receive.DivisionRequest;
import com.example.receive.Doctor;
import com.example.receive.PersonnelRequest;
import com.example.receive.Request;
import com.example.service.DivisionService;
import com.example.service.DoctorsService;
import com.example.service.PersonneService;
import com.example.service.util.XmlUtils;
import net.sf.json.xml.XMLSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;


/**
 * Created by wang bin
 */
@Controller
@RequestMapping("/request/")
public class RequestController {

    static final Logger log = LoggerFactory.getLogger(RequestController.class);


    @Resource
    private DoctorsService doctorsService;

    @Resource
    private DivisionService divisionService;

    @Resource
    private PersonneService personneService;


  /*  @RequestMapping(value="/medical",produces = "application/xml; charset=UTF-8")
    @ResponseBody
    public String resultNotify(HttpServletRequest request) {

        log.info("个人体检接收接口");
        InputStream ins = null;
        Response rep = null;
        try {
            ins = request.getInputStream();
            byte[] rebyte = readStream(ins);
            String remess = new String(rebyte);
            System.out.println("XML报文内容为：" + remess);
             Request request1 = XmlUtils.xmlToObject(Request.class, remess);
             rep = doctorsService.insertDoctor(request1);
            return rep.toString();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return rep.toString();

     }


    @RequestMapping(value="/department",produces = "application/xml; charset=UTF-8")
    @ResponseBody
    public Response SendManagerDataInfo(HttpServletRequest request) {

        log.info("科室字典接收接口");
        InputStream ins = null;
        Response rep = null;
        try {
            ins = request.getInputStream();
            byte[] rebyte = readStream(ins);
            String remess = new String(rebyte);
            System.out.println("XML报文内容为：" + remess);
            DivisionRequest req = XmlUtils.xmlToObject(DivisionRequest.class, remess);
            log.info("测试数据:{}",req.getDivisionBody().getdT_DeptList().getCT_Dept().getBusinessFieldCode());
             rep = divisionService.insert(req);
            return rep;
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return rep;

    }


    @RequestMapping(value="/personnel",produces = "application/xml; charset=UTF-8")
    @ResponseBody
    public Response personnel(HttpServletRequest request) {

        log.info("人员字典接收接口");
        InputStream ins = null;
        Response rep = null;
        try {
            ins = request.getInputStream();
            byte[] rebyte = readStream(ins);
            String remess = new String(rebyte);
            System.out.println("XML报文内容为：" + remess);
            PersonnelRequest req = XmlUtils.xmlToObject(PersonnelRequest.class, remess);
            log.info("测试数据:{}",req.getPersonnelDody().getCt_careProvList().getCt_careProv().getBusinessFieldCode());
            rep = personneService.insert(req);
            return rep;
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return rep;

    }
*/
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
