
## SpringCloud

eureka producer
- 注册中心与服务提供者保持版本一致，建议全都继承父类pom文件中的springboot版本。
```xml
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    </dependency>
            
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
```
依赖解决注解 @EnableEurekaServer 无法导入的问题。
版本号
spring-cloud.version：Greenwich.SR4
springboot.version：2.1.11.RELEASE

- The following method did not exist: org.springframework.boot.actuate.health.CompositeHealthIndicator 问题
https://www.cnblogs.com/taiyii/p/12326603.html 

- SpringCloud Feign注解导入失败
https://blog.csdn.net/u013305864/article/details/82322867 
采用的是：
```xml
 <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```

- java.lang.ClassNotFoundException: org.springframework.boot.context.properties.ConfigurationPropertiesBean
https://blog.csdn.net/hello_word2/article/details/103598857
版本号不一致问题。