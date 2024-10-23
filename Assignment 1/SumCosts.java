// Akram Harris
// HRRAKR001
// 25/07/2024


import java.util.Scanner;

public class SumCosts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an amount or '[D]one' to print the sum and quit:");
        String user_amount = scanner.nextLine();

        if (user_amount.equals("Done") || user_amount.equals("D")) {
            System.out.println("Total: R0.00");
        } else {
            Currency rand = new Currency("R", "ZAR", 100);
            Money initial_amount = new Money(user_amount, rand);
            Money total_amount = initial_amount;

            while (true) {
                System.out.println("Enter an amount or '[D]one' to print the sum and quit:");
                String add_amount = scanner.nextLine();
                if (add_amount.equals("Done") || add_amount.equals("D")) {
                    break;
                }
                Money added_amount = new Money(add_amount, rand);
                total_amount = total_amount.add(added_amount);
            }
            String print_total = total_amount.toString();
            System.out.println("Total: " + print_total);
        }

        scanner.close();
    }
}

       
         
                  
         
      
      