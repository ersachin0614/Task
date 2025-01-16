public class Doctor {
    private int id;
    private String name;
    private String specialty;
    private String phone;
    private String email;

    public Doctor(int id, String name, String specialty, String phone, String email) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Doctor [ID=" + id + ", Name=" + name + ", Specialty=" + specialty + "]";
    }
}
