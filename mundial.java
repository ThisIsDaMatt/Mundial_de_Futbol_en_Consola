import java.io.*;

public class mundial {
        public static void main(String[] args) throws FileNotFoundException {

                System.out.println("     _____                                                             \r\n" + //
                                " ___|    _|__  __   _  ____   _  _____   ____  ____    ____            \r\n" + //
                                "|    \\  /  | ||  | | ||    \\ | ||     \\ |    ||    \\  |    |           \r\n" + //
                                "|     \\/   | ||  |_| ||     \\| ||      \\|    ||     \\ |    |_          \r\n" + //
                                "|__/\\__/|__|_||______||__/\\____||______/|____||__|\\__\\|______|         \r\n" + //
                                "    |_____|            _____                                           \r\n" + //
                                "  _____   ______    __|___  |__  __   _    __    ______  _____  ____   \r\n" + //
                                " |     \\ |   ___|  |   ___|    ||  | | | _|  |_ |      >/     \\|    |  \r\n" + //
                                " |      \\|   ___|  |   ___|    ||  |_| ||_    _||     < |     ||    |_ \r\n" + //
                                " |______/|______|  |___|     __||______|  |__|  |______>\\_____/|______|\r\n" + //
                                "                      |_____|                                          ");

                System.out.println("=====================================================================");
                System.out.println("                         MENÚ PRINCIPAL");
                System.out.println("=====================================================================");
                System.out.println("[1] Ver la bandera de un país.\n" +
                                   "[2] Ver o editar la tabla de posiciones.\n" +
                                   "[3] Ver el calendario de partidos.\n" +
                                   "[4] Salir");
                System.out.print("Ingrese una opción: ");
                int opcion = ConsoleInput.getInt();

        
            String[] paises = { "AUSTRIA", "MEXICO", "MARRUECOS", "NORUEGA", "BOSNIA Y HERZEGOVINA", "TUNEZ",
                    "INGLATERRA ", "ESPANA", "FRANCIA", "CABO VERDE", "COREA DEL SUR", "CONGO RD", "ECUADOR",
                    "ALEMANIA", "BÉLGICA", "CHEQUIA", "JAPON", "SUDÁFRICA", "TURQUÍA", "COLOMBIA", "ESCOCIA",
                    "PARAGUAY", "SUIZA", "EGIPTO", "PORTUGAL", "HAITI", "ARGELIA", "ARABIA SAUDI", "CROACIA",
                    "ARGENTINA", "COSTA DE MARFIL", "PAISES BAJOS", "BRASIL", "QATAR", "ESTADOS UNIDOS", "URUGUAY",
                    "SENEGAL", "JORDANIA", "CANADA", "AUSTRALIA", "NUEVA ZELANDA", "PANAMA", "CURAZAO", "SUECIA",
                    "IRAN", "UZBEKISTAN", "IRAK", "GHANA" };

        switch (opcion) {
            case 1:
                System.out.println("Lista de paises:");

                for (int i = 0; i < paises.length; i++) {
                    System.out.println((i + 1) + ") " + paises[i]);
                }

                byte[][] banderaSel;
                byte[][] bandera;
                int seleccion;

                while (true) {
                    try {
                        seleccion = ConsoleInput.getInt("Seleccione un país:") - 1;
                        banderaSel = banderas.getBandera(seleccion);

                        break;
                    } catch (RuntimeException e) {
                        System.out.println("Debes ingresar un número de país valido!");
                    }
                }

                System.out.println(paises[seleccion]);

                System.out.println("Escoge el tamaño de la bandera.");
                System.out.println("[1] Ícono\n" +
                                   "[2] Pequeño\n" +
                                   "[3] Mediano\n" +
                                   "[4] Grande");

                int tamaño = ConsoleInput.getInt();

                switch (tamaño) {
                    case 1:
                        bandera = banderas.menor(banderaSel, 2);
                        break;
                    case 2:
                        bandera = banderas.menor(banderaSel, 1);
                        break;
                    case 3:
                        bandera = banderas.agrandar(banderaSel, 2);
                        break;
                    case 4:
                        bandera = banderas.agrandar(banderaSel, 3);
                        break;
                    default:
                        System.out.println("Opción inválida. Se mostrará la bandera en tamaño mediano.");
                        bandera = banderas.menor(banderaSel, 1);
                }

                for (int i = 0; i < bandera.length; i++) {
                    for (int j = 0; j < bandera[i].length; j++) {
                        banderas.printColor(bandera[i][j]);
                    }
                    System.out.println();
                }

                break;

            case 2:
                System.out.println("La tabla de posiciones ");
                posiciones.posiciones();
                break;

            case 3:
                System.out.println("El calendario de partidos ");
                break;

            case 4:
                System.out.println("Saliendo del programa...");
                return;

            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");


        }

}