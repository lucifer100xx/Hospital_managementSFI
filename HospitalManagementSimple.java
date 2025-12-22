import java.util.*;

public class HospitalManagementSimple {
    private static final List<Patient> patients = new ArrayList<>();
    private static final List<Doctor> doctors = new ArrayList<>();
    private static final List<Appointment> appointments = new ArrayList<>();
    private static final List<Bill> bills = new ArrayList<>();
    private static int pSeq = 100;
    private static int dSeq = 200;
    private static int aSeq = 300;
    private static int bSeq = 400;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "1) Add Patient\n2) List Patients\n3) Add Doctor\n4) List Doctors\n5) Create Appointment\n6) List Appointments\n7) Create Bill\n8) List Bills\n9) Exit");
            System.out.print("Choose: ");
            String s = sc.nextLine();
            int c;
            try {
                c = Integer.parseInt(s.trim());
            } catch (Exception e) {
                c = -1;
            }
            if (c == 1)
                addPatient(sc);
            else if (c == 2)
                listPatients();
            else if (c == 3)
                addDoctor(sc);
            else if (c == 4)
                listDoctors();
            else if (c == 5)
                createAppointment(sc);
            else if (c == 6)
                listAppointments();
            else if (c == 7)
                createBill(sc);
            else if (c == 8)
                listBills();
            else if (c == 9) {
                System.out.println("Bye");
                break;
            } else
                System.out.println("Pick 1-9");
        }
    }

    private static void addPatient(Scanner sc) {
        String name = ask(sc, "Full Name: ");
        String phone = ask(sc, "Phone: ");
        int age = askInt(sc, "Age: ");
        String gender = ask(sc, "Gender: ");
        String nid = ask(sc, "NID: ");
        String address = ask(sc, "Address: ");
        String bloodGroup = ask(sc, "Blood Group: ");
        String notes = ask(sc, "Notes: ");
        String id = "P-" + (++pSeq);
        Patient p = new Patient(id, name, phone, age, gender, nid, address, bloodGroup, notes);
        patients.add(p);
        System.out.println(p);
    }

    private static void listPatients() {
        if (patients.isEmpty())
            System.out.println("No patients");
        else
            for (Patient p : patients)
                System.out.println(p);
    }

    private static void addDoctor(Scanner sc) {
        String name = ask(sc, "Doctor Name: ");
        String dept = ask(sc, "Department: ");
        String phone = ask(sc, "Phone: ");
        String availability = ask(sc, "Availability: ");
        String id = "D-" + (++dSeq);
        Doctor d = new Doctor(id, name, dept, phone, availability);
        doctors.add(d);
        System.out.println(d);
    }

    private static void listDoctors() {
        if (doctors.isEmpty())
            System.out.println("No doctors");
        else
            for (Doctor d : doctors)
                System.out.println(d);
    }

    private static void createAppointment(Scanner sc) {
        String patientId = ask(sc, "Patient ID: ");
        String doctorName = ask(sc, "Doctor: ");
        String date = ask(sc, "Date (YYYY-MM-DD): ");
        String time = ask(sc, "Time (HH:MM): ");
        String status = ask(sc, "Status: ");
        String id = "A-" + (++aSeq);
        Appointment a = new Appointment(id, patientId, doctorName, date, time, status);
        appointments.add(a);
        System.out.println(a);
    }

    private static void listAppointments() {
        if (appointments.isEmpty())
            System.out.println("No appointments");
        else
            for (Appointment a : appointments)
                System.out.println(a);
    }
