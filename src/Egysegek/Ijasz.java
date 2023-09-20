package Egysegek;
/**
 * Egy speciális harci egység típus
 * @see Egyseg
 */
public class Ijasz extends Egyseg {
    public Ijasz() {
        super();
        this.setNev("Ijasz");
        this.setAr(6);
        this.setSebzesLower(2);
        this.setSebzesUpper(4);
        this.setEletero(7);
        this.setSebesseg(4);
        this.setKezdemenyezes(9);
        this.setMarker("I");
        this.setFaj("Ember");
        //löves
        this.setSpecial("loves");
        if(this.getSpecial().equals("loves")){
            this.setRange(true);
        }else {
            this.setRange(false);
        }
    }
}
