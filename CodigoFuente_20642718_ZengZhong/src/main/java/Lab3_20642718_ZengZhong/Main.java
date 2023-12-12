package Lab3_20642718_ZengZhong;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * La clase Main es el punto de entrada del programa y proporciona un menú de usuario
 * @author Ka Zeng
 */
public class Main {

    public static List<TDAOption_20642718_ZengZhong> opcionesGuardadas = new ArrayList<>();
    public static List<TDAFlow_20642718_ZengZhong> flujosGuardados = new ArrayList<>();
    public static List<TDAChatbot_20642718_ZengZhong> chatbotsGuardados = new ArrayList<>();
    public static List<TDASystem_20642718_ZengZhong> sistemasGuardados = new ArrayList<>();

    /**
     * El método main inicializa y ejecuta el sistema de chatbots.
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        TDAOption_20642718_ZengZhong op1 = new TDAOption_20642718_ZengZhong(1, "1) Viajar", 1, 1, Arrays.asList("viajar", "turistear", "conocer"));
        TDAOption_20642718_ZengZhong op2 = new TDAOption_20642718_ZengZhong(2, "2) Estudiar", 2, 1, Arrays.asList("estudiar", "aprender", "perfecionarme"));
        TDAOption_20642718_ZengZhong op3 = new TDAOption_20642718_ZengZhong(1, "1) New York, USA", 1, 2, Arrays.asList("USA", "Estados Unidos", "New York"));
        TDAOption_20642718_ZengZhong op4 = new TDAOption_20642718_ZengZhong(2, "2) París, Francia", 1, 1, Arrays.asList("Paris", "Eiffel"));
        TDAOption_20642718_ZengZhong op5 = new TDAOption_20642718_ZengZhong(3, "3) Torres del Paine, Chile", 1, 1, Arrays.asList("Chile", "Torres", "Paine", "Torres Paine", "Torres del Paine"));
        TDAOption_20642718_ZengZhong op6 = new TDAOption_20642718_ZengZhong(4, "4) Volver", 0, 1, Arrays.asList("Regresar", "Salir", "Volver"));
        TDAOption_20642718_ZengZhong op7 = new TDAOption_20642718_ZengZhong(1, "1) Central Park", 1, 2, Arrays.asList("Central", "Park", "Central Park"));
        TDAOption_20642718_ZengZhong op8 = new TDAOption_20642718_ZengZhong(2, "2) Museos", 1, 2, Arrays.asList("Museo"));
        TDAOption_20642718_ZengZhong op9 = new TDAOption_20642718_ZengZhong(3, "3) Ningún otro atractivo", 1, 3, Arrays.asList("Museo"));
        TDAOption_20642718_ZengZhong op10 = new TDAOption_20642718_ZengZhong(4, "4) Cambiar destino", 1, 1, Arrays.asList("Cambiar", "Volver", "Salir"));
        TDAOption_20642718_ZengZhong op11 = new TDAOption_20642718_ZengZhong(1, "1) Solo", 1, 3, Arrays.asList("Solo"));
        TDAOption_20642718_ZengZhong op12 = new TDAOption_20642718_ZengZhong(2, "2) En pareja", 1, 3, Arrays.asList("Pareja"));
        TDAOption_20642718_ZengZhong op13 = new TDAOption_20642718_ZengZhong(3, "3) En familia", 1, 3, Arrays.asList("Familia"));
        TDAOption_20642718_ZengZhong op14 = new TDAOption_20642718_ZengZhong(4, "4) Agregar más atractivos", 1, 2, Arrays.asList("Volver", "Atractivos"));
        TDAOption_20642718_ZengZhong op15 = new TDAOption_20642718_ZengZhong(5, "5) En realidad quiero otro destino", 1, 1, Arrays.asList("Cambiar destino"));
        TDAOption_20642718_ZengZhong op16 = new TDAOption_20642718_ZengZhong(1, "1) Carrera Técnica", 2, 1, Arrays.asList("Técnica"));
        TDAOption_20642718_ZengZhong op17 = new TDAOption_20642718_ZengZhong(2, "2) Postgrado", 2, 1, Arrays.asList("Doctorado", "Magister", "Postgrado"));
        TDAOption_20642718_ZengZhong op18 = new TDAOption_20642718_ZengZhong(3, "3) Volver", 0, 1, Arrays.asList("Volver", "Salir", "Regresar"));
        TDAFlow_20642718_ZengZhong f10 = new TDAFlow_20642718_ZengZhong(1, "flujo 1", Arrays.asList(op1, op2));
        TDAFlow_20642718_ZengZhong f20 = new TDAFlow_20642718_ZengZhong(1, "Flujo 1 Chatbot1\n¿Dónde te Gustaría ir?", Arrays.asList(op3, op4, op5, op6));
        TDAFlow_20642718_ZengZhong f21 = new TDAFlow_20642718_ZengZhong(2, "Flujo 2 Chatbot1\n¿Qué atractivos te gustaría visitar?", Arrays.asList(op7, op8, op9, op10));
        TDAFlow_20642718_ZengZhong f22 = new TDAFlow_20642718_ZengZhong(3, "Flujo 3 Chatbot1\n¿Vas solo o acompañado?", Arrays.asList(op11, op12, op13, op14, op15));
        TDAFlow_20642718_ZengZhong f30 = new TDAFlow_20642718_ZengZhong(1, "Flujo 1 Chatbot2\n¿Qué te gustaría estudiar?", Arrays.asList(op16, op17, op18));
        TDAChatbot_20642718_ZengZhong cb0 = new TDAChatbot_20642718_ZengZhong(0, "Inicial", "Bienvenido\n¿Qué te gustaria hacer?", 1, Arrays.asList(f10));
        TDAChatbot_20642718_ZengZhong cb1 = new TDAChatbot_20642718_ZengZhong(1, "Agencia Viajes", "Bienvenido\n¿Dónde quieres viajar?", 1, Arrays.asList(f20, f21, f22));
        TDAChatbot_20642718_ZengZhong cb2 = new TDAChatbot_20642718_ZengZhong(2, "Orientador Académico", "Bienvenido\n¿Qué te gustaría estudiar?", 1, Arrays.asList(f30));
        TDASystem_20642718_ZengZhong s0 = new TDASystem_20642718_ZengZhong("Chatbots Paradigmas", 0, Arrays.asList(cb0, cb1, cb2));
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
        //s0.systemTalkRec("1");
        //s0.systemTalkRec("1");
        //s0.systemTalkRec("Museo");
        //s0.systemTalkRec("1");
        //s0.systemTalkRec("3");
        //s0.systemTalkRec("5");
        //s0.systemSynthesis();

        TDAUser_20642718_ZengZhong user = new TDAUser_20642718_ZengZhong();
        user.run();
    }
}





