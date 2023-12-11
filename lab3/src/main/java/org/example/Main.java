package org.example;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static List<Option> opcionesGuardadas = new ArrayList<>();
    public static List<Flow> flujosGuardados = new ArrayList<>();
    public static List<Chatbot> chatbotsGuardados = new ArrayList<>();
    public static List<TDASystem> sistemasGuardados = new ArrayList<>();

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
        Chatbot cb0 = new Chatbot(0, "Inicial", "Bienvenido\n¿Qué te gustaria hacer?", 1, Arrays.asList(f10));
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
        boolean continuar = true;

        while (continuar) {
            System.out.println("¿Cómo quiere ejecutar el programa?");
            System.out.println("1) Administrador");
            System.out.println("2) Usuario Común");
            System.out.println("3) Salir");
            System.out.print("Elija la opción (1, 2 o 3): ");
            int opcionMenu = Integer.parseInt(scanner.nextLine());

            switch (opcionMenu) {
                case 1:
                    AdminMenu.mostrarMenuAdministrador(scanner);
                    break;
                case 2:
                    UserMenu.mostrarMenuUsuario(scanner);
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        scanner.close();
    }
}





