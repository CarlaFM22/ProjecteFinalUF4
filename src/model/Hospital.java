package model;

import Utils.Utilities;

import java.util.ArrayList;

public class Hospital {
    private float diners;

    ArrayList<Treballador> treballadors;
    ArrayList<Habitacion> habitacions;

    public Hospital() {
      this.diners=5000;

      Cirurgia c1 = new Cirurgia("Carla","Dona",25,50,75,0);
      Metge m1= new Metge("Ramon","Home",50,75,0,25);
      Infermera i1 = new Infermera("Hector","Home",75,25,50,0);
      Serveis s1 = new Serveis("Tupac","Home",0,0,0,75);
      this.treballadors = new ArrayList<Treballador>();
      treballadors.add(c1);
      treballadors.add(m1);
      treballadors.add(i1);
      treballadors.add(s1);

      this.habitacions = new ArrayList<Habitacion>();
      for (int i=0;i<10;i++)
      {
          this.habitacions.add(new Habitacion());
      }
      creapacient();

    }

    public Treballador createTreballador()
    {
        Treballador rand= new Treballador((int)Math.random()*100,(int)Math.random()*100,(int)Math.random()*100,(int)Math.random()*100);

        return rand;
    }

    public void creapacient()
    {

        int indice = (int)(Math.random()* Pacient.nombres.length);

        String nom = Pacient.nombres[indice];
        String sexe="";
        if(((int)(Math.random()*2)) == 1) {
            sexe = "Dona";
        }
        else
        {
            sexe="Home";
        }
        indice = ((int)(Math.random()*Malalties.values().length));
        int indice2 = ((int)(Math.random()*Sang.values().length));



        boolean done;
        int hab=0;
        do {
            done = true;
            hab =((int)(Math.random()*habitacions.size()));
            if(habitacions.get(hab).getResident()!=null)
            {
                done=false;
            }
        }while (!done);
        int edat = (int) (Math.random()*2);
        if (edat==0)
        {
            habitacions.get(hab).setResident(new Pacient(nom,sexe,Malalties.values()[indice],Sang.values()[indice2],true));
        }
        else {
            habitacions.get(hab).setResident(new Pacient(nom,sexe,Malalties.values()[indice],Sang.values()[indice2],false));
        }

    }

    public float getDiners() {
        return diners;
    }

    public void setDiners(float diners) {
        this.diners += diners;
    }

    public ArrayList<Habitacion> getHabitacions() {
        return habitacions;
    }

    public ArrayList<Treballador> getTreballadors() {
        return treballadors;
    }

    public void afegirTreballadors(Treballador treballador) {
        this.treballadors.add(treballador);
    }

    public void addHabitacions(ArrayList<Habitacion> habitacions) {
        Habitacion hab = new Habitacion();
        this.habitacions.add(hab);
    }

    public int habitacionsplenes ()
    {
        int result = 0;

        for (int i = 0; i < this.habitacions.size(); i++)
        {
            if (habitacions.get(i).getResident()!=null)
            {
                result++;
            }
        }
        return result;
    }

    public void llistaHabitacions()
    {
        System.out.println("Nº | NOM | ESTAT HABITACIO");
        //llista d'habitacions *exemple: Nºhabitacio | NomPacient ( si hi ha) | estat de la habitacio
        for (int i = 0; i< habitacions.size();i++)
        {
            System.out.println(i + " | "+habitacions.get(i).toString());
        }
    }

    public void llistaTreballadors()
    {
        System.out.println("Nº | NOM | PROFESIO");
        for (int i = 0; i < treballadors.size();i++)
        {
            if (treballadors.get(i) instanceof Cirurgia )
            {
                System.out.println(i+" | "+treballadors.get(i).getNom() + " | CIRUGIA");
            } else if (treballadors.get(i) instanceof Metge) {
                System.out.println(i+" | "+treballadors.get(i).getNom() + " | METGE/A");
            } else if (treballadors.get(i) instanceof Infermera) {
                System.out.println(i+" | "+treballadors.get(i).getNom() + " | INFERMER/A");
            }
            else {
                System.out.println(i+" | "+treballadors.get(i).getNom() + " | SERVEI");
            }

        }
    }



}
