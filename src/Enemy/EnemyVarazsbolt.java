package Enemy;

import Egysegek.Hos;
import Varazslatok.*;

import java.util.ArrayList;

/**
 * A gép innen tud varázslatokat venni
 */
public class EnemyVarazsbolt {

    private ArrayList<Varazslas> enemyVarazslatok = new ArrayList<>();
    public EnemyVarazsbolt() {
        Varazslas Tuzlabda = new Tuzlabda();
        Varazslas Villamcsapas = new Villamcsapas();
        Varazslas Feltamasztas = new Feltamasztas();
        this.enemyVarazslatok.add(Tuzlabda);
        this.enemyVarazslatok.add(Villamcsapas);
        this.enemyVarazslatok.add(Feltamasztas);
    }

    public void EnemyVarazsBazar(Hos hos){
        int enemyNumberOfKnownMagic = (int) (Math.random()*(enemyVarazslatok.size()));
        System.out.println("Tudni kene: "+enemyNumberOfKnownMagic);
        for(int i=0;i<enemyNumberOfKnownMagic;i++){
            int enemyVehetoMagic = (int) (Math.random()*(enemyVarazslatok.size()));

            hos.getTanultVarazslatok().add(enemyVarazslatok.get(enemyVehetoMagic));
            hos.getJatekos().setArany((hos.getJatekos().getArany())-(enemyVarazslatok.get(enemyVehetoMagic).getAr()));
            enemyVarazslatok.remove(enemyVehetoMagic);

            if(enemyVarazslatok.size() == 0){
                break;
            }
        }
        //System.out.println("Arany maradt: "+hos.getJatekos().getArany());

    }
}
