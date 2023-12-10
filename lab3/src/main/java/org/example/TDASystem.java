package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class TDASystem {
    private String name;
    private int initialChatbotCodeLink;
    private List<Chatbot> chatbots;
    private List<RespuestaMensaje> chatHistory;
    private Set<String> usuariosRegistrados;
    private String usuarioLogueadoActualmente;


    public TDASystem(String name, int initialChatbotCodeLink, List<Chatbot> chatbots) {
        this.name = name;
        this.initialChatbotCodeLink = initialChatbotCodeLink;
        this.chatbots = (chatbots != null) ? new ArrayList<>(chatbots) : new ArrayList<>();
        this.chatHistory = new ArrayList<>();
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

    public void systemTalkRec(String message) {
        if (usuarioLogueadoActualmente == null) {
            System.out.println("Error: No hay una sesión activa.");
            return;
        }

        Chatbot chatbotActivo = buscarChatbotActivo(initialChatbotCodeLink);
        if (chatbotActivo == null) {
            System.out.println("Error: No se encontró un chatbot activo.");
            return;
        }

        Flow flowActivo = buscarFlowActivo(chatbotActivo, chatbotActivo.getStartFlowId());
        if (flowActivo == null) {
            System.out.println("Error: No se encontró un flujo activo en el chatbot.");
            return;
        }

        RespuestaMensaje respuesta = procesarMensaje(flowActivo.getOptions(), flowActivo.getNameMsg(), message, usuarioLogueadoActualmente);
        System.out.println("Chatbot responde: " + respuesta);

        chatbotActivo.setStartFlowId(respuesta.getNewFlow());
        this.setInitialChatbotCodeLink(respuesta.getNewChatbot());
        this.chatHistory.add(respuesta);
    }

    private Chatbot buscarChatbotActivo(int code) {
        for (Chatbot chatbot : chatbots) {
            if (chatbot.getChatbotID() == code) {
                return chatbot;
            }
        }
        return null; // No se encontró un chatbot con el código especificado
    }

    private Flow buscarFlowActivo(Chatbot chatbotActivo, int code) {
        for (Flow flow : chatbotActivo.getFlows()) {
            if (flow.getId() == code) {
                return flow;
            }
        }
        return null; // No se encontró un flujo con el código especificado
    }

    public RespuestaMensaje procesarMensaje(List<Option> options, String nameMsg, String input, String user) {
        for (Option option : options) {
            if (option.getKeywords().contains(input) || parseToInt(input) == option.getCode()) {
                return new RespuestaMensaje(user, nameMsg, option.getMessage(),
                        option.getChatbotCodeLink(), option.getInitialFlowCodeLink());
            }
        }
        return new RespuestaMensaje(user, nameMsg, "Opción no encontrada.", -1, -1);
    }

    private int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1; // Si no es un número válido, retorna -1
        }
    }
    // Setters y Getters
    public void setInitialChatbotCodeLink(int initialChatbotCodeLink) {
        this.initialChatbotCodeLink = initialChatbotCodeLink;
    }

    public String getName() {return name;}
    public int getInitialChatbotCodeLink(){ return initialChatbotCodeLink;}
    public List<Chatbot> getChatbots() {return chatbots;}
    public Set<String> getUsuariosRegistrados() {return usuariosRegistrados;}
    public String getUsuarioLogueadoActualmente() {return usuarioLogueadoActualmente;}

}


class RespuestaMensaje {
    private String user;
    private String nameMsg;
    private String message;
    private int newChatbot;
    private int newFlow;

    public RespuestaMensaje(String user, String nameMsg, String message, int newChatbot, int newFlow) {
        this.user = user;
        this.nameMsg = nameMsg;
        this.message = message;
        this.newChatbot = newChatbot;
        this.newFlow = newFlow;
    }

    public String getUser() {
        return user;
    }

    public String getNameMsg() {
        return nameMsg;
    }

    public String getMessage() {
        return message;
    }

    public int getNewChatbot() {
        return newChatbot;
    }

    public int getNewFlow() {
        return newFlow;
    }

}


