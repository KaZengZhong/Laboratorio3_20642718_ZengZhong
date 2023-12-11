package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {

    public static void mostrarMenuAdministrador(Scanner scanner) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("### Menú Adminitrador ###");
            System.out.println("1. Crear Opcion");
            System.out.println("2. Crear Flujo");
            System.out.println("3. Agregar Opciones a Flujo");
            System.out.println("4. Crear Chatbot");
            System.out.println("5. Agregar Flujos a Chatbot");
            System.out.println("6. Crear Sistema");
            System.out.println("7. Agregar Chatbots a Sistema");
            System.out.println("8. Mostrar Opciones Guardadas");
            System.out.println("9. Mostrar Flujos Guardados");
            System.out.println("10. Mostrar Chatbots Guardados");
            System.out.println("11. Mostrar Sistemas Guardados");
            System.out.println("12. Volver a Menu Principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarOpcion(scanner);
                    break;
                case 2:
                    agregarFlujo(scanner);
                    break;
                case 3:
                    agregarOpcionAFlujo(scanner);
                    break;
                case 4:
                    agregarChatbot(scanner);
                    break;
                case 5:
                    anadirFlujosAChatbot(scanner);
                    break;
                case 6:
                    crearSistema(scanner);
                    break;
                case 7:
                    anadirChatbotASistema(scanner);
                    break;
                case 8:
                    mostrarOpcionesGuardadas();
                    break;
                case 9:
                    mostrarFlujosGuardados();
                    break;
                case 10:
                    mostrarChatbotsGuardados();
                    break;
                case 11:
                    mostrarSistemasCreados();
                    break;
                case 12:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }



    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static Option buscarOpcionPorCodigo(int codigo) {
        for (Option opcion : Main.opcionesGuardadas) {
            if (opcion.getCode() == codigo) {
                return opcion;
            }
        }
        return null;
    }

    private static Flow buscarFlujoPorId(int id) {
        for (Flow flujo : Main.flujosGuardados) {
            if (flujo.getId() == id) {
                return flujo;
            }
        }
        return null;
    }

    private static Chatbot buscarChatbotPorId(int id) {
        for (Chatbot chatbot : Main.chatbotsGuardados) {
            if (chatbot.getChatbotID() == id) {
                return chatbot;
            }
        }
        return null;
    }

    public static TDASystem buscarSistemaPorNombre(String nombre) {
        for (TDASystem sistema : Main.sistemasGuardados) {
            if (sistema.getName().equals(nombre)) {
                return sistema;
            }
        }
        return null;
    }





    private static void agregarOpcion(Scanner scanner) {
        System.out.print("Ingrese el código de la opción: ");
        int code = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el mensaje de la opción: ");
        String message = scanner.nextLine();
        System.out.print("Ingrese el código de enlace del chatbot: ");
        int chatbotCodeLink = scanner.nextInt();
        System.out.print("Ingrese el código de enlace del flujo inicial: ");
        int initialFlowCodeLink = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese palabras clave (separadas por comas): ");
        String keywordsInput = scanner.nextLine();
        List<String> keywords = Arrays.asList(keywordsInput.split(","));
        Option option = new Option(code, message, chatbotCodeLink, initialFlowCodeLink, keywords);
        Main.opcionesGuardadas.add(option);
    }


    private static void agregarFlujo(Scanner scanner) {
        System.out.print("Ingrese el ID del flujo: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el mensaje del flujo: ");
        String nameMsg = scanner.nextLine();
        System.out.print("Ingrese los códigos de las opciones para este flujo (separados por comas): ");
        String opcionesInput = scanner.nextLine();
        List<Option> opcionesParaFlujo = new ArrayList<>();
        String[] codigosOpciones = opcionesInput.split(",");
        for (String codigo : codigosOpciones) {
            if (isNumeric(codigo.trim())) {
                int codigoOpcion = Integer.parseInt(codigo.trim());
                Option opcionEncontrada = buscarOpcionPorCodigo(codigoOpcion);
                if (opcionEncontrada != null) {
                    opcionesParaFlujo.add(opcionEncontrada);
                } else {
                    System.out.println("No se encontró una opción con el código: " + codigoOpcion);
                }
            } else {
                System.out.println("Código inválido: " + codigo.trim());
            }
        }
        Flow nuevoFlujo = new Flow(id, nameMsg, opcionesParaFlujo);
        Main.flujosGuardados.add(nuevoFlujo);
        System.out.println("Flujo agregado exitosamente.");
    }


    private static void agregarOpcionAFlujo(Scanner scanner) {
        System.out.print("Ingrese el ID del flujo: ");
        int idFlujo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        System.out.print("Ingrese el código de la opción a agregar: ");
        int codigoOpcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        // Buscar el flujo y la opción
        Flow flujo = buscarFlujoPorId(idFlujo);
        Option opcion = buscarOpcionPorCodigo(codigoOpcion);

        if (flujo != null && opcion != null) {
            // Agregar la opción al flujo
            flujo.flowAddOption(opcion);
            System.out.println("Opción agregada al flujo exitosamente.");
        } else {
            System.out.println("Flujo o opción no encontrados.");
        }
    }

    private static void agregarChatbot(Scanner scanner) {
        System.out.print("Ingrese el ID del chatbot: ");
        int chatbotID = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        System.out.print("Ingrese el nombre del chatbot: ");
        String name = scanner.nextLine();

        System.out.print("Ingrese el mensaje de bienvenida del chatbot: ");
        String welcomeMessage = scanner.nextLine();

        System.out.print("Ingrese el ID del flujo de inicio del chatbot: ");
        int startFlowId = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        // Leer los IDs de los flujos asociados al chatbot (separados por comas)
        System.out.print("Ingrese los IDs de los flujos para este chatbot (separados por comas): ");
        String flujosInput = scanner.nextLine();

        List<Flow> flujosParaChatbot = new ArrayList<>();
        String[] idsFlujos = flujosInput.split(",");

        for (String idFlujo : idsFlujos) {
            int id = Integer.parseInt(idFlujo.trim());
            Flow flujoEncontrado = buscarFlujoPorId(id);
            if (flujoEncontrado != null) {
                flujosParaChatbot.add(flujoEncontrado);
            } else {
                System.out.println("No se encontró un flujo con el ID: " + id);
            }
        }

        Chatbot nuevoChatbot = new Chatbot(chatbotID, name, welcomeMessage, startFlowId, flujosParaChatbot);
        Main.chatbotsGuardados.add(nuevoChatbot);
        System.out.println("Chatbot agregado exitosamente.");
    }

    // ----------------------------------------------------------------------------------------------
    private static void anadirFlujosAChatbot(Scanner scanner) {
        System.out.print("Ingrese el ID del chatbot al que desea añadir flujos: ");
        int chatbotID = scanner.nextInt();
        scanner.nextLine();

        Chatbot chatbotEncontrado = buscarChatbotPorId(chatbotID);
        if (chatbotEncontrado == null) {
            System.out.println("No se encontró un chatbot con el ID: " + chatbotID);
            return;
        }

        System.out.print("Ingrese los IDs de los flujos a añadir (separados por comas): ");
        String flujosInput = scanner.nextLine();
        String[] idsFlujos = flujosInput.split(",");

        for (String idFlujo : idsFlujos) {
            int id = Integer.parseInt(idFlujo.trim());
            Flow flujoEncontrado = buscarFlujoPorId(id);
            if (flujoEncontrado != null) {
                chatbotEncontrado.chatbotAddFlow(flujoEncontrado);
            } else {
                System.out.println("No se encontró un flujo con el ID: " + id);
            }
        }

        System.out.println("Flujos añadidos al chatbot exitosamente.");
    }


    private static void crearSistema(Scanner scanner) {
        System.out.print("Ingrese el nombre del sistema: ");
        String nombreSistema = scanner.nextLine();

        System.out.print("Ingrese el código inicial del chatbot para el sistema: ");
        int codigoInicialChatbot = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer de entrada

        // Crear una lista de chatbots para el sistema
        List<Chatbot> chatbotsParaSistema = new ArrayList<>();

        // Leer los IDs de los chatbots a incluir en el sistema (separados por comas)
        System.out.print("Ingrese los IDs de los chatbots para este sistema (separados por comas): ");
        String chatbotsInput = scanner.nextLine();
        String[] idsChatbots = chatbotsInput.split(",");

        for (String idChatbot : idsChatbots) {
            int id = Integer.parseInt(idChatbot.trim());
            Chatbot chatbotEncontrado = buscarChatbotPorId(id);
            if (chatbotEncontrado != null) {
                chatbotsParaSistema.add(chatbotEncontrado);
            } else {
                System.out.println("No se encontró un chatbot con el ID: " + id);
            }
        }

        TDASystem nuevoSistema = new TDASystem(nombreSistema, codigoInicialChatbot, chatbotsParaSistema);
        Main.sistemasGuardados.add(nuevoSistema);
        System.out.println("Sistema creado exitosamente.");
    }

    private static void anadirChatbotASistema(Scanner scanner) {
        System.out.print("Ingrese el nombre del sistema al que desea añadir un chatbot: ");
        String nombreSistema = scanner.nextLine();

        TDASystem sistemaEncontrado = buscarSistemaPorNombre(nombreSistema);
        if (sistemaEncontrado == null) {
            System.out.println("No se encontró un sistema con el nombre: " + nombreSistema);
            return;
        }

        System.out.print("Ingrese el ID del chatbot a añadir: ");
        int idChatbot = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer de entrada

        Chatbot chatbotEncontrado = buscarChatbotPorId(idChatbot);
        if (chatbotEncontrado == null) {
            System.out.println("No se encontró un chatbot con el ID: " + idChatbot);
            return;
        }

        sistemaEncontrado.systemAddChatbot(chatbotEncontrado);
        System.out.println("Chatbot añadido al sistema exitosamente.");
    }

    // ----------------------------------------------------------------------------------------------
    private static void mostrarOpcionesGuardadas() {
        if (Main.opcionesGuardadas.isEmpty()) {
            System.out.println("No hay opciones guardadas.");
        } else {
            System.out.println("Opciones Guardadas:");
            for (Option options : Main.opcionesGuardadas) {
                System.out.println("-----------------------------------");
                System.out.println("Código: " + options.getCode());
                System.out.println("Mensaje: " + options.getMessage());
                System.out.println("Código de Enlace del Chatbot: " + options.getChatbotCodeLink());
                System.out.println("Código de Enlace del Flujo Inicial: " + options.getInitialFlowCodeLink());
                System.out.println("Palabras Clave: " + options.getKeywords());
                System.out.println("-----------------------------------");
            }
        }
    }

    // ----------------------------------------------------------------------------------------------
    private static void mostrarFlujosGuardados() {
        if (Main.flujosGuardados.isEmpty()) {
            System.out.println("No hay flujos guardados.");
        } else {
            System.out.println("Flujos Guardados:");
            for (Flow flujos : Main.flujosGuardados) {
                System.out.println("-----------------------------------");
                System.out.println("ID del Flujo: " + flujos.getId());
                System.out.println("Mensaje del Flujo: " + flujos.getNameMsg());
                System.out.println("Opciones guardadas: ");
                for (Option opcion : flujos.getOptions()) {
                    System.out.println(" " + opcion.getMessage());
                }
                System.out.println("-----------------------------------");
            }
        }
    }

    private static void mostrarChatbotsGuardados() {
        if (Main.chatbotsGuardados.isEmpty()) {
            System.out.println("No hay chatbots guardados.");
        } else {
            System.out.println("Chatbots Guardados:");
            for (Chatbot chatbot : Main.chatbotsGuardados) {
                System.out.println("-----------------------------------");
                System.out.println("ID del Chatbot: " + chatbot.getChatbotID());
                System.out.println("Nombre: " + chatbot.getName());
                System.out.println("Mensaje de Bienvenida: " + chatbot.getWelcomeMessage());
                System.out.println("ID del Flujo Inicial: " + chatbot.getStartFlowId());
                System.out.println("Flujos asociados:");
                for (Flow flujo : chatbot.getFlows()) {
                    System.out.println(" " + flujo.getNameMsg());
                }
                System.out.println("-----------------------------------");
            }
        }
    }

    private static void mostrarSistemasCreados() {
        if (Main.sistemasGuardados.isEmpty()) {
            System.out.println("No hay sistemas creados.");
        } else {
            System.out.println("Sistemas Creados:");
            for (TDASystem sistema : Main.sistemasGuardados) {
                System.out.println("-----------------------------------");
                System.out.println("Nombre del Sistema: " + sistema.getName());
                System.out.println("Código Inicial del Chatbot: " + sistema.getInitialChatbotCodeLink());
                System.out.println("Chatbots en el Sistema:");
                for (Chatbot chatbot : sistema.getChatbots()) {
                    System.out.println(" " + chatbot.getName());
                }
                System.out.println("Usuarios Registrados:");
                for (String usuario : sistema.getUsuariosRegistrados()) {
                    System.out.println(" " + usuario);
                }
                System.out.println("Usuario Logueado: " + sistema.getUsuarioLogueadoActualmente());
                System.out.println("-----------------------------------");
            }
        }
    }
}

