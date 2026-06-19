import java.util.Scanner;
import service.JuegoTruco;
import service.ReglasTruco;

public class Main {

    public static void main(String[] args) {
        Scanner tecladoMain = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n=======================================");
            System.out.println("            MENU DE TRUCO              ");
            System.out.println("=======================================");
            System.out.println("  1 -> Jugar Partida");
            System.out.println("  2 -> Ver Reglas (Jerarquia de Cartas)");
            System.out.println("  3 -> Salir del Programa");
            System.out.println("=======================================");
            System.out.print("Selecciona una opcion: ");

            if (tecladoMain.hasNextInt()) {
                opcion = tecladoMain.nextInt();
                
                switch (opcion) {
                    case 1:
                        char respuesta;
                        do {
                            JuegoTruco juego = new JuegoTruco();
                            juego.iniciarPartida();

                            System.out.print("\n¿Queres jugar otra partida? (S/N): ");
                            respuesta = tecladoMain.next().toUpperCase().charAt(0);
                        } while (respuesta == 'S');
                        break;
                        
                    case 2:
                        
                        ReglasTruco.mostrarReglas();
                        break;
                        
                    case 3:
                        System.out.println("\nGracias por jugar al Truco! Programa finalizado.");
                        break;
                        
                    default:
                        System.out.println("Opcion invalida. Elegi entre 1, 2 o 3.");
                }
            } else {
                tecladoMain.next(); 
                System.out.println("Entrada invalida. Por favor, ingresa un numero.");
            }

        } while (opcion != 3);

        tecladoMain.close();
    }
}