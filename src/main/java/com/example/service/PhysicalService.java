package com.example.service;

import com.example.api.CommonService;
import com.example.api.PUB0015Soap;
import com.example.dao.PhysicalDAO;
import com.example.domain.*;
import com.example.service.util.XmlUtils;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhysicalService {

    @Autowired
    PhysicalDAO physicalDAO;

    //根据患者索引查询历次体检记录，bug：不确定患者索引类型
    public List<Physical> getList(String SourceSystem, String MessageID, String PATPatientID) {
        // 数据准备
        String xmlStr = "<Request>\n" +
                "    <Header>\n" +
                "        <SourceSystem>" + "platform" + "</SourceSystem>\n" +
                "        <MessageID>" + MessageID + "</MessageID>\n" +
                "    </Header>\n" +
                "    <Body>\n" +
                "        <MedExamRt>\n" +
                "            <PATPatientID>" + PATPatientID + "</PATPatientID>\n" +
                "        </MedExamRt>\n" +
                "    </Body>\n" +
                "</Request>\n";
        //远程调用，获取到xml数据
        String result = this.sendWebService(xmlStr, "BOE0074");
        if (result == null ||  result.equals("")) {
            return null;
        }
        //转成对象
        Response r = XmlUtils.xmlToObject(Response.class, result);
        //插入数据库
        physicalDAO.delPhysical(new Long(PATPatientID));
        List<Physical> physicalList = r.getBody().getMedExamRp().getPhysicalsList();

        if (physicalList == null) {
            return null;
        }
        for (Physical physical : physicalList) {
            physical.setSourceSystem(r.getHeader().getSourceSystem());
            physical.setMessageID(r.getHeader().getMessageID());
            physical.setPatId(new Long(PATPatientID));
        }

        physicalDAO.addPhysical(physicalList);
        //返回数据
        return r.getBody().getMedExamRp().getPhysicalsList();
    }

    //根据体检记录查询建议bug：不确定一条体检记录对应几条建议,目前按文档的多条做的
    public List<Suggest> getSuggest(String SourceSystem, String MessageID, Long MedExamID) {
        // 数据准备
        String xmlStr = "<Request>\n" +
                "    <Header>\n" +
                "        <SourceSystem>"  + "platform" + "</SourceSystem>\n" +
                "        <MessageID>" + MessageID + "</MessageID>\n" +
                "    </Header>\n" +
                "    <Body>\n" +
                "        <MedExamSummaryRt>\n" +
                "            <MedExamID>" + MedExamID + "</MedExamID>\n" +
                "        </MedExamSummaryRt>\n" +
                "    </Body>\n" +
                "</Request>\n";
        //远程调用，获取到xml数据
        String result = this.sendWebService(xmlStr, "BOE0075");
        if (result == null || result.equals("")) {
            return null;
        }
        //转成对象
        Response r = XmlUtils.xmlToObject(Response.class, result);
        //插入数据库
        physicalDAO.delSuggests(MedExamID);
        List<Suggest> suggests = r.getBody().getMedExamSummaryRp().getSuggestList();
        for (Suggest suggest : suggests) {
            suggest.setSourceSystem(r.getHeader().getSourceSystem());
            suggest.setMessageID(r.getHeader().getMessageID());
            suggest.setPhyId(MedExamID);
        }
        physicalDAO.addSuggests(suggests);
        //返回数据
        return suggests;
    }

    //查询报告项目细项结果 bug：
    public MedExamItemRp getConsequence(String SourceSystem, String MessageID, Long MedExamID, String PageNo) {
        // 数据准备
        String xmlStr = "<Request>\n" +
                "    <Header>\n" +
                "        <SourceSystem>" + "platform" + "</SourceSystem>\n" +
                "        <MessageID>" + MessageID + "</MessageID>\n" +
                "    </Header>\n" +
                "    <Body>\n" +
                "        <MedExamRt>\n" +
                "            <MedExamID>" + MedExamID + "</MedExamID>\n" +
                "            <PageNo>" + PageNo + "</PageNo>\n" +
                "        </MedExamRt>\n" +
                "    </Body>\n" +
                "</Request>\n";
        //远程调用，获取到xml数据
        String result = this.sendWebService(xmlStr, "BOE0076");
        if (result == null || result.equals("")) {
            return null;
        }
        //转成对象
        WResponse r = XmlUtils.xmlToObject(WResponse.class, result);
        if(!"0".equals(r.getBody().getResultCode())){
            return null;
        }
        //插入数据库

        physicalDAO.delConsequence(MedExamID);
        System.out.println(r.getBody().getMedExamItemRp());
        String total = r.getBody().getMedExamItemRp().getTotal();
        List<Consequence> consequenceList = r.getBody().getMedExamItemRp().getConsequenceList();
        for (Consequence consequence : consequenceList) {
            consequence.setSourceSystem(r.getHeader().getSourceSystem());
            consequence.setMessageID(r.getHeader().getMessageID());
            consequence.setPhyId(MedExamID);
            consequence.setTotal(total);
            List<PhysicalConse> physicalConses = consequence.getPhysicalConseList();
            for (PhysicalConse physicalConse : physicalConses) {///问题点
                physicalConse.setConId(consequence.getId());
            }
            physicalDAO.delPhysicalConse(consequence.getId());
            if(physicalConses!=null&&physicalConses.size()!=0){
                physicalDAO.addPhysicalConse(physicalConses);

            }
        }
        physicalDAO.addConsequence(consequenceList);
        //返回数据
        return r.getBody().getMedExamItemRp();
    }

    public static void main(String []args){
        String str="<Response><Header><MessageID>6347</MessageID><SourceSystem>02</SourceSystem></Header><Body><ResultCode>0</ResultCode><ResultContent>临床诊断:;检查所见:1. BA、双侧VA血流速度Vm、Vs正常，PI值正常，血流频谱圆钝。2.双侧ACA、左侧MCA、ICA末端血流速度Vm、Vs稍减慢，PI值偏高，其余各支被检动脉血管血流速度Vm、Vs正常，PI值正常，谱态动脉硬化改变。;诊断意见:脑动脉硬化改变（定期复查）。</ResultContent><MedExamSummaryRp><ExaminationSummary><MedExamSummary>1、[高血压(2级)]161mmHg(90-140mmHg)↑106目前血压控制不理想，建议心血管门诊调整用药方案，并注意监测血压。平时忌烟酒，低盐、低动物脂肪饮食，多食水果、蔬菜，增加运动，控制体重，调畅情绪，规律作息。2、痔疮多吃蔬菜水果，保持大便通畅，可热水坐浴；如症状加重，建议到外科门诊进一步诊治。3、[牙龈炎]由于口腔卫生不良，导致牙菌斑、牙结石及软垢在龈缘附近牙面沉积，诱发牙龈炎。建议到口腔科诊治。平时应保持良好的口腔卫生，掌握正确的刷牙方法，定期进行口腔检查。4、[牙石]是附着在牙齿上的异物硬块。由于牙石本身容易吸附更多的细菌毒素，故易诱发牙龈炎、牙周炎。平时应认真刷牙，少进食松软粘性食物，定期到口腔科清除牙石。5、腹部超声：胆囊息肉为胆囊的良性病变，大多数人无症状，建议每6-12个月复查腹部超声；若息肉增大到1cm以上，或增长速度快，应到肝胆外科进一步诊治。6、[血常规：淋巴细胞增多]淋巴细胞百分比：50.30%(20-50%)↑血淋巴细胞增多主要见于病毒感染，建议您复查，如明显持续升高请到血液科进一步诊治。7、[高密度脂蛋白胆固醇（HDL）增高]高密度胆固醇：1.88mmol/L(1.04-1.55mmol/L)↑;1.88mmol/L(1.04-1.55mmol/L)↑;1.88mmol/L(1.04-1.55mmol/L)↑;1.88mmol/L(1.04-1.55mmol/L)↑高密度脂蛋白胆固醇（HDL）增高可能与体力劳动透支、注射雌激素、胰岛素、服用避孕药、烟酸、肝素、维生素E等药物，这种情况下只需适当休息，停止服用或减量服用药物即可恢复正常。原发性高密度脂蛋白胆固醇（HDL）、胆汁淤积性肝硬化、慢性肝炎等，也会造成高密度脂蛋白胆固醇（HDL）增高，定期复查。8、白带清洁度Ⅲ清洁度：III(I-II)不排除阴道炎的可能，建议妇科门诊进一步诊治。9、经颅多普勒超声检查：脑动脉硬化改变动脉硬化与年龄、性别、遗传、吸烟、饮酒、体力活动少、肥胖、血脂异常、高血压、糖尿病等存在相关性，可导致动脉管腔狭窄及器官缺血。脑动脉粥样硬化可导致脑供血不足甚至脑血管意外。建议去神经内科门诊进一步诊治。</MedExamSummary><MedExamSummaryDoctor>奚东珠</MedExamSummaryDoctor><MedExamSummaryDate>2019-01-19</MedExamSummaryDate></ExaminationSummary></MedExamSummaryRp></Body></Response>";
        //转成对象
        Response r = XmlUtils.xmlToObject(Response.class, str);
        //插入数据库
        List<Suggest> suggests = r.getBody().getMedExamSummaryRp().getSuggestList();
        System.out.println(suggests.size());
        for (Suggest suggest : suggests) {
            System.out.println(suggest.getMedExamSummary());
        }
    }

    public String sendWebService(String xmlStr, String code) {
        // 接口地址
        String address = "http://60.174.197.150:57772/csp/hsb/DHC.Published.PUB0015.BS.PUB0015.CLS";
        // String address = "http://localhost:13001/services/CommonService?wsdl";
        // 代理工厂
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        System.out.println("代理工厂 .....");
        // 设置代理地址
        jaxWsProxyFactoryBean.setAddress(address);
        System.out.println("设置代理地址 .....");
        // 设置接口类型
        jaxWsProxyFactoryBean.setServiceClass(PUB0015Soap.class);
        System.out.println("设置接口类型 .....");
        // 创建一个代理接口实现
        PUB0015Soap cs = (PUB0015Soap) jaxWsProxyFactoryBean.create();
        System.out.println("创建一个代理接口实现 .....");
        // 调用代理接口的方法调用并返回xml结果
        String result = cs.hipMessageServer(code, xmlStr);
        System.out.println("调用代理接口的方法调用并返回xml结果 ....." +result);
        return result;
    }




}
