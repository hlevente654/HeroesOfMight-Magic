package Egysegek;
/**
 * Egy speciális harci egység típus
 * @see Egyseg
 */
public class Kenntaur extends Egyseg {
    public Kenntaur() {
        super();
        this.setNev("Kenntaur");
        this.setAr(10);
        this.setSebzesLower(4);
        this.setSebzesUpper(8);
        this.setEletero(15);
        this.setSebesseg(10);
        this.setKezdemenyezes(10);
        this.setMarker("L");
        this.setFaj("Fey");
        //löves
        this.setSpecial("mozgas utan megtamad valamit");
        if(this.getSpecial().equals("loves")){
            this.setRange(true);
        }else {
            this.setRange(false);
        }
    }
}