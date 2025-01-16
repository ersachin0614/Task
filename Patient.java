import java.util.Date;

public class Patient {
    private int id;
    private String firstName;
    private String lastName;
    private Date dob;
    private String phone;
    private String email;

    public Patient(int id, String firstName, String lastName, Date dob, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Date getDob() {
        return dob;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Patient [ID=" + id + ", Name=" + getFullName() + ", DOB=" + dob + ", Phone=" + phone + "]";
    }
}
