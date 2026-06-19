package service;

import java.util.Scanner;
import model.Baraja;
import model.Carta;
import model.Jugador;
import model.Palo;

public class JuegoTruco {

    private Baraja baraja;
    private Jugador jugador1;
    private Jugador cpu;

    private int puntosJ1 = 0;
    private int puntosCPU = 0;

    public JuegoTruco() {
        baraja = new Baraja();
        jugador1 = new Jugador("Tú"); 
        cpu = new Jugador("CPU");
    }

    @SuppressWarnings("resource")
    public void iniciarPartida() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n=======================================");
        System.out.println("      ¡PARTIDA DE TRUCO INICIADA!      ");
        System.out.println("=======================================");

        baraja.barajar();
        repartir();

        int rondaActual = 1;
        while (puntosJ1 < 2 && puntosCPU < 2 && rondaActual <= 3) {
            System.out.println("\n RONDA " + rondaActual + "");
            
            // Solo se muestra tu mano al principio de la ronda
            jugador1.mostrarMano();
            
            int opcion = -1;
            // ESCUDO ANTI-ERRORES: Si ponés letras o números raros, no explota
            while (true) {
                System.out.print("\n Elegí tu carta (1 a " + jugador1.getMano().size() + "): ");
                if (teclado.hasNextInt()) {
                    opcion = teclado.nextInt();
                    if (opcion >= 1 && opcion <= jugador1.getMano().size()) {
                        break; // El número es válido, salimos del bucle de control
                    }
                } else {
                    teclado.next(); // Limpia la letra inválida (como la 't') para que no buclee infinito
                }
                System.out.println(" Selección inválida. Por favor, ingresá un número correcto de la lista.");
            }
            
            Carta carta1 = jugador1.jugarCarta(opcion - 1);
            Carta carta2 = cpu.jugarCartaAleatoria();

            System.out.println("\n┌───────────────────────────────────┐");
            System.out.println("│           MESA DE JUEGO           │");
            System.out.println("├───────────────────────────────────┤");
            System.out.println("│    Tú jugaste:  " + carta1);
            System.out.println("│    CPU jugó:    " + carta2);
            System.out.println("└───────────────────────────────────┘");

            int resultado = comparar(carta1, carta2);

            if(resultado > 0){
                System.out.println(" ¡Ganaste esta ronda!");
                puntosJ1++;
            } else if(resultado < 0){
                System.out.println(" La CPU ganó esta ronda.");
                puntosCPU++;
            } else {
                System.out.println(" ¡Parda! (Empate)");
                puntosJ1++;
                puntosCPU++;
            }
            rondaActual++;
        }

        mostrarGanador(); 
    }

    private void repartir(){
        for(int i = 0; i < 3; i++){
            jugador1.recibirCarta(baraja.siguienteCarta());
            cpu.recibirCarta(baraja.siguienteCarta());
        }
    }

    private int valorTruco(Carta carta) {
        int n = carta.getNumero();
        Palo palo = carta.getPalo();

        // Configurado con tus enums en singular (ESPADA, BASTO, ORO, COPA)
        if (n == 1 && palo == Palo.ESPADA) return 14;
        if (n == 1 && palo == Palo.BASTO) return 13;
        if (n == 7 && palo == Palo.ESPADA) return 12;
        if (n == 7 && palo == Palo.ORO) return 11;

        if (n == 3) return 10;
        if (n == 2) return 9;
        if (n == 1) return 8; 
        if (n == 12) return 7;
        if (n == 11) return 6;
        if (n == 10) return 5;
        if (n == 7) return 4; 
        if (n == 6) return 3;
        if (n == 5) return 2;
        if (n == 4) return 1;

        return 0;
    }

    private int comparar(Carta c1, Carta c2){
        int valor1 = valorTruco(c1);
        int valor2 = valorTruco(c2);

        if(valor1 > valor2) return 1;
        if(valor1 < valor2) return -1;
        return 0; 
    }

    private void mostrarGanador(){
        System.out.println("\n=======================================");
        System.out.println("            FIN DE LA MANO            ");
        System.out.println("=======================================");
        if(puntosJ1 > puntosCPU){
            System.out.println("    ¡Ganaste la partida! ¡Felicitaciones! 🎉");
        } else if(puntosCPU > puntosJ1) {
            System.out.println("    La CPU se lleva la victoria esta vez.");
        } else {
            System.out.println("   La mano terminó en un empate general.");
        }
        System.out.println("=======================================");
    }
}