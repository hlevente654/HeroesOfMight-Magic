package Csata;

import CsataMezo.Kor;
import CsataMezo.Mezo;
import Egysegek.Unit;
import Kiegeszitok.Ellenorok;
import Egysegek.Hos;

import java.util.ArrayList;

import static Kiegeszitok.Colours.*;

/**
 * Itt számolódnak és hajtódnak végre a sebző vagy más módon egységet befolyásoló hatások
 */
public class Sebzes {
    /**
     *Itt tudnak közelharcban támadni egymást
     * @param akiSebez egység aki most lép és támad
     * @param akitSebez akit most támadnak meg
     * @param hos hos akinek az egysége támad
     * @param ellenfelhos hos akinek az egységét megtámadták
     * @param kor az összes körben résztvevők listája abban a sorrendben amiben lépnek
     * @param palya amin harcolnak
     */
    public static void egysegSebezEgysegetTavolrol(Unit akiSebez, Unit akitSebez, Hos hos, Hos ellenfelhos, ArrayList<Kor> kor, Mezo palya){
        int sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,ellenfelhos,kor,palya);
        sebzodes(akitSebez, sebzes);
        if(akitSebez.getMenyiseg() < 1){
            System.out.println("Meghalt az egyseg");
            egysegMeghal(akitSebez, kor, palya);
        }

    }
    /**
     *Itt tudnak távolról támadni egymást
     * @param akiSebez egység aki most lép és támad
     * @param akitSebez akit most támadnak meg
     * @param hos hos akinek az egysége támad
     * @param ellenfelhos hos akinek az egységét megtámadták
     * @param kor az összes körben résztvevők listája abban a sorrendben amiben lépnek
     * @param palya amin harcolnak
     */
    public static void egysegSebezEgysegetKozelrol(Unit akiSebez, Unit akitSebez, Hos hos, Hos ellenfelhos, ArrayList<Kor> kor, Mezo palya){
        int sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,ellenfelhos,kor,palya);
            sebzodes(akitSebez, sebzes);
            if(akitSebez.getMenyiseg() < 1){
                System.out.println("Meghalt az egyseg");
                egysegMeghal(akitSebez, kor, palya);
            }else {
                //ha nem tavolsagi és meg van visszatamadasa akkor
                //System.out.println("Akit megtamadtak: "+akitSebez.isVisszatamadhat()+" : Aki tamad: "+akiSebez.isVisszatamadhat());
                if(!akitSebez.getEgyseg().isRange()){
                    if(akitSebez.isVisszatamadhat()){
                        visszatamadas( akiSebez,  akitSebez,  hos,  ellenfelhos,  kor,  palya);
                    }
                }
                //System.out.println("Akit megtamadtak: "+akitSebez.isVisszatamadhat()+" : Aki tamad: "+akiSebez.isVisszatamadhat());

            }
        if(akiSebez.getEgyseg().getNev().equals("Pit Fiend")){
            cleavAttack( akiSebez,  akitSebez,  hos,  ellenfelhos,  kor, palya);

        }



    }
    /**
     *Itt tudnak közelharcban a cleav attack-ra képesek a fő célpont melletti egységeket is megsebezni
     * legyenaz barát vagy ellenség
     * @param akiSebez egység aki most lép és támad
     * @param akitSebez akit most támadnak meg
     * @param hos hos akinek az egysége támad
     * @param ellenfelhos hos akinek az egységét megtámadták
     * @param kor az összes körben résztvevők listája abban a sorrendben amiben lépnek
     * @param palya amin harcolnak
     */
    private static void cleavAttack(Unit akiSebez, Unit akitSebez, Hos hos, Hos ellenfelhos, ArrayList<Kor> kor, Mezo palya) {

        // Itt tartok még mindig rossz és végtelenszer megy + társat is megtamad magatol

        // itt tartok: szarul vannak az ifen belul a + - ok
        //jobbra tamad
        if(akiSebez.getMenyiseg() > 0 && akiSebez.getOszlop() == akitSebez.getOszlop() && akiSebez.getSor()+1 == (akitSebez.getSor())  ){
            for (int i=0;i< kor.size();i++){
                if(akiSebez.getMenyiseg() > 0 &&  Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop()-1)+"-"+(akiSebez.getSor()+1)) && akitSebez.getOszlop() == (kor.get(i).getEgyseg().getOszlop()+1) && akitSebez.getSor() == kor.get(i).getEgyseg().getSor() ){
                    System.out.println("CLEAVE");
                    int sebzes;
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,hos,kor,palya);
                    }else {
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,ellenfelhos,kor,palya);
                    }

                    sebzodes(kor.get(i).getEgyseg(), sebzes);
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(kor.get(i).getEgyseg(), kor, palya);
                    }else {
                        // ha nem tavolsagi és meg van visszatamadasa akkor
                        if(akiSebez.getMenyiseg() > 0 && !kor.get(i).getEgyseg().getEgyseg().isRange()){
                            if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isVisszatamadhat()){
                                if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  hos,  kor,  palya);
                                }else {
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  ellenfelhos,  kor,  palya);
                                }

                            }
                        }
                    }

                    System.out.println("Van felette ellenfel akit meg lehet csapni");
                }
                if(akiSebez.getMenyiseg() > 0 &&  Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop()+1)+"-"+(akiSebez.getSor()+1)) && akitSebez.getOszlop()+1 == (kor.get(i).getEgyseg().getOszlop()) && akitSebez.getSor() == kor.get(i).getEgyseg().getSor() ){
                    System.out.println("CLEAVE");
                    int sebzes;
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,hos,kor,palya);
                    }else {
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,ellenfelhos,kor,palya);
                    }
                    sebzodes(kor.get(i).getEgyseg(), sebzes);
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(kor.get(i).getEgyseg(), kor, palya);
                    }else {
                        // ha nem tavolsagi és meg van visszatamadasa akkor
                        if(akiSebez.getMenyiseg() > 0 && !kor.get(i).getEgyseg().getEgyseg().isRange()){
                            if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isVisszatamadhat()){
                                if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  hos,  kor,  palya);
                                }else {
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  ellenfelhos,  kor,  palya);
                                }
                            }
                        }
                    }
                    System.out.println("Van alatta ellenfel akit meg lehet csapni");
                }
            }

        }
        //jobb fel tamad
        if(akiSebez.getMenyiseg() > 0 &&  akiSebez.getOszlop()-1 == (akitSebez.getOszlop()) && akiSebez.getSor()+1 == (akitSebez.getSor())  ){
            for (int i=0;i< kor.size();i++){
                if(akiSebez.getMenyiseg() > 0 &&  Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop()-1)+"-"+(akiSebez.getSor())) && akitSebez.getOszlop() == (kor.get(i).getEgyseg().getOszlop()) && akitSebez.getSor()-1 == (kor.get(i).getEgyseg().getSor()) ){
                    System.out.println("CLEAVE");
                    int sebzes;
                    if(akiSebez.getMenyiseg() > 0 &&  kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,hos,kor,palya);
                    }else {
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,ellenfelhos,kor,palya);
                    }
                    sebzodes(kor.get(i).getEgyseg(), sebzes);
                    if(akiSebez.getMenyiseg() > 0 &&  kor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(kor.get(i).getEgyseg(), kor, palya);
                    }else {
                        // ha nem tavolsagi és meg van visszatamadasa akkor
                        if(akiSebez.getMenyiseg() > 0 && !kor.get(i).getEgyseg().getEgyseg().isRange()){
                            if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isVisszatamadhat()){
                                if(akiSebez.getMenyiseg() > 0 &&  kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  hos,  kor,  palya);
                                }else {
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  ellenfelhos,  kor,  palya);
                                }
                            }
                        }
                    }
                    System.out.println("Van tolle ballra ellenfel akit meg lehet csapni");
                }
                if(akiSebez.getMenyiseg() > 0 &&  Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop())+"-"+(akiSebez.getSor()+1)) && akitSebez.getOszlop()+1 == (kor.get(i).getEgyseg().getOszlop()) && akitSebez.getSor() == kor.get(i).getEgyseg().getSor() ){
                    System.out.println("CLEAVE");
                    int sebzes;
                    if(akiSebez.getMenyiseg() > 0 &&  kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,hos,kor,palya);
                    }else {
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,ellenfelhos,kor,palya);
                    }
                    sebzodes(kor.get(i).getEgyseg(), sebzes);
                    if(akiSebez.getMenyiseg() > 0 &&  kor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(kor.get(i).getEgyseg(), kor, palya);
                    }else {
                        //ha nem tavolsagi és meg van visszatamadasa akkor
                        if(akiSebez.getMenyiseg() > 0 && !kor.get(i).getEgyseg().getEgyseg().isRange()){
                            if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isVisszatamadhat()){
                                if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  hos,  kor,  palya);
                                }else {
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  ellenfelhos,  kor,  palya);
                                }
                            }
                        }
                    }
                    System.out.println("Van alatta ellenfel akit meg lehet csapni");
                }
            }
        }
        //jobb le tamad
        if(akiSebez.getMenyiseg() > 0 &&  akiSebez.getOszlop()+1 == (akitSebez.getOszlop()) && akiSebez.getSor()+1 == (akitSebez.getSor())  ){
            for (int i=0;i< kor.size();i++){


                if(akiSebez.getMenyiseg() > 0 &&  Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop()-1)+"-"+(akiSebez.getSor()+1)) && akitSebez.getOszlop()-1 == (kor.get(i).getEgyseg().getOszlop()) && akitSebez.getSor() == kor.get(i).getEgyseg().getSor() ){
                    System.out.println("CLEAVE");
                    int sebzes;
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,hos,kor,palya);
                    }else {
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,ellenfelhos,kor,palya);
                    }
                    sebzodes(kor.get(i).getEgyseg(), sebzes);
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(kor.get(i).getEgyseg(), kor, palya);
                    }else {
                        //ha nem tavolsagi és meg van visszatamadasa akkor
                        if(akiSebez.getMenyiseg() > 0 && !kor.get(i).getEgyseg().getEgyseg().isRange()){
                            if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isVisszatamadhat()){
                                if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  hos,  kor,  palya);
                                }else {
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  ellenfelhos,  kor,  palya);
                                }
                            }
                        }
                    }
                    System.out.println("Van felette ellenfel akit meg lehet csapni");
                }
                if(akiSebez.getMenyiseg() > 0 &&  Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop()-1)+"-"+(akiSebez.getSor())) && akitSebez.getOszlop() == (kor.get(i).getEgyseg().getOszlop()) && akitSebez.getSor()-1 == (kor.get(i).getEgyseg().getSor()) ){
                    System.out.println("CLEAVE");
                    int sebzes;
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,hos,kor,palya);
                    }else {
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,ellenfelhos,kor,palya);
                    }
                    sebzodes(kor.get(i).getEgyseg(), sebzes);
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(kor.get(i).getEgyseg(), kor, palya);
                    }else {
                        //ha nem tavolsagi és meg van visszatamadasa akkor
                        if(akiSebez.getMenyiseg() > 0 && !kor.get(i).getEgyseg().getEgyseg().isRange()){
                            if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isVisszatamadhat()){
                                if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  hos,  kor,  palya);
                                }else {
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  ellenfelhos,  kor,  palya);
                                }
                            }
                        }
                    }
                    System.out.println("Van tolle ballra ellenfel akit meg lehet csapni");
                }
            }
        }
        //fel tamad
        if(akiSebez.getMenyiseg() > 0 && akiSebez.getOszlop()-1 == (akitSebez.getOszlop()) && akiSebez.getSor() == (akitSebez.getSor())  ){
            for (int i=0;i< kor.size();i++){

                if(akiSebez.getMenyiseg() > 0 && Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop()-1)+"-"+(akiSebez.getSor()-1)) && akitSebez.getOszlop() == (kor.get(i).getEgyseg().getOszlop()) && akitSebez.getSor()-1 == (kor.get(i).getEgyseg().getSor()) ){
                    System.out.println("CLEAVE");
                    int sebzes;
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,hos,kor,palya);
                    }else {
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,ellenfelhos,kor,palya);
                    }
                    sebzodes(kor.get(i).getEgyseg(), sebzes);
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(kor.get(i).getEgyseg(), kor, palya);
                    }else {
                        //ha nem tavolsagi és meg van visszatamadasa akkor
                        if(akiSebez.getMenyiseg() > 0 && !kor.get(i).getEgyseg().getEgyseg().isRange()){
                            if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isVisszatamadhat()){
                                if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  hos,  kor,  palya);
                                }else {
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  ellenfelhos,  kor,  palya);
                                }
                            }
                        }
                    }
                    System.out.println("Van tolle ballra ellenfel akit meg lehet csapni");
                }
                if(akiSebez.getMenyiseg() > 0 && Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop()-1)+"-"+(akiSebez.getSor()+1)) && akitSebez.getOszlop() == (kor.get(i).getEgyseg().getOszlop()) && akitSebez.getSor()+1 == (kor.get(i).getEgyseg().getSor()+1) ){
                    System.out.println("CLEAVE");
                    int sebzes;
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,hos,kor,palya);
                    }else {
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,ellenfelhos,kor,palya);
                    }
                    sebzodes(kor.get(i).getEgyseg(), sebzes);
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(kor.get(i).getEgyseg(), kor, palya);
                    }else {
                        //ha nem tavolsagi és meg van visszatamadasa akkor
                        if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().getEgyseg().isRange() == false){
                            if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isVisszatamadhat() == true){
                                if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  hos,  kor,  palya);
                                }else {
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  ellenfelhos,  kor,  palya);
                                }
                            }
                        }
                    }
                    System.out.println("Van tolle jobbra ellenfel akit meg lehet csapni");
                }
            }
        }
        //le tamad
        if(akiSebez.getMenyiseg() > 0 && akiSebez.getOszlop()+1 == (akitSebez.getOszlop()) && akiSebez.getSor() == (akitSebez.getSor())  ){
            for (int i=0;i< kor.size();i++){

                if(akiSebez.getMenyiseg() > 0 && Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop()+1)+"-"+(akiSebez.getSor()-1)) && akitSebez.getOszlop() == (kor.get(i).getEgyseg().getOszlop()) && akitSebez.getSor()-1 == (kor.get(i).getEgyseg().getSor()) ){
                    System.out.println("CLEAVE");
                    int sebzes = 0;
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,hos,kor,palya);
                    }else {
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,ellenfelhos,kor,palya);
                    }
                    sebzodes(kor.get(i).getEgyseg(), sebzes);
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(kor.get(i).getEgyseg(), kor, palya);
                    }else {
                        //ha nem tavolsagi és meg van visszatamadasa akkor
                        if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().getEgyseg().isRange() == false){
                            if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isVisszatamadhat() == true){
                                if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  hos,  kor,  palya);
                                }else {
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  ellenfelhos,  kor,  palya);
                                }
                            }
                        }
                    }
                    System.out.println("Van tolle ballra akit meg lehet csapni");
                }
                if(akiSebez.getMenyiseg() > 0 && Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop()+1)+"-"+(akiSebez.getSor()+1)) && akitSebez.getOszlop() == (kor.get(i).getEgyseg().getOszlop()) && akitSebez.getSor()+1 == (kor.get(i).getEgyseg().getSor()) ){
                    System.out.println("CLEAVE");
                    int sebzes = 0;
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,hos,kor,palya);
                    }else {
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,ellenfelhos,kor,palya);
                    }
                    sebzodes(kor.get(i).getEgyseg(), sebzes);
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(kor.get(i).getEgyseg(), kor, palya);
                    }else {
                        //ha nem tavolsagi és meg van visszatamadasa akkor
                        if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().getEgyseg().isRange() == false){
                            if(kor.get(i).getEgyseg().isVisszatamadhat() == true){
                                if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  hos,  kor,  palya);
                                }else {
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  ellenfelhos,  kor,  palya);
                                }
                            }
                        }
                    }
                    System.out.println("Van tolle jobbra akit meg lehet csapni");
                }
            }
        }
        //ball le tamad
        if(akiSebez.getMenyiseg() > 0 && akiSebez.getOszlop()+1 == (akitSebez.getOszlop()) && akiSebez.getSor()-1 == (akitSebez.getSor())  ){
            for (int i=0;i< kor.size();i++){

                if(akiSebez.getMenyiseg() > 0 && Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop()+1)+"-"+(akiSebez.getSor())) && akitSebez.getOszlop() == (kor.get(i).getEgyseg().getOszlop()) && akitSebez.getSor()+1 == (kor.get(i).getEgyseg().getSor()) ){
                    System.out.println("CLEAVE");
                    int sebzes = 0;
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,hos,kor,palya);
                    }else {
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,ellenfelhos,kor,palya);
                    }
                    sebzodes(kor.get(i).getEgyseg(), sebzes);
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(kor.get(i).getEgyseg(), kor, palya);
                    }else {
                        // ha nem tavolsagi és meg van visszatamadasa akkor
                        if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().getEgyseg().isRange() == false){
                            if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isVisszatamadhat() == true){
                                if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  hos,  kor,  palya);
                                }else {
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  ellenfelhos,  kor,  palya);
                                }
                            }
                        }
                    }
                    System.out.println("Van tolle jobbra akit meg lehet csapni");
                }
                if(akiSebez.getMenyiseg() > 0 && Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop())+"-"+(akiSebez.getSor()-1)) && akitSebez.getOszlop()-1 == (kor.get(i).getEgyseg().getOszlop()) && akitSebez.getSor() == kor.get(i).getEgyseg().getSor() ){
                    System.out.println("CLEAVE");
                    int sebzes = 0;
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,hos,kor,palya);
                    }else {
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,ellenfelhos,kor,palya);
                    }
                    sebzodes(kor.get(i).getEgyseg(), sebzes);
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(kor.get(i).getEgyseg(), kor, palya);
                    }else {
                        // ha nem tavolsagi és meg van visszatamadasa akkor
                        if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().getEgyseg().isRange() == false){
                            if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isVisszatamadhat() == true){
                                if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  hos,  kor,  palya);
                                }else {
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  ellenfelhos,  kor,  palya);
                                }
                            }
                        }
                    }
                    System.out.println("Van felette ellenfel akit meg lehet csapni");
                }
            }
        }
        //ball
        if(akiSebez.getMenyiseg() > 0 && akiSebez.getOszlop() == akitSebez.getOszlop() && akiSebez.getSor()-1 == (akitSebez.getSor())  ){
            for (int i=0;i< kor.size();i++){

                if(akiSebez.getMenyiseg() > 0 && Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop()-1)+"-"+(akiSebez.getSor()-1)) && akitSebez.getOszlop()-1 == (kor.get(i).getEgyseg().getOszlop()) && akitSebez.getSor() == kor.get(i).getEgyseg().getSor() ){
                    System.out.println("CLEAVE");
                    int sebzes = 0;
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,hos,kor,palya);
                    }else {
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,ellenfelhos,kor,palya);
                    }
                    sebzodes(kor.get(i).getEgyseg(), sebzes);
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(kor.get(i).getEgyseg(), kor, palya);
                    }else {
                        // ha nem tavolsagi és meg van visszatamadasa akkor
                        if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().getEgyseg().isRange() == false){
                            if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isVisszatamadhat() == true){
                                if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  hos,  kor,  palya);
                                }else {
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  ellenfelhos,  kor,  palya);
                                }
                            }
                        }
                    }
                    System.out.println("Van felette ellenfel akit meg lehet csapni");
                }
                if(akiSebez.getMenyiseg() > 0 && Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop()+1)+"-"+(akiSebez.getSor()-1)) && akitSebez.getOszlop()+1 == (kor.get(i).getEgyseg().getOszlop()) && akitSebez.getSor() == kor.get(i).getEgyseg().getSor() ){
                    System.out.println("CLEAVE");
                    int sebzes = 0;
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,hos,kor,palya);
                    }else {
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,ellenfelhos,kor,palya);
                    }
                    sebzodes(kor.get(i).getEgyseg(), sebzes);
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(kor.get(i).getEgyseg(), kor, palya);
                    }else {
                        // ha nem tavolsagi és meg van visszatamadasa akkor
                        if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().getEgyseg().isRange() == false){
                            if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isVisszatamadhat() == true){
                                if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  hos,  kor,  palya);
                                }else {
                                    visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  ellenfelhos,  kor,  palya);
                                }
                            }
                        }
                    }
                    System.out.println("Van alatta ellenfel akit meg lehet csapni");
                }
            }
        }
        //ball fel
        if(akiSebez.getMenyiseg() > 0 && akiSebez.getOszlop()-1 == (akitSebez.getOszlop()) && akiSebez.getSor()-1 == (akitSebez.getSor())  ){
            for (int i=0;i< kor.size();i++){
                if(akiSebez.getMenyiseg() > 0 && Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop()-1)+"-"+(akiSebez.getSor())) && akitSebez.getOszlop() == (kor.get(i).getEgyseg().getOszlop()) && akitSebez.getSor()+1 == (kor.get(i).getEgyseg().getSor()) ){
                    System.out.println("CLEAVE");
                    int sebzes = 0;
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,hos,kor,palya);
                    }else {
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,ellenfelhos,kor,palya);
                    }
                    sebzodes(kor.get(i).getEgyseg(), sebzes);
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(kor.get(i).getEgyseg(), kor, palya);
                    }else {
                        // ha nem tavolsagi és meg van visszatamadasa akkor
                        if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().getEgyseg().isRange() == false){
                            if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isVisszatamadhat() == true){
                                visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  ellenfelhos,  kor,  palya);
                            }
                        }
                    }
                    System.out.println("Van tolle jobbra akit meg lehet csapni");
                }
                if(akiSebez.getMenyiseg() > 0 && Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop())+"-"+(akiSebez.getSor()-1)) && akitSebez.getOszlop()+1 == (kor.get(i).getEgyseg().getOszlop()) && akitSebez.getSor() == kor.get(i).getEgyseg().getSor() ){
                    System.out.println("CLEAVE");
                    int sebzes = 0;
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isJatekosEe() == akiSebez.isJatekosEe()){
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,hos,kor,palya);
                    }else {
                        sebzes = EgysegSebzesKiszamitasa(akiSebez, akitSebez,hos,ellenfelhos,kor,palya);
                    }
                    sebzodes(kor.get(i).getEgyseg(), sebzes);
                    if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(kor.get(i).getEgyseg(), kor, palya);
                    }else {
                        // ha nem tavolsagi és meg van visszatamadasa akkor
                        if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().getEgyseg().isRange() == false){
                            if(akiSebez.getMenyiseg() > 0 && kor.get(i).getEgyseg().isVisszatamadhat() == true){
                                visszatamadas( akiSebez,  kor.get(i).getEgyseg(),  hos,  ellenfelhos,  kor,  palya);
                            }
                        }
                    }
                    System.out.println("Van alatta ellenfel akit meg lehet csapni");
                }
            }
        }
    }

    /**
     * A közelharcban történő megtámadás esetén vissza támadás
     * @param akiMegtamadott az az egység aki támadott
     * @param akitMegtamadtak az az egység akit megtámadtak
     * @param hos annak a hőse akit megtámadtak
     * @param ellenfelhos annak a hőse aki támadott
     * @param kor  az összes körben résztvevők listája abban a sorrendben amiben lépnek
     * @param palya amin harcolnak
     */
    public static void visszatamadas(Unit akiMegtamadott, Unit akitMegtamadtak, Hos hos, Hos ellenfelhos, ArrayList<Kor> kor, Mezo palya){
        if(akitMegtamadtak.isVisszatamadhat()) {
            int sebzes = EgysegSebzesKiszamitasa(akitMegtamadtak, akiMegtamadott, ellenfelhos, hos, kor, palya);
            double vsebzes = (double) sebzes * 0.5;
            sebzes = (int) Math.round(vsebzes);
            System.out.println("Vissza tamadas.");
            System.out.println("Vissza sebez: " + sebzes);
            sebzodes(akiMegtamadott, sebzes);

            if (akiMegtamadott.getMenyiseg() < 1) {
                System.out.println("Meghalt az egyseg");
                egysegMeghal(akiMegtamadott, kor, palya);
            }
        }
        if(akitMegtamadtak.getEgyseg().getSpecial().equals("vegtelenVisszatamadas")){
            akitMegtamadtak.setVisszatamadhat(true);
        }else{
            akitMegtamadtak.setVisszatamadhat(false);
        }

    }

    /**
     * Itt számolódik ki a támadás sebzése
     * legyenaz barát vagy ellenség
     * @param akiSebez egység aki most lép és támad
     * @param akitSebez akit most támadnak meg
     * @param hos hos akinek az egysége támad
     * @param ellenfelhos hos akinek az egységét megtámadták
     * @param kor az összes körben résztvevők listája abban a sorrendben amiben lépnek
     * @param palya amin harcolnak
     * @return az az érték amennyit sebzünk
     */
    public static int EgysegSebzesKiszamitasa(Unit akiSebez, Unit akitSebez, Hos hos, Hos ellenfelhos, ArrayList<Kor> kor, Mezo palya){
        int sebzes = (int)(Math.random()* (akiSebez.getEgyseg().getSebzesUpper() - akiSebez.getEgyseg().getSebzesLower() + 1)+akiSebez.getEgyseg().getSebzesLower());
        System.out.println(akiSebez.getEgyseg().getNev()+" tamadja "+akitSebez.getEgyseg().getNev());
        System.out.println("Krit eselye: "+hos.getSzerencse()*5);
        int kritElekE = (int)(Math.random()* (100)+1);
        System.out.println("Critelek e: "+kritElekE);
        System.out.println("Gurit: "+sebzes);
        int egyUttTamadunk = sebzes*akiSebez.getMenyiseg();
        System.out.println("Osszesen sebzunk: "+egyUttTamadunk);
        double novelo = (double) hos.getTamadas();
        System.out.println(novelo);
        novelo = novelo / 10;
        System.out.println(novelo);
        novelo = novelo +1;
        System.out.println("Novelo: "+novelo);
        double hosSegitseggel =egyUttTamadunk*novelo;
        System.out.println("Hos segitsegevel: "+hosSegitseggel);
        double vedekezes = ellenfelhos.getVedekezes() * 0.05;
        System.out.println("A vedekezes: "+vedekezes);
        double csatt = hosSegitseggel * vedekezes;
        double az = hosSegitseggel -csatt;
        int kiosztottSebzes = (int) Math.round(az);

        System.out.println("Kiosztott sebzes: "+kiosztottSebzes);
        if(kritElekE <= (hos.getSzerencse()*5)){
            System.out.println("CRIT");
            kiosztottSebzes = kiosztottSebzes*2;
            System.out.println("Kiosztott sebzes (CRIT): "+kiosztottSebzes);
        }
        return kiosztottSebzes;
    }

    /**
     * Ha vaamelyik egység meghal az itt kerül eltakarításra
     * @param akiMeghal az az egység amelyiknek elfogyott az élete
     * @param kor Ahonnan el kell távolítani a halottat
     * @param palya Ahonnan el kell távolítani a halottat
     */
    public static void egysegMeghal(Unit akiMeghal, ArrayList<Kor> kor, Mezo palya){
        //Tunjon el a pajarol
        for (int i=0;i< kor.size();i++){
            if(kor.get(i).getEgyseg().getSor() == akiMeghal.getSor() && kor.get(i).getEgyseg().getOszlop() == akiMeghal.getOszlop()){
                kor.remove(i);
                break;
            }
        }
        System.out.println("Meg van "+kor.size()+" egyseg");
        palya.setMezo(akiMeghal.getOszlop(),akiMeghal.getSor(),"0");
        palya.frissitettPalya(kor);

    }

    /**
     * Itt kapja meg a sebzést a megtámadott egység
     * @param akitSebez aki valamilyen támadás ért
     * @param kiosztottSebzes amennyit sérülni fpg
     */
    public static void sebzodes(Unit akitSebez, int kiosztottSebzes){
        System.out.println(akitSebez.getMenyiseg()+" ennyi "+akitSebez.getEgyseg().getNev()+" vann eleinte");
        int osszHp = akitSebez.getEgysegEletero();
        int maradtOsszHp = akitSebez.getEgysegEletero() -kiosztottSebzes;
        System.out.println("Maradt meg "+maradtOsszHp+" enyi osszhp");
        int meghalt = (osszHp - maradtOsszHp ) / akitSebez.getEgyseg().getEletero() ;
        if(akitSebez.getMenyiseg() - meghalt < 0){
            System.out.println("Meghaltak: "+akitSebez.getMenyiseg());
        }else{
            System.out.println("Meghaltak: "+meghalt);
        }
        boolean vanSebesult = false;
        if( ( (osszHp - maradtOsszHp ) % akitSebez.getEgyseg().getEletero() ) == 0 ){
            System.out.println("nincs serult");
            vanSebesult = false;
        }else{
            System.out.println("van serult");
            vanSebesult = true;
        }
        akitSebez.setEgysegEletero(maradtOsszHp);
        int elmeg = akitSebez.getEgysegEletero() / akitSebez.getEgyseg().getEletero();
        if(!vanSebesult){

        }else{
            elmeg = elmeg +1;
        }
        akitSebez.setMenyiseg(elmeg);
    }

    /**
     * A Játékos hős támad
     * @param palya
     * @param egyseg aki következik
     * @param egeszKor a körben benn lévő egységek listálya
     * @param hos aki támad
     * @param ellenfelhos akinek az egységét támadják
     * @return amennyit sebez a hos
     */
    public static int HosTamad(Mezo palya, Unit egyseg, ArrayList<Kor> egeszKor, Hos hos, Hos ellenfelhos){
        int sebzes;
        return sebzes = hos.getTamadas() * 10;
    }

    /**
     * Itt számolja ki a villámcsapás sebzését
     * @param varazslasHelye havo varázsol
     * @param egeszKor a körben benn lévő egységek listálya
     * @param hosAkiVarazsol
     * @param palya amin varázsolunk
     */
    public static void villamcsapasSebzes(String varazslasHelye,ArrayList<Kor> egeszKor,Hos hosAkiVarazsol,Mezo palya){
        String []tomb = varazslasHelye.split("-");
        for (int i=0;i<egeszKor.size();i++){
            if(egeszKor.get(i).getEgyseg().getOszlop() == Integer.parseInt(tomb[0]) && egeszKor.get(i).getEgyseg().getSor() == Integer.parseInt(tomb[1])){
                int sebzes = hosAkiVarazsol.getVarazsero()*30;
                sebzodes(egeszKor.get(i).getEgyseg(),sebzes);
                if(egeszKor.get(i).getEgyseg().getMenyiseg() < 1){
                    System.out.println("Meghalt az egyseg");
                    egysegMeghal(egeszKor.get(i).getEgyseg(), egeszKor, palya);
                }
            }
        }
    }
    /**
     * Itt számolja ki a tűzlabda sebzését
     * @param varazslasHelye havo varázsol
     * @param egeszKor a körben benn lévő egységek listálya
     * @param hosAkiVarazsol
     * @param palya amin varázsolunk
     */
    public static void tuzlabdaSebzes(String varazslasHelye,ArrayList<Kor> egeszKor,Hos hosAkiVarazsol,Mezo palya){
        String []tomb = varazslasHelye.split("-");
        int sebzes = hosAkiVarazsol.getVarazsero()*20;
        for (int i=0;i< egeszKor.size();i++){
            //ball felette
            if(Ellenorok.vaneIlyenKordinata((Integer.parseInt(tomb[0])-1)+"-"+(Integer.parseInt(tomb[1])-1))){
                if(egeszKor.get(i).getEgyseg().getOszlop() == (Integer.parseInt(tomb[0])-1) && egeszKor.get(i).getEgyseg().getSor() == (Integer.parseInt(tomb[1])-1)){
                    sebzodes(egeszKor.get(i).getEgyseg(),sebzes);
                    System.out.println(ANSI_RED+"A "+(Integer.parseInt(tomb[0])-1)+" - "+(Integer.parseInt(tomb[1])-1)+" mezőre mértek "+sebzes+" sebzést."+ANSI_RESET);
                    if(egeszKor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(egeszKor.get(i).getEgyseg(), egeszKor, palya);
                    }
                }
            }
            // ball mellette */
            if(Ellenorok.vaneIlyenKordinata((Integer.parseInt(tomb[0]))+"-"+(Integer.parseInt(tomb[1])-1))){
                if(egeszKor.get(i).getEgyseg().getOszlop() == (Integer.parseInt(tomb[0])) && egeszKor.get(i).getEgyseg().getSor() == (Integer.parseInt(tomb[1])-1)){
                    sebzodes(egeszKor.get(i).getEgyseg(),sebzes);
                    System.out.println(ANSI_RED+"A "+(Integer.parseInt(tomb[0]))+" - "+(Integer.parseInt(tomb[1])-1)+" mezőre mértek "+sebzes+" sebzést."+ANSI_RESET);
                    if(egeszKor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(egeszKor.get(i).getEgyseg(), egeszKor, palya);
                    }
                }
            }
            // ball alatta */
            if(Ellenorok.vaneIlyenKordinata((Integer.parseInt(tomb[0])+1)+"-"+(Integer.parseInt(tomb[1])-1))){
                if(egeszKor.get(i).getEgyseg().getOszlop() == (Integer.parseInt(tomb[0])+1) && egeszKor.get(i).getEgyseg().getSor() == (Integer.parseInt(tomb[1])-1)){
                    sebzodes(egeszKor.get(i).getEgyseg(),sebzes);
                    System.out.println(ANSI_RED+"A "+(Integer.parseInt(tomb[0])+1)+" - "+(Integer.parseInt(tomb[1])-1)+" mezőre mértek "+sebzes+" sebzést."+ANSI_RESET);
                    if(egeszKor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(egeszKor.get(i).getEgyseg(), egeszKor, palya);
                    }
                }
            }
            // felette */
            if(Ellenorok.vaneIlyenKordinata((Integer.parseInt(tomb[0])-1)+"-"+(Integer.parseInt(tomb[1])))){
                if(egeszKor.get(i).getEgyseg().getOszlop() == (Integer.parseInt(tomb[0])-1) && egeszKor.get(i).getEgyseg().getSor() == (Integer.parseInt(tomb[1]))){
                    sebzodes(egeszKor.get(i).getEgyseg(),sebzes);
                    System.out.println(ANSI_RED+"A "+(Integer.parseInt(tomb[0])-1)+" - "+(Integer.parseInt(tomb[1]))+" mezőre mértek "+sebzes+" sebzést."+ANSI_RESET);
                    if(egeszKor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(egeszKor.get(i).getEgyseg(), egeszKor, palya);
                    }
                }
            }
            // rajta */
            if(Ellenorok.vaneIlyenKordinata((Integer.parseInt(tomb[0]))+"-"+(Integer.parseInt(tomb[1])))){
                if(egeszKor.get(i).getEgyseg().getOszlop() == (Integer.parseInt(tomb[0])) && egeszKor.get(i).getEgyseg().getSor() == (Integer.parseInt(tomb[1]))){
                    sebzodes(egeszKor.get(i).getEgyseg(),sebzes);
                    System.out.println(ANSI_RED+"A "+(Integer.parseInt(tomb[0]))+" - "+(Integer.parseInt(tomb[1]))+" mezőre mértek "+sebzes+" sebzést."+ANSI_RESET);
                    if(egeszKor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(egeszKor.get(i).getEgyseg(), egeszKor, palya);
                    }
                }
            }
            // alatta */
            if(Ellenorok.vaneIlyenKordinata((Integer.parseInt(tomb[0])+1)+"-"+(Integer.parseInt(tomb[1])))){
                if(egeszKor.get(i).getEgyseg().getOszlop() == (Integer.parseInt(tomb[0])+1) && egeszKor.get(i).getEgyseg().getSor() == (Integer.parseInt(tomb[1]))){
                    sebzodes(egeszKor.get(i).getEgyseg(),sebzes);
                    System.out.println(ANSI_RED+"A "+(Integer.parseInt(tomb[0])+1)+" - "+(Integer.parseInt(tomb[1]))+" mezőre mértek "+sebzes+" sebzést."+ANSI_RESET);
                    if(egeszKor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(egeszKor.get(i).getEgyseg(), egeszKor, palya);
                    }
                }
            }
            // jobb folotte */
            if(Ellenorok.vaneIlyenKordinata((Integer.parseInt(tomb[0])-1)+"-"+(Integer.parseInt(tomb[1])+1))){
                if(egeszKor.get(i).getEgyseg().getOszlop() == (Integer.parseInt(tomb[0])-1) && egeszKor.get(i).getEgyseg().getSor() == (Integer.parseInt(tomb[1])+1)){
                    sebzodes(egeszKor.get(i).getEgyseg(),sebzes);
                    System.out.println(ANSI_RED+"A "+(Integer.parseInt(tomb[0])-1)+" - "+(Integer.parseInt(tomb[1])+1)+" mezőre mértek "+sebzes+" sebzést."+ANSI_RESET);
                    if(egeszKor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(egeszKor.get(i).getEgyseg(), egeszKor, palya);
                    }
                }
            }
            // jobb mellette */
            if(Ellenorok.vaneIlyenKordinata((Integer.parseInt(tomb[0]))+"-"+(Integer.parseInt(tomb[1])+1))){
                if(egeszKor.get(i).getEgyseg().getOszlop() == (Integer.parseInt(tomb[0])) && egeszKor.get(i).getEgyseg().getSor() == (Integer.parseInt(tomb[1])+1)){
                    sebzodes(egeszKor.get(i).getEgyseg(),sebzes);
                    System.out.println(ANSI_RED+"A "+(Integer.parseInt(tomb[0]))+" - "+(Integer.parseInt(tomb[1])+1)+" mezőre mértek "+sebzes+" sebzést."+ANSI_RESET);
                    if(egeszKor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(egeszKor.get(i).getEgyseg(), egeszKor, palya);
                    }
                }
            }
            // jobb alatta */
            if(Ellenorok.vaneIlyenKordinata((Integer.parseInt(tomb[0])+1)+"-"+(Integer.parseInt(tomb[1])+1))){
                if(egeszKor.get(i).getEgyseg().getOszlop() == (Integer.parseInt(tomb[0])+1) && egeszKor.get(i).getEgyseg().getSor() == (Integer.parseInt(tomb[1])+1)){
                    sebzodes(egeszKor.get(i).getEgyseg(),sebzes);
                    System.out.println(ANSI_RED+"A "+(Integer.parseInt(tomb[0])+1)+" - "+(Integer.parseInt(tomb[1])+1)+" mezőre mértek "+sebzes+" sebzést."+ANSI_RESET);
                    if(egeszKor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        egysegMeghal(egeszKor.get(i).getEgyseg(), egeszKor, palya);
                    }
                }
            }
        }

    }

    /**
     * Itt számolja ki hogy mennyit gyógyítson
     * @param gyogyitandoEgyseg aki gyógyulni fog
     * @param gyogyitas amennyit gyógyulni fog
     */
    public static void gyogyitas(Unit gyogyitandoEgyseg, int gyogyitas){
        System.out.println("Eleinte van "+gyogyitandoEgyseg.getEgyseg().getNev()+" bol "+gyogyitandoEgyseg.getMenyiseg()+" van, "+gyogyitandoEgyseg.getEgysegEletero());
        gyogyitandoEgyseg.setEgysegEletero(gyogyitandoEgyseg.getEgysegEletero()+gyogyitas);
        System.out.println("Maximum HP: "+gyogyitandoEgyseg.getMaximumHP());
        if(gyogyitandoEgyseg.getEgysegEletero() > gyogyitandoEgyseg.getMaximumHP()){
            gyogyitandoEgyseg.setEgysegEletero(gyogyitandoEgyseg.getMaximumHP());
        }
        int letszam = gyogyitandoEgyseg.getEgysegEletero() / gyogyitandoEgyseg.getEgyseg().getEletero();
        if( ( gyogyitandoEgyseg.getEgysegEletero() % gyogyitandoEgyseg.getEgyseg().getEletero() ) != 0 ){
            letszam = letszam +1;
        }
        gyogyitandoEgyseg.setMenyiseg(letszam);
        System.out.println(ANSI_BLUE+"Gyogyitas utan van "+gyogyitandoEgyseg.getEgyseg().getNev()+" bol "+gyogyitandoEgyseg.getMenyiseg()+" , "+gyogyitandoEgyseg.getEgysegEletero()+" összesített életerővel."+ANSI_RESET);


    }

    /**
     * Itt kapja meg a hógyítást az egység
     * @param varazslasHelye ahova varázsolunk
     * @param egeszKor a körben benn lévő egységek listálya
     * @param hosAkiVarazsol aki varázsol
     * @param palya amire varázsolunk
     */
    public static void feltamasztasMinuszSebzes(String varazslasHelye,ArrayList<Kor> egeszKor,Hos hosAkiVarazsol,Mezo palya){
        String []tomb = varazslasHelye.split("-");
        for (int i=0;i<egeszKor.size();i++){
            if(egeszKor.get(i).getEgyseg().getOszlop() == Integer.parseInt(tomb[0]) && egeszKor.get(i).getEgyseg().getSor() == Integer.parseInt(tomb[1])){
                int gyogyitas = hosAkiVarazsol.getVarazsero()*50;
                gyogyitas(egeszKor.get(i).getEgyseg(),gyogyitas);
                if(egeszKor.get(i).getEgyseg().getMenyiseg() < 1){
                    System.out.println("Meghalt az egyseg");
                    egysegMeghal(egeszKor.get(i).getEgyseg(), egeszKor, palya);
                }
            }
        }
    }

    /**
     * A kenntaur futás után megtámad valakit ha van mellette
     * @param akiSebez egység aki sebez
     * @param hos akinek az egysége sebez
     * @param hosAkinekAzEgysegetTamadjak
     * @param kor Ahonnan el kell távolítani a halottat
     * @param palya amire varázsolunk
     */
    public static void kenntaurLepesUtanSebez(Unit akiSebez, Hos hos, Hos hosAkinekAzEgysegetTamadjak, ArrayList<Kor> kor, Mezo palya) {
        // Ha van 1 vagy több ellenfel mellettünk valasszunk egyet és azt tamadjuk meg */
        System.out.println("Kenntaur futtaban sebez");
        // Itt valami nem jó */

        int hanyszortamadott = 0;

        if(Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop()-1)+"-"+(akiSebez.getSor()+1)))
        {
            if(akiSebez.isJatekosEe() && Ellenorok.vaneOttAIEgyseg((akiSebez.getOszlop()-1)+"-"+(akiSebez.getSor()+1),kor) ){
                for (int i=0;i<kor.size();i++){
                    if(kor.get(i).getEgyseg().getOszlop() == (akiSebez.getOszlop()-1) && kor.get(i).getEgyseg().getSor() == (akiSebez.getSor()+1)){
                        hanyszortamadott++;
                        egysegSebezEgysegetKozelrol(akiSebez,kor.get(i).getEgyseg(),hos,hosAkinekAzEgysegetTamadjak,kor,palya);
                    }
                }

            }
            if(!akiSebez.isJatekosEe() && Ellenorok.vaneOttJatekosEgyseg((akiSebez.getOszlop()-1)+"-"+(akiSebez.getSor()+1),kor)){
                for (int i=0;i<kor.size();i++){
                    if(kor.get(i).getEgyseg().getOszlop() == (akiSebez.getOszlop()-1) && kor.get(i).getEgyseg().getSor() == (akiSebez.getSor()+1)){
                        egysegSebezEgysegetKozelrol(akiSebez,kor.get(i).getEgyseg(),hos,hosAkinekAzEgysegetTamadjak,kor,palya);
                        hanyszortamadott++;
                    }
                }
            }

        }
        if(hanyszortamadott == 0 && Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop())+"-"+(akiSebez.getSor()+1)))
        {
            if(akiSebez.isJatekosEe() && Ellenorok.vaneOttAIEgyseg((akiSebez.getOszlop())+"-"+(akiSebez.getSor()+1),kor) ){
                for (int i=0;i<kor.size();i++){
                    if(kor.get(i).getEgyseg().getOszlop() == (akiSebez.getOszlop()) && kor.get(i).getEgyseg().getSor() == (akiSebez.getSor()+1)){
                        egysegSebezEgysegetKozelrol(akiSebez,kor.get(i).getEgyseg(),hos,hosAkinekAzEgysegetTamadjak,kor,palya);
                        hanyszortamadott++;
                    }
                }

            }
            if(!akiSebez.isJatekosEe() && Ellenorok.vaneOttJatekosEgyseg((akiSebez.getOszlop())+"-"+(akiSebez.getSor()+1),kor)){
                for (int i=0;i<kor.size();i++){
                    if(kor.get(i).getEgyseg().getOszlop() == (akiSebez.getOszlop()) && kor.get(i).getEgyseg().getSor() == (akiSebez.getSor()+1)){
                        egysegSebezEgysegetKozelrol(akiSebez,kor.get(i).getEgyseg(),hos,hosAkinekAzEgysegetTamadjak,kor,palya);
                        hanyszortamadott++;
                    }
                }
            }

        }
        if(hanyszortamadott == 0 && Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop()+1)+"-"+(akiSebez.getSor()+1)))
        {
            if(akiSebez.isJatekosEe() && Ellenorok.vaneOttAIEgyseg((akiSebez.getOszlop()+1)+"-"+(akiSebez.getSor()+1),kor) ){
                for (int i=0;i<kor.size();i++){
                    if(kor.get(i).getEgyseg().getOszlop() == (akiSebez.getOszlop()+1) && kor.get(i).getEgyseg().getSor() == (akiSebez.getSor()+1)){
                        egysegSebezEgysegetKozelrol(akiSebez,kor.get(i).getEgyseg(),hos,hosAkinekAzEgysegetTamadjak,kor,palya);
                        hanyszortamadott++;
                    }
                }

            }
            if(!akiSebez.isJatekosEe() && Ellenorok.vaneOttJatekosEgyseg((akiSebez.getOszlop()+1)+"-"+(akiSebez.getSor()+1),kor)){
                for (int i=0;i<kor.size();i++){
                    if(kor.get(i).getEgyseg().getOszlop() == (akiSebez.getOszlop()+1) && kor.get(i).getEgyseg().getSor() == (akiSebez.getSor()+1)){
                        egysegSebezEgysegetKozelrol(akiSebez,kor.get(i).getEgyseg(),hos,hosAkinekAzEgysegetTamadjak,kor,palya);
                        hanyszortamadott++;
                    }
                }
            }

        }
        if(hanyszortamadott == 0 && Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop()+1)+"-"+(akiSebez.getSor())))
        {
            if(akiSebez.isJatekosEe() && Ellenorok.vaneOttAIEgyseg((akiSebez.getOszlop()+1)+"-"+(akiSebez.getSor()),kor) ){
                for (int i=0;i<kor.size();i++){
                    if(kor.get(i).getEgyseg().getOszlop() == (akiSebez.getOszlop()+1) && kor.get(i).getEgyseg().getSor() == (akiSebez.getSor())){
                        egysegSebezEgysegetKozelrol(akiSebez,kor.get(i).getEgyseg(),hos,hosAkinekAzEgysegetTamadjak,kor,palya);
                        hanyszortamadott++;
                    }
                }

            }
            if(!akiSebez.isJatekosEe() && Ellenorok.vaneOttJatekosEgyseg((akiSebez.getOszlop()+1)+"-"+(akiSebez.getSor()),kor)){
                for (int i=0;i<kor.size();i++){
                    if(kor.get(i).getEgyseg().getOszlop() == (akiSebez.getOszlop()+1) && kor.get(i).getEgyseg().getSor() == (akiSebez.getSor())){
                        egysegSebezEgysegetKozelrol(akiSebez,kor.get(i).getEgyseg(),hos,hosAkinekAzEgysegetTamadjak,kor,palya);
                        hanyszortamadott++;
                    }
                }
            }

        }
        if(hanyszortamadott == 0 && Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop()+1)+"-"+(akiSebez.getSor()-1)))
        {
            if(akiSebez.isJatekosEe() && Ellenorok.vaneOttAIEgyseg((akiSebez.getOszlop()+1)+"-"+(akiSebez.getSor()-1),kor) ){
                for (int i=0;i<kor.size();i++){
                    if(kor.get(i).getEgyseg().getOszlop() == (akiSebez.getOszlop()+1) && kor.get(i).getEgyseg().getSor() == (akiSebez.getSor()-1)){
                        egysegSebezEgysegetKozelrol(akiSebez,kor.get(i).getEgyseg(),hos,hosAkinekAzEgysegetTamadjak,kor,palya);
                        hanyszortamadott++;
                    }
                }

            }
            if(!akiSebez.isJatekosEe() && Ellenorok.vaneOttJatekosEgyseg((akiSebez.getOszlop()+1)+"-"+(akiSebez.getSor()-1),kor)){
                for (int i=0;i<kor.size();i++){
                    if(kor.get(i).getEgyseg().getOszlop() == (akiSebez.getOszlop()+1) && kor.get(i).getEgyseg().getSor() == (akiSebez.getSor()-1)){
                        egysegSebezEgysegetKozelrol(akiSebez,kor.get(i).getEgyseg(),hos,hosAkinekAzEgysegetTamadjak,kor,palya);
                        hanyszortamadott++;
                    }
                }
            }

        }
        if(hanyszortamadott == 0 && Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop())+"-"+(akiSebez.getSor()-1)))
        {
            if(akiSebez.isJatekosEe() && Ellenorok.vaneOttAIEgyseg((akiSebez.getOszlop())+"-"+(akiSebez.getSor()-1),kor) ){
                for (int i=0;i<kor.size();i++){
                    if(kor.get(i).getEgyseg().getOszlop() == (akiSebez.getOszlop()) && kor.get(i).getEgyseg().getSor() == (akiSebez.getSor()-1)){
                        egysegSebezEgysegetKozelrol(akiSebez,kor.get(i).getEgyseg(),hos,hosAkinekAzEgysegetTamadjak,kor,palya);
                        hanyszortamadott++;
                    }
                }

            }
            if(!akiSebez.isJatekosEe() && Ellenorok.vaneOttJatekosEgyseg((akiSebez.getOszlop())+"-"+(akiSebez.getSor()-1),kor)){
                System.out.println("Ai lo roham");
                for (int i=0;i<kor.size();i++){
                    if(kor.get(i).getEgyseg().getOszlop() == (akiSebez.getOszlop()) && kor.get(i).getEgyseg().getSor() == (akiSebez.getSor()-1)){
                        egysegSebezEgysegetKozelrol(akiSebez,kor.get(i).getEgyseg(),hos,hosAkinekAzEgysegetTamadjak,kor,palya);
                        hanyszortamadott++;
                    }
                }
            }

        }
        if(hanyszortamadott == 0 && Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop()-1)+"-"+(akiSebez.getSor()-1)))
        {
            if(akiSebez.isJatekosEe() && Ellenorok.vaneOttAIEgyseg((akiSebez.getOszlop()-1)+"-"+(akiSebez.getSor()-1),kor) ){
                for (int i=0;i<kor.size();i++){
                    if(kor.get(i).getEgyseg().getOszlop() == (akiSebez.getOszlop()-1) && kor.get(i).getEgyseg().getSor() == (akiSebez.getSor()-1)){
                        egysegSebezEgysegetKozelrol(akiSebez,kor.get(i).getEgyseg(),hos,hosAkinekAzEgysegetTamadjak,kor,palya);
                        hanyszortamadott++;
                    }
                }

            }
            if(!akiSebez.isJatekosEe() && Ellenorok.vaneOttJatekosEgyseg((akiSebez.getOszlop()-1)+"-"+(akiSebez.getSor()-1),kor)){
                for (int i=0;i<kor.size();i++){
                    if(kor.get(i).getEgyseg().getOszlop() == (akiSebez.getOszlop()-1) && kor.get(i).getEgyseg().getSor() == (akiSebez.getSor()-1)){
                        egysegSebezEgysegetKozelrol(akiSebez,kor.get(i).getEgyseg(),hos,hosAkinekAzEgysegetTamadjak,kor,palya);
                        hanyszortamadott++;
                    }
                }
            }

        }
        if(hanyszortamadott == 0 && Ellenorok.vaneIlyenKordinata((akiSebez.getOszlop()-1)+"-"+(akiSebez.getSor())))
        {
            if(akiSebez.isJatekosEe() && Ellenorok.vaneOttAIEgyseg((akiSebez.getOszlop()-1)+"-"+(akiSebez.getSor()),kor) ){
                for (int i=0;i<kor.size();i++){
                    if(kor.get(i).getEgyseg().getOszlop() == (akiSebez.getOszlop()-1) && kor.get(i).getEgyseg().getSor() == (akiSebez.getSor())){
                        egysegSebezEgysegetKozelrol(akiSebez,kor.get(i).getEgyseg(),hos,hosAkinekAzEgysegetTamadjak,kor,palya);
                        hanyszortamadott++;
                    }
                }

            }
            if(!akiSebez.isJatekosEe() && Ellenorok.vaneOttJatekosEgyseg((akiSebez.getOszlop()-1)+"-"+(akiSebez.getSor()),kor)){
                for (int i=0;i<kor.size();i++){
                    if(kor.get(i).getEgyseg().getOszlop() == (akiSebez.getOszlop()-1) && kor.get(i).getEgyseg().getSor() == (akiSebez.getSor())){
                        egysegSebezEgysegetKozelrol(akiSebez,kor.get(i).getEgyseg(),hos,hosAkinekAzEgysegetTamadjak,kor,palya);
                        hanyszortamadott++;
                    }
                }
            }

        }

    }

    /**
     * Mindenkit sebez a pályán aki nem démon
     * @param varazslasHelye
     * @param egeszKor a körben benn lévő egységek listálya
     * @param hosAkiVarazsol aki varázsol
     * @param palya amin az egységek vannak
     */
    public static void tulvilagiSebzes(String varazslasHelye, ArrayList<Kor> egeszKor, Hos hosAkiVarazsol, Mezo palya) {
        for (int i=0;i<egeszKor.size();i++){
            if(!egeszKor.get(i).getEgyseg().getEgyseg().getFaj().equals("Demon")){
                int sebzes = hosAkiVarazsol.getVarazsero()*10;
                sebzodes(egeszKor.get(i).getEgyseg(),sebzes);
                System.out.println(ANSI_RED+"A túlvilági átok sebez "+sebzes+" a "+egeszKor.get(i).getEgyseg().getEgyseg().getNev()+ANSI_RESET);
                if(egeszKor.get(i).getEgyseg().getMenyiseg() < 1){
                    System.out.println("Meghalt az egyseg");
                    egysegMeghal(egeszKor.get(i).getEgyseg(), egeszKor, palya);
                }
            }
        }
    }

    /**
     * Az eltalált egységek nem tudnak mozogni két körig
     * @param varazslasHelye ahova a varázslat megy
     * @param egeszKor a körben benn lévő egységek listálya
     * @param palya maga a pálya amin harcolnak
     */
    public static void neted(String varazslasHelye, ArrayList<Kor> egeszKor, Mezo palya){
        String []tomb = varazslasHelye.split("-");

        for (Kor kor : egeszKor) {
            // ball felette */
            if (Ellenorok.vaneIlyenKordinata((Integer.parseInt(tomb[0]) - 1) + "-" + (Integer.parseInt(tomb[1]) - 1))) {
                if (kor.getEgyseg().getOszlop() == (Integer.parseInt(tomb[0]) - 1) && kor.getEgyseg().getSor() == (Integer.parseInt(tomb[1]) - 1)) {
                    kor.getEgyseg().setRootTurns(2);
                    kor.getEgyseg().setCurrentSpeed(0);
                    System.out.println(ANSI_BLUE+kor.getEgyseg().getEgyseg().getNev()+" le lett hálózva."+ANSI_RESET);

                }
            }
            // ball mellette */
            if (Ellenorok.vaneIlyenKordinata((Integer.parseInt(tomb[0])) + "-" + (Integer.parseInt(tomb[1]) - 1))) {
                if (kor.getEgyseg().getOszlop() == (Integer.parseInt(tomb[0])) && kor.getEgyseg().getSor() == (Integer.parseInt(tomb[1]) - 1)) {
                    kor.getEgyseg().setCurrentSpeed(0);
                    kor.getEgyseg().setRootTurns(2);
                    System.out.println(ANSI_BLUE+kor.getEgyseg().getEgyseg().getNev()+" le lett hálózva."+ANSI_RESET);
                }
            }
            // ball alatta */
            if (Ellenorok.vaneIlyenKordinata((Integer.parseInt(tomb[0]) + 1) + "-" + (Integer.parseInt(tomb[1]) - 1))) {
                if (kor.getEgyseg().getOszlop() == (Integer.parseInt(tomb[0]) + 1) && kor.getEgyseg().getSor() == (Integer.parseInt(tomb[1]) - 1)) {
                    kor.getEgyseg().setCurrentSpeed(0);
                    kor.getEgyseg().setRootTurns(2);
                    System.out.println(ANSI_BLUE+kor.getEgyseg().getEgyseg().getNev()+" le lett hálózva."+ANSI_RESET);
                }
            }
            // felette */
            if (Ellenorok.vaneIlyenKordinata((Integer.parseInt(tomb[0]) - 1) + "-" + (Integer.parseInt(tomb[1])))) {
                if (kor.getEgyseg().getOszlop() == (Integer.parseInt(tomb[0]) - 1) && kor.getEgyseg().getSor() == (Integer.parseInt(tomb[1]))) {
                    kor.getEgyseg().setCurrentSpeed(0);
                    kor.getEgyseg().setRootTurns(2);
                    System.out.println(ANSI_BLUE+kor.getEgyseg().getEgyseg().getNev()+" le lett hálózva."+ANSI_RESET);
                }
            }
            // rajta */
            if (Ellenorok.vaneIlyenKordinata((Integer.parseInt(tomb[0])) + "-" + (Integer.parseInt(tomb[1])))) {
                if (kor.getEgyseg().getOszlop() == (Integer.parseInt(tomb[0])) && kor.getEgyseg().getSor() == (Integer.parseInt(tomb[1]))) {
                    kor.getEgyseg().setCurrentSpeed(0);
                    kor.getEgyseg().setRootTurns(2);
                    System.out.println(ANSI_BLUE+kor.getEgyseg().getEgyseg().getNev()+" le lett hálózva."+ANSI_RESET);
                }
            }
            // alatta */
            if (Ellenorok.vaneIlyenKordinata((Integer.parseInt(tomb[0]) + 1) + "-" + (Integer.parseInt(tomb[1])))) {
                if (kor.getEgyseg().getOszlop() == (Integer.parseInt(tomb[0]) + 1) && kor.getEgyseg().getSor() == (Integer.parseInt(tomb[1]))) {
                    kor.getEgyseg().setCurrentSpeed(0);
                    kor.getEgyseg().setRootTurns(2);
                    System.out.println(ANSI_BLUE+kor.getEgyseg().getEgyseg().getNev()+" le lett hálózva."+ANSI_RESET);
                }
            }
            // jobb folotte */
            if (Ellenorok.vaneIlyenKordinata((Integer.parseInt(tomb[0]) - 1) + "-" + (Integer.parseInt(tomb[1]) + 1))) {
                if (kor.getEgyseg().getOszlop() == (Integer.parseInt(tomb[0]) - 1) && kor.getEgyseg().getSor() == (Integer.parseInt(tomb[1]) + 1)) {
                    kor.getEgyseg().setCurrentSpeed(0);
                    kor.getEgyseg().setRootTurns(2);
                    System.out.println(ANSI_BLUE+kor.getEgyseg().getEgyseg().getNev()+" le lett hálózva."+ANSI_RESET);
                }
            }
            // jobb mellette */
            if (Ellenorok.vaneIlyenKordinata((Integer.parseInt(tomb[0])) + "-" + (Integer.parseInt(tomb[1]) + 1))) {
                if (kor.getEgyseg().getOszlop() == (Integer.parseInt(tomb[0])) && kor.getEgyseg().getSor() == (Integer.parseInt(tomb[1]) + 1)) {
                    kor.getEgyseg().setCurrentSpeed(0);
                    kor.getEgyseg().setRootTurns(2);
                    System.out.println(ANSI_BLUE+kor.getEgyseg().getEgyseg().getNev()+" le lett hálózva."+ANSI_RESET);
                }
            }
            // jobb alatta */
            if (Ellenorok.vaneIlyenKordinata((Integer.parseInt(tomb[0]) + 1) + "-" + (Integer.parseInt(tomb[1]) + 1))) {
                if (kor.getEgyseg().getOszlop() == (Integer.parseInt(tomb[0]) + 1) && kor.getEgyseg().getSor() == (Integer.parseInt(tomb[1]) + 1)) {
                    kor.getEgyseg().setCurrentSpeed(0);
                    kor.getEgyseg().setRootTurns(2);
                    System.out.println(ANSI_BLUE+kor.getEgyseg().getEgyseg().getNev()+" le lett hálózva."+ANSI_RESET);
                }
            }
        }
    }
}
