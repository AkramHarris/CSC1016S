// HRRAKR001
// Akram Harris
// 01/10/2024


public abstract class Shape { // A parent class for other shapes that contain abstract methods
    private String color;
    private boolean filled;

   
    public Shape() {
        this.color = "unknown";
        this.filled = false;
    }

    
    public Shape(String color, boolean filled) { // A shape constructor
        this.color = color;
        this.filled = filled;
    }

    
    public String getColor() { // Get method for color
        return color;
    }

    public void setColor(String color) { // Set method for color
        this.color = color;
    }

    
    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    
    public abstract double getArea();
    public abstract double getPerimeter();
    
    
   public boolean equals(Shape other) { // equals method to check if 2 shapes are equal to each other
      if (this == other) 
         return true;
      if (this.color==other.color && this.filled==other.filled)
         return true;
      return false;
   }

    @Override
    public String toString() {
        return "Shape[color=" + color + ", filled=" + filled + "]";
    }
}
