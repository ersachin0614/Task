import java.util.Date;

public class Appointment {
    private int id;
    private int patientId;
    private int doctorId;
    private Date date;
    private String reason;

    public Appointment(int id, int patientId, int doctorId, Date date, String reason) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.reason = reason;
    }

    public int getId() {
        return id;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public Date getDate() {
        return date;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return "Appointment [ID=" + id + ", PatientID=" + patientId + ", DoctorID=" + doctorId + ", Date=" + date + ", Reason=" + reason + "]";
    }
}
