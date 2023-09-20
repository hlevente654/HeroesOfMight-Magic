package CsataMezo;

import Csata.Lepes;
import Csata.Sebzes;
import Egysegek.Hos;
import Egysegek.Unit;
import Kiegeszitok.Ellenorok;
import Varazslatok.Varazslas;

import java.util.ArrayList;

import static Kiegeszitok.Colours.ANSI_RESET;
import static Kiegeszitok.Colours.ANSI_YELLOW;
import static Main.Main.bekero;

/**
 * A hős által csata közben tehető tevékenységek
 */
public class HosCselekvesek {
    /**
     * Itt tud támadni a gép hős
     * @param palya amin harcolnak
     * @param egyseg aki éppen következik
     * @param egeszKor az élő egységeket tartalmazó lista
     * @param aihos a gép hőse
     * @param playerhos a játékos hőse
     */
    public static void AiHosTamad(Mezo palya, Unit egyseg, ArrayList<Kor> egeszKor, Hos aihos, Hos playerhos){
        int anumberOfplayerUnits = 0;
        for (Kor kor : egeszKor) {
            if (kor.getEgyseg().isJatekosEe()) {
                anumberOfplayerUnits++;
            }
        }
        int kiosztottsebzes =Sebzes.HosTamad( palya, egyseg, egeszKor, aihos, playerhos);
        int melyiket = (int) (Math.random()*((anumberOfplayerUnits-1)+1)+1);
        anumberOfplayerUnits = 0;
        for (int i=0;i<egeszKor.size();i++){
            if(egeszKor.get(i).getEgyseg().isJatekosEe()){
                anumberOfplayerUnits++;
            }
            if(anumberOfplayerUnits == melyiket){
                if(egeszKor.get(i).getEgyseg().isJatekosEe()){
                    System.out.println("Hos alltal kiosztott sebzes: "+kiosztottsebzes);
                    Sebzes.sebzodes(egeszKor.get(i).getEgyseg(),kiosztottsebzes);
                    if(egeszKor.get(i).getEgyseg().getMenyiseg() < 1){
                        System.out.println("Meghalt az egyseg");
                        Sebzes.egysegMeghal(egeszKor.get(i).getEgyseg(), egeszKor, palya);
                        palya.frissitettPalya(egeszKor);
                }
                }
            }
        }
        aihos.setLephetEMegAHos(false);
        System.out.println("Hos tamad");
    }

    /**
     * Itt tud támadni a játékos hőssel
     * @param palya amin harcolnak
     * @param egyseg aki éppen következik
     * @param egeszKor az élő egységeket tartalmazó lista
     * @param hos a játékos hőse
     * @param ellenfelhos a gép hőse
     *
     */

    public static void HosTamad(Mezo palya, Unit egyseg, ArrayList<Kor> egeszKor, Hos hos, Hos ellenfelhos){

        System.out.println("Hova akarsz hossal tamadni? Pl:(5-6)");
        String bekert;
        boolean joInput = false;
        do {
            bekert = bekero.nextLine();
            String[] tomb = bekert.split("-");
            if(tomb.length == 2){
                if(tomb[0].equals("1") || tomb[0].equals("2") || tomb[0].equals("3") || tomb[0].equals("4") || tomb[0].equals("5") || tomb[0].equals("6") || tomb[0].equals("7") || tomb[0].equals("8") || tomb[0].equals("9") || tomb[0].equals("10")){
                    if(tomb[1].equals("1") || tomb[1].equals("2") || tomb[1].equals("3") || tomb[1].equals("4") || tomb[1].equals("5") || tomb[1].equals("6") || tomb[1].equals("7") || tomb[1].equals("8") || tomb[1].equals("9") || tomb[1].equals("10") || tomb[1].equals("11") || tomb[1].equals("12")){
                        for(int i=0;i<egeszKor.size();i++){
                            if(egeszKor.get(i).getEgyseg().getOszlop() == Integer.parseInt(tomb[0]) && egeszKor.get(i).getEgyseg().getSor() == Integer.parseInt(tomb[1])){
                                if(!egeszKor.get(i).getEgyseg().isJatekosEe()){
                                    int kiosztottsebzes =Sebzes.HosTamad( palya, egyseg, egeszKor, hos, ellenfelhos);
                                    System.out.println("Hos alltal kiosztott sebzes: "+kiosztottsebzes);
                                    Sebzes.sebzodes(egeszKor.get(i).getEgyseg(),kiosztottsebzes);
                                    if(egeszKor.get(i).getEgyseg().getMenyiseg() < 1){
                                        System.out.println("Meghalt az egyseg");
                                        Sebzes.egysegMeghal(egeszKor.get(i).getEgyseg(), egeszKor, palya);
                                        palya.frissitettPalya(egeszKor);
                                    }
                                    joInput = true;
                                }
                            }
                        }
                    }
                }
            }
            if(!joInput){
                System.out.println(ANSI_YELLOW+"Rossz input"+ANSI_RESET);
            }
        }while (!joInput);


        hos.setLephetEMegAHos(false);
        System.out.println("Hos tamad");
        Lepes.JatekosLep(palya, egyseg,egeszKor, hos, ellenfelhos);
    }

