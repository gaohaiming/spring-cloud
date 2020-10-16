package com.learn.servicefeign;

import org.springframework.stereotype.Component;

@Component
public class UserFeignHystrix implements UserFeignService {
    @Override
    public String getHelloFromClientOne(String name) {
        return String.format("hello %s,sorry error occurs!", name);
    }
}
