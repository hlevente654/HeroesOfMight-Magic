package Egysegek;

import Kiegeszitok.Ellenorok;
import Player.Jatekos;
import Varazslatok.VarazsBolt;
import Varazslatok.Varazslas;

import java.util.ArrayList;

import static Kiegeszitok.Colours.ANSI_RESET;
import static Kiegeszitok.Colours.ANSI_YELLOW;
import static Main.Main.bekero;

/**
 * A hős aki vezeti a sereget
 * rendelkezis saját statisztikákkal akár varázslatokkal is
 */
public class Hos {
    private ArrayList<Varazslas> tanultVarazslatok = new ArrayList<>();
    private ArrayList<Egyseg> birtokoltUnitok = new ArrayList<>();
    private ArrayList<Unit> unit = new ArrayList<>();
    private int tamadas;
    private int vedekezes;
    private int varazsero;
    private int tudas;
    private int moral;
    private int szerencse;
    private Jatekos jatekos;
    private boolean lephetEMegAHos;

    private int mannaPool;

    public Hos(Jatekos jatekos) {
        this.tamadas = 1;
        this.vedekezes = 1;
        this.varazsero = 1;
        this.tudas = 1;
        this.moral = 1;
        this.szerencse = 1;
        this.jatekos = jatekos;
        this.lephetEMegAHos = true;
        this.mannaPool = 0;
    }

    public boolean isLephetEMegAHos() {
        return lephetEMegAHos;
    }

    public void setSzerencse(int szerencse) {
        this.szerencse = szerencse;
    }

    public void setLephetEMegAHos(boolean lephetEMegAHos) {
        this.lephetEMegAHos = lephetEMegAHos;
    }

    public int getMannaPool() {
        return mannaPool;
    }

    public void setMannaPool(int mannaPool) {
        this.mannaPool = mannaPool;
    }

    public int getVedekezes() {
        return vedekezes;
    }


    public int getVarazsero() {
        return varazsero;
    }


    public int getTudas() {
        return tudas;
    }

    public int getMoral() {
        return moral;
    }

    public int getSzerencse() {
        return szerencse;
    }

    public Jatekos getJatekos() {
        return jatekos;
    }

    public ArrayList<Egyseg> getBirtokoltUnitok() {
        return birtokoltUnitok;
    }

    public ArrayList<Unit> getUnit() {
        return unit;
    }

    public void setUnit(ArrayList<Unit> unit) {
        this.unit = unit;
    }

    public ArrayList<Varazslas> getTanultVarazslatok() {
        return tanultVarazslatok;
    }

    public int getTamadas() {
        return tamadas;
    }

    /**AT*/
    public void raseTamadas() { /*tamadast annyival novelem vagy csokkentem*/
        this.tamadas = this.tamadas + 1;
    }
    public void lowerTamadas() { /*tamadast annyival novelem vagy csokkentem*/
        this.tamadas = this.tamadas - 1;
    }

    /**DE*/
    public void raseVedekezes() {
        this.vedekezes = this.vedekezes + 1;
    }
    public void lowerVedekezes() {
        this.vedekezes = this.vedekezes - 1;
    }


    /**MA*/
    public void raseVarazsero(){
        this.varazsero = this.varazsero + 1;
    }
    public void lowerVarazsero(){
        this.varazsero = this.varazsero - 1;
    }


    /**IN*/
    public void raseTudas(){
        this.tudas = this.tudas + 1;
    }
    public void lowerTudas(){
        this.tudas = this.tudas - 1;
    }


    /**LE*/
    public void raseMoral(){
        this.moral = this.moral + 1;
    }
    public void lowerMoral(){
        this.moral = this.moral - 1;
    }

    /**LU*/
    public void raseSzerencse(){
        this.szerencse = this.szerencse + 1;
    }
    public void lowerSzerencse(){
        this.szerencse = this.szerencse - 1;
    }

    public void getAllStats(){
        System.out.println("(AT)Tamadas: "+this.tamadas);
        System.out.println("(DE)Vedekezes: "+this.vedekezes);
        System.out.println("(MA)Varazsero: "+this.varazsero);
        System.out.println("(IN)Tudas: "+this.tudas);
        System.out.println("(LE)Moral: "+this.moral);
        System.out.println("(LU)Szerencse: "+this.szerencse);
    }

