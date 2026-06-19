package service;

import java.util.Scanner;

import model.Baraja;
import model.Carta;
import model.Jugador;
import model.Palo;

public class JuegoTruco {

    private Baraja baraja;
    private Jugador jugador1;
    private Jugador jugador2;

    private int puntosJ1 = 0;
    private int puntosJ2 = 0;


    public JuegoTruco() {

        baraja = new Baraja();

        jugador1 = new Jugador("Jugador 1");
        jugador2 = new Jugador("Jugador 2");
    }


    public void iniciarPartida() {

        Scanner teclado = new Scanner(System.in);

        System.out.println("=== TRUCO SIMPLE ===");

        baraja.barajar();


        repartir();


        jugador1.mostrarMano();
        jugador2.mostrarMano();


        for(int ronda = 1; ronda <= 3; ronda++){

            System.out.println("\nRonda " + ronda);


            Carta carta1 = jugador1.jugarCarta();

            Carta carta2 = jugador2.jugarCarta();


            System.out.println(
                jugador1.getNombre() + " juega " + carta1
            );

            System.out.println(
                jugador2.getNombre() + " juega " + carta2
            );


            int resultado = comparar(carta1,carta2);


            if(resultado > 0){

                System.out.println(
                "Gana ronda " + jugador1.getNombre());

                puntosJ1++;

            }else{

                System.out.println(
                "Gana ronda " + jugador2.getNombre());

                puntosJ2++;
            }


        }


        mostrarGanador();

        teclado.close();
    }



    private void repartir(){

        for(int i=0;i<3;i++){

            jugador1.recibirCarta(
                baraja.siguienteCarta()
            );


            jugador2.recibirCarta(
                baraja.siguienteCarta()
            );
        }
    }


    private int valorTruco(Carta carta) {
    int n = carta.getNumero();
    
    Palo palo = carta.getPalo();

    if (n == 1 && palo == Palo.ESPADA) return 14;
    if (n == 1 && palo == Palo.BASTO) return 13;

    if (n == 7 && palo.equals("ESPADA")) return 12;
    if (n == 7 && palo.equals("ORO")) return 11;

    if (n == 3) return 10;
    if (n == 2) return 9;

    if (n == 1) return 8; // copa y oro

    if (n == 12) return 7;
    if (n == 11) return 6;
    if (n == 10) return 5;

    if (n == 7) return 4; // copa y basto

    if (n == 6) return 3;
    if (n == 5) return 2;
    if (n == 4) return 1;

    return 0;
}



    private int comparar(Carta c1,Carta c2){


        int valor1 = valorTruco(c1);
        int valor2 = valorTruco(c2);


        if(valor1 > valor2)
            return 1;


        return -1;
    }




    private void mostrarGanador(){


        System.out.println("\nResultado final");


        if(puntosJ1 > puntosJ2){

            System.out.println(
            "Ganador: " + jugador1.getNombre());

        }else{

            System.out.println(
            "Ganador: " + jugador2.getNombre());
        }
    }

}