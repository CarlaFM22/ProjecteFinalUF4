package model;

import java.time.LocalDate;

public class Pacient extends Persona {
    private Malalties malaltia;
    private String tipusSang;
    private int numHabitacio;
    private boolean esMajorEdat;

    public Pacient(String nom, String cognom1, String cognom2, String dni, LocalDate dataNeixement, String sexe, Malalties malaltia, String tipusSang, int numHabitacio, boolean esMajorEdat) {
        super(nom, cognom1, cognom2, dni, dataNeixement, sexe);
        this.malaltia = malaltia;
        this.tipusSang = tipusSang;
        this.numHabitacio = numHabitacio;
        this.esMajorEdat = esMajorEdat;
    }
}
