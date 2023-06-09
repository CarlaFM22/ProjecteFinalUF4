package controllers;

import Utils.Utilities;
import model.*;

public class Main {
    public static void main(String[] args) {
        boolean game = true;
        int dies=3;
        Hospital general = new Hospital();
        int estado = 1;
        System.out.println("TUTORIAL!!!!" +
                "\nMira el teus pacients i despres assigna el treballador corresponent\n" +
                "si esta en estat GREU assigna un personatge amb cirugia alt\n" +
                "si esta MITJ assigna un amb metge alt\n" +
                "si esta LLEU assigna un amb infermer alt\n" +
                "PER CURAR O REDUIR DE NIVELL LA ENFERMETAT\n" +
                "SI LES HABITACIONS ESTAN BRUTES ELS MALALTS PODEN ACABAR TROBANT-SE PITJOR" +
                "Per evitar això, assigna treballadors de serveis per netejar" +
                "SI UN TREBALLADOR JA ESTA ASSIGNAT A UNA HABITACIÓ NO LI POTS ASSIGNAR UNA ALTRE PER AQUELL TORN" +
                "CADA 3 DIES (9 cambis d'horari) HAS DE PAGAR ELS TEUS TREBALLADORS SI ESTAS AMB DINERS NEGATIUS ABANS DE PAGAR, PERDS\n");
        System.out.println("Benvingut al hospital general, jugador!");
        do {
            switch (estado) {
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

            if (dies==3) {
                System.out.println("ES DIA DE PAGA, TINDRAS QUE PAGAR: "+general.aPagar()+" AL FINAL DEL DIA");
            }

            int opcio = Utilities.llegirInt("Escull una de les seüents opcions:\n\t1-Mirar pacients\n\t2-Gestionar treballadors\n\t3-Gestionar Hospital\n\t4-Passar següent horari\n\t5-Sortir\n",1,5);
            switch (opcio) {
                case 1:
                    do {
                        general.llistaHabitacions();
                        opcio=Utilities.llegirInt("Selecciona la habitació que vols visitar. 0-"+(general.getHabitacions().size()-1)+ " o "+general.getHabitacions().size() + " per sortir\n",0,general.getHabitacions().size());
                        if (opcio!= general.getHabitacions().size()) {
                            if(general.getHabitacions().get(opcio).getResident()==null) {
                                System.out.println("LA HABITACIÓ ESTA VUIDA");
                            } else {
                                general.getHabitacions().get(opcio).getResident().Hablar();
                                System.out.println(general.getHabitacions().get(opcio).getResident().toString());
                            }
                        }
                    }while (opcio!=general.getHabitacions().size());
                    break;
                case 2:
                    do {
                        //llista de treballadors
                        general.llistaTreballadors();
                        //menu per selecionar un dels treballadors
                        opcio = Utilities.llegirInt("Selecciona el treballador que vols gestionar. 0-"+(general.getTreballadors().size()-1)+ " o "+general.getTreballadors().size()+" Per anar enrera \n",0,general.getTreballadors().size());
                        if (opcio!=general.getTreballadors().size()) {
                            int treballadorN = opcio;

                            System.out.println(general.getTreballadors().get(opcio).toString());
                            general.getTreballadors().get(opcio).Hablar();
                            opcio = Utilities.llegirInt("Vols enviare el treballadaor a una habitacio SI(1) o NO(2)",1,2);

                            if (opcio==1) {
                                do {
                                    //menu per poder enviar un treballador a una habitacio
                                    general.llistaHabitacions();
                                    opcio= Utilities.llegirInt("Selecciona la habitacio on vols enviar el treballador. 0-"+(general.getHabitacions().size()-1)+". o "+general.getHabitacions().size()+" per sortir",0,general.getHabitacions().size());

                                    if (opcio!=general.getHabitacions().size()) {
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
                    opcio = Utilities.llegirInt("SELECIONA UNA DE LES OPCIONS\n\t1-COMPRAR HABITACIO\n\t2-CONTRACTAR NOU METGE\n\t3-TORNAR ENRERA\n\t ",1,3);
                    switch (opcio) {
                        case 1:
                            opcio = Utilities.llegirInt("Vols comprar una nova habitacio per "+ general.getPreuHabitacio() +"? SI(1) NO(2)\n\t",1,2);
                            if (opcio==1) {
                                   general.setDiners(-general.getPreuHabitacio());
                                   general.getHabitacions().add(new Habitacion());
                            }
                            break;
                        case 2:
                            if (general.getOportunitatReclut()==0) {
                                System.out.println("No pots reclutar mes avui");
                            } else {
                                general.Reclutar();
                            }
                            break;
                    }
                    break;
                case 4:
                    general.actualitzar();
                    estado++;

                    if (estado>3) {
                        estado=1;
                        if (dies==3) {
                            if (general.getDiners() <0) {
                                System.out.println("GAME OVER");
                                game=false;
                            }
                            general.setDiners(-general.aPagar());
                            dies=0;
                        }
                        dies++;
                        general.setOportunitatReclut(3);
                    }

                    if (general.habitacionsplenes() != general.getHabitacions().size()) {
                        general.creapacient();
                    }

                    general.setOportunitatReclut(3);
                    break;
                case 5:
                    System.out.println("GRACIES PER JUGAR");
                    game = false;
                    break;
            }
        }while (game);
    }
}