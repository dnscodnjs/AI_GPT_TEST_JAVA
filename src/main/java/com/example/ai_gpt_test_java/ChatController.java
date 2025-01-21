package com.example.ai_gpt_test_java;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final com.example.ai_gpt_test_java.ChatCompletionService chatCompletionService;

    public ChatController(ChatCompletionService chatCompletionService) {
        this.chatCompletionService = chatCompletionService;
    }

    // 예시1) GET 사용 시, prompt를 쿼리 파라미터로 받는다
    @GetMapping
    public String getChatCompletion(@RequestParam("prompt") String prompt) {
        return chatCompletionService.getChatCompletion(prompt);
    }

    // 예시2) POST 사용 시, prompt를 JSON 바디로 받는다
    @PostMapping
    public String postChatCompletion(@RequestBody PromptRequest request) {
        return chatCompletionService.getChatCompletion(request.getPrompt());
    }

    // 내부 DTO
    public static class PromptRequest {
        private String prompt;
        public String getPrompt() {
            return prompt;
        }
        public void setPrompt(String prompt) {
            this.prompt = prompt;
        }
    }
}