import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Menus {
    public static void MainMenu() {
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
                        exit = true;
                        break;
                    case 2:
                        patientLogin(scanner);
                        exit = true;
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

    public static void doctorLogin(Scanner scanner) {
        // Add Doctor login logic here
        System.out.println(Colors.CYAN + "Doctor login selected" + Colors.RESET);
        Doctor doctor = doctorCreate(scanner);

        // Main doctor menu
        doctorMenu(scanner, doctor);
    }

    public static Doctor doctorCreate(Scanner scanner){
        
        Doctor doctor;
        while (true) {
            doctor = new Doctor();
            System.out.print("Enter your ID: ");
            doctor.setId(scanner.nextInt());

            if (Files.getDoctorByID(doctor.getId()) == null) {
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

                doctor.setName(scanner.nextLine());

                System.out.println("Enter your age: ");
                doctor.setAge(scanner.nextInt());
                int doctorAge = doctor.getAge();
                while (doctorAge < 18 || doctorAge > 120) {
                    System.out.println(Colors.RED + "Invalid input, Please try again." + Colors.RESET);
                    System.out.println("Enter your age: ");
                    doctorAge = scanner.nextInt();
                    doctor.setAge(doctorAge);
                }

                System.out.println("Enter your gender (M for Male, F for Female): ");
                char doctorGender = scanner.next().charAt(0);
                while (doctorGender != 'M' && doctorGender != 'm' &&
                        doctorGender != 'F' && doctorGender != 'f') {
                    System.out.println(Colors.RED + "Invalid input, Please try again." + Colors.RESET);
                    System.out.println("Enter your gender (M for Male, F for Female): ");
                    scanner.nextLine(); // Consume the newline character
                    doctorGender = scanner.next().charAt(0);
                }


                System.out.print("Enter your Speciality: ");
                scanner.nextLine();
                doctor.setSpecialty(scanner.nextLine());


                Files.addData(FileData.Doctors, doctor);
                System.out.println(Colors.GREEN + "\nAccount successfully created. Your ID is: " + doctor.getId() + Colors.RESET);
            } else doctor = Files.getDoctorByID(doctor.getId());
            break;

        }
        return doctor;
    }
    
    public static void doctorMenu(Scanner scanner, Doctor doctor) {
        boolean logout = false;
        while (!logout) {
            System.out.println("Welcome Dr." + Colors.CYAN + doctor.getName() + Colors.RESET);
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
                    System.out.println(Colors.BLUE +  "\n" + Files.getDoctorByID(doctor.getId()).toString() + Colors.RESET + "\n");
                    break;
                case 10:
                    logout = true;
                    break;
                default:
                    System.out.println(Colors.RED + "Invalid choice. Please try again." + Colors.RESET);
            }
        }
    }
    
    public static void patientLogin(Scanner scanner) { //Patient login system

        // Add Patient login logic here
        System.out.println(Colors.YELLOW + "Patient login selected" + Colors.RESET);
        Patient patient = patientCreate(scanner);

        // Main patient menu
        patientMenu(scanner, patient);
    }

    public static Patient patientCreate(Scanner scanner) {
        Patient patient;
        while (true) {
            patient = new Patient();
            System.out.print("Enter your ID: ");
            patient.setId(scanner.nextInt());

            if (Files.getPatientByID(patient.getId()) == null) {
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
                patient.setName(scanner.nextLine());


                System.out.println("Enter your age: ");
                patient.setAge(scanner.nextInt());
                int patientAge = patient.getAge();
                while (patientAge <= 0 || patientAge > 120) {
                    System.out.println(Colors.RED + "Invalid input, Please try again." + Colors.RESET);
                    System.out.println("Enter your age: ");
                    patientAge = scanner.nextInt();
                    patient.setAge(patientAge);
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
                    patient.setOldSickness(pastDisease);
                } else {
                    System.out.println("الحمدلله");
                }

                Files.addData(FileData.Patients, patient);
            } else patient = Files.getPatientByID(patient.getId());
            break;
        }
        return patient;
    }
    
    public static void patientMenu(Scanner scanner, Patient patient) {
        boolean logout = false;
        while (!logout) {
            char PatientGender = patient.getGender();
            String Honorific = "";
            if (PatientGender == 'M' || PatientGender == 'm') {
                Honorific = "Mr.";
            } else if (PatientGender == 'F' || PatientGender == 'f') {
                Honorific = "Ms.";
            }
            System.out.println("Welcome " + Honorific + Colors.YELLOW + patient.getName() + Colors.RESET);
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

                    break;
                case 2:
                    if( Files.getDoctorsList() != null){
                        for (Doctor dctr : Files.getDoctorsList()) {
                            System.out.println(Colors.GREEN + "Dr."+ dctr.getName() + " - " + dctr.getSpecialty() + Colors.RESET );
                        }
                    }else{
                        System.out.println("No doctors registered" );
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Please enter/change your phone number: ");
                        patient.setContactDetails(scanner.nextInt());
                    }catch(InputMismatchException e){
                        System.out.println(Colors.RED + "Please enter a valid phone number." + Colors.RESET);
                    }
                    try{
                        System.out.print("Please enter/modify your Address Info (City or Neighborhood): ");
                        patient.setInfoAddress(scanner.nextLine());
                        scanner.nextLine();

                    }catch(Exception e){
                        System.out.println("Please enter a valid location.");
                    }
                    Files.addData(FileData.Patients, patient);
                    break;
                case 4:
                    System.out.println(Colors.MAGENTA + Files.getPatientByID(patient.getId()) + Colors.RESET);
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
