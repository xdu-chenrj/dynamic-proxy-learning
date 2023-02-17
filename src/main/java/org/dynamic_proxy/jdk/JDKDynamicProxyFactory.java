package org.dynamic_proxy.jdk;

import java.lang.reflect.Proxy;

public class JDKDynamicProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new JDKDynamicInvocationHandler(target));
    }
}
