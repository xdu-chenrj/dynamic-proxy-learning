package org;


import lombok.extern.slf4j.Slf4j;
import org.dynamic_proxy.cglib.CGLIBDynamicProxyFactory;
import org.dynamic_proxy.jdk.JDKDynamicProxyFactory;
import org.static_proxy.SmsStaticProxy;

@Slf4j
public class Main {
    public static void main(String[] args) {
        // 静态代理
        SmsService smsService = new SmsServiceImpl();
        SmsStaticProxy smsStaticProxy = new SmsStaticProxy(smsService);
        String message = "hello world";
        log.info("message {}", smsStaticProxy.sendMessage(message));


        // JDK动态代理
        smsService = (SmsService) JDKDynamicProxyFactory.getProxy(new SmsServiceImpl());
        log.info("message {}", smsService.sendMessage(message));

        // CGLIB动态代理

        smsService = (SmsService) CGLIBDynamicProxyFactory.getProxy(SmsServiceImpl.class);
        log.info(smsService.sendMessage(message));
    }
}