public class Person {
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
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Person{ Name: %s, Age: %d, Gender: %s }".formatted(name, age, gender);
    }

    Person() {
        setName("Person");
        setAge(20);
        setGender('M');
    }

    Person(String name, int age, char gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }
}
