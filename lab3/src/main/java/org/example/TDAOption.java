package org.example;

import java.util.List;

public class TDAOption {
    private int code;
    private String message;
    private int chatbotCodeLink;
    private int initialFlowCodeLink;
    private List<String> keywords;

    // Constructor
    public TDAOption(int code, String message, int chatbotCodeLink, int initialFlowCodeLink, List<String> keywords) {
        this.code = code;
        this.message = message;
        this.chatbotCodeLink = chatbotCodeLink;
        this.initialFlowCodeLink = initialFlowCodeLink;
        this.keywords = keywords;
    }

    // Getters
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getChatbotCodeLink() {
        return chatbotCodeLink;
    }

    public int getInitialFlowCodeLink() {
        return initialFlowCodeLink;
    }

    public List<String> getKeywords() {
        return keywords;
    }
}

