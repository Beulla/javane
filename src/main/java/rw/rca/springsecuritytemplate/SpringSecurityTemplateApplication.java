package rw.rca.springsecuritytemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableAutoConfiguration
//@EntityScan("rw.rca.springsecutirytemplate.Models")
//@EnableJpaRepositories("rw.rca.springsecuritytemplate.Repositories")
//@ComponentScan(basePackages ={"rw.rca.springsecuritytemplate.controllers","rw.rca.springsecuritytemplate.Services"})


public class SpringSecurityTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityTemplateApplication.class, args);
    }

}
