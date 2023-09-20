package Main;

import Csata.Lepes;
import Kiegeszitok.CsataElottiInfo;
import CsataMezo.Kor;
import CsataMezo.Mezo;
import Enemy.EnemyHero;
import Kiegeszitok.Ellenorok;
import Player.Jatekos;
import Player.UnitStatSzamolo;
import Egysegek.Hos;


import java.io.IOException;
import java.util.*;

/**
 * A main ahonnan a program indul és ahol véget ér
 * Egyben a program gerinceként is üzemel
 */
public class Main {
    public static Scanner bekero = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        System.out.println("Valssz nehezseget: (Konnyu: e, kozepes: m, nehez: d)");


        String nehezseg;
        boolean joNehezseg = false;
        do {
             nehezseg = bekero.nextLine();
             if(nehezseg.equals("e") || nehezseg.equals("m") || nehezseg.equals("d")){
                 joNehezseg = true;
             }
             if (!joNehezseg){
                 System.out.println("Nincs ilyen nehézség, válassz újra");
             }
        }while (!joNehezseg);


        //Ellenfél
        Jatekos enemy;
        enemy = new Jatekos("m");
        EnemyHero enemyHero;
        enemyHero = new EnemyHero(enemy);

        //Player
        Jatekos p1 ;
        p1 = new Jatekos(nehezseg);
        Hos hos1;
        hos1= new Hos(p1);
        hos1.hosPontKiosztas();

        //Info kiiro
        CsataElottiInfo.infokKiirasa(hos1,enemyHero);
        //Egysegek elhelyezese
        Mezo palya = new Mezo();
        palya.frissitettPalya();
        //Egysegek palyan való elhelyezese
        palya.elhelyezes(palya,hos1.getUnit());
        //Ellenfel palyan való elhelyezesege
        palya.EnemyElhelyezes(enemyHero);
        //Stat korrigálás
        UnitStatSzamolo.vezerlo(hos1);
        UnitStatSzamolo.vezerlo(enemyHero);
        //Körökre osztás
        ArrayList<Kor> kor = new ArrayList<>();
        boolean vanGyoztes = false;
        int korSzam = 0;
        do {
            korSzam++;
            System.out.println("Uj kor: "+korSzam);
            Lepes.korBerendezes(hos1,enemyHero,kor,palya);
            hos1.setLephetEMegAHos(true);
            enemyHero.setLephetEMegAHos(true);
            for (Kor value : kor) {
                // ujra tudjon vissza tamadni
                value.getEgyseg().setVisszatamadhat(true);
                value.getEgyseg().setAllapotVoltMarNezve(false);
            }
            for(int i=0;i< kor.size();i++) {
                if(kor.get(i).getEgyseg().isJatekosEe()){
                    System.out.println("\nJelenlegi kör: "+korSzam);
                    System.out.println("Jelenlegi lépő: "+(i+1));
                    Lepes.korBerendezes(hos1,enemyHero,kor,palya);
                    Lepes.JatekosLep(palya, kor.get(i).getEgyseg(),kor, hos1, enemyHero);
                    if(Ellenorok.jatekosNyert(kor)){
                        vanGyoztes = true;
                        System.out.println("-----------------------------------------------------");
                        System.out.println("Gratulálok a győzelemhez!!!");
                        break;
                    }else if(Ellenorok.aiNyert(kor)){
                        vanGyoztes = true;
                        System.out.println("-----------------------------------------------------");
                        System.out.println("Tobbszerencsét legközelebb!!!");
                        break;
                    }else if(Ellenorok.dontetlenLett(kor)){
                        vanGyoztes = true;
                        System.out.println("-----------------------------------------------------");
                        System.out.println("Döntetlen!!!");
                        break;
                    }
                }
                else {
                    System.out.println("\nJelenlegi kör: "+korSzam);
                    System.out.println("Jelenlegi lépő: "+(i+1));
                    Lepes.korBerendezes(hos1,enemyHero,kor,palya);
                    Lepes.EllenfelLepes(palya, kor.get(i).getEgyseg(), kor, enemyHero, hos1);
                    if(Ellenorok.jatekosNyert(kor)){
                        vanGyoztes = true;
                        System.out.println("-----------------------------------------------------");
                        System.out.println("Gratulálok a győzelemhez!!!");
                        break;
                    }else if(Ellenorok.aiNyert(kor)){
                        vanGyoztes = true;
                        System.out.println("-----------------------------------------------------");
                        System.out.println("Tobbszerencsét legközelebb!!!");
                        break;
                    }else if(Ellenorok.dontetlenLett(kor)){
                        vanGyoztes = true;
                        System.out.println("-----------------------------------------------------");
                        System.out.println("Döntetlen!!!");
                        break;
                    }
                }
            }

        }while (!vanGyoztes);


        bekero.close();
    }
}
