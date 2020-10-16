# spring-cloud
learn spring-cloud
###**一、服务的注册与发现（Eureka）**
#####1、引入依赖
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
#####2、@EnableEurekaServer开启eureka服务
#####3、配置实例名称端口等信息

在微服务架构中，业务都会被拆分成一个独立的服务，服务与服务的通讯是基于**http restful**的。
Spring cloud有两种服务调用方式，
一种是ribbon+restTemplate，另一种是feign。

###二、ribbon简介
ribbon是一个负载均衡客户端，可以很好的控制htt和tcp的一些行为。Feign默认集成了ribbon。

ribbon 已经默认实现了这些配置bean：

`IClientConfig ribbonClientConfig: DefaultClientConfigImpl`
`IRule ribbonRule: ZoneAvoidanceRule`
`IPing ribbonPing: NoOpPing`
`ServerList ribbonServerList: ConfigurationBasedServerList`
`ServerListFilter ribbonServerListFilter: ZonePreferenceServerListFilter`
`ILoadBalancer ribbonLoadBalancer: ZoneAwareLoadBalancer`

在工程的启动类中,通过@EnableDiscoveryClient向服务中心注册；
并且向程序的ioc注入一个bean: restTemplate;
并通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能。


###三、Feign简介
Feign是一个声明式的伪Http客户端，它使得写Http客户端变得更简单。
使用Feign，只需要创建一个接口并注解。它具有可插拔的注解特性，可使用Feign 注解和JAX-RS注解。
Feign支持可插拔的编码器和解码器。Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果。

`Feign 采用的是基于接口的注解
Feign 整合了ribbon，具有负载均衡的能力
整合了Hystrix，具有熔断的能力`

###五、断路器
Netflix开源了Hystrix组件，实现了断路器模式，SpringCloud对这一组件进行了整合。 
在微服务架构中，一个请求需要调用多个服务是非常常见的

###六、Zuul
   Zuul的主要功能是路由转发和过滤器。
   路由功能是微服务的一部分，比如／api/user转发到到user服务，/api/shop转发到到shop服务。
   zuul默认和Ribbon结合实现了负载均衡的功能。
     zuul有以下功能：
     Authentication
     Insights
     Stress Testing
     Canary Testing
     Dynamic Routing
     Service Migration
     Load Shedding
     Security
     Static Response handling
     Active/Active traffic management