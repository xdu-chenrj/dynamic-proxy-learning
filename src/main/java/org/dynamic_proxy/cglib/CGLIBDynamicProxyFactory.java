package org.dynamic_proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class CGLIBDynamicProxyFactory {
    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new CGLIBDynamicProxyMethodInterceptor());
        return enhancer.create();
    }
}
