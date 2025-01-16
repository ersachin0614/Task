import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class HospitalManagementSystem {

    private static List<Patient> patients = new ArrayList<>();
    private static List<Doctor> doctors = new ArrayList<>();
    private static List<Appointment> appointments = new ArrayList<>();
    private static List<Bill> bills = new ArrayList<>();
    
    private static int patientCounter = 1;
    private static int doctorCounter = 1;
    private static int appointmentCounter = 1;
    private static int billCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nHospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. Generate Bill");
            System.out.println("5. View Patients");
            System.out.println("6. View Doctors");
            System.out.println("7. View Appointments");
            System.out.println("8. View Bills");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addPatient(scanner);
                    break;
                case 2:
                    addDoctor(scanner);
                    break;
                case 3:
                    scheduleAppointment(scanner);
                    break;
                case 4:
                    generateBill(scanner);
                    break;
                case 5:
                    viewPatients();
                    break;
                case 6:
                    viewDoctors();
                    break;
                case 7:
                    viewAppointments();
                    break;
                case 8:
                    viewBills();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 9);
    }

    private static void addPatient(Scanner scanner) {
        System.out.println("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter Date of Birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();
        System.out.println("Enter Phone Number: ");
        String phone = scanner.nextLine();
        System.out.println("Enter Email: ");
        String email = scanner.nextLine();

        Patient patient = new Patient(patientCounter++, firstName, lastName, new Date(), phone, email);
        patients.add(patient);
        System.out.println("Patient added: " + patient);
    }

    private static void addDoctor(Scanner scanner) {
        System.out.println("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Specialty: ");
        String specialty = scanner.nextLine();
        System.out.println("Enter Phone Number: ");
        String phone = scanner.nextLine();
        System.out.println("Enter Email: ");
        String email = scanner.nextLine();

        Doctor doctor = new Doctor(doctorCounter++, name, specialty, phone, email);
        doctors.add(doctor);
        System.out.println("Doctor added: " + doctor);
    }

    private static void scheduleAppointment(Scanner scanner) {
        System.out.println("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.println("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.println("Enter Appointment Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.println("Enter Reason for Appointment: ");
        String reason = scanner.nextLine();

        Appointment appointment = new Appointment(appointmentCounter++, patientId, doctorId, new Date(), reason);
        appointments.add(appointment);
        System.out.println("Appointment scheduled: " + appointment);
    }

    private static void generateBill(Scanner scanner) {
        System.out.println("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.println("Enter Bill Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline
        System.out.println("Enter Bill Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        Bill bill = new Bill(billCounter++, patientId, amount, new Date());
        bills.add(bill);
        System.out.println("Bill generated: " + bill);
    }

    private static void viewPatients() {
        System.out.println("\nList of Patients:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    private static void viewDoctors() {
        System.out.println("\nList of Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    private static void viewAppointments() {
        System.out.println("\nList of Appointments:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    private static void viewBills() {
        System.out.println("\nList of Bills:");
        for (Bill bill : bills) {
            System.out.println(bill);
        }
    }
}
