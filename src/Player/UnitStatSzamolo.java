package Player;

import Egysegek.Hos;
/**
 * Ez a class felel a hősök pontjainak a hatásainak érvényesítésért
 */
public class UnitStatSzamolo {
/**
 * Vezérli s statisztikák igazításának sorrendjét
 * @param hos akinek a pontjai alapján kell az egyébstatisztikáit igazítani
 * @version 1.0
 */
    public static void vezerlo(Hos hos){
        kezdemenyezesStatBeallito(hos);
        armorStatBeallitasa(hos);
        mannapoolStatBeallito(hos);
        critStatBeallito(hos);
    }

    /**
     * Az adott hős szerencs pontja alapján beállítja a critelés eséjét
     * @param hos
     */
    private static void critStatBeallito(Hos hos) {
        for (int i=0;i<hos.getUnit().size();i++){
            hos.getUnit().get(i).setCritChance(5*hos.getSzerencse());
            //System.out.println("Krit esely: "+hos.getUnit().get(i).getCritChance());
        }

    }

    /**
     * A hos mannáját állítja be
     * @param hos
     */
    private static void mannapoolStatBeallito(Hos hos) {
        hos.setMannaPool(10*hos.getTudas());
        //System.out.println("Manna pool: "+hos.getMannaPool());
    }

    /**
     * A hos egységeinek a védelmét állítja be
     * @param hos
     */
    private static void armorStatBeallitasa(Hos hos) {
        for (int i=0;i<hos.getUnit().size();i++){
            hos.getUnit().get(i).setArmor(hos.getVedekezes()*5);
            //System.out.println("Armor: "+hos.getUnit().get(i).getArmor());
        }

    }

    /**
     * A z egysegek kezdeményezését állítja be
     * @param hos
     */
    static void kezdemenyezesStatBeallito(Hos hos){
        //for (int i=0;i<hos.getUnit().size();i++){
            //System.out.println("Eleinte: "+hos.getUnit().get(i).getEgyseg().getNev()+" kezdemenyezes: "+hos.getUnit().get(i).getKezdemenyezes());
        //}
        //System.out.println("Moral: "+hos.getMoral());
        for (int i=0;i<hos.getUnit().size();i++){
            hos.getUnit().get(i).setKezdemenyezes(hos.getUnit().get(i).getKezdemenyezes()+hos.getMoral());
        }
        //for (int i=0;i<hos.getUnit().size();i++){
            //System.out.println("Utanna: "+hos.getUnit().get(i).getEgyseg().getNev()+" moral: "+hos.getUnit().get(i).getKezdemenyezes());
        //}

    }
}
