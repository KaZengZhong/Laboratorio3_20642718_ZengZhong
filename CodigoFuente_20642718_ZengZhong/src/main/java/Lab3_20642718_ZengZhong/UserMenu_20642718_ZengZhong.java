package Lab3_20642718_ZengZhong;

import java.util.Scanner;
import java.util.Set;

/**
 * La clase representa un menu para los usuarios que son comunes
 * @author Ka Zeng
 */
public class UserMenu_20642718_ZengZhong {
    /**
     * Muestra el menú principal para el usuario y maneja las selecciones de menú.
     * @param scanner Scanner para leer la entrada del usuario.
     */
    public static void mostrarMenuUsuario(Scanner scanner) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("### Menu Usuario ###");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Iniciar Sesion");
            System.out.println("3. Cerrar Sesion");
            System.out.println("4. Ver usuarios registrados");
            System.out.println("5. Ver usuario logueado");
            System.out.println("6. Interactuar con un chatbot");
            System.out.println("7. Ver el historial del chat");
            System.out.println("8. Volver al Menu Principal");
            System.out.print("Seleccione una opcion: ");
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
                case 6:
                    interactuarChatbot(scanner);
                    break;
                case 7:
                    sintesisChatbot(scanner);
                    break;
                case 8:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }
    }

    /**
     * Permite al usuario interactuar con un chatbot.
     * @param scanner Scanner para leer la entrada del usuario.
     */
    private static void interactuarChatbot(Scanner scanner) {
        System.out.print("Ingrese el nombre del sistema con el que desea interactuar: ");
        String nombreSistema = scanner.nextLine();
        TDASystem_20642718_ZengZhong sistemaEncontrado = AdminMenu_20642718_ZengZhong.buscarSistemaPorNombre(nombreSistema);

        if (sistemaEncontrado == null) {
            System.out.println("No se encontro un sistema con el nombre: " + nombreSistema);
            return;
        }

        System.out.print("Ingrese el id o la palabra clave asociada: ");
        String message = scanner.nextLine();

        sistemaEncontrado.systemTalkRec(message);
    }

    /**
     * Muestra el historial de interacciones del usuario con un chatbot.
     * @param scanner Scanner para leer la entrada del usuario.
     */
    private static void sintesisChatbot(Scanner scanner) {
        System.out.print("Ingrese el nombre del sistema con el que desea interactuar: ");
        String nombreSistema = scanner.nextLine();
        TDASystem_20642718_ZengZhong sistemaEncontrado = AdminMenu_20642718_ZengZhong.buscarSistemaPorNombre(nombreSistema);

        if (sistemaEncontrado == null) {
            System.out.println("No se encontro un sistema con el nombre: " + nombreSistema);
            return;
        }
        sistemaEncontrado.systemSynthesis();
    }

    /**
     * Permite al usuario añadir un nuevo usuario al sistema.
     * @param scanner Scanner para leer la entrada del usuario.
     */
    private static void anadirUsuarioASistema(Scanner scanner) {
        System.out.print("Ingrese el nombre del sistema al que desea anadir un usuario: ");
        String nombreSistema = scanner.nextLine();

        TDASystem_20642718_ZengZhong sistemaEncontrado = AdminMenu_20642718_ZengZhong.buscarSistemaPorNombre(nombreSistema);
        if (sistemaEncontrado == null) {
            System.out.println("No se encontro un sistema con el nombre: " + nombreSistema);
            return;
        }
        System.out.print("Ingrese el nombre de usuario a registrar: ");
        String nombreUsuario = scanner.nextLine();

        if (sistemaEncontrado.getUsuariosRegistrados().contains(nombreUsuario)) {
            System.out.println("El usuario '" + nombreUsuario + "' ya esta registrado en el sistema.");
        } else {
            sistemaEncontrado.systemAddUser(nombreUsuario);
            System.out.println("Usuario '" + nombreUsuario + "' registrado exitosamente en el sistema.");
        }
    }

    /**
     * Maneja el inicio de sesión de un usuario en el sistema.
     * @param scanner Scanner para leer la entrada del usuario.
     */
    private static void iniciarSesionEnSistema(Scanner scanner) {
        System.out.print("Ingrese el nombre del sistema en el que desea iniciar sesion: ");
        String nombreSistema = scanner.nextLine();

        TDASystem_20642718_ZengZhong sistemaEncontrado = AdminMenu_20642718_ZengZhong.buscarSistemaPorNombre(nombreSistema);
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

    /**
     * Maneja el cierre de sesión de un usuario en el sistema.
     * @param scanner Scanner para leer la entrada del usuario.
     */
    private static void cerrarSesionEnSistema(Scanner scanner) {
        System.out.print("Ingrese el nombre del sistema en el que desea cerrar sesión: ");
        String nombreSistema = scanner.nextLine();

        TDASystem_20642718_ZengZhong sistemaEncontrado = AdminMenu_20642718_ZengZhong.buscarSistemaPorNombre(nombreSistema);
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

    /**
     * Muestra una lista de todos los usuarios registrados en el sistema.
     * @param scanner Scanner para leer la entrada del usuario.
     */
    private static void verUsuariosRegistrados(Scanner scanner) {
        System.out.print("Ingrese el nombre del sistema para ver los usuarios registrados: ");
        String nombreSistema = scanner.nextLine();
        TDASystem_20642718_ZengZhong sistemaEncontrado = AdminMenu_20642718_ZengZhong.buscarSistemaPorNombre(nombreSistema);
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

    /**
     * Muestra el usuario actualmente logueado en el sistema.
     * @param scanner Scanner para leer la entrada del usuario.
     */
    private static void verUsuarioLogueado(Scanner scanner) {
        System.out.print("Ingrese el nombre del sistema para ver el usuario logueado: ");
        String nombreSistema = scanner.nextLine();

        TDASystem_20642718_ZengZhong sistemaEncontrado = AdminMenu_20642718_ZengZhong.buscarSistemaPorNombre(nombreSistema);
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


