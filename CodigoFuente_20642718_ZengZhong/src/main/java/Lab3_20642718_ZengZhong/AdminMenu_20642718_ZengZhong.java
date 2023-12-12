package Lab3_20642718_ZengZhong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * La clase representa un menu para los usuarios que son administradores
 * @author Ka Zeng
 */
public class AdminMenu_20642718_ZengZhong {

    /**
     * Muestra el menú de administrador y maneja la selección de opciones.
     * @param scanner Scanner para leer la entrada del usuario.
     */
    public static void mostrarMenuAdministrador(Scanner scanner) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("### Menu Administrador ###");
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
            System.out.print("Seleccione una opcion: ");
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
                    System.out.println("Opcion no valida.");
                    break;
            }
        }
    }

    // Funciones auxiliares
    /**
     * Verifica si una cadena de texto es numérica.
     * @param strNum La cadena a verificar.
     * @return true si la cadena es numérica, false en caso contrario.
     */
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

    /**
     * Busca una opción por su código.
     * @param codigo El código de la opción a buscar.
     * @return La opción encontrada o null si no se encuentra.
     */
    private static TDAOption_20642718_ZengZhong buscarOpcionPorCodigo(int codigo) {
        for (TDAOption_20642718_ZengZhong opcion : Main.opcionesGuardadas) {
            if (opcion.getCode() == codigo) {
                return opcion;
            }
        }
        return null;
    }
    /**
     * Busca un flujo por su ID.
     * @param id El ID del flujo a buscar.
     * @return El flujo encontrado o null si no se encuentra.
     */
    private static TDAFlow_20642718_ZengZhong buscarFlujoPorId(int id) {
        for (TDAFlow_20642718_ZengZhong flujo : Main.flujosGuardados) {
            if (flujo.getId() == id) {
                return flujo;
            }
        }
        return null;
    }
    /**
     * Busca un chatbot por su ID.
     * @param id El ID del chatbot a buscar.
     * @return El chatbot encontrado o null si no se encuentra.
     */
    private static TDAChatbot_20642718_ZengZhong buscarChatbotPorId(int id) {
        for (TDAChatbot_20642718_ZengZhong chatbot : Main.chatbotsGuardados) {
            if (chatbot.getChatbotID() == id) {
                return chatbot;
            }
        }
        return null;
    }
    /**
     * Busca un sistema por su nombre.
     * @param nombre El nombre del sistema a buscar.
     * @return El sistema encontrado o null si no se encuentra.
     */
    public static TDASystem_20642718_ZengZhong buscarSistemaPorNombre(String nombre) {
        for (TDASystem_20642718_ZengZhong sistema : Main.sistemasGuardados) {
            if (sistema.getName().equals(nombre)) {
                return sistema;
            }
        }
        return null;
    }


    // Funciones principales
    /**
     * Agrega una nueva opción al sistema.
     * @param scanner Scanner para leer la entrada del usuario.
     */
    private static void agregarOpcion(Scanner scanner) {
        System.out.print("Ingrese el codigo de la opcion: ");
        int code = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el mensaje de la opcion: ");
        String message = scanner.nextLine();
        System.out.print("Ingrese el código de enlace del chatbot: ");
        int chatbotCodeLink = scanner.nextInt();
        System.out.print("Ingrese el código de enlace del flujo inicial: ");
        int initialFlowCodeLink = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese palabras clave (separadas por comas): ");
        String keywordsInput = scanner.nextLine();
        List<String> keywords = Arrays.asList(keywordsInput.split(","));
        TDAOption_20642718_ZengZhong option = new TDAOption_20642718_ZengZhong(code, message, chatbotCodeLink, initialFlowCodeLink, keywords);
        Main.opcionesGuardadas.add(option);
    }

    /**
     * Agrega un nuevo flujo al sistema.
     * @param scanner Scanner para leer la entrada del usuario.
     */
    private static void agregarFlujo(Scanner scanner) {
        System.out.print("Ingrese el ID del flujo: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el mensaje del flujo: ");
        String nameMsg = scanner.nextLine();
        System.out.print("Ingrese los códigos de las opciones para este flujo (separados por comas): ");
        String opcionesInput = scanner.nextLine();
        List<TDAOption_20642718_ZengZhong> opcionesParaFlujo = new ArrayList<>();
        String[] codigosOpciones = opcionesInput.split(",");
        for (String codigo : codigosOpciones) {
            if (isNumeric(codigo.trim())) {
                int codigoOpcion = Integer.parseInt(codigo.trim());
                TDAOption_20642718_ZengZhong opcionEncontrada = buscarOpcionPorCodigo(codigoOpcion);
                if (opcionEncontrada != null) {
                    opcionesParaFlujo.add(opcionEncontrada);
                } else {
                    System.out.println("No se encontró una opción con el código: " + codigoOpcion);
                }
            } else {
                System.out.println("Código inválido: " + codigo.trim());
            }
        }
        TDAFlow_20642718_ZengZhong nuevoFlujo = new TDAFlow_20642718_ZengZhong(id, nameMsg, opcionesParaFlujo);
        Main.flujosGuardados.add(nuevoFlujo);
        System.out.println("Flujo agregado exitosamente.");
    }

    /**
     * Agrega una opción existente a un flujo específico.
     * @param scanner Scanner para leer la entrada del usuario.
     */
    private static void agregarOpcionAFlujo(Scanner scanner) {
        System.out.print("Ingrese el ID del flujo al que desea añadir opciones: ");
        int idFlujo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        System.out.print("Ingrese el código de la opción a agregar: ");
        int codigoOpcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        // Buscar el flujo y la opción
        TDAFlow_20642718_ZengZhong flujo = buscarFlujoPorId(idFlujo);
        TDAOption_20642718_ZengZhong opcion = buscarOpcionPorCodigo(codigoOpcion);

        if (flujo != null && opcion != null) {
            // Agregar la opción al flujo
            flujo.flowAddOption(opcion);
            System.out.println("Opción agregada al flujo exitosamente.");
        } else {
            System.out.println("Flujo o opción no encontrados.");
        }
    }

    /**
     * Crea un nuevo chatbot y lo agrega al sistema.
     * @param scanner Scanner para leer la entrada del usuario.
     */
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
        scanner.nextLine();

        System.out.print("Ingrese los IDs de los flujos para este chatbot (separados por comas): ");
        String flujosInput = scanner.nextLine();

        List<TDAFlow_20642718_ZengZhong> flujosParaChatbot = new ArrayList<>();
        String[] idsFlujos = flujosInput.split(",");

        for (String idFlujo : idsFlujos) {
            int id = Integer.parseInt(idFlujo.trim());
            TDAFlow_20642718_ZengZhong flujoEncontrado = buscarFlujoPorId(id);
            if (flujoEncontrado != null) {
                flujosParaChatbot.add(flujoEncontrado);
            } else {
                System.out.println("No se encontró un flujo con el ID: " + id);
            }
        }

        TDAChatbot_20642718_ZengZhong nuevoChatbot = new TDAChatbot_20642718_ZengZhong(chatbotID, name, welcomeMessage, startFlowId, flujosParaChatbot);
        Main.chatbotsGuardados.add(nuevoChatbot);
        System.out.println("Chatbot agregado exitosamente.");
    }

    /**
     * Añade flujos existentes a un chatbot específico.
     * @param scanner Scanner para leer la entrada del usuario.
     */
    private static void anadirFlujosAChatbot(Scanner scanner) {
        System.out.print("Ingrese el ID del chatbot al que desea añadir flujos: ");
        int chatbotID = scanner.nextInt();
        scanner.nextLine();
        TDAChatbot_20642718_ZengZhong chatbotEncontrado = buscarChatbotPorId(chatbotID);
        if (chatbotEncontrado == null) {
            System.out.println("No se encontró un chatbot con el ID: " + chatbotID);
            return;
        }
        System.out.print("Ingrese los IDs de los flujos a añadir (separados por comas): ");
        String flujosInput = scanner.nextLine();
        String[] idsFlujos = flujosInput.split(",");
        for (String idFlujo : idsFlujos) {
            int id = Integer.parseInt(idFlujo.trim());
            TDAFlow_20642718_ZengZhong flujoEncontrado = buscarFlujoPorId(id);
            if (flujoEncontrado != null) {
                chatbotEncontrado.chatbotAddFlow(flujoEncontrado);
            } else {
                System.out.println("No se encontró un flujo con el ID: " + id);
            }
        }
        System.out.println("Flujos añadidos al chatbot exitosamente.");
    }

    /**
     * Crea un nuevo sistema de chatbots.
     * @param scanner Scanner para leer la entrada del usuario.
     */
    private static void crearSistema(Scanner scanner) {
        System.out.print("Ingrese el nombre del sistema: ");
        String nombreSistema = scanner.nextLine();
        System.out.print("Ingrese el código inicial del chatbot para el sistema: ");
        int codigoInicialChatbot = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer de entrada
        List<TDAChatbot_20642718_ZengZhong> chatbotsParaSistema = new ArrayList<>();
        System.out.print("Ingrese los IDs de los chatbots para este sistema (separados por comas): ");
        String chatbotsInput = scanner.nextLine();
        String[] idsChatbots = chatbotsInput.split(",");
        for (String idChatbot : idsChatbots) {
            int id = Integer.parseInt(idChatbot.trim());
            TDAChatbot_20642718_ZengZhong chatbotEncontrado = buscarChatbotPorId(id);
            if (chatbotEncontrado != null) {
                chatbotsParaSistema.add(chatbotEncontrado);
            } else {
                System.out.println("No se encontró un chatbot con el ID: " + id);
            }
        }
        TDASystem_20642718_ZengZhong nuevoSistema = new TDASystem_20642718_ZengZhong(nombreSistema, codigoInicialChatbot, chatbotsParaSistema);
        Main.sistemasGuardados.add(nuevoSistema);
        System.out.println("Sistema creado exitosamente.");
    }

    /**
     * Añade un chatbot existente a un sistema específico.
     * @param scanner Scanner para leer la entrada del usuario.
     */
    private static void anadirChatbotASistema(Scanner scanner) {
        System.out.print("Ingrese el nombre del sistema al que desea añadir un chatbot: ");
        String nombreSistema = scanner.nextLine();
        TDASystem_20642718_ZengZhong sistemaEncontrado = buscarSistemaPorNombre(nombreSistema);
        if (sistemaEncontrado == null) {
            System.out.println("No se encontró un sistema con el nombre: " + nombreSistema);
            return;
        }
        System.out.print("Ingrese el ID del chatbot a añadir: ");
        int idChatbot = scanner.nextInt();
        scanner.nextLine();
        TDAChatbot_20642718_ZengZhong chatbotEncontrado = buscarChatbotPorId(idChatbot);
        if (chatbotEncontrado == null) {
            System.out.println("No se encontró un chatbot con el ID: " + idChatbot);
            return;
        }
        sistemaEncontrado.systemAddChatbot(chatbotEncontrado);
        System.out.println("Chatbot añadido al sistema exitosamente.");
    }

    /**
     * Muestra todas las opciones guardadas en el sistema.
     */
    private static void mostrarOpcionesGuardadas() {
        if (Main.opcionesGuardadas.isEmpty()) {
            System.out.println("No hay opciones guardadas.");
        } else {
            System.out.println("Opciones Guardadas:");
            for (TDAOption_20642718_ZengZhong options : Main.opcionesGuardadas) {
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

    /**
     * Muestra todos los flujos guardados en el sistema.
     */
    private static void mostrarFlujosGuardados() {
        if (Main.flujosGuardados.isEmpty()) {
            System.out.println("No hay flujos guardados.");
        } else {
            System.out.println("Flujos Guardados:");
            for (TDAFlow_20642718_ZengZhong flujos : Main.flujosGuardados) {
                System.out.println("-----------------------------------");
                System.out.println("ID del Flujo: " + flujos.getId());
                System.out.println("Mensaje del Flujo: " + flujos.getNameMsg());
                System.out.println("Opciones guardadas: ");
                for (TDAOption_20642718_ZengZhong opcion : flujos.getOptions()) {
                    System.out.println(" " + opcion.getMessage());
                }
                System.out.println("-----------------------------------");
            }
        }
    }

    /**
     * Muestra todos los chatbots guardados en el sistema.
     */
    private static void mostrarChatbotsGuardados() {
        if (Main.chatbotsGuardados.isEmpty()) {
            System.out.println("No hay chatbots guardados.");
        } else {
            System.out.println("Chatbots Guardados:");
            for (TDAChatbot_20642718_ZengZhong chatbot : Main.chatbotsGuardados) {
                System.out.println("-----------------------------------");
                System.out.println("ID del Chatbot: " + chatbot.getChatbotID());
                System.out.println("Nombre: " + chatbot.getName());
                System.out.println("Mensaje de Bienvenida: " + chatbot.getWelcomeMessage());
                System.out.println("ID del Flujo Inicial: " + chatbot.getStartFlowId());
                System.out.println("Flujos asociados:");
                for (TDAFlow_20642718_ZengZhong flujo : chatbot.getFlows()) {
                    System.out.println(" " + flujo.getNameMsg());
                }
                System.out.println("-----------------------------------");
            }
        }
    }

    /**
     * Muestra todos los sistemas creados.
     */
    private static void mostrarSistemasCreados() {
        if (Main.sistemasGuardados.isEmpty()) {
            System.out.println("No hay sistemas creados.");
        } else {
            System.out.println("Sistemas Creados:");
            for (TDASystem_20642718_ZengZhong sistema : Main.sistemasGuardados) {
                System.out.println("-----------------------------------");
                System.out.println("Nombre del Sistema: " + sistema.getName());
                System.out.println("Código Inicial del Chatbot: " + sistema.getInitialChatbotCodeLink());
                System.out.println("Chatbots en el Sistema:");
                for (TDAChatbot_20642718_ZengZhong chatbot : sistema.getChatbots()) {
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

