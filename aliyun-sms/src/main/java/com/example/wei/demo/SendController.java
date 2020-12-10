package com.example.wei.demo;

import com.example.wei.util.SmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：weimin
 * @date ：2020/12/10
 * @description：
 */
@RestController
public class SendController {

    @Autowired
    private SmsClient smsClient;

    @RequestMapping(value = "/send")
    public void send(){
        Map<String, String> map = new HashMap<>(3);
        map.put("corpName","三墩");
        map.put("doctorName","张三");
        map.put("patientVisitUrl","1233");
        smsClient.send("SMS_206563594",map,"15711036498");
    }

}
