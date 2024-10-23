// HRRAKR001
// Akram Harris
// 18/10/2024

public class Student extends Person { // Student is a child class of person
    private String nameOfInstitution; // Every student is a person but students go to uni and study something
    private String programOfStudy;
    private int yearOfStudy;
    private String hobbies; // And has hobbies

    
    public Student(String name, int age, String gender, String institution, String program, int year, String hobbies) { // Student constructor
        super(name, age, gender);  
        this.nameOfInstitution = institution;
        this.programOfStudy = program;
        this.yearOfStudy = year;
        this.hobbies = hobbies;
    }

    
    public Student(Student student) { // A student copy constructor that inherits from person
        super(student.getName(), student.getAge(), student.getGender());
        this.nameOfInstitution = student.getNameOfInstitution();
        this.programOfStudy = student.getProgramOfStudy();
        this.yearOfStudy = student.getYearOfStudy();
        this.hobbies = student.getHobbies();
    }

    // A bunch of get and set methods
    public String getNameOfInstitution() {
        return nameOfInstitution;
    }

    public String getProgramOfStudy() {
        return programOfStudy;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public String getHobbies() {
        return hobbies;
    }

    
    public void setNameOfInstitution(String nameOfInstitution) {
        this.nameOfInstitution = nameOfInstitution;
    }

    public void setProgramOfStudy(String programOfStudy) {
        this.programOfStudy = programOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
    }
