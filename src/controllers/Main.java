package controllers;

import Utils.Utilities;
import model.Cirurgia;
import model.Hospital;
import model.Infermera;
import model.Metge;

public class Main {
    public static void main(String[] args) {
        boolean game = true;
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
            int opcio = Utilities.llegirInt("Escull una de les seüents opcions:\n\t1-Mirar pacients\n\t2-Gestionar treballadors\n\t3-Gestionar Hospital\n\t4-Passar seguent horari\n\t5-Sortir\n",1,5);
            switch (opcio)
            {
                case 1:
                    System.out.println("Nº | NOM | ESTAT HABITACIO");
                    //llista d'habitacions *exemple: Nºhabitacio | NomPacient ( si hi ha) | estat de la habitacio
                    for (int i = 0; i< general.getHabitacions().size();i++)
                    {
                        System.out.println(i + " | "+general.getHabitacions().get(i).toString());
                    }
                    break;
                    //Menu para ir a visitar un paciente, el paciente te habla y puedes ver los datos del pacient
                case 2:
                    //llista de treballadors
                    System.out.println("Nº | NOM | PROFESIO");
                    for (int i = 0; i < general.getTreballadors().size();i++)
                    {
                        if (general.getTreballadors().get(i) instanceof Cirurgia )
                        {
                            System.out.println(i+" | "+general.getTreballadors().get(i).getNom() + " | CIRUGIA");
                        } else if (general.getTreballadors().get(i) instanceof Metge) {
                            System.out.println(i+" | "+general.getTreballadors().get(i).getNom() + " | METGE/A");
                        } else if (general.getTreballadors().get(i) instanceof Infermera) {
                            System.out.println(i+" | "+general.getTreballadors().get(i).getNom() + " | INFERMER/A");
                        }
                        else {
                            System.out.println(i+" | "+general.getTreballadors().get(i).getNom() + " | SERVEI");
                        }

                    }

                    //menu per selecionar un dels treballadors


                    //menu per poder enviar un treballador a una habitacio

                    break;
                case 3:
                    //segon menu on podem elegir comprar mes habitacions o contractar nou metge

                    opcio = Utilities.llegirInt("SELECIONA UNA DE LES OPCIONS\n\t1-COMPRAR HABITACIO\n\t2-CONTRACTAR NOU METGE\n",1,2);
                    switch (opcio)
                    {
                        case 1:
                            //compra nova habitacio
                            break;
                        case 2:
                            //contractar nou metge, es crean 3 aleatoris i el jugarod seleciona 1 d'ells, que despres li donara una clase
                            break;
                    }
                    break;
                case 4:
                    //modificar els estats de els pacients i rebre recompenses

                    //si han pasat 3 dies pagar als treballadors

                    //modificar estat habitacions

                    //pasar a seguent horari i generar malat nou
                    estado++;
                    if (estado>3)
                    {
                        estado=1;
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