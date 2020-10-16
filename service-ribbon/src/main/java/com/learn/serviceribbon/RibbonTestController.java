package com.learn.serviceribbon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RibbonTestController {
    @Resource
    HelloService helloService;

    @GetMapping(value = "/test")
    public String hi(@RequestParam String name) {
        return helloService.helloService(name);
    }
}
