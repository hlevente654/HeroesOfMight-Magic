package Egysegek;

/**
 * Egy speciális harci egység típus
 * @see Egyseg
 */
public class PitFiend extends Egyseg {
    public PitFiend() {
        super();
        this.setNev("Pit Fiend");
        this.setAr(60);
        this.setSebzesLower(30);
        this.setSebzesUpper(50);
        this.setEletero(70);
        this.setSebesseg(4);
        this.setKezdemenyezes(2);
        this.setMarker("P");
        this.setFaj("Demon");
        //löves
        this.setSpecial("mozgas utan megtamad valamit");
        if(this.getSpecial().equals("loves")){
            this.setRange(true);
        }else {
            this.setRange(false);
        }
    }
}