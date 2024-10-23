import java.io.File;
import java.io.FileNotFoundException;
//
import java.util.Scanner;
/**
 * See Assignment II Question II
 *
 * @author Stephan Jamieson
 * @version 26/7/2019
 */
public class MarketPlace {
    
    private MarketPlace() {}
    
    private final static Currency RAND = new Currency("R", "ZAR", 100);
    
    
    // Create an instance of Seller with attributes ID, name, location, product, 
    // unit_price and number_of_units
    private static Seller makeSeller(final String data) {
        final Scanner scanner = new Scanner(data.trim());
        scanner.useDelimiter("\\s*,\\s*");
        
        Seller seller = new Seller(); // Creating an instance of seller with attributes
        
        seller.ID = scanner.next(); // Defining attributes
        seller.Name = scanner.next();
        seller.Location = scanner.next();
        seller.Product = scanner.next();
        
        String price = scanner.next();
        Money unit_price = new Money(price, RAND); // Converting unit_price to a money object 
        
        seller.unit_price = unit_price;
        seller.number_of_units = Integer.parseInt(scanner.next());
             
        return seller;
    }
    
    // Read the contents of CSV file into an array.
    // See the Appendix on page 4 of the Assignment sheet.
    private static Seller[] parseFile(final String fileName) throws FileNotFoundException {
        final Scanner inFile = new Scanner(new File(fileName));
        Seller[] sellers = null;
    
        if (inFile.hasNextLine()) {
            sellers = new Seller[Integer.parseInt(inFile.nextLine().trim())];
            for (int index=0; index<sellers.length; index++) {
                sellers[index] = makeSeller(inFile.nextLine());
            }
        }
        inFile.close();
        return sellers;
    }
    
    public static void main(final String[] args) throws FileNotFoundException {
        final Scanner inKey = new Scanner(System.in);
        System.out.println("Enter the name of a \"Comma Separated Values\" (CSV) file:");
        final Seller[] sellers = parseFile(inKey.nextLine()); // Creates a seller array from the csv file
         if (sellers == null || sellers.length == 0) {
            System.out.println("The file contains no seller data."); // If array is empty print this
         }
        else {
        System.out.println("Enter the name of a product:"); // Takes user input and stores it as variables
        String product = inKey.nextLine();
        System.out.println("Enter the number of units required:");
        int units = inKey.nextInt();
        System.out.println("Enter the maximum unit price:");
        String price = inKey.next();
        Money max_price = new Money(price, RAND);
         
       boolean sellers_present = false; // Create a boolean value that assumes there are no sellers that meet the users requirements
       for (Seller seller : sellers) {
         if (product.equals(seller.Product)) {
            if ( units <= seller.number_of_units ) 
               if ( (seller.unit_price).compareTo(max_price) <= 0) { // Using the compareTo method to check if the price of the product is equal to or less than the users max price
                  sellers_present = true; // If this if statement gets triggered then there is a seller present
                  System.out.println(seller.ID + " : " + seller.Name + 
                  " in " + seller.Location + " has " + seller.number_of_units + 
                  " " + seller.Product + " for " + seller.unit_price + " each.");
                  }
        }   }
         if (!sellers_present) // If sellers prent is false, print this
         System.out.println("None found.");
         inKey.close();
        }
        }

             }


