import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.print.Doc;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Files {

    public static void main(String[] args) {
        Doctor d1 = new Doctor();
    }

    public static void addData(FileData FileType, Object data) {
        ObjectMapper mapper = new ObjectMapper();

        if (FileType == FileData.Doctors) {
            try {
                ArrayList<Doctor> old_data = mapper.readValue(new File("Doctors.json"), new TypeReference<ArrayList<Doctor>>() {});
                Doctor data_as_doctor = (Doctor) data;

                boolean contain = false;
                for (int i = 0; i < old_data.size(); i++) {
                    if (old_data.get(i).getId() == data_as_doctor.getId()) {
                        contain = true;
                        break;
                    }
                }

                if (!contain) {
                    old_data.add((Doctor) data);
                    mapper.writeValue(new File("Doctors.json"), old_data);
                } else {
                    for (int i = 0; i < old_data.size(); i++) {
                        if (old_data.get(i).getId() == data_as_doctor.getId()) {
                            old_data.set(i, data_as_doctor);
                            System.out.println(old_data);
                            break;
                        }
                    }
                    mapper.writeValue(new File("Doctors.json"), old_data);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } else if (FileType == FileData.Patients) {
            try {
                ArrayList<Patient> old_data = mapper.readValue(new File("Patients.json"), new TypeReference<ArrayList<Patient>>() {});
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

    public static Doctor getDoctorByID(int id) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<Doctor> stored_data = mapper.readValue(new File("Doctors.json"), new TypeReference<ArrayList<Doctor>>() {});
            for (int i = 0; i < stored_data.size(); i++) {
                if (stored_data.get(i).getId() == id) {
                    return stored_data.get(i);
                }
            }
        } catch (IOException e) {}

        return null;
    }

    public static Patient getPatientByID(int id) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<Patient> stored_data = mapper.readValue(new File("Patients.json"), new TypeReference<ArrayList<Patient>>() {});
            for (int i = 0; i < stored_data.size(); i++) {
                if (stored_data.get(i).getId() == id) {
                    return stored_data.get(i);
                }
            }
        } catch (IOException e) {}
        return null;
    }

    public static ArrayList<Doctor> getDoctorsList() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File("Doctors.json"), new TypeReference<ArrayList<Doctor>>(){});
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<Doctor>();
    }

    public static ArrayList<Patient> getPatientsList() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File("Patients.json"), new TypeReference<ArrayList<Patient>>(){});
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<Patient>();
    }

}









