package model;

import java.time.LocalDate;

public class Treballador extends Persona{

    public static final float souBase = 900f;

    protected int p_infermer;
    protected int p_metge;
    protected   int p_cirugia;
    protected int p_servei;


    protected float modificador;

    public Treballador(String nom, String sexe, int p_infermer, int p_metge, int p_cirugia, int p_servei, float modificador) {
        super(nom, sexe);
        this.p_infermer = p_infermer;
        this.p_metge = p_metge;
        this.p_cirugia = p_cirugia;
        this.p_servei = p_servei;
        this.modificador = modificador;

    }

    public Treballador(int p_infermer, int p_metge, int p_cirugia, int p_servei)
    {
        this.p_infermer = p_infermer;
        this.p_metge = p_metge;
        this.p_cirugia = p_cirugia;
        this.p_servei = p_servei;
        this.modificador = 0;
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

    @Override
    public void Hablar() {

    }
}
