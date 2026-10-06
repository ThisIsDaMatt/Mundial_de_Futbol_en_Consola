
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FlagStandard {
    public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);
    

/*                                                                                                                                                                                                                                                                                                                 
▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ 
████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████                                                   
*/ 
/*
___  ___      _        _       _____              __ _       
|  \/  |     | |      (_)     /  __ \            / _(_)      
| .  . | __ _| |_ _ __ _ ____ | /  \/ ___  _ __ | |_ _  __ _ 
| |\/| |/ _` | __| '__| |_  / | |    / _ \| '_ \|  _| |/ _` |
| |  | | (_| | |_| |  | |/ /  | \__/\ (_) | | | | | | | (_| |
\_|  |_/\__,_|\__|_|  |_/___|  \____/\___/|_| |_|_| |_|\__, |
                                                        __/ |
                                                       |___/ 

Configuramos la matriz para que tome datos del archivo csv basándonos en el repositorio
de Xaca
*/


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

    fila++; //Lo que se logra con esto es que la matriz que estaba vacía, quede llena justo con los datos del CSV
}

/*                                                                                                                                                                                                                                                                                                                 
▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ ▄▄▄▄ 
████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████                                                   
*/
/*
    ____            _             _       _                                          
  / ___|___  _ __ | |_ _ __ ___ | |   __| | ___    ___ _ __ _ __ ___  _ __ ___  ___ 
 | |   / _ \| '_ \| __| '__/ _ \| |  / _` |/ _ \  / _ \ '__| '__/ _ \| '__/ _ \/ __|
 | |__| (_) | | | | |_| | | (_) | | | (_| |  __/ |  __/ |  | | | (_) | | |  __/\__ \
  \____\___/|_| |_|\__|_|  \___/|_|  \__,_|\___|  \___|_|  |_|  \___/|_|  \___||___/

  Solo opera con la varible flag, le "permite el paso" si está entre 1 y 48, si es decimal,
  negativo, un texto o no está dentro del rango, el programa vuelve a pedir
  el número de bandera hasta que sea válido.
                                                                                
*/

