package model;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {

    private ArrayList<Carta> cartas;
    private ArrayList<Carta> cartasRepartidas;

    public Baraja() {
        cartas = new ArrayList<>();
        cartasRepartidas = new ArrayList<>();

        crearBaraja();
    }

    private void crearBaraja() {

        for (Palo palo : Palo.values()) {

            for (int numero = 1; numero <= 12; numero++) {

                if (numero != 8 && numero != 9) {
                    cartas.add(new Carta(numero, palo));
                }
            }
        }
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public Carta siguienteCarta() {

        if (cartas.isEmpty()) {
            return null;
        }

        Carta carta = cartas.remove(0);

        cartasRepartidas.add(carta);

        return carta;
    }

    public int cartasDisponibles() {
        return cartas.size();
    }

    public ArrayList<Carta> darCartas(int cantidad) {

        if (cantidad > cartas.size()) {
            return null;
        }

        ArrayList<Carta> mano = new ArrayList<>();

        for (int i = 0; i < cantidad; i++) {
            mano.add(siguienteCarta());
        }

        return mano;
    }

    public void mostrarCartasRepartidas() {

        for (Carta carta : cartasRepartidas) {
            System.out.println(carta);
        }
    }

    public void mostrarBaraja() {

        for (Carta carta : cartas) {
            System.out.println(carta);
        }
    }
}