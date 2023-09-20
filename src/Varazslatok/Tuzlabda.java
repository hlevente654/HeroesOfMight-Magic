package Varazslatok;

/**
 * A Tuzlabda egy speciális varazslas
 * @see Varazslas
 */
public class Tuzlabda extends Varazslas{

    public Tuzlabda() {
        super();
        this.setAr(120);
        this.setMannaCost(9);
        this.setNev("Tuzlabda");
        this.setLeiras("Egy kiválasztott mezo körüli 3x3-as területen levö összes (sajat, illetve ellenseges) egysegre (varazser * 20) sebzes okozasa");
    }
}
