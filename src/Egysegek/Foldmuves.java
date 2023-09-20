package Egysegek;
/**
 * Egy speciális harci egység típus
 * @see Egyseg
 */
public class Foldmuves extends Egyseg {

    public Foldmuves() {
    super();
    this.setNev("Foldmuves");
    this.setAr(2);
    this.setSebzesLower(1);
    this.setSebzesUpper(1);
    this.setEletero(3);
    this.setSebesseg(4);
    this.setKezdemenyezes(8);
    this.setMarker("F");
    this.setFaj("Ember");
    //nincs speciális képesség
        this.setSpecial("nincs");
        if(this.getSpecial().equals("loves")){
            this.setRange(true);
        }else {
            this.setRange(false);
        }
    }

    @Override
    public void Special(){
        System.out.println("Foldmuves Special");
    }
}
