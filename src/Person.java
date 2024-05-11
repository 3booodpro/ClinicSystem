import java.util.Random;

public class Person {
    // Basic Class for a person.. later we will extend it for a patient class and a doctor class.

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private char gender;

    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        if(gender == 'M' || gender == 'm' || gender == 'f' || gender == 'F') {
            this.gender = gender;
        }
        else {
            System.out.println(Colors.RED + "This gender exists only in USA. shame on you." + Colors.RESET);
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Name: %s, ID: %d, Age: %d, Gender: %s, ".formatted(name, getId(), age, gender);
    }

    Person() {
        setName("Person");
        setAge(20);
        setGender('M');
        setId((int) Math.floor(Math.abs(new Random().nextInt()*1000)));
    }

    public Person(int id, String name, char gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}
