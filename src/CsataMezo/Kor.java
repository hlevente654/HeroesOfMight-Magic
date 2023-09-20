package CsataMezo;

import Egysegek.Unit;

/**
 * A kor ami tartalmazza a még élő egységeket és a kezdeményezésük alapján a sorrendjüket
 */
public class Kor implements Comparable<Kor> {

    private int kezdemenyezes;
    private Unit egyseg;

    public Kor(int kezdemenyezes, Unit egyseg) {
        this.kezdemenyezes = kezdemenyezes;
        this.egyseg = egyseg;
    }
    @Override
    public int compareTo(Kor e) {
        return (this.getKezdemenyezes() - e.kezdemenyezes);
    }


    public Unit getEgyseg() {
        return egyseg;
    }

    public void setEgyseg(Unit egyseg) {
        this.egyseg = egyseg;
    }

    public int getKezdemenyezes() {
        return kezdemenyezes;
    }

    public void setKezdemenyezes(int kezdemenyezes) {
        this.kezdemenyezes = kezdemenyezes;
    }
}
