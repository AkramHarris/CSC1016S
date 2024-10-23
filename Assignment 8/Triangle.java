// HRRAKR001
// Akram Harris
// 01/10/2024
public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() { // Default constructor
        super();
        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;
    }

    public Triangle(double side1, double side2, double side3) { // Constructor with sides
        super("unknown", false);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(double side1, double side2, double side3, String color, boolean filled) { // Constructor with sides and color
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() { // Get side methods
        return side1;
    }

    public void setSide1(double side1) { // Set side1
        this.side1 = side1;
    }

    public double getSide2() { // Get side2
        return side2;
    }

    public void setSide2(double side2) { // Set side2
        this.side2 = side2;
    }

    public double getSide3() { // Get side3
        return side3;
    }

    public void setSide3(double side3) { // Set side3
        this.side3 = side3;
    }

    @Override
    public double getArea() { // Calculate area
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double getPerimeter() { // Calculate perimeter
        return side1 + side2 + side3;
    }

    public boolean equals(Triangle other) { // Check if triangles are equal
        if (this == other)
            return true;

        return Double.compare(this.side1, other.side1) == 0 &&
               Double.compare(this.side2, other.side2) == 0 &&
               Double.compare(this.side3, other.side3) == 0 &&
               this.getColor().equals(other.getColor()) &&
               this.isFilled() == other.isFilled();
    }

    @Override
    public String toString() { // String method
        return "Triangle[side1=" + side1 + ", side2=" + side2 + ", side3=" + side3 + ", " + super.toString() + "]";
    }
}