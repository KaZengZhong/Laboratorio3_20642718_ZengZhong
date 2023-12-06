package org.example;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese su nombre
        System.out.print("Ingrese el nombre de usuario: ");
        String username = scanner.nextLine();

        // Pedir al usuario que seleccione su tipo (administrador o usuario normal)
        System.out.println("Seleccione el tipo de usuario:");
        System.out.println("1. Administrador");
        System.out.println("2. Usuario Normal");
        System.out.print("Ingrese su opción (1 o 2): ");
        int tipoUsuario = scanner.nextInt();

        // Limpiar el buffer de entrada
        scanner.nextLine();

        // Lógica para mostrar el menú correspondiente
        if (tipoUsuario == 1) {
            // Usuario es administrador
            System.out.println("Bienvenido " + username + ". Usted es un administrador.");
            mostrarMenuAdministrador(scanner);
        } else if (tipoUsuario == 2) {
            // Usuario normal
            System.out.println("Bienvenido " + username + ".");
            mostrarMenuUsuario(scanner);
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private static void mostrarMenuAdministrador(Scanner scanner) {
        System.out.println("### Menú Administrador ###");
        System.out.println("1. Agregar un Chatbot");
        System.out.println("2. Modificar un Chatbot");
        // ... más opciones para administrador
        int opcionAdministrador = scanner.nextInt();

        if (opcionAdministrador == 1) {
            // Leer el código de la opción
            System.out.print("Ingrese el código de la opción: ");
            int code = scanner.nextInt();

            // Limpiar el buffer de entrada (importante después de leer números)
            scanner.nextLine();

            // Leer el mensaje
            System.out.print("Ingrese el mensaje de la opción: ");
            String message = scanner.nextLine();

            // Leer el código de enlace del chatbot
            System.out.print("Ingrese el código de enlace del chatbot: ");
            int chatbotCodeLink = scanner.nextInt();

            // Leer el código de enlace del flujo inicial
            System.out.print("Ingrese el código de enlace del flujo inicial: ");
            int initialFlowCodeLink = scanner.nextInt();

            // Limpiar el buffer de entrada
            scanner.nextLine();

            // Leer palabras clave (separadas por comas)
            System.out.print("Ingrese palabras clave (separadas por comas): ");
            String keywordsInput = scanner.nextLine();
            List<String> keywords = Arrays.asList(keywordsInput.split(","));

            // Crear la instancia de Option
            TDAOption option = new TDAOption(code, message, chatbotCodeLink, initialFlowCodeLink, keywords);

            // Mostrar los valores ingresados
            System.out.println("Option creada:");
            System.out.println("Código: " + option.getCode());
            System.out.println("Mensaje: " + option.getMessage());
            System.out.println("Código de Enlace del Chatbot: " + option.getChatbotCodeLink());
            System.out.println("Código de Enlace del Flujo Inicial: " + option.getInitialFlowCodeLink());
            System.out.println("Palabras Clave: " + option.getKeywords());
        }



        // Implementar la lógica para manejar la elección del administrador
    }

    private static void mostrarMenuUsuario(Scanner scanner) {
        System.out.println("### Menú Usuario ###");
        System.out.println("1. Opción de Usuario 1");
        System.out.println("2. Opción de Usuario 2");
        // ... más opciones para usuario normal
        // Implementar la lógica para manejar la elección del usuario
    }
}




