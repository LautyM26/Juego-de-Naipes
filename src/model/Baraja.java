package model;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {

    private ArrayList<Carta> cartas;
    private ArrayList<Carta> cartasRepartidas;

    public Baraja() {
        cartas = new ArrayList<>();
        cartasRepartidas = new ArrayList<>();

        crearBaraja();  // Genera las cartas al instanciar la baraja
    }

    private void crearBaraja() {
       // Crea las cartas omitiendo el 8 y el 9
        for (Palo palo : Palo.values()) {

            for (int numero = 1; numero <= 12; numero++) {

                if (numero != 8 && numero != 9) {
                    cartas.add(new Carta(numero, palo));
                }
            }
        }
    }

    public void barajar() {
        Collections.shuffle(cartas);   // Desordena aleatoriamente la lista de cartas
    }

    public Carta siguienteCarta() {
       // Verifica si quedan cartas disponibles
        if (cartas.isEmpty()) {
            return null;
        }
       // Saca la carta superior y la mueve a repartidas
        Carta carta = cartas.remove(0);
       
        cartasRepartidas.add(carta);

        return carta;
    }

    public int cartasDisponibles() {
        return cartas.size();
    }

    public ArrayList<Carta> darCartas(int cantidad) {
       // Valida que haya suficientes cartas antes de repartir
        if (cantidad > cartas.size()) {
            return null;
        }

        ArrayList<Carta> mano = new ArrayList<>();

        for (int i = 0; i < cantidad; i++) {
            mano.add(siguienteCarta());   // Reparte una por una
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