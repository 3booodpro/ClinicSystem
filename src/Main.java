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
        } catch (InputMismatchException e) {
            System.out.println(Colors.RED + "Please enter a valid option.");
        }
    }

    private static void doctorLogin(Scanner scanner) {
        // Add Doctor login logic here
        System.out.println(Colors.CYAN + "Doctor login selected" + Colors.RESET);
        Doctor doctor1;
        while (true) {
            doctor1 = new Doctor();
            System.out.print("Enter your ID: ");
            doctor1.setIdentifier(scanner.nextInt());

            if (Files.getDoctorByID(doctor1.getIdentifier()) == null) {
                boolean tryagain = false;
                while (true) {
                    System.out.println(Colors.GREEN + "ID not detected in database. Would you like to create a new account? " + Colors.RESET
                            + "\n1. Create new account  \n2. Try again");
                    System.out.print("Enter your choice: " + Colors.RESET);
                    int result = scanner.nextInt();
                    if (result == 2) {
                        tryagain = true;
                        break;
                    }
                    if (result != 1) {
                        System.out.println(Colors.RED + "Please enter a valid option.");
                        continue;
                    }
                    break;
                }
                if (tryagain) continue;

                System.out.println("Enter your name: ");
                scanner.nextLine();

                doctor1.setName(scanner.nextLine());

                System.out.println("Enter your age: ");
                doctor1.setAge(scanner.nextInt());
                int doctorAge = doctor1.getAge();
                while (doctorAge < 18 || doctorAge > 120) {
                    System.out.println(Colors.RED + "Invalid input, Please try again." + Colors.RESET);
                    System.out.println("Enter your age: ");
                    doctorAge = scanner.nextInt();
                    doctor1.setAge(doctorAge);

                }

                System.out.println("Enter your gender (M for Male, F for Female): ");
                char doctor1Gender = scanner.next().charAt(0);
                while (doctor1Gender != 'M' && doctor1Gender != 'm' &&
                        doctor1Gender != 'F' && doctor1Gender != 'f') {
                    System.out.println(Colors.RED + "Invalid input, Please try again." + Colors.RESET);
                    System.out.println("Enter your gender (M for Male, F for Female): ");
                    scanner.nextLine(); // Consume the newline character
                    doctor1Gender = scanner.next().charAt(0);
                }


                System.out.print("Enter your Speciality: ");
                scanner.nextLine();
                doctor1.setSpecialty(scanner.nextLine());


                Files.saveData(FileData.Doctors, doctor1);
                System.out.println(Colors.GREEN + "\nAccount successfully created. Your ID is: " + doctor1.getIdentifier() + Colors.RESET);
            } else doctor1 = Files.getDoctorByID(doctor1.getIdentifier());
            break;


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
                case 3: // follow same method to add more information.
                    System.out.println("Reading Information...");
                    System.out.println(Colors.BLUE +  "\n" + Files.getDoctorByID(doctor1.getIdentifier()));
                    System.out.println("{ Speciality: %s }".formatted(doctor1.getSpecialty()));
                    System.out.println("{ Schedule: %s }".formatted(doctor1.getSchedule()) + Colors.RESET + "\n");

                    break;
                case 10:
                    logout = true;
                    break;
                default:
                    System.out.println(Colors.RED + "Invalid choice. Please try again." + Colors.RESET);
            }
        }
    }

    private static void patientLogin(Scanner scanner) { //Patient login system

        // Add Patient login logic here
        System.out.println(Colors.YELLOW + "Patient login selected" + Colors.RESET);
        Patient patient1;
        while (true) {
            patient1 = new Patient();
            System.out.print("Enter your ID: ");
            patient1.setIdentifier(scanner.nextInt());

            if (Files.getPatientByID(patient1.getIdentifier()) == null) {
                boolean tryagain = false;
                while (true) {
                    System.out.println(Colors.GREEN + "ID not detected in database. Would you like to create a new account? " + Colors.RESET
                            + "\n1. Create new account  \n2. Try again");
                    System.out.print("Enter your choice: " + Colors.RESET);
                    int result = scanner.nextInt();
                    if (result == 2) {
                        tryagain = true;
                        break;          // if ID is not inside the "Patient.json" file,
                                        // it would ask the user to either try again or create a new account with the entered id.
                    }
                    if (result != 1) {
                        System.out.println(Colors.RED + "Please enter a valid option.");
                        continue;
                    }
                    break;
                }
                if (tryagain) continue;

                System.out.println("Enter your name: ");
                scanner.nextLine();
                patient1.setName(scanner.nextLine());


                System.out.println("Enter your age: ");
                patient1.setAge(scanner.nextInt());
                int patientAge = patient1.getAge();
                while (patientAge <= 0 || patientAge > 120) {
                    System.out.println(Colors.RED + "Invalid input, Please try again." + Colors.RESET);
                    System.out.println("Enter your age: ");
                    patientAge = scanner.nextInt();
                    patient1.setAge(patientAge);
                }

                System.out.println("Enter your gender (M for Male, F for Female): ");
                char doctor1Gender = scanner.next().charAt(0);
                while (doctor1Gender != 'M' && doctor1Gender != 'm' &&
                        doctor1Gender != 'F' && doctor1Gender != 'f') {
                    System.out.println(Colors.RED + "Invalid input, Please try again." + Colors.RESET);
                    System.out.println("Enter your gender (M for Male, F for Female): ");
                    scanner.nextLine(); // Consume the newline character
                    doctor1Gender = scanner.next().charAt(0);
                }

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

                Files.saveData(FileData.Patients, patient1);
            } else patient1 = Files.getPatientByID(patient1.getIdentifier());
            break;
        }

        // Main patient menu
        boolean logout = false;
        while (!logout) {
            char PatientGender = patient1.getGender();
            String Honorific = "";
            if (PatientGender == 'M' || PatientGender == 'm') {
                Honorific = "Mr.";
            } else if (PatientGender == 'F' || PatientGender == 'f') {
                Honorific = "Ms.";
            }
            System.out.println("Welcome " + Honorific + Colors.YELLOW + patient1.getName() + Colors.RESET);
            System.out.println("\nPatient Menu");
            System.out.println("1. View appointments");
            System.out.println("2. Book appointment");
            System.out.println("3. Add more information");
            System.out.println("4. View your Status");
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
                    System.out.println("Booking appointment...");
                    // Add logic to book appointment
                    break;
                case 3:
                    try {
                        System.out.println("Please enter/change your phone number: ");
                        patient1.setContactDetails(scanner.nextInt());
                    }catch(InputMismatchException e){
                        System.out.println(Colors.RED + "Please enter a valid phone number." + Colors.RESET);
                    }
                    try{
                        System.out.print("Please enter/modify your Address Info (City or Neighborhood): ");
                        patient1.setInfoAddress(scanner.next());
                    }catch(Exception e){
                        System.out.println("Please enter a valid location.");
                    }
                    Files.saveData(FileData.Patients, patient1);
                    break;
                case 4:
                    System.out.println(Colors.MAGENTA + Files.getPatientByID(patient1.getIdentifier()) + Colors.RESET);
           //   THE OTHER INFO NEED TO BE ADDED (CONTACT INFO AND ADDRESS...)

                    break;
                case 10:
                    logout = true;
                    break;
                default:
                    System.out.println(Colors.RED + "Invalid choice. Please try again.");
            }
        }
    }


}
