package Varazslatok;

/**
 * A varazslas egy parent class a sima varázslatoknak
 * @see ATulvilagAtka
 * @see Feltamasztas
 * @see Tuzlabda
 * @see Villamcsapas
 * @see NetOfAmyntok
 */
public class Varazslas {
    private int ar;
    private int mannaCost;
    private String nev;
    private String leiras;

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public Varazslas() {

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

    public int getMannaCost() {
        return mannaCost;
    }

    public void setMannaCost(int mannaCost) {
        this.mannaCost = mannaCost;
    }
}