boolean salir = false;
int flag = 0;
do{
flag = 0;
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

        // Imprimir la tabla una sola vez
        System.out.println("+------+---------------------------+");
        System.out.println("| Num  | País                      |");
        System.out.println("+------+---------------------------+");
        for (int i = 0; i < paises.length; i++) {
            System.out.println("| " + (i + 1) + "\t| " + paises[i]);
        }
        System.out.println("+------+---------------------------+");

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
        archivo.close();



switch (flag) {

    // -------------------------------------------------------------
    // Case 1: Inglaterra (Filas 61-70)
    // -------------------------------------------------------------
    case 1:
        System.out.println("--------------------------------");
        for (fila = (61) - 1; fila < 70; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 2: España (Filas 71-80)
    // -------------------------------------------------------------
    case 2:
        System.out.println("--------------------------------");
        for (fila = (71) - 1; fila < 80; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 3: Francia (Filas 81-90)
    // -------------------------------------------------------------
    case 3:
        System.out.println("--------------------------------");
        for (fila = (81) - 1; fila < 90; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 4: Cabo Verde (Filas 91-100)
    // -------------------------------------------------------------
    case 4:
        System.out.println("--------------------------------");
        for (fila = (91) - 1; fila < 100; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 5: Arabia Saudita (Filas 271-280)
    // -------------------------------------------------------------
    case 5:
        System.out.println("--------------------------------");
        for (fila = (271) - 1; fila < 280; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 6: Corea del Sur (Filas 101-110)
    // -------------------------------------------------------------
    case 6:
        System.out.println("--------------------------------");
        for (fila = (101) - 1; fila < 110; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 7: Congo RD (Filas 111-120)
    // -------------------------------------------------------------
    case 7:
        System.out.println("--------------------------------");
        for (fila = (111) - 1; fila < 120; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 8: Ecuador (Filas 121-130)
    // -------------------------------------------------------------
    case 8:
        System.out.println("--------------------------------");
        for (fila = (121) - 1; fila < 130; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 9: Estados Unidos (Filas 341-350)
    // -------------------------------------------------------------
    case 9:
        System.out.println("--------------------------------");
        for (fila = (341) - 1; fila < 350; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 10: Argentina (Filas 291-300)
    // -------------------------------------------------------------
    case 10:
        System.out.println("--------------------------------");
        for (fila = (291) - 1; fila < 300; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 11: Brasil (Filas 321-330)
    // -------------------------------------------------------------
    case 11:
        System.out.println("--------------------------------");
        for (fila = (321) - 1; fila < 330; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 12: Canadá (Filas 381-390)
    // -------------------------------------------------------------
    case 12:
        System.out.println("--------------------------------");
        for (fila = (381) - 1; fila < 390; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 13: Costa de Marfil (Filas 301-310)
    // -------------------------------------------------------------
    case 13:
        System.out.println("--------------------------------");
        for (fila = (301) - 1; fila < 310; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 14: Jordania (Filas 371-380)
    // -------------------------------------------------------------
    case 14:
        System.out.println("--------------------------------");
        for (fila = (371) - 1; fila < 380; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 15: Alemania (Filas 131-140)
    // -------------------------------------------------------------
    case 15:
        System.out.println("--------------------------------");
        for (fila = (131) - 1; fila < 140; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 16: Japón (Filas 161-170)
    // -------------------------------------------------------------
    case 16:
        System.out.println("--------------------------------");
        for (fila = (161) - 1; fila < 170; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 17: Colombia (Filas 191-200)
    // -------------------------------------------------------------
    case 17:
        System.out.println("--------------------------------");
        for (fila = (191) - 1; fila < 200; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 18: Bélgica (Filas 141-150)
    // -------------------------------------------------------------
    case 18:
        System.out.println("--------------------------------");
        for (fila = (141) - 1; fila < 150; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 19: Turquía (Filas 181-190)
    // -------------------------------------------------------------
    case 19:
        System.out.println("--------------------------------");
        for (fila = (181) - 1; fila < 190; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 20: Sudáfrica (Filas 171-180)
    // -------------------------------------------------------------
    case 20:
        System.out.println("--------------------------------");
        for (fila = (171) - 1; fila < 180; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 21: Chequia (Filas 151-160)
    // -------------------------------------------------------------
    case 21:
        System.out.println("--------------------------------");
        for (fila = (151) - 1; fila < 160; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 22: Suiza (Filas 221-230)
    // -------------------------------------------------------------
    case 22:
        System.out.println("--------------------------------");
        for (fila = (221) - 1; fila < 230; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 23: Portugal (Filas 241-250)
    // -------------------------------------------------------------
    case 23:
        System.out.println("--------------------------------");
        for (fila = (241) - 1; fila < 250; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 24: Egipto (Filas 231-240)
    // -------------------------------------------------------------
    case 24:
        System.out.println("--------------------------------");
        for (fila = (231) - 1; fila < 240; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 25: Paraguay (Filas 211-220)
    // -------------------------------------------------------------
    case 25:
        System.out.println("--------------------------------");
        for (fila = (211) - 1; fila < 220; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 26: Escocia (Filas 201-210)
    // -------------------------------------------------------------
    case 26:
        System.out.println("--------------------------------");
        for (fila = (201) - 1; fila < 210; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 27: Haití (Filas 251-260)
    // -------------------------------------------------------------
    case 27:
        System.out.println("--------------------------------");
        for (fila = (251) - 1; fila < 260; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 28: Argelia (Filas 261-270)
    // -------------------------------------------------------------
    case 28:
        System.out.println("--------------------------------");
        for (fila = (261) - 1; fila < 270; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 29: México (Filas 11-20)
    // -------------------------------------------------------------
    case 29:
        System.out.println("--------------------------------");
        for (fila = (11) - 1; fila < 20; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 30: Marruecos (Filas 21-30)
    // -------------------------------------------------------------
    case 30:
        System.out.println("--------------------------------");
        for (fila = (21) - 1; fila < 30; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 31: Austria (Filas 1-10)
    // -------------------------------------------------------------
    case 31:
        System.out.println("--------------------------------");
        for (fila = (1) - 1; fila < 10; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 32: Noruega (Filas 31-40)
    // -------------------------------------------------------------
    case 32:
        System.out.println("--------------------------------");
        for (fila = (31) - 1; fila < 40; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 33: Bosnia y Herzegovina (Filas 41-50)
    // -------------------------------------------------------------
    case 33:
        System.out.println("--------------------------------");
        for (fila = (41) - 1; fila < 50; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 34: Túnez (Filas 51-60)
    // -------------------------------------------------------------
    case 34:
        System.out.println("--------------------------------");
        for (fila = (51) - 1; fila < 60; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 35: Croacia (Filas 281-290)
    // -------------------------------------------------------------
    case 35:
        System.out.println("--------------------------------");
        for (fila = (281) - 1; fila < 290; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 36: Países Bajos (Filas 311-320)
    // -------------------------------------------------------------
    case 36:
        System.out.println("--------------------------------");
        for (fila = (311) - 1; fila < 320; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 37: Uruguay (Filas 351-360)
    // -------------------------------------------------------------
    case 37:
        System.out.println("--------------------------------");
        for (fila = (351) - 1; fila < 360; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 38: Qatar (Filas 331-340)
    // -------------------------------------------------------------
    case 38:
        System.out.println("--------------------------------");
        for (fila = (331) - 1; fila < 340; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 39: Australia (Filas 391-400)
    // -------------------------------------------------------------
    case 39:
        System.out.println("--------------------------------");
        for (fila = (391) - 1; fila < 400; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 40: Nueva Zelanda (Filas 401-410)
    // -------------------------------------------------------------
    case 40:
        System.out.println("--------------------------------");
        for (fila = (401) - 1; fila < 410; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 41: Senegal (Filas 361-370)
    // -------------------------------------------------------------
    case 41:
        System.out.println("--------------------------------");
        for (fila = (361) - 1; fila < 370; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 42: Ghana (Filas 471-480)
    // -------------------------------------------------------------
    case 42:
        System.out.println("--------------------------------");
        for (fila = (471) - 1; fila < 480; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 43: Panamá (Filas 411-420)
    // -------------------------------------------------------------
    case 43:
        System.out.println("--------------------------------");
        for (fila = (411) - 1; fila < 420; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 44: Irak (Filas 461-470)
    // -------------------------------------------------------------
    case 44:
        System.out.println("--------------------------------");
        for (fila = (461) - 1; fila < 470; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 45: Suecia (Filas 431-440)
    // -------------------------------------------------------------
    case 45:
        System.out.println("--------------------------------");
        for (fila = (431) - 1; fila < 440; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 46: Curazao (Filas 421-430)
    // -------------------------------------------------------------
    case 46:
        System.out.println("--------------------------------");
        for (fila = (421) - 1; fila < 430; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 47: Irán (Filas 441-450)
    // -------------------------------------------------------------
    case 47:
        System.out.println("--------------------------------");
        for (fila = (441) - 1; fila < 450; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

    // -------------------------------------------------------------
    // Case 48: Uzbekistán (Filas 451-460)
    // -------------------------------------------------------------
    case 48:
        System.out.println("--------------------------------");
        for (fila = (451) - 1; fila < 460; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == '1') {
                    System.out.print(ConsoleColors.YELLOW_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '2') {
                    System.out.print(ConsoleColors.ORANGE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '3') {
                    System.out.print(ConsoleColors.RED_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '4') {
                    System.out.print(ConsoleColors.PURPLE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '5') {
                    System.out.print(ConsoleColors.BLUE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '6') {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '7') {
                    System.out.print(ConsoleColors.WHITE_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '8') {
                    System.out.print(ConsoleColors.BLACK_BACKGROUND + "   ");
                }
                if (matriz[fila][columna] == '9') {
                    System.out.print(ConsoleColors.BROWN_BACKGROUND + "   ");
                }
                System.out.print(ConsoleColors.RESET);
            }
            System.out.println();
        }
        break;

}

    System.out.print("Salir? (s/n): ");
    char c = sc.next().charAt(0);
    if(c == 's'){
        salir = true;
    }

    }while(!salir);
    sc.close();



















}
}



