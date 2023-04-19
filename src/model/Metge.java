package model;

import java.time.LocalDate;

public class Metge extends Treballador{

    public Metge(String nom, String sexe, int p_infermer, int p_metge, int p_cirugia, int p_servei) {
        super(nom, sexe, p_infermer, p_metge, p_cirugia, p_servei, 1);
    }

    @Override
    public void Hablar() {
        System.out.println("Estas una mica groc... pren aquesta pastilla");
    }
}
