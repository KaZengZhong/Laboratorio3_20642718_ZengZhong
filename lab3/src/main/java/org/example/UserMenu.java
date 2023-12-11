package org.example;

import java.util.Scanner;
import java.util.Set;

public class UserMenu {
    public static void mostrarMenuUsuario(Scanner scanner) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("### Menú Usuario ###");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Cerrar Sesión");
            System.out.println("4. Ver usuarios registrados");
            System.out.println("5. Ver usuario logueado");
            System.out.println("6. Interactuar con un chatbot");
            System.out.println("7. Ver el historial del chat");
            System.out.println("8. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    anadirUsuarioASistema(scanner);
                    break;
                case 2:
                    iniciarSesionEnSistema(scanner);
                    break;
                case 3:
                    cerrarSesionEnSistema(scanner);
                    break;
                case 4:
                    verUsuariosRegistrados(scanner);
                    break;
                case 5:
                    verUsuarioLogueado(scanner);
                    break;
                case 8:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }


    private static void anadirUsuarioASistema(Scanner scanner) {
        System.out.print("Ingrese el nombre del sistema al que desea añadir un usuario: ");
        String nombreSistema = scanner.nextLine();

        TDASystem sistemaEncontrado = AdminMenu.buscarSistemaPorNombre(nombreSistema);
        if (sistemaEncontrado == null) {
            System.out.println("No se encontró un sistema con el nombre: " + nombreSistema);
            return;
        }

        System.out.print("Ingrese el nombre de usuario a registrar: ");
        String nombreUsuario = scanner.nextLine();

        if (sistemaEncontrado.getUsuariosRegistrados().contains(nombreUsuario)) {
            System.out.println("El usuario '" + nombreUsuario + "' ya está registrado en el sistema.");
        } else {
            sistemaEncontrado.systemAddUser(nombreUsuario);
            System.out.println("Usuario '" + nombreUsuario + "' registrado exitosamente en el sistema.");
        }
    }

    private static void iniciarSesionEnSistema(Scanner scanner) {
        System.out.print("Ingrese el nombre del sistema en el que desea iniciar sesión: ");
        String nombreSistema = scanner.nextLine();

        TDASystem sistemaEncontrado = AdminMenu.buscarSistemaPorNombre(nombreSistema);
        if (sistemaEncontrado == null) {
            System.out.println("No se encontró un sistema con el nombre: " + nombreSistema);
            return;
        }

        System.out.print("Ingrese su nombre de usuario para iniciar sesión: ");
        String nombreUsuario = scanner.nextLine();

        if (sistemaEncontrado.getUsuariosRegistrados().contains(nombreUsuario)) {
            if (sistemaEncontrado.getUsuarioLogueadoActualmente() == null || sistemaEncontrado.getUsuarioLogueadoActualmente().isEmpty()) {
                sistemaEncontrado.systemLogin(nombreUsuario);
                System.out.println("Usuario '" + nombreUsuario + "' ha iniciado sesión en el sistema.");
            } else {
                System.out.println("Ya hay una sesión activa con el usuario '" + sistemaEncontrado.getUsuarioLogueadoActualmente() + "'.");
            }
        } else {
            System.out.println("El usuario '" + nombreUsuario + "' no está registrado en el sistema.");
        }
    }

    private static void cerrarSesionEnSistema(Scanner scanner) {
        System.out.print("Ingrese el nombre del sistema en el que desea cerrar sesión: ");
        String nombreSistema = scanner.nextLine();

        TDASystem sistemaEncontrado = AdminMenu.buscarSistemaPorNombre(nombreSistema);
        if (sistemaEncontrado == null) {
            System.out.println("No se encontró un sistema con el nombre: " + nombreSistema);
            return;
        }

        if (sistemaEncontrado.getUsuarioLogueadoActualmente() != null) {
            System.out.println("Usuario '" + sistemaEncontrado.getUsuarioLogueadoActualmente() + "' ha cerrado su sesión.");
            sistemaEncontrado.systemLogout();
        } else {
            System.out.println("No hay ninguna sesión activa para cerrar en el sistema.");
        }
    }

    private static void verUsuariosRegistrados(Scanner scanner) {
        System.out.print("Ingrese el nombre del sistema para ver los usuarios registrados: ");
        String nombreSistema = scanner.nextLine();

        TDASystem sistemaEncontrado = AdminMenu.buscarSistemaPorNombre(nombreSistema);
        if (sistemaEncontrado == null) {
            System.out.println("No se encontró un sistema con el nombre: " + nombreSistema);
            return;
        }

        Set<String> usuariosRegistrados = sistemaEncontrado.getUsuariosRegistrados();
        if (usuariosRegistrados.isEmpty()) {
            System.out.println("No hay usuarios registrados en el sistema.");
        } else {
            System.out.println("Usuarios Registrados en el sistema '" + nombreSistema + "':");
            for (String usuario : usuariosRegistrados) {
                System.out.println(" - " + usuario);
            }
        }
    }


    private static void verUsuarioLogueado(Scanner scanner) {
        System.out.print("Ingrese el nombre del sistema para ver el usuario logueado: ");
        String nombreSistema = scanner.nextLine();

        TDASystem sistemaEncontrado = AdminMenu.buscarSistemaPorNombre(nombreSistema);
        if (sistemaEncontrado == null) {
            System.out.println("No se encontró un sistema con el nombre: " + nombreSistema);
            return;
        }

        String usuarioLogueado = sistemaEncontrado.getUsuarioLogueadoActualmente();
        if (usuarioLogueado == null || usuarioLogueado.isEmpty()) {
            System.out.println("No hay ningún usuario logueado en el sistema.");
        } else {
            System.out.println("Usuario logueado en el sistema '" + nombreSistema + "': " + usuarioLogueado);
        }
    }


}


