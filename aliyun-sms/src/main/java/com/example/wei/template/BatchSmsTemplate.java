package com.example.wei.template;

import lombok.*;

import java.util.List;
import java.util.Map;

/**
 * 阿里云 SMS 短信模板.
 *
 * @author wei
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchSmsTemplate {
    private List<String> signNames;
    private String templateCode;
    private List<Map<String, String>> templateParams;
    private List<String> phoneNumbers;
}
