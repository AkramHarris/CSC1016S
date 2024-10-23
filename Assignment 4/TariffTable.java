// HRRAKR001
// Akram Harris
// 20/08/2024



public class TariffTable {
    private ParkingTariff[] parkingTariffs; // Creating the neccessary instance variables
    private int nextFree;
    public TariffTable(int maxSize) {
        
        this.parkingTariffs = new ParkingTariff[maxSize];
        this.nextFree = 0;
    }

    public void addTariff(TimePeriod period, Money tariff) { // Method to dd a tariff
        if (nextFree == 0) { // Fir the first tariff added
            parkingTariffs[nextFree] = new ParkingTariff(period, tariff);
            nextFree++;
        } 
        else {
            ParkingTariff lastTariff = parkingTariffs[nextFree - 1];
            boolean precede = period.precedes(lastTariff.getTimePeriod()); 
            if (!lastTariff.isDirectlyFollowedBy(period) && !precede) { // Checks if timeperiods are adjacent
                throw new IllegalArgumentException("Tariff periods must be adjacent.");
            }            
            parkingTariffs[nextFree] = new ParkingTariff(period, tariff);
            nextFree++;
        }
    }

    public Money getTariff(Duration StayTime) { // Method to get the tariff's cost
        for (int i = 0; i <= nextFree; i++) {
            if (parkingTariffs[i] != null) {
              if (parkingTariffs[i].containsDuration(StayTime)) {
                   return parkingTariffs[i].getCost();
            }
         }
        }
        return null;
    }
    public String toString() { // Creates the table
       StringBuilder bigString = new StringBuilder(); // Using this class to make generating the string easier
       boolean first = true; // Use this condition to know when to add a new line
       
       for (ParkingTariff tariff : parkingTariffs) { // Loops through array of tariffs
           if (tariff != null) {
               if (!first) {
                   bigString.append("\n");
               }
               bigString.append(tariff.toString());
               first = false;
           }
       }
       
       return bigString.toString();
}
  
}     