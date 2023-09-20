package Player;

/**
 * A játékos class
 * A játékosnak van aranya
 */
public class Jatekos {
    private int arany;

    /**
     * A kapott nehézség alapján kap aranyat a játékos
     * @param nehezseg
     */
    public Jatekos(String nehezseg) {
        if(nehezseg.equals("e")){
            this.arany = 1300;
            System.out.println("Van "+this.arany+" g. Könnyű lessz!");
        }
        if (nehezseg.equals("m")){
            this.arany = 1000;
            System.out.println("Van "+this.arany+" g. Kiegyensulyozott lessz!");
        }
        if(nehezseg.equals("d")){
            this.arany = 700;
            System.out.println("Van "+this.arany+" g. Nehez lessz!");
        }
    }

    /**
     * Visszaadja az adott játékos jelenlegi aranyát
     * @return
     */
    public int getArany() {
        return arany;
    }

    /**
     * Beállítja a szóbanforgó játékos aranyát
     * @param arany
     */

    public void setArany(int arany) {
        this.arany = arany;
    }
}
