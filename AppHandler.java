import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AppHandler {

  private ArrayList<String> records;
  private Calacator calacator;
  private String[] files = {"_blank", "Addition.txt",  "Subtraction.txt", "Multiplication.txt", "Division.txt"};
  private String[] operations = {"_blank", "Addition",  "Subtraction", "Multiplication", "Division"};

  public AppHandler() {

    records = new ArrayList<String>();
    calacator = new Calacator();


  }

  public double calculating(int operation, int num1, int num2) {

    double result = 0;

    try {
    
      if (operation == 1) {

        result = calacator.addition(num1, num2);

      } else if (operation == 2) {

        result = calacator.subtraction(num1, num2);

      } else if (operation == 3) {

        result = calacator.multiplication(num1, num2);

      } else if (operation == 4) {

        result = calacator.division(num1, num2);

      } else {

        System.out.println("Invalid operation !!");

      }
      
    } catch (Exception e) {

      System.out.println(" The input must be interger type !!");

    }

    return result;

  }

  public void store(int operation, int num1, int num2) {


    if(operation == 1 || operation == 2) {

      try {

        FileWriter fwriter = new FileWriter(this.files[operation], true);

        BufferedWriter writer = new BufferedWriter(fwriter);
        
        writer.append(this.logger(operation, num1, num2));
        
        writer.flush();
        
      } catch (IOException e) {
        
        System.out.println(e.getMessage());

      }
    } else if (operation == 3 || operation == 4) {

      try {

        FileWriter fos = new FileWriter(this.files[operation], true);
        PrintWriter printWriter = new PrintWriter(fos);

        printWriter.append(this.logger(operation, num1, num2));
        printWriter.flush();

      } catch (IOException e) {

        System.out.println(e.getMessage());

      }

    }

  }

  public String logger(int operation, int num1, int num2) {

    double result = this.calculating(operation, num1, num2);

    String dataRow = "ID: " + getRecordId() + ", Operation: " + this.operations
    [operation] + ", number_1: " + num1 + ", number_2: " + num2 + ", result: " + result + "\n";

    records.add(dataRow);

    return dataRow;

  }

  public int getRecordId() {
    int id = 0;
    if (records.size() == 0) {
      id = 1;
    } else if (records.size() == 1 ) {
      ++id;
    } else {
      id = records.size();
    }
    return id;
  }

  public String reports() {

    String report = "";

    try {

      for (int i = 1; i < 3; i++) {

        FileReader fis = new FileReader(new File(this.files[i]));
  
        BufferedReader reader = new BufferedReader(fis);

        String line = reader.readLine();

        while (line != null) {
          report += line + "\n";
          line = reader.readLine();
        }
      }

      for (int i = 3; i < 5; i++) {
        
        Scanner scanner = new Scanner(new File(this.files[i]));

        while (scanner.hasNext()) {

          report += scanner.nextLine() + "\n";

        }

      }
      
    } catch (Exception e) {

      System.out.println(e.getMessage());

    }
  

    return report;

  }


  public String reports(int operation) {

    String report = "";

    try {

      if (operation == 1 || operation == 2) {
        for (int i = 1; i < 3; i++) {

          FileReader fis = new FileReader(new File(this.files[i]));
    
          BufferedReader reader = new BufferedReader(fis);

          String line = reader.readLine();

          while (line != null) {
            report += line + "\n";
            line = reader.readLine();
          }
        }
      }

      if (operation == 3 || operation == 4) {
        for (int i = 3; i < 5; i++) {
          Scanner scanner = new Scanner(new File(this.files[i]));
          while (scanner.hasNext()) {
            report += scanner.nextLine() + "\n";
          }
        }
      }
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    return report;
  }
}