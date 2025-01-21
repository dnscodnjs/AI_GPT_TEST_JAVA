package com.example.ai_gpt_test_java;


import java.util.List;

public class ChatCompletionRequest {
    private String model;
    private List<Message> messages;
    private double temperature;
    private int max_tokens;

    // 기본 생성자
    public ChatCompletionRequest() {
    }

    // 모든 필드를 인자로 받는 생성자 (필요시)
    public ChatCompletionRequest(String model, List<Message> messages, double temperature, int max_tokens) {
        this.model = model;
        this.messages = messages;
        this.temperature = temperature;
        this.max_tokens = max_tokens;
    }

    // Getter & Setter
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getMax_tokens() {
        return max_tokens;
    }

    public void setMax_tokens(int max_tokens) {
        this.max_tokens = max_tokens;
    }

    // 내부 클래스로 메시지 정의
    public static class Message {
        private String role;
        private String content;

        // 기본 생성자
        public Message() {
        }

        // 모든 필드를 인자로 받는 생성자
        public Message(String role, String content) {
            this.role = role;
            this.content = content;
        }

        // Getter & Setter
        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}