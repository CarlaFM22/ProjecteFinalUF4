package model;

import java.time.LocalDate;

public class Cirurgia extends Treballador{
    public Cirurgia(String nom, String sexe, int p_infermer, int p_metge, int p_cirugia, int p_servei) {
        super(nom, sexe, p_infermer, p_metge, p_cirugia, p_servei, 1.5f);
    }

    @Override
    public void Hablar() {
        System.out.println("A operar");;
    }
}
