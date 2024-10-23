// HRRAKR001
// Akram Harris
// 18/10/2024

public class Person { // A Parent class
    private String name; // A Person has a name, age and gender
    private int age;
    private String gender;

    public Person(String name, int age, String gender) { // The person constructor
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public Person(Person person) { // The person copy constructor
      this.name = person.getName();
      this.age = person.getAge();
      this.gender = person.getGender();
    }

    // A bunch of get and set methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
      this.age = age;
    }
    public void setGender(String gender) {
      this.gender = gender;
    }
    public void setName(String name) {
      this.name = name;
    }

    public String getGender() {
        return gender;
    }
    
 

  
}
