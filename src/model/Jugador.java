package model;

import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private ArrayList<Carta> mano;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }

    public void recibirCarta(Carta carta) {
        mano.add(carta); // Añade una carta a la mano 
    }

    // Modificado para poder remover la carta exacta que elijas de la lista
    public Carta jugarCarta(int indice) {
        Carta carta = mano.get(indice);
        mano.remove(indice);
        return carta;
    }

    // Método exclusivo para la CPU
    public Carta jugarCartaAleatoria() {
        int indiceAleatorio = (int) (Math.random() * mano.size());
        Carta carta = mano.get(indiceAleatorio);
        mano.remove(indiceAleatorio);
        return carta;
    }

    // Diseño visual de tus cartas
    public void mostrarMano() {
        System.out.println("\n┌─────────────────────────┐");
        System.out.println("│       TUS CARTAS        │");
        System.out.println("└─────────────────────────┘");
        
        for (int i = 0; i < mano.size(); i++) {
            System.out.println("  " + (i + 1) + " -> [ " + mano.get(i) + " ]");
        }
    }
}