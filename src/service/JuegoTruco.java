package service;

import model.Baraja;
import model.Jugador;

public class JuegoTruco {
    // Componentes necesarios para el juego
    private Baraja baraja;
    private Jugador jugador1;
    private Jugador jugador2;

    public JuegoTruco() { // Inicializa la baraja y los jugadores al crear el juego

        baraja = new Baraja();

        jugador1 = new Jugador("Jugador 1");
        jugador2 = new Jugador("Jugador 2");
    }

    public void iniciarPartida() {
       // Mezcla las cartas antes de empezar
        baraja.barajar();

        for (int i = 0; i < 3; i++) {
           // Reparte 3 cartas a cada jugador
            jugador1.recibirCarta(baraja.siguienteCarta());
            jugador2.recibirCarta(baraja.siguienteCarta());
        }
       // Muestra las cartas que recibió cada uno
        jugador1.mostrarMano();
        jugador2.mostrarMano();
    }
}