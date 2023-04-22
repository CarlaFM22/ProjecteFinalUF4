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
        habitacioasignada =-1;
    }

    public Treballador(int p_infermer, int p_metge, int p_cirugia, int p_servei)
    {
        this.p_infermer = p_infermer;
        this.p_metge = p_metge;
        this.p_cirugia = p_cirugia;
        this.p_servei = p_servei;
        this.modificador = 0;
        habitacioasignada =-1;
    }

    public int getP_infermer() {
        return p_infermer;
    }

    public int getP_metge() {
        return p_metge;
    }

    public int getP_cirugia() {
        return p_cirugia;
    }

    public int getP_servei() {
        return p_servei;
    }

    public int getHabitacioasignada() {
        return habitacioasignada;
    }

    public void setHabitacioasignada(int habitacioasignada) {
        this.habitacioasignada = habitacioasignada;
    }

    public float getSou()
    {
        return souBase*modificador;
    }
    @Override
    public void Hablar() {   }

    @Override
    public String toString() {
        return "Treballador{" +
                "p_infermer=" + p_infermer +
                ", p_metge=" + p_metge +
                ", p_cirugia=" + p_cirugia +
                ", p_servei=" + p_servei +
                '}';
    }
}
