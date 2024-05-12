import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.print.Doc;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Abdulwahab Najib Abdulrahman 4410443
 * Karam M. Ali Khirallah 4410366
 * Muayyad Mutea Alnouman 4410286
 * */

public class Files {
    // this is the file management class, it utilizes json libraries in order to save & read data

    public static void main(String[] args) {
        Doctor d1 = new Doctor(); // This main method might be used for testing purposes (currently creates a Doctor object)
    }

    public static void addData(FileData FileType, Object data) {
        ObjectMapper mapper = new ObjectMapper();

        if (FileType == FileData.Doctors) {
            try {
                // Read existing doctor data from Doctors.json
                ArrayList<Doctor> old_data = mapper.readValue(new File("Doctors.json"), new TypeReference<ArrayList<Doctor>>() {
                });
                Doctor data_as_doctor = (Doctor) data; // Cast the provided data to a Doctor object

                // Check if a doctor with the same ID already exists
                boolean contain = false;
                for (int i = 0; i < old_data.size(); i++) {
                    if (old_data.get(i).getId() == data_as_doctor.getId()) {
                        contain = true;
                        break;
                    }
                }

                if (!contain) {
                    // Add new doctor data if the ID doesn't exist
                    old_data.add(data_as_doctor);
                    mapper.writeValue(new File("Doctors.json"), old_data); // Write updated data to Doctors.json
                } else {
                    // Update existing doctor data if the ID already exists
                    for (int i = 0; i < old_data.size(); i++) {
                        if (old_data.get(i).getId() == data_as_doctor.getId()) {
                            old_data.set(i, data_as_doctor);  // Replace existing doctor data with the new data
                            System.out.println("Doctor data updated!"); // Informative message
                            break;
                        }
                    }
                    mapper.writeValue(new File("Doctors.json"), old_data); // Write updated data to Doctors.json
                }
            } catch (IOException e) {
                System.out.println(e.getMessage()); // Catch and print any IO errors
            }

        } else if (FileType == FileData.Patients) {
            try {
                ArrayList<Patient> old_data = mapper.readValue(new File("Patients.json"), new TypeReference<ArrayList<Patient>>() {
                });
                Patient data_as_patient = (Patient) data;

                boolean contain = false;
                for (int i = 0; i < old_data.size(); i++) {
                    if (old_data.get(i).getId() == data_as_patient.getId()) {
                        contain = true;
                        break;
                    }
                }

                if (!contain) {
                    old_data.add((Patient) data);
                    mapper.writeValue(new File("Patients.json"), old_data);
                } else {
                    for (int i = 0; i < old_data.size(); i++) {
                        if (old_data.get(i).getId() == data_as_patient.getId()) {
                            old_data.set(i, data_as_patient);
                            break;
                        }
                    }
                    mapper.writeValue(new File("Patients.json"), old_data);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }

    }

    // Retrieves a doctor object from Doctors.json based on the provided ID
    public static Doctor getDoctorByID(int id) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<Doctor> stored_data = mapper.readValue(new File("Doctors.json"), new TypeReference<ArrayList<Doctor>>() {
            });
            for (int i = 0; i < stored_data.size(); i++) {
                if (stored_data.get(i).getId() == id) {
                    return stored_data.get(i);
                }
            }
        } catch (IOException e) {
        }

        return null;
    }

    // Retrieves a patient object from Patients.json based on the provided ID
    public static Patient getPatientByID(int id) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<Patient> stored_data = mapper.readValue(new File("Patients.json"), new TypeReference<ArrayList<Patient>>() {
            });
            for (int i = 0; i < stored_data.size(); i++) {
                if (stored_data.get(i).getId() == id) {
                    return stored_data.get(i);
                }
            }
        } catch (IOException e) {
        }
        return null;
    }

    // Retrieves a list of all doctors from Doctors.json
    public static ArrayList<Doctor> getDoctorsList() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Attempt to read doctor data from Doctors.json
            return mapper.readValue(new File("Doctors.json"), new TypeReference<ArrayList<Doctor>>() {
            });
        } catch (IOException e) {
            // Print any IO errors encountered
            System.out.println(e.getMessage());
        }

        // If there's an error or the file is empty, return an empty ArrayList
        return new ArrayList<Doctor>();
    }

    // Retrieves a list of all patients from Patients.json (similar logic to getDoctorsList)
    public static ArrayList<Patient> getPatientsList() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File("Patients.json"), new TypeReference<ArrayList<Patient>>() {
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<Patient>();
    }
}








