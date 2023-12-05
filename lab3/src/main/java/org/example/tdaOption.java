package org.example;

import java.util.List;

public class tdaOption {
    private int code;
    private String message;
    private int chatbotCodeLink;
    private int initialFlowCodeLink;
    private List<String> keywords;

    public tdaOption(int code, String message, int chatbotCodeLink, int initialFlowCodeLink, List<String> keywords) {
        this.code = code;
        this.message = message;
        this.chatbotCodeLink = chatbotCodeLink;
        this.initialFlowCodeLink = initialFlowCodeLink;
        this.keywords = keywords;
    }
}
