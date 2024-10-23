// Akram Harris
// HRRAKR001
// 25/07/2024
import java.util.Scanner;

public class CalculateDuration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter time A:");
        String timeA = scanner.nextLine();
        System.out.println("Enter time B:");
        String timeB = scanner.nextLine();
        

        Time t1 = new Time(timeA);
        Time t2 = new Time(timeB);

        Duration durationBetweentimes = t2.subtract(t1);
        long minutesBetween = durationBetweentimes.intValue("minute");
        String t1final = t1.toString();
        String t2final = t2.toString();

        System.out.println("The time " + t2final + " occurs " + minutesBetween + " minutes after the time " + t1final + ".");
        scanner.close();
    }
}


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
        
        Seller seller = new Seller();
        
        seller.ID = scanner.next();
        seller.Name = scanner.next();
        seller.Location = scanner.next();
        seller.Product = scanner.next();
        
        String price = scanner.next();
        Money unit_price = new Money(price, RAND);
        
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
        final Seller[] sellers = parseFile(inKey.nextLine());
         if (sellers == null || sellers.length == 0) {
            System.out.println("The file contains no seller data.");
         }
        else {
        System.out.println("Enter the name of a product:");
        String product = inKey.next();
        System.out.println("Enter the number of units required:");
        int units = inKey.nextInt();
        System.out.println("Enter the maximum unit price:");
        String price = inKey.next();
        Money max_price = new Money(price, RAND);
         
       boolean sellers_present = false;
       for (Seller seller : sellers) {
         if (product.equals(seller.Product)) {
            if ( units <= seller.number_of_units ) 
               if ( (seller.unit_price).compareTo(max_price) <= 0) {
                  sellers_present = true;
                  System.out.println(seller.ID + " : " + seller.Name + 
                  " in " + seller.Location + " has " + seller.number_of_units + 
                  " " + seller.Product + " for " + seller.unit_price + " each.");
                  }
        }   }
         if (sellers_present == false)
         System.out.println("None found.");
         inKey.close();
        }
        }

             }



