import java.util.Random;

public class Person extends identifier {
    // Basic Class for a person.. later we will extend it for a patient class and a doctor class.


    private String name;
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
        return "{ Name: %s, ID: %d, Age: %d, Gender: %s }".formatted(name, getIdentifier(), age, gender);
    }

    Person() {
        setName("Person");
        setAge(20);
        setGender('M');
        setIdentifier((int) Math.floor(Math.abs(new Random().nextInt()*1000)));
    }

    Person(String name, int age, char gender) {
        setName(name);
        setAge(age);
        setGender(gender);
        setIdentifier((int) Math.floor(Math.abs(new Random().nextInt()*1000)));
    }
}
