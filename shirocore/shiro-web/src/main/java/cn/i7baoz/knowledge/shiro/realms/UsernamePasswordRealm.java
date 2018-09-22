package cn.i7baoz.knowledge.shiro.realms;

import cn.i7baoz.knowledge.exception.KnowledgeException;
import cn.i7baoz.knowledge.exception.KnowledgeMessageEnum;
import cn.i7baoz.knowledge.model.dto.LoginUserPersonDto;
import cn.i7baoz.knowledge.service.UserService;
import cn.i7baoz.knowledge.shiro.matcher.Md5PasswordMatcher;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
public class UsernamePasswordRealm extends AuthorizingRealm {

    @Override
    public String getName() {
        return "usernamePasswordRealm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {

        super.setCredentialsMatcher(new Md5PasswordMatcher());
    }

    private Md5Hash md5Hash = new Md5Hash();

    @Autowired
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        if (Objects.isNull(token.getPrincipal())) {
            throw new KnowledgeException(KnowledgeMessageEnum.UNKNOWN_ACCOUNT);
        }
        LoginUserPersonDto personDetail = userService.getPersonDetail((String) token.getPrincipal());
        if (personDetail == null) {
            throw new UnknownAccountException();
        }

        return new SimpleAuthenticationInfo(personDetail, token.getCredentials(), getName());
    }
}
