package com.example.ai_gpt_test_java;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class ChatCompletionService {

    @Value("${openai.api.url}")
    private String openAiUrl;

    @Value("${openai.api.key}")
    private String openAiApiKey;

    private final RestTemplate restTemplate;

    public ChatCompletionService() {
        this.restTemplate = new RestTemplate();
    }

    public String getChatCompletion(String userPrompt) {
        // 1) 요청 바디 만들기
        ChatCompletionRequest requestBody = new ChatCompletionRequest();
        requestBody.setModel("gpt-4o-mini");
        requestBody.setMessages(Collections.singletonList(new ChatCompletionRequest.Message("user", userPrompt)));
        requestBody.setTemperature(1.0);
        requestBody.setMax_tokens(1000);

        // 2) 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(openAiApiKey);

        HttpEntity<ChatCompletionRequest> entity = new HttpEntity<>(requestBody, headers);

        // 3) OpenAI API 호출
        ResponseEntity<ChatCompletionResponse> responseEntity =
                restTemplate.exchange(openAiUrl, HttpMethod.POST, entity, ChatCompletionResponse.class);

        // 4) 결과 파싱
        if (responseEntity.getStatusCode() == HttpStatus.OK && responseEntity.getBody() != null) {
            ChatCompletionResponse responseBody = responseEntity.getBody();

            // 첫 번째 choice의 message.content를 반환
            if (responseBody.getChoices() != null && !responseBody.getChoices().isEmpty()) {
                return responseBody.getChoices().get(0).getMessage().getContent();
            }
        }
        return "응답이 올바르지 않습니다.";
    }
}
