package model;

import Utils.Utilities;

import java.util.ArrayList;

public class Hospital {
    private float diners;
    private int habitacionsMAX;
    ArrayList<Treballador> treballadors;
    ArrayList<Pacient> malalts;

    public Hospital() {
      this.diners=5000;
      this.habitacionsMAX=10;
      Cirurgia c1 = new Cirurgia("Carla","Dona",25,50,75,0);
      Metge m1= new Metge("Ramon","Home",50,75,0,25);
      Infermera i1 = new Infermera("Hector","Home",75,25,50,0);
      Serveis s1 = new Serveis("Tupac","Home",0,0,0,75);

      treballadors.add(c1);
      treballadors.add(m1);
      treballadors.add(i1);
      treballadors.add(s1);

    }

    public Treballador createTreballador()
    {
        Treballador rand= new Treballador((int)Math.random()*100,(int)Math.random()*100,(int)Math.random()*100,(int)Math.random()*100);

        return rand;
    }

    public void creapacient()
    {

        int indice = (int)Math.random()* Pacient.nombres.length;
        String nom = Pacient.nombres[indice];
        String sexe="";
        if(((int)Math.random()*2)+1 == 1) {
            sexe = "Dona";
        }
        else
        {
            sexe="Home";
        }
        indice = ((int)Math.random()*Malalties.values().length);
        int indice2 = ((int)Math.random()*Sang.values().length);


        boolean done;
        int hab=0;
        do {
            done = true;
            hab =((int)Math.random()*habitacionsMAX)+1;
            for (int i = 0; i<malalts.size();i++)
            {
                if (malalts.get(i).getNumHabitacio()==hab)
                {
                    done = false;
                    break;
                }
            }
        }while (!done);
        int edat = (int) Math.random()*2;
        if (edat==0)
        {
            malalts.add(new Pacient(nom,sexe,Malalties.values()[indice],Sang.values()[indice2],hab,true));
        }
        else {
            malalts.add(new Pacient(nom,sexe,Malalties.values()[indice],Sang.values()[indice2],hab,false));
        }

    }

    public float getDiners() {
        return diners;
    }

    public void setDiners(float diners) {
        this.diners += diners;
    }

    public int getHabitacions() {
        return habitacionsMAX;
    }

    public void afegirHabitacions() {
        this.habitacionsMAX ++;
    }

    public ArrayList<Treballador> getTreballadors() {
        return treballadors;
    }

    public void afegirTreballadors(Treballador treballador) {
        this.treballadors.add(treballador);
    }

    public ArrayList<Pacient> getMalalts() {
        return malalts;
    }

    public void afegirMalalts(Pacient malalts) {
        this.malalts.add(malalts);
    }
}
