import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Partidos {
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final int PARTIDOS_DE_GRUPOS = 72;
	private static final String ARCHIVO_RESULTADOS = "resultados_grupos.txt";
	private static List<Partido> partidosDeGrupo;
	private static List<Partido> fase32;
	private static List<Partido> octavos;
	private static List<Partido> cuartos;
	private static List<Partido> semifinales;
	private static Partido tercerPuesto;
	private static Partido finalMundial;
	private static boolean gruposJugados;

	private static class Partido {
		private final String identificador;
		private final String horario;
		private final String local;
		private final String visitante;
		private Resultado resultado;

		private Partido(String identificador, String horario, String local, String visitante) {
			this.identificador = identificador;
			this.horario = horario;
			this.local = local;
			this.visitante = visitante;
		}

		private String ganador() {
			if (resultado.golesLocal > resultado.golesVisitante) {
				return local;
			}
			if (resultado.golesVisitante > resultado.golesLocal) {
				return visitante;
			}
			return resultado.ganadorPorPenales;
		}
	}

	private static class Resultado {
		private final int golesLocal;
		private final int golesVisitante;
		private final String ganadorPorPenales;

		private Resultado(int golesLocal, int golesVisitante, String ganadorPorPenales) {
			this.golesLocal = golesLocal;
			this.golesVisitante = golesVisitante;
			this.ganadorPorPenales = ganadorPorPenales;
		}
	}

	private static class Equipo {
		private final String nombre;
		private int puntos;
		private int golesFavor;
		private int golesContra;

		private Equipo(String nombre) {
			this.nombre = nombre;
		}

		private int diferenciaDeGoles() {
			return golesFavor - golesContra;
		}
	}

	private static class ConsoleInput {
		public static int leerEntero(String mensaje) {
			while (true) {
				System.out.print(mensaje);
				String entrada = SCANNER.nextLine();
				try {
					return Integer.parseInt(entrada.trim());
				} catch (NumberFormatException e) {
					System.out.println("Entrada invalida. Debe ingresar un numero entero.");
				}
			}
		}

		public static int leerGoles(String equipo) {
			int goles = leerEntero("Goles de " + equipo + ": ");
			while (goles < 0) {
				System.out.println("Los goles no pueden ser negativos.");
				goles = leerEntero("Goles de " + equipo + ": ");
			}
			return goles;
		}
	}

	public static void main(String[] args) {
		try {
			partidosDeGrupo = cargarPartidos();
			cargarResultadosGuardados();
		} catch (IOException excepcion) {
			System.out.println("No se encontro partidos_mundial_2026.txt.");
			return;
		}

		int opcion;
		do {
			mostrarMenu();
			opcion = ConsoleInput.leerEntero("Seleccione una opcion: ");
			System.out.println();
			switch (opcion) {
				case 1:
					jugarFaseDeGrupos();
					break;
				case 2:
					mostrarPartidoDeGrupos();
					break;
				case 3:
					jugarFase32();
					break;
				case 4:
					jugarOctavos();
					break;
				case 5:
					jugarCuartos();
					break;
				case 6:
					jugarSemifinales();
					break;
				case 7:
					jugarTercerPuesto();
					break;
				case 8:
					jugarFinal();
					break;
				case 9:
					System.out.println("Programa finalizado.");
					break;
				default:
					System.out.println("Opcion invalida.");
			}
			System.out.println();
		} while (opcion != 9);
	}

	private static List<Partido> cargarPartidos() throws IOException {
		List<String> registros = Files.readAllLines(Paths.get("partidos_mundial_2026.txt"), StandardCharsets.UTF_8);
		List<Partido> partidos = new ArrayList<>();
		for (int i = 0; i < PARTIDOS_DE_GRUPOS; i++) {
			String[] datos = registros.get(i).split("\\|");
			partidos.add(new Partido(datos[0], datos[1], datos[2], datos[4]));
		}
		return partidos;
	}

	private static void cargarResultadosGuardados() throws IOException {
		if (!Files.exists(Paths.get(ARCHIVO_RESULTADOS))) return;
		List<String> registros = Files.readAllLines(Paths.get(ARCHIVO_RESULTADOS), StandardCharsets.UTF_8);
		for (String registro : registros) {
			String[] datos = registro.split("\\|");
			if (datos.length != 5) continue;
			for (Partido partido : partidosDeGrupo) {
				if (partido.identificador.equals(datos[0])) {
					partido.resultado = new Resultado(Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), null);
					break;
				}
			}
		}
		gruposJugados = rondaCompleta(partidosDeGrupo);
	}

	private static void guardarResultados() {
		List<String> registros = new ArrayList<>();
		for (Partido partido : partidosDeGrupo) {
			if (partido.resultado != null) {
				registros.add(partido.identificador + "|" + partido.local + "|" + partido.visitante + "|"
						+ partido.resultado.golesLocal + "|" + partido.resultado.golesVisitante);
			}
		}
		try {
			Files.write(Paths.get(ARCHIVO_RESULTADOS), registros, StandardCharsets.UTF_8);
		} catch (IOException excepcion) {
			System.out.println("No se pudieron guardar los resultados de grupos.");
		}
	}

	private static void mostrarMenu() {
		System.out.println("========== FIXTURE MUNDIAL 2026 ==========");
		System.out.println("1. Jugar fase de grupos");
		System.out.println("2. Jugar un partido de grupos especifico");
		System.out.println("3. Jugar fase de 32");
		System.out.println("4. Jugar octavos de final");
		System.out.println("5. Jugar cuartos de final");
		System.out.println("6. Jugar semifinales");
		System.out.println("7. Jugar partido por el tercer puesto");
		System.out.println("8. Jugar final");
		System.out.println("9. Salir");
	}

	private static void jugarFaseDeGrupos() {
		System.out.println("========== FASE DE GRUPOS ==========");
		for (Partido partido : partidosDeGrupo) {
			jugarPartido(partido, false);
		}
		gruposJugados = true;
		mostrarClasificados();
	}

	private static void mostrarPartidoDeGrupos() {
		int numero = ConsoleInput.leerEntero("Ingrese el numero de partido de grupos (1-72): ");
		if (numero < 1 || numero > PARTIDOS_DE_GRUPOS) {
			System.out.println("Numero de partido invalido.");
			return;
		}
		jugarPartido(partidosDeGrupo.get(numero - 1), false);
	}

	private static void jugarPartido(Partido partido, boolean eliminatoria) {
		if (partido.resultado == null) {
			System.out.println(partido.identificador + " - " + partido.local + " vs. " + partido.visitante
					+ (partido.horario.isEmpty() ? "" : " - " + partido.horario + " ET"));
			int golesLocal = ConsoleInput.leerGoles(partido.local);
			int golesVisitante = ConsoleInput.leerGoles(partido.visitante);
			String ganadorPorPenales = null;
			if (eliminatoria && golesLocal == golesVisitante) {
				int ganador = ConsoleInput.leerEntero("Quien avanza por penales? (1: " + partido.local
						+ ", 2: " + partido.visitante + "): ");
				while (ganador != 1 && ganador != 2) {
					System.out.println("Debe elegir 1 o 2.");
					ganador = ConsoleInput.leerEntero("Quien avanza por penales? (1: " + partido.local
							+ ", 2: " + partido.visitante + "): ");
				}
				ganadorPorPenales = ganador == 1 ? partido.local : partido.visitante;
			}
			partido.resultado = new Resultado(golesLocal, golesVisitante, ganadorPorPenales);
			if (!eliminatoria) {
				guardarResultados();
			}
		}
		mostrarResultado(partido);
	}

	private static void mostrarClasificados() {
		System.out.println("\nClasificados para la fase de 32:");
		List<String> clasificados = obtenerClasificados();
		for (int i = 0; i < clasificados.size(); i++) {
			System.out.println((i + 1) + ". " + clasificados.get(i));
		}
	}

	private static void jugarFase32() {
		if (!gruposJugados) {
			System.out.println("Primero debe jugar todos los partidos de la fase de grupos.");
			return;
		}
		if (fase32 == null) {
			fase32 = crearPartidosEliminatoria(obtenerClasificados());
		}
		jugarRonda("FASE DE 32", fase32);
	}

	private static void jugarOctavos() {
		if (!jugarRondaAnterior(fase32, "la fase de 32")) return;
		if (octavos == null) octavos = crearPartidosEliminatoria(ganadores(fase32));
		jugarRonda("OCTAVOS DE FINAL", octavos);
	}

	private static void jugarCuartos() {
		if (!jugarRondaAnterior(octavos, "los octavos de final")) return;
		if (cuartos == null) cuartos = crearPartidosEliminatoria(ganadores(octavos));
		jugarRonda("CUARTOS DE FINAL", cuartos);
	}

	private static void jugarSemifinales() {
		if (!jugarRondaAnterior(cuartos, "los cuartos de final")) return;
		if (semifinales == null) semifinales = crearPartidosEliminatoria(ganadores(cuartos));
		jugarRonda("SEMIFINALES", semifinales);
	}

	private static void jugarTercerPuesto() {
		if (!jugarRondaAnterior(semifinales, "las semifinales")) return;
		if (tercerPuesto == null) {
			List<String> perdedores = perdedores(semifinales);
			tercerPuesto = new Partido("3P", "", perdedores.get(0), perdedores.get(1));
		}
		System.out.println("========== TERCER PUESTO ==========");
		jugarPartido(tercerPuesto, true);
	}

	private static void jugarFinal() {
		if (!jugarRondaAnterior(semifinales, "las semifinales")) return;
		if (finalMundial == null) {
			List<String> ganadores = ganadores(semifinales);
			finalMundial = new Partido("FINAL", "", ganadores.get(0), ganadores.get(1));
		}
		System.out.println("========== FINAL ==========");
		jugarPartido(finalMundial, true);
		System.out.println("CAMPEON: " + finalMundial.ganador());
	}

	private static boolean jugarRondaAnterior(List<Partido> ronda, String nombre) {
		if (ronda == null || !rondaCompleta(ronda)) {
			System.out.println("Primero debe jugar todos los partidos de " + nombre + ".");
			return false;
		}
		return true;
	}

	private static void jugarRonda(String nombre, List<Partido> ronda) {
		System.out.println("========== " + nombre + " ==========");
		for (Partido partido : ronda) jugarPartido(partido, true);
	}

	private static void mostrarResultado(Partido partido) {
		String penales = partido.resultado.ganadorPorPenales == null ? ""
				: " (avanza " + partido.resultado.ganadorPorPenales + " por penales)";
		System.out.println(partido.identificador + " - " + partido.local + " "
				+ partido.resultado.golesLocal + "-" + partido.resultado.golesVisitante + " "
				+ partido.visitante + penales);
	}

	private static List<Partido> crearPartidosEliminatoria(List<String> equipos) {
		List<Partido> partidos = new ArrayList<>();
		for (int i = 0; i < equipos.size(); i += 2) {
			partidos.add(new Partido("E" + (i / 2 + 1), "", equipos.get(i), equipos.get(i + 1)));
		}
		return partidos;
	}

	private static List<String> ganadores(List<Partido> partidos) {
		List<String> equipos = new ArrayList<>();
		for (Partido partido : partidos) equipos.add(partido.ganador());
		return equipos;
	}

	private static List<String> perdedores(List<Partido> partidos) {
		List<String> equipos = new ArrayList<>();
		for (Partido partido : partidos) {
			equipos.add(partido.ganador().equals(partido.local) ? partido.visitante : partido.local);
		}
		return equipos;
	}

	private static boolean rondaCompleta(List<Partido> ronda) {
		for (Partido partido : ronda) if (partido.resultado == null) return false;
		return true;
	}

	private static Map<String, Equipo> crearTabla(int grupo) {
		Map<String, Equipo> tabla = new LinkedHashMap<>();
		for (int i = grupo * 6; i < grupo * 6 + 6; i++) {
			Partido partido = partidosDeGrupo.get(i);
			tabla.putIfAbsent(partido.local, new Equipo(partido.local));
			tabla.putIfAbsent(partido.visitante, new Equipo(partido.visitante));
		}
		return tabla;
	}

	private static List<Equipo> tablaOrdenada(int grupo) {
		Map<String, Equipo> tabla = crearTabla(grupo);
		for (int i = grupo * 6; i < grupo * 6 + 6; i++) actualizarTabla(tabla, partidosDeGrupo.get(i));
		List<Equipo> equipos = new ArrayList<>(tabla.values());
		equipos.sort(Comparator.comparingInt((Equipo equipo) -> equipo.puntos).reversed()
				.thenComparing(Comparator.comparingInt(Equipo::diferenciaDeGoles).reversed())
				.thenComparing(Comparator.comparingInt((Equipo equipo) -> equipo.golesFavor).reversed()));
		return equipos;
	}

	private static void actualizarTabla(Map<String, Equipo> tabla, Partido partido) {
		if (partido.resultado == null) return;
		Equipo local = tabla.get(partido.local);
		Equipo visitante = tabla.get(partido.visitante);
		local.golesFavor += partido.resultado.golesLocal;
		local.golesContra += partido.resultado.golesVisitante;
		visitante.golesFavor += partido.resultado.golesVisitante;
		visitante.golesContra += partido.resultado.golesLocal;
		if (partido.resultado.golesLocal > partido.resultado.golesVisitante) local.puntos += 3;
		else if (partido.resultado.golesLocal < partido.resultado.golesVisitante) visitante.puntos += 3;
		else {
			local.puntos++;
			visitante.puntos++;
		}
	}

	private static List<String> obtenerClasificados() {
		List<String> clasificados = new ArrayList<>();
		List<Equipo> terceros = new ArrayList<>();
		for (int grupo = 0; grupo < 12; grupo++) {
			List<Equipo> tabla = tablaOrdenada(grupo);
			clasificados.add(tabla.get(0).nombre);
			clasificados.add(tabla.get(1).nombre);
			terceros.add(tabla.get(2));
		}
		terceros.sort(Comparator.comparingInt((Equipo equipo) -> equipo.puntos).reversed()
				.thenComparing(Comparator.comparingInt(Equipo::diferenciaDeGoles).reversed())
				.thenComparing(Comparator.comparingInt((Equipo equipo) -> equipo.golesFavor).reversed()));
		for (int i = 0; i < 8; i++) clasificados.add(terceros.get(i).nombre);
		return clasificados;
	}

}
