package com.example.wei.config;

import com.example.wei.template.SmsTemplate;
import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 阿里云 SMS 配置属性.
 *
 * @author wei
 */
@Data
@ConfigurationProperties(prefix = "aliyun.sms")
@PropertySource(value = {"classpath:application-dev.properties"}, encoding = "utf-8")
@Component
public class SmsProperties implements InitializingBean {

    private String accessKeyId;
    private String accessKeySecret;
    private String signName;
    private String templateCode;
    private Map<String, SmsTemplate> templates;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (!StringUtils.isEmpty(this.templateCode)) {
            SmsTemplate template = new SmsTemplate();
            template.setSignName(this.signName);
            template.setTemplateCode(this.templateCode);
            templates = new HashMap<>(1);
            templates.put(templateCode,template);
        }
    }
}
