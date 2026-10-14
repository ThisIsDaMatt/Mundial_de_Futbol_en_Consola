import java.util.Scanner;

public class ConsoleInput{

	public static Scanner sc = new Scanner(System.in);

	public static int getInt()
	{
		int temp = 0;

		try{
			// Initialize the Scanner object to use the standard input
        	temp = sc.nextInt();
                sc.nextLine();
	        // Close the Scanner
		}catch(Exception e)
		{
			refreshScanner();
			System.out.println("Error de lectura de numero entero");
			System.out.println(e);
			System.out.println("Presiona ENTER para continuar");
			sc.nextLine();
		}
		

		return temp;
	}

	public static float getFloat()
	{
		float temp = 0;

		try{
			// Initialize the Scanner object to use the standard input
	        temp = sc.nextFloat();
                sc.nextLine();
        }catch(Exception e)
		{
			refreshScanner();
			System.out.println("Error de lectura de numero flotante");
			System.out.println(e);
			System.out.println("Presiona ENTER para continuar");
			sc.nextLine();
		}

		return temp;
	}

	public static String getString(){
		String temp = null;

		try{
			// Initialize the Scanner object to use the standard input
	        // Read strings until the End Of File (EOF)
	        //System.out.println("Finaliza con Ctrl-D");
	        //while(sc.hasNext()) {
	            //String s = sc.next();
	        //}
	        temp = sc.nextLine();
	        // Close the Scanner
		}catch(Exception e)
		{
			refreshScanner();
			System.out.println("Error de lectura de cadena");
			System.out.println(e);
		}
		return temp;
	}

	public static int getMayi0()
	{
		int temp = 0;
		
		do{
		try{
			// Initialize the Scanner object to use the standard input
        	temp = sc.nextInt();
                sc.nextLine();
			if (temp < 0){
				System.out.println("Error de lectura de numero entero positivo o cero");
				System.out.println("Presiona ENTER para continuar");
				sc.nextLine();
				break;
			}
			
	        // Close the Scanner
		}catch(Exception e)
		{
			refreshScanner();
			System.out.println("Error de lectura de numero entero positivo o cero");
			System.out.println(e);
			System.out.println("Presiona ENTER para continuar");
			sc.nextLine();
		}}while(temp < 0);
		

		return temp;
	}

	public static int getMay0()
	{
		int temp = 0;
		
		
		try{
			// Initialize the Scanner object to use the standard input
        	temp = sc.nextInt();
                sc.nextLine();
			if (temp <= 0){
				System.out.println("Error de lectura de numero entero positivo");
				System.out.println("Presiona ENTER para continuar");
				sc.nextLine();
			}
			
	        // Close the Scanner
		}catch(Exception e)
		{
			refreshScanner();
			System.out.println("Error de lectura de numero entero positivo");
			System.out.println(e);
			System.out.println("Presiona ENTER para continuar");
			sc.nextLine();
		}
		

		return temp;
	}
	public static void refreshScanner()
	{
		//sc.close();
		sc = new Scanner(System.in);
	}

    //System.out.print("Enter a long : ");
    //long l = sc.nextLong();

    //System.out.print("Enter a boolean : ");
    //boolean b = sc.nextBoolean();



    //System.out.print("Enter an double : ");
    //double d = sc.nextDouble();
}
