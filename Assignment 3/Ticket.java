// HRRAKR001
// Akram Harris
// 09/08/2024

public class Ticket { // Creating instance variables
   String id;
   Time issueTime;
   
   public Ticket(Time currentTime, String ID) { // Creating a constructor
      this.issueTime = currentTime;
      this.id = ID;
      
   }
   public String ID() { // Return a string id
      return this.id;
   }
   public Duration age(Time currentTime) {
      Duration ticketage = currentTime.subtract(this.issueTime);
      return ticketage; // Returns how long the person was parked
   }
   public String toString() {
      return "Ticket[id=" + this.id + ", time=" + this.issueTime + "]";
   }
   
}