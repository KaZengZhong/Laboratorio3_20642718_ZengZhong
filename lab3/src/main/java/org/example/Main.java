package org.example;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static List<Option> opcionesGuardadas = new ArrayList<>();
    private static List<Flow> flujosGuardados = new ArrayList<>();
    private static List<Chatbot> chatbotsGuardados = new ArrayList<>();
    private static List<TDASystem> sistemasGuardados = new ArrayList<>();

    public static void main(String[] args) {

        Option op1 = new Option(1, "1) Viajar", 1, 1, Arrays.asList("viajar", "turistear", "conocer"));
        Option op2 = new Option(2, "2) Estudiar", 2, 1, Arrays.asList("estudiar", "aprender", "perfecionarme"));
        Option op3 = new Option(1, "1) New York, USA", 1, 2, Arrays.asList("USA", "Estados Unidos", "New York"));
        Option op4 = new Option(2, "2) París, Francia", 1, 1, Arrays.asList("Paris", "Eiffel"));
        Option op5 = new Option(3, "3) Torres del Paine, Chile", 1, 1, Arrays.asList("Chile", "Torres", "Paine", "Torres Paine", "Torres del Paine"));
        Option op6 = new Option(4, "4) Volver", 0, 1, Arrays.asList("Regresar", "Salir", "Volver"));
        Option op7 = new Option(1, "1) Central Park", 1, 2, Arrays.asList("Central", "Park", "Central Park"));
        Option op8 = new Option(2, "2) Museos", 1, 2, Arrays.asList("Museo"));
        Option op9 = new Option(3, "3) Ningún otro atractivo", 1, 3, Arrays.asList("Museo"));
        Option op10 = new Option(4, "4) Cambiar destino", 1, 1, Arrays.asList("Cambiar", "Volver", "Salir"));
        Option op11 = new Option(1, "1) Solo", 1, 3, Arrays.asList("Solo"));
        Option op12 = new Option(2, "2) En pareja", 1, 3, Arrays.asList("Pareja"));
        Option op13 = new Option(3, "3) En familia", 1, 3, Arrays.asList("Familia"));
        Option op14 = new Option(4, "4) Agregar más atractivos", 1, 2, Arrays.asList("Volver", "Atractivos"));
        Option op15 = new Option(5, "5) En realidad quiero otro destino", 1, 1, Arrays.asList("Cambiar destino"));
        Option op16 = new Option(1, "1) Carrera Técnica", 2, 1, Arrays.asList("Técnica"));
        Option op17 = new Option(2, "2) Postgrado", 2, 1, Arrays.asList("Doctorado", "Magister", "Postgrado"));
        Option op18 = new Option(3, "3) Volver", 0, 1, Arrays.asList("Volver", "Salir", "Regresar"));
        Flow f10 = new Flow(1, "flujo 1", Arrays.asList(op1, op2));
        Flow f20 = new Flow(1, "Flujo 1 Chatbot1\n¿Dónde te Gustaría ir?", Arrays.asList(op3, op4, op5, op6));
        Flow f21 = new Flow(2, "Flujo 2 Chatbot1\n¿Qué atractivos te gustaría visitar?", Arrays.asList(op7, op8, op9, op10));
        Flow f22 = new Flow(3, "Flujo 3 Chatbot1\n¿Vas solo o acompañado?", Arrays.asList(op11, op12, op13, op14, op15));
        Flow f30 = new Flow(1, "Flujo 1 Chatbot2\n¿Qué te gustaría estudiar?", Arrays.asList(op16, op17, op18));
        Chatbot cb0 = new Chatbot(0, "Inicial", "Bienvenido\n, ¿Qué te gustaria hacer?", 1, Arrays.asList(f10));
        Chatbot cb1 = new Chatbot(1, "Agencia Viajes", "Bienvenido\n¿Dónde quieres viajar?", 1, Arrays.asList(f20, f21, f22));
        Chatbot cb2 = new Chatbot(2, "Orientador Académico", "Bienvenido\n¿Qué te gustaría estudiar?", 1, Arrays.asList(f30));
        TDASystem s0 = new TDASystem("Chatbots Paradigmas", 0, Arrays.asList(cb0, cb1, cb2));
        s0.systemAddUser("user1");
        s0.systemAddUser("user2");
        s0.systemAddUser("user3");
        s0.systemLogin("user2");
        opcionesGuardadas.add(op1);
        opcionesGuardadas.add(op2);
        opcionesGuardadas.add(op3);
        opcionesGuardadas.add(op4);
        opcionesGuardadas.add(op5);
        opcionesGuardadas.add(op6);
        opcionesGuardadas.add(op7);
        opcionesGuardadas.add(op8);
        opcionesGuardadas.add(op9);
        opcionesGuardadas.add(op10);
        opcionesGuardadas.add(op11);
        opcionesGuardadas.add(op12);
        opcionesGuardadas.add(op13);
        opcionesGuardadas.add(op14);
        opcionesGuardadas.add(op15);
        opcionesGuardadas.add(op16);
        opcionesGuardadas.add(op17);
        opcionesGuardadas.add(op18);
        flujosGuardados.add(f10);
        flujosGuardados.add(f20);
        flujosGuardados.add(f21);
        flujosGuardados.add(f22);
        flujosGuardados.add(f30);
        chatbotsGuardados.add(cb0);
        chatbotsGuardados.add(cb1);
        chatbotsGuardados.add(cb2);
        sistemasGuardados.add(s0);

        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese su nombre
        System.out.print("¿Como quiere ejecutar el programa? ");
        System.out.print("1) Adminitrador");
        System.out.print("2) usuario comun");
        System.out.print("Elija la opción (1 o 2)");
        int opcionMenu = scanner.nextint();

        if (opcionMenu == 1) {
            mostrarMenuAdministrador(scanner);
        } else if (opcionMenu == 2) {
            mostrarMenuUsuario(scanner);
        } else {
            System.out.println("Opción no válida.");
        }
        scanner.close();
    }

    private static void mostrarMenuAdministrador(Scanner scanner) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("### Menú Adminitrador ###");
            System.out.println("1. Crear una Opcion");
            System.out.println("2. Crear un Flujo");
            System.out.println("3. Agregar una Opcion a un Flujo");
            System.out.println("4. Crear un Chatbot");
            System.out.println("5. Agregar un Flujo a un Chatbot");
            System.out.println("6. Crear un Sistema");
            System.out.println("7. Agregar un Chatbot a un Sistema");
            System.out.println("8. Registrar Usuario");
            System.out.println("9. Iniciar Sesion");
            System.out.println("10. Cerrar Sesion");
            System.out.println("11. Mostrar Opciones Guardadas");
            System.out.println("12. Mostrar Flujos Guardados");
            System.out.println("13. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer después de leer un número

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
                    anadirUsuarioASistema(scanner);
                    break;
                case 9:
                    iniciarSesionEnSistema(scanner);
                    break;
                case 10:
                    cerrarSesionEnSistema(scanner);
                    break;
                case 11:
                    mostrarOpcionesGuardadas();
                    break;
                case 12:
                    mostrarFlujosGuardados();
                    break;
                case 13:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    private static void mostrarMenuUsuario(Scanner scanner) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("### Menú Usuario ###");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Cerrar Sesión");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                // Casos para cada opción del usuario común
                case 9:
                    continuar = false;
                    break;
                // ... otros casos
            }
        }
    }








    // ----------------------------------------------------------------------------------------------
    private static void agregarOpcion(Scanner scanner) {
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
    }

    // ----------------------------------------------------------------------------------------------
    private static void agregarFlujo(Scanner scanner) {
        System.out.print("Ingrese el ID del flujo: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer de entrada

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
        flujosGuardados.add(nuevoFlujo);
        System.out.println("Flujo agregado exitosamente.");
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
        for (Option opcion : opcionesGuardadas) {
            if (opcion.getCode() == codigo) {
                return opcion;
            }
        }
        return null;
    }

    // ----------------------------------------------------------------------------------------------
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
    private static Flow buscarFlujoPorId(int id) {
        for (Flow flujo : flujosGuardados) {
            if (flujo.getId() == id) {
                return flujo;
            }
        }
        return null;
    }

    // ----------------------------------------------------------------------------------------------
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
        chatbotsGuardados.add(nuevoChatbot);
        System.out.println("Chatbot agregado exitosamente.");
    }

