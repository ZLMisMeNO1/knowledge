package cn.i7baoz.knowledge.exception;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
public class KnowledgeException extends RuntimeException{

    private String code;

    private String message;

    public KnowledgeException(String messgae) {
        super(messgae);
    }

    public KnowledgeException(String message,Object... args){
        super(String.format(message, args));
    }

    public KnowledgeException(KnowledgeMessageEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMessage();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}
