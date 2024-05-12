import java.util.Random;
/*
 * Abdulwahab Najib Abdulrahman 4410443
 * Karam M. Ali Khirallah 4410366
 * Muayyad Mutea Alnouman 4410286
 * */
public class Person {

    // This class represents a basic Person object. It serves as a foundation class
    // for subclasses like Patient and Doctor.

    private int id;  // Unique identifier for the person
    private String name;  // Person's name

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private char gender;  // Person's gender (M or F)

    private int age;  // Person's age

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    // Ensures gender is set to either 'M' or 'F'
    public void setGender(char gender) {
        if (gender == 'M' || gender == 'm' || gender == 'f' || gender == 'F') {
            this.gender = gender;
        } else {
            System.out.println("Invalid gender. Please enter 'M' or 'F'."); // More informative error message
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: %s, ID: %d, Age: %d, Gender: %s".formatted(name, getId(), age, gender);
    }

    // Default constructor with random ID, default values for name, age and gender (M)
    public Person() {
        setName("Person");
        setAge(20);
        setGender('M');
        setId((int) Math.floor(Math.abs(new Random().nextInt() * 1000))); // Generates a random positive integer ID
    }

    // Constructor with arguments for ID, name, gender and age
    public Person(int id, String name, char gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}
