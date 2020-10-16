package com.learn.servicefeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client",fallback = UserFeignHystrix.class)
public interface UserFeignService {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String getHelloFromClientOne(@RequestParam(value = "name") String name);
}
