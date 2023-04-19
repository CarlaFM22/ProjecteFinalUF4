package model;

import java.time.LocalDate;

public class Infermera extends Treballador{
    public Infermera(String nom, String sexe, int p_infermer, int p_metge, int p_cirugia, int p_servei) {
        super(nom, sexe, p_infermer, p_metge, p_cirugia, p_servei, 0.5f);
    }

    @Override
    public void Hablar() {
        System.out.println("Encantat de coneixet");
    }
}
