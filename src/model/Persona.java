package model;

import java.time.LocalDate;

public abstract class Persona {
    protected String nom;
    protected String cognom1;
    protected String cognom2;
    protected String dni;
    protected LocalDate dataNeixement;
    protected String sexe;

    public Persona(String nom, String cognom1, String cognom2, String dni, LocalDate dataNeixement, String sexe) {
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.dni = dni;
        this.dataNeixement = dataNeixement;
        this.sexe = sexe;
    }

    public static void parlar(String misstge) {
        System.out.println(misstge);
    }
}
