package top.xc27.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "top.xc27")
@SpringBootApplication
public class DcardWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(DcardWebApplication.class, args);
    }
}
