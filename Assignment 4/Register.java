
public class Register {
   Ticket[] tickets = new Ticket[100]; // Initializing an array with size 100
   int numTickets = 0;
   
   
   public Register() {
   
   
   }
   public void add(Ticket ticket) { // Add an ticket to register 
         tickets[numTickets] = ticket;
         numTickets++;
    
   }
   public boolean contains(String ticketID) { // Checks if ticket is present in array
     for (int i = 0; i < numTickets; i++) {
         if (tickets[i].ID().equals(ticketID)) {
          return true;
         }
     }
     return false;
   }
   public Ticket retrieve(String ticketID) { // Returns the ticket from array with a string argument
      for (int i=0; i < numTickets; i++) {
         if (tickets[i].ID().equals(ticketID)) {
            return tickets[i];
         }
      }
      return null;
   }
   
}