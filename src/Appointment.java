import java.util.Date;

public class Appointment {
    String date;
    String patient_name;
    String doctor_name;

    public Appointment() {
    }

    public Appointment(String date, String patient_name, String doctor_name) {
        this.date = date;
        this.patient_name = patient_name;
        this.doctor_name = doctor_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "date=" + date +
                ", patient_name='" + patient_name + '\'' +
                ", doctor_name='" + doctor_name + '\'' +
                '}';
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }
}
