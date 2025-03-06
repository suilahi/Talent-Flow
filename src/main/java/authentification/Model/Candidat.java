package authentification.Model;

public class Candidat extends User{
    private int id;
    private String name;
    private String phone;

    public Candidat(int id, String name, String email, String password, UserRole role) {
        super(id,name,email,password,role);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
