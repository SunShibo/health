package com.example.service;

import com.alibaba.druid.util.StringUtils;
import com.example.dao.*;
import com.example.domain.*;
import com.example.service.util.XmlUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Patient)表服务实现类
 *
 * @author makejava
 * @since 2020-02-11 20:51:37
 */
@Service("patientService")
@Transactional(rollbackFor = Exception.class)
 public class PatientService  {
    @Resource
    private PatientDao patientDao;
    @Resource
    private AddressDao  addressDao;
    @Resource
    private CertificateDao certificateDao;
    @Resource
    private ContactsDao contactsDao;
    @Resource
    private ConsAddressDao consAddressDao;
    /**
     * 新增数据
     *
     * @param param 实例对象
     * @return 实例对象
     */
    public String insert(String param) throws Exception {


            Request request = XmlUtils.xmlToObject(Request.class, param);
            //插入患者基本信息
            Patient patient = request.getBody().getPatientRegistryRt();
            patient.setSourcesystem(request.getHeader().getSourceSystem());
            patient.setMessageid(request.getHeader().getMessageID());
            patientDao.insert(patient);
            //插入患者地址信息
            if (patient.getPATAddressList() != null && patient.getPATAddressList().getAddress() != null && patient.getPATAddressList().getAddress().size() > 0) {
                List<Address> address = patient.getPATAddressList().getAddress();
                for (Address addr : address) {
                    addr.setPatId(patient.getId());
                    addressDao.insert(addr);
                }
            }
            //插入患者证件信息
            if (patient.getCertificate() != null && patient.getCertificate().getCertificates() != null && patient.getCertificate().getCertificates().size() > 0) {
                List<Certificates> certificates = patient.getCertificate().getCertificates();
                for (Certificates cer : certificates) {
                    cer.setPatid(patient.getId());
                    certificateDao.insert(cer);
                }
            }
            //患者联系人
            if (patient.getPatRelationList() != null && patient.getPatRelationList().getContacts() != null && patient.getPatRelationList().getContacts().size() > 0) {
                List<Contacts> contacts = patient.getPatRelationList().getContacts();
                for (Contacts con : contacts) {
                    con.setPatid(patient.getId());
                    contactsDao.insert(con);
                    //联系人地址
                    if (con.getPatRelationAddressList() != null && con.getPatRelationAddressList().getConsAddressList() != null && con.getPatRelationAddressList().getConsAddressList().size() > 0) {
                        List<ConsAddress> consAddressList = con.getPatRelationAddressList().getConsAddressList();
                        for (ConsAddress list : consAddressList) {
                            list.setContsId(con.getId());
                            consAddressDao.insert(list);
                        }
                    }
                }
            }

        return ResponseBuild.success();
    }


}