package Enemy;

import Kiegeszitok.Ellenorok;
import Player.Jatekos;
import Egysegek.Hos;

/**
 * Egy speciális hős fajta, ellenséges/gép hős.
 */
public class EnemyHero extends Hos {

    public EnemyHero(Jatekos jatekos) {
        super(jatekos);
        EllenfelPontEloszto();
    }

    /**
     * Ellenfél hős pontjainak elosztása itt történik
     */
    private void EllenfelPontEloszto(){
        //500 g max pontokra
        int pontraElkoltott = 0 ;
        int pontElosztoValaszto = 0;
        int pontraMaxElkoltheto = (int)(Math.random()*(501-50)+50);
                do{
                    pontElosztoValaszto =(int) (Math.random()*(7-1)+1);
                    //System.out.println(pontElosztoValaszto);
                    if(pontElosztoValaszto == 1){
                        if (!Ellenorok.lehetNovelni(this.getTamadas(), this.getJatekos())){
                        }else{
                            this.raseTamadas();
                            pontraElkoltott = 1000-this.getJatekos().getArany();
                        }
                    }
                    if(pontElosztoValaszto == 2){
                        if (!Ellenorok.lehetNovelni(this.getVedekezes(), this.getJatekos())){
                        }else{
                            this.raseVedekezes();
                            pontraElkoltott = 1000-this.getJatekos().getArany();
                        }
                    }
                    if(pontElosztoValaszto == 3){
                        if (!Ellenorok.lehetNovelni(this.getVarazsero(), this.getJatekos())){
                        }else{
                            this.raseVarazsero();
                            pontraElkoltott = 1000-this.getJatekos().getArany();
                        }
                    }
                    if(pontElosztoValaszto == 4){
                        if (!Ellenorok.lehetNovelni(this.getTudas(), this.getJatekos())){
                        }else{
                            this.raseTudas();
                            pontraElkoltott = 1000-this.getJatekos().getArany();
                        }
                    }
                    if(pontElosztoValaszto == 5){
                        if (!Ellenorok.lehetNovelni(this.getMoral(), this.getJatekos())){
                        }else{
                            this.raseMoral();
                            pontraElkoltott = 1000-this.getJatekos().getArany();
                        }
                    }
                    if(pontElosztoValaszto == 6){
                        if (!Ellenorok.lehetNovelni(this.getSzerencse(), this.getJatekos())){
                        }else{
                            this.raseSzerencse();
                            pontraElkoltott = 1000-this.getJatekos().getArany();
                        }
                    }
                }
                while (pontraElkoltott < pontraMaxElkoltheto);
                EnemyVarazsbolt enemyVarazsbolt = new EnemyVarazsbolt();
                enemyVarazsbolt.EnemyVarazsBazar(this);
                EnemyToborzo enemyToborzo = new EnemyToborzo();
                enemyToborzo.toborzas(this);

                //
                //    System.out.println("Ellenfel pontjai: ");
                //    System.out.println("Tamadas : "+this.getTamadas());
                //    System.out.println("Vedekezes : "+this.getVedekezes());
                //    System.out.println("Varazsero : "+this.getVarazsero());
                //    System.out.println("Tudas : "+this.getTudas());
                //    System.out.println("Moral : "+this.getMoral());
                //    System.out.println("Szerencse : "+this.getSzerencse());
                //    System.out.println("Maradt gold: "+this.getJatekos().getArany());

    }
}
