package Varazslatok;
/**
 * A Feltamasztas egy speciális varazslas
 * @see Varazslas
 */
public class Feltamasztas extends Varazslas{

    public Feltamasztas() {
        super();
        this.setAr(120);
        this.setMannaCost(6);
        this.setNev("Feltamasztas");
        this.setLeiras("Egy kivalasztott sajat egyseg feltamasztasa. Maximalis gyogyítas merteke: (varazsero * 50) (de az eredeti egysegszamnal több nem lehet)");
    }
}
