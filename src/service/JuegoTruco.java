package service;

import model.Baraja;
import model.Jugador;

public class JuegoTruco {

    private Baraja baraja;
    private Jugador jugador1;
    private Jugador jugador2;

    public JuegoTruco() {

        baraja = new Baraja();

        jugador1 = new Jugador("Jugador 1");
        jugador2 = new Jugador("Jugador 2");
    }

    public void iniciarPartida() {

        baraja.barajar();

        for (int i = 0; i < 3; i++) {

            jugador1.recibirCarta(baraja.siguienteCarta());
            jugador2.recibirCarta(baraja.siguienteCarta());
        }

        jugador1.mostrarMano();
        jugador2.mostrarMano();
    }
}