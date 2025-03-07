package authentification.Model;

public class Recruteur extends User {
    private String company;

    public Recruteur(String name, String email, String password,String role ,String company) {
        super(name, email, password, role);
        this.company = company;
    }

    public String getCompany() {
        return company; }

    public void setCompany(String company) {
        this.company = company; }
}
