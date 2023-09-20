package Kiegeszitok;

import CsataMezo.Kor;
import CsataMezo.Mezo;
import Egysegek.Egyseg;
import Egysegek.Unit;
import Player.Jatekos;

import java.util.ArrayList;

/**
 * Az Ellenorok class szolgál egy gyüjtőként a programban lévő
 * ellenőrző metódusoknak amiket többször kell hívni.
 */
public class Ellenorok {
    /**
     * valyon egész számmá-e konvertálható a kapott String vagy nem?
     * @param str adott String ami vagy szám vagy nem
     * @return igaz ha egész szám, hamis ha nem
     */
    public static boolean isHoleNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    /**
     * adott kórdináta az egy létező kórdináta
     * vagy nem.
     * @param varazslasHelye adott kórdináta
     * @return true ha a kapott String egy létező kordináta, fals ha nem.
     */
    public static boolean vaneIlyenKordinata(String varazslasHelye) {
        String []tomb = varazslasHelye.split("-");
        if(tomb.length == 2){
            if( isHoleNumber(tomb[0]) && isHoleNumber(tomb[1])){
                //System.out.println("Nincs ilyen mezo");
                return Integer.parseInt(tomb[0]) >= 1 && Integer.parseInt(tomb[0]) <= 10 && Integer.parseInt(tomb[1]) >= 1 && Integer.parseInt(tomb[1]) <= 12;
            }else {
                //System.out.println("Rossz input");
                return false;
            }
        }else {
            //System.out.println("Rossz input");
            return false;
        }
    }

    /**
     * Van e a Kapott kórdinátán már egy nem játékos egység vagy nincs?
     * @param varazslasHelye a kapott kórdináta
     * @param egeszKor Az egységek listája
     * @return ha nincs akkor fals, ha van akkor true
     */
    public static boolean vaneOttAIEgyseg(String varazslasHelye, ArrayList<Kor> egeszKor) {
        String []tomb = varazslasHelye.split("-");
        if (tomb.length == 2 && isHoleNumber(tomb[0]) && isHoleNumber(tomb[1]) && vaneIlyenKordinata(varazslasHelye)) {
            for (Kor kor : egeszKor) {
                if (kor.getEgyseg().getOszlop() == Integer.parseInt(tomb[0]) && kor.getEgyseg().getSor() == Integer.parseInt(tomb[1])) {
                    if (kor.getEgyseg().isJatekosEe() == false) {
                        return true;
                    } else {
                        return false;
                    }

                }
            }
        }
        return false;
    }

