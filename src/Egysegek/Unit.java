package Egysegek;

/**
 * Az Unit egy ugyanolyan tipusú elemekből álló harckész csapat
 */

public class Unit {
    private int oszlop;
    private int sor;
    private int menyiseg;
    private Egyseg egyseg;
    private int egysegSebzesLower;
    private int egysegSebzesUpper;
    private int egysegEletero;
    private int kezdemenyezes;
    private int armor;
    private int critChance;
    private boolean jatekosEe;
    private boolean visszatamadhat;
    private int maximumEgysegSzam;
    private int maximumHP;
    private int baseSpade;
    private int currentSpeed;
    private int rootTurns;
    private boolean allapotVoltMarNezve;


    public Unit(Egyseg mifeleEgyseg, int mennnyi) {
        this.egyseg = mifeleEgyseg;
        this.menyiseg = mennnyi;
        this.egysegSebzesLower = this.menyiseg * this.egyseg.getSebzesLower();
        this.egysegSebzesUpper = this.menyiseg *this.egyseg.getSebzesUpper();
        this.egysegEletero = this.menyiseg * this.egyseg.getEletero();
        this.kezdemenyezes = this.egyseg.getKezdemenyezes();
        this.armor = 0;
        critChance = 0;
        this.jatekosEe = false;
        this.baseSpade = mifeleEgyseg.getSebesseg();
        this.currentSpeed = mifeleEgyseg.getSebesseg();
        allapotVoltMarNezve = false;
    }

    public boolean isAllapotVoltMarNezve() {
        return allapotVoltMarNezve;
    }

    public void setAllapotVoltMarNezve(boolean allapotVoltMarNezve) {
        this.allapotVoltMarNezve = allapotVoltMarNezve;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public int getRootTurns() {
        return rootTurns;
    }

    public void setRootTurns(int rootTurns) {
        this.rootTurns = rootTurns;
    }

    public void setMaximumEgysegSzam(int maximumEgysegSzam) {
        this.maximumEgysegSzam = maximumEgysegSzam;
    }

    public void setMaximumHP(int maximumHP) {
        this.maximumHP = maximumHP;
    }

    public int getMaximumHP() {
        return maximumHP;
    }

    public boolean isVisszatamadhat() {
        return visszatamadhat;
    }

    public void setVisszatamadhat(boolean visszatamadhat) {
        this.visszatamadhat = visszatamadhat;
    }

    public boolean isJatekosEe() {
        return jatekosEe;
    }

    public void setJatekosEe(boolean jatekosEe) {
        this.jatekosEe = jatekosEe;
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getKezdemenyezes() {
        return kezdemenyezes;
    }

    public void setKezdemenyezes(int kezdemenyezes) {
        this.kezdemenyezes = kezdemenyezes;
    }

    public void LetszamNoveles(int ujHus){
        this.menyiseg = this.menyiseg + ujHus;
        this.egysegSebzesLower = this.menyiseg * this.egyseg.getSebzesLower();
        this.egysegSebzesUpper = this.menyiseg *this.egyseg.getSebzesUpper();
        this.egysegEletero = this.menyiseg * this.egyseg.getEletero();
    }

    public int getOszlop() {
        return oszlop;
    }

    public void setOszlop(int oszlop) {
        this.oszlop = oszlop;
    }

    public int getSor() {
        return sor;
    }

    public void setSor(int sor) {
        this.sor = sor;
    }

    public int getEgysegEletero() {
        return egysegEletero;
    }

    public void setEgysegEletero(int egysegEletero) {
        this.egysegEletero = egysegEletero;
    }

    public int getEgysegSebzesLower() {
        return egysegSebzesLower;
    }

    public int getEgysegSebzesUpper() {
        return egysegSebzesUpper;
    }

    public Egyseg getEgyseg() {
        return egyseg;
    }

    public void setEgyseg(Egyseg egyseg) {
        this.egyseg = egyseg;
    }

    public int getMenyiseg() {
        return menyiseg;
    }

    public void setMenyiseg(int menyiseg) {
        this.menyiseg = menyiseg;
    }
}
