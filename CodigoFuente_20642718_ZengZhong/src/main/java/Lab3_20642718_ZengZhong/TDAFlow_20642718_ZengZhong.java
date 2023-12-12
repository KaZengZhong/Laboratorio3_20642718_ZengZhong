package Lab3_20642718_ZengZhong;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * La clase representa un flujo en un chatbot.
 * @author Ka Zeng
 */
public class TDAFlow_20642718_ZengZhong {
    private int id;
    private String nameMsg;
    private List<TDAOption_20642718_ZengZhong> options;
    private Set<Integer> optionIds;

    /**
     * Constructor para crear un nuevo flujo.
     *
     * @param id El ID único del flujo.
     * @param nameMsg El mensaje o nombre asociado al flujo.
     * @param options La lista de opciones que componen el flujo.
     */
    public TDAFlow_20642718_ZengZhong(int id, String nameMsg, List<TDAOption_20642718_ZengZhong> options) {
        this.id = id;
        this.nameMsg = nameMsg;
        this.optionIds = new HashSet<>();
        this.options = new ArrayList<>();
        if (options != null) {
            for (TDAOption_20642718_ZengZhong option : options) {
                flowAddOption(option);
            }
        }
    }

    /**
     * Añade una opción al flujo, verificando que no esté duplicada.
     *
     * @param option La opción a añadir al flujo.
     */
    public void flowAddOption(TDAOption_20642718_ZengZhong option) {
        if (option == null) {
            System.out.println("Error: La opcion es nula.");
            return;
        }
        // Verifica si la opción ya existe en el flujo
        if (!optionIds.contains(option.getCode())) {
            options.add(option);
            optionIds.add(option.getCode());
        } else {
            System.out.println("Error: La opcion con el código " + option.getCode() + " ya existe en el flujo.");
        }
    }

    // Getters
    /**
     * Obtiene el ID del flujo.
     * @return El ID del flujo.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el mensaje o nombre del flujo.
     * @return El mensaje o nombre del flujo.
     */
    public String getNameMsg() {
        return nameMsg;
    }

    /**
     * Obtiene la lista de opciones del flujo.
     * @return Una lista de objetos Option.
     */
    public List<TDAOption_20642718_ZengZhong> getOptions() {
        return new ArrayList<>(options);
    }
}

