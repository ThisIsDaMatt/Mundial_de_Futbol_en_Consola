import java.util.Scanner;

public class posiciones {

    static final int PJ = 0, PG = 1, PE = 2, PP = 3, GF = 4, GC = 5, DG = 6, TA = 7, TR = 8, PTS = 9;

    public static void main(String[] args) {
        String[] equipos = {"Inglaterra", "España", "Francia", "Cabo Verde", "Estados Unidos", "Argentina", "Brasil", "Canadá", "Alemania", "Japón", "Colombia", "Bélgica", "Suiza", "Portugal", "Egipto", "Paraguay", "México", "Marruecos", "Austria", "Noruega", "Croacia", "Paises Bajos", "Uruguay", "Qatar", "Sudafrica", "Corea del Sur", "Chequia", "Bosnia y Herzegovina", "Escocia", "Haiti", "Turquia", "Australia", "Curazao", "Costa de Marfil", "Ecuador", "Suecia", "Túnez", "Nueva Zelanda", "Irán", "Arabia Saudita", "Argelia", "Jordania", "Congo RD", "Uzbekistan", "Panamá", "Ghana", "Irak", "Senegal"};
        int n = equipos.length;

        int[][] stats = new int[n][10];

        registrarPartido(stats, 0, 1, 2, 1); // Colombia 2 - 1 Brasil
        registrarPartido(stats, 2, 3, 3, 0); // Argentina 3 - 0 Uruguay
        registrarPartido(stats, 4, 5, 1, 1); // España 1 - 1 Alemania
        registrarPartido(stats, 0, 2, 0, 2); // Colombia 0 - 2 Argentina

        imprimirTabla(equipos, stats);
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

    static void imprimirTabla(String[] equipos, int[][] stats) {
        Scanner sc = new Scanner(System.in);
        int porPagina = 3;

        String encabezado = String.format("%-12s %3s %3s %3s %3s %3s %3s %4s %3s %3s %4s",
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

            System.out.printf("%-12s %3d %3d %3d %3d %3d %3d %4d %3d %3d %4d%n",
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
        sc.close();
    }
}