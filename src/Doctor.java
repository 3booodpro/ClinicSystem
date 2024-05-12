import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Doctor extends Person {
    // Doctor class inherits from Person class

    private String specialty;
    // This field stores the doctor's specialty (e.g., Cardiology, Pediatrics)

    private ArrayList<Object> schedule;
    // This field stores the doctor's schedule, likely a list of appointments or time slots.

    public Doctor(String specialty, ArrayList<Object> schedule) {
        // Constructor that takes specialty and schedule as arguments
        setSpecialty(specialty);
        setSchedule(schedule);
    }

    public Doctor(int id, String name, char gender, int age, String specialty, ArrayList<Object> schedule) {
        // Constructor that takes all doctor information and the schedule
        super(id, name, gender, age); // Calls the parent class (Person) constructor
        this.specialty = specialty;
        this.schedule = schedule;
    }

    public String getSpecialty() {
        // Getter method to access the doctor's specialty
        return specialty;
    }

    public void setSpecialty(String specialty) {
        // Setter method to update the doctor's specialty
        this.specialty = specialty;
    }

    public ArrayList<Object> getSchedule() {
        // Getter method to access the doctor's schedule
        return schedule;
    }

    public void setSchedule(ArrayList<Object> schedule) {
        // Setter method to update the doctor's schedule
        this.schedule = schedule;
    }

    Doctor() {
        // Default constructor with no arguments
        super(); // Calls the parent class (Person) default constructor
        setSpecialty("General"); // Sets default specialty to "General"
        setSchedule(new ArrayList<Object>()); // Initializes an empty schedule as an ArrayList
    }

    @Override
    public String toString() {
        // Overrides the toString() method to provide a human-readable representation of the Doctor object
        return "Doctor{" + super.toString() + // Calls the parent class toString() method
                "specialty='" + specialty + '\'' +
                ", schedule=" + schedule +
                '}';
    }
}
