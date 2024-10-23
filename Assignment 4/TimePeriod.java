// HRRAKR001
// Akram Harris
// 20/08/2024

public class TimePeriod {
   private Duration lowerBound; // Creating the required instance variables
   private Duration upperBound;
   public TimePeriod(Duration lowerBound, Duration upperBound) { // Creating a constructor
      this.lowerBound = lowerBound;
      this.upperBound = upperBound;
   }
   public Duration lowerBound() {
      return this.lowerBound;
   }
   
   public Duration upperBound() {
      return this.upperBound;
   }
   
   public boolean includes(Duration duration) { // Checks if the bounds are included in duration
      if (this.lowerBound().compareTo(duration) <= 0 && this.upperBound().compareTo(duration) > 0) {
         return true;
      }
      return false;
   }
   
   public boolean precedes(TimePeriod other) { // Compares 2 timeperiods
      if (this.upperBound().compareTo(other.lowerBound())<=0) {
         return true;
      }
      return false;
   }
   
   public boolean adjacent(TimePeriod other) { // Checks if 2 timeperiods are followed by one another
      if (this.upperBound().compareTo(other.lowerBound()) == 0 || this.lowerBound().compareTo(other.upperBound()) == 0) {
         return true;
      }
      return false;
   }
   
   public String toString() { // To string method to print timeperiod out
      String timePeriodLower = Duration.format(this.lowerBound, TimeUnit.MINUTE);
      String timePeriodUpper = Duration.format(this.upperBound, TimeUnit.MINUTE);
      return "[" + timePeriodLower + " .. " + timePeriodUpper + "]";
   }

   
}
            