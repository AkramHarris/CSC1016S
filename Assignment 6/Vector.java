// HRRAKR001
// 20/09/2024
// Akram Harris
public class Vector {
    private double x;
    private double y;

    public Vector(double x, double y) { // Creates a constructor that takes an x nd a y coordinate
        this.x = x;
        this.y = y;
    }

    public double getMagnitude() { // Gets the magnitude by squaring the values and adding them
        return Math.sqrt(x * x + y * y);
    }

    public Vector add(Vector other) { // Adds 2 vectors
        return new Vector(this.x + other.x, this.y + other.y);
    }

    public Vector multiply(double scalar) { // Multiplies the vector by a value
        return new Vector(this.x * scalar, this.y * scalar);
    }

    public double dotProduct(Vector other) { // Gets the dot product
        return this.x * other.x + this.y * other.y;
    }
   
    public String toString(){ // Simple to string method
        return String.format("v = (%.2f, %.2f)", this.x, this.y);
    }
}
