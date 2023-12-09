package org.example;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static List<Option> opcionesGuardadas = new ArrayList<>();
    private static List<Flow> flujosGuardados = new ArrayList<>();
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
        scanner.close();
    }

    private static void mostrarMenuAdministrador(Scanner scanner) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("### Menú Administrador ###");
            System.out.println("1. Agregar una Opcion");
            System.out.println("2. Agregar un Flujo");
            System.out.println("3. Mostrar Opciones Guardadas");
            System.out.println("4. Mostrar Flujos Guardados");
            System.out.println("5. Salir");
            // ... más opciones para administrador
            System.out.print("Seleccione una opción: ");
            int opcionAdministrador = scanner.nextInt();

            switch (opcionAdministrador) {
                case 1:
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
                    Option option = new Option(code, message, chatbotCodeLink, initialFlowCodeLink, keywords);
                    opcionesGuardadas.add(option);
                    break;

                case 2:

                    System.out.print("Ingrese el código del flujo: ");
                    int idFlow = scanner.nextInt();
                    scanner.nextLine();

                    // Leer el mensaje
                    System.out.print("Ingrese el mensaje del flujo: ");
                    String messageFlow = scanner.nextLine();

                    System.out.print("Ingrese los códigos de las opciones que quiere agregar (separados por comas): ");
                    String opcionesInput = scanner.nextLine();

                    String[] partesOpciones = opcionesInput.split(",");
                    List<Integer> codigosOpciones = new ArrayList<>();

                    // Convertir las cadenas de los códigos a enteros
                    for (String parte : partesOpciones) {
                        try {
                            codigosOpciones.add(Integer.parseInt(parte.trim()));
                        } catch (NumberFormatException e) {
                            System.out.println("Se ha ingresado un código no válido: " + parte.trim());
                            // Manejar el error o continuar
                        }
                    }

                    List<Option> opcionesParaAgregar = new ArrayList<>();
                    // Filtrar las opciones basado en los códigos
                    for (Option opcion : opcionesGuardadas) {
                        if (codigosOpciones.contains(opcion.getCode())) {
                            opcionesParaAgregar.add(opcion);
                        }
                    }

                    Flow flujo = new Flow(idFlow, messageFlow, opcionesParaAgregar);
                    flujosGuardados.add(flujo);
                    break;

                case 3:
                    if (opcionesGuardadas.isEmpty()) {
                        System.out.println("No hay opciones guardadas.");
                    } else {
                        System.out.println("Opciones Guardadas:");
                        for (Option options : opcionesGuardadas) {
                            // Asumiendo que TDAOption tiene métodos getters para acceder a sus atributos
                            System.out.println("-----------------------------------");
                            System.out.println("Código: " + options.getCode());
                            System.out.println("Mensaje: " + options.getMessage());
                            System.out.println("Código de Enlace del Chatbot: " + options.getChatbotCodeLink());
                            System.out.println("Código de Enlace del Flujo Inicial: " + options.getInitialFlowCodeLink());
                            System.out.println("Palabras Clave: " + options.getKeywords());
                            System.out.println("-----------------------------------");
                        }
                    }
                    break;
                case 4:
                    if (flujosGuardados.isEmpty()) {
                        System.out.println("No hay flujos guardados.");
                    } else {
                        System.out.println("Flujos Guardados:");
                        for (Flow flujos : flujosGuardados) {
                            System.out.println("-----------------------------------");
                            System.out.println("ID del Flujo: " + flujos.getId());
                            System.out.println("Mensaje del Flujo: " + flujos.getNameMsg());
                            // Asumiendo que TDAFlow tiene un método para obtener las opciones
                            System.out.println("Opciones del Flujo: ");
                            for (Option opcion : flujos.getOptions()) {
                                System.out.println("\tCódigo de Opción: " + opcion.getCode());
                            }
                            System.out.println("-----------------------------------");
                        }
                    }
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }


    private static void mostrarMenuUsuario(Scanner scanner) {
        System.out.println("### Menú Usuario ###");
        System.out.println("1. Opción de Usuario 1");
        System.out.println("2. Opción de Usuario 2");
        // ... más opciones para usuario normal
        // Implementar la lógica para manejar la elección del usuario
    }
}




