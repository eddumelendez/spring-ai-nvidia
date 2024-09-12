package org.example.springainvidia;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @GetMapping("/chat")
    public String chat() {
        return this.chatClient.prompt()
                .system("Do not exceed 200 characters in the answer")
                .user("Do you know how to improve my developer productivity with NVIDIA, Docker and Testcontainers?")
                .call()
                .content();
    }
}
