package Varazslatok;
/**
 * A villámcsapás egy speciális varazslas
 * @see Varazslas
 */
public class Villamcsapas extends Varazslas{

    public Villamcsapas() {
        super();
        this.setAr(60);
        this.setMannaCost(5);
        this.setNev("Villamcsapas");
        this.setLeiras("Egy kivalasztott ellenseges egysegre (varazser * 30) sebzes okozasa");
    }

}
