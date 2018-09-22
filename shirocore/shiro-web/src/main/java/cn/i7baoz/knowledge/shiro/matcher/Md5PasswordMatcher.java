package cn.i7baoz.knowledge.shiro.matcher;

import cn.i7baoz.knowledge.exception.KnowledgeException;
import cn.i7baoz.knowledge.exception.KnowledgeMessageEnum;
import cn.i7baoz.knowledge.model.dto.LoginUserPersonDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.Objects;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@Slf4j
public class Md5PasswordMatcher extends SimpleCredentialsMatcher {


    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

        LoginUserPersonDto loginUserPersonDto = (LoginUserPersonDto) info.getPrincipals().getPrimaryPrincipal();
        token.getCredentials();
        Md5Hash md5Hash = new Md5Hash(token.getCredentials(),loginUserPersonDto.getSalt(),2);
        //校验密码hash值是否相同
        if (!Objects.deepEquals(md5Hash.toHex(),loginUserPersonDto.getPasswordHash())) {
            throw new IncorrectCredentialsException();
        }
        return true;
    }
}