    public void hosPontKiosztas(){
        boolean hosPontElosztas = true;
        String pontKiosztasDontes;
        System.out.println("Adj képesség pontot a hősödnek azzal hogy beírod a megfelelő betű kombinációt: Pl: (AT-6)");
        System.out.println("Ha már nem akarsz tobb pontot kiosztani ird be hogy : tovabb");
        this.getAllStats();
        do {
            boolean joKommand = false;
            String []tomb = new String[10];
            do {
                pontKiosztasDontes =  bekero.nextLine();
                if(pontKiosztasDontes.contains("-")){
                    tomb = pontKiosztasDontes.split("-");
                }


                if(pontKiosztasDontes.equals("tovabb")){
                    joKommand = true;
                }
                if(!joKommand){
                    if(tomb.length == 2 && Ellenorok.isHoleNumber(tomb[1])  && Integer.parseInt(tomb[1]) >0 && Integer.parseInt(tomb[1]) < 11){
                        if(tomb[0].equals("AT") || tomb[0].equals("DE") || tomb[0].equals("MA") || tomb[0].equals("IN") || tomb[0].equals("LE") || tomb[0].equals("LU")){
                            joKommand = true;
                        }
                    }
                }

                if(!joKommand){
                    System.out.println(ANSI_YELLOW+"Rossz kommand"+ANSI_RESET);
                }

            }while (!joKommand);

            if(pontKiosztasDontes.equals("tovabb")){
                hosPontElosztas = false;
            }else{
                if(tomb[0].equals("AT")){
                    if(!Ellenorok.lehetNovelni(this.tamadas, jatekos, Integer.parseInt(tomb[1]))){
                        System.out.println("Ezt a statisztikát nem tudod novelni!");
                    }else{
                        int ertek = this.tamadas;
                        if(ertek < Integer.parseInt(tomb[1])){
                            for (;ertek< Integer.parseInt(tomb[1]);ertek++) {
                                this.raseTamadas();
                            }
                        }else if(ertek > Integer.parseInt(tomb[1])){
                            int ezmost = Integer.parseInt(tomb[1]);
                            for (;ezmost<ertek ;ezmost++) {
                                this.lowerTamadas();
                            }
                        }

                    }
                }
                if(tomb[0].equals("DE")){
                    if(!Ellenorok.lehetNovelni(this.vedekezes, jatekos, Integer.parseInt(tomb[1]))){
                        System.out.println(ANSI_YELLOW+"Ezt a statisztikát nem tudod novelni!"+ANSI_RESET);
                    }else{
                        int ertek = this.vedekezes;
                        if(ertek < Integer.parseInt(tomb[1])){
                            for (;ertek< Integer.parseInt(tomb[1]);ertek++) {
                                this.raseVedekezes();
                            }
                        }else if(ertek > Integer.parseInt(tomb[1])){
                            int ezmost = Integer.parseInt(tomb[1]);
                            for (;ezmost<ertek ;ezmost++) {
                                this.lowerVedekezes();
                            }
                        }

                    }
                }
                if(tomb[0].equals("MA")){
                    if(!Ellenorok.lehetNovelni(this.varazsero, jatekos, Integer.parseInt(tomb[1]))){
                        System.out.println(ANSI_YELLOW+"Ezt a statisztikát nem tudod novelni!"+ANSI_RESET);
                    }else{
                        int ertek = this.varazsero;
                        if(ertek < Integer.parseInt(tomb[1])){
                            for (;ertek< Integer.parseInt(tomb[1]);ertek++) {
                                this.raseVarazsero();
                            }
                        }else if(ertek > Integer.parseInt(tomb[1])){
                            int ezmost = Integer.parseInt(tomb[1]);
                            for (;ezmost<ertek ;ezmost++) {
                                this.lowerVarazsero();
                            }
                        }

                    }
                }
                if(tomb[0].equals("IN")){
                    if(!Ellenorok.lehetNovelni(this.tudas, jatekos, Integer.parseInt(tomb[1]))){
                        System.out.println(ANSI_YELLOW+"Ezt a statisztikát nem tudod novelni!"+ANSI_RESET);
                    }else{
                        int ertek = this.tudas;
                        if(ertek < Integer.parseInt(tomb[1])){
                            for (;ertek< Integer.parseInt(tomb[1]);ertek++) {
                                this.raseTudas();
                            }
                        }else if(ertek > Integer.parseInt(tomb[1])){
                            int ezmost = Integer.parseInt(tomb[1]);
                            for (;ezmost<ertek ;ezmost++) {
                                this.lowerTudas();
                            }
                        }

                    }
                }
                if(tomb[0].equals("LE")){
                    if(!Ellenorok.lehetNovelni(this.moral, jatekos, Integer.parseInt(tomb[1]))){
                        System.out.println(ANSI_YELLOW+"Ezt a statisztikát nem tudod novelni!"+ANSI_RESET);
                    }else{
                        int ertek = this.moral;
                        if(ertek < Integer.parseInt(tomb[1])){
                            for (;ertek< Integer.parseInt(tomb[1]);ertek++) {
                                this.raseMoral();
                            }
                        }else if(ertek > Integer.parseInt(tomb[1])){
                            int ezmost = Integer.parseInt(tomb[1]);
                            for (;ezmost<ertek ;ezmost++) {
                                this.lowerMoral();
                            }
                        }

                    }
                }
                if(tomb[0].equals("LU")){
                    if(!Ellenorok.lehetNovelni(this.szerencse, jatekos, Integer.parseInt(tomb[1]))){
                        System.out.println(ANSI_YELLOW+"Ezt a statisztikát nem tudod novelni!"+ANSI_RESET);
                    }else{
                        int ertek = this.szerencse;
                        if(ertek < Integer.parseInt(tomb[1])){
                            for (;ertek< Integer.parseInt(tomb[1]);ertek++) {
                                this.raseSzerencse();
                            }
                        }else if(ertek > Integer.parseInt(tomb[1])){
                            int ezmost = Integer.parseInt(tomb[1]);
                            for (;ezmost<ertek ;ezmost++) {
                                this.lowerSzerencse();
                            }
                        }

                    }
                }
                }
                System.out.println("-------------------------------------------------------");
                System.out.println("Jelenleg van: "+jatekos.getArany()+" goldod.");
                this.getAllStats();
        }while (hosPontElosztas);
        System.out.println("-------------------------------------------------------");
        VarazsBolt vBolt = new VarazsBolt();
        vBolt.VarazsBazar(this);
        Toborzo toborzo = new Toborzo();
        toborzo.toborzas(this);
    }

}
