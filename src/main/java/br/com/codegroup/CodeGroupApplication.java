package br.com.codegroup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.Collections;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CodeGroupApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(CodeGroupApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.servlet.context-path", "/codegroup"));
        app.run(args);
    }
}
