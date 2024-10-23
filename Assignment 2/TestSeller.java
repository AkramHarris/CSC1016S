// Akram Harris
// HRRAKR001
// 01/08/2024



import java.util.Scanner; // Will need scanner to read input

public class TestSeller { // Iniatiating the class
   public static void main(String[] args) {
      Seller seller = new Seller();
      Currency rand = new Currency("R", "ZAR", 100); // Creating a new Currency
      Scanner scanner = new Scanner(System.in); // Creating a scanner object
      System.out.println("Please enter the details of the seller.");
      System.out.print("ID: ");
      seller.ID = scanner.nextLine(); // Storing the inputs as String variables
      System.out.print("Name: ");
      seller.Name = scanner.nextLine();
      System.out.print("Location: ");
      seller.Location = scanner.nextLine();
      System.out.print("Product: ");
      seller.Product = scanner.nextLine();
      System.out.print("Price: ");
      String price = scanner.next();
      seller.unit_price = new Money(price, rand);
      System.out.print("Units: ");
      seller.number_of_units = scanner.nextInt(); // Storing the number of units as integers
      System.out.println("The seller has been successfully created:"); // Printing out the results
      System.out.println("ID of the seller: " + seller.ID);
      System.out.println("Name of the seller: " + seller.Name);
      System.out.println("Location of the seller: " + seller.Location);
      System.out.println("The product to sell: " + seller.Product);
      System.out.println("Product unit price: " + seller.unit_price);
      System.out.println("The number of available units: " + seller.number_of_units);
      scanner.close();
      }
}
      
      