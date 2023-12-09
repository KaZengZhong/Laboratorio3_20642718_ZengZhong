package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class TDASystem {
    private String name;
    private int initialChatbotCodeLink;
    private List<Chatbot> chatbots;
    private Map<String, List<ChatMessage>> chatHistory;
    private Set<String> usuariosRegistrados;
    private String usuarioLogueadoActualmente;

    public TDASystem(String name, int initialChatbotCodeLink, List<Chatbot> chatbots) {
        this.name = name;
        this.initialChatbotCodeLink = initialChatbotCodeLink;
        this.chatbots = (chatbots != null) ? new ArrayList<>(chatbots) : new ArrayList<>();
        this.chatHistory = new HashMap<>();
        this.usuariosRegistrados = new HashSet<>();
        this.usuarioLogueadoActualmente = null;
    }

    public void systemAddChatbot(Chatbot chatbot) {
        if (chatbot == null) {
            System.out.println("Error: El chatbot es nulo.");
            return;
        }
        for (Chatbot existingChatbot : chatbots) {
            if (existingChatbot.getChatbotID() == chatbot.getChatbotID()) {
                System.out.println("Error: Ya existe un chatbot con el ID " + chatbot.getChatbotID() + " en el sistema.");
                return;
            }
        }
        chatbots.add(chatbot);
    }

    public void systemAddUser(String username) {
        if (username != null && !usuariosRegistrados.contains(username)) {
            usuariosRegistrados.add(username);
            System.out.println("Usuario '" + username + "' registrado exitosamente en el sistema.");
        } else {
            System.out.println("Error: No se pudo registrar al usuario '" + username + "'. Puede que el nombre de usuario ya esté en uso o sea inválido.");
        }
    }

    public boolean systemLogin(String username) {
        if (username == null || !usuariosRegistrados.contains(username)) {
            System.out.println("Error: Usuario no registrado o nombre de usuario inválido.");
            return false;
        }

        if (usuarioLogueadoActualmente != null) {
            System.out.println("Error: Ya hay una sesión activa con otro usuario.");
            return false;
        }

        usuarioLogueadoActualmente = username;
        System.out.println("Usuario '" + username + "' ha iniciado sesión exitosamente.");
        return true;
    }

    public void systemLogout() {
        if (usuarioLogueadoActualmente != null) {
            System.out.println("Usuario '" + usuarioLogueadoActualmente + "' ha cerrado su sesión.");
            usuarioLogueadoActualmente = null;
        } else {
            System.out.println("No hay ninguna sesión activa para cerrar.");
        }
    }

    // Getters y Setters
    // ...
}

class Chatbot {
    private int chatbotID;
    // Otros atributos y métodos ...

    public int getChatbotID() {
        return chatbotID;
    }
}

class ChatMessage {
    // Atributos y métodos de ChatMessage
    // ...
}

