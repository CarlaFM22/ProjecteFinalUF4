package model;

import Utils.Utilities;

import java.util.ArrayList;

public class Hospital {
    private float diners;

    private int oportunitatReclut;

    private final int preuHabitacio = 100;
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

      this.oportunitatReclut=3;

      this.habitacions = new ArrayList<Habitacion>();
      for (int i=0;i<10;i++)
      {
          this.habitacions.add(new Habitacion());
      }
      creapacient();

    }

    private Treballador createTreballador()
    {
        Treballador rand= new Treballador((int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100));

        return rand;
    }
    public int getPreuHabitacio() {
        return preuHabitacio;
    }

    public int getOportunitatReclut() {
        return oportunitatReclut;
    }

    public void setOportunitatReclut(int oportunitatReclut) {
        this.oportunitatReclut = oportunitatReclut;
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

    public float aPagar()
    {
        float result =0;
        for (int i = 0; i<treballadors.size();i++)
        {
            result+= treballadors.get(i).getSou();
        }
        return result;
    }

    public void Reclutar()
    {
        System.out.println("Pots reclutar "+oportunitatReclut+"/3 Avui");
        int opcio = Utilities.llegirInt("Estars segur de que vols gastar una oprtunitat? SI(1) NO(2)",1,2);
        if (opcio==1)
        {
            oportunitatReclut--;

            Treballador t1 = createTreballador();
            Treballador t2 = createTreballador();
            Treballador t3 = createTreballador();

            System.out.println("1: "+t1.toString());
            System.out.println("2: "+t2.toString());
            System.out.println("3: "+t3.toString());
            opcio= Utilities.llegirInt("Selecciona el treballador que vols contractar (1-3) o apreta 4 per no contractar a ningu",1,4);
            switch (opcio)
            {
                case 1:
                    opcio=Utilities.llegirInt("Selecciona el carrec que li vols donar\n\t1-Cirugia\n\t2-Metge\n\t3-Infermer\n\t4-Serveis",1,4);
                    afegriArryaList(opcio,t1);
                    break;
                case 2:
                    opcio=Utilities.llegirInt("Selecciona el carrec que li vols donar\n\t1-Cirugia\n\t2-Metge\n\t3-Infermer\n\t4-Serveis",1,4);
                    afegriArryaList(opcio,t2);
                    break;
                case 3:
                    opcio=Utilities.llegirInt("Selecciona el carrec que li vols donar\n\t1-Cirugia\n\t2-Metge\n\t3-Infermer\n\t4-Serveis",1,4);
                    afegriArryaList(opcio,t3);
                    break;
            }




        }
    }

    private void afegriArryaList(int opcio,Treballador t)
    {
        String Nom = Utilities.llegirString("Insereix el nom que li vols posar al treballador");
        String Sexe = Utilities.llegirString("Insereix el sexe que li vols posar al treballador");
        switch (opcio)
        {
            case 1:
                treballadors.add(new Cirurgia(Nom,Sexe,t.p_infermer,t.p_metge,t.p_cirugia,t.p_servei));
                break;
            case 2:
                treballadors.add(new Metge(Nom,Sexe,t.p_infermer,t.p_metge,t.p_cirugia,t.p_servei));
                break;
            case 3:
                treballadors.add(new Infermera(Nom,Sexe,t.p_infermer,t.p_metge,t.p_cirugia,t.p_servei));
                break;
            case 4:
                treballadors.add(new Serveis(Nom,Sexe,t.p_infermer,t.p_metge,t.p_cirugia,t.p_servei));
                break;
        }
    }

    public void actualitzar()
    {
        for (int i =0; i<this.habitacions.size();i++)
        {
            //trobar si un treballador ha esta asignat aquesta habitacio
            int idTreballador = habitacioAsignada(i);
            //si en la habitacio tenim un pacient
            if (this.habitacions.get(i).getResident()!=null)
            {
                int p_aumentarenferm=0;
                int p_curar =0;
                //intenar curar si hi ha un treballador assignat a l'habitacio que no sigui server
                if (idTreballador!= this.habitacions.size() && false == this.treballadors.get(idTreballador) instanceof Serveis)
                {

                        switch (this.habitacions.get(i).getResident().getMalaltia()) {
                            case Lleu -> p_curar += this.treballadors.get(idTreballador).getP_infermer();
                            case Mitj -> p_curar += this.treballadors.get(idTreballador).getP_metge();
                            case Greu -> p_curar += this.treballadors.get(idTreballador).getP_cirugia();
                        }
                        if ((int) (Math.random() * 100) <= p_curar) {
                            switch (this.habitacions.get(i).getResident().getMalaltia()) {
                                case Lleu:
                                    System.out.println(this.habitacions.get(i).CURAT());
                                    diners += this.habitacions.get(i).getResident().getRecompensa();
                                    habitacions.get(i).setResident(null);
                                    break;
                                case Mitj:
                                    this.habitacions.get(i).getResident().setMalaltia(Malalties.Lleu);
                                    break;
                                case Greu:
                                    this.habitacions.get(i).getResident().setMalaltia(Malalties.Mitj);
                                    break;
                            }
                        }

                }
                //si no tenim doctor % d'empitjora la malatia
                else {
                    switch (habitacions.get(i).getEstat()) {
                        case NET -> p_aumentarenferm = 60;
                        case POLS -> p_aumentarenferm = 40;
                        case BRUT -> p_aumentarenferm = 50;
                    }
                    if ((int) (Math.random() * 100) > p_aumentarenferm) {
                        switch (habitacions.get(i).getResident().getMalaltia()) {
                            case Lleu:
                                habitacions.get(i).getResident().setMalaltia(Malalties.Mitj);
                                break;
                            case Mitj:
                                habitacions.get(i).getResident().setMalaltia(Malalties.Greu);
                                break;
                            case Greu:
                                System.out.println(habitacions.get(i).MORT());
                                diners -= habitacions.get(i).getResident().getRecompensa();
                                habitacions.get(i).setResident(null);
                                break;
                        }
                    }
                }

            }
            //Update habitacions
            int p_empitjora=0;
            if (idTreballador!= this.habitacions.size())
            {
                if (treballadors.get(idTreballador) instanceof Serveis)
                {
                    p_empitjora+=treballadors.get(i).getP_servei();
                }
                if ((int) (Math.random() * 100) <= p_empitjora)
                {
                    switch (habitacions.get(i).getEstat())
                    {
                        case POLS -> habitacions.get(i).setEstat(estatHabitacion.NET);
                        case BRUT -> habitacions.get(i).setEstat(estatHabitacion.POLS);
                    }
                }
            }
            else {
                switch (habitacions.get(i).getEstat())
                {
                    case POLS -> habitacions.get(i).setEstat(estatHabitacion.BRUT);
                    case NET -> habitacions.get(i).setEstat(estatHabitacion.POLS);
                }
            }

        }
    }
    private int habitacioAsignada(int nHabitacio)
    {
        for (int i =0; i< this.treballadors.size();i++)
        {
            if (this.treballadors.get(i).getHabitacioasignada()==nHabitacio)
            {
                return i;
            }
        }
        return this.habitacions.size();
    }
}
