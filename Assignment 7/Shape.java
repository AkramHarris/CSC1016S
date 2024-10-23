//HRRAKR001
//25/09/2024
//Akram Harris
public class Shape { // The Parent class Shape
  private String name; // Name and color are general attributes of shapes
  private String color;
  
  
   public Shape(Shape other) { //Equating 2 Shapes
        this.name = other.name;
        this.color = other.color;
    }

   
    public Shape(String name, String color) { // The Shape Constructor
        this.name = name;
        this.color = color;
    }

    
    @Override
    public String toString() { // The toString method
        return name + " " + color;
    }
}


