import java.util.Scanner;

public class posiciones {

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

        int[][] stats = new int[n][10];

        int[][] historial = new int[500][4];
        int[] numPartidos = {0};

        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Registrar resultado de un partido");
            System.out.println("2. Ver tabla de posiciones");
            System.out.println("3. Salir");
            System.out.println("4. Corregir un partido ya registrado");
            System.out.print("Elige una opcion: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    registrarPartidoDesdeTeclado(sc, equipos, stats, historial, numPartidos);
                    break;
                case 2:
                    imprimirTabla(sc, equipos, stats);
                    break;
                case 3:
                    salir = true;
                    break;
                case 4:
                    corregirPartido(sc, equipos, stats, historial, numPartidos);
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }

        System.out.println("Programa finalizado.");
    }

    static void mostrarEquiposConIndice(String[] equipos) {
        for (int i = 0; i < equipos.length; i++) {
            System.out.printf("%2d - %s%n", i + 1, equipos[i]);
        }
    }

    static void registrarPartidoDesdeTeclado(Scanner sc, String[] equipos, int[][] stats, int[][] historial, int[] numPartidos) {
        mostrarEquiposConIndice(equipos);

        System.out.print("Número del equipo 1 (1 a " + equipos.length + "): ");
        int i = sc.nextInt() - 1;
        System.out.print("Número del equipo 2 (1 a " + equipos.length + "): ");
        int j = sc.nextInt() - 1;

        if (i < 0 || i >= equipos.length || j < 0 || j >= equipos.length || i == j) {
            System.out.println("Numeros invalidos.");
            return;
        }

        System.out.print("Goles de " + equipos[i] + ": ");
        int golesI = sc.nextInt();
        System.out.print("Goles de " + equipos[j] + ": ");
        int golesJ = sc.nextInt();

        int p = numPartidos[0];
        historial[p][0] = i;
        historial[p][1] = j;
        historial[p][2] = golesI;
        historial[p][3] = golesJ;
        numPartidos[0]++;

        registrarPartido(stats, i, j, golesI, golesJ);
        System.out.println("El resultado ha sido registrado.");
    }

    static void corregirPartido(Scanner sc, String[] equipos, int[][] stats, int[][] historial, int[] numPartidos) {
        if (numPartidos[0] == 0) {
            System.out.println("Todavia no hay partidos registrados.");
            return;
        }

        for (int p = 0; p < numPartidos[0]; p++) {
            int eq1 = historial[p][0];
            int eq2 = historial[p][1];
            System.out.printf("%2d - %s %d - %d %s%n", p + 1, equipos[eq1], historial[p][2], historial[p][3], equipos[eq2]);
        }

        System.out.print("Numero del partido a corregir: ");
        int p = sc.nextInt() - 1;

        if (p < 0 || p >= numPartidos[0]) {
            System.out.println("Numero invalido.");
            return;
        }

        System.out.print("Nuevos goles de " + equipos[historial[p][0]] + ": ");
        int nuevosGolesI = sc.nextInt();
        System.out.print("Nuevos goles de " + equipos[historial[p][1]] + ": ");
        int nuevosGolesJ = sc.nextInt();

        historial[p][2] = nuevosGolesI;
        historial[p][3] = nuevosGolesJ;

        recalcularEstadisticas(stats, historial, numPartidos[0]);
        System.out.println("Partido corregido y estadisticas recalculadas.");
    }

    static void recalcularEstadisticas(int[][] stats, int[][] historial, int totalPartidos) {
        for (int i = 0; i < stats.length; i++) {
            for (int j = 0; j < stats[i].length; j++) {
                stats[i][j] = 0;
            }
        }

        for (int p = 0; p < totalPartidos; p++) {
            int eqI = historial[p][0];
            int eqJ = historial[p][1];
            int golesI = historial[p][2];
            int golesJ = historial[p][3];
            registrarPartido(stats, eqI, eqJ, golesI, golesJ);
        }
    }

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

    static void ordenarPorPuntos(String[] equipos, int[][] stats) {
        int n = equipos.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (stats[j][PTS] < stats[j + 1][PTS]) {
                    // Intercambia el nombre del equipo
                    String tempNombre = equipos[j];
                    equipos[j] = equipos[j + 1];
                    equipos[j + 1] = tempNombre;

                    int[] tempFila = stats[j];
                    stats[j] = stats[j + 1];
                    stats[j + 1] = tempFila;
                }
            }
        }
    }

    static int calcularAnchoNombre(String[] equipos) {
        int max = 0;
        for (String nombre : equipos) {
            if (nombre.length() > max) {
                max = nombre.length();
            }
        }
        return max + 1; // +1 de margen
    }

    static void imprimirTabla(Scanner sc, String[] equipos, int[][] stats) {
        ordenarPorPuntos(equipos, stats);
        sc.nextLine(); 
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