    /**
     * Itt tud varázslást kezdeményezni a játékos hős
     * @param palya amin harcolnak
     * @param egyseg aki éppen következik
     * @param egeszKor az élő egységeket tartalmazó lista
     * @param hos a játékos hőse
     * @param ellenfelhos a gép hőse
     */
    public static void HosVarazslas(Mezo palya, Unit egyseg, ArrayList<Kor> egeszKor, Hos hos, Hos ellenfelhos) {
        System.out.println("Varazslataid: ");
        for (int i = 0;i<hos.getTanultVarazslatok().size();i++){
            System.out.println("("+(i+1)+") "+ hos.getTanultVarazslatok().get(i).getNev());
        }
        boolean joInput = false;
        String input;
        do {
            input = bekero.nextLine();

            if(Ellenorok.isHoleNumber(input) && Integer.parseInt(input) <= hos.getTanultVarazslatok().size()){
                // Vane ra elég varazsero?
                if(hos.getTanultVarazslatok().get(Integer.parseInt(input)-1).getMannaCost() <= hos.getMannaPool()){
                    System.out.println("Van ra eleg mannad");
                    castSpell(hos.getTanultVarazslatok().get(Integer.parseInt(input)-1),hos,egeszKor,palya);
                    joInput = true;
                }else
                {
                    System.out.println("Nincs ra eleg mannad.");
                    Lepes.JatekosLep(palya, egyseg,egeszKor, hos, ellenfelhos);
                }
            }

            if (!joInput){
                System.out.println(ANSI_YELLOW+"Rossz input"+ANSI_RESET);
                Lepes.JatekosLep(palya, egyseg,egeszKor, hos, ellenfelhos);
            }
        }while (!joInput);


        hos.setLephetEMegAHos(false);
        System.out.println("Hos varazsol");
        Lepes.JatekosLep(palya, egyseg,egeszKor, hos, ellenfelhos);
    }

    /**
     * Itt hajtja végre a varázslást a játékos hős
     * @param varazslas amilyen varázslatott használ éppen
     * @param hosAkiVarazsol
     * @param egeszKor az élő egységeket tartalmazó lista
     * @param palya amin harcolnak
     */
    public static void castSpell(Varazslas varazslas, Hos hosAkiVarazsol, ArrayList<Kor> egeszKor, Mezo palya){
        System.out.println("Hova varazsolsz (1-1): "+varazslas.getNev());
        String varazslasHelye = "";
        if(varazslas.getNev().equals("Villamcsapas")){
            boolean joInput = false;
            do {
                varazslasHelye=bekero.nextLine();
                if(Ellenorok.vaneIlyenKordinata(varazslasHelye)){
                    if(Ellenorok.vaneOttAIEgyseg(varazslasHelye,egeszKor)){
                        System.out.println("Lesujt a villam");
                        Sebzes.villamcsapasSebzes(varazslasHelye,egeszKor,hosAkiVarazsol,palya);
                        hosAkiVarazsol.setMannaPool(hosAkiVarazsol.getMannaPool()-varazslas.getMannaCost());
                        System.out.println("Manna pool: "+hosAkiVarazsol.getMannaPool());
                        joInput = true;
                    }
                }
                if(!joInput){
                    System.out.println(ANSI_YELLOW+"Rossz input"+ANSI_RESET);
                }
            }while (!joInput);

        } else
            if(varazslas.getNev().equals("Tuzlabda")){
                boolean joInput = false;
            do {
                varazslasHelye=bekero.nextLine();
                if(Ellenorok.vaneIlyenKordinata(varazslasHelye)){
                    System.out.println("Lesujt a tuzlabda");
                    Sebzes.tuzlabdaSebzes(varazslasHelye,egeszKor,hosAkiVarazsol,palya);
                    hosAkiVarazsol.setMannaPool(hosAkiVarazsol.getMannaPool()-varazslas.getMannaCost());
                    System.out.println("Manna pool: "+hosAkiVarazsol.getMannaPool());
                    joInput = true;
                }
                if(!joInput){
                    System.out.println(ANSI_YELLOW+"Rossz input"+ANSI_RESET);
                }
            }while (!joInput);
        }else
            if(varazslas.getNev().equals("Feltamasztas")){
                boolean joInput = false;
                do {
                    varazslasHelye=bekero.nextLine();
                    if(Ellenorok.vaneIlyenKordinata(varazslasHelye)){
                        if(Ellenorok.vaneOttJatekosEgyseg(varazslasHelye,egeszKor)){
                            System.out.println("Feltamasztanak");
                            Sebzes.feltamasztasMinuszSebzes(varazslasHelye,egeszKor,hosAkiVarazsol,palya);
                            hosAkiVarazsol.setMannaPool(hosAkiVarazsol.getMannaPool()-varazslas.getMannaCost());
                            System.out.println("Manna pool: "+hosAkiVarazsol.getMannaPool());
                            joInput = true;
                        }
                    }
                    if(!joInput){
                        System.out.println(ANSI_YELLOW+"Rossz input"+ANSI_RESET);
                    }
                }while (!joInput);
        }else  if(varazslas.getNev().equals("A Túlvilág Átka")){

                System.out.println("A pokol erői tamadnak");
                Sebzes.tulvilagiSebzes(varazslasHelye,egeszKor,hosAkiVarazsol,palya);
                hosAkiVarazsol.setMannaPool(hosAkiVarazsol.getMannaPool()-varazslas.getMannaCost());
                System.out.println("Manna pool: "+hosAkiVarazsol.getMannaPool());

            }else
            if(varazslas.getNev().equals("Net of Amyntok")){
                boolean joInput = false;
                do {
                    varazslasHelye=bekero.nextLine();
                    if(Ellenorok.vaneIlyenKordinata(varazslasHelye)){
                            System.out.println("Behalozva");
                            Sebzes.neted(varazslasHelye,egeszKor,palya);
                            hosAkiVarazsol.setMannaPool(hosAkiVarazsol.getMannaPool()-varazslas.getMannaCost());
                            System.out.println("Manna pool: "+hosAkiVarazsol.getMannaPool());
                            joInput = true;
                    }
                    if(!joInput){
                        System.out.println(ANSI_YELLOW+"Rossz input"+ANSI_RESET);
                    }
                }while (!joInput);
            }
    }
}
