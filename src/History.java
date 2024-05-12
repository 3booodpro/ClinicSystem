import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Timer;
/*
 * Abdulwahab Najib Abdulrahman 4410443
 * Karam M. Ali Khirallah 4410366
 * Muayyad Mutea Alnouman 4410286
 * */


/*
This class was primarily created to address the issue we were facing with the 2D Array.
In the Patient class, we had a 2D Array with two data fields: "date" and "cost".
Instead of using a 2D array, we opted for a 1D array containing a class with different data fields.
*/

public class History {
    // Data fields for storing history information
    private String description; // Description of the history event
    private Date date; // Date of the history event
    private String cost; // Cost associated with the history event

    // Constructor to initialize history objects
    public History(String description, Date date, String cost) {
        this.description = description;
        this.date = date;
        this.cost = cost;
    }

    // Getter method for retrieving description
    public String getDescription() {
        return description;
    }

    // Setter method for updating description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter method for retrieving date
    public Date getDate() {
        return date;
    }

    // Setter method for updating date
    public void setDate(Date date) {
        this.date = date;
    }

    // Getter method for retrieving cost
    public String getCost() {
        return cost;
    }

    // Setter method for updating cost
    public void setCost(String cost) {
        this.cost = cost;
    }

    // Method to provide string representation of History object
    @Override
    public String toString() {
        return "History{" +
                "description='" + description + '\'' +
                ", date=" + date +
                ", cost='" + cost + '\'' +
                '}';
    }
}


/*
* Abdulwahab Najib Abdulrahman 4410443
* Karam M. Ali Khirallah 4410366
* Muayyad Mutea Alnouman 4410286
* */