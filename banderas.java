/**
 * PASO 1: MATRIX 2 CONSOLE
 * Banderas: España, Francia, Cabo Verde, Corea del Sur, Congo RD, Ecuador, Arabia Saudí.
 *
 * Cada bandera se guarda en una matriz "base" de 12 filas x 18 columnas (máximo detalle).
 * Cada celda contiene un código de color (tabla COLORES BANDERAS):
 *   1 amarillo | 2 naranja | 3 rojo | 4 morado | 5 azul | 6 verde | 7 blanco | 8 negro | 9 café
*/
import java.util.Scanner;

public class banderas {

    // CONSOLA DE COLORES
    public static final String RESET   = "\u001B[0m";
    public static final String AMARILLO = "\u001B[43m";
    public static final String NARANJA  = "\u001B[48;5;208m";
    public static final String ROJO     = "\u001B[41m";
    public static final String MORADO   = "\u001B[45m";
    public static final String AZUL     = "\u001B[44m";
    public static final String VERDE    = "\u001B[42m";
    public static final String BLANCO   = "\u001B[47m";
    public static final String NEGRO    = "\u001B[40m";
    public static final String CAFE     = "\u001B[48;5;94m";

    static final int FILAS = 12;
    static final int COLS  = 18;

    // Tamaños: 
    static final int[] GRANDE  = {1, 1}; // 12 x 18  
    static final int[] MEDIANO = {2, 2}; //  6 x 9
    static final int[] PEQUENO = {3, 3}; //  4 x 6
    static final int[] ICONO   = {4, 6}; //  3 x 3   

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nombres = {"España", "Francia", "Cabo Verde", "Corea del Sur",
                            "Congo RD", "Ecuador", "Arabia Saudí", "Inglaterra"};
        char[][][] banderas = {
            crearEspana(), crearFrancia(), crearCaboVerde(), crearCoreaDelSur(),
            crearCongoRD(), crearEcuador(), crearArabiaSaudi(), crearInglaterra()
        };

        String[] nombresTamano = {"Grande", "Mediano", "Pequeño", "Ícono"};
        int[][] tamanos = {GRANDE, MEDIANO, PEQUENO, ICONO};