    /**
     * Az adott kórdinátán vane játékosnak egysége vagy nincs
     * @param varazslasHelye az adott kórdináta
     * @param egeszKor az egységek listája
     * @return true ha van ott játékosnak egysége, false ha nincs
     */
    public static boolean vaneOttJatekosEgyseg(String varazslasHelye, ArrayList<Kor> egeszKor) {
        String []tomb = varazslasHelye.split("-");
        if (tomb.length == 2 && isHoleNumber(tomb[0]) && isHoleNumber(tomb[1]) && vaneIlyenKordinata(varazslasHelye)) {
            for (Kor kor : egeszKor) {
                if (kor.getEgyseg().getOszlop() == Integer.parseInt(tomb[0]) && kor.getEgyseg().getSor() == Integer.parseInt(tomb[1])) {
                    if (kor.getEgyseg().isJatekosEe() == true) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Ellenőrzi hogy nyert e a játékos
     * @param kor a még élő egységek listája
     * @return true ha játékos nyert egyébként false
     */
    public static boolean jatekosNyert(ArrayList<Kor> kor){
        int numberOfAiUnits = 0, numberOfPlayerUnits = 0;
        for (int i=0;i<kor.size();i++){
            if(kor.get(i).getEgyseg().isJatekosEe()){
                numberOfPlayerUnits++;
            }
            if(!kor.get(i).getEgyseg().isJatekosEe()){
                numberOfAiUnits++;
            }
        }
        if(numberOfAiUnits == 0 && numberOfPlayerUnits >0){
            return true;
        }
        return false;
    }

    /**
     * Ellenőrzi hogy nyert e a gép
     * @param kor a még élő egységek listája
     * @return true ha gép nyert egyébként false
     */
    public static boolean aiNyert(ArrayList<Kor> kor){
        int numberOfAiUnits = 0, numberOfPlayerUnits = 0;
        for (int i=0;i<kor.size();i++){
            if(kor.get(i).getEgyseg().isJatekosEe()){
                numberOfPlayerUnits++;
            }
            if(!kor.get(i).getEgyseg().isJatekosEe()){
                numberOfAiUnits++;
            }
        }
        if(numberOfPlayerUnits == 0 && numberOfAiUnits >0){
            return true;
        }
        return false;

    }

    /**
     * Döntetlen lett e, vagyis mindkét játékos egységei egyszerre haltake meg
     * @param kor a még élő egységek listája
     * @return true ha döntetlen false ha nem
     */
    public static boolean dontetlenLett(ArrayList<Kor> kor){
        int numberOfAiUnits = 0, numberOfPlayerUnits = 0;
        for (int i=0;i<kor.size();i++){
            if(kor.get(i).getEgyseg().isJatekosEe()){
                numberOfPlayerUnits++;
            }
            if(!kor.get(i).getEgyseg().isJatekosEe()){
                numberOfAiUnits++;
            }
        }
        if(numberOfPlayerUnits == 0 && numberOfAiUnits == 0){
            return true;
        }
        return false;
    }


    /**
     * Megnézi hogy van e elég pénz
     * @param ar termék ára
     * @param menyiseg termék mennyisége
     * @param jatekos aki megakarja venni
     * @return true ha van rá elég pénz false ha nincs
     */
        public static boolean vanerapenz(int ar, int menyiseg, Jatekos jatekos){
            if(ar > 0 && menyiseg > 0){
                return (ar * menyiseg) <= jatekos.getArany();
            }else {
                return false;
            }

        }

    /**
     * A játékos hős pontjainak megvásárlásának kezelése
     * @param jelenlegiStat a hős jelenlegi statisztikája
     * @param jatekos az aki veszi a statisztikákat
     * @param ennyire amennyire be szeretné állítani
     * @return true ha van a pontokra elég aranya, false ha nincs
     */
        //játékos használja pontkiosztás során
        public static boolean lehetNovelni(int jelenlegiStat, Jatekos jatekos,int ennyire){
            int ertekValtozas = 0;
            if(jelenlegiStat == ennyire){
                return false;
            }
            int osszkolcseg = 0;
            if(jelenlegiStat < ennyire){
                // noveles
                for (;jelenlegiStat < ennyire;jelenlegiStat++){
                    if(jelenlegiStat >= 1 && jelenlegiStat <= 7 ){
                        ertekValtozas = jelenlegiStat + 4;
                    }
                    if(jelenlegiStat == 8){
                        ertekValtozas = 13;
                    }
                    if(jelenlegiStat == 9){
                        ertekValtozas = 15;
                    }
                    osszkolcseg = osszkolcseg + ertekValtozas;

                }

            }
            if(jelenlegiStat > ennyire){
                // csokkentes
                while (ennyire < jelenlegiStat) {
                    if(jelenlegiStat >= 2 && jelenlegiStat <= 8 ){
                        ertekValtozas = jelenlegiStat + 3;
                    }

                    if(jelenlegiStat == 9){
                        ertekValtozas = 13;
                    }
                    if(jelenlegiStat == 10){
                        ertekValtozas = 15;
                    }

                    osszkolcseg = osszkolcseg - ertekValtozas;
                    jelenlegiStat--;
                }
            }

            if((jatekos.getArany()-osszkolcseg) < 0){
                return false;
            }
            jatekos.setArany(jatekos.getArany()-osszkolcseg);

            return true;
        }
        //Ai használja pontkiosztás során

    /**
     * A gép hősének pontjainak vásárlásáért, aranya kezelésért felel
     * @param jelenlegiStat a hős jelenlegi statisztikája
     * @param jatekos az aki veszi a statisztikákat
     * @return true ha meg tudja venni, false ha nem
     */
        public static boolean lehetNovelni(int jelenlegiStat, Jatekos jatekos){
            int ertekValtozas = 0;
            if(jelenlegiStat == 10){
                return false;
            }
            if(jelenlegiStat >= 1 && jelenlegiStat <= 7 ){
                ertekValtozas = jelenlegiStat + 4;
            }
            if(jelenlegiStat == 8){
                ertekValtozas = 13;
            }
            if(jelenlegiStat == 9){
                ertekValtozas = 15;
            }

            if((jatekos.getArany()-ertekValtozas) < 0){
                return false;
            }
            jatekos.setArany(jatekos.getArany()-ertekValtozas);

            return true;
    }

    public static boolean tudszEMozogni(Unit egyseg, Mezo palya, ArrayList<Kor> kor){

                    //van e ball fenn valaki
                        if(vaneIlyenKordinata((egyseg.getOszlop()-1)+"-"+(egyseg.getSor()-1)) && vaneOttJatekosEgyseg((egyseg.getOszlop()-1)+"-"+(egyseg.getSor()-1),kor) == false && vaneOttAIEgyseg((egyseg.getOszlop()-1)+"-"+(egyseg.getSor()-1),kor) == false){
                            return true;
                        }
                        //vane ballra
                    if(vaneIlyenKordinata((egyseg.getOszlop())+"-"+(egyseg.getSor()-1)) && vaneOttJatekosEgyseg((egyseg.getOszlop())+"-"+(egyseg.getSor()-1),kor) == false && vaneOttAIEgyseg((egyseg.getOszlop())+"-"+(egyseg.getSor()-1),kor) == false){
                        return true;
                    }
                    //ball le
        if(vaneIlyenKordinata((egyseg.getOszlop()+1)+"-"+(egyseg.getSor()-1)) && vaneOttJatekosEgyseg((egyseg.getOszlop()+1)+"-"+(egyseg.getSor()-1),kor) == false && vaneOttAIEgyseg((egyseg.getOszlop()+1)+"-"+(egyseg.getSor()-1),kor) == false){
            return true;
        }
        //felette
        if(vaneIlyenKordinata((egyseg.getOszlop()-1)+"-"+(egyseg.getSor())) && vaneOttJatekosEgyseg((egyseg.getOszlop()-1)+"-"+(egyseg.getSor()),kor) == false && vaneOttAIEgyseg((egyseg.getOszlop()-1)+"-"+(egyseg.getSor()),kor) == false){
            return true;
        }
        //alatta
        if(vaneIlyenKordinata((egyseg.getOszlop()+1)+"-"+(egyseg.getSor())) && vaneOttJatekosEgyseg((egyseg.getOszlop()+1)+"-"+(egyseg.getSor()),kor) == false && vaneOttAIEgyseg((egyseg.getOszlop()+1)+"-"+(egyseg.getSor()),kor) == false){
            return true;
        }
        //jobb fent
        if(vaneIlyenKordinata((egyseg.getOszlop()-1)+"-"+(egyseg.getSor()+1)) && vaneOttJatekosEgyseg((egyseg.getOszlop()-1)+"-"+(egyseg.getSor()+1),kor) == false && vaneOttAIEgyseg((egyseg.getOszlop()-1)+"-"+(egyseg.getSor()+1),kor) == false){
            return true;
        }
        //jobb lent
        if(vaneIlyenKordinata((egyseg.getOszlop()+1)+"-"+(egyseg.getSor()+1)) && vaneOttJatekosEgyseg((egyseg.getOszlop()+1)+"-"+(egyseg.getSor()+1),kor) == false && vaneOttAIEgyseg((egyseg.getOszlop()+1)+"-"+(egyseg.getSor()+1),kor) == false){
            return true;
        }
        //jobb
        if(vaneIlyenKordinata((egyseg.getOszlop())+"-"+(egyseg.getSor()+1)) && vaneOttJatekosEgyseg((egyseg.getOszlop())+"-"+(egyseg.getSor()+1),kor) == false && vaneOttAIEgyseg((egyseg.getOszlop())+"-"+(egyseg.getSor()+1),kor) == false){
            return true;
        }


            return false;
    }
}
