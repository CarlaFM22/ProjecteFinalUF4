package model;

import java.time.LocalDate;

public class Cirurgia extends Treballador{
    public Cirurgia(String nom, String cognom1, String cognom2, String dni, LocalDate dataNeixement, String sexe, int numSeguretatSocial) {
        super(nom, cognom1, cognom2, dni, dataNeixement, sexe, numSeguretatSocial);
    }
}
