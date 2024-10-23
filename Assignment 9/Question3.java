// HRRAKR001
// Akram Harris
// 18/10/2024

import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.println("Enter the vehicle manufacturer:");
        String manufacturer = sc.nextLine();
        
        System.out.println("Enter the name of the vehicle owner:");
        String ownerName = sc.nextLine();
        
        System.out.println("Enter the owner's gender:");
        String ownerGender = sc.nextLine();
        
        System.out.println("Enter the owner's programme of study:");
        String ownerProgramme = sc.nextLine();
        
        System.out.println("Enter the owner's Institution name:");
        String ownerInstitution = sc.nextLine();
        
        System.out.println("Enter the owner's hobbies:");
        String ownerHobbies = sc.nextLine();
        
        System.out.println("Enter the owner's age:");
        int ownerAge = sc.nextInt();
        
        
        System.out.println("Enter the number of cylinders in the engine:");
        int numCylinders = sc.nextInt();
        
        System.out.println("Enter the car seating capacity:");
        int seatingCapacity = sc.nextInt();
        
        System.out.println("Enter the weight of the car:");
        double carWeight = sc.nextDouble();

        // Gets the students details and constructs a Student owner object
        Student owner = new Student(ownerName, ownerAge, ownerGender, ownerInstitution, ownerProgramme, 0, ownerHobbies);

        
        Car car = new Car(numCylinders, manufacturer, owner, seatingCapacity, carWeight); // Creates a car object

        
        System.out.println(car.toString());

        sc.close();
    }
}
