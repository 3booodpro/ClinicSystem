import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Timer;

public class Patient extends Person {
    private CustomArray history;
    private int contactDetails;
    private String infoAddress;
    private String oldSickness; // Whether the patient has an old sickness, i think this is the way to do it ?



    public String getOldSickness() {
        return oldSickness;
    }

    public void setOldSickness(String oldSickness) {
        this.oldSickness = oldSickness;
    }
    public Patient() {
        // Call the parameterized constructor with default values
        this("Default Name", 0, 'M', 0, "Medina", "No old disease");
    }

    public Patient(String name, int age, char gender, int contactDetails, String infoAddress, String oldSickness) {
        super(name, age, gender);
        this.contactDetails = contactDetails;
        this.infoAddress = infoAddress;
        this.oldSickness = oldSickness;
        this.history = new CustomArray();
        this.history.addElement(new History("Created account", new Date(), "20$"));
    }

    public void addHistory(String description, String cost) {
        History newHistory = new History(description, new Date(), cost);
        history.addElement(newHistory);
    }

    public void setAllHistory(CustomArray newValue) {
        history = newValue;
    }

    public void removeHistory(int index) {
        history.removeElement(index);
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
        StringBuilder historyString = new StringBuilder();
        for (int i = 0; i < history.getSize(); i++) {
            historyString.append(history.getElement(i));
            if (i < history.getSize() - 1) {
                historyString.append(", ");
            }
        }
        return "\nPatient {" +
                "Name: " + getName() + ", Age: " + getAge() + ", Gender: " + getGender() + "}" +
                ",\nhistory: [" + historyString + "],\n Contact Details: " + getContactDetails() +
                ", Info Address: " + getInfoAddress() + ", Old Sickness: " + getOldSickness() +
                '}' + "\n";
    }




}
