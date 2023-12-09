package org.example;

import java.util.HashSet;
import java.util.Set;

public class Usuario {
    private String username;
    private static final Set<String> usuariosRegistrados = new HashSet<>();
    private static final Set<String> usuariosLogueados = new HashSet<>();

    public Usuario(String username) {
        // Verifica la unicidad en el momento de la creación del usuario
        if (username == null || usuariosRegistrados.contains(username)) {
            this.username = null; // Indica un estado inválido o no registrado
        } else {
            this.username = username;
            usuariosRegistrados.add(username);
        }
    }

    public boolean iniciarSesion() {
        if (this.username != null && !usuariosLogueados.contains(this.username)) {
            usuariosLogueados.add(this.username);
            return true;
        }
        return false;
    }

    public boolean cerrarSesion() {
        return usuariosLogueados.remove(this.username);
    }

    // Getters y Setters
    public String getUsername() {
        return username;
    }

    public boolean setUsername(String username) {
        if (username != null && !usuariosRegistrados.contains(username)) {
            usuariosRegistrados.remove(this.username);
            if (usuariosLogueados.contains(this.username)) {
                usuariosLogueados.remove(this.username);
            }
            this.username = username;
            usuariosRegistrados.add(username);
            return true;
        }
        return false;
    }

    // Métodos estáticos para verificar si un usuario está registrado o logueado
    public static boolean esUsuarioRegistrado(String username) {
        return usuariosRegistrados.contains(username);
    }

    public static boolean esUsuarioLogueado(String username) {
        return usuariosLogueados.contains(username);
    }
}






