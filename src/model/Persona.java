package model;

import java.time.LocalDate;
import java.util.Set;

public abstract class Persona implements InterificePerson {
    protected String nom;
    protected String sexe;

    public Persona(String nom, String sexe) {
        this.nom = nom;

        this.sexe = sexe;
    }
    public Persona()
    {

    }

    public String getNom() {
        return nom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
}
