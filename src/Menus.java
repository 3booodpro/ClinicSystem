import javax.print.Doc;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.*;

/*
This class was designed to display the menu options to the user and allow them to select their preferred service
. It encompasses all the functions related to the menu.
* */
public class Menus {
    public static void MainMenu() {

        Scanner scanner = new Scanner(System.in);


        // Declare variables to store doctor and patient names
        String docName;
        String patientName;

        // Initialize flags to control program flow
        boolean flag = true; // Flag to control loop inside method
        boolean exit = false; // Flag to control program termination

        try {

            System.out.println("Welcome to the Clinic Management System!");

            // Main menu loop
            while (!exit) {
                // Display main menu options
                System.out.println("\nMain Menu");
                System.out.println("1. Doctor login");
                System.out.println("2. Patient login");
                System.out.println("10. Exit");
                System.out.print("Enter your choice: ");

                // Read user choice
                int choice = scanner.nextInt();

                // Clear scanner buffer
                scanner = new Scanner(System.in);

                // Switch case for handling user choice
                switch (choice) {
                    case 1:
                        // Call method for doctor login
                        doctorLogin(scanner);
                        break;
                    case 2:
                        // Call method for patient login
                        patientLogin(scanner);
                        break;
                    case 10:
                        // Exit program
                        System.out.println("Exiting...");
                        exit = true;
                        break;
                    default:
                        // Display error message for invalid choice
                        System.out.println(Colors.RED + "Invalid choice. Please try again." + Colors.RESET);
                        break;
                }
            }
            // Close scanner after use
            scanner.close();
        } catch (InputMismatchException e) {
            // Exception handling for invalid input
            System.out.println(Colors.RED + "Please enter a valid option.");
        }
    }

    public static void doctorLogin(Scanner scanner) {
        // Display message indicating doctor login selection
        System.out.println(Colors.CYAN + "Doctor login selected" + Colors.RESET);
        // Create doctor object using user input
        Doctor doctor = doctorCreate(scanner);

        // Call method to display doctor menu
        doctorMenu(scanner, doctor);
    }


    public static Doctor doctorCreate(Scanner scanner) {
        // Initialize doctor object
        Doctor doctor;

        // Loop for doctor creation process
        while (true) {
            // Create a new doctor object
            doctor = new Doctor();

            // Prompt user to enter ID
            System.out.print("Enter your ID: ");
            doctor.setId(scanner.nextInt());

            // Check if the doctor ID exists in the database
            if (Files.getDoctorByID(doctor.getId()) == null) {
                boolean tryagain = false;
                while (true) {
                    // Prompt user for account creation or retry option
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

                // Prompt user to enter name
                System.out.println("Enter your name: ");
                scanner.nextLine(); // Consume newline character
                doctor.setName(scanner.nextLine());

                // Prompt user to enter age
                System.out.println("Enter your age: ");
                doctor.setAge(scanner.nextInt());
                int doctorAge = doctor.getAge();
                while (doctorAge < 18 || doctorAge > 120) {
                    // Validate age input
                    System.out.println(Colors.RED + "Invalid input, Please try again." + Colors.RESET);
                    System.out.println("Enter your age: ");
                    doctorAge = scanner.nextInt();
                    doctor.setAge(doctorAge);
                }

                // Prompt user to enter gender
                System.out.println("Enter your gender (M for Male, F for Female): ");
                char doctorGender = scanner.next().charAt(0);
                while (doctorGender != 'M' && doctorGender != 'm' &&
                        doctorGender != 'F' && doctorGender != 'f') {
                    // Validate gender input
                    System.out.println(Colors.RED + "Invalid input, Please try again." + Colors.RESET);
                    System.out.println("Enter your gender (M for Male, F for Female): ");
                    scanner.nextLine(); // Consume the newline character
                    doctorGender = scanner.next().charAt(0);
                }

                // Prompt user to enter specialty
                System.out.print("Enter your Speciality: ");
                scanner.nextLine(); // Consume newline character
                doctor.setSpecialty(scanner.nextLine());

                // Add doctor data to the database
                Files.addData(FileData.Doctors, doctor);
                // Display success message with doctor ID
                System.out.println(Colors.GREEN + "\nAccount successfully created. Your ID is: " + doctor.getId() + Colors.RESET);
            } else {
                // Retrieve doctor object from database if ID exists
                doctor = Files.getDoctorByID(doctor.getId());
            }
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

                    System.out.println(Files.getDoctorByID(doctor.getId()).getSchedule());

                    break;
                case 2:
                    System.out.println("Adding prescription...");
                    // Add logic to add prescription
                    break;
                case 3: // follow same method to add more information.
                    System.out.println("Reading Information...");
                    System.out.println(Colors.BLUE + "\n" + Files.getDoctorByID(doctor.getId()).toString() + Colors.RESET + "\n");
                    break;
                case 10:
                    logout = true;
                    break;
                default:
                    System.out.println(Colors.RED + "Invalid choice. Please try again." + Colors.RESET);
            }
        }
    }

