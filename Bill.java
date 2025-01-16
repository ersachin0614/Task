import java.util.Date;

public class Bill {
    private int id;
    private int patientId;
    private double amount;
    private Date dateIssued;

    public Bill(int id, int patientId, double amount, Date dateIssued) {
        this.id = id;
        this.patientId = patientId;
        this.amount = amount;
        this.dateIssued = dateIssued;
    }

    public int getId() {
        return id;
    }

    public int getPatientId() {
        return patientId;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDateIssued() {
        return dateIssued;
    }

    @Override
    public String toString() {
        return "Bill [ID=" + id + ", PatientID=" + patientId + ", Amount=" + amount + ", DateIssued=" + dateIssued + "]";
    }
}
