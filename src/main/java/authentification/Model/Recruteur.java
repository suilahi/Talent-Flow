package authentification.Model;

public class Recruteur extends User {
    private String company;

    public Recruteur(String name, String email, String password, String company) {
        super(name, email, password, UserRole.RECRUITER);
        this.company = company;
    }

    // Getters and Setters
    public String getCompany() {
        return company; }

    public void setCompany(String company) {
        this.company = company; }
}