// ----------------------------------------------------------------------------------------------
    private static void anadirFlujosAChatbot(Scanner scanner) {
        System.out.print("Ingrese el ID del chatbot al que desea añadir flujos: ");
        int chatbotID = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer de entrada

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

    private static Chatbot buscarChatbotPorId(int id) {
        for (Chatbot chatbot : chatbotsGuardados) {
            if (chatbot.getChatbotID() == id) {
                return chatbot;
            }
        }
        return null;
    }
    // ----------------------------------------------------------------------------------------------
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
        sistemasGuardados.add(nuevoSistema);
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

    private static TDASystem buscarSistemaPorNombre(String nombre) {
        for (TDASystem sistema : sistemasGuardados) {
            if (sistema.getName().equals(nombre)) {
                return sistema;
            }
        }
        return null;
    }

    private static void anadirUsuarioASistema(Scanner scanner) {
        System.out.print("Ingrese el nombre del sistema al que desea añadir un usuario: ");
        String nombreSistema = scanner.nextLine();

        TDASystem sistemaEncontrado = buscarSistemaPorNombre(nombreSistema);
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

        TDASystem sistemaEncontrado = buscarSistemaPorNombre(nombreSistema);
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

        TDASystem sistemaEncontrado = buscarSistemaPorNombre(nombreSistema);
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


    // ----------------------------------------------------------------------------------------------
    private static void mostrarOpcionesGuardadas() {
        if (opcionesGuardadas.isEmpty()) {
            System.out.println("No hay opciones guardadas.");
        } else {
            System.out.println("Opciones Guardadas:");
            for (Option options : opcionesGuardadas) {
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
        if (flujosGuardados.isEmpty()) {
            System.out.println("No hay flujos guardados.");
        } else {
            System.out.println("Flujos Guardados:");
            for (Flow flujos : flujosGuardados) {
                System.out.println("-----------------------------------");
                System.out.println("ID del Flujo: " + flujos.getId());
                System.out.println("Mensaje del Flujo: " + flujos.getNameMsg());
                System.out.println("Opciones guardadas: ");
                for (Option opcion : flujos.getOptions()) {
                    System.out.println("  " + opcion.getMessage());
                }
                System.out.println("-----------------------------------");
            }
        }
    }

    private static void mostrarChatbotsGuardados() {
        if (chatbotsGuardados.isEmpty()) {
            System.out.println("No hay chatbots guardados.");
        } else {
            System.out.println("Chatbots Guardados:");
            for (Chatbot chatbot : chatbotsGuardados) {
                System.out.println("-----------------------------------");
                System.out.println("ID del Chatbot: " + chatbot.getChatbotID());
                System.out.println("Nombre: " + chatbot.getName());
                System.out.println("Mensaje de Bienvenida: " + chatbot.getWelcomeMessage());
                System.out.println("ID del Flujo Inicial: " + chatbot.getStartFlowId());
                System.out.println("Flujos asociados:");
                for (Flow flujo : chatbot.getFlows()) {
                    System.out.println("  ID del Flujo: " + flujo.getId() + ", Nombre: " + flujo.getNameMsg());
                }
                System.out.println("-----------------------------------");
            }
        }
    }

    private static void mostrarSistemasCreados() {
        if (sistemasGuardados.isEmpty()) {
            System.out.println("No hay sistemas creados.");
        } else {
            System.out.println("Sistemas Creados:");
            for (TDASystem sistema : sistemasGuardados) {
                System.out.println("-----------------------------------");
                System.out.println("Nombre del Sistema: " + sistema.getName());
                System.out.println("Código Inicial del Chatbot: " + sistema.getInitialChatbotCodeLink());
                System.out.println("Chatbots en el Sistema:");
                for (Chatbot chatbot : sistema.getChatbots()) {
                    System.out.println("  ID del Chatbot: " + chatbot.getChatbotID() + ", Nombre: " + chatbot.getName());
                }
                System.out.println("Usuarios Registrados:");
                for (String usuario : sistema.getUsuariosRegistrados()) {
                    System.out.println("  Usuario: " + usuario);
                }
                System.out.println("Usuario Actualmente Logueado: " + sistema.getUsuarioLogueadoActualmente());
                System.out.println("-----------------------------------");
            }
        }
    }


}




