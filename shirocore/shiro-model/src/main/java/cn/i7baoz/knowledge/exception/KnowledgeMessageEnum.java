package cn.i7baoz.knowledge.exception;

/**
 * 错误列举
 * @author baoqi.zhang
 */
public enum KnowledgeMessageEnum {
    /*操作相关*/
    SUCCESS("200","OK"),
    ACCESS_DENIED("201","拒绝访问"),
    SYSTEM_ERROR("1000001","系统错误"),
    /* 登录相关*/
    UNKNOWN_ACCOUNT("200001","用户名不存在！"),
    INVALIDE_CRED("200002","密码错误！")
    ;

    private String code;

    private String message;

    KnowledgeMessageEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
