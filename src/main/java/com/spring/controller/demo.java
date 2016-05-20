package com.spring.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 16-5-9.
 */
public class demo {
    private static final Logger logger = LoggerFactory.getLogger(demo.class);

    public static void main(String[] args) {
        // 初始化 SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:conf/shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();

        // 登录
        UsernamePasswordToken token = new UsernamePasswordToken("shiro", "201314");
        try {
            subject.login(token);
            System.out.println("hello shiro");
        } catch (AuthenticationException ae) {
            logger.info("登录失败！");
            System.out.println("login error");
            return;
        }
        System.out.println("登录成功！Hello " + subject.getPrincipal());

        // 注销
        subject.logout();
    }
}
