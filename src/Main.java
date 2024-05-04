import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        CustomArray myArray = new CustomArray();

        myArray.addElement(new Appointment(new Date(), new Patient("Khaled", 99, 'M', "+9606060", "Madinah")));
        myArray.addElement(new String("h2"));
        myArray.addElement(new String("h3"));


        System.out.println((Appointment) myArray.getElement(0).getDate());

    }
}