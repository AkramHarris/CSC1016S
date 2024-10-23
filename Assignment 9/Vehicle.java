// HRRAKR001
// Akram Harris
// 18/10/2024

class Vehicle { // A parent class
    private int numCylinders;
    private String maker;
    private Student owner;

    
    public Vehicle(int numCylinders, String maker, Student owner) { // The Vehicle constructor
        this.numCylinders = numCylinders;
        this.maker = maker;
        this.owner = owner;
    }

    
    public Vehicle(Vehicle v) { // The copy constructor
        this.numCylinders = v.numCylinders;
        this.maker = v.maker;
        this.owner = v.owner;
    }

    
    @Override
    public String toString() { // The toString method (gets used in car)
        return maker + ", " + numCylinders + " cylinders, owned by " + owner.getName() +
                ", a " + owner.getAge() + "-year old " + owner.getGender() +
                " studying " + owner.getProgramOfStudy() + " at " + owner.getNameOfInstitution() +
                ". " + owner.getName() + " likes " + owner.getHobbies() + ".";
    }
}
