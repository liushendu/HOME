package com.kyle.shiro;

import com.kyle.dao.AdminRespository;
import com.kyle.domain.Admin;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

public class AdminShiroRealm extends AuthorizingRealm {
    @Resource
    AdminRespository adminRespository;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
       Admin admin = adminRespository.findByName(username);
        System.out.println(admin.toString());
        String salt = "likun";  //把用户名作为加密密码的盐
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username,admin.getPassword(),ByteSource.Util.bytes(salt),getName());
        return simpleAuthenticationInfo;
    }
}
