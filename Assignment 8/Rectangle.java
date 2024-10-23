// HRRAKR001
// Akram Harris
// 01/10/2024

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle() { // Default constructor
        super();
        this.width = 1.0;
        this.height = 1.0;
    }

    public Rectangle(double width, double height) { // Constructor with dimensions
        super("unknown", false);
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String color, boolean filled) { // Constructor with dimensions and color
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() { // Get width
        return width;
    }

    public void setWidth(double width) { // Set width
        this.width = width;
    }

    public double getHeight() { // Get height
        return height;
    }

    public void setHeight(double height) { // Set height
        this.height = height;
    }

    @Override
    public double getArea() { // Calculate area
        return width * height;
    }

    @Override
    public double getPerimeter() { // Calculate perimeter
        return 2 * (width + height);
    }

    public boolean equals(Rectangle other) { // Check if rectangles are equal
        if (this == other)
            return true;

        return Double.compare(this.width, other.width) == 0 &&
               Double.compare(this.height, other.height) == 0 &&
               this.getColor().equals(other.getColor()) &&
               this.isFilled() == other.isFilled();
    }

    @Override
    public String toString() { // String method
        return "Rectangle[width=" + width + ", height=" + height + ", " + super.toString() + "]";
    }
}