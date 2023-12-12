package Lab3_20642718_ZengZhong;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * La clase representa un chatbot individual que contiene varios flujos.
 * @author Ka Zeng
 */
public class TDAChatbot_20642718_ZengZhong {
    private int chatbotID;
    private String name;
    private String welcomeMessage;
    private int startFlowId;
    private List<TDAFlow_20642718_ZengZhong> flows;
    private Set<Integer> flowIds;

    /**
     * Constructor para crear un nuevo chatbot.
     *
     * @param chatbotID El ID único del chatbot.
     * @param name El nombre del chatbot.
     * @param welcomeMessage El mensaje de bienvenida del chatbot.
     * @param startFlowId El ID del flujo de inicio del chatbot.
     * @param flows La lista de flujos asociados al chatbot.
     */
    public TDAChatbot_20642718_ZengZhong(int chatbotID, String name, String welcomeMessage, int startFlowId, List<TDAFlow_20642718_ZengZhong> flows) {
        this.chatbotID = chatbotID;
        this.name = name;
        this.welcomeMessage = welcomeMessage;
        this.startFlowId = startFlowId;
        this.flows = new ArrayList<>();
        this.flowIds = new HashSet<>();
        if (flows != null) {
            for (TDAFlow_20642718_ZengZhong flow : flows) {
                chatbotAddFlow(flow);
            }
        }
    }

    /**
     * Añade un flujo al chatbot, verificando que no haya duplicados por ID.
     *
     * @param flow El flujo a añadir al chatbot.
     */
    public void chatbotAddFlow(TDAFlow_20642718_ZengZhong flow) {
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
    /**
     * Obtiene el nombre del chatbot.
     * @return El nombre del chatbot.
     */
    public String getName() {return name;}

    /**
     * Obtiene el mensaje de bienvenida del chatbot.
     * @return El mensaje de bienvenida.
     */
    public String getWelcomeMessage(){ return welcomeMessage;}

    /**
     * Obtiene el ID del chatbot.
     * @return El ID del chatbot.
     */
    public int getChatbotID() {
        return chatbotID;
    }

    /**
     * Obtiene el ID del flujo de inicio del chatbot.
     * @return El ID del flujo de inicio.
     */
    public int getStartFlowId() {
        return startFlowId;
    }

    /**
     * Obtiene la lista de flujos asociados al chatbot.
     * @return Una lista de flujos.
     */
    public List<TDAFlow_20642718_ZengZhong> getFlows() {
        // Retorna una copia para evitar la modificación directa de la lista
        return new ArrayList<>(flows);
    }

    // Setters
    /**
     * Establece el ID del flujo de inicio del chatbot.
     * @param startFlowId El nuevo ID del flujo de inicio.
     */
    public void setStartFlowId(int startFlowId) {
        this.startFlowId = startFlowId;
    }

}

