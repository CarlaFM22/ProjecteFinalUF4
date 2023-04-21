package model;

import java.time.LocalDate;

public class Treballador extends Persona{

    public static final float souBase = 900f;

    protected int p_infermer;
    protected int p_metge;
    protected   int p_cirugia;
    protected int p_servei;

    protected int habitacioasignada;

    protected float modificador;

    public Treballador(String nom, String sexe, int p_infermer, int p_metge, int p_cirugia, int p_servei, float modificador) {
        super(nom, sexe);
        this.p_infermer = p_infermer;
        this.p_metge = p_metge;
        this.p_cirugia = p_cirugia;
        this.p_servei = p_servei;
        this.modificador = modificador;
        habitacioasignada =0;
    }

    public Treballador(int p_infermer, int p_metge, int p_cirugia, int p_servei)
    {
        this.p_infermer = p_infermer;
        this.p_metge = p_metge;
        this.p_cirugia = p_cirugia;
        this.p_servei = p_servei;
        this.modificador = 0;
        habitacioasignada =0;
    }


    public void setHabitacioasignada(int habitacioasignada) {
        this.habitacioasignada = habitacioasignada;
    }

    @Override
    public void Hablar() {

    }


}
