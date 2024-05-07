import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Timer;

public class History {
    private String description;
    private Date date;
    private String cost;
    public History(String description, Date date, String cost) {
        this.description = description;
        this.date = date;
        this.cost = cost;
    }
    // Getters and setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "History{" +
                "description='" + description + '\'' +
                ", date=" + date +
                ", cost='" + cost + '\'' +
                '}';
    }

}
