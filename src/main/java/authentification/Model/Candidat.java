package authentification.Model;

public class Candidat extends User{
    private int id;
    private String name;
    private String phone;
    private String Cv;

    public Candidat(int id, String name, String email, String password, String role) {
        super(name,email);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCv() {
        return Cv;
    }
    public void setCv(String Cv) {
        this.Cv = Cv;
    }

}
