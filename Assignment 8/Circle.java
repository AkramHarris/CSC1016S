// HRRAKR001
// Akram Harris
// 01/10/2024

public class Circle extends Shape {
    private double radius;

    public Circle() { // Default constructor
        super();
        this.radius = 1.0;
    }

    public Circle(double radius) { // Constructor with radius
        super("unknown", false);
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) { // Constructor with radius and color
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() { // Get radius
        return radius;
    }

    public void setRadius(double radius) { // Set radius
        this.radius = radius;
    }

    @Override
    public double getArea() { // Calculate area
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() { // Calculate perimeter
        return 2 * Math.PI * radius;
    }

    public boolean equals(Circle other) { // Check if circles are equal
        if (this == other)
            return true;

        return Double.compare(this.radius, other.radius) == 0 &&
               this.getColor().equals(other.getColor()) &&
               this.isFilled() == other.isFilled();
    }

    @Override
    public String toString() { // String method
        return "Circle[radius=" + radius + ", " + super.toString() + "]";
    }
}