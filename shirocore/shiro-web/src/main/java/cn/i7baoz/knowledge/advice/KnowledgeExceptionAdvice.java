package cn.i7baoz.knowledge.advice;

import cn.i7baoz.knowledge.exception.KnowledgeException;
import cn.i7baoz.knowledge.exception.KnowledgeMessageEnum;
import cn.i7baoz.knowledge.resp.KnowledgeResponseBody;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@ControllerAdvice
public class KnowledgeExceptionAdvice {

    @ExceptionHandler(KnowledgeException.class)
    @ResponseBody
    public KnowledgeResponseBody doAdvice(KnowledgeException e){
        return KnowledgeResponseBody.builder()
                .code(e.getCode())
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public KnowledgeResponseBody ex(Exception e){
        e.printStackTrace();
        return KnowledgeResponseBody.builder()
                .code(KnowledgeMessageEnum.SYSTEM_ERROR.getCode())
                .message(KnowledgeMessageEnum.SYSTEM_ERROR.getMessage())
                .build();
    }
}