        boolean seguir = true;
        while (seguir) {
            // 1) Preguntar la bandera
            System.out.println("\n=========== BANDERAS ===========");
            for (int i = 0; i < nombres.length; i++) {
                System.out.println("  " + (i + 1) + ". " + nombres[i]);
            }
            System.out.println("  0. Salir");
            int pais = leerOpcion(sc, "¿Qué bandera quieres ver? ", 0, nombres.length);
            if (pais == 0) break;

            // 2) Preguntar el tamaño
            System.out.println("\n--- TAMAÑOS ---");
            for (int i = 0; i < nombresTamano.length; i++) {
                System.out.println("  " + (i + 1) + ". " + nombresTamano[i]);
            }
            int tam = leerOpcion(sc, "¿En qué tamaño? ", 1, nombresTamano.length);

            // 3) Dibujar
            mostrar(nombres[pais - 1] + " (" + nombresTamano[tam - 1] + ")",
                    banderas[pais - 1], tamanos[tam - 1]);

            // 4) Volver a empezar?
            System.out.print("\n¿Ver otra bandera? (s/n): ");
            String resp = sc.nextLine().trim().toLowerCase();
            seguir = resp.startsWith("s");
        }
        System.out.println("¡Hasta pronto!");
        sc.close();
    }

    static int leerOpcion(Scanner sc, String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            try {
                int n = Integer.parseInt(sc.nextLine().trim());
                if (n >= min && n <= max) return n;
            } catch (NumberFormatException e) {
                // cae al mensaje de error
            }
            System.out.println("Opción no válida. Escribe un número entre " + min + " y " + max + ".");
        }
    }

    // ========================================================================
    //  ALGORITMO DE ESCALADO
    // ========================================================================

    static void mostrar(String titulo, char[][] base, int[] tamano) {
        System.out.println("\n--- " + titulo + " ---");
        dibujar(reducir(base, tamano[0], tamano[1]));
    }

    static char[][] reducir(char[][] base, int ff, int fc) {
        int nf = base.length / ff;
        int nc = base[0].length / fc;
        char[][] r = new char[nf][nc];
        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {
                int[] cuenta = new int[10];
                for (int a = 0; a < ff; a++) {
                    for (int b = 0; b < fc; b++) {
                        cuenta[base[i * ff + a][j * fc + b] - '0']++;
                    }
                }
                int mejor = 1;
                for (int k = 1; k <= 9; k++) {
                    if (cuenta[k] >= cuenta[mejor]) mejor = k; 
                }
                r[i][j] = (char) ('0' + mejor);
            }
        }
        return r;
    }

    /** Pinta la matriz en consola: cada celda = 2 espacios con color de fondo. */
    static void dibujar(char[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(colorAnsi(m[i][j]) + "  ");
            }
            System.out.println(RESET);
        }
    }

    static String colorAnsi(char c) {
        switch (c) {
            case '1': return AMARILLO;
            case '2': return NARANJA;
            case '3': return ROJO;
            case '4': return MORADO;
            case '5': return AZUL;
            case '6': return VERDE;
            case '7': return BLANCO;
            case '8': return NEGRO;
            case '9': return CAFE;
            default:  return RESET;
        }
    }

    // ========================================================================
    //  HERRAMIENTAS PARA DIBUJAR EN LA MATRIZ
    // ========================================================================

    static char[][] nueva(char fondo) {
        char[][] m = new char[FILAS][COLS];
        for (int i = 0; i < FILAS; i++)
            for (int j = 0; j < COLS; j++)
                m[i][j] = fondo;
        return m;
    }

    /** Rellena un rectángulo (límites incluidos). */
    static void rect(char[][] m, int f1, int f2, int c1, int c2, char color) {
        for (int i = f1; i <= f2; i++)
            for (int j = c1; j <= c2; j++)
                m[i][j] = color;
    }

    /** Escribe una cadena de códigos de color desde (fila, col). */
    static void poner(char[][] m, int f, int c, String s) {
        for (int k = 0; k < s.length(); k++) m[f][c + k] = s.charAt(k);
    }

    // ========================================================================
    //  BANDERAS (matriz base 12 x 18)
    // ========================================================================

    /** Francia: azul, blanco, rojo (vertical). */
    static char[][] crearFrancia() {
        char[][] m = nueva('7');
        rect(m, 0, 11, 0, 5, '5');
        rect(m, 0, 11, 6, 11, '7');
        rect(m, 0, 11, 12, 17, '3');
        return m;
    }

    /** España: rojo, amarillo (doble), rojo + escudo simplificado. */
    static char[][] crearEspana() {
        char[][] m = nueva('3');
        rect(m, 3, 8, 0, 17, '1');
        poner(m, 5, 4, "999");
        poner(m, 6, 4, "939");
        poner(m, 7, 4, "999");
        return m;
    }

    /** Ecuador: amarillo (mitad), azul, rojo + escudo central. */
    static char[][] crearEcuador() {
        char[][] m = nueva('1');
        rect(m, 6, 8, 0, 17, '5');
        rect(m, 9, 11, 0, 17, '3');
        poner(m, 3, 8, "55");
        poner(m, 4, 7, "5665");
        poner(m, 5, 7, "5775");
        poner(m, 6, 7, "9779");
        poner(m, 7, 8, "99");
        return m;
    }

    /** Cabo Verde: azul, franjas blanca-roja-blanca y círculo de 10 estrellas. */
    static char[][] crearCaboVerde() {
        char[][] m = nueva('5');
        rect(m, 7, 7, 0, 17, '7');
        rect(m, 8, 8, 0, 17, '3');
        rect(m, 9, 9, 0, 17, '7');
        int[][] estrellas = {
            {5, 6}, {6, 8}, {7, 9}, {9, 9}, {10, 8},
            {11, 6}, {10, 4}, {9, 3}, {7, 3}, {6, 4}
        };
        for (int[] e : estrellas) m[e[0]][e[1]] = '1';
        return m;
    }

    /** Congo RD: fondo azul, franja roja diagonal con bordes amarillos y estrella. */
    static char[][] crearCongoRD() {
        char[][] m = nueva('5');
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLS; j++) {
                // distancia horizontal a la diagonal de la bandera 
                double d = Math.abs(j - 1.545 * (FILAS - 1 - i));
                if (d <= 1.5) m[i][j] = '3';       // franja roja
                else if (d <= 2.7) m[i][j] = '1';  // bordes amarillos
            }
        }
        poner(m, 0, 2, "1");
        poner(m, 1, 1, "111");
        poner(m, 2, 2, "1");
        return m;
    }

    /** Corea del Sur: fondo blanco, taegeuk (rojo/azul) y 4 trigramas negros. */
    static char[][] crearCoreaDelSur() {
        char[][] m = nueva('7');
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLS; j++) {
                double dy = i + 0.5 - 6, dx = j + 0.5 - 9;
                if (dx * dx + dy * dy <= 6.8) m[i][j] = (i < 6) ? '3' : '5';
            }
        }
        trigrama(m, 0, 1,  "SSS"); // arriba-izq: tres líneas completas
        trigrama(m, 0, 12, "RSR"); // arriba-der
        trigrama(m, 7, 1,  "SRS"); // abajo-izq
        trigrama(m, 7, 12, "RRR"); // abajo-der: tres líneas partidas
        return m;
    }

    /** S = línea sólida, R = línea rota. Cada línea ocupa una fila separada por una fila vacía. */
    static void trigrama(char[][] m, int f, int c, String tipo) {
        for (int k = 0; k < 3; k++) {
            poner(m, f + 2 * k, c, tipo.charAt(k) == 'S' ? "88888" : "88788");
        }
    }

    /** Arabia Saudí: fondo verde, texto (shahada) y espada en blanco. */
    static char[][] crearArabiaSaudi() {
        char[][] m = nueva('6');
        poner(m, 3, 4, "7767776777");
        poner(m, 4, 4, "7677767677");
        poner(m, 5, 4, "7776767777");
        rect(m, 8, 8, 3, 14, '7'); // hoja de la espada
        m[7][12] = '7';            // empuñadura
        m[9][12] = '7';
        return m;
    }

    /** Inglaterra: fondo blanco, cruz roja. */
    static char[][] crearInglaterra() {
    char[][] m = nueva('7');           // fondo blanco
    rect(m, 0, 11, 8, 9, '3');        // franja roja vertical (centro)
    rect(m, 5, 6, 0, 17, '3');        // franja roja horizontal (centro)
    return m;
}
    }

