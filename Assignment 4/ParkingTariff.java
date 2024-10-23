// HRRAKR001
// Akram Harris
// 20/08/2024
public class ParkingTariff {
   TimePeriod timePeriod; // Creating the instance variables
   Money cost;
   public ParkingTariff() {
   }
   public ParkingTariff(TimePeriod timePeriod, Money cost) { // Creating constructor
      this.timePeriod = timePeriod;
      this.cost = cost;
      
   }
   public TimePeriod getTimePeriod() {
      return timePeriod;
   }
   
   public void setMoney(Money money) { // Sets the cost of the tariff
      this.cost = money;
   }
   public void setTimePeriod(TimePeriod timePeriod) { // Sets the timeperiod
      this.timePeriod = timePeriod;
   }
   
   public Money getCost() {
      return cost;
   }
   public boolean containsDuration(Duration duration) { // These methods are to check if this parkingtariff can be valid
      return this.timePeriod.includes(duration);
   }
   public boolean isDirectlyFollowedBy(TimePeriod other) {
      return this.timePeriod.adjacent(other);
      
   }
   public String toString() { // Converts to string
        return this.timePeriod.toString() + " : " + cost.toString();
    }
    
}