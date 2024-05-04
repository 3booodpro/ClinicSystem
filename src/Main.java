import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Patient omar = new Patient("Omar", 19, 'M', "+966501111111", "Madinah, Near UPM.");
        Doctor ahmed = new Doctor("Ahmad", 48, 'M', "General", new CustomArray());
        CustomArray schedule = ahmed.getSchedule();

        Appointment firstAppoint = new Appointment(new Date(2024, 5, 10), omar);
        Appointment secondAppoint = new Appointment(new Date(2024, 5, 23), omar);

        schedule.addElement(firstAppoint);
        schedule.addElement(secondAppoint);
        ahmed.setSchedule(schedule);
        System.out.println((ahmed.getSchedule().toString()));

    }
}