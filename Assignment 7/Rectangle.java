// HRRAKR001
// 25/09/2024
// Akram Harris

public class Rectangle extends Shape { // A Rectangle (child) class that inherits from Shape
   private double length; // The width and length of the rectangle
   private double width;

 
 public Rectangle(String name, String color, double length, double width) { // A Rectangle constructor
     super(name, color); // Calling the Shape constructor            
     this.width = width;
     this.length = length;
   }
 public Rectangle(Rectangle other) { // Equating 2 Rectangles
        super(other);
        this.length = other.length;
        this.width = other.width;
    }
   
 @Override
 public String toString() { // The toString method for Rectangle that will override the existing toString method
     return super.toString() + " Length " + length + " Width " + width;
 }

}