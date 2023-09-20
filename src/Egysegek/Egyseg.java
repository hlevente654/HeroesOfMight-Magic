package Egysegek;


/**
 * Minden harci egység szülő class-a
 */
public class Egyseg {
    private String faj;
    private String marker;
    private String nev;
    private int ar;
    private int sebzesLower;
    private int sebzesUpper;
    private int eletero;
    private int sebesseg;
    private int kezdemenyezes;
    private String special;
    private boolean range;

    public boolean isRange() {
        return range;
    }

    public String getFaj() {
        return faj;
    }

    public void setFaj(String faj) {
        this.faj = faj;
    }

    public void setRange(boolean range) {
        this.range = range;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public int getSebzesLower() {
        return sebzesLower;
    }

    public void setSebzesLower(int sebzesLower) {
        this.sebzesLower = sebzesLower;
    }

    public int getSebzesUpper() {
        return sebzesUpper;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setSebzesUpper(int sebzesUpper) {
        this.sebzesUpper = sebzesUpper;
    }

    public int getEletero() {
        return eletero;
    }

    public void setEletero(int eletero) {
        this.eletero = eletero;
    }

    public int getSebesseg() {
        return sebesseg;
    }

    public void setSebesseg(int sebesseg) {
        this.sebesseg = sebesseg;
    }

    public int getKezdemenyezes() {
        return kezdemenyezes;
    }

    public void setKezdemenyezes(int kezdemenyezes) {
        this.kezdemenyezes = kezdemenyezes;
    }

    public void Special(){
        System.out.println("special");
    }
}
