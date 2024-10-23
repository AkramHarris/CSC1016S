// HRRAKR001
// Akram Harris
// 09/08/2024

import java.util.Scanner;

/**
 * The CarParkSim class contains the main car park simulation method.
 * It creates and manipulates the main objects, and handles user I/O.
 *
 * @author Stephan Jamieson and ...
 * @version 14/7/2019
 */
public class CarParkSim {

    public static void main(final String[] args) {
        final Scanner keyboard = new Scanner(System.in);
        // YOUR CODE HERE.
        // Declare variables to store a Clock and a Register object, create the relevant objects and assign them.
        Time currentTime = new Time("00:00:00");
        Clock clock = new Clock(currentTime);
        Register register = new Register();

        System.out.println("Car Park Simulator");

        // YOUR CODE HERE.
        // Print current time.
        System.out.println("The current time is " + clock.examine().toString() + ".");
        System.out.println("Commands: advance {minutes}, arrive, depart, quit.");
        System.out.print(">");

        String input = keyboard.next().toLowerCase();
        while (!input.equals("quit")) {
            if (input.equals("advance")) {
                // YOUR CODE HERE.
                // Advance the clock, print the current time.
                long user_input = keyboard.nextLong();
                Duration duration = new Duration("minute", user_input);
                clock.advance(duration);
                System.out.println("The current time is " + clock.examine().toString() + ".");
            }
            else if (input.equals("arrive")) {
                // YOUR CODE HERE.
                // Create a new ticket, add it to the register, print details of ticket issued.
                String ticketID = UIDGenerator.makeUID();
                Ticket newTicket = new Ticket(clock.examine(), ticketID);
                register.add(newTicket);
                
                System.out.println("Ticket issued: " + newTicket.toString() + ".");
            }
            else if (input.equals("depart")) {
                // YOUR CODE HERE.
                // Determine if ticket is valid, i.e. in the register.
                // If not, print error message.
                // If yes, retrieve it, calculate duration of stay and print it.
                String ticketID = keyboard.next();
                if (register.contains(ticketID)) {
                    Ticket ticket = register.retrieve(ticketID);
                    System.out.println("Ticket details: " + ticket.toString() + ".");
                    System.out.println("Current time: " + clock.examine().toString() + ".");
                    Duration durationOfStay = ticket.age(clock.examine());
                    
                    String d = Duration.format(durationOfStay, TimeUnit.MINUTE);
                    System.out.println("Duration of stay: " + d + ".");
                } else {
                    System.out.println("Invalid ticket ID.");
                }
            }
            else {
                System.out.println("That command is not recognised.");
                System.out.println("Commands: advance <minutes>, arrive, depart, quit.");
            }            
            System.out.print(">");
            input = keyboard.next().toLowerCase();
        }
        System.out.println("Goodbye.");
    }
}
