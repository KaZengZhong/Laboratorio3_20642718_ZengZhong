package Lab3_20642718_ZengZhong;

import java.util.List;

/**
 * La clase representa una opción dentro de un flujo de chatbot.
 * @author Ka Zeng
 */
public class TDAOption_20642718_ZengZhong {
    private int code;
    private String message;
    private int chatbotCodeLink;
    private int initialFlowCodeLink;
    private List<String> keywords;

    /**
     * Constructor para crear una nueva opción.
     *
     * @param code El código único de la opción.
     * @param message El mensaje asociado a la opción.
     * @param chatbotCodeLink El código del chatbot al que está vinculada esta opción.
     * @param initialFlowCodeLink El código del flujo inicial al que está vinculada esta opción.
     * @param keywords Lista de palabras clave asociadas a esta opción.
     */
    public TDAOption_20642718_ZengZhong(int code, String message, int chatbotCodeLink, int initialFlowCodeLink, List<String> keywords) {
        this.code = code;
        this.message = message;
        this.chatbotCodeLink = chatbotCodeLink;
        this.initialFlowCodeLink = initialFlowCodeLink;
        this.keywords = keywords;
    }

    // Getters
    /**
     * Obtiene el código de la opción.
     * @return El código de la opción.
     */
    public int getCode() {
        return code;
    }

    /**
     * Obtiene el mensaje de la opción.
     * @return El mensaje asociado a la opción.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Obtiene el código de enlace del chatbot.
     * @return El código del chatbot asociado a esta opción.
     */
    public int getChatbotCodeLink() {
        return chatbotCodeLink;
    }

    /**
     * Obtiene el código de enlace del flujo inicial.
     * @return El código del flujo inicial asociado a esta opción.
     */
    public int getInitialFlowCodeLink() {
        return initialFlowCodeLink;
    }

    /**
     * Obtiene la lista de palabras clave asociadas a la opción.
     * @return Una lista de palabras clave.
     */
    public List<String> getKeywords() {
        return keywords;
    }
}



