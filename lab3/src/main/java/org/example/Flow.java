package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Flow {
    private int id;
    private String nameMsg;
    private List<Option> options;
    private Set<Integer> optionIds;

    public Flow(int id, String nameMsg, List<Option> options) {
        this.id = id;
        this.nameMsg = nameMsg;
        this.optionIds = new HashSet<>();

        this.options = new ArrayList<>();
        if (options != null) {
            for (Option option : options) {
                flowAddOption(option);
            }
        }
    }

    public void flowAddOption(Option option) {
        if (option == null) {
            System.out.println("Error: La opción es nula.");
            return;
        }

        // Verifica si la opción ya existe en el flujo
        if (!optionIds.contains(option.getCode())) {
            options.add(option);
            optionIds.add(option.getCode());
        } else {
            System.out.println("Error: La opción con el código " + option.getCode() + " ya existe en el flujo.");
        }
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMsg() {
        return nameMsg;
    }

    public void setNameMsg(String nameMsg) {
        this.nameMsg = nameMsg;
    }

    public List<Option> getOptions() {
        return new ArrayList<>(options);
    }

    public void setOptions(List<Option> options) {
        this.options = new ArrayList<>(options);
    }

}

