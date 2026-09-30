import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FlagStandardOP{

    // Cada carácter del CSV ('1'..'9') corresponde a una posición (0..8) de este arreglo
    static final String[] COLORES = {
        ConsoleColors.YELLOW_BACKGROUND,  // '1'
        ConsoleColors.ORANGE_BACKGROUND,  // '2'
        ConsoleColors.RED_BACKGROUND,     // '3'
        ConsoleColors.PURPLE_BACKGROUND,  // '4'
        ConsoleColors.BLUE_BACKGROUND,    // '5'
        ConsoleColors.GREEN_BACKGROUND,   // '6'
        ConsoleColors.WHITE_BACKGROUND,   // '7'
        ConsoleColors.BLACK_BACKGROUND,   // '8'
        ConsoleColors.BROWN_BACKGROUND    // '9'
    };

    // Tamaños disponibles: {filas, columnas}. Todos mantienen la proporción 2:3 de la bandera original.
    static final String[] NOMBRES_TAMANO = { "Grande", "Mediano", "Pequeño", "Ícono" };
    static final int[][] TAMANOS = {
        {10, 15},  // 1. Grande (tamaño original)
        {6, 9},    // 2. Mediano
        {4, 6},    // 3. Pequeño
        {2, 3}     // 4. Ícono
    };

    // Las banderas del CSV siempre son de 10 filas x 15 columnas
    static final int FILAS_ORIGEN = 10;
    static final int COLUMNAS_ORIGEN = 15;

    // Pinta una bandera que empieza en filaInicio (numeración desde 1, como en el CSV)
    // reducida a filasDestino x columnasDestino tomando, para cada celda nueva, la celda
    // del centro del bloque que le corresponde en la bandera original.
    static void pintarBandera(char[][] matriz, int filaInicio, int filasDestino, int columnasDestino) {
        System.out.println("--------------------------------");
        for (int f = 0; f < filasDestino; f++) {
            int filaOrigen = filaInicio - 1 + (int) ((f + 0.5) * FILAS_ORIGEN / filasDestino);
            for (int col = 0; col < columnasDestino; col++) {
                int colOrigen = (int) ((col + 0.5) * COLUMNAS_ORIGEN / columnasDestino);
                char c = matriz[filaOrigen][colOrigen];
                if (c >= '1' && c <= '9') {
                    System.out.print(COLORES[c - '1'] + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        /* ---------- Matriz de configuración: carga el CSV ---------- */
        char[][] matriz = new char[480][15];

        BufferedReader archivo = new BufferedReader(
            new FileReader("Flags.csv")
        );

        String linea;
        int fila = 0;

        while ((linea = archivo.readLine()) != null && fila < matriz.length) {
            String[] columnas = linea.split(";");
            for (int columna = 0; columna < columnas.length; columna++) {
                matriz[fila][columna] = columnas[columna].charAt(0);
            }
            fila++;
        }
        archivo.close();

        /* ---------- Países y fila donde empieza cada bandera ---------- */
        String[] paises = {
            "Inglaterra", "España", "Francia", "Cabo Verde", "Arabia Saudita",
            "Corea del Sur", "Congo RD", "Ecuador", "Estados Unidos", "Argentina",
            "Brasil", "Canadá", "Costa de Marfil", "Jordania", "Alemania",
            "Japón", "Colombia", "Bélgica", "Turquía", "Sudáfrica",
            "Chequia", "Suiza", "Portugal", "Egipto", "Paraguay",
            "Escocia", "Haití", "Argelia", "México", "Marruecos",
            "Austria", "Noruega", "Bosnia y Herzegovina", "Túnez", "Croacia",
            "Países Bajos", "Uruguay", "Qatar", "Australia", "Nueva Zelanda",
            "Senegal", "Ghana", "Panamá", "Irak", "Suecia",
            "Curazao", "Irán", "Uzbekistán"
        };

        // Índice = número de país - 1. Valor = fila del CSV donde empieza la bandera.
        // 0 significa "todavía sin asignar".
        int[] inicioFila = new int[paises.length];
         
            inicioFila[0]  = 61; // 1. Inglaterra
            inicioFila[1]  = 71;// 2. España
            inicioFila[2]  = 81;// 3. Francia
            inicioFila[3]  = 91;// 4. Cabo Verde
            inicioFila[4]  = 271;// 5. Arabia Saudita
            inicioFila[5]  = 101;// 6. Corea del Sur
            inicioFila[6]  = 111; // 7. Congo RD
            inicioFila[7]  = 121; // 8. Ecuador
            inicioFila[8]  = 341; // 9. Estados Unidos
            inicioFila[9]  = 291; // 10. Argentina
            inicioFila[10]  = 321; // 11. Brasil
            inicioFila[11]  = 381; // 12. Canadá
            inicioFila[12]  = 301; // 13. Costa de Marfil
            inicioFila[13]  = 371; // 14. Jordania
            inicioFila[14]  = 131; // 15. Alemania
            inicioFila[15]  = 161;  // 16. Japón
            inicioFila[16]  = 191; // 17. Colombia
            inicioFila[17]  = 141; // 18. Bélgica
            inicioFila[18]  = 181; // 19. Turquía
            inicioFila[19]  = 171; // 20. Sudáfrica
            inicioFila[20]  = 151; // 21. Chequia
            inicioFila[21] = 221; // 22. Suiza
            inicioFila[22] = 241; // 23. Portugal
            inicioFila[23] = 231; // 24. Egipto
            inicioFila[24] = 211; // 25. Paraguay
            inicioFila[25] = 201; // 26. Escocia
            inicioFila[26] = 251; // 27. Haití
            inicioFila[27] = 261; // 28. Argelia
            inicioFila[28]  = 11; // 29. México
            inicioFila[29]  = 21; // 30. Marruecos
            inicioFila[30]  = 1; // 31. Austria
            inicioFila[31]  = 31; // 32. Noruega
            inicioFila[32]  = 41; // 33. Bosnia y Herzegovina
            inicioFila[33]  = 51; // 34. Túnez
            inicioFila[34]  = 281; // 35. Croacia
            inicioFila[35]  = 311; // 36. Países Bajos
            inicioFila[36]  = 351; // 37. Uruguay
            inicioFila[37]  = 331; // 38. Qatar
            inicioFila[38]  = 391; // 39. Australia
            inicioFila[39]  = 401; // 40. Nueva Zelanda
            inicioFila[40]  = 361; // 41. Senegal
            inicioFila[41]  = 471; // 42. Ghana
            inicioFila[42]  = 411; // 43. Panamá
            inicioFila[43]  = 461; // 44. Irak
            inicioFila[44]  = 431; // 45. Suecia
            inicioFila[45]  = 421;  // 46. Curazao
            inicioFila[46]  = 441;  // 47. Irán
            inicioFila[47]  = 451;  // 48. Uzbekistán     
            
            
        boolean salir = false;
        do {  
            /* ---------- Menú ---------- */
            System.out.println("+------+---------------------------+");
            System.out.println("| Num  | País                      |");
            System.out.println("+------+---------------------------+");
            for (int i = 0; i < paises.length; i++) {
                System.out.println("| " + (i + 1) + "\t| " + paises[i]);
            }
            System.out.println("+------+---------------------------+");

            /* ---------- Control de errores ---------- */
            int flag = 0;
            while (flag < 1 || flag > paises.length) {
                System.out.print("Ingresa un número de país (1-" + paises.length + "): ");
                try {
                    flag = sc.nextInt();
                    if (flag < 1 || flag > paises.length) {
                        System.out.println("Inválido: debe estar entre 1 y " + paises.length);
                    }
                } catch (Exception e) {
                    System.out.println("Inválido: ingresa un número");
                    sc.nextLine(); // limpia el buffer
                    flag = 0;
                }
            }

            /* ---------- Dibujar la bandera ---------- */
            System.out.println("Escogiste: " + paises[flag -1]);
            if (inicioFila[flag - 1] == 0) {
                System.out.println("Todavía no hay bandera cargada para " + paises[flag - 1]);
            } else {
                /* ---------- Elegir tamaño ---------- */
                System.out.println("+------+---------------------------+");
                System.out.println("| Num  | Tamaño                    |");
                System.out.println("+------+---------------------------+");
                for (int i = 0; i < NOMBRES_TAMANO.length; i++) {
                    System.out.println("| " + (i + 1) + "\t| " + NOMBRES_TAMANO[i] + " (" + TAMANOS[i][0] + "x" + TAMANOS[i][1] + ")");
                }
                System.out.println("+------+---------------------------+");

                int tamano = 0;
                while (tamano < 1 || tamano > TAMANOS.length) {
                    System.out.print("Ingresa un número de tamaño (1-" + TAMANOS.length + "): ");
                    try {
                        tamano = sc.nextInt();
                        if (tamano < 1 || tamano > TAMANOS.length) {
                            System.out.println("Inválido: debe estar entre 1 y " + TAMANOS.length);
                        }
                    } catch (Exception e) {
                        System.out.println("Inválido: ingresa un número");
                        sc.nextLine(); // limpia el buffer
                        tamano = 0;
                    }
                }

                pintarBandera(matriz, inicioFila[flag - 1], TAMANOS[tamano - 1][0], TAMANOS[tamano - 1][1]);
            }
            System.out.print("Salir? (s/n): ");
            char c = sc.next().charAt(0);
            if(c == 's'){
            salir = true;
    }
}  while (!salir);
        sc.close();



    }
}