package Enemy;
import Egysegek.Toborzo;
import Egysegek.Unit;
import Egysegek.Hos;

/**
 * A gép innen szerzi az egységeit
 */
public class EnemyToborzo extends Toborzo{

    public EnemyToborzo() {
        super();
    }

    /**
     * Itt veszi meg az egységeket
     * @param hos akinek a seregének a részei lesznek
     */
    @Override
    public void toborzas(Hos hos){
        boolean tudVenni = true;
        boolean vanEmarIlyen = false;
        int numberOfFails = 0;
        do {
            int melyikFalytaEgyseg = (int)(Math.random()*(this.getToborohato().size()));
            //System.out.println("melyikFalytaEgyseg: "+melyikFalytaEgyseg);
            int mennyit = (int)(Math.random()*(11-10)+10);
            int kolcseg = this.getToborohato().get(melyikFalytaEgyseg).getAr()*mennyit;
            if(kolcseg < hos.getJatekos().getArany()){

                for (int p = 0; p < hos.getBirtokoltUnitok().size(); p++) {
                    if (hos.getBirtokoltUnitok().get(p).getNev().equals(this.getToborohato().get(melyikFalytaEgyseg).getNev())) {
                        vanEmarIlyen = true;
                        break;
                    }
                }
                if(vanEmarIlyen){
                    //Mar van ilyen
                    for (int h = 0; h < hos.getUnit().size(); h++) {
                        if (hos.getUnit().get(h).getEgyseg().getNev().equals(this.getToborohato().get(melyikFalytaEgyseg).getNev())) {
                            hos.getUnit().get(h).LetszamNoveles(mennyit);
                        }
                    }
                }else{
                    //Meg nincs neki
                    hos.getUnit().add(new Unit(this.getToborohato().get(melyikFalytaEgyseg), mennyit));
                    hos.getBirtokoltUnitok().add(this.getToborohato().get(melyikFalytaEgyseg));
                }
                hos.getJatekos().setArany(hos.getJatekos().getArany()-kolcseg);
            }else{
                numberOfFails++;
            }
            //System.out.println("Van meg: "+hos.getJatekos().getArany());
            if(numberOfFails == 3){
                tudVenni = false;
            }
        }while (tudVenni == true );
        //for (int i=0;i<hos.getUnit().size();i++){
          //  System.out.println("Van: "+hos.getUnit().get(i).getEgyseg().getNev()+" van belole: "+hos.getUnit().get(i).getMenyiseg());
        //}

    }
}