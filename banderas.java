
/**
 * PASO 1: MATRIX 2 CONSOLE
 * Banderas: España, Francia, Cabo Verde, Corea del Sur, Congo RD, Ecuador, Arabia Saudí.
 *
 * Cada bandera se guarda en una matriz "base" de 12 filas x 18 columnas (máximo detalle).
 * Cada celda contiene un código de color (tabla COLORES BANDERAS):
 *   1 amarillo | 2 naranja | 3 rojo | 4 morado | 5 azul | 6 verde | 7 blanco | 8 negro | 9 café
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class banderas {

    private static final int FILAS = 10;
    private static final int COLS = 15;
    private static final int TOTAL_PAISES = 48;

    private static final String[] COLORES = {
            "\033[43m", // Amarillo
            "\033[48;5;208m", // Naranja
            "\033[41m", // Rojo
            "\033[45m", // Morado
            "\033[44m", // Azul
            "\033[42m", // Verde
            "\033[47m", // Blanco
            "\033[40m", // Negro
            "\033[48;5;88m", // Cafe
    };

    /**
     * Da el array con los colores de la bandera del pais dado.
     *
     * @param pais Índice del país en la tabla.
     * @return Array bidimensional con los colores de la bandera del país.
     */

    public static byte[][] getBandera(int pais) throws FileNotFoundException {
        byte[][] bandera = new byte[FILAS][COLS];

        Scanner sc = new Scanner(new File("./banderas.csv"));

        // TODO: Usar IllegalArgumentException con mensaje en vez de RuntimeException
        // vacía
        if (pais < 0 || pais > TOTAL_PAISES - 1) {
            throw new RuntimeException();
        }

        int saltos = (FILAS * pais) + (pais + 1);

        for (int i = 0; i < saltos; i++) {
            sc.nextLine();
        }

        for (int i = 0; i < FILAS; i++) {

            String[] lineaActual = sc.nextLine().split(",");

            for (int j = 0; j < COLS; j++) {
                bandera[i][j] = Byte.parseByte(lineaActual[j]);
            }
        }

        sc.close();

        return bandera;
    }

    public static byte[][] menor(byte[][] array, int factor) {

        // Da el tamaño del array tras ser diezmado.
        int filas = array.length / factor;
        int cols = array[0].length / factor;

        byte[][] arrayMenor = new byte[filas][cols];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                arrayMenor[i][j] = array[i * factor][j * factor];
    
            }
        }
        return arrayMenor;
    }
    public static byte[][] agrandar(byte[][] array, int factor) {

        // Da el tamaño del array tras ser interpolado.
        int filas = array.length * factor;
        int cols = array[0].length * factor;

        byte[][] arrayAgrandar = new byte[filas][cols];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                arrayAgrandar[i][j] = array[i / factor][j / factor];
            }
        }

        return arrayAgrandar;
    }
}
