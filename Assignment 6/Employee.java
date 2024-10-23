// HRRAKR001
// 20/09/2024
// Akram Harris

import java.util.ArrayList; // We need to use an array list for this question
import java.util.List;

public class Employee {
   private String name; // Define instance variables
   private String uid;
   private CalendarTime currentSignin; 
   private List<Shift> shifts; // Initialize a List of type shift
   public Employee(String name, String uid) { // Create a Employee constructor
      this.name = name;
      this.uid = uid;
      this.currentSignin = null;
      this.shifts = new ArrayList<>(); // It starts the array list
   }
   public String name() { // Define simple get methods
      return this.name;
   }
   public String UID() {
     return this.uid;
   }
   public void signIn(Date d, Time t) {
      currentSignin = new CalendarTime(d,t);
   } 
   public void signOut(Date d, Time t) { // When someone signs out, add a shift with the signintime and signouttime as arguements to the shift arraylist
      CalendarTime signoutTime = new CalendarTime(d,t);
      shifts.add(new Shift(currentSignin, signoutTime));
      currentSignin = null;
   }
   public boolean present() { // If sign is not null, then the they are present
      return currentSignin != null;
   }
   public boolean present(Date date) { // Checks if the user is present on that date
        if (present() && currentSignin.date().equals(date)) {
            return true;
        }

        for (Shift shift : shifts) { // Checks the array
            if (shift.includesDate(date)) {
                return true;
            }
        }
        return false;
    }

    public boolean worked(Date date) { // Checks if they worked on a specified date
        for (Shift shift : shifts) { // Loops through the arraylist
            if (shift.includesDate(date)) {
                return true;
            }
        }
        return false;
    }

    public boolean worked(Week week) { // Does the same thing but checks for the week
        for (Shift shift : shifts) {
            if (shift.inWeek(week)) {
                return true;
            }
        }
        return false;
    }
    public List<Shift> get(Week w) { // Returns all the shifts recorded in that week
        List<Shift> shiftsInWeek = new ArrayList<>();
        for (Shift shift : shifts) {
            if (shift.inWeek(w)) { // If the shift falls in that week number, then add it to now arraylist
                shiftsInWeek.add(shift);
            }
        }
        return shiftsInWeek;
    }
     public List<Shift> get(Date d) { // Does the same thing but takes in a Date arguement
        List<Shift> shiftsInDate = new ArrayList<>();
        for (Shift shift : shifts) {
            if (shift.includesDate(d)) {
                shiftsInDate.add(shift);
            }
        }
        return shiftsInDate;
    }


     public Duration hours(Week w) { // Gets the total Duration worked
     Duration totalDuration = new Duration("minute", 0);
     for (Shift shift : get(w)) {
         totalDuration = totalDuration.add(shift.length()); // Adds each shift length
     }
     return totalDuration;
 }
   
}