import java.util.Scanner;

public class posiciones {

    // Constantes para los índices de columna (así no hay que memorizar números)
    static final int PJ = 0, PG = 1, PE = 2, PP = 3, GF = 4, GC = 5, DG = 6, TA = 7, TR = 8, PTS = 9;

    public static void main(String[] args) {
        String[] equipos = {
            "Inglaterra", "España", "Francia", "Cabo Verde", "Estados Unidos", "Argentina",
            "Brasil", "Canadá", "Alemania", "Japón", "Colombia", "Bélgica", "Suiza", "Portugal",
            "Egipto", "Paraguay", "México", "Marruecos", "Austria", "Noruega", "Croacia",
            "Paises Bajos", "Uruguay", "Qatar", "Sudafrica", "Corea del Sur", "Chequia",
            "Bosnia y Herzegovina", "Escocia", "Haiti", "Turquia", "Australia", "Curazao",
            "Costa de Marfil", "Ecuador", "Suecia", "Túnez", "Nueva Zelanda", "Irán",
            "Arabia Saudita", "Argelia", "Jordania", "Congo RD", "Uzbekistan", "Panamá",
            "Ghana", "Irak", "Senegal"
        };
        int n = equipos.length; // 48

        // Matriz de estadísticas: n filas, 10 columnas
        int[][] stats = new int[n][10];

        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Registrar resultado de un partido");
            System.out.println("2. Ver tabla de posiciones");
            System.out.println("3. Salir");
            System.out.print("Elige una opcion: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    registrarPartidoDesdeTeclado(sc, equipos, stats);
                    break;
                case 2:
                    imprimirTabla(sc, equipos, stats);
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }

        System.out.println("Programa finalizado.");
    }

    // Muestra la lista de equipos con su indice, para que el usuario sepa cual escribir
    static void mostrarEquiposConIndice(String[] equipos) {
        for (int i = 0; i < equipos.length; i++) {
            System.out.printf("%2d - %s%n", i + 1, equipos[i]);
        }
    }

    // Pide por teclado los dos equipos y el marcador, valida y actualiza la matriz
    static void registrarPartidoDesdeTeclado(Scanner sc, String[] equipos, int[][] stats) {
        mostrarEquiposConIndice(equipos);

        System.out.print("Número del equipo 1: ");
        int i = sc.nextInt();
        System.out.print("Número del equipo 2: ");
        int j = sc.nextInt();

        if (i < 0 || i >= equipos.length || j < 0 || j >= equipos.length || i == j) {
            System.out.println("Indices invalidos.");
            return;
        }

        System.out.print("Goles de " + equipos[i] + ": ");
        int golesI = sc.nextInt();
        System.out.print("Goles de " + equipos[j] + ": ");
        int golesJ = sc.nextInt();

        registrarPartido(stats, i, j, golesI, golesJ);
        System.out.println("El resultado ha sido registrado.");
    }

    // Actualiza la matriz cuando se juega un partido entre el equipo i y el equipo j
    static void registrarPartido(int[][] stats, int i, int j, int golesI, int golesJ) {
        actualizarEquipo(stats, i, golesI, golesJ);
        actualizarEquipo(stats, j, golesJ, golesI);
    }

    static void actualizarEquipo(int[][] stats, int idx, int golesFavor, int golesContra) {
        stats[idx][PJ]++;
        stats[idx][GF] += golesFavor;
        stats[idx][GC] += golesContra;
        stats[idx][DG] = stats[idx][GF] - stats[idx][GC];

        if (golesFavor > golesContra) {
            stats[idx][PG]++;
        } else if (golesFavor == golesContra) {
            stats[idx][PE]++;
        } else {
            stats[idx][PP]++;
        }

        stats[idx][PTS] = stats[idx][PG] * 3 + stats[idx][PE];
    }

    // Ordena los equipos de mayor a menor segun sus puntos (bubble sort)
    static void ordenarPorPuntos(String[] equipos, int[][] stats) {
        int n = equipos.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (stats[j][PTS] < stats[j + 1][PTS]) {
                    // Intercambia el nombre del equipo
                    String tempNombre = equipos[j];
                    equipos[j] = equipos[j + 1];
                    equipos[j + 1] = tempNombre;

                    // Intercambia toda la fila de estadisticas
                    int[] tempFila = stats[j];
                    stats[j] = stats[j + 1];
                    stats[j + 1] = tempFila;
                }
            }
        }
    }

    // Encuentra la longitud del nombre de equipo más largo, para que la tabla no se desalinee
    static int calcularAnchoNombre(String[] equipos) {
        int max = 0;
        for (String nombre : equipos) {
            if (nombre.length() > max) {
                max = nombre.length();
            }
        }
        return max + 1; // +1 de margen
    }

    // Imprime la matriz como tabla formateada, paginando cada "porPagina" filas
    static void imprimirTabla(Scanner sc, String[] equipos, int[][] stats) {
        ordenarPorPuntos(equipos, stats);
        sc.nextLine(); // limpia el salto de linea que quedó pendiente de nextInt()
        int porPagina = 10;
        int anchoNombre = calcularAnchoNombre(equipos);

        String formatoEncabezado = "%-" + anchoNombre + "s %3s %3s %3s %3s %3s %3s %4s %3s %3s %4s";
        String formatoFila = "%-" + anchoNombre + "s %3d %3d %3d %3d %3d %3d %4d %3d %3d %4d%n";

        String encabezado = String.format(formatoEncabezado,
                "Equipo", "PJ", "PG", "PE", "PP", "GF", "GC", "DG", "TA", "TR", "Pts");

        for (int i = 0; i < equipos.length; i++) {
            if (i % porPagina == 0) {
                System.out.println(encabezado);
                StringBuilder linea = new StringBuilder();
                for (int k = 0; k < encabezado.length(); k++) {
                    linea.append("-");
                }
                System.out.println(linea);
            }

            System.out.printf(formatoFila,
                    equipos[i],
                    stats[i][PJ], stats[i][PG], stats[i][PE], stats[i][PP],
                    stats[i][GF], stats[i][GC], stats[i][DG], stats[i][TA], stats[i][TR], stats[i][PTS]);

            boolean finDePagina = (i + 1) % porPagina == 0;
            boolean esUltimo = i == equipos.length - 1;

            if (finDePagina && !esUltimo) {
                System.out.println("\n--- Presiona ENTER para ver más ---");
                sc.nextLine();
                System.out.println();
            }
        }
    }
}