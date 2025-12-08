package org.example.auth.sms;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Nyxcirea
 * @date 2025/12/8
 * @description: 阿里云 Access Key 配置
 */
@ConfigurationProperties(prefix = "red-book.aliyun")
@Component
@Data
public class AliyunAccessKeyProperties {
	private String accessKeyId;
	private String accessKeySecret;
}
