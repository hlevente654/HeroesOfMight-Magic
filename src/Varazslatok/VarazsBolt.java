package Varazslatok;

import Kiegeszitok.Ellenorok;
import Egysegek.Hos;

import java.util.ArrayList;
import java.util.Arrays;

import static Kiegeszitok.Colours.ANSI_RESET;
import static Kiegeszitok.Colours.ANSI_YELLOW;
import static Main.Main.bekero;

/**
 * A Varázsboltban van minden varázslat amiket meg lehet venni
 *
 */
public  class VarazsBolt {
     private ArrayList<Varazslas> varazslatok = new ArrayList<>();

    public VarazsBolt() {
        Varazslas tuzlabda = new Tuzlabda();
        Varazslas villamcsapas = new Villamcsapas();
        Varazslas feltamasztas = new Feltamasztas();
        Varazslas atulvilaggiatok = new ATulvilagAtka();
        Varazslas netofamyntok = new NetOfAmyntok();
        this.varazslatok.addAll(Arrays.asList(tuzlabda, villamcsapas, feltamasztas, atulvilaggiatok, netofamyntok));
    }
    /**
     * A VarazsBazar lehet megvenni a varázslatokat a hősöknek
     * @param hos aki éppen varázslatot vesz
     * @see Hos
     */
    public void VarazsBazar(Hos hos){
        System.out.println("Ha nem akarsz varázslatot venni ird be: (tovabb)");
        boolean AkatszVarazsolni = true;
        String kommand;


        do {
            System.out.println("Vehető varázslatok: ");
            for (int i = 0;i< this.varazslatok.size();i++){
                System.out.println("("+(i+1)+")"+this.varazslatok.get(i).getNev()+" :. Ár: "+this.varazslatok.get(i).getAr()+". Manna Kölcseg: "+this.varazslatok.get(i).getMannaCost());
                System.out.println(this.varazslatok.get(i).getLeiras()+"\n");
            }
            System.out.println("Vasarlat vasarlasahoz ird be a varázslat számát.");


            boolean jokommand = false;
            do {
                kommand = bekero.nextLine();
                if (kommand.equals("1") || kommand.equals("2") || kommand.equals("3") || kommand.equals("4") || kommand.equals("5") || kommand.equals("tovabb")){
                    jokommand = true;
                }else{
                    System.out.println(ANSI_YELLOW+"Nincs ilyen kommand! Írj be mást."+ANSI_RESET);
                }
            }while (!jokommand);

            if(!kommand.equals("tovabb")){
                outerloop:
                for (int i = 0;i< this.varazslatok.size();i++){
                    if (Integer.parseInt(kommand) == (i+1)){
                        for (int t=0;t<hos.getTanultVarazslatok().size();t++){
                            if(this.varazslatok.get(i).getNev().equals(hos.getTanultVarazslatok().get(t).getNev())){
                                System.out.println(ANSI_YELLOW+"A hős már ismeri ezt a varazslatot!"+ANSI_RESET);
                                break outerloop;
                            }
                        }
                        if(Ellenorok.vanerapenz(this.varazslatok.get(i).getAr(), 1, hos.getJatekos())){
                            hos.getTanultVarazslatok().add(this.varazslatok.get(i));
                            hos.getJatekos().setArany(hos.getJatekos().getArany()-this.varazslatok.get(i).getAr());
                            System.out.println("Megvetted a(z): "+this.varazslatok.get(i).getNev()+"-t");
                        }else {
                            System.out.println(ANSI_YELLOW+"Nincs rá pénzed!"+ANSI_RESET);
                        }

                    }
                }
            }
            if(kommand.equals("tovabb")){
                AkatszVarazsolni = false;
            }
            System.out.println("-----------------------------");
            System.out.println("Jelenlegi varazslataid: ");
            if(hos.getTanultVarazslatok().size() == 0){
                System.out.println("-");
            }else{
                for (int i=0;i<hos.getTanultVarazslatok().size();i++){
                    System.out.print(hos.getTanultVarazslatok().get(i).getNev()+", ");
                }
            }
            System.out.println("Ha nem akarsz varázslatot venni ird be: (tovabb)");
            System.out.println("\nMég van: "+hos.getJatekos().getArany()+"\n");
        }while (AkatszVarazsolni);

    }
}
