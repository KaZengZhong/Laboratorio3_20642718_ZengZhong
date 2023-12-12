package Lab3_20642718_ZengZhong;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

/**
 * La clase representa un sistema de gestión de chatbots
 * @author Ka Zeng
 */
public class TDASystem_20642718_ZengZhong {
    private String name;
    private int initialChatbotCodeLink;
    private List<TDAChatbot_20642718_ZengZhong> chatbots;
    private List<RespuestaMensaje> chatHistory;
    private Set<String> usuariosRegistrados;
    private String usuarioLogueadoActualmente;

    /**
     * Constructor para crear un nuevo sistema.
     * @param name Nombre del sistema.
     * @param initialChatbotCodeLink Código inicial del chatbot para vincular.
     * @param chatbots Lista de chatbots en el sistema.
     */
    public TDASystem_20642718_ZengZhong(String name, int initialChatbotCodeLink, List<TDAChatbot_20642718_ZengZhong> chatbots) {
        this.name = name;
        this.initialChatbotCodeLink = initialChatbotCodeLink;
        this.chatbots = (chatbots != null) ? new ArrayList<>(chatbots) : new ArrayList<>();
        this.chatHistory = new ArrayList<>();
        this.usuariosRegistrados = new HashSet<>();
        this.usuarioLogueadoActualmente = null;
    }

    /**
     * Agrega un chatbot al sistema si no existe otro con el mismo ID.
     * @param chatbot El chatbot a añadir.
     */
    public void systemAddChatbot(TDAChatbot_20642718_ZengZhong chatbot) {
        if (chatbot == null) {
            System.out.println("Error: El chatbot es nulo.");
            return;
        }
        for (TDAChatbot_20642718_ZengZhong existingChatbot : chatbots) {
            if (existingChatbot.getChatbotID() == chatbot.getChatbotID()) {
                System.out.println("Error: Ya existe un chatbot con el ID " + chatbot.getChatbotID() + " en el sistema.");
                return;
            }
        }
        chatbots.add(chatbot);
    }

    /**
     * Añade un nuevo usuario al sistema si no existe otro con el mismo nombre.
     * @param username Nombre del usuario a añadir.
     */
    public void systemAddUser(String username) {
        if (username != null && !usuariosRegistrados.contains(username)) {
            usuariosRegistrados.add(username);
            System.out.println("Usuario '" + username + "' registrado exitosamente en el sistema.");
        } else {
            System.out.println("Error: No se pudo registrar al usuario '" + username + "'. Puede que el nombre de usuario ya este en uso o sea inválido.");
        }
    }

    /**
     * Permite a un usuario iniciar sesión en el sistema.
     * @param username Nombre del usuario que inicia sesión.
     * @return true si la sesión se inició con éxito, false en caso contrario.
     */
    public boolean systemLogin(String username) {
        if (username == null || !usuariosRegistrados.contains(username)) {
            System.out.println("Error: Usuario no registrado o nombre de usuario invalido.");
            return false;
        }
        if (usuarioLogueadoActualmente != null) {
            System.out.println("Error: Ya hay una sesion activa con otro usuario.");
            return false;
        }
        usuarioLogueadoActualmente = username;
        System.out.println("Usuario '" + username + "' ha iniciado sesion exitosamente.");
        return true;
    }

    /**
     * Cierra la sesión activa de un usuario.
     */
    public void systemLogout() {
        if (usuarioLogueadoActualmente != null) {
            System.out.println("Usuario '" + usuarioLogueadoActualmente + "' ha cerrado su sesion.");
            usuarioLogueadoActualmente = null;
        } else {
            System.out.println("No hay ninguna sesion activa para cerrar.");
        }
    }

    /**
     * Procesa un mensaje enviado por un usuario, interactuando con el chatbot y flujo activos.
     * @param message Mensaje del usuario.
     */
    public void systemTalkRec(String message) {
        if (usuarioLogueadoActualmente == null) {
            System.out.println("Error: No hay una sesion activa.");
            return;
        }

        TDAChatbot_20642718_ZengZhong chatbotActivo = buscarChatbotActivo(initialChatbotCodeLink);
        if (chatbotActivo == null) {
            System.out.println("Error: No se encontró un chatbot activo.");
            return;
        }
        System.out.println("Chatbot encontrado: " + chatbotActivo.getName());


        TDAFlow_20642718_ZengZhong flowActivo = buscarFlowActivo(chatbotActivo, chatbotActivo.getStartFlowId());
        if (flowActivo == null) {
            System.out.println("Error: No se encontró un flujo activo en el chatbot.");
            return;
        }
        System.out.println("Flujo encontrado: " + flowActivo.getNameMsg());

        RespuestaMensaje respuesta = procesarMensaje(flowActivo.getOptions(), message,
                usuarioLogueadoActualmente, chatbotActivo, flowActivo);
        System.out.println("Mensaje encontrado: " + respuesta.getMessage());

        chatbotActivo.setStartFlowId(respuesta.getNewFlow());
        this.setInitialChatbotCodeLink(respuesta.getNewChatbot());
        this.chatHistory.add(respuesta);
    }

    /**
     * Busca un chatbot activo en la lista de chatbots basándose en su ID.
     * @param code El código del chatbot a buscar.
     * @return El chatbot encontrado o null si no se encuentra.
     */
    private TDAChatbot_20642718_ZengZhong buscarChatbotActivo(int code) {
        for (TDAChatbot_20642718_ZengZhong chatbot : chatbots) {
            if (chatbot.getChatbotID() == code) {
                return chatbot;
            }
        }
        return null; // No se encontró un chatbot con el código especificado
    }

