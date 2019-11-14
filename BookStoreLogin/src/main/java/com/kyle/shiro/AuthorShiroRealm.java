package com.kyle.shiro;

import com.kyle.dao.AuthorRespository;
import com.kyle.domain.Author;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorShiroRealm extends AuthorizingRealm {
    @Autowired
    AuthorRespository authorRespository;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String aname= (String) token.getPrincipal();
       Author author = authorRespository.findByAname(aname);
        String salt = "likun";  //把用户名作为加密密码的盐
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(aname,author.getApassword(),ByteSource.Util.bytes(salt),getName());
        return simpleAuthenticationInfo;
    }
}
