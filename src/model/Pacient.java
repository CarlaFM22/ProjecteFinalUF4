package model;

import java.time.LocalDate;

public class Pacient extends Persona {
    private Malalties malaltia;
    private Sang tipusSang;
    private int recompensa;

    private final int recompinit = 20;
    private boolean esMajorEdat;

    public Pacient(String nom, String sexe, Malalties malaltia, Sang tipusSang, boolean esMajorEdat) {

        super(nom, sexe);
        this.malaltia = malaltia;
        this.tipusSang = tipusSang;
        switch (this.malaltia)
        {
            case Lleu -> this.recompensa=recompinit;
            case Mitj -> this.recompensa=recompinit*2;
            case Greu -> this.recompensa=recompinit*3;
        }
        this.esMajorEdat = esMajorEdat;
    }

    public int getRecompensa() {
        return recompensa;
    }

    public Malalties getMalaltia() {
        return malaltia;
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

    @Override
    public String toString() {
        return "Pacient{" +
                "malaltia=" + malaltia +
                ", tipusSang=" + tipusSang +
                ", recompensa=" + recompensa +
                ", esMajorEdat=" + esMajorEdat +
                ", nom='" + nom + '\'' +
                ", sexe='" + sexe + '\'' +
                '}';
    }
}
