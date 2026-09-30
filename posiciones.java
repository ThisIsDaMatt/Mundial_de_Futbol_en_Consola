import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class posiciones {

    static final int PJ = 0, PG = 1, PE = 2, PP = 3, GF = 4, GC = 5, DG = 6, TA = 7, TR = 8, PTS = 9;
    private static final String ARCHIVO_RESULTADOS = "resultados_grupos.txt";
    private static String[] equiposCompartidos;
    private static int[][] statsCompartidas;
    private static final int[][] historialCompartido = new int[500][4];
    private static final String[] identificadoresCompartidos = new String[500];
    private static int cantidadPartidos;

    public static void main(String[] args) {
        String[] equipos = inicializarEquipos();
        cargarResultadosDesdeArchivo();
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n=== TABLA DE POSICIONES ===");
            System.out.println("1. Ver tabla de posiciones");
            System.out.println("2. Corregir un partido ya registrado");
            System.out.println("3. Salir");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    cargarResultadosDesdeArchivo();
                    imprimirTabla(sc, equipos, statsCompartidas);
                    break;
                case 2:
                    corregirPartido(sc, equipos, statsCompartidas);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 3);

        System.out.println("Programa finalizado.");
    }

    private static String[] inicializarEquipos() {
        if (equiposCompartidos == null) {
            equiposCompartidos = new String[] {
                "Inglaterra", "España", "Francia", "Cabo Verde", "Estados Unidos", "Argentina",
                "Brasil", "Canadá", "Alemania", "Japón", "Colombia", "Bélgica", "Suiza", "Portugal",
                "Egipto", "Paraguay", "México", "Marruecos", "Austria", "Noruega", "Croacia",
                "Paises Bajos", "Uruguay", "Qatar", "Sudafrica", "Corea del Sur", "Chequia",
                "Bosnia y Herzegovina", "Escocia", "Haiti", "Turquia", "Australia", "Curazao",
                "Costa de Marfil", "Ecuador", "Suecia", "Túnez", "Nueva Zelanda", "Irán",
                "Arabia Saudita", "Argelia", "Jordania", "Congo RD", "Uzbekistan", "Panamá",
                "Ghana", "Irak", "Senegal"
            };
            statsCompartidas = new int[equiposCompartidos.length][10];
        }
        return equiposCompartidos;
    }

    public static void registrarResultadoDesdeFixture(String equipoLocal, String equipoVisitante,
                int golesLocal, int golesVisitante) {
            inicializarEquipos();
            int indiceLocal = buscarEquipo(equipoLocal);
            int indiceVisitante = buscarEquipo(equipoVisitante);
            if (indiceLocal == -1 || indiceVisitante == -1) {
                System.out.println("No se pudo actualizar la tabla para: " + equipoLocal + " vs. " + equipoVisitante);
                return;
            }
            registrarPartido(statsCompartidas, indiceLocal, indiceVisitante, golesLocal, golesVisitante);
            historialCompartido[cantidadPartidos][0] = indiceLocal;
            historialCompartido[cantidadPartidos][1] = indiceVisitante;
            historialCompartido[cantidadPartidos][2] = golesLocal;
            historialCompartido[cantidadPartidos][3] = golesVisitante;
            cantidadPartidos++;
    }

    public static void corregirResultadoDesdeFixture(String equipoLocal, String equipoVisitante,
            int golesLocalesAnteriores, int golesVisitantesAnteriores,
            int golesLocalesNuevos, int golesVisitantesNuevos) {
        inicializarEquipos();
        int indiceLocal = buscarEquipo(equipoLocal);
        int indiceVisitante = buscarEquipo(equipoVisitante);
        if (indiceLocal == -1 || indiceVisitante == -1) return;
        actualizarPartido(statsCompartidas, indiceLocal, indiceVisitante,
                golesLocalesAnteriores, golesVisitantesAnteriores, -1);
        actualizarPartido(statsCompartidas, indiceLocal, indiceVisitante,
                golesLocalesNuevos, golesVisitantesNuevos, 1);
        for (int i = 0; i < cantidadPartidos; i++) {
            if (historialCompartido[i][0] == indiceLocal && historialCompartido[i][1] == indiceVisitante) {
                historialCompartido[i][2] = golesLocalesNuevos;
                historialCompartido[i][3] = golesVisitantesNuevos;
                break;
            }
        }
    }

    public static void mostrarTablaDesdeFixture(Scanner sc) {
        inicializarEquipos();
        cargarResultadosDesdeArchivo();
        imprimirTabla(sc, equiposCompartidos, statsCompartidas);
    }

    private static void corregirPartido(Scanner sc, String[] equipos, int[][] stats) {
        if (cantidadPartidos == 0) {
            System.out.println("Todavia no hay partidos registrados.");
            return;
        }

        for (int i = 0; i < cantidadPartidos; i++) {
            int local = historialCompartido[i][0];
            int visitante = historialCompartido[i][1];
            System.out.printf("%2d - %s %d - %d %s%n", i + 1, equipos[local],
                    historialCompartido[i][2], historialCompartido[i][3], equipos[visitante]);
        }

        System.out.print("Numero del partido a corregir: ");
        int partido = sc.nextInt() - 1;
        if (partido < 0 || partido >= cantidadPartidos) {
            System.out.println("Numero invalido.");
            return;
        }

        int local = historialCompartido[partido][0];
        int visitante = historialCompartido[partido][1];
        int golesLocalesAnteriores = historialCompartido[partido][2];
        int golesVisitantesAnteriores = historialCompartido[partido][3];
        System.out.print("Nuevos goles de " + equipos[local] + ": ");
        int golesLocalesNuevos = sc.nextInt();
        System.out.print("Nuevos goles de " + equipos[visitante] + ": ");
        int golesVisitantesNuevos = sc.nextInt();

        actualizarPartido(stats, local, visitante, golesLocalesAnteriores, golesVisitantesAnteriores, -1);
        actualizarPartido(stats, local, visitante, golesLocalesNuevos, golesVisitantesNuevos, 1);
        historialCompartido[partido][2] = golesLocalesNuevos;
        historialCompartido[partido][3] = golesVisitantesNuevos;
        guardarResultadosEnArchivo();
        System.out.println("Partido corregido y estadisticas recalculadas.");
    }

    private static void cargarResultadosDesdeArchivo() {
        inicializarEquipos();
        for (int i = 0; i < statsCompartidas.length; i++) {
            for (int j = 0; j < statsCompartidas[i].length; j++) statsCompartidas[i][j] = 0;
        }
        cantidadPartidos = 0;
        if (!Files.exists(Paths.get(ARCHIVO_RESULTADOS))) return;

        try {
            List<String> registros = Files.readAllLines(Paths.get(ARCHIVO_RESULTADOS), StandardCharsets.UTF_8);
            for (String registro : registros) {
                String[] datos = registro.split("\\|");
                if (datos.length != 5) continue;
                int cantidadAnterior = cantidadPartidos;
                registrarResultadoDesdeFixture(datos[1], datos[2], Integer.parseInt(datos[3]), Integer.parseInt(datos[4]));
                if (cantidadPartidos > cantidadAnterior) {
                    identificadoresCompartidos[cantidadPartidos - 1] = datos[0];
                }
            }
        } catch (IOException | NumberFormatException excepcion) {
            System.out.println("No se pudieron cargar los resultados guardados.");
        }
    }

    private static void guardarResultadosEnArchivo() {
        List<String> registros = new ArrayList<>();
        for (int i = 0; i < cantidadPartidos; i++) {
            String identificador = identificadoresCompartidos[i] == null ? "P" + (i + 1) : identificadoresCompartidos[i];
            registros.add(identificador + "|" + equiposCompartidos[historialCompartido[i][0]] + "|"
                    + equiposCompartidos[historialCompartido[i][1]] + "|" + historialCompartido[i][2] + "|"
                    + historialCompartido[i][3]);
        }
        try {
            Files.write(Paths.get(ARCHIVO_RESULTADOS), registros, StandardCharsets.UTF_8);
        } catch (IOException excepcion) {
            System.out.println("No se pudieron guardar los resultados corregidos.");
        }
    }

    private static int buscarEquipo(String nombre) {
        String nombreNormalizado = normalizar(nombre);
        for (int i = 0; i < equiposCompartidos.length; i++) {
            if (normalizar(equiposCompartidos[i]).equals(nombreNormalizado)) return i;
        }

        String nombreCanonico;
        switch (nombreNormalizado) {
            case "ee uu": nombreCanonico = "estados unidos"; break;
            case "c marfil": nombreCanonico = "costa de marfil"; break;
            case "corea sur": nombreCanonico = "corea del sur"; break;
            case "p bajos": nombreCanonico = "paises bajos"; break;
            case "n zelanda": nombreCanonico = "nueva zelanda"; break;
            case "arabia s": nombreCanonico = "arabia saudita"; break;
            case "dr congo": nombreCanonico = "congo rd"; break;
            case "bosnia": nombreCanonico = "bosnia y herzegovina"; break;
            case "iraq": nombreCanonico = "irak"; break;
            default: nombreCanonico = nombreNormalizado;
    }
        for (int i = 0; i < equiposCompartidos.length; i++) {
            if (normalizar(equiposCompartidos[i]).equals(nombreCanonico)) return i;
        }
        return -1;
    }

    private static String normalizar(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .replaceAll("[^a-zA-Z0-9]", " ")
                .trim()
                .replaceAll(" +", " ")
                .toLowerCase();
    }

    static void registrarPartido(int[][] stats, int i, int j, int golesI, int golesJ) {
        actualizarPartido(stats, i, j, golesI, golesJ, 1);
    }

    private static void actualizarPartido(int[][] stats, int i, int j, int golesI, int golesJ, int factor) {
        actualizarEquipo(stats, i, golesI, golesJ, factor);
        actualizarEquipo(stats, j, golesJ, golesI, factor);
    }

    static void actualizarEquipo(int[][] stats, int idx, int golesFavor, int golesContra, int factor) {
        stats[idx][PJ] += factor;
        stats[idx][GF] += factor * golesFavor;
        stats[idx][GC] += factor * golesContra;
        stats[idx][DG] = stats[idx][GF] - stats[idx][GC];

        if (golesFavor > golesContra) {
            stats[idx][PG] += factor;
        } else if (golesFavor == golesContra) {
            stats[idx][PE] += factor;
        } else {
            stats[idx][PP] += factor;
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
        String[] equiposOrdenados = equipos.clone();
        int[][] statsOrdenadas = new int[stats.length][];
        for (int i = 0; i < stats.length; i++) statsOrdenadas[i] = stats[i].clone();
        ordenarPorPuntos(equiposOrdenados, statsOrdenadas);
        sc.nextLine(); 
        int porPagina = 10;
        int anchoNombre = calcularAnchoNombre(equiposOrdenados);

        String formatoEncabezado = "%-" + anchoNombre + "s %3s %3s %3s %3s %3s %3s %4s %3s %3s %4s";
        String formatoFila = "%-" + anchoNombre + "s %3d %3d %3d %3d %3d %3d %4d %3d %3d %4d%n";

        String encabezado = String.format(formatoEncabezado,
                "Equipo", "PJ", "PG", "PE", "PP", "GF", "GC", "DG", "TA", "TR", "Pts");

        for (int i = 0; i < equiposOrdenados.length; i++) {
            if (i % porPagina == 0) {
                System.out.println(encabezado);
                StringBuilder linea = new StringBuilder();
                for (int k = 0; k < encabezado.length(); k++) {
                    linea.append("-");
                }
                System.out.println(linea);
            }

            System.out.printf(formatoFila,
                    equiposOrdenados[i],
                    statsOrdenadas[i][PJ], statsOrdenadas[i][PG], statsOrdenadas[i][PE], statsOrdenadas[i][PP],
                    statsOrdenadas[i][GF], statsOrdenadas[i][GC], statsOrdenadas[i][DG], statsOrdenadas[i][TA],
                    statsOrdenadas[i][TR], statsOrdenadas[i][PTS]);

            boolean finDePagina = (i + 1) % porPagina == 0;
            boolean esUltimo = i == equiposOrdenados.length - 1;

            if (finDePagina && !esUltimo) {
                System.out.println("\n--- Presiona ENTER para ver más ---");
                sc.nextLine();
                System.out.println();
            }
        }
    }
}