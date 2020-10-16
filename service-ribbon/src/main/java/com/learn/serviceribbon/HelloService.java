package com.learn.serviceribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class HelloService {
    @Resource
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultError")
    public String helloService(String name) {
        //在ribbon中它会根据服务名来选择具体的服务实例，根据服务实例在请求的时候会用具体的url替换掉服务名
        return restTemplate.getForObject("http://eureka-client/hello?name=" + name, String.class);
    }

    public String defaultError(String name) {
        return name + ",sorry,this is a default error!";
    }
}
