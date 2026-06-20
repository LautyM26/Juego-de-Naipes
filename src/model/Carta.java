package model;

public class Carta {

    private int numero;
    private Palo palo;

    public Carta(int numero, Palo palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public int getNumero() {  // Devuelve el numero de la carta
        return numero;
    }

    public Palo getPalo() {  // Devuelve el objeto Palo de la carta
        return palo;
    }

    @Override
    public String toString() {
        return numero + " de " + palo;   // Formato de visualización
    }
}