package TrainingJava;

import java.util.Scanner;


public class App
{
    public static void main( String[] args )
    {
      Scanner sc = new Scanner(System.in);
      System.out.println("Please enter your name: ");
      String prueba = sc.nextLine();
      System.out.println("Welcome sr " + prueba + " to your Maven Proyect");
    }
}
