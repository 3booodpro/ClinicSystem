import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Timer; // This import might not be used in this class

/*
 * Abdulwahab Najib Abdulrahman 4410443
 * Karam M. Ali Khirallah 4410366
 * Muayyad Mutea Alnouman 4410286
 * */


public class Patient extends Person {

    // This class represents a Patient in the Clinic Management System

    private ArrayList<Object> history;  // List containing patient's medical history entries (Consider using a dedicated class for history entries)
    private ArrayList<Object> schedule;  // List containing patient's appointments or scheduled events
    private int contactDetails;  // Likely stores patient's contact information (phone number, etc.) (Needs clarification on format)

    public Patient() {
        super();  // Calls the parent class (Person) constructor with default arguments
        this.history = new ArrayList<Object>();  // Initializes an empty list for medical history
        this.schedule = new ArrayList<Object>();  // Initializes an empty list for appointments/schedule
    }

    public Patient(int id, String name, char gender, int age, ArrayList<Object> history, ArrayList<Object> schedule, int contactDetails, String infoAddress, String oldSickness) {
        super(id, name, gender, age);  // Calls the parent class (Person) constructor with provided arguments
        this.history = history;
        this.schedule = schedule;
        this.contactDetails = contactDetails;
        this.infoAddress = infoAddress;
        this.oldSickness = oldSickness;
    }

    public ArrayList<Object> getSchedule() {
        // Getter method to access the patient's schedule
        return schedule;
    }

    public void setSchedule(ArrayList<Object> schedule) {
        // Setter method to update the patient's schedule
        this.schedule = schedule;
    }

    private String infoAddress;
    private String oldSickness;  // Whether or not the patient has an old disease.
    public ArrayList<Object> getHistory() {
        // Getter method to access the patient's medical history
        return history;
    }

    public void setHistory(ArrayList<Object> history) {
        this.history = history;
    }

    public String getOldSickness() {
        return oldSickness;
    }

    public void setOldSickness(String oldSickness) {
        this.oldSickness = oldSickness;
    }

    // Constructor with arguments for history, contact details, address and old sickness (alternative to the constructor with all fields)
    public Patient(ArrayList<Object> history, int contactDetails, String infoAddress, String oldSickness) {
        this.history = history;
        this.contactDetails = contactDetails;
        this.infoAddress = infoAddress;
        this.oldSickness = oldSickness;
    }

    // Adds a new history entry with description, date and cost
    public void addHistory(String description, String cost) {
        History newHistory = new History(description, new Date(), cost); // Creates a new History object with details
        history.add(newHistory);  // Adds the new history entry to the patient's history list
    }

    // Sets the entire history list (likely for internal use)
    public void setAllHistory(ArrayList<Object> newValue) {
        history = newValue;
    }

    // Removes a history entry based on its index in the list
    public void removeHistory(int index) {
        history.remove(index);
    }

    public int getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(int contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getInfoAddress() {
        return infoAddress;
    }

    public void setInfoAddress(String infoAddress) {
        this.infoAddress = infoAddress;
    }

    @Override
    public String toString() {
        return "Patient{" + super.toString() +
                "history=" + history +
                ", contactDetails=" + contactDetails +
                ", infoAddress='" + infoAddress + '\'' +
                ", oldSickness='" + oldSickness + '\'' +
                '}';
    }
}
