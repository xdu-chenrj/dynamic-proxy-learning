package org.static_proxy;

import lombok.extern.slf4j.Slf4j;
import org.SmsService;

@Slf4j
public class SmsStaticProxy implements SmsService {
    private SmsService smsService;
    public SmsStaticProxy(SmsService smsService) {
        this.smsService = smsService;
    }
    @Override
    public String sendMessage(String message) {
        log.info("before sendMessage");
        String mes = smsService.sendMessage(message);
        log.info("sendMessage {}", mes);
        log.info("after sendMessage");
        return mes;
    }
}
