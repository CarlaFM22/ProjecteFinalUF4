package controllers;

import Utils.Utilities;
import model.*;

public class Main {
    public static void main(String[] args) {
        boolean game = true;
        int dies=3;
        Hospital general = new Hospital();
        int estado = 1;
        System.out.println("Benvingut al hospital general, jugador!");
        do {
            switch (estado)
            {
                case 1:
                    System.out.println("ES PER EL MATI");
                    break;
                case 2:
                    System.out.println("ES PER LA TARDA");
                    break;
                case 3:
                    System.out.println("ES PER LA NIT");
                    break;
            }
            System.out.println("NUMERO DE TRABALLADORS "+ general.getTreballadors().size());
            System.out.println("HABITACIONS PLENES "+ general.habitacionsplenes()+"/"+general.getHabitacions().size());
            System.out.println("DINERS "+general.getDiners());
            if (dies==3)
            {
                System.out.println("ES DIA DE PAGA, TINDRAS QUE PAGAR: "+general.aPagar()+" AL FINAL DEL DIA");
            }
            int opcio = Utilities.llegirInt("Escull una de les seüents opcions:\n\t1-Mirar pacients\n\t2-Gestionar treballadors\n\t3-Gestionar Hospital\n\t4-Passar seguent horari\n\t5-Sortir\n",1,5);
            switch (opcio)
            {
                case 1:
                    general.llistaHabitacions();
                    break;
                    //Menu para ir a visitar un paciente, el paciente te habla y puedes ver los datos del pacient
                case 2:
                    do {
                        //llista de treballadors
                        general.llistaTreballadors();
                        //menu per selecionar un dels treballadors
                        opcio = Utilities.llegirInt("Selecciona el treballador que vols gestionar. 0-"+(general.getTreballadors().size()-1)+ " o "+general.getTreballadors().size()+" Per anar enrera \n",0,general.getTreballadors().size());
                        if (opcio!=general.getTreballadors().size())
                        {
                            int treballadorN = opcio;

                            System.out.println(general.getTreballadors().get(opcio).toString());
                            general.getTreballadors().get(opcio).Hablar();
                            opcio = Utilities.llegirInt("Vols enviare el treballadaor a una habitacio SI(1) o NO(2)",1,2);

                            if (opcio==1)
                            {
                                do {
                                    //menu per poder enviar un treballador a una habitacio
                                    opcio= Utilities.llegirInt("Selecciona la habitacio on vols enviar el treballador. 0-"+(general.getHabitacions().size()-1)+". o "+general.getHabitacions().size()+" per sortir",0,general.getHabitacions().size());

                                    if (opcio!=general.getHabitacions().size())
                                    {
                                        general.getTreballadors().get(treballadorN).setHabitacioasignada(opcio);

                                        System.out.println("El treballador "+ general.getTreballadors().get(treballadorN).getNom()+" treballara en la habitacio "+opcio);
                                        opcio=general.getHabitacions().size();
                                    }
                                }while (opcio!= general.getHabitacions().size());
                            }
                        }


                    }while (opcio!=general.getTreballadors().size());
                    break;
                case 3:
                    //segon menu on podem elegir comprar mes habitacions o contractar nou metge

                    opcio = Utilities.llegirInt("SELECIONA UNA DE LES OPCIONS\n\t1-COMPRAR HABITACIO\n\t2-CONTRACTAR NOU METGE\n\t3-TORNAR ENRERA\n\t ",1,3);
                    switch (opcio)
                    {
                        case 1:
                            //compra nova habitacio
                            opcio = Utilities.llegirInt("Vols comprar una nova habitacio per "+ general.getPreuHabitacio() +"? SI(1) NO(2)\n\t",1,2);
                            if (opcio==1)
                            {
                                   general.setDiners(-general.getPreuHabitacio());
                                   general.getHabitacions().add(new Habitacion());
                            }
                            break;
                        case 2:
                            //contractar nou metge, es crean 3 aleatoris i el jugarod seleciona 1 d'ells, que despres li donara una clase

                            if (general.getOportunitatReclut()==0)
                            {
                                System.out.println("No pots reclutar mes avui");
                            }
                            else
                            {
                                general.Reclutar();
                            }
                            break;
                    }
                    break;
                case 4:
                    //modificar els estats de els pacients i rebre recompenses


                    //modificar estat habitacions

                    //pasar a seguent horari i generar malat nou
                    estado++;
                    if (estado>3)
                    {
                        estado=1;
                        if (dies==3)
                        {
                            if (general.getDiners() <0)
                            {
                                System.out.println("GAME OVER");
                                game=false;
                            }
                            general.setDiners(-general.aPagar());
                            dies=0;
                        }
                        dies++;
                        general.setOportunitatReclut(3);
                    }
                    if (general.habitacionsplenes() != general.getHabitacions().size())
                    {
                        general.creapacient();
                    }

                    break;
                case 5:
                    System.out.println("GRACIES PER JUGAR");
                    game = false;
                    break;
            }
        }while (game);
    }
}