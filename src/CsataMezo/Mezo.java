package CsataMezo;

import Egysegek.Unit;
import Enemy.EnemyHero;

import java.util.ArrayList;

import static Kiegeszitok.Colours.*;
import static Main.Main.bekero;

/**
 * A mezo maga a pálya amin a csata játszódik ami 10-12 méretú
 */
public class Mezo {
    private  String[][] mezo;
    public Mezo(){
        //                     magassag|szelesseg
        //                    t | i
        this.mezo = new String[10][12];
        for (int t=0;t<10;t++){
            for (int i=0;i<12;i++){
                this.mezo[t][i] = "0";
            }
        }
    }

    /**
     * Visszaadja magát a mezőt
     * @return
     */
    public String[][] getMezo() {
        return mezo;
    }

    /**
     *
     * @param magassag 1-10 közötti érték kell legyen
     * @param szelesseg 1-12 közötti érték kell legyen
     * @return visszaadja azt a jelölő karaktert mi az adott kordinátán van
     */
    public  String getMezoAdottEleme(int magassag, int szelesseg){
        //System.out.println("magassag: "+magassag+". szelesseg: "+szelesseg);
        if(magassag < 11 && magassag > 0 && szelesseg < 13 && magassag > 0){
            String eredmeny = mezo[magassag-1][szelesseg-1];
            return eredmeny;
        }
        System.out.println("nincs ilyen mezo");
        return null;
    }

    /**
     *
     * @param magassag 1-10 közötti érték kell legyen
     * @param szelesseg 1-12 közötti érték kell legyen
     * @param valami amire az adott kordinátát beakarjuk állítani
     */
    public void setMezo(int magassag,int szelesseg,String valami) {
        this.mezo[magassag-1][szelesseg-1] = valami;
    }


    /**
     * Kirajzolja a pályát és a rajza levő egységeket színnel megkülönböztetve
     * @param egeszkor a még élő egységeket tartalmazó lista
     */
    public void frissitettPalya(ArrayList<Kor> egeszkor){
        System.out.print("   ");
        for (int i=0;i<12;i++){
            if((i+1) > 9){
                System.out.print(""+(i+1)+" ");
            }else{
                System.out.print(" "+(i+1)+" ");
            }

        }
        System.out.println("");
        int oszlopSzam = 1;
        for (int t=0;t<10;t++){
            if(oszlopSzam > 9){
                System.out.print(""+(oszlopSzam)+" ");
            }else{
                System.out.print(" "+(oszlopSzam)+" ");
            }
            oszlopSzam++;
            for (int i=0;i<12;i++){
                boolean kivoltIrva = false;
                for (Kor kor : egeszkor) {
                    if (kor.getEgyseg().getOszlop() == (t + 1) && kor.getEgyseg().getSor() == (i + 1)) {
                        if (kor.getEgyseg().isJatekosEe()) {
                            System.out.print(" " + ANSI_GREEN + this.mezo[t][i] + " " + ANSI_RESET);
                            kivoltIrva = true;
                        } else {
                            System.out.print(" " + ANSI_RED + this.mezo[t][i] + " " + ANSI_RESET);
                            kivoltIrva = true;
                        }
                    }
                }
                if (!kivoltIrva){
                    System.out.print(" "+this.mezo[t][i]+" ");
                }
            }
            System.out.println("");
        }
    }
    /**
     * Kirajzolja a pályát és a rajza levő egységeket színnek nélkül
     */
    public void frissitettPalya(){
        System.out.print("   ");
        for (int i=0;i<12;i++){
            if((i+1) > 9){
                System.out.print(""+(i+1)+" ");
            }else{
                System.out.print(" "+(i+1)+" ");
            }

        }
        System.out.println("");
        int oszlopSzam = 1;
        for (int t=0;t<10;t++){
            if(oszlopSzam > 9){
                System.out.print(""+(oszlopSzam)+" ");
            }else{
                System.out.print(" "+(oszlopSzam)+" ");
            }
            oszlopSzam++;
            for (int i=0;i<12;i++){
                System.out.print(" "+this.mezo[t][i]+" ");
            }
            System.out.println("");
        }
    }

