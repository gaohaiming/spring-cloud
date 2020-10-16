package com.learn.servicefeign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignHelloController {
    @Resource
    UserFeignService userFeignService;

    @GetMapping(value = "/feignTest")
    public String sayHi(@RequestParam String name) {
        return userFeignService.getHelloFromClientOne(name);
    }
}
