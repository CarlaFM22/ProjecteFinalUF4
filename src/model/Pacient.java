package model;

import java.time.LocalDate;

public class Pacient extends Persona {
    private Malalties malaltia;
    private Sang tipusSang;
    private int numHabitacio;
    private boolean esMajorEdat;

    public Pacient(String nom, String sexe, Malalties malaltia, Sang tipusSang, int numHabitacio, boolean esMajorEdat) {

        super(nom, sexe);
        this.malaltia = malaltia;
        this.tipusSang = tipusSang;
        this.numHabitacio = numHabitacio;
        this.esMajorEdat = esMajorEdat;
    }

    public int getNumHabitacio() {
        return numHabitacio;
    }

    public Malalties getMalaltia() {
        return malaltia;
    }

    public Sang getTipusSang() {
        return tipusSang;
    }

    public boolean isEsMajorEdat() {
        return esMajorEdat;
    }

    public void setMalaltia(Malalties malaltia) {
        this.malaltia = malaltia;
    }


    @Override
    public void Hablar() {
        switch (malaltia)
        {
            case Lleu -> System.out.println("Buenos dias doctor");
            case Mitj -> System.out.println("Cogh cogh... que... tal doctor?");
            case Greu -> System.out.println("... *esta tan mal que no puede ni hablar*");
        }
    }
}
