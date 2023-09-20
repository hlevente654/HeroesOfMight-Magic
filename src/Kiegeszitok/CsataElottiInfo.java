package Kiegeszitok;

import Egysegek.Hos;

/**
 * Itt íródnak ki a részvevőkről információk
 */
public class CsataElottiInfo {
    public static void infokKiirasa(Hos p1, Hos enemy){

        String heading1="Jatekos Stats:.";
        String heading2="Ellenfel Stats:.";
        System.out.printf( "%-25s %25s %n", heading1, heading2);
        //Stats
        String playerS;
        String enemyS;

        playerS = "-Tamadas: "+p1.getTamadas();
        enemyS = "-Tamadas: "+enemy.getTamadas();
        System.out.printf( "%-25s %25s %n", playerS, enemyS);

        playerS = "-Vedekezes: "+p1.getVedekezes();
        enemyS = "-Vedekezes: "+enemy.getVedekezes();
        System.out.printf( "%-25s %25s %n", playerS, enemyS);

        playerS = "-Varazsero: "+p1.getVarazsero();
        enemyS = "-Varazsero: "+enemy.getVarazsero();
        System.out.printf( "%-25s %25s %n", playerS, enemyS);

        playerS = "-Tudas: "+p1.getTudas();
        enemyS = "-Tudas: "+enemy.getTudas();
        System.out.printf( "%-25s %25s %n", playerS, enemyS);

        playerS = "-Moral: "+p1.getMoral();
        enemyS = "-Moral: "+enemy.getMoral();
        System.out.printf( "%-25s %25s %n", playerS, enemyS);

        playerS = "-Szerencse: "+p1.getSzerencse();
        enemyS = "-Szerencse: "+enemy.getSzerencse();
        System.out.printf( "%-25s %25s %n", playerS, enemyS);

         heading1="Jatekos varazslatok:.";
         heading2="Ellenfel varazslatok:.";
        System.out.printf( "%-25s %25s %n", heading1, heading2);
        //Magic
        int biger,pm= p1.getTanultVarazslatok().size(),nm = enemy.getTanultVarazslatok().size();
        if(p1.getTanultVarazslatok().size() > enemy.getTanultVarazslatok().size()){
            biger = p1.getTanultVarazslatok().size();
        }else{
            biger = enemy.getTanultVarazslatok().size();
        }
        for (int i=0;i<biger;i++){
            if(i > pm-1){
                playerS="";
            }else{
                playerS = ""+p1.getTanultVarazslatok().get(i).getNev();
            }
            if(i > nm-1){
                enemyS="";
            }else{
                enemyS = ""+enemy.getTanultVarazslatok().get(i).getNev();
            }
            System.out.printf( "%-25s %25s %n", playerS, enemyS);
        }
        //Egysegek
        heading1="Jatekos egysegei:.";
        heading2="Ellenfel egysegei:.";
        System.out.printf( "%-25s %25s %n", heading1, heading2);
        pm= p1.getUnit().size();
        nm = enemy.getUnit().size();
        if(p1.getUnit().size() > enemy.getUnit().size()){
            biger = p1.getUnit().size();
        }else{
            biger = enemy.getUnit().size();
        }
        for (int i=0;i<biger;i++){
            if(i > pm-1){
                playerS="";
            }else{
                playerS = ""+p1.getUnit().get(i).getEgyseg().getNev()+" "+p1.getUnit().get(i).getMenyiseg()+" db";
            }
            if(i > nm-1){
                enemyS="";
            }else{
                enemyS = ""+enemy.getUnit().get(i).getEgyseg().getNev()+" "+enemy.getUnit().get(i).getMenyiseg()+" db";
            }
            System.out.printf( "%-25s %25s %n", playerS, enemyS);
        }

         heading1="Jatekos aranya:.";
         heading2="Ellenfel aranya:.";
        System.out.printf( "%-25s %25s %n", heading1, heading2);

        playerS = "-g: "+p1.getJatekos().getArany();
        enemyS = "-g: "+enemy.getJatekos().getArany();
        System.out.printf( "%-25s %25s %n", playerS, enemyS);

    }
}
