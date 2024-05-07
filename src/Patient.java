import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Timer;

public class Patient extends Person {
    private CustomArray history;
    private String contactDetails;
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
        this("Default Name", 0, 'M', "", "", "No old disease");
    }


    public Patient(String name, int age, char gender, String contactDetails, String infoAddress, String oldSickness) {
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

    @Override
    public String toString() {
        StringBuilder historyString = new StringBuilder();
        for (int i = 0; i < history.getSize(); i++) {
            historyString.append(history.getElement(i));
            if (i < history.getSize() - 1) {
                historyString.append(", ");
            }
        }
        return "Patient{" +
                "Name: " + getName() + ", Age: " + getAge() + ", Gender: " + getGender() +
                ", history: [" + historyString + "], Contact Details: " + contactDetails +
                ", Info Address: " + infoAddress + ", Old Sickness: " + oldSickness +
                '}';
    }


    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getInfoAddress() {
        return infoAddress;
    }

    public void setInfoAddress(String infoAddress) {
        this.infoAddress = infoAddress;
    }








}
