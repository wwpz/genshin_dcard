package top.xc27.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@ComponentScan(basePackages = "top.xc27")
@SpringBootApplication
public class DcardWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(DcardWebApplication.class, args);
    }
}
