import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Doctor extends Person {
    private String specialty;
    private CustomArray schedule;

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public CustomArray getSchedule() {
        return schedule;
    }

    public void setSchedule(CustomArray schedule) {
        this.schedule = schedule;
    }

    Doctor() {
        setSpecialty("General");
        setSchedule(new CustomArray());
    }

    public void showInformation(){
        try {

            BufferedReader reader = new BufferedReader(new FileReader("Doctorinfo.txt"));
            System.out.println(reader.readLine());
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    Doctor(String name, int age, char gender, String specialty, CustomArray schedule) {
        super(name, age, gender);
        setSpecialty(specialty);
        setSchedule(schedule);
    }


}
