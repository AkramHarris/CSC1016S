// HRRAKR001
// Akram Harris
// 18/10/2024


import java.util.ArrayList;
import java.util.Scanner;


abstract class Part { // Part is an abstract class
    protected String serialNumber;
    protected String manufacturer;
    protected String colour;

    public Part(String serialNumber, String manufacturer, String colour) { // Part constructor
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.colour = colour;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String toString() {
        return serialNumber + ", " + manufacturer + ", " + colour;
    }
}


class Box extends Part { // A box is a part but has memory
    private int memory;

    public Box(String serialNumber, String manufacturer, String colour, int memory) { // Box constructor
        super(serialNumber, manufacturer, colour);
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Box: " + super.toString() + ", " + memory;
    }
}


class Screen extends Part { // Screen is a child class of part
    private int size;

    public Screen(String serialNumber, String manufacturer, String colour, int size) { // Screen constructor
        super(serialNumber, manufacturer, colour);
        this.size = size;
    }

    @Override
    public String toString() {
        return "Screen: " + super.toString() + ", " + size;
    }
}


class Accessory extends Part { // An accessory is a child class of part
    public Accessory(String serialNumber, String manufacturer, String colour) {
        super(serialNumber, manufacturer, colour);
    }

    @Override
    public String toString() { // All of them have toString methods
        return "Accessories: " + super.toString();
    }
}


public class Question1 { // Question1 is for userinput and output
    private static ArrayList<Part> parts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Great International Technology");
        String option;

        do {
            System.out.println("MENU: add (B)ox, add (S)creen, add (A)ccessories, (D)elete, (L)ist, (Q)uit");
            option = scanner.nextLine().toLowerCase();

            switch (option) {
                case "b":
                    addBox();
                    break;
                case "s":
                    addScreen();
                    break;
                case "a":
                    addAccessory();
                    break;
                case "d":
                    deletePart();
                    break;
                case "l":
                    listParts();
                    break;
                case "q":
                    
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (!option.equals("q"));
    }

    private static void addBox() {
        System.out.println("Enter the serial number");
        String serialNumber = scanner.nextLine();
        System.out.println("Enter the manufacturer");
        String manufacturer = scanner.nextLine();
        System.out.println("Enter the colour");
        String colour = scanner.nextLine();
        System.out.println("Enter the amount of memory (MB)");
        int memory = Integer.parseInt(scanner.nextLine());

        parts.add(new Box(serialNumber, manufacturer, colour, memory)); // Makes a new Box object based on userinput 
        System.out.println("Done"); // Adds it to a parts Arraylist
    }

    private static void addScreen() {
        System.out.println("Enter the serial number");
        String serialNumber = scanner.nextLine();
        System.out.println("Enter the manufacturer");
        String manufacturer = scanner.nextLine();
        System.out.println("Enter the colour");
        String colour = scanner.nextLine();
        System.out.println("Enter the screen size in inches");
        int size = Integer.parseInt(scanner.nextLine());

        parts.add(new Screen(serialNumber, colour, manufacturer, size)); // Makes a screen based on userinput
        System.out.println("Done"); // Adds it to a parts Arraylist
    }

    private static void addAccessory() {
        System.out.println("Enter the serial number");
        String serialNumber = scanner.nextLine();
        System.out.println("Enter the manufacturer");
        String manufacturer = scanner.nextLine();
        System.out.println("Enter the colour");
        String colour = scanner.nextLine();

        parts.add(new Accessory(serialNumber, manufacturer, colour)); // Makes an accessory based on userinput
        System.out.println("Done"); // Adds it to a parts Arraylist
    }

    private static void deletePart() {
        System.out.println("Enter the serial number");
        String serialNumber = scanner.nextLine(); // removes part from list

        Part partToRemove = null;
        for (Part part : parts) {
            if (part.getSerialNumber().equals(serialNumber)) {
                partToRemove = part;
                break;
            }
        }

        if (partToRemove != null) {
            parts.remove(partToRemove);
            System.out.println("Done");
        } else {
            System.out.println("Not found");
        }
    }

    private static void listParts() {
        if (parts.isEmpty()) {
            
        } else {
            for (Part part : parts) {
                System.out.println(part); // List all parts
            }
        }
        System.out.println("Done");
    }
}
