import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Timer;

public class Patient extends Person {
    private History[] history;
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
        this("Default Name", 0, 'U', "", "", "No old disease");
    }


    public Patient(String name, int age, char gender, String contactDetails, String infoAddress, String oldSickness) {
        super(name, age, gender);
        this.contactDetails = contactDetails;
        this.infoAddress = infoAddress;
        this.oldSickness = oldSickness;
        this.history = new History[]{new History("Created account", new Date(), "20$")};
    }

    public void addHistory(String description, String cost) {
        History newHistory = new History(description, new Date(), cost);
        History[] newHistoryArray = new History[history.length + 1];
        System.arraycopy(history, 0, newHistoryArray, 0, history.length);
        newHistoryArray[history.length] = newHistory;
        history = newHistoryArray;
    }

    public void removeHistory(int index) {
        if (index >= 0 && index < history.length) {
            // Remove the History object at the specified index
            History[] newHistoryArray = new History[history.length - 1];
            System.arraycopy(history, 0, newHistoryArray, 0, index);
            System.arraycopy(history, index + 1, newHistoryArray, index, history.length - index - 1);
            history = newHistoryArray;
        }
    }

    @Override
    public String toString() {
        StringBuilder historyString = new StringBuilder();
        for (int i = 0; i < history.length; i++) {
            historyString.append(history[i]);
            if (i < history.length - 1) {
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
