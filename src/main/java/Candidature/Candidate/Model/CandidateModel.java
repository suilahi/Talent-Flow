package Candidature.Candidate.Model;

import authentification.Model.User;


public class CandidateModel extends User {


    private int id_condidature;
    private int job_id;
    private String phone;
    private String cv ;

    //constractures


    public CandidateModel(String name, String email, String password, String role, String phone, String cv) {
        super(name, email, password, role);
        this.phone = phone;
        this.cv = cv;
    }

    public CandidateModel(int id, String name, String email, String phone, String cv) {
        super(id, name, email);
        this.phone = phone;
        this.cv = cv;
    }

    public CandidateModel(String name, String email, String phone, String cv) {
        super(name, email);
        this.phone = phone;
        this.cv = cv;
    }

    public CandidateModel(int id, String name, String email) {
        super(id, name, email);
    }

    public CandidateModel(String name, String email) {
        super(name, email);
    }





    //setters et getters


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }
}


