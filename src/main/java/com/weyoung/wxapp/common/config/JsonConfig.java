///:JsonConfig.java
package com.weyoung.wxapp.common.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * 改变jackson的一些默认配置
 */
@Configuration
public class JsonConfig {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private FebsProperties febsProperties;

    @Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        // 序列化null为空字符串
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
                    throws IOException {
                jsonGenerator.writeString("");
            }
        });

        logger.debug("配置jackson的时间格式及时区...");
        // 强制转换时区为东八区
        objectMapper.setDateFormat(new SimpleDateFormat(febsProperties.getTimeFormat()));
        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        builder.timeZone("GMT+8");
        return objectMapper;
    }
}
///:JsonConfig.java
