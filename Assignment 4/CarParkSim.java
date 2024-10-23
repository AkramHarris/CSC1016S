// HRRAKR001
// Akram Harris
// 20/08/2024

import java.util.Scanner;

/**
 * The CarParkSim class contains the main car park simulation method.
 * It creates and manipulates the main objects, and handles user I/O.
 *
 * @author Stephan Jamieson and...
 * @version 09/08/2024
 */
public class CarParkSim {

    public static void main(final String[] args) {
        final Scanner keyboard = new Scanner(System.in);

        // Initialize the Clock and Register objects.
        Time currentTime = new Time("00:00:00");
        Clock clock = new Clock(currentTime);
        Register register = new Register();
        Currency rand = new Currency("R", "ZAR", 100);

        // Define the tariffs for the car park.
        TariffTable tariffs = new TariffTable(100);
        tariffs.addTariff(new TimePeriod(new Duration("minute", 0), new Duration("minute", 30)), new Money("R10", rand));
        tariffs.addTariff(new TimePeriod(new Duration("minute", 30), new Duration("hour", 1)), new Money("R15", rand));
        tariffs.addTariff(new TimePeriod(new Duration("hour", 1), new Duration("hour", 3)), new Money("R20", rand));
        tariffs.addTariff(new TimePeriod(new Duration("hour", 3), new Duration("hour", 4)), new Money("R30", rand));
        tariffs.addTariff(new TimePeriod(new Duration("hour", 4), new Duration("hour", 5)), new Money("R40", rand));
        tariffs.addTariff(new TimePeriod(new Duration("hour", 5), new Duration("hour", 6)), new Money("R50", rand));
        tariffs.addTariff(new TimePeriod(new Duration("hour", 6), new Duration("hour", 8)), new Money("R60", rand));
        tariffs.addTariff(new TimePeriod(new Duration("hour", 8), new Duration("hour", 10)), new Money("R70", rand));
        tariffs.addTariff(new TimePeriod(new Duration("hour", 10), new Duration("hour", 12)), new Money("R90", rand));
        tariffs.addTariff(new TimePeriod(new Duration("hour", 12), new Duration("day", 1)), new Money("R100", rand));

        System.out.println("Car Park Simulator");
        System.out.println("The current time is " + clock.examine().toString() + ".");
        System.out.println("Commands: tariffs, advance {minutes}, arrive, depart, quit.");
        System.out.print(">");

        String input = keyboard.next().toLowerCase();
        while (!input.equals("quit")) {
            if (input.equals("advance")) { // Advances the clock by the given duration
                long minutes = keyboard.nextLong();
                Duration duration = new Duration("minute", minutes);
                clock.advance(duration);
                System.out.println("The current time is " + clock.examine().toString() + "."); // Prints it out
            } 
            else if (input.equals("arrive")) { // Creates a ticket that stores the current time as arrival time
                Ticket newTicket = new Ticket(clock.examine());
                register.add(newTicket); // Adds it to the register of tickets
                System.out.println("Ticket issued: " + newTicket.toString() + ".");
            } 
            else if (input.equals("depart")) {
                String ticketID = keyboard.next(); // Finds the ticketID in the array register
                if (register.contains(ticketID)) {
                    Ticket ticket = register.retrieve(ticketID); // Getts that ticket in the register
                    System.out.println("Ticket details: " + ticket.toString() + "."); // Prints out information
                    System.out.println("Current time: " + clock.examine().toString() + ".");
                    Duration durationOfStay = ticket.age(clock.examine());
                    String durationFormatted = Duration.format(durationOfStay, TimeUnit.MINUTE);
                    System.out.println("Duration of stay: " + durationFormatted + ".");
                    Money costOfStay = tariffs.getTariff(durationOfStay);
                    System.out.println("Cost of stay : " + costOfStay.toString() + "."); // Gets the tariff cost for the duration you stayed
                } else {
                    System.out.println("Invalid ticket ID.");
                }
            } 
            else if (input.equals("tariffs")) {
                System.out.println("[0 minutes .. 30 minutes] : R10.00"); // Prints out prices
                System.out.println("[30 minutes .. 1 hour] : R15.00");
                System.out.println("[1 hour .. 3 hours] : R20.00");
                System.out.println("[3 hours .. 4 hours] : R30.00");
                System.out.println("[4 hours .. 5 hours] : R40.00");
                System.out.println("[5 hours .. 6 hours] : R50.00");
                System.out.println("[6 hours .. 8 hours] : R60.00");
                System.out.println("[8 hours .. 10 hours] : R70.00");
                System.out.println("[10 hours .. 12 hours] : R90.00");
                System.out.println("[12 hours .. 1 day] : R100.00");
            } 
            else {
                System.out.println("That command is not recognised.");
                System.out.println("Commands: tariffs, advance {minutes}, arrive, depart, quit.");
            }

            System.out.print(">");
            input = keyboard.next().toLowerCase();
        }

        System.out.println("Goodbye.");
        keyboard.close();
    }
}
