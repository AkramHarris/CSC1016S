// HRRAKR001
// Akram Harris
// 18/10/2024


public class Car extends Vehicle { // Subclass of vehicle
    private int seatingCapacity;
    private double weight;

    public Car(int numCylinders, String manufacturer, Student owner, int seatingCapacity, double weight) { // Constructs a car object with seatingcap and weight 
        super(numCylinders, manufacturer, owner);
        this.seatingCapacity = seatingCapacity;
        this.weight = weight;
    }

    
    public Car(Car c) { // A Car copy constructor
        super(c);
        this.seatingCapacity = c.seatingCapacity;
        this.weight = c.weight;
    }

    @Override
    public String toString() { // The toString method
        return super.toString() + "\nThe car is a " + seatingCapacity + "-seater weighing " + weight + " kg";
    }
}
