package Lab3_20642718_ZengZhong;

import java.util.Scanner;

/**
 * La clase User revisa que tipo de usuario es y lo redirige al menu correspondiente
 * @author Ka Zeng
 */
public class TDAUser_20642718_ZengZhong {

    private Scanner scanner;

    /**
     * Constructor de la clase
     */
    public TDAUser_20642718_ZengZhong() {
        scanner = new Scanner(System.in);
    }

    /**
     * Ejecuta el bucle principal del menú
     */
    public void run() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("Como quiere ejecutar el programa?");
            System.out.println("1) Administrador");
            System.out.println("2) Usuario Comun");
            System.out.println("3) Salir");
            System.out.print("Elija la opcion (1, 2 o 3): ");
            int opcionMenu = Integer.parseInt(scanner.nextLine());

            switch (opcionMenu) {
                case 1:
                    AdminMenu_20642718_ZengZhong.mostrarMenuAdministrador(scanner);
                    break;
                case 2:
                    UserMenu_20642718_ZengZhong.mostrarMenuUsuario(scanner);
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }
        scanner.close();
    }
}

