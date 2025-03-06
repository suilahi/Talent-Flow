package Candidature.Candidate.Model;

import authentification.Model.User;


public class CandidateModel extends User {

    private String cv ;

    public CandidateModel(String name, String email, String password, String role) {
        super(name, email, password, role);
    }

    public CandidateModel(String name, String email, String password, String role, String cv) {
        super(name, email, password, role );
        this.cv = cv;
    }


    public CandidateModel(String cv) {
        this.cv = cv;
    }

    public CandidateModel() {
    }



    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    @Override
    public String toString() {
        return "CandidateModel{" +
                "cv='" + cv + '\'' +
                '}';
    }
}