    /**
     * Az egységek pályán való elhelyezése a játékos számára
     * @param mezo az a pálya amire elhelyezzük az egységeket
     * @param sereg az összes egységet tartalmazó lista
     */
    public void elhelyezes(Mezo mezo, ArrayList<Unit> sereg){
        int nemElhelyezettEgysegekSzama = sereg.size();
        int [] elhelyezettek = new int[sereg.size()];
        int elhelyezettindex = 0;
        do{

        System.out.println("Egysegeid: ");
        for (int i=0;i<sereg.size();i++){
            System.out.println("("+(i+1)+") "+sereg.get(i).getEgyseg().getNev()+" .Letszam: "+sereg.get(i).getMenyiseg());
        }
        System.out.println("Add meg hogy melyik egységedet akarod hova tenni:(magassag-szelesseg):(amit el akarsz helyezni) pl: 1-1:1");
        System.out.println("Csak az első két oszlopba tehetsz egységet.");
        String kommand;
        //Kell ellenorzes
        boolean megfelel = true;
        do {
            megfelel = false;
            kommand = bekero.nextLine();
            String[] elsoVagoEllenor = kommand.split(":");

            String[] masodikVagoEllenor = elsoVagoEllenor[0].split("-");

            if(elsoVagoEllenor.length == 2 && masodikVagoEllenor.length == 2){
                if(elsoVagoEllenor[1].equals("1") || elsoVagoEllenor[1].equals("2") || elsoVagoEllenor[1].equals("3") || elsoVagoEllenor[1].equals("4") || elsoVagoEllenor[1].equals("5") || elsoVagoEllenor[1].equals("6") || elsoVagoEllenor[1].equals("7") || elsoVagoEllenor[1].equals("8") || elsoVagoEllenor[1].equals("9") ) {
                    if (Integer.parseInt(elsoVagoEllenor[1]) <= sereg.size() && Integer.parseInt(elsoVagoEllenor[1]) > 0) {
                        if (masodikVagoEllenor[0].equals("1") || masodikVagoEllenor[0].equals("2") || masodikVagoEllenor[0].equals("3") || masodikVagoEllenor[0].equals("4") || masodikVagoEllenor[0].equals("5") || masodikVagoEllenor[0].equals("6") || masodikVagoEllenor[0].equals("7") || masodikVagoEllenor[0].equals("8") || masodikVagoEllenor[0].equals("9") || masodikVagoEllenor[0].equals("10")) {
                            if (masodikVagoEllenor[1].equals("1") || masodikVagoEllenor[1].equals("2") ) {
                                boolean hiba = false;
                                for (int i=0;i<elhelyezettek.length;i++){
                                    if(elhelyezettek[i] == Integer.parseInt(elsoVagoEllenor[1])){
                                        System.out.println(ANSI_YELLOW+"Ezt az egységet már elhelyezted"+ANSI_RESET);
                                        hiba = true;
                                    }
                                }
                                //Ne lehessen egymásra rakni
                                //System.out.println("teszt: "+Integer.parseInt(masodikVagoEllenor[0])+" "+Integer.parseInt(masodikVagoEllenor[1]));
                                //System.out.println("Van: "+this.mezo[4][1]);
                                if(this.mezo[Integer.parseInt(masodikVagoEllenor[0])-1][Integer.parseInt(masodikVagoEllenor[1])-1].equals("0")){

                                }else{
                                    System.out.println(ANSI_YELLOW+"Itt mar van egy egyseg."+ANSI_RESET);
                                    hiba = true;
                                }
                                if(!hiba){megfelel = true;}
                            }
                        }
                    }
                }

            }
            if(!megfelel){System.out.println(ANSI_YELLOW+"Rossz kommand"+ANSI_RESET);}
        }while (!megfelel);

        String[] elsoVago = kommand.split(":");
        String[] masodikVago = elsoVago[0].split("-");
        int oszlop = Integer.parseInt(masodikVago[0]);
        int sor = Integer.parseInt(masodikVago[1]);
        int unitId = Integer.parseInt(elsoVago[1]);

        for (int i=0;i<sereg.size();i++){
            if((i+1) == unitId){
                int[][] pozicio=new int[oszlop-1][sor-1];
                sereg.get(i).setOszlop(oszlop);
                sereg.get(i).setSor(sor);
                System.out.println(sereg.get(i).getEgyseg().getNev()+" nek a pozíciója: "+ sereg.get(i).getOszlop()+" "+sereg.get(i).getSor());
                this.mezo[oszlop-1][sor-1] = sereg.get(i).getEgyseg().getMarker();
                elhelyezettek[elhelyezettindex] = unitId;
                elhelyezettindex++;
                frissitettPalya();
                nemElhelyezettEgysegekSzama--;
            }
        }
    }while (nemElhelyezettEgysegekSzama > 0);
    }

    /**
     * A gép elhelyezi az egységeit
     * @param enemy hős aki elhelyezi az egységeit
     */
    public void EnemyElhelyezes(EnemyHero enemy){
        System.out.println("---------------------------------");
        System.out.println("Az ellenfel elhelyezi az egysegeit: ");

        int enemyMagassag ;
        int enemySzelesseg;
        ArrayList<Integer> magassag = new ArrayList<>();
        ArrayList<Integer> szelesseg = new ArrayList<>();
        for (int i=0;i<enemy.getUnit().size();i++){
            boolean jo = true;
            do {
                jo = true;
                enemyMagassag=(int) (Math.random() * (10-1+1)+1 );
                enemySzelesseg=(int) (Math.random() * (12-11+1)+11);
                for (int t=0;t<magassag.size();t++){
                    if (magassag.get(t) == enemyMagassag){
                        if(szelesseg.get(t) == enemySzelesseg){
                            jo = false;
                        }
                    }
                }
            }while (!jo);
            magassag.add(enemyMagassag);
            szelesseg.add(enemySzelesseg);
            System.out.println(enemy.getUnit().get(i).getEgyseg().getNev()+" helye: "+enemyMagassag+" "+enemySzelesseg);
            enemy.getUnit().get(i).setOszlop(enemyMagassag);
            enemy.getUnit().get(i).setSor(enemySzelesseg);
            this.mezo[enemyMagassag-1][enemySzelesseg-1]=enemy.getUnit().get(i).getEgyseg().getMarker();
        }
        frissitettPalya();

    }
}
