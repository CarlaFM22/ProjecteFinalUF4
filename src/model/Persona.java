package model;

import java.time.LocalDate;

public abstract class Persona {
    private String nom;
    private String cognom1;
    private String cognom2;
    private String dni;
    private LocalDate dataNeixement;
    private String sexe;

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
