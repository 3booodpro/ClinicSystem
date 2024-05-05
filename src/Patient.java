import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Timer;

public class Patient extends Person {
    private String[][] history;
    private String contactDetails;
    private String infoAddress;

    private String oldSickness; // Whether the patient has an old sickness, i think this is the way to do it ?

    public String getOldSickness() {
        return oldSickness;
    }

    public void setOldSickness(String oldSickness) {
        this.oldSickness = oldSickness;
    }

    public String[] getHistory(int index) {
        return history[index];
    }

    public String[][] getAllHistory() {
        return history;
    }

    public String allHistoryToString() {
        String output = "{";
        for (int i = 0; i < history.length; i++) {
            output += "{";
            for (int j = 0; j < history[i].length; j++) {
                output += history[i][j];
                if (j < history[i].length - 1) {
                    output += ", ";
                }
            }
            output += "}";
            if (i < history.length - 1) {
                output += ", ";
            }
        }
        output += "}";

        return output;
    }

    @Override
    public String toString() {
        String historyString = allHistoryToString();

        return "Patient{" +
                "Name: %s, Age: %d, Gender: %s, ".formatted(super.getName(), super.getAge(), super.getGender()) +
                "history: " + historyString + " }";
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

    public void addHistory(String history, int money) {
        int new_size = this.history.length + 1;
        String[][] new_history = new String[new_size][];
        for (int i = 0; i < new_size - 1; i++) {
            new_history[i] = this.history[i];
        }
        new_history[new_size - 1] = new String[]{history, new Date().toString(), Integer.toString(money) + "$"};
        this.history = new_history;
    }

    public void removeHistory(int index) {
        if (index < 0) {
            index = this.history.length + index;
        }

        int size = this.history.length;
        int last_new_index = 0;
        String[][] new_history = new String[size - 1][];
        for (int i = 0; i < size; i++) {
            if (i == index) {
                continue;
            }

            new_history[last_new_index] = this.history[i];
            last_new_index += 1;
        }
        this.history = new_history;
    }

    Patient() {
        super(); // default values for a patient object
        history = new String[][]{{"Created account", new Date().toString(), "20$"}};
        setContactDetails("+966501111111");
        setInfoAddress("Madinah, Near UPM.");
        setOldSickness("No old disease.");
    }

    Patient(String name, int age, char gender, String contactDetails, String infoAddress, String oldSickness) {
        super(name, age, gender);
        history = new String[][]{{"Created account", new Date().toString(), "20$"}};
        setContactDetails(contactDetails);
        setInfoAddress(infoAddress);
        setOldSickness(oldSickness);
    }


}