    /**
     * Busca un flujo activo dentro de un chatbot específico.
     * @param chatbotActivo El chatbot en el cual buscar el flujo.
     * @param code El código del flujo a buscar.
     * @return El flujo encontrado o null si no se encuentra.
     */
    private TDAFlow_20642718_ZengZhong buscarFlowActivo(TDAChatbot_20642718_ZengZhong chatbotActivo, int code) {
        for (TDAFlow_20642718_ZengZhong flow : chatbotActivo.getFlows()) {
            if (flow.getId() == code) {
                return flow;
            }
        }
        return null; // No se encontró un flujo con el código especificado
    }

    /**
     * Procesa el mensaje ingresado y genera una respuesta.
     * @param options Opciones disponibles en el flujo actual.
     * @param input Entrada del usuario.
     * @param user Usuario que envía el mensaje.
     * @param chatbotName Nombre del chatbot activo.
     * @param flowName Nombre del flujo activo.
     * @return Respuesta generada.
     */
    public RespuestaMensaje procesarMensaje(List<TDAOption_20642718_ZengZhong> options, String input, String user,
                                            TDAChatbot_20642718_ZengZhong chatbotName, TDAFlow_20642718_ZengZhong flowName) {
        for (TDAOption_20642718_ZengZhong option : options) {
            if (option.getKeywords().contains(input) || parseToInt(input) == option.getCode()) {
                return new RespuestaMensaje(user, option.getMessage(),
                        option.getChatbotCodeLink(), option.getInitialFlowCodeLink(),
                        chatbotName.getName(), flowName.getNameMsg());
            }
        }
        return new RespuestaMensaje(user, "Opción no encontrada.", chatbotName.getChatbotID(),
                flowName.getId(), chatbotName.getName(), flowName.getNameMsg());
    }

    /**
     * Convierte un string a entero, devolviendo -1 si no es posible.
     * @param input Cadena a convertir.
     * @return Entero convertido o -1 si falla.
     */
    private int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Muestra el historial de chat del sistema.
     */
    public void systemSynthesis() {
        if (chatHistory.isEmpty()) {
            System.out.println("El historial de chat está vacío.");
        } else {
            System.out.println("Historial de Chat:");
            for (RespuestaMensaje respuesta : chatHistory) {
                System.out.println("-----------------------------------");
                System.out.println("Usuario: " + respuesta.getUser());
                System.out.println("Chatbot: " + respuesta.getChatbotName());
                System.out.println("Flujo: " + respuesta.getFlowName());
                System.out.println("Respuesta: " + respuesta.getMessage());
                System.out.println("-----------------------------------");
            }
        }
    }

    // Getters
    /**
     * Obtiene el nombre del sistema.
     * @return El nombre del sistema.
     */
    public String getName() {return name;}
    /**
     * Obtiene el código inicial del chatbot vinculado al sistema.
     * @return El código inicial del chatbot.
     */
    public int getInitialChatbotCodeLink(){ return initialChatbotCodeLink;}
    /**
     * Obtiene la lista de chatbots en el sistema.
     * @return La lista de chatbots.
     */
    public List<TDAChatbot_20642718_ZengZhong> getChatbots() {return chatbots;}
    /**
     * Obtiene el conjunto de nombres de usuarios registrados en el sistema.
     * @return El conjunto de usuarios registrados.
     */
    public Set<String> getUsuariosRegistrados() {return usuariosRegistrados;}
    /**
     * Obtiene el nombre del usuario actualmente logueado en el sistema.
     * @return El nombre del usuario logueado.
     */
    public String getUsuarioLogueadoActualmente() {return usuarioLogueadoActualmente;}

    // Setters
    /**
     * Establece el código inicial del chatbot vinculado al sistema.
     * @param initialChatbotCodeLink El código del chatbot a establecer.
     */
    public void setInitialChatbotCodeLink(int initialChatbotCodeLink) {this.initialChatbotCodeLink = initialChatbotCodeLink;}
}

/**
 * Clase que representa una respuesta generada en el contexto de un chatbot y un flujo específicos.
 */
class RespuestaMensaje {
    private String user;
    private String message;
    private int newChatbot;
    private int newFlow;
    private String chatbotName;
    private String flowName;

    /**
     * Constructor de RespuestaMensaje.
     * @param user El usuario que envía el mensaje.
     * @param message El mensaje de respuesta.
     * @param newChatbot El ID del nuevo chatbot activo tras la respuesta.
     * @param newFlow El ID del nuevo flujo activo tras la respuesta.
     * @param chatbotName El nombre del chatbot activo.
     * @param flowName El nombre del flujo activo.
     */
    public RespuestaMensaje(String user, String message, int newChatbot, int newFlow, String chatbotName, String flowName){
        this.user = user;
        this.message = message;
        this.newChatbot = newChatbot;
        this.newFlow = newFlow;
        this.chatbotName = chatbotName;
        this.flowName = flowName;
    }

    // Getters
    /**
     * Obtiene el usuario que envió el mensaje.
     * @return El nombre del usuario.
     */
    public String getUser() {
        return user;
    }
    /**
     * Obtiene el mensaje de respuesta.
     * @return El mensaje de respuesta.
     */
    public String getMessage() {
        return message;
    }
    /**
     * Obtiene el ID del nuevo chatbot activo.
     * @return El ID del chatbot.
     */
    public int getNewChatbot() {
        return newChatbot;
    }
    /**
     * Obtiene el ID del nuevo flujo activo.
     * @return El ID del flujo.
     */
    public int getNewFlow() {
        return newFlow;
    }
    /**
     * Obtiene el nombre del chatbot activo.
     * @return El nombre del chatbot.
     */
    public String getChatbotName() {return chatbotName;}
    /**
     * Obtiene el nombre del flujo activo.
     * @return El nombre del flujo.
     */
    public String getFlowName() {return flowName;}
}


