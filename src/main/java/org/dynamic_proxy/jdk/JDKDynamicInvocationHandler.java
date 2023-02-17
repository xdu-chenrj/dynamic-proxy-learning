package org.dynamic_proxy.jdk;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class JDKDynamicInvocationHandler implements InvocationHandler {
    private final Object target;

    public JDKDynamicInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("before method {}", method.getName());
        Object res = method.invoke(target, args);
        log.info("after method {}", method.getName());
        return res;
    }
}
