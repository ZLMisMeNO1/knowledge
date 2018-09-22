package cn.i7baoz.knowledge.advice;

import cn.i7baoz.knowledge.exception.KnowledgeMessageEnum;
import cn.i7baoz.knowledge.resp.KnowledgeResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@Slf4j
@ControllerAdvice
public class KnowledgeResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {

        return FastJsonHttpMessageConverter.class.isAssignableFrom(converterType);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        if (body instanceof KnowledgeResponseBody){
            return body;
        }

        /**
         * 转为KnowledgeResponseBody 发送到页面
         */
        return KnowledgeResponseBody.builder()
                .code(KnowledgeMessageEnum.SUCCESS.getCode())
                .message(KnowledgeMessageEnum.SUCCESS.getMessage())
                .body(body)
                .build();
    }
}
