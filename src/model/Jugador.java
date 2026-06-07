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
        mano.add(carta);
    }

    public void mostrarMano() {

        System.out.println("\nMano de " + nombre);

        for (Carta carta : mano) {
            System.out.println(carta);
        }
    }
}