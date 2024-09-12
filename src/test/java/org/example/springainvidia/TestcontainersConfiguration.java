package org.example.springainvidia;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.nvidia.NimContainer;

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

    @Bean
    NimContainer nimContainer(DynamicPropertyRegistry registry) {
        NimContainer nim = new NimContainer("nvcr.io/nim/meta/llama3-8b-instruct:1.0.0")
                .withNgcApiKey(System.getenv("NGC_API_KEY"))
                .withReuse(true);
        registry.add("spring.ai.openai.base-url", nim::getEndpoint);
        registry.add("spring.ai.openai.api-key", () -> "no-key");
        return nim;
    }

}
