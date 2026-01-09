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
 private static void createBill(Scanner sc) {
        String patientId = ask(sc, "Patient ID: ");
        String service = ask(sc, "Service: ");
        int amount = askInt(sc, "Amount (BDT): ");
        String status = ask(sc, "Payment Status: ");
        String notes = ask(sc, "Notes: ");
        String id = "B-" + (++bSeq);
        Bill b = new Bill(id, patientId, service, amount, status, notes);
        bills.add(b);
        System.out.println(b);
    }

    private static void listBills() {
        if (bills.isEmpty())
            System.out.println("No bills");
        else
            for (Bill b : bills)
                System.out.println(b);
    }

    private static String ask(Scanner sc, String prompt) {
        System.out.print(prompt);
        String s = sc.nextLine().trim();
        return s.isEmpty() ? ask(sc, prompt) : s;
    }

    private static int askInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        String s = sc.nextLine().trim();
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return askInt(sc, prompt);
        }
    }

    static class Patient {
        final String id, name, phone, gender, nid, address, bloodGroup, notes;
        final int age;

        Patient(String id, String name, String phone, int age, String gender, String nid, String address,
                String bloodGroup, String notes) {
            this.id = id;
            this.name = name;
            this.phone = phone;
            this.age = age;
            this.gender = gender;
            this.nid = nid;
            this.address = address;
            this.bloodGroup = bloodGroup;
            this.notes = notes;
        }

        public String toString() {
            return id + " | " + name + " | " + phone + " | age:" + age + " | " + gender + " | NID:" + nid + " | "
                    + address + " | BG:" + bloodGroup + (notes.isEmpty() ? "" : " | " + notes);
        }
    }

    static class Doctor {
        final String id, name, department, phone, availability;

        Doctor(String id, String name, String department, String phone, String availability) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.phone = phone;
            this.availability = availability;
        }

        public String toString() {
            return id + " | " + name + " — " + department + " — " + availability + " | " + phone;
        }
    }

    static class Appointment {
        final String id, patientId, doctor, date, time, status;

        Appointment(String id, String patientId, String doctor, String date, String time, String status) {
            this.id = id;
            this.patientId = patientId;
            this.doctor = doctor;
            this.date = date;
            this.time = time;
            this.status = status;
        }

        public String toString() {
            return id + " | " + patientId + " ->  " + doctor + " | " + date + "  " + time + " | " + status;
        }
    }

    static class Bill {
        final String id, patientId, service, status, notes;
        final int amount;

        Bill(String id, String patientId, String service, int amount, String status, String notes) {
            this.id = id;
            this.patientId = patientId;
            this.service = service;
            this.amount = amount;
            this.status = status;
            this.notes = notes;
        }

        public String toString() {
            return id + "  |  " + patientId + "  |  " + service + "  | bdt " + amount + "  |  " + tatus
                    + (notes.isEmpty() ? " " :  "  |  "  + notes);
        }
    }
}


