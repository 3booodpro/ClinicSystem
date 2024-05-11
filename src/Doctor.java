import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Doctor extends Person {
    private String specialty;
    private ArrayList<Object> schedule;

    public Doctor(String specialty, ArrayList<Object> schedule) {
        setSpecialty(specialty);
        setSchedule(schedule);
    }

    public Doctor(int id, String name, char gender, int age, String specialty, ArrayList<Object> schedule) {
        super(id, name, gender, age);
        this.specialty = specialty;
        this.schedule = schedule;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public ArrayList<Object> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<Object> schedule) {
        this.schedule = schedule;
    }

    Doctor() {
        super();
        setSpecialty("General");
        setSchedule(new ArrayList<Object>());
    }

    @Override
    public String toString() {
        return "Doctor{" + super.toString() +
                "specialty='" + specialty + '\'' +
                ", schedule=" + schedule +
                '}';
    }
}
