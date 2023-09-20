package Varazslatok;
/**
 * A Net Of Amyntok egy speciális varazslas
 * @see Varazslas
 */
public class NetOfAmyntok extends Varazslas{

        public NetOfAmyntok() {
            super();
            this.setAr(150);
            this.setMannaCost(10);
            this.setNev("Net of Amyntok");
            this.setLeiras("Egy kiválasztott mezőt körüli 4x4-as területen lévő összes egységet behálóz amitől nem tudnak mozogni 2 körig");
        }


}
