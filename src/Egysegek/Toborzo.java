package Egysegek;

import Kiegeszitok.Ellenorok;

import java.util.ArrayList;

import static Kiegeszitok.Colours.ANSI_RESET;
import static Kiegeszitok.Colours.ANSI_YELLOW;
import static Main.Main.bekero;

/**
 * A játékos innen szerzi az egységeit
 */
public class Toborzo {

     private ArrayList<Egyseg> toborohato = new ArrayList<>();

    public Toborzo() {
        Egyseg foldmuves = new Foldmuves();
        Egyseg ijasz = new Ijasz();
        Egyseg griff = new Griff();
        Egyseg kenntaur = new Kenntaur();
        Egyseg pitfiend = new PitFiend();
        this.toborohato.add(foldmuves);
        this.toborohato.add(ijasz);
        this.toborohato.add(griff);
        this.toborohato.add(kenntaur);
        this.toborohato.add(pitfiend);
    }

    public ArrayList<Egyseg> getToborohato() {
        return toborohato;
    }

    public void toborzas(Hos hos){

        System.out.println("Toborzas: ");
        System.out.println("Ha már nem akarsz tobb eggyseget felberelni akkor írd : (tovabb)");
        boolean joinput = false;
        boolean akarszMegSereget = true;
        String egysegId = "";
        int mennyiseg = 0;
        if(hos.getJatekos().getArany() < 2){
            System.out.println(ANSI_YELLOW+"Nincs elég pénzed seregre de egy Földműves megszán és csatlakozik hozzád:");
            hos.getUnit().add(new Unit(this.toborohato.get(0), 1));
            hos.getBirtokoltUnitok().add(this.toborohato.get(0));
        }else {

            System.out.println("Toborozz harcosokat: ((kívánt egység tipus szama)-(amennyit szeretnél belőlle).pl: (1-15) )");
            do {
                for (int i = 0; i < this.toborohato.size(); i++) {
                    System.out.println("(" + (i + 1) + ")" + this.toborohato.get(i).getNev() + " :. Ár: " + this.toborohato.get(i).getAr());
                }

                if (hos.getUnit().size() == 0) {
                } else {
                    System.out.println("Neked van: ");
                    for (int i = 0; i < hos.getUnit().size(); i++) {
                        System.out.println(hos.getUnit().get(i).getEgyseg().getNev() + ": " + hos.getUnit().get(i).getMenyiseg() + " Sebzesuk: " + hos.getUnit().get(i).getEgysegSebzesLower() + "-" + hos.getUnit().get(i).getEgysegSebzesUpper() + " Egyseg eletereje: " + hos.getUnit().get(i).getEgysegEletero());
                        System.out.println();
                    }
                    System.out.println("Meg van: " + hos.getJatekos().getArany() + " gold.");
                    System.out.println("--------------------");
                }


                String[] toborzasT;
                do {
                    String inputEz;
                    joinput=false;
                    boolean jokommand = false;
                    do {
                        inputEz = bekero.nextLine();
                        String ez[] = inputEz.split("-");
                        if (ez.length == 2 && Ellenorok.isHoleNumber(ez[0]) && Ellenorok.isHoleNumber(ez[1]) && Integer.parseInt(ez[1]) > 0 && ez[0].equals("1") || ez[0].equals("2") || ez[0].equals("3") || ez[0].equals("4") || ez[0].equals("5") || ez[0].equals("tovabb")){
                            jokommand = true;
                        }else{
                            System.out.println(ANSI_YELLOW+"Nincs ilyen kommand! Írj be mást.");
                        }
                    }while (!jokommand);
                     

                    if (inputEz.equals("tovabb")) {
                        akarszMegSereget = false;
                        joinput = true;
                    } else {
                        toborzasT = inputEz.split("");
                        boolean joEazInput = true;
                        for (String s : toborzasT) {
                            if (s.equals("-") || s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5") || s.equals("6") || s.equals("7") || s.equals("8") || s.equals("9") || s.equals("0")) {
                            } else {
                                joEazInput = false;
                                System.out.println("Rossz az input");
                                break;
                            }
                        }

                        toborzasT = inputEz.split("-");
                        if (toborzasT.length != 2) {
                            joEazInput = false;
                        }
                        for (String s : toborzasT) {
                            if (s.equals("")) {
                                joEazInput = false;
                                break;
                            }
                        }

                        // Minden jó

                        if (joEazInput) {
                            egysegId = toborzasT[0];
                            mennyiseg = Integer.parseInt(toborzasT[1]);
                            if (egysegId.equals("1") || egysegId.equals("2") || egysegId.equals("3") || egysegId.equals("4") || egysegId.equals("5")) {
                                joinput = true;
                            }
                        } else {
                            System.out.println(ANSI_YELLOW+"Nincs ilyen kommand! Írj be mást.");
                        }
                    }
                } while (!joinput);
                if (!akarszMegSereget) {

                } else {

                    if (Ellenorok.vanerapenz(this.toborohato.get(Integer.parseInt(egysegId) - 1).getAr(), mennyiseg, hos.getJatekos())) {
                        boolean vanEmarIlyen = false;
                        for (int p = 0; p < hos.getBirtokoltUnitok().size(); p++) {
                            if (hos.getBirtokoltUnitok().get(p).getNev().equals(this.toborohato.get(Integer.parseInt(egysegId) - 1).getNev())) {
                                vanEmarIlyen = true;
                            }
                        }
                        //Van mar ilyen fajta egyseg
                        if (vanEmarIlyen) {
                            for (int h = 0; h < hos.getUnit().size(); h++) {
                                if (hos.getUnit().get(h).getEgyseg().getNev().equals(this.toborohato.get(Integer.parseInt(egysegId) - 1).getNev())) {
                                    hos.getUnit().get(h).LetszamNoveles(mennyiseg);
                                    hos.getJatekos().setArany(hos.getJatekos().getArany() - (this.toborohato.get(Integer.parseInt(egysegId) - 1).getAr() * mennyiseg));
                                }
                            }
                        } else {
                            //Nincs meg ilyen
                            hos.getUnit().add(new Unit(this.toborohato.get(Integer.parseInt(egysegId) - 1), mennyiseg));
                            hos.getBirtokoltUnitok().add(this.toborohato.get(Integer.parseInt(egysegId) - 1));
                            hos.getJatekos().setArany(hos.getJatekos().getArany() - (this.toborohato.get(Integer.parseInt(egysegId) - 1).getAr() * mennyiseg));
                        }
                    }else{
                        System.out.println(ANSI_YELLOW+"Nincs rá elég aranyad!"+ANSI_RESET);
                    }
                }
                if (hos.getUnit().size() == 0) {
                    System.out.println(ANSI_YELLOW+"Nem harcolhatsz sereg nelkul!"+ANSI_RESET);
                    akarszMegSereget = true;
                }
                if (akarszMegSereget) {
                    System.out.println("Toborozz harcosokat: ((kívánt egység tipus szama)-(amennyit szeretnél belőlle).pl: 1-15)");
                }

            } while (akarszMegSereget);
        }
        for (int i=0;i<hos.getUnit().size();i++){
            hos.getUnit().get(i).setJatekosEe(true);
            //System.out.println("Lojalis egysegek: "+hos.getUnit().get(i).isJatekosEe());
        }

    }
}
