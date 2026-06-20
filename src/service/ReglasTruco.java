package service;

public class ReglasTruco {

    // Imprime la tabla estatica de posiciones de valor de las cartas del Truco
    public static void mostrarReglas() {
        System.out.println("\n------------------------------------------------");
        System.out.println("|         REGLAS Y JERARQUIA (TRUCO)           |");
        System.out.println("------------------------------------------------");
        System.out.println("| El juego se disputa a un maximo de 3 rondas. |");
        System.out.println("| Quien gane 2 rondas se lleva la partida.     |");
        System.out.println("|                                              |");
        System.out.println("| Valor de las cartas (De mayor a menor):      |");
        System.out.println("| 1. 1 de Espada (Ancho de Espada)             |");
        System.out.println("| 2. 1 de Basto (Ancho de Basto)               |");
        System.out.println("| 3. 7 de Espada                               |");
        System.out.println("| 4. 7 de Oro                                  |");
        System.out.println("| 5. Todos los 3                               |");
        System.out.println("| 6. Todos los 2                               |");
        System.out.println("| 7. 1 de Oro y 1 de Copa (Anchos falsos)      |");
        System.out.println("| 8. Todos los 12                              |");
        System.out.println("| 9. Todos los 11                              |");
        System.out.println("| 10. Todos los 10                             |");
        System.out.println("| 11. 7 de Basto y 7 de Copa (Falsos)          |");
        System.out.println("| 12. Todos los 6                              |");
        System.out.println("| 13. Todos los 5                              |");
        System.out.println("| 14. Todos los 4                              |");
        System.out.println("------------------------------------------------");
        System.out.println("Presiona ENTER para volver al menu...");
        try { 
            System.in.read(); 
        } catch (Exception e) {
           // Manejo de interrupcion de lectura por teclado
        }
    }
}