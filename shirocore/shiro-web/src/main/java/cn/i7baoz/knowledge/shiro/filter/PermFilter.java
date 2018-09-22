package cn.i7baoz.knowledge.shiro.filter;

import cn.i7baoz.knowledge.exception.KnowledgeMessageEnum;
import cn.i7baoz.knowledge.resp.KnowledgeResponseBody;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
public class PermFilter extends AuthenticationFilter {

    /**
     * 表示当访问拒绝时是否已经处理了；如果返回true表示需要继续处理；如果返回false表示该拦截器实例已经处理了，将直接返回即可。
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        KnowledgeResponseBody build = KnowledgeResponseBody
                .builder()
                .code(KnowledgeMessageEnum.ACCESS_DENIED.getCode())
                .message(KnowledgeMessageEnum.ACCESS_DENIED.getMessage())
                .build();
        writer.append(JSONObject.toJSONString(build));
        writer.flush();
        return false;
    }

    /**
     * 表示是否允许访问；mappedValue就是[urls]配置中拦截器参数部分，如果允许访问返回true，否则false；
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        Subject subject = SecurityUtils.getSubject();
        return subject.isAuthenticated();
    }
}
