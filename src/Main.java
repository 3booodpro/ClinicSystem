import java.io.*;
import java.nio.Buffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


//        Patient omar = new Patient("Omar", 19, 'M', "+966501111111", "Madinah, Near UPM.", "Diabetes");
//        Doctor ahmed = new Doctor("Ahmad", 48, 'M', "General", new CustomArray());
//        CustomArray schedule = ahmed.getSchedule();
//
//        Appointment firstAppoint = new Appointment(new Date(2024, 5, 10), omar);
//        Appointment secondAppoint = new Appointment(new Date(2024, 5, 23), omar);


public class Main {
    public static void main(String[] args) {

        //TESTING FOR TEXT BASED UI
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        String docName;
        String patientName;

        boolean flag = true;
        boolean exit = false;

        try {
            System.out.println("Welcome to the Clinic Management System!");
            while (!exit) {
                System.out.println("\nMain Menu");
                System.out.println("1. Doctor login");
                System.out.println("2. Patient login");
                System.out.println("10. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                scanner = new Scanner(System.in);

                switch (choice) {
                    case 1:
                        doctorLogin(scanner);
                        break;
                    case 2:
                        patientLogin(scanner);
                        break;
                    case 10:
                        System.out.println("Exiting...");
                        exit = true;
                        break;
                    default:
                        System.out.println(Colors.RED + "Invalid choice. Please try again." + Colors.RESET);
                        break;
                }

            }
            scanner.close();
        } catch(InputMismatchException e){
            System.out.println(Colors.RED + "Please enter a valid option.");
        }
    }
            private static void doctorLogin(Scanner scanner) {
                // Add Doctor login logic here

                System.out.println(Colors.CYAN + "Doctor login selected" + Colors.RESET);
                Doctor doctor1 = new Doctor();

                System.out.println("Enter your name: ");
                doctor1.setName(scanner.nextLine());

                System.out.println("Enter your age: ");
                 doctor1.setAge(scanner.nextInt());
                int doctorAge = doctor1.getAge();
                while(doctorAge < 0 || doctorAge > 120){
                    System.out.println(Colors.RED + "Invalid input, Please try again." + Colors.RESET);
                    System.out.println("Enter your age: ");
                    doctorAge = scanner.nextInt();
                }

                System.out.println("Enter your gender (M for Male, F for Female): ");
                char doctor1Gender = scanner.next().charAt(0);
                while (doctor1Gender != 'M' && doctor1Gender != 'm' &&
                        doctor1Gender != 'F' && doctor1Gender != 'f') {
                    System.out.println("Invalid input, Please try again.");
                    System.out.println("Enter your gender (M for Male, F for Female): ");
                    scanner.nextLine(); // Consume the newline character
                    doctor1Gender = scanner.next().charAt(0);
                }





                System.out.println("Enter your Speciality: ");
                doctor1.setSpecialty(scanner.next());

                // WRITING FILES
                try {
                    BufferedWriter Writer = new BufferedWriter(new FileWriter("Doctorinfo.txt", true));

                    Writer.write("Doctor Information: " + doctor1 + " ");


                    Writer.close();
                }catch(IOException e){
                    e.printStackTrace();
                }


                // Main doctor menu
                boolean logout = false;
                while (!logout) {
                    System.out.println("Welcome Dr." + Colors.CYAN + doctor1.getName() + Colors.RESET);
                    System.out.println("\nDoctor Menu");
                    System.out.println("1. View appointments");
                    System.out.println("2. Add prescription");
                    System.out.println("3. View your Status");
                    System.out.println("10. Return to login page");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1:
                            System.out.println("Viewing appointments...");
                            // Add logic to view appointments
                            break;
                        case 2:
                            System.out.println("Adding prescription...");
                            // Add logic to add prescription
                            break;
                        case 3:
                            System.out.println("Reading Information...");
                           doctor1.showInformation();
                        case 10:
                            logout = true;
                            break;
                        default:
                            System.out.println(Colors.RED + "Invalid choice. Please try again." + Colors.RESET);
                    }
                }
            }

            private static void patientLogin(Scanner scanner) {

                // Add Patient login logic here
                System.out.println(Colors.YELLOW + "Patient login selected" + Colors.RESET);
                Patient patient1 = new Patient();

                System.out.println("Enter your name: ");
                patient1.setName(scanner.nextLine());

                System.out.println("Enter your age: ");
                patient1.setAge(scanner.nextInt());

                System.out.println("Enter your gender (M for Male, F for Female): ");
                patient1.setGender(scanner.next().charAt(0));
                System.out.println("Do you have any past diseases? (Answer with Yes or No): ");
                String answerSickness = scanner.next();
                scanner.nextLine(); // Consume the newline character
                if (answerSickness.equalsIgnoreCase("yes")) {
                    System.out.println("Please type the name of your past disease: ");
                    String pastDisease = scanner.nextLine();
                    patient1.setOldSickness(pastDisease);
                } else {
                    System.out.println("الحمدلله");
                }

                try {
                    BufferedWriter Writer = new BufferedWriter(new FileWriter("PatientInfo.txt", true));

                    Writer.write("\nPatient Information: " + patient1);

                    Writer.close();
                }catch(IOException e){
                    e.printStackTrace();
                }


                // Main patient menu
                boolean logout = false;
                while (!logout) {
                    char PatientGender = patient1.getGender();
                    String Honorific = "";
                    if(PatientGender == 'M' || PatientGender == 'm'){
                        Honorific = "Mr.";
                    }
                    else if(PatientGender == 'F' || PatientGender == 'f'){
                        Honorific = "Ms.";
                    }
                    System.out.println("Welcome " + Honorific + Colors.YELLOW +  patient1.getName() + Colors.RESET);
                    System.out.println("\nPatient Menu");
                    System.out.println("1. View appointments");
                    System.out.println("2. Book appointment");
                    System.out.println("3. Return to login page");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1:
                            System.out.println("Viewing appointments...");
                            // Add logic to view appointments
                            break;
                        case 2:
                            System.out.println("Booking appointment...");
                            // Prompt the user to enter a date
                            System.out.println("Enter a date (dd/MM/yyyy): ");
                            String userInput = scanner.nextLine();

                            // Create a SimpleDateFormat object with the desired date format
                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                            try {
                                Date inputDate = dateFormat.parse(userInput);

                                String formattedDate = dateFormat.format(inputDate);

                                // Print the formatted date
                                System.out.println("your date is " + formattedDate);
                            } catch (ParseException e) {

                                System.out.println("Invalid date format. Please enter date in dd/MM/yyyy format.");
                            }

                            scanner.close();
                            break;
                        case 3:
                            logout = true;
                            break;
                        default:
                            System.out.println(Colors.RED + "Invalid choice. Please try again.");
                    }
                }
            }
        }
