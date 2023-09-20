package Varazslatok;
/**
 * A Túlvilági Átok egy speciális varazslas
 * @see Varazslas
 */
public class ATulvilagAtka extends Varazslas{

        public ATulvilagAtka() {
            super();
            this.setAr(50);
            this.setMannaCost(9);
            this.setNev("A Túlvilág Átka");
            this.setLeiras("A páján lévő összes egységet sebzi (varázserő * 10) kivéve a démonokat például a Pit Fiend");
        }

}