    public static void patientLogin(Scanner scanner) {
        // Display message indicating patient login selection
        System.out.println(Colors.YELLOW + "Patient login selected" + Colors.RESET);
        // Create patient object using user input
        Patient patient = patientCreate(scanner);

        // Call method to display patient menu
        patientMenu(scanner, patient);
    }


    public static Patient patientCreate(Scanner scanner) {
        Patient patient;
        // Loop for patient creation process
        while (true) {
            // Create a new patient object
            patient = new Patient();
            // Prompt user to enter ID
            System.out.print("Enter your ID: ");
            patient.setId(scanner.nextInt());

            // Check if the patient ID exists in the database
            if (Files.getPatientByID(patient.getId()) == null) {
                boolean tryagain = false;
                while (true) {
                    // Prompt user for account creation or retry option
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

                // Prompt user to enter name
                System.out.println("Enter your name: ");
                scanner.nextLine(); // Consume newline character
                patient.setName(scanner.nextLine());

                // Prompt user to enter age
                System.out.println("Enter your age: ");
                patient.setAge(scanner.nextInt());
                int patientAge = patient.getAge();
                while (patientAge <= 0 || patientAge > 120) {
                    // Validate age input
                    System.out.println(Colors.RED + "Invalid input, Please try again." + Colors.RESET);
                    System.out.println("Enter your age: ");
                    patientAge = scanner.nextInt();
                    patient.setAge(patientAge);
                }

                // Prompt user to enter gender
                System.out.println("Enter your gender (M for Male, F for Female): ");
                char doctor1Gender = scanner.next().charAt(0);
                while (doctor1Gender != 'M' && doctor1Gender != 'm' &&
                        doctor1Gender != 'F' && doctor1Gender != 'f') {
                    // Validate gender input
                    System.out.println(Colors.RED + "Invalid input, Please try again." + Colors.RESET);
                    System.out.println("Enter your gender (M for Male, F for Female): ");
                    scanner.nextLine(); // Consume the newline character
                    doctor1Gender = scanner.next().charAt(0);
                }

                // Prompt user about past diseases
                System.out.println("Do you have any past diseases? (Answer with Yes or No): ");
                String answerSickness = scanner.next();

                scanner.nextLine(); // Consume the newline character
                if (answerSickness.equalsIgnoreCase("yes")) {
                    // If yes, prompt for the name of the past disease
                    System.out.println("Please type the name of your past disease: ");
                    String pastDisease = scanner.nextLine();
                    patient.setOldSickness(pastDisease);
                } else {
                    // If no, display a message
                    System.out.println("الحمدلله");
                }

                // Add patient data to the database
                Files.addData(FileData.Patients, patient);
            } else {
                // Retrieve patient object from database if ID exists
                patient = Files.getPatientByID(patient.getId());
            }
            break;
        }
        return patient;
    }


    public static void patientMenu(Scanner scanner, Patient patient) {
        boolean logout = false;
        // Loop for patient menu
        while (!logout) {
            // Determine honorific based on patient's gender
            char PatientGender = patient.getGender();
            String Honorific = "";
            if (PatientGender == 'M' || PatientGender == 'm') {
                Honorific = "Mr.";
            } else if (PatientGender == 'F' || PatientGender == 'f') {
                Honorific = "Ms.";
            }
            // Display welcome message with patient's name
            System.out.println("Welcome " + Honorific + Colors.YELLOW + patient.getName() + Colors.RESET);
            // Display patient menu options
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
                    // View appointments
                    System.out.println("Viewing appointments...");
                    System.out.println(Files.getPatientByID(patient.getId()).getSchedule());
                    break;
                case 2:
                    // Book appointment
                    if (Files.getDoctorsList().size() >= 1) {
                        // Display list of available doctors
                        for (int i = 0; i < Files.getDoctorsList().size(); i++) {
                            Doctor doctor = Files.getDoctorsList().get(i);
                            System.out.println(Colors.YELLOW + i + ") Dr." + doctor.getName() + "(" + doctor.getSpecialty() + ")");
                        }

                        // Prompt user to select a doctor or cancel
                        System.out.println(Colors.YELLOW + "-1) Cancel");
                        System.out.println("Enter your choice: ");
                        int doctor_choice = scanner.nextInt();

                        // Validate user input for doctor choice
                        if (doctor_choice < -1 || doctor_choice > Files.getDoctorsList().size() - 1) {
                            // Loop until valid input is provided
                            while (true) {
                                // Display error message for invalid input
                                System.out.println(Colors.RED + "Invalid input, Please try again." + Colors.RESET);
                                System.out.println(Colors.YELLOW + "Enter your choice: ");
                                // Prompt user to enter choice again
                                doctor_choice = scanner.nextInt();
                                // Check if the input is within the valid range of doctor choices
                                if (doctor_choice > 0 && doctor_choice < Files.getDoctorsList().size()) {
                                    break; // Exit loop if input is valid
                                }
                            }
                        }


                        // Handle cancel option
                        if (doctor_choice == -1) {
                            System.out.println(Colors.YELLOW + "Booking Canceled.." + Colors.RESET);
                            break;
                        }

                        // Retrieve selected doctor
                        Doctor doctor = Files.getDoctorsList().get(doctor_choice);

                        int year;
                        int month;
                        int day;

                        scanner.nextLine();
                        // Prompt user to enter appointment date
                        while (true) {
                            System.out.println(Colors.YELLOW + "Enter the date in yyyy-MM-dd format: ");
                            String dateInput = scanner.nextLine();

                            String dateFormat = "yyyy-MM-dd";
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);

                            try {
                                // Parse entered date
                                LocalDate date = LocalDate.parse(dateInput, formatter);

                                // Get current date
                                Date current_date = new Date();
                                current_date.setTime(0);
                                current_date.setSeconds(0);
                                current_date.setMinutes(0);
                                current_date.setHours(0);

                                // Convert entered date to Date object
                                Date entered_date = new SimpleDateFormat(dateFormat).parse(dateInput);
                                entered_date.setTime(0);
                                entered_date.setSeconds(0);
                                entered_date.setMinutes(0);
                                entered_date.setHours(0);

                                // Validate if entered date is in the past
                                if (current_date.compareTo(entered_date) > 0) {
                                    System.out.println(Colors.RED + "Invalid date, Please try again." + Colors.RESET);
                                    continue;
                                }

                                // Extract year, month, and day from entered date
                                year = date.getYear();
                                month = date.getMonth().getValue();
                                day = date.getDayOfMonth();

                                break;
                            } catch (Exception e) {
                                // Handle invalid date format
                                System.out.println(Colors.RED + "Invalid date, Please try again." + Colors.RESET);
                            }
                        }

                        // Create appointment object
                        Appointment appointment = new Appointment(year + "-" + month + "-" + day, patient.getName(), doctor.getName());

                        // Add appointment to patient's schedule
                        patient.getSchedule().add(appointment);
                        // Add appointment to patient's history
                        patient.addHistory("Booked an Appointment at " + year + "-" + month + "-" + day + ". With Dr." + doctor.getName(), "20$");
                        // Update patient data in database
                        Files.addData(FileData.Patients, patient);

                        // Add appointment to doctor's schedule
                        doctor.getSchedule().add(appointment);
                        // Update doctor data in database
                        Files.addData(FileData.Doctors, doctor);

                        // Display success message
                        System.out.println(Colors.GREEN + "Appointment booked successfully. at " + year + "-" + month + "-" + day + ". With Dr." + doctor.getName() + Colors.RESET);

                    } else {
                        // Display message if no doctors registered
                        System.out.println("No doctors registered");
                    }
                    break;
                case 3:
                    // Add more information
                    try {
                        // Prompt user to enter/change phone number
                        System.out.println("Please enter/change your phone number: ");
                        patient.setContactDetails(scanner.nextInt());
                    } catch (InputMismatchException e) {
                        // Handle invalid phone number input
                        System.out.println(Colors.RED + "Please enter a valid phone number." + Colors.RESET);
                    }
                    try {
                        // Prompt user to enter/modify address information
                        System.out.print("Please enter/modify your Address Info (City or Neighborhood): ");
                        patient.setInfoAddress(scanner.nextLine());
                        scanner.nextLine();
                    } catch (Exception e) {
                        // Handle invalid location input
                        System.out.println("Please enter a valid location.");
                    }
                    // Update patient data in database
                    Files.addData(FileData.Patients, patient);
                    break;
                case 4:
                    // View patient status
                    System.out.println(Colors.MAGENTA + Files.getPatientByID(patient.getId()) + Colors.RESET);
                    // Additional information (contact info and address) to be added...
                    break;
                case 10:
                    // Return to login page
                    logout = true;
                    break;
                default:
                    // Display error message for invalid choice
                    System.out.println(Colors.RED + "Invalid choice. Please try again.");
            }
        }
    }


}
