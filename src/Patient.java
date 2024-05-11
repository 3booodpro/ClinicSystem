import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Timer;

public class Patient extends Person {
    private ArrayList<Object> history;
    private ArrayList<Object> schedule;
    private int contactDetails;

    public Patient() {
        super();
        this.history = new ArrayList<Object>();
        this.schedule = new ArrayList<Object>();
    }

    public Patient(int id, String name, char gender, int age, ArrayList<Object> history, ArrayList<Object> schedule, int contactDetails, String infoAddress, String oldSickness) {
        super(id, name, gender, age);
        this.history = history;
        this.schedule = schedule;
        this.contactDetails = contactDetails;
        this.infoAddress = infoAddress;
        this.oldSickness = oldSickness;
    }

    public ArrayList<Object> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<Object> schedule) {
        this.schedule = schedule;
    }

    private String infoAddress;
    private String oldSickness; // Whether the patient has an old sickness, i think this is the way to do it ?

    public ArrayList<Object> getHistory() {
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

    public Patient(ArrayList<Object> history, int contactDetails, String infoAddress, String oldSickness) {
        this.history = history;
        this.contactDetails = contactDetails;
        this.infoAddress = infoAddress;
        this.oldSickness = oldSickness;
    }

    public void addHistory(String description, String cost) {
        History newHistory = new History(description, new Date(), cost);
        history.add(newHistory);
    }

    public void setAllHistory(ArrayList<Object> newValue) {
        history = newValue;
    }

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
