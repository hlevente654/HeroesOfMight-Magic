package Egysegek;
/**
 * Egy speciális harci egység típus
 * @see Egyseg
 */
public class Griff extends Egyseg {
    public Griff() {
        super();
        this.setNev("Griff");
        this.setAr(15);
        this.setSebzesLower(5);
        this.setSebzesUpper(10);
        this.setEletero(30);
        this.setSebesseg(7);
        this.setKezdemenyezes(15);
        this.setMarker("G");
        this.setFaj("Fey");
        //végtelen visszatámadás
        this.setSpecial("vegtelenVisszatamadas");
        if(this.getSpecial().equals("loves")){
            this.setRange(true);
        }else {
            this.setRange(false);
        }

    }
}
