// HRRAKR001
// 20/09/2024
// Akram Harris

public class Shift {
   private static CalendarTime start;
   private static CalendarTime finish;
   
   public Shift(CalendarTime start, CalendarTime finish) { // Creates a constructor with shift start time and end time
      this.start = start;
      this.finish = finish;
   }
   public static CalendarTime start() { // Simple get methods
      return start;
   }
   public static CalendarTime finish() {
      return finish;
   }
   public static boolean inWeek(Week w) { // Checks if shift falls in a week
      return w.includes(start.date()) || w.includes(finish.date());
   }
      
   public static boolean includesDate(Date date) {
        return (start.date().compareTo(date) <= 0 && finish.date().compareTo(date) >= 0); // Checks if it falls in a given date
   }
   public static Duration length() { // Obtains the length of the shift
      return finish.subtract(start);
      
   }
   public String toString() { // Simple toString method
      return start.toString() + " - " + finish.toString();
   }
}