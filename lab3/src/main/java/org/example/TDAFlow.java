package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TDAFlow {
    private int id;
    private String nameMsg;
    private List<TDAOption> options;

    // Constructor
    public TDAFlow(int id, String nameMsg, List<TDAOption> options) {
        this.id = id;
        this.nameMsg = nameMsg;
        this.options = new ArrayList<>();

        // Asegurar que las opciones no se repitan
        Set<Integer> uniqueOptionIds = new HashSet<>();
        for (TDAOption option : options) {
            if (uniqueOptionIds.add(option.getCode())) {
                this.options.add(option);
            }
        }
    }

    public void addOption(TDAOption option) {
        for (TDAOption existingOption : options) {
            if (existingOption.getCode() == option.getCode()) {
                System.out.println("No se puede agregar la opción: ya existe una opción con el código " + option.getCode());
                return; // Salimos del método si encontramos una opción duplicada
            }
        }
        options.add(option); // Agregamos la opción si no se encontraron duplicados
    }


    // Getters y posibles setters
    public int getId() {
        return id;
    }

    public String getNameMsg() {
        return nameMsg;
    }

    public List<TDAOption> getOptions() {
        return options;
    }

    // Otros métodos relacionados con la clase Flow
}
