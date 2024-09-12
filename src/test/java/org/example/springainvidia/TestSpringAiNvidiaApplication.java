package org.example.springainvidia;

import org.springframework.boot.SpringApplication;

public class TestSpringAiNvidiaApplication {

    public static void main(String[] args) {
        SpringApplication.from(SpringAiNvidiaApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
