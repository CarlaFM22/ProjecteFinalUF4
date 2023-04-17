package model;

import java.time.LocalDate;

public class Treballador extends Persona{
    protected int numSeguretatSocial;
    public static final float souBase = 900f;

    public Treballador(String nom, String cognom1, String cognom2, String dni, LocalDate dataNeixement, String sexe, int numSeguretatSocial) {
        super(nom, cognom1, cognom2, dni, dataNeixement, sexe);
        this.numSeguretatSocial = numSeguretatSocial;
    }
}
