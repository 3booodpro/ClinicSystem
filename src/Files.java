import com.google.gson.Gson;
import org.json.*;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Files {

    public static void saveData(FileData FileType, Object data) {
        try {
            String FiledData;
            try {
                StringBuilder content = new StringBuilder();
                java.nio.file.Files.readAllLines(Paths.get("" + FileType.name() + ".json")).forEach(line -> content.append(line).append("\n"));
                FiledData = content.toString();
            } catch (Exception e) {
                FiledData = "[]";
            }

            JSONArray obj = new JSONArray();
            boolean Overwritten = false;
            try {
                obj = new JSONArray(FiledData);
                for (int i = 0; i < obj.length(); i++) {
                    JSONObject jsonobj = obj.getJSONObject(i);
                    if (jsonobj.getInt("identifier") == ((identifier)data).getIdentifier()) {
                        obj.remove(i);
                        obj.put(new JSONObject(data));
                        Overwritten = true;
                    }
                }
            } catch (Exception e) {
            }

            if(!Overwritten){
                obj.put(new JSONObject(data));
            }

            FileWriter writer = new FileWriter("" + FileType.name() + ".json");
            obj.write(writer);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Patient getPatientByID(int ID) {

        try {
            String FiledData;
            try {
                StringBuilder content = new StringBuilder();
                java.nio.file.Files.readAllLines(Paths.get(FileData.Patients+ ".json")).forEach(line -> content.append(line).append("\n"));
                FiledData = content.toString();
            } catch (Exception e) {
                FiledData = "[]";
            }

            try {
                JSONArray jsonarr = new JSONArray(FiledData);
                for (int i = 0; i < jsonarr.length(); i++) {
                    JSONObject jsonobj = jsonarr.getJSONObject(i);
                    if (jsonobj.getInt("identifier") == ID) {
                        return new Gson().fromJson(jsonobj.toString(), Patient.class);
                    }
                }
            } catch (Exception e) {
                // e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Doctor getDoctorByID(int ID) {
        try {
            String FiledData;
            try {
                StringBuilder content = new StringBuilder();
                java.nio.file.Files.readAllLines(Paths.get(FileData.Doctors + ".json")).forEach(line -> content.append(line).append("\n"));
                FiledData = content.toString();
            } catch (Exception e) {
                FiledData = "[]";
            }
            try {
                JSONArray jsonarr = new JSONArray(FiledData);
                for (int i = 0; i < jsonarr.length(); i++) {
                    JSONObject jsonobj = jsonarr.getJSONObject(i);
                    if (jsonobj.getInt("identifier") == ID) {
                        return new Gson().fromJson(jsonobj.toString(), Doctor.class);
                    }
                }
            } catch (Exception e) {
                // e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public static List<Appointment> getAppointmentsByPatientID(int PatientID) {
        try {
            String FiledData;
            try {
                StringBuilder content = new StringBuilder();
                java.nio.file.Files.readAllLines(Paths.get(FileData.Appointments + ".json")).forEach(line -> content.append(line).append("\n"));
                FiledData = content.toString();
            } catch (Exception e) {
             FiledData = "[]";
            }

            try {
                ArrayList<Appointment> SavedAppointments = new ArrayList<Appointment>();
                JSONArray jsonarr = new JSONArray(FiledData);
                for (int i = 0; i < jsonarr.length(); i++) {
                    JSONObject jsonobj = jsonarr.getJSONObject(i);
                    if (jsonobj.getInt("patientID") == PatientID) {
                        SavedAppointments.add(new Gson().fromJson(jsonobj.toString(), Appointment.class));
                    }
                }
                if(SavedAppointments.isEmpty()){
                    return null;
                }
                return SavedAppointments;
            } catch (Exception e) {
                // e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public static List<Appointment> getAppointmentsByDoctorID(int DoctorID) {
        try {
            String FiledData;
            try {
                StringBuilder content = new StringBuilder();
                java.nio.file.Files.readAllLines(Paths.get(FileData.Appointments + ".json")).forEach(line -> content.append(line).append("\n"));
                FiledData = content.toString();
            } catch (Exception e) {
                FiledData = "[]";
            }
            try {
                ArrayList<Appointment> SavedAppointments = new ArrayList<Appointment>();
                JSONArray jsonarr = new JSONArray(FiledData);
                for (int i = 0; i < jsonarr.length(); i++) {
                    JSONObject jsonobj = jsonarr.getJSONObject(i);
                    if (jsonobj.getInt("doctorID") == DoctorID) {
                        SavedAppointments.add(new Gson().fromJson(jsonobj.toString(), Appointment.class));
                    }
                }
                if(SavedAppointments.isEmpty()){
                    return null;
                }
                return SavedAppointments;
            } catch (Exception e) {
                //e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public static Appointment getAppointmentByID(int ID) {

        try {
            String FiledData;
            try {
                StringBuilder content = new StringBuilder();
                java.nio.file.Files.readAllLines(Paths.get(FileData.Appointments + ".json")).forEach(line -> content.append(line).append("\n"));
                FiledData = content.toString();
            } catch (Exception e) {
                FiledData = "[]";
            }
            try {
                JSONArray jsonarr = new JSONArray(FiledData);
                for (int i = 0; i < jsonarr.length(); i++) {
                    JSONObject jsonobj = jsonarr.getJSONObject(i);
                    if (jsonobj.getInt("identifier") == ID) {
                        return new Gson().fromJson(jsonobj.toString(), Appointment.class);
                    }
                }
            } catch (Exception e) {
                // e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }





}









