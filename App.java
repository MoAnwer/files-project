/**
 * @author mohamed_anwer
 * @see https://github.com/MoAnwer/files-project
 */

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    
    boolean endProgram = false;

    Scanner scanner = new Scanner(System.in);

    AppHandler handler = new AppHandler();

    while (!endProgram) {

      System.out.println("A. Operation\n");

      System.out.println("\s1. Addition");
      System.out.println("\s2. Subtraction");
      System.out.println("\s3. Multiplication");
      System.out.println("\s4. Division\n");


      System.out.println("B. Reports\n");
      System.out.println("\s1. All operations");
      System.out.println("\s2. Specific operation");

      System.out.println("C. Exit\n");
      
      System.out.print("Enter Character : ");

      char order = scanner.next().charAt(0);


      if (order == 'A' || order == 'a') {


        System.out.print("Enter operation number: ");


        int operation =  scanner.nextInt();

        try {
      
          switch (operation) {
            
            case 1:
              System.out.println("Addition : ");
              System.out.println("Enter two numbers: ");
              
              handler.store(operation, scanner.nextInt(), scanner.nextInt());
  
            break;
            case 2: 
              System.out.println("Subtraction : ");
              System.out.println("Enter two numbers: ");
              
              handler.store(operation, scanner.nextInt(), scanner.nextInt());
            break;
            case 3:
              System.out.println("Multiplication : ");
              System.out.println("Enter two numbers: ");
              
              handler.store(operation, scanner.nextInt(), scanner.nextInt());
            break;
            case 4:
              System.out.println("Divition : ");
              System.out.println("Enter two numbers: ");
              
              handler.store(operation, scanner.nextInt(), scanner.nextInt());
            break;
            default:
              System.out.println("------------------------------------------");
              System.out.println("ERROR: You must be just typing numbers !!");
              System.out.println("------------------------------------------");
            break;
          }
          
        } catch (Exception e) {
          
          System.out.println("------------------------------------------");
          System.out.println("ERROR: Please enter characters");
          System.out.println("------------------------------------------");

        }

      
      } else if (order == 'B' || order == 'b') {

        System.out.print("Enter report number: ");


        
        try {
          int operation =  scanner.nextInt();
          
          switch (operation) {
            case 1:
              System.out.println("------------------------------------------------------------------------");
              System.out.println("Reports: ");
              System.out.println("------------------------------------------------------------------------");
              System.out.print(handler.reports());
              System.out.println("------------------------------------------------------------------------\n");
            break;
            case 2:
              System.out.println("Enter operation number: ");
              System.out.println("\s1. Addition");
              System.out.println("\s2. Subtraction");
              System.out.println("\s3. Multiplication");
              System.out.print("\s4. Division\n");
  
              
              int mathOperation = scanner.nextInt();
  
              System.out.println("------------------------------------------------------------------------");
              System.out.println("Reports: ");
              System.out.println("------------------------------------------------------------------------");
              System.out.print(handler.reports(mathOperation));
              System.out.println("------------------------------------------------------------------------");
            break;
          }

        } catch (Exception e) {
          System.out.println("\n------------------------------------------------------------------------");
          System.out.println("ERROR: Please enter characters");
          System.out.println("------------------------------------------------------------------------");

        }

      } else if (order == 'C' || order == 'c') {

        endProgram = true;

      } else {

        System.out.println("\n------------------------------------------------------------------------");
        System.out.println("ERROR: Invalid operation character !!");
        System.out.println("------------------------------------------------------------------------");

      }

    }

  }

}