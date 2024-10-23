//HRRAKR001
//25/09/2024
//Akram Harris

public class Circle extends Shape { // Child Class that inherits from Shape
    private double radius; // Radius of the circle shape

   
    public Circle(String name, String color, double radius) { // A circle constructor
        super(name, color); // Calling the Shape constructor  
        this.radius = radius;
    }
    public Circle(Circle other) { // Equating 2 circles
        super(other); 
        this.radius = other.radius;
    }
    
    @Override
    public String toString() { // The to String method that overrides the shape to String method
        return super.toString() + " Radius " + radius;
    }
}

