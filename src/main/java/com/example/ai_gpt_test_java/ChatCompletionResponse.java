package com.example.ai_gpt_test_java;


import java.util.List;

public class ChatCompletionResponse {
    private String id;
    private String object;
    private long created;
    private String model;
    private List<Choice> choices;

    // 기본 생성자
    public ChatCompletionResponse() {
    }

    // 모든 필드를 인자로 받는 생성자(필요 시)
    public ChatCompletionResponse(String id, String object, long created, String model, List<Choice> choices) {
        this.id = id;
        this.object = object;
        this.created = created;
        this.model = model;
        this.choices = choices;
    }

    // Getter & Setter
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }
    public void setObject(String object) {
        this.object = object;
    }

    public long getCreated() {
        return created;
    }
    public void setCreated(long created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public List<Choice> getChoices() {
        return choices;
    }
    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    // 내부 Choice 클래스
    public static class Choice {
        private int index;
        private Message message;

        // 기본 생성자
        public Choice() {
        }

        // 모든 필드를 인자로 받는 생성자
        public Choice(int index, Message message) {
            this.index = index;
            this.message = message;
        }

        // Getter & Setter
        public int getIndex() {
            return index;
        }
        public void setIndex(int index) {
            this.index = index;
        }

        public Message getMessage() {
            return message;
        }
        public void setMessage(Message message) {
            this.message = message;
        }

        // 내부 Message 클래스
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
}