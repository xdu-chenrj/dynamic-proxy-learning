package org.dynamic_proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


@Slf4j
public class CGLIBDynamicProxyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("before method {}, methodProxy {}", method.getName(), methodProxy.getSuperName());
        Object res = methodProxy.invokeSuper(o, objects);
        log.info("message {}", res);
        log.info("after method {}", method.getName());
        return res;
    }
}
