package controllers;

import Utils.Utilities;
import model.Hospital;

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
            System.out.println("NUMERO DE PACIENTS "+ general.getMalalts().size()+"/"+general.getHabitacions());
            int opcio = Utilities.llegirInt("Escull una de les seüents opcions:\n\t1-Mirar pacients\n\t2-Gestionar treballadors\n\t3-Passar seguent horari\n\t4-Sortir\n",1,4);
            switch (opcio)
            {
                case 1:
                    //llista de pacients i el estat de la malatia
                    break;
                case 2:
                    //llista de treballadors i poder selecionar un per assignar una habitacio
                    break;
                case 3:
                    //pasar a seguent horari i generar malat nou
                case 4:
                    System.out.println("GRACIES PER JUGAR");
                    game = false;
            }
        }while (game);
    }
}