import java.util.Date;
import java.util.Random;

public class Appointment extends identifier  {

    private Date date;

    private int doctorID;
    private int patientID;

    public Appointment(Date date, int patientID, int doctorID) {
        this.date = date;
        this.patientID = patientID;
        this.doctorID = doctorID;
        setIdentifier((int) Math.floor(Math.abs(new Random().nextInt()*1000)));
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public int getPatientID() {
        return patientID;
    }


    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "date: " + date +
                ", patientID: " + patientID +
                '}';
    }
}
