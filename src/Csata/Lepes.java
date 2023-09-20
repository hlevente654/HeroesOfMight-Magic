package Csata;

import CsataMezo.HosCselekvesek;
import CsataMezo.Kor;
import CsataMezo.Mezo;
import Egysegek.Unit;
import Kiegeszitok.Ellenorok;
import Egysegek.Hos;

import static Kiegeszitok.Colours.ANSI_RESET;
import static Kiegeszitok.Colours.ANSI_YELLOW;
import static Main.Main.bekero;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Itt lépnek mind a játékos mind a gép egységei, legyen az mozgás, támadás, várakozás vagy varázslás.
 */
public class Lepes {

    public static void  JatekosEGysegTavolTamad(Mezo palya, Unit egyseg, ArrayList<Kor> egeszKor,Hos hos, Hos ellenfelhos){
        // Itt tartunk */
        System.out.println("Hova akarsz tamadni? Pl: 1-1 en levo egysegggel tamadod a 2-2-n levo ellenfelet akkor írd be (2-2)");
        String input;
        boolean joInput = false;
        boolean vanOttEllenfel = false;
        String [] tomb;
        do {
            joInput = false;
            vanOttEllenfel = false;
            input = bekero.nextLine();
            tomb = input.split("-");
            if(tomb.length == 2){
                if(tomb[0].equals("1") || tomb[0].equals("2") || tomb[0].equals("3") || tomb[0].equals("4") || tomb[0].equals("5") || tomb[0].equals("6") || tomb[0].equals("7") || tomb[0].equals("8") || tomb[0].equals("9") || tomb[0].equals("10") ){
                    if(tomb[1].equals("1") || tomb[1].equals("2") || tomb[1].equals("3") || tomb[1].equals("4") || tomb[1].equals("5") || tomb[1].equals("6") || tomb[1].equals("7") || tomb[1].equals("8") || tomb[1].equals("9") || tomb[1].equals("10") || tomb[1].equals("11") || tomb[1].equals("12") ){
                        joInput = true;
                    }
                }
            }

            for (int i=0;i< egeszKor.size();i++) {
                if (egeszKor.get(i).getEgyseg().getOszlop() == Integer.parseInt(tomb[0]) && egeszKor.get(i).getEgyseg().getSor() == Integer.parseInt(tomb[1])) {
                    if (egeszKor.get(i).getEgyseg().isJatekosEe() == false){
                        vanOttEllenfel = true;
                    }
                }
            }
            boolean kozelVan = false;
            if(joInput == true){
                if( (Integer.parseInt(tomb[0])+1) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])+1) == egyseg.getSor()  ){kozelVan =true;}
                if( (Integer.parseInt(tomb[0])) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])+1) == egyseg.getSor()  ){kozelVan =true;}
                if( (Integer.parseInt(tomb[0])-1) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])+1) == egyseg.getSor()  ){kozelVan =true;}
                if( (Integer.parseInt(tomb[0])+1) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])) == egyseg.getSor()  ){kozelVan =true;}
                if( (Integer.parseInt(tomb[0])-1) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])) == egyseg.getSor()  ){kozelVan =true;}
                if( (Integer.parseInt(tomb[0])) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])-1) == egyseg.getSor()  ){kozelVan =true;}
                if( (Integer.parseInt(tomb[0])+1) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])-1) == egyseg.getSor()  ){kozelVan =true;}
                if( (Integer.parseInt(tomb[0])-1) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])-1) == egyseg.getSor()  ){kozelVan =true;}
            }

            if(vanOttEllenfel == false){joInput = false;}
            if(kozelVan == true){joInput = false;}
            if(joInput == false){System.out.println(ANSI_YELLOW+"Rossz parancs"+ANSI_RESET);}
        }while (joInput == false);

        for (int i=0;i< egeszKor.size();i++){
            if(egeszKor.get(i).getEgyseg().getOszlop() == Integer.parseInt(tomb[0]) && egeszKor.get(i).getEgyseg().getSor() == Integer.parseInt(tomb[1])) {
                String ez = palya.getMezoAdottEleme(egeszKor.get(i).getEgyseg().getOszlop(), egeszKor.get(i).getEgyseg().getSor());
                boolean ezMostJo = false;
                do {
                    if (!ez.equals("0") && egeszKor.get(i).getEgyseg().isJatekosEe() == false) {
                        ezMostJo = true;
                        System.out.println("Van itt ellenseges egyseg");
                        System.out.println("Innen tamad: " + egyseg.getOszlop() + " : " + egyseg.getSor() + " Ide: " + tomb[0] + " : " + tomb[1]);
                        System.out.println("Lo");
                        Sebzes.egysegSebezEgysegetTavolrol(egyseg, egeszKor.get(i).getEgyseg(), hos, ellenfelhos, egeszKor, palya);

                    }
                }while (ezMostJo == false);
            }
        }


    }
    public static void JatekosEGysegKozelTamad(Mezo palya, Unit egyseg, ArrayList<Kor> egeszKor,Hos hos, Hos ellenfelhos ){
        System.out.println("Hova akarsz tamadni? Pl: 1-1 en levo egysegggel tamadod a 2-2-n levo ellenfelet akkor írd be (2-2)");
        String input;
        boolean joInput = false;
        boolean vanOttEllenfel = false;
        String [] tomb;
        do {
            joInput = false;
            vanOttEllenfel = false;
            input = bekero.nextLine();
            tomb = input.split("-");
            if(tomb.length == 2){
                if(tomb[0].equals("1") || tomb[0].equals("2") || tomb[0].equals("3") || tomb[0].equals("4") || tomb[0].equals("5") || tomb[0].equals("6") || tomb[0].equals("7") || tomb[0].equals("8") || tomb[0].equals("9") || tomb[0].equals("10") ){
                    if(tomb[1].equals("1") || tomb[1].equals("2") || tomb[1].equals("3") || tomb[1].equals("4") || tomb[1].equals("5") || tomb[1].equals("6") || tomb[1].equals("7") || tomb[1].equals("8") || tomb[1].equals("9") || tomb[1].equals("10") || tomb[1].equals("11") || tomb[1].equals("12") ){
                        joInput = true;
                    }
                }
            }

            for (int i=0;i< egeszKor.size();i++) {
                if (egeszKor.get(i).getEgyseg().getOszlop() == Integer.parseInt(tomb[0]) && egeszKor.get(i).getEgyseg().getSor() == Integer.parseInt(tomb[1])) {
                    if (egeszKor.get(i).getEgyseg().isJatekosEe() == false){
                        vanOttEllenfel = true;
                    }
                }
            }
            boolean kozelVan = false;
            if(joInput == true){
                if( (Integer.parseInt(tomb[0])+1) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])+1) == egyseg.getSor()  ){kozelVan =true;}
                if( (Integer.parseInt(tomb[0])) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])+1) == egyseg.getSor()  ){kozelVan =true;}
                if( (Integer.parseInt(tomb[0])-1) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])+1) == egyseg.getSor()  ){kozelVan =true;}
                if( (Integer.parseInt(tomb[0])+1) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])) == egyseg.getSor()  ){kozelVan =true;}
                if( (Integer.parseInt(tomb[0])-1) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])) == egyseg.getSor()  ){kozelVan =true;}
                if( (Integer.parseInt(tomb[0])) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])-1) == egyseg.getSor()  ){kozelVan =true;}
                if( (Integer.parseInt(tomb[0])+1) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])-1) == egyseg.getSor()  ){kozelVan =true;}
                if( (Integer.parseInt(tomb[0])-1) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])-1) == egyseg.getSor()  ){kozelVan =true;}
            }

            if(vanOttEllenfel == false){joInput = false;}
            if(kozelVan == false){joInput = false;}
            if(joInput == false){System.out.println(ANSI_YELLOW+"Rossz parancs"+ANSI_RESET);}
        }while (joInput == false);

        for (int i=0;i< egeszKor.size();i++){
            if(egeszKor.get(i).getEgyseg().getOszlop() == Integer.parseInt(tomb[0]) && egeszKor.get(i).getEgyseg().getSor() == Integer.parseInt(tomb[1])){
                String ez = palya.getMezoAdottEleme(egeszKor.get(i).getEgyseg().getOszlop(),egeszKor.get(i).getEgyseg().getSor());
                boolean ezMostJo = false;
                do {
                    if(!ez.equals("0") && egeszKor.get(i).getEgyseg().isJatekosEe() == false){
                        ezMostJo = true;
                        System.out.println("Van itt ellenseges egyseg");
                        System.out.println(tomb[0]+" "+tomb[1]+" : "+egyseg.getOszlop()+" "+egyseg.getSor());
                        if( (Integer.parseInt(tomb[0])+1) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])+1) == egyseg.getSor()  ){
                            System.out.println("Sebez");
                            Sebzes.egysegSebezEgysegetKozelrol(egyseg, egeszKor.get(i).getEgyseg(), hos, ellenfelhos, egeszKor, palya);
                        }
                        if( (Integer.parseInt(tomb[0])) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])+1) == egyseg.getSor()  ){
                            Sebzes.egysegSebezEgysegetKozelrol(egyseg, egeszKor.get(i).getEgyseg(), hos, ellenfelhos, egeszKor, palya);
                            System.out.println("Sebez");
                        }
                        if( (Integer.parseInt(tomb[0])-1) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])+1) == egyseg.getSor()  ){
                            Sebzes.egysegSebezEgysegetKozelrol(egyseg, egeszKor.get(i).getEgyseg(), hos, ellenfelhos, egeszKor, palya);
                            System.out.println("Sebez");
                        }
                        if( (Integer.parseInt(tomb[0])+1) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])) == egyseg.getSor()  ){
                            Sebzes.egysegSebezEgysegetKozelrol(egyseg, egeszKor.get(i).getEgyseg(), hos, ellenfelhos, egeszKor, palya);
                            System.out.println("Sebez");
                        }
                        if( (Integer.parseInt(tomb[0])-1) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])) == egyseg.getSor()  ){
                            Sebzes.egysegSebezEgysegetKozelrol(egyseg, egeszKor.get(i).getEgyseg(), hos, ellenfelhos, egeszKor, palya);
                            System.out.println("Sebez");
                        }
                        if( (Integer.parseInt(tomb[0])) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])-1) == egyseg.getSor()  ){
                            Sebzes.egysegSebezEgysegetKozelrol(egyseg, egeszKor.get(i).getEgyseg(), hos, ellenfelhos, egeszKor, palya);
                            System.out.println("Sebez");
                        }
                        if( (Integer.parseInt(tomb[0])+1) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])-1) == egyseg.getSor()  ){
                            Sebzes.egysegSebezEgysegetKozelrol(egyseg, egeszKor.get(i).getEgyseg(), hos, ellenfelhos, egeszKor, palya);
                            System.out.println("Sebez");
                        }
                        if( (Integer.parseInt(tomb[0])-1) == egyseg.getOszlop() &&  (Integer.parseInt(tomb[1])-1) == egyseg.getSor()  ){
                            Sebzes.egysegSebezEgysegetKozelrol(egyseg, egeszKor.get(i).getEgyseg(), hos, ellenfelhos, egeszKor, palya);
                            System.out.println("Sebez");
                        }
                    }else {
                        System.out.println("Itt nincs semmi amit tamadni tudnal.");
                    }
                }while (ezMostJo == false);

            }
        }




    }
    public static void JatekosEGysegLep(Mezo palya, Unit egyseg,Hos jatekosHos,Hos aiHos,ArrayList<Kor> teljesKor){
        System.out.println("Írd be hogy hova akarsz lepni: ");
        System.out.println("Pl: az 1-1 mezorol a 2-4 es mezőre akarszmenni akkor ird be (2-4)");
        int lepeszam = egyseg.getEgyseg().getSebesseg();
       String input = "";
       boolean joInput = false;
        do {
            input ="";
            input = bekero.nextLine();
            if(Ellenorok.vaneIlyenKordinata(input) == true && Ellenorok.vaneOttAIEgyseg(input,teljesKor) == false && Ellenorok.vaneOttJatekosEgyseg(input,teljesKor) == false){
            joInput = true;
            }
            if(joInput == false){
                System.out.println(ANSI_YELLOW+"Rossz input"+ANSI_RESET);
            }
        }while (joInput == false);
        String []tomb = input.split("-");
        int celOszlop = Integer.parseInt(tomb[0]);
        int celSor = Integer.parseInt(tomb[1]);
        String elozoPziciodHelye = " ";

        boolean megalhat = false;
        out:
        do {
            // Ha a cél tolled fentebb és jobbrább van */
            if(celOszlop < egyseg.getOszlop() && celSor > egyseg.getSor() && lepeszam >0){

                    if(!elozoPziciodHelye.contains((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor() + 1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor() + 1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor() + 1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor() + 1), teljesKor)){
                        System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                        palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                        palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                        elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                        egyseg.setOszlop(egyseg.getOszlop()-1);
                        egyseg.setSor(egyseg.getSor()+1);
                        palya.frissitettPalya(teljesKor);
                        System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    }else if (!elozoPziciodHelye.contains((egyseg.getOszlop()) + "-" + (egyseg.getSor() + 1)) &&  Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()) + "-" + (egyseg.getSor() + 1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()) + "-" + (egyseg.getSor() + 1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()) + "-" + (egyseg.getSor() + 1), teljesKor)){
                        // van valaki az útban akkor menny jobbra */
                        System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                        palya.setMezo(egyseg.getOszlop(),egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                        palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                        elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                        egyseg.setOszlop(egyseg.getOszlop());
                        egyseg.setSor(egyseg.getSor()+1);
                        palya.frissitettPalya(teljesKor);
                        System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    }else if(!elozoPziciodHelye.contains((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor() )) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()-1) + "-" + (egyseg.getSor())) && Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()-1)+"-"+(egyseg.getSor()),teljesKor) == false && Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()-1)+"-"+(egyseg.getSor()),teljesKor) == false){
                        // Ha jobbra is van valaki akkor menny fel */
                        System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                        palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor(),egyseg.getEgyseg().getMarker());
                        palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                        elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                        egyseg.setOszlop(egyseg.getOszlop()-1);
                        egyseg.setSor(egyseg.getSor());
                        palya.frissitettPalya(teljesKor);
                        System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    }else if(!elozoPziciodHelye.contains((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor() + 1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()+1) + "-" + (egyseg.getSor()+1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor() + 1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor() + 1), teljesKor)){
                        // Ha fel sem lehet menni mennyen jobbra le */
                        System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                        palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                        palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                        elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                        egyseg.setOszlop(egyseg.getOszlop()+1);
                        egyseg.setSor(egyseg.getSor()+1);
                        palya.frissitettPalya(teljesKor);
                        System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    }else if(!elozoPziciodHelye.contains((egyseg.getOszlop() +1) + "-" + (egyseg.getSor() )) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()+1) + "-" + (egyseg.getSor())) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor()), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor()), teljesKor)){
                        // Ha jobbra le sem lehet menni akkor mennyen le */
                        System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                        palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor(),egyseg.getEgyseg().getMarker());
                        palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                        elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                        egyseg.setOszlop(egyseg.getOszlop()+1);
                        egyseg.setSor(egyseg.getSor());
                        palya.frissitettPalya(teljesKor);
                        System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    }else if(!elozoPziciodHelye.contains((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor() - 1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()-1) + "-" + (egyseg.getSor()-1)) && Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()-1)+"-"+(egyseg.getSor()-1),teljesKor) == false && Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()-1)+"-"+(egyseg.getSor()-1),teljesKor) == false){
                        // Ha le sem lehet menni mennyen ball fel */
                        System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                        palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                        palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                        elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                        egyseg.setOszlop(egyseg.getOszlop()-1);
                        egyseg.setSor(egyseg.getSor()-1);
                        palya.frissitettPalya(teljesKor);
                        System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    }else if(!elozoPziciodHelye.contains((egyseg.getOszlop() ) + "-" + (egyseg.getSor() - 1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()) + "-" + (egyseg.getSor()-1)) && Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop())+"-"+(egyseg.getSor()-1),teljesKor) == false && Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop())+"-"+(egyseg.getSor()-1),teljesKor) == false){
                        // Ha ball fel sem tud menni mennyen ballra */
                        System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                        palya.setMezo(egyseg.getOszlop(),egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                        palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                        elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                        egyseg.setOszlop(egyseg.getOszlop());
                        egyseg.setSor(egyseg.getSor()-1);
                        palya.frissitettPalya(teljesKor);
                        System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    }else if(!elozoPziciodHelye.contains((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor() - 1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()+1) + "-" + (egyseg.getSor()-1)) && Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()+1)+"-"+(egyseg.getSor()-1),teljesKor) == false && Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()+1)+"-"+(egyseg.getSor()-1),teljesKor) == false){
                        // Ha ballra sem tud menni mennyen ball le */
                        System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                        palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                        palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                        elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                        egyseg.setOszlop(egyseg.getOszlop()+1);
                        egyseg.setSor(egyseg.getSor()-1);
                        palya.frissitettPalya(teljesKor);
                        System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    }else {
                        System.out.println("Be vagy szorulva nem tudsz lepni");
                        break out;
                    }
                lepeszam--;
            }

            // Ha a cél tolled lenntebb és jobbrább van */
            if(celOszlop > egyseg.getOszlop() && celSor > egyseg.getSor() && lepeszam >0){

                if(!elozoPziciodHelye.contains((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor() + 1)) &&Ellenorok.vaneIlyenKordinata((egyseg.getOszlop() +1) + "-" + (egyseg.getSor() +1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor() + 1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor() + 1), teljesKor)){
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()+1);
                    egyseg.setSor(egyseg.getSor()+1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if (!elozoPziciodHelye.contains((egyseg.getOszlop() ) + "-" + (egyseg.getSor() + 1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()) + "-" + (egyseg.getSor() + 1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()) + "-" + (egyseg.getSor() + 1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()) + "-" + (egyseg.getSor() + 1), teljesKor)){
                    // van valaki az útban akkor menny jobbra */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop());
                    egyseg.setSor(egyseg.getSor()+1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor() )) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()+1) + "-" + (egyseg.getSor())) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor()), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor()), teljesKor)){
                    // Ha jobbra is van valaki akkor menny le */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor(),egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()+1);
                    egyseg.setSor(egyseg.getSor());
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor() + 1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()-1) + "-" + (egyseg.getSor()+1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor() + 1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor() + 1), teljesKor)){
                    // Ha le sem lehet menni akkor mennyen jobb fel */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()-1);
                    egyseg.setSor(egyseg.getSor()+1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor() - 1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()+1) + "-" + (egyseg.getSor()-1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor() - 1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor() - 1), teljesKor)){
                    // Ha jobbra fel sem lehet menni mennyen ball le */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()+1);
                    egyseg.setSor(egyseg.getSor()-1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop() -1) + "-" + (egyseg.getSor() )) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()-1) + "-" + (egyseg.getSor())) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor()), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor()), teljesKor)){
                    // Ha ball le sem tud menni mennyen fel */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor(),egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()-1);
                    egyseg.setSor(egyseg.getSor());
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()) + "-" + (egyseg.getSor() - 1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()) + "-" + (egyseg.getSor()-1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()) + "-" + (egyseg.getSor() - 1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()) + "-" + (egyseg.getSor() - 1), teljesKor)){
                    // Ha fel sem tud menni mennyen ballra */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop());
                    egyseg.setSor(egyseg.getSor()-1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop() -1) + "-" + (egyseg.getSor() - 1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()-1) + "-" + (egyseg.getSor()-1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()-1) + "-" + (egyseg.getSor() - 1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()-1) + "-" + (egyseg.getSor() - 1), teljesKor)){
                    // Ha fel sem lehet menni mannyen ballra fel */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()-1);
                    egyseg.setSor(egyseg.getSor()-1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else  {
                    System.out.println("Be vagy szorulva nem tudsz lepni");
                    break out;
                }
                lepeszam--;
            }

            // Ha a cél tolled egy szintben jobbrabb van */
            if(celOszlop == egyseg.getOszlop() && celSor > egyseg.getSor() && lepeszam >0){

                if(!elozoPziciodHelye.contains((egyseg.getOszlop()) + "-" + (egyseg.getSor() + 1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop() ) + "-" + (egyseg.getSor() +1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() ) + "-" + (egyseg.getSor() + 1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() ) + "-" + (egyseg.getSor() + 1), teljesKor)){
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop());
                    egyseg.setSor(egyseg.getSor()+1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if (!elozoPziciodHelye.contains((egyseg.getOszlop() -1) + "-" + (egyseg.getSor() + 1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()-1) + "-" + (egyseg.getSor() + 1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()-1) + "-" + (egyseg.getSor() + 1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()-1) + "-" + (egyseg.getSor() + 1), teljesKor)){
                    // van valaki az útban akkor menny jobbra fel */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()-1);
                    egyseg.setSor(egyseg.getSor()+1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop() +1) + "-" + (egyseg.getSor()+ 1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()+1) + "-" + (egyseg.getSor()+1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor()+1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor()+1), teljesKor)){
                    // Ha jobbra fel is van valaki akkor menny jobbra le */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()+1);
                    egyseg.setSor(egyseg.getSor()+1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop() -1) + "-" + (egyseg.getSor() )) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()-1) + "-" + (egyseg.getSor())) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor() ), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor() ), teljesKor)){
                    // Ha jobbra le sem lehet menni akkor mennyen fel */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor(),egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()-1);
                    egyseg.setSor(egyseg.getSor());
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop() +1) + "-" + (egyseg.getSor() )) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()+1) + "-" + (egyseg.getSor())) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor() ), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor() ), teljesKor)){
                    // Ha fel sem lehet menni mennyen le */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor(),egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()+1);
                    egyseg.setSor(egyseg.getSor());
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop() -1) + "-" + (egyseg.getSor() - 1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()-1) + "-" + (egyseg.getSor()-1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor()-1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor()-1), teljesKor)){
                    // Ha le sem tud menni mennyen ballra fel */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()-1);
                    egyseg.setSor(egyseg.getSor()-1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop() +1) + "-" + (egyseg.getSor() - 1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()+1) + "-" + (egyseg.getSor()-1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()+1) + "-" + (egyseg.getSor() - 1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()+1) + "-" + (egyseg.getSor() - 1), teljesKor)){
                    // Ha ballra fel sem tud menni mennyen ballra le */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()+1);
                    egyseg.setSor(egyseg.getSor()-1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()) + "-" + (egyseg.getSor() - 1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()) + "-" + (egyseg.getSor()-1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()) + "-" + (egyseg.getSor() - 1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()) + "-" + (egyseg.getSor() - 1), teljesKor)){
                    // Ha ballra le sem lehet menni mannyen ballra  */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop());
                    egyseg.setSor(egyseg.getSor()-1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else  {
                    System.out.println("Be vagy szorulva nem tudsz lepni");
                    break out;
                }
                lepeszam--;
            }

            // Ha a cél feletted van */
            if(celOszlop < egyseg.getOszlop() && celSor == egyseg.getSor() && lepeszam >0){

                if(!elozoPziciodHelye.contains((egyseg.getOszlop()-1) + "-" + (egyseg.getSor() )) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop() -1) + "-" + (egyseg.getSor() )) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()-1 ) + "-" + (egyseg.getSor() ), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()-1 ) + "-" + (egyseg.getSor() ), teljesKor)){
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor(),egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()-1);
                    egyseg.setSor(egyseg.getSor());
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if (!elozoPziciodHelye.contains((egyseg.getOszlop()-1) + "-" + (egyseg.getSor() + 1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()-1) + "-" + (egyseg.getSor() + 1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()-1) + "-" + (egyseg.getSor() + 1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()-1) + "-" + (egyseg.getSor() + 1), teljesKor)){
                    // van valaki az útban akkor menny jobbra fel */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()-1);
                    egyseg.setSor(egyseg.getSor()+1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()-1) + "-" + (egyseg.getSor() - 1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()-1) + "-" + (egyseg.getSor()-1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor()-1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor()-1), teljesKor)){
                    // Ha jobbra fel is van valaki akkor menny ballra fel */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()-1);
                    egyseg.setSor(egyseg.getSor()-1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()) + "-" + (egyseg.getSor() + 1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()) + "-" + (egyseg.getSor()+1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() ) + "-" + (egyseg.getSor()+1 ), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() ) + "-" + (egyseg.getSor()+1 ), teljesKor)){
                    // Ha ballra fel sem lehet menni akkor mennyen jobbra */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop());
                    egyseg.setSor(egyseg.getSor()+1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()) + "-" + (egyseg.getSor() - 1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()) + "-" + (egyseg.getSor()-1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() ) + "-" + (egyseg.getSor()-1 ), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() ) + "-" + (egyseg.getSor()-1 ), teljesKor)){
                    // Ha jobbra sem lehet menni mennyen ballra */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop());
                    egyseg.setSor(egyseg.getSor()-1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()+1) + "-" + (egyseg.getSor() + 1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()+1) + "-" + (egyseg.getSor()+1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor()+1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor()+1), teljesKor)){
                    // Ha ballra sem tud menni mennyen jobbra le */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()+1);
                    egyseg.setSor(egyseg.getSor()+1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()+1) + "-" + (egyseg.getSor() - 1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()+1) + "-" + (egyseg.getSor()-1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()+1) + "-" + (egyseg.getSor() - 1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()+1) + "-" + (egyseg.getSor() - 1), teljesKor)){
                    // Ha jobbra le sem tud menni mennyen ballra le */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()+1);
                    egyseg.setSor(egyseg.getSor()-1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()+1) + "-" + (egyseg.getSor())) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()+1) + "-" + (egyseg.getSor())) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()+1) + "-" + (egyseg.getSor() ), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()+1) + "-" + (egyseg.getSor() ), teljesKor)){
                    // Ha ballra le sem lehet menni mannyen le  */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor(),egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()+1);
                    egyseg.setSor(egyseg.getSor());
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else  {
                    System.out.println("Be vagy szorulva nem tudsz lepni");
                    break out;
                }
                lepeszam--;
            }

            // Ha a cél alattad van */
            if(celOszlop > egyseg.getOszlop() && celSor == egyseg.getSor() && lepeszam >0){

                if(!elozoPziciodHelye.contains((egyseg.getOszlop()+1) + "-" + (egyseg.getSor())) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop() +1) + "-" + (egyseg.getSor() )) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()+1 ) + "-" + (egyseg.getSor() ), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()+1 ) + "-" + (egyseg.getSor() ), teljesKor)){
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor(),egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()+1);
                    egyseg.setSor(egyseg.getSor());
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if (!elozoPziciodHelye.contains((egyseg.getOszlop()+1) + "-" + (egyseg.getSor()+1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()+1) + "-" + (egyseg.getSor() + 1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()+1) + "-" + (egyseg.getSor() + 1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()+1) + "-" + (egyseg.getSor() + 1), teljesKor)){
                    // van valaki az útban akkor menny jobbra le */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()+1);
                    egyseg.setSor(egyseg.getSor()+1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()+1) + "-" + (egyseg.getSor()-1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()+1) + "-" + (egyseg.getSor()-1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor()-1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor()-1), teljesKor)){
                    // Ha jobbra le is van valaki akkor menny ballra le */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()+1);
                    egyseg.setSor(egyseg.getSor()-1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()) + "-" + (egyseg.getSor()+1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()) + "-" + (egyseg.getSor()+1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() ) + "-" + (egyseg.getSor()+1 ), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() ) + "-" + (egyseg.getSor()+1 ), teljesKor)){
                    // Ha ballra le sem lehet menni akkor mennyen jobbra */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop());
                    egyseg.setSor(egyseg.getSor()+1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()) + "-" + (egyseg.getSor()-1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()) + "-" + (egyseg.getSor()-1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() ) + "-" + (egyseg.getSor()-1 ), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() ) + "-" + (egyseg.getSor()-1 ), teljesKor)){
                    // Ha jobbra sem lehet menni mennyen ballra */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop());
                    egyseg.setSor(egyseg.getSor()-1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()-1) + "-" + (egyseg.getSor()+1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()-1) + "-" + (egyseg.getSor()+1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor()+1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor()+1), teljesKor)){
                    // Ha ballra sem tud menni mennyen jobbra fel */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()-1);
                    egyseg.setSor(egyseg.getSor()+1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()-1) + "-" + (egyseg.getSor()-1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()-1) + "-" + (egyseg.getSor()-1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()-1) + "-" + (egyseg.getSor() - 1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()-1) + "-" + (egyseg.getSor() - 1), teljesKor)){
                    // Ha jobbra fel sem tud menni mennyen ballra fel */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()-1);
                    egyseg.setSor(egyseg.getSor()-1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()-1) + "-" + (egyseg.getSor())) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()-1) + "-" + (egyseg.getSor())) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()-1) + "-" + (egyseg.getSor() ), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()-1) + "-" + (egyseg.getSor() ), teljesKor)){
                    // Ha ballra fel sem lehet menni mannyen fel  */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor(),egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()-1);
                    egyseg.setSor(egyseg.getSor());
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else  {
                    System.out.println("Be vagy szorulva nem tudsz lepni");
                    break out;
                }
                lepeszam--;
            }

            // Ha a cél tolled egy szintben ballra van */
            if(celOszlop == egyseg.getOszlop() && celSor < egyseg.getSor() && lepeszam >0){

                if(!elozoPziciodHelye.contains((egyseg.getOszlop()) + "-" + (egyseg.getSor()-1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop() ) + "-" + (egyseg.getSor()-1 )) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() ) + "-" + (egyseg.getSor()-1 ), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() ) + "-" + (egyseg.getSor()-1 ), teljesKor)){
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop());
                    egyseg.setSor(egyseg.getSor()-1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if (!elozoPziciodHelye.contains((egyseg.getOszlop()-1) + "-" + (egyseg.getSor()-1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()-1) + "-" + (egyseg.getSor() - 1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()-1) + "-" + (egyseg.getSor() - 1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()-1) + "-" + (egyseg.getSor() - 1), teljesKor)){
                    // van valaki az útban akkor menny ballra fel */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()-1);
                    egyseg.setSor(egyseg.getSor()-1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()+1) + "-" + (egyseg.getSor()-1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()+1) + "-" + (egyseg.getSor()-1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor()-1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor()-1), teljesKor)){
                    // Ha ballra fel is van valaki akkor menny ballra le */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()+1);
                    egyseg.setSor(egyseg.getSor()-1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()-1) + "-" + (egyseg.getSor())) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()-1) + "-" + (egyseg.getSor())) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() -1) + "-" + (egyseg.getSor() ), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()-1 ) + "-" + (egyseg.getSor() ), teljesKor)){
                    // Ha ballra le sem lehet menni akkor mennyen fel */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor(),egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()-1);
                    egyseg.setSor(egyseg.getSor());
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()+1) + "-" + (egyseg.getSor())) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()+1) + "-" + (egyseg.getSor())) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()+1 ) + "-" + (egyseg.getSor() ), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()+1 ) + "-" + (egyseg.getSor() ), teljesKor)){
                    // Ha fel sem lehet menni mennyen le */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor(),egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()+1);
                    egyseg.setSor(egyseg.getSor());
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()-1) + "-" + (egyseg.getSor()+1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()-1) + "-" + (egyseg.getSor()+1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor()+1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor()+1), teljesKor)){
                    // Ha le sem tud menni mennyen jobbra fel */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()-1);
                    egyseg.setSor(egyseg.getSor()+1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()+1) + "-" + (egyseg.getSor()+1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()+1) + "-" + (egyseg.getSor()+1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()+1) + "-" + (egyseg.getSor() + 1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()+1) + "-" + (egyseg.getSor() + 1), teljesKor)){
                    // Ha jobbra fel sem tud menni mennyen jobbra le */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()+1);
                    egyseg.setSor(egyseg.getSor()+1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()) + "-" + (egyseg.getSor()+1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()) + "-" + (egyseg.getSor()+1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()) + "-" + (egyseg.getSor()+1 ), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()) + "-" + (egyseg.getSor()+1 ), teljesKor)){
                    // Ha jobbra le sem lehet menni mannyen jobbra  */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop());
                    egyseg.setSor(egyseg.getSor()+1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else  {
                    System.out.println("Be vagy szorulva nem tudsz lepni");
                    break out;
                }
                lepeszam--;
            }

            // Ha a cél tolled fentebb ballra van */
            if(celOszlop < egyseg.getOszlop() && celSor < egyseg.getSor() && lepeszam >0){

                if(!elozoPziciodHelye.contains((egyseg.getOszlop()-1) + "-" + (egyseg.getSor()-1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()-1 ) + "-" + (egyseg.getSor()-1 )) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()-1 ) + "-" + (egyseg.getSor()-1 ), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()-1 ) + "-" + (egyseg.getSor()-1 ), teljesKor)){
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()-1);
                    egyseg.setSor(egyseg.getSor()-1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if (!elozoPziciodHelye.contains((egyseg.getOszlop()) + "-" + (egyseg.getSor()-1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()) + "-" + (egyseg.getSor() - 1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()) + "-" + (egyseg.getSor() - 1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()) + "-" + (egyseg.getSor() - 1), teljesKor)){
                    // van valaki az útban akkor menny ballra  */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop());
                    egyseg.setSor(egyseg.getSor()-1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()-1) + "-" + (egyseg.getSor())) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()-1) + "-" + (egyseg.getSor())) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor()), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor()), teljesKor)){
                    // Ha ballra is van valaki akkor menny fel */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor(),egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()-1);
                    egyseg.setSor(egyseg.getSor());
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()+1) + "-" + (egyseg.getSor()-1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()+1) + "-" + (egyseg.getSor()-1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() +1) + "-" + (egyseg.getSor()-1 ), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()+1 ) + "-" + (egyseg.getSor()-1 ), teljesKor)){
                    // Ha fel sem lehet menni akkor mennyen ball le */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()+1);
                    egyseg.setSor(egyseg.getSor()-1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()-1) + "-" + (egyseg.getSor()+1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()-1) + "-" + (egyseg.getSor()+1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()-1 ) + "-" + (egyseg.getSor() +1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()-1 ) + "-" + (egyseg.getSor()+1 ), teljesKor)){
                    // Ha ball le sem lehet menni jobb fel */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()-1);
                    egyseg.setSor(egyseg.getSor()+1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()+1) + "-" + (egyseg.getSor())) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()+1) + "-" + (egyseg.getSor())) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor()), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()  +1) + "-" + (egyseg.getSor()), teljesKor)){
                    // Ha jobbra fel sem tud menni le */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor(),egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()+1);
                    egyseg.setSor(egyseg.getSor());
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()) + "-" + (egyseg.getSor()+1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()) + "-" + (egyseg.getSor()+1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()) + "-" + (egyseg.getSor() + 1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()) + "-" + (egyseg.getSor() + 1), teljesKor)){
                    // Ha le sem tud menni mennyen jobbra */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop());
                    egyseg.setSor(egyseg.getSor()+1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()+1) + "-" + (egyseg.getSor()+1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()+1) + "-" + (egyseg.getSor()+1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()+1) + "-" + (egyseg.getSor()+1 ), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()+1) + "-" + (egyseg.getSor()+1 ), teljesKor)){
                    // Ha jobbra sem lehet menni mannyen jobbra le  */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()+1);
                    egyseg.setSor(egyseg.getSor()+1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else  {
                    System.out.println("Be vagy szorulva nem tudsz lepni");
                    break out;
                }
                lepeszam--;
            }

            // Ha a cél tolled lenntebb ballra van */
            if(celOszlop > egyseg.getOszlop() && celSor < egyseg.getSor() && lepeszam >0){

                if(!elozoPziciodHelye.contains((egyseg.getOszlop()+1) + "-" + (egyseg.getSor()-1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()+1 ) + "-" + (egyseg.getSor()-1 )) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()+1 ) + "-" + (egyseg.getSor()-1 ), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()+1 ) + "-" + (egyseg.getSor()-1 ), teljesKor)){
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()+1);
                    egyseg.setSor(egyseg.getSor()-1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if (!elozoPziciodHelye.contains((egyseg.getOszlop()) + "-" + (egyseg.getSor()-1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()) + "-" + (egyseg.getSor() - 1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()) + "-" + (egyseg.getSor() - 1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()) + "-" + (egyseg.getSor() - 1), teljesKor)){
                    // van valaki az útban akkor menny ballra  */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop());
                    egyseg.setSor(egyseg.getSor()-1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()+1) + "-" + (egyseg.getSor())) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()+1) + "-" + (egyseg.getSor())) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor()), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() + 1) + "-" + (egyseg.getSor()), teljesKor)){
                    // Ha ballra is van valaki akkor menny le */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor(),egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()+1);
                    egyseg.setSor(egyseg.getSor());
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()-1) + "-" + (egyseg.getSor()-1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()-1) + "-" + (egyseg.getSor()-1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() -1) + "-" + (egyseg.getSor()-1 ), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()-1 ) + "-" + (egyseg.getSor()-1 ), teljesKor)){
                    // Ha le sem lehet menni akkor mennyen ball fel */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()-1);
                    egyseg.setSor(egyseg.getSor()-1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()+1) + "-" + (egyseg.getSor()+1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()+1) + "-" + (egyseg.getSor()+1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()+1 ) + "-" + (egyseg.getSor() +1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()+1 ) + "-" + (egyseg.getSor()+1 ), teljesKor)){
                    // Ha ball fel sem lehet menni jobb le */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()+1);
                    egyseg.setSor(egyseg.getSor()+1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()-1) + "-" + (egyseg.getSor())) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()-1) + "-" + (egyseg.getSor())) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop() - 1) + "-" + (egyseg.getSor()), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop() -1) + "-" + (egyseg.getSor()), teljesKor)){
                    // Ha jobbra le sem lehet menni mennyyen fel*/
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor(),egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()-1);
                    egyseg.setSor(egyseg.getSor());
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()) + "-" + (egyseg.getSor()+1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()) + "-" + (egyseg.getSor()+1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()) + "-" + (egyseg.getSor() + 1), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()) + "-" + (egyseg.getSor() + 1), teljesKor)){
                    // Ha fel sem tud menni mennyen jobbra */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop());
                    egyseg.setSor(egyseg.getSor()+1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else if(!elozoPziciodHelye.contains((egyseg.getOszlop()-1) + "-" + (egyseg.getSor()+1)) && Ellenorok.vaneIlyenKordinata((egyseg.getOszlop()-1) + "-" + (egyseg.getSor()+1)) && !Ellenorok.vaneOttJatekosEgyseg((egyseg.getOszlop()-1) + "-" + (egyseg.getSor()+1 ), teljesKor) && !Ellenorok.vaneOttAIEgyseg((egyseg.getOszlop()-1) + "-" + (egyseg.getSor()+1 ), teljesKor)){
                    // Ha jobbra sem lehet menni mannyen jobbra fel  */
                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                    elozoPziciodHelye = elozoPziciodHelye+egyseg.getOszlop()+"-"+egyseg.getSor()+" ";
                    egyseg.setOszlop(egyseg.getOszlop()-1);
                    egyseg.setSor(egyseg.getSor()+1);
                    palya.frissitettPalya(teljesKor);
                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                }else  {
                    System.out.println("Be vagy szorulva nem tudsz lepni");
                    break out;
                }
                lepeszam--;
            }


            if( (lepeszam < 1) || ( celOszlop == egyseg.getOszlop() && celSor == egyseg.getSor()) ){
                megalhat =true;
            }
        }while (megalhat == false);

        if(egyseg.getEgyseg().getNev().equals("Kenntaur")){
            Sebzes.kenntaurLepesUtanSebez(egyseg,jatekosHos,aiHos,teljesKor,palya);
        }
        System.out.println("A lepesnek vege.");
    }

    public static void JatekosLep(Mezo palya, Unit egyseg,ArrayList<Kor> egeszKor, Hos hos, Hos ellenfelhos){
        System.out.println("A "+egyseg.getEgyseg().getNev()+" kovetkezik.");
        System.out.println("Tudsz lepni (1), tamadni (2) vagy varakozni (3).");
        if(hos.isLephetEMegAHos() == true){
            System.out.print("Vagy a hossel varazsolsz (4), vagy a hossel tamadsz (5)\n");
        }

        boolean jo = false;
        String inputPVezerlo ="";
        do {
            jo = false;
            inputPVezerlo = bekero.nextLine();
            if(inputPVezerlo.equals("1") || inputPVezerlo.equals("2") || inputPVezerlo.equals("3") || inputPVezerlo.equals("4")  || inputPVezerlo.equals("5") ){
                // Hos cselekvesek */
                if(inputPVezerlo.equals("4")){
                    if(hos.getTanultVarazslatok().size() > 0){
                        HosCselekvesek.HosVarazslas( palya,  egyseg,egeszKor,  hos,  ellenfelhos);
                        jo=true;
                    }else {
                        System.out.println("Nem ismersz varazslatokat");
                    }

                }
                if(inputPVezerlo.equals("5")){
                    HosCselekvesek.HosTamad( palya,  egyseg,egeszKor,  hos,  ellenfelhos);
                    jo=true;
                }
                if(inputPVezerlo.equals("1")){
                    if(egyseg.getCurrentSpeed() != 0 && Ellenorok.tudszEMozogni(egyseg,palya,egeszKor)){
                        JatekosEGysegLep( palya, egyseg,hos,ellenfelhos,egeszKor);
                        jo=true;
                    }else{
                        System.out.println("Az egyseg nem tud mozogni");
                    }

                }
                if(inputPVezerlo.equals("2")){
                    if(allEmelletteEllenfel(palya,egyseg,egeszKor) == true && egyseg.getEgyseg().isRange() == false){
                        System.out.println("All melleteed ellenfel: tudsz tamadni");
                        JatekosEGysegKozelTamad(palya,egyseg,egeszKor,hos, ellenfelhos);
                        jo=true;
                    }
                    if(allEmelletteEllenfel(palya,egyseg,egeszKor) == true && egyseg.getEgyseg().isRange() == true){
                        System.out.println("All melleteed ellenfel: nem tudsz tamadni");
                    }
                    if(allEmelletteEllenfel(palya,egyseg,egeszKor) == false && egyseg.getEgyseg().isRange() == true){
                        System.out.println("Nem all melleteed ellenfel: tudsz tamadni");
                        JatekosEGysegTavolTamad(palya,egyseg,egeszKor,hos, ellenfelhos);
                        jo=true;
                    }
                    if(allEmelletteEllenfel(palya,egyseg,egeszKor) == false && egyseg.getEgyseg().isRange() == false){
                        System.out.println("Nem all melleteed ellenfel: nem tudsz tamadni");
                    }
                }
                if(inputPVezerlo.equals("3")){
                    jo=true;
                }
            }else {
                System.out.println(ANSI_YELLOW+"Rossz input"+ANSI_RESET);
            }
            if(inputPVezerlo.equals("2") && jo == false){
                //System.out.println("Nincs senki elég közel ahoz hogy megtámadd");
            }
        }while (jo == false);

        if(egyseg.isAllapotVoltMarNezve() == false ){
            if(egyseg.getCurrentSpeed() == 0){
                System.out.println("Az egyseg nem tud lepni meg "+(egyseg.getRootTurns())+" korig");
                egyseg.setRootTurns(egyseg.getRootTurns()-1);
                egyseg.setAllapotVoltMarNezve(true);
            }
            if(egyseg.getRootTurns() == 0){
                egyseg.setCurrentSpeed(egyseg.getEgyseg().getSebesseg());
            }
        }

    }
    public static void EllenfelLepes(Mezo palya, Unit egyseg, ArrayList<Kor> egeszKor, Hos aihos,Hos playerhos){
        // Ha olyanja van akkor tamadjon meg valamit */
        if(aihos.isLephetEMegAHos() == true){
            HosCselekvesek.AiHosTamad(palya,egyseg,egeszKor,aihos,playerhos);
        }
        //Nezze meg hogy tud-e valamit tamadni*/
        if(egyseg.getEgyseg().isRange() == false && allEmelletteEllenfel(palya,egyseg,egeszKor) == false){
            // Menny kozelebb az ellenfelhez */
            if(egyseg.getCurrentSpeed() != 0){
                EllenfelEgysegLepHogytamadjon(palya,egyseg,egeszKor,aihos,playerhos);
            }else {
                System.out.println("Nem tud mozogni");
            }

        }else if(egyseg.getEgyseg().isRange() == false && allEmelletteEllenfel(palya,egyseg,egeszKor) == true){
            // Tamadd meg az ellenfelet melletted */
            EllenfelTamad(palya,egyseg,egeszKor,aihos,playerhos);
        }else if(egyseg.getEgyseg().isRange() == true && allEmelletteEllenfel(palya,egyseg,egeszKor) == false){
            // Lojj valamire */
            EllenfelLo(palya,egyseg,egeszKor,aihos,playerhos);
        }else if(egyseg.getEgyseg().isRange() == true && allEmelletteEllenfel(palya,egyseg,egeszKor) == true){
            // menekulj */
        }

        if(egyseg.isAllapotVoltMarNezve() == false ){
            if(egyseg.getCurrentSpeed() == 0){
                System.out.println("Az egyseg nem tud lepni meg "+(egyseg.getRootTurns())+" korig");
                egyseg.setRootTurns(egyseg.getRootTurns()-1);
                egyseg.setAllapotVoltMarNezve(true);
            }
            if(egyseg.getRootTurns() == 0){
                egyseg.setCurrentSpeed(egyseg.getEgyseg().getSebesseg());
            }
        }

    }
    private static void EllenfelTamad(Mezo palya, Unit egyseg, ArrayList<Kor> egeszKor, Hos playerhos, Hos aihos){
        //egykor alatt tobbet is tud tamadni neha ha tobb van mellette ellenfelbol */
        boolean tamadtEmar = false;
        // Tolle jobbra all-e ellenfel ha igen tamadja meg */
        if((egyseg.getSor()+1 <= 12 ) && tamadtEmar == false ) {
            if(!palya.getMezoAdottEleme(egyseg.getOszlop(),egyseg.getSor()+1).equals("0")){
                for(int i=0;i<egeszKor.size();i++) {
                    Unit value = egeszKor.get(i).getEgyseg();
                    if(value.getOszlop() == egyseg.getOszlop() && value.getSor() == egyseg.getSor()+1){
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == false){
                            System.out.println("Ellenfel tamad: ");
                            Sebzes.egysegSebezEgysegetKozelrol(egyseg,egeszKor.get(i).getEgyseg(),playerhos,aihos,egeszKor,palya);
                            tamadtEmar = true;
                        }
                    }
                }
            }
        }
        //Tolle ballra all e ellenfel ha igen tamadja meg*/
        if( ((egyseg.getSor()-1 ) >=1 ) && tamadtEmar == false ){
            if(!palya.getMezoAdottEleme(egyseg.getOszlop(),egyseg.getSor()-1).equals("0")){
                for(int i=0;i<egeszKor.size();i++) {
                    Unit value = egeszKor.get(i).getEgyseg();
                    if(value.getOszlop() == egyseg.getOszlop() && value.getSor() == egyseg.getSor()-1){
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == false){
                            System.out.println("Ellenfel tamad: ");
                            Sebzes.egysegSebezEgysegetKozelrol(egyseg,egeszKor.get(i).getEgyseg(),playerhos,aihos,egeszKor,palya);
                            tamadtEmar = true;
                        }
                    }
                }
            }
        }
        //Tolle fentebb all e ellenfel ha igen tamadja meg*/
        if(((egyseg.getOszlop()-1 ) >=1) && ( tamadtEmar == false) ){
            if(!palya.getMezoAdottEleme(egyseg.getOszlop()-1,egyseg.getSor()).equals("0")){
                for(int i=0;i<egeszKor.size();i++) {
                    Unit value = egeszKor.get(i).getEgyseg();
                    if(value.getOszlop() == egyseg.getOszlop()-1 && value.getSor() == egyseg.getSor()){
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == false){
                            System.out.println("Ellenfel tamad: ");
                            Sebzes.egysegSebezEgysegetKozelrol(egyseg,egeszKor.get(i).getEgyseg(),playerhos,aihos,egeszKor,palya);
                            tamadtEmar = true;
                        }
                    }
                }
            }
        }
        //Tolle lentebb all e ellenfel ha igen tamadja meg*/
        if(((egyseg.getOszlop()+1 ) <=10 ) && (tamadtEmar == false) ){
            if(!palya.getMezoAdottEleme(egyseg.getOszlop()+1,egyseg.getSor()).equals("0")){
                for(int i=0;i<egeszKor.size();i++) {
                    String key = Integer.toString(egeszKor.get(i).getKezdemenyezes());
                    Unit value = egeszKor.get(i).getEgyseg();
                    if(value.getOszlop() == egyseg.getOszlop()+1 && value.getSor() == egyseg.getSor()){
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == false){
                            System.out.println("Ellenfel tamad: ");
                            Sebzes.egysegSebezEgysegetKozelrol(egyseg,egeszKor.get(i).getEgyseg(),playerhos,aihos,egeszKor,palya);
                            tamadtEmar = true;
                        }
                    }
                }
            }
        }
        //Tolle ballra fentebb all e ellenfel ha igen tamadja meg*/
        if(( (egyseg.getSor()-1 ) >=1) && ((egyseg.getOszlop()-1 ) >=1 ) && (tamadtEmar == false) ){
            if(!palya.getMezoAdottEleme(egyseg.getOszlop()-1,egyseg.getSor()-1).equals("0")){
                for(int i=0;i<egeszKor.size();i++) {
                    String key = Integer.toString(egeszKor.get(i).getKezdemenyezes());
                    Unit value = egeszKor.get(i).getEgyseg();
                    if(value.getOszlop() == egyseg.getOszlop()-1 && value.getSor() == egyseg.getSor()-1){
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == false){
                            System.out.println("Ellenfel tamad: ");
                            Sebzes.egysegSebezEgysegetKozelrol(egyseg,egeszKor.get(i).getEgyseg(),playerhos,aihos,egeszKor,palya);
                            tamadtEmar = true;
                        }
                    }
                }
            }
        }
        // Tolle ballra lenntebb all e ellenfel ha igen tamadja meg */
        if(((egyseg.getSor()-1 ) >=1 ) && ((egyseg.getOszlop()+1 ) <=10) && (tamadtEmar == false)){
            if(!palya.getMezoAdottEleme(egyseg.getOszlop()+1,egyseg.getSor()-1).equals("0")){
                for(int i=0;i<egeszKor.size();i++) {
                    String key = Integer.toString(egeszKor.get(i).getKezdemenyezes());
                    Unit value = egeszKor.get(i).getEgyseg();
                    if(value.getOszlop() == egyseg.getOszlop()+1 && value.getSor() == egyseg.getSor()-1){
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == false){
                            System.out.println("Ellenfel tamad: ");
                            Sebzes.egysegSebezEgysegetKozelrol(egyseg,egeszKor.get(i).getEgyseg(),playerhos,aihos,egeszKor,palya);
                            tamadtEmar = true;
                        }
                    }
                }
            }
        }
        //Tolle jobbra fenntebb all e ellenfel ha igen tamadja meg*/
        if(((egyseg.getSor()+1) <= 12) && ((egyseg.getOszlop()-1 ) >=1) && (tamadtEmar == false) ){
            if(!palya.getMezoAdottEleme(egyseg.getOszlop()-1,egyseg.getSor()+1).equals("0")){
                for(int i=0;i<egeszKor.size();i++) {
                    String key = Integer.toString(egeszKor.get(i).getKezdemenyezes());
                    Unit value = egeszKor.get(i).getEgyseg();
                    if(value.getOszlop() == egyseg.getOszlop()-1 && value.getSor() == egyseg.getSor()+1){
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == false){
                            System.out.println("Ellenfel tamad: ");
                            Sebzes.egysegSebezEgysegetKozelrol(egyseg,egeszKor.get(i).getEgyseg(),playerhos,aihos,egeszKor,palya);
                            tamadtEmar = true;
                        }
                    }
                }
            }
        }
        //Tolle jobbra lennt all e ellenfel ha igen tamadja meg */
        if(((egyseg.getSor()+1) <= 12) && ((egyseg.getOszlop()+1 ) <=10) && (tamadtEmar == false)){
            if(!palya.getMezoAdottEleme(egyseg.getOszlop()+1,egyseg.getSor()+1).equals("0")){
                for(int i=0;i<egeszKor.size();i++) {
                    String key = Integer.toString(egeszKor.get(i).getKezdemenyezes());
                    Unit value = egeszKor.get(i).getEgyseg();
                    if(value.getOszlop() == egyseg.getOszlop()+1 && value.getSor() == egyseg.getSor()+1){
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == false){
                            System.out.println("Ellenfel tamad: ");
                            Sebzes.egysegSebezEgysegetKozelrol(egyseg,egeszKor.get(i).getEgyseg(),playerhos,aihos,egeszKor,palya);
                            tamadtEmar = true;
                        }
                    }
                }
            }
        }

    }
    private static void EllenfelLo(Mezo palya, Unit egyseg, ArrayList<Kor> egeszKor, Hos playerhos, Hos aihos){
        int talaltLegnagyobbAR = 0;
        //
         // nezze meg melyik a legdragabb es azt lojje
        for (int i=0;i<egeszKor.size();i++){
            if(egeszKor.get(i).getEgyseg().isJatekosEe() == true){
                int ennekAra=egeszKor.get(i).getEgyseg().getEgyseg().getAr() * egeszKor.get(i).getEgyseg().getMenyiseg();
                if(ennekAra > talaltLegnagyobbAR){
                    talaltLegnagyobbAR = ennekAra;
                }
            }
        }
        for (int i=0;i<egeszKor.size();i++){
            if(egeszKor.get(i).getEgyseg().isJatekosEe() == true){
                int ennekAra=egeszKor.get(i).getEgyseg().getEgyseg().getAr() * egeszKor.get(i).getEgyseg().getMenyiseg();
                if(ennekAra == talaltLegnagyobbAR){
                    Sebzes.egysegSebezEgysegetTavolrol(egyseg,egeszKor.get(i).getEgyseg(),playerhos,aihos,egeszKor,palya);
                    System.out.println("Lo");
                }
            }
        }
    }

    private static void EllenfelEgysegLepHogytamadjon(Mezo palya, Unit egyseg, ArrayList<Kor> egeszKor,Hos aiHos,Hos jatekosHos) {
        int lepesSzam = egyseg.getEgyseg().getSebesseg();
        int kulombseg = 0;
        //Mikhez tud oda lepni*/
        outerloop:
        for(int i = 0;i<egeszKor.size();i++) {
            String key = Integer.toString(egeszKor.get(i).getKezdemenyezes()) ;
            Unit value = egeszKor.get(i).getEgyseg();
            if(value.isJatekosEe() == true){

                do {
                    System.out.println("Lepes szam: "+lepesSzam);
                    //ball le*/
                    if(lepesSzam > 0 && allEmelletteEllenfel(palya,egyseg,egeszKor) == false){
                        if(value.getOszlop() > egyseg.getOszlop() && value.getSor() < egyseg.getSor()){
                            if((egyseg.getSor()-1 ) >=1 && (egyseg.getOszlop()+1 ) <=10){
                                if(palya.getMezoAdottEleme(egyseg.getOszlop()+1,egyseg.getSor()-1).equals("0")){
                                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                    palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                                    egyseg.setSor(egyseg.getSor()-1);
                                    egyseg.setOszlop(egyseg.getOszlop()+1);
                                    palya.frissitettPalya(egeszKor);
                                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                    lepesSzam--;
                                }else{
                                    System.out.println("Itt all mar valaki1");
                                    for (int t=0;t<egeszKor.size();t++){
                                        if(egeszKor.get(t).getEgyseg().getOszlop() == egyseg.getOszlop()+1 && egeszKor.get(t).getEgyseg().getSor() == egyseg.getSor()-1){
                                            // ha jatekose */
                                            if(egeszKor.get(t).getEgyseg().isJatekosEe() == true){
                                                break outerloop;
                                            }else{
                                                // akkor mennyen ballra */
                                                if(palya.getMezoAdottEleme(egyseg.getOszlop(),egyseg.getSor()-1).equals("0")){
                                                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                                                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                                                    egyseg.setSor(egyseg.getSor()-1);
                                                    palya.frissitettPalya(egeszKor);
                                                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                                    lepesSzam--;
                                                }else{
                                                    System.out.println("Itt all mar valaki3");
                                                    // ellenfel-e */
                                                    for (int p=0;p<egeszKor.size();p++){
                                                        if(egeszKor.get(p).getEgyseg().getOszlop() == egyseg.getOszlop() && egeszKor.get(p).getEgyseg().getSor() == egyseg.getSor()-1){
                                                            // ha jatekose */
                                                            if(egeszKor.get(p).getEgyseg().isJatekosEe() == true){
                                                                break outerloop;
                                                            }else{
                                                                // akkor mennyen le */
                                                                if(palya.getMezoAdottEleme(egyseg.getOszlop()-1,egyseg.getSor()).equals("0")){
                                                                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                                                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor(),egyseg.getEgyseg().getMarker());
                                                                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                                                                    egyseg.setOszlop(egyseg.getOszlop()-1);
                                                                    palya.frissitettPalya(egeszKor);
                                                                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                                                    lepesSzam--;
                                                                }else {
                                                                    System.out.println("Itt all mar valaki5");
                                                                    // ellenfel-e */
                                                                    break outerloop;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    break outerloop;

                                }
                            }else {
                                System.out.println("Erre nincs mezo.");
                            }
                        }
                    }
                    //ball fel*/
                    if (lepesSzam > 0 && allEmelletteEllenfel(palya,egyseg,egeszKor) == false){
                        if(value.getOszlop() < egyseg.getOszlop() && value.getSor() < egyseg.getSor()){
                            if((egyseg.getSor()-1 ) >=1 && (egyseg.getOszlop()-1 ) >=1){
                                if(palya.getMezoAdottEleme(egyseg.getOszlop()-1,egyseg.getSor()-1).equals("0")){
                                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                                    egyseg.setSor(egyseg.getSor()-1);
                                    egyseg.setOszlop(egyseg.getOszlop()-1);
                                    palya.frissitettPalya(egeszKor);
                                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                    lepesSzam--;
                                }else{
                                    System.out.println("Itt all mar valaki2");
                                    for (int t=0;t<egeszKor.size();t++){
                                        if(egeszKor.get(t).getEgyseg().getOszlop() == egyseg.getOszlop()-1 && egeszKor.get(t).getEgyseg().getSor() == egyseg.getSor()-1){
                                            //ha jatekose */
                                            if(egeszKor.get(t).getEgyseg().isJatekosEe() == true){
                                                break outerloop;
                                            }else{//akkor mennyen ballra */
                                                if(palya.getMezoAdottEleme(egyseg.getOszlop(),egyseg.getSor()-1).equals("0")){
                                                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                                                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                                                    egyseg.setSor(egyseg.getSor()-1);
                                                    palya.frissitettPalya(egeszKor);
                                                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                                    lepesSzam--;
                                                }else {
                                                    System.out.println("Itt all mar valaki3");
                                                    // ellenfel-e */
                                                    for (int p=0;p<egeszKor.size();p++){
                                                        if(egeszKor.get(p).getEgyseg().getOszlop() == egyseg.getOszlop() && egeszKor.get(p).getEgyseg().getSor() == egyseg.getSor()-1){
                                                            // ha jatekose */
                                                            if(egeszKor.get(p).getEgyseg().isJatekosEe() == true){
                                                                break outerloop;
                                                            }else{
                                                                // akkor mennyen fel */
                                                                if(palya.getMezoAdottEleme(egyseg.getOszlop()-1,egyseg.getSor()).equals("0")){
                                                                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                                                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor(),egyseg.getEgyseg().getMarker());
                                                                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                                                                    egyseg.setOszlop(egyseg.getOszlop()-1);
                                                                    palya.frissitettPalya(egeszKor);
                                                                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                                                    lepesSzam--;
                                                                }else {
                                                                    System.out.println("Itt all mar valaki5");
                                                                    // ellenfel-e */
                                                                    break outerloop;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }

                                            }
                                        }
                                    // ellenfel-e */
                                }
                                }
                            }else {
                                System.out.println("Erre nincs mezo.");
                            }
                        }
                    }
                    // ball */
                    if (lepesSzam > 0 && allEmelletteEllenfel(palya,egyseg,egeszKor) == false){
                        if(value.getOszlop() == egyseg.getOszlop() && value.getSor() < egyseg.getSor()){
                                if((egyseg.getSor()-1 ) >=1 ){
                                    if(palya.getMezoAdottEleme(egyseg.getOszlop(),egyseg.getSor()-1).equals("0")){
                                        System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                        palya.setMezo(egyseg.getOszlop(),egyseg.getSor()-1,egyseg.getEgyseg().getMarker());
                                        palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                                        egyseg.setSor(egyseg.getSor()-1);
                                        palya.frissitettPalya(egeszKor);
                                        System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                        lepesSzam--;
                                    }else{
                                        System.out.println("Itt all mar valaki3");
                                        // ellenfel-e */
                                        break outerloop;
                                        // ha nem ellenfel van az útban akkor mennyen ballle vagy ballfel */
                                    }
                                }else{
                                    System.out.println("Erre nincs mezo");
                                }
                        }
                    }
                    // fel */
                    if (lepesSzam > 0 && allEmelletteEllenfel(palya,egyseg,egeszKor) == false){
                        if(value.getOszlop() <  egyseg.getOszlop() && value.getSor() == egyseg.getSor()){
                                if((egyseg.getOszlop()-1 ) >=1 ){
                                    if(palya.getMezoAdottEleme(egyseg.getOszlop()-1,egyseg.getSor()).equals("0")){
                                        System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                        palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor(),egyseg.getEgyseg().getMarker());
                                        palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                                        egyseg.setOszlop(egyseg.getOszlop()-1);
                                        palya.frissitettPalya(egeszKor);
                                        System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                        lepesSzam--;
                                    }else {
                                        System.out.println("Itt all mar valaki4");
                                        // ellenfel-e */
                                        break outerloop;
                                    }
                                }else{
                                    System.out.println("Erre nincs mezo");
                                }
                        }
                    }
                    // le */
                    if (lepesSzam > 0 && allEmelletteEllenfel(palya,egyseg,egeszKor) == false){
                        if(value.getOszlop() >  egyseg.getOszlop() && value.getSor() == egyseg.getSor()){
                            if((egyseg.getOszlop()-1 ) >=1 ){
                                if(palya.getMezoAdottEleme(egyseg.getOszlop()-1,egyseg.getSor()).equals("0")){
                                    System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                    palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor(),egyseg.getEgyseg().getMarker());
                                    palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                                    egyseg.setOszlop(egyseg.getOszlop()-1);
                                    palya.frissitettPalya(egeszKor);
                                    System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                    lepesSzam--;
                                }else {
                                    System.out.println("Itt all mar valaki5");
                                    // ellenfel-e */
                                    break outerloop;
                                }
                            }else{
                                System.out.println("Erre nincs mezo");
                            }
                        }
                    }
                    // jobb fel */
                    if (lepesSzam > 0 && allEmelletteEllenfel(palya,egyseg,egeszKor) == false){
                        if(value.getOszlop() < egyseg.getOszlop() && value.getSor() > egyseg.getSor()){
                            if((egyseg.getOszlop()-1 ) >=1 ){
                                    if(egyseg.getSor()+1 <= 12 && (egyseg.getOszlop()-1 ) >=1){
                                        if(palya.getMezoAdottEleme(egyseg.getOszlop()-1,egyseg.getSor()+1).equals("0")){
                                            System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                            palya.setMezo(egyseg.getOszlop()-1,egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                                            palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                                            egyseg.setSor(egyseg.getSor()+1);
                                            egyseg.setOszlop(egyseg.getOszlop()-1);
                                            palya.frissitettPalya(egeszKor);
                                            System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                            lepesSzam--;
                                        }else{
                                            System.out.println("Itt all mar valaki6");
                                            // ellenfel-e */
                                            break outerloop;
                                        }
                                    }else {
                                        System.out.println("Erre nincs mezo.");
                                    }
                            }
                        }
                    }
                    // jobb le */
                    if (lepesSzam > 0 && allEmelletteEllenfel(palya,egyseg,egeszKor) == false){
                        if(value.getOszlop() > egyseg.getOszlop() && value.getSor() > egyseg.getSor()){
                                if(egyseg.getSor()+1 <= 12 && (egyseg.getOszlop()+1 ) <=10){
                                    if(palya.getMezoAdottEleme(egyseg.getOszlop()+1,egyseg.getSor()+1).equals("0")){
                                        System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                        palya.setMezo(egyseg.getOszlop()+1,egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                                        palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                                        egyseg.setSor(egyseg.getSor()+1);
                                        egyseg.setOszlop(egyseg.getOszlop()+1);
                                        palya.frissitettPalya(egeszKor);
                                        System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                        lepesSzam--;
                                    }else{
                                        System.out.println("Itt all mar valaki7");
                                        // ellenfel-e */
                                        break outerloop;
                                    }
                                }else {
                                    System.out.println("Erre nincs mezo.");
                                }
                        }
                    }
                    // jobb */
                    if (lepesSzam > 0 && allEmelletteEllenfel(palya,egyseg,egeszKor) == false){
                        if(value.getOszlop() == egyseg.getOszlop() && value.getSor() > egyseg.getSor()){
                                if(egyseg.getSor()+1 <= 12){
                                    if(palya.getMezoAdottEleme(egyseg.getOszlop(),egyseg.getSor()+1).equals("0")){
                                        System.out.println("innen: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                        palya.setMezo(egyseg.getOszlop(),egyseg.getSor()+1,egyseg.getEgyseg().getMarker());
                                        palya.setMezo(egyseg.getOszlop(),egyseg.getSor(),"0");
                                        egyseg.setSor(egyseg.getSor()+1);
                                        palya.frissitettPalya(egeszKor);
                                        System.out.println("ide lepsz: "+egyseg.getOszlop()+"-"+egyseg.getSor());
                                        lepesSzam--;
                                    }else{
                                        System.out.println("Itt all mar valaki8");
                                        // ellenfel-e */
                                        break outerloop;
                                    }
                                }else {
                                    System.out.println("Erre nincs mezo.");
                                }
                        }
                    }
                    if(allEmelletteEllenfel(palya,egyseg,egeszKor) == true || lepesSzam == 0){
                        if(egyseg.getEgyseg().getNev().equals("Kenntaur")){
                            Sebzes.kenntaurLepesUtanSebez(egyseg,aiHos,jatekosHos,egeszKor,palya);
                        }
                        break outerloop;
                    }
                }while (allEmelletteEllenfel(palya,egyseg,egeszKor) == false);

            }
        }


    }

    private static boolean allEmelletteEllenfel(Mezo palya ,Unit egyseg,ArrayList<Kor> egeszKor) {
        // Tolle jobbra all-e ellenfel */
        if(egyseg.getSor()+1 <= 12){
            if(!palya.getMezoAdottEleme(egyseg.getOszlop(),egyseg.getSor()+1).equals("0")){
                for(int i=0;i<egeszKor.size();i++) {
                    String key = Integer.toString(egeszKor.get(i).getKezdemenyezes());
                    Unit value = egeszKor.get(i).getEgyseg();
                    if(value.getOszlop() == egyseg.getOszlop() && value.getSor() == egyseg.getSor()+1){
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == true){
                            //System.out.println("Ket jatekos egyseg all egymas mellett.");
                        }
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == false){
                            //System.out.println("Ket ellenseges egyseg all egymas mellett");
                            return true;
                        }
                        if(value.isJatekosEe() == false && egyseg.isJatekosEe() == true){
                            //System.out.println("Ket ellenseges egyseg all egymas mellett");
                            return true;
                        }
                        if(value.isJatekosEe() == false && egyseg.isJatekosEe() == false){
                            //System.out.println("Ket ellenfel egyseg all egymas mellettt");
                        }
                    }
                }
            }
        }

        //Tolle ballra all e ellenfel*/
        if((egyseg.getSor()-1 ) >=1 ){
            if(!palya.getMezoAdottEleme(egyseg.getOszlop(),egyseg.getSor()-1).equals("0")){
                for(int i=0;i<egeszKor.size();i++) {
                    String key = Integer.toString(egeszKor.get(i).getKezdemenyezes());
                    Unit value = egeszKor.get(i).getEgyseg();
                    if(value.getOszlop() == egyseg.getOszlop() && value.getSor() == egyseg.getSor()-1){
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == true){
                            //System.out.println("Ket jatekos egyseg all egymas mellett.");
                        }
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == false){
                            //System.out.println("Ket ellenseges egyseg all egymas mellett");
                            return true;
                        }
                        if(value.isJatekosEe() == false && egyseg.isJatekosEe() == true){
                            //System.out.println("Ket ellenseges egyseg all egymas mellett");
                            return true;
                        }
                        if(value.isJatekosEe() == false && egyseg.isJatekosEe() == false){
                            //System.out.println("Ket ellenfel egyseg all egymas mellettt");
                        }
                    }
                }
            }
        }
        //Tolle fentebb all e ellenfel*/
        if((egyseg.getOszlop()-1 ) >=1 ){
            if(!palya.getMezoAdottEleme(egyseg.getOszlop()-1,egyseg.getSor()).equals("0")){
                for(int i=0;i<egeszKor.size();i++) {
                    String key = Integer.toString(egeszKor.get(i).getKezdemenyezes());
                    Unit value = egeszKor.get(i).getEgyseg();
                    if(value.getOszlop() == egyseg.getOszlop()-1 && value.getSor() == egyseg.getSor()){
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == true){
                            //System.out.println("Ket jatekos egyseg all egymas mellett.");
                        }
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == false){
                            //System.out.println("Ket ellenseges egyseg all egymas mellett");
                            return true;
                        }
                        if(value.isJatekosEe() == false && egyseg.isJatekosEe() == true){
                            //System.out.println("Ket ellenseges egyseg all egymas mellett");
                            return true;
                        }
                        if(value.isJatekosEe() == false && egyseg.isJatekosEe() == false){
                            //System.out.println("Ket ellenfel egyseg all egymas mellettt");
                        }
                    }
                }
            }
        }
        //Tolle lentebb all e ellenfel*/
        if((egyseg.getOszlop()+1 ) <=10 ){
            if(!palya.getMezoAdottEleme(egyseg.getOszlop()+1,egyseg.getSor()).equals("0")){
                for(int i=0;i<egeszKor.size();i++) {
                    String key = Integer.toString(egeszKor.get(i).getKezdemenyezes());
                    Unit value = egeszKor.get(i).getEgyseg();
                    if(value.getOszlop() == egyseg.getOszlop()+1 && value.getSor() == egyseg.getSor()){
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == true){
                            //System.out.println("Ket jatekos egyseg all egymas mellett.");
                        }
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == false){
                            //System.out.println("Ket ellenseges egyseg all egymas mellett");
                            return true;
                        }
                        if(value.isJatekosEe() == false && egyseg.isJatekosEe() == true){
                            //System.out.println("Ket ellenseges egyseg all egymas mellett");
                            return true;
                        }
                        if(value.isJatekosEe() == false && egyseg.isJatekosEe() == false){
                            //System.out.println("Ket ellenfel egyseg all egymas mellettt");
                        }
                    }
                }
            }
        }
        //Tolle ballra fentebb all e ellenfel*/
        if((egyseg.getSor()-1 ) >=1 && (egyseg.getOszlop()-1 ) >=1){
            if(!palya.getMezoAdottEleme(egyseg.getOszlop()-1,egyseg.getSor()-1).equals("0")){
                for(int i=0;i<egeszKor.size();i++) {
                    String key = Integer.toString(egeszKor.get(i).getKezdemenyezes());
                    Unit value = egeszKor.get(i).getEgyseg();
                    if(value.getOszlop() == egyseg.getOszlop()-1 && value.getSor() == egyseg.getSor()-1){
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == true){
                            //System.out.println("Ket jatekos egyseg all egymas mellett.");
                        }
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == false){
                            //System.out.println("Ket ellenseges egyseg all egymas mellett");
                            return true;
                        }
                        if(value.isJatekosEe() == false && egyseg.isJatekosEe() == true){
                            //System.out.println("Ket ellenseges egyseg all egymas mellett");
                            return true;
                        }
                        if(value.isJatekosEe() == false && egyseg.isJatekosEe() == false){
                            //System.out.println("Ket ellenfel egyseg all egymas mellettt");
                        }
                    }
                }
            }
        }
        // Tolle ballra lenntebb all e ellenfel */
        if((egyseg.getSor()-1 ) >=1 && (egyseg.getOszlop()+1 ) <=10){
            if(!palya.getMezoAdottEleme(egyseg.getOszlop()+1,egyseg.getSor()-1).equals("0")){
                for(int i=0;i<egeszKor.size();i++) {
                    String key = Integer.toString(egeszKor.get(i).getKezdemenyezes());
                    Unit value = egeszKor.get(i).getEgyseg();
                    if(value.getOszlop() == egyseg.getOszlop()+1 && value.getSor() == egyseg.getSor()-1){
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == true){
                            //System.out.println("Ket jatekos egyseg all egymas mellett.");
                        }
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == false){
                            //System.out.println("Ket ellenseges egyseg all egymas mellett");
                            return true;
                        }
                        if(value.isJatekosEe() == false && egyseg.isJatekosEe() == true){
                            //System.out.println("Ket ellenseges egyseg all egymas mellett");
                            return true;
                        }
                        if(value.isJatekosEe() == false && egyseg.isJatekosEe() == false){
                            //System.out.println("Ket ellenfel egyseg all egymas mellettt");
                        }
                    }
                }
            }
        }
        //Tolle jobbra fenntebb all e ellenfel*/
        if((egyseg.getSor()+1) <= 12 && (egyseg.getOszlop()-1 ) >=1){
            if(!palya.getMezoAdottEleme(egyseg.getOszlop()-1,egyseg.getSor()+1).equals("0")){
                for(int i=0;i<egeszKor.size();i++) {
                    String key = Integer.toString(egeszKor.get(i).getKezdemenyezes());
                    Unit value = egeszKor.get(i).getEgyseg();
                    if(value.getOszlop() == egyseg.getOszlop()-1 && value.getSor() == egyseg.getSor()+1){
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == true){
                            //System.out.println("Ket jatekos egyseg all egymas mellett.");
                        }
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == false){
                            //System.out.println("Ket ellenseges egyseg all egymas mellett");
                            return true;
                        }
                        if(value.isJatekosEe() == false && egyseg.isJatekosEe() == true){
                            //System.out.println("Ket ellenseges egyseg all egymas mellett");
                            return true;
                        }
                        if(value.isJatekosEe() == false && egyseg.isJatekosEe() == false){
                            //System.out.println("Ket ellenfel egyseg all egymas mellettt");
                        }
                    }
                }
            }
        }
        //Tolle jobbra lennt all e ellenfel*/
        if((egyseg.getSor()+1) <= 12 && (egyseg.getOszlop()+1 ) <=10){
            if(!palya.getMezoAdottEleme(egyseg.getOszlop()+1,egyseg.getSor()+1).equals("0")){
                for(int i=0;i<egeszKor.size();i++) {
                    String key = Integer.toString(egeszKor.get(i).getKezdemenyezes());
                    Unit value = egeszKor.get(i).getEgyseg();
                    if(value.getOszlop() == egyseg.getOszlop()+1 && value.getSor() == egyseg.getSor()+1){
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == true){
                            //System.out.println("Ket jatekos egyseg all egymas mellett.");
                        }
                        if(value.isJatekosEe() == true && egyseg.isJatekosEe() == false){
                            //System.out.println("Ket ellenseges egyseg all egymas mellett");
                            return true;
                        }
                        if(value.isJatekosEe() == false && egyseg.isJatekosEe() == true){
                            //System.out.println("Ket ellenseges egyseg all egymas mellett");
                            return true;
                        }
                        if(value.isJatekosEe() == false && egyseg.isJatekosEe() == false){
                            //System.out.println("Ket ellenfel egyseg all egymas mellettt");
                        }
                    }
                }
            }
        }

        return false;
    }


    public  static void korBerendezes(Hos hos1, Hos enemyHero, ArrayList<Kor> kor,Mezo palya){
        if(kor.size() == 0){
            for (int i=0;i<hos1.getUnit().size();i++){
                kor.add(new Kor (hos1.getUnit().get(i).getKezdemenyezes(),hos1.getUnit().get(i)));
            }
            for (int i=0;i<enemyHero.getUnit().size();i++){
                kor.add(new Kor(enemyHero.getUnit().get(i).getKezdemenyezes(), enemyHero.getUnit().get(i)));
            }
        }
        for (int i=0;i<kor.size();i++){
            kor.get(i).getEgyseg().setMaximumEgysegSzam(kor.get(i).getEgyseg().getMenyiseg());
            kor.get(i).getEgyseg().setMaximumHP(kor.get(i).getEgyseg().getMenyiseg()*kor.get(i).getEgyseg().getEgyseg().getEletero());
        }
        int sorrendSzam=1;
        Collections.sort(kor,Collections.reverseOrder());
        System.out.println("Lépések sorrendje: ");
        for(int i=0;i< kor.size();i++) {
            int key = kor.get(i).getKezdemenyezes();
            //System.out.println(key+" : "+kor.get(i).getEgyseg().getEgyseg().getNev()+" Kezdemenyezes");
            if(kor.get(i).getEgyseg().isJatekosEe() == true){
                System.out.println(sorrendSzam+" : "+kor.get(i).getEgyseg().getEgyseg().getNev()+" (Játékosé)");
            }else {
                System.out.println(sorrendSzam+" : "+kor.get(i).getEgyseg().getEgyseg().getNev()+" (Ellenfélé)");
            }
            sorrendSzam++;
        }
        palya.frissitettPalya(kor);
    }

}
