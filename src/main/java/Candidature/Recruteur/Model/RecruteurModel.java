package Candidature.Recruteur.Model;

import authentification.Model.User;

public class RecruteurModel extends User {
    private String company; // Correspond à la colonne 'company' dans la table recruiters

    public RecruteurModel() {
        super();
    }

    public RecruteurModel(int id, String name, String email, String password, String company) {
        super(id, name, email, password, UserRole.RECRUITER);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "RecruteurModel{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
