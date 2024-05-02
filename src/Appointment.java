import java.util.Date;

public class Appointment {
    private Date date;
    private Patient patient;

    public Appointment(Date date, Patient patient) {
        this.date = date;
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "date: " + date +
                ", patient: " + patient +
                '}';
    }
}
