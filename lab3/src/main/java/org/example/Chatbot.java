package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Chatbot {
    private int chatbotID;
    private String name;
    private String welcomeMessage;
    private int startFlowId;
    private List<Flow> flows;
    private Set<Integer> flowIds;

    public Chatbot(int chatbotID, String name, String welcomeMessage, int startFlowId, List<Flow> flows) {
        this.chatbotID = chatbotID;
        this.name = name;
        this.welcomeMessage = welcomeMessage;
        this.startFlowId = startFlowId;
        this.flows = new ArrayList<>();
        this.flowIds = new HashSet<>();
        if (flows != null) {
            for (Flow flow : flows) {
                chatbotAddFlow(flow);
            }
        }
    }

    // Método para añadir un flujo, verificando la no duplicación de su ID
    public void chatbotAddFlow(Flow flow) {
        if (flow == null) {
            System.out.println("Error: El flujo es nulo.");
            return;
        }
        // Verifica si el flujo ya existe en el chatbot
        if (!flowIds.contains(flow.getId())) {
            flows.add(flow);
            flowIds.add(flow.getId());
        } else {
            System.out.println("Error: El flujo con el ID " + flow.getId() + " ya existe en el chatbot.");
        }
    }

    // Getters
    public String getName() {return name;}

    public String getWelcomeMessage(){ return welcomeMessage;}
    public int getChatbotID() {
        return chatbotID;
    }

    public int getStartFlowId() {
        return startFlowId;
    }

    public List<Flow> getFlows() {
        // Retorna una copia para evitar la modificación directa de la lista
        return new ArrayList<>(flows);
    }

    // Setters
    public void setStartFlowId(int startFlowId) {
        this.startFlowId = startFlowId;
    }



}

