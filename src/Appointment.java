import java.util.Date; 
/**
 * This class represents an appointment.
 */
public class Appointment {

    /**
     * The date of the appointment as a String. You might want to consider using a LocalDate object from java.time for better date handling.
     */
    String date;

    /**
     * The name of the patient attending the appointment.
     */
    String patient_name;

    /**
     * The name of the doctor for the appointment.
     */
    String doctor_name;

    /**
     * Default constructor for Appointment. Initializes all fields to empty strings.
     */
    public Appointment() {
    }

    /**
     * Constructor for Appointment that takes all required fields.
     *
     * @param date The date of the appointment as a String.
     * @param patient_name The name of the patient attending the appointment.
     * @param doctor_name The name of the doctor for the appointment.
     */
    public Appointment(String date, String patient_name, String doctor_name) {
        this.date = date;
        this.patient_name = patient_name;
        this.doctor_name = doctor_name;
    }

    /**
     * Getter method to access the appointment date.
     *
     * @return The date of the appointment as a String.
     */
    public String getDate() {
        return date;
    }

    /**
     * Setter method to update the appointment date.
     *
     * @param date The new date for the appointment as a String.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Overrides the toString() method to provide a human-readable representation of the Appointment object.
     *
     * @return A formatted string containing appointment details.
     */
    @Override
    public String toString() {
        return "Appointment{" +
                "date=" + date +
                ", patient_name='" + patient_name + '\'' +
                ", doctor_name='" + doctor_name + '\'' +
                '}';
    }

    /**
     * Getter method to access the patient name.
     *
     * @return The name of the patient attending the appointment.
     */
    public String getPatient_name() {
        return patient_name;
    }

    /**
     * Setter method to update the patient name.
     *
     * @param patient_name The new name for the patient.
     */
    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    /**
     * Getter method to access the doctor name.
     *
     * @return The name of the doctor for the appointment.
     */
    public String getDoctor_name() {
        return doctor_name;
    }

    /**
     * Setter method to update the doctor name.
     */
    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }
}
