package Teszt;
import Csata.Sebzes;
import CsataMezo.Kor;
import CsataMezo.Mezo;
import Egysegek.*;
import Kiegeszitok.Ellenorok;
import Player.Jatekos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class TestSebzes {
    private ArrayList<Kor> egeszKor;
    private Unit elso,masodik,harmadik;
    private Jatekos jatekos1,enemy;
    private Hos jatekosHos, gepHos;
    private Mezo mezo;

    @BeforeEach
    public void setUp() {
        mezo = new Mezo();
        enemy = new Jatekos("m");
        jatekos1 = new Jatekos("e");
        jatekosHos = new Hos(jatekos1);
        for (int i=0;i<5;i++){
            jatekosHos.raseTamadas();
        }
        gepHos = new Hos(enemy);
        Egyseg Foldmuves = new Foldmuves();
        Egyseg Griff = new Griff();
        Unit foldmuves = new Unit(Foldmuves,100);
        elso = new Unit(Foldmuves,100);
        masodik = new Unit(Foldmuves,200);
        harmadik = new Unit(Griff,100);
        egeszKor = new ArrayList<Kor>();

        elso.setEgyseg(Foldmuves);
        masodik.setEgyseg(Foldmuves);
        harmadik.setEgyseg(Griff);

        elso.setCurrentSpeed(5);
        elso.setSor(1);
        elso.setOszlop(1);
        elso.setMenyiseg(100);

        elso.setJatekosEe(true);
        masodik.setCurrentSpeed(5);
        masodik.setOszlop(10);
        masodik.setSor(12);
        masodik.setMenyiseg(200);

        harmadik.setCurrentSpeed(5);
        harmadik.setOszlop(2);
        harmadik.setSor(2);
        harmadik.setMenyiseg(100);
        harmadik.setJatekosEe(true);


        masodik.setJatekosEe(false);
        egeszKor.add(new Kor(9,elso));
        egeszKor.add(new Kor(9,masodik));
        egeszKor.add(new Kor(10,harmadik));
    }

    @Test
    public void testHosTamad(){
        System.out.println(jatekosHos.getTamadas());
        assertEquals(60,Sebzes.HosTamad(mezo,elso,egeszKor,jatekosHos,gepHos));
        assertNotEquals(50,Sebzes.HosTamad(mezo,elso,egeszKor,jatekosHos,gepHos));
        assertNotEquals(60,Sebzes.HosTamad(mezo,masodik,egeszKor,gepHos,jatekosHos));
    }
    @Test
    public void testSebzodes(){
        //System.out.println(masodik.getMenyiseg());
        Sebzes.sebzodes(masodik,100);
        assertEquals(167,masodik.getMenyiseg());
        assertNotEquals(166,masodik.getMenyiseg());
        Sebzes.sebzodes(masodik,100000000);
        assertTrue(masodik.getMenyiseg() < 0);
    }

    @Test
    public void testEgysegMeghal(){
        int ez=0;
        if(ez == 1){
            Sebzes.egysegMeghal(masodik,egeszKor,mezo);
            assertEquals(1,egeszKor.size());
            assertNotEquals(2,egeszKor.size());
            assertNotEquals(0,egeszKor.size());
        }else {
            Sebzes.egysegMeghal(elso,egeszKor,mezo);
            assertEquals(1,egeszKor.size());
            assertNotEquals(2,egeszKor.size());
            assertNotEquals(0,egeszKor.size());
        }
    }

    @Test
    public void testEgysegSebzesKiszamitasa(){
        jatekosHos.setSzerencse(0);
        assertEquals(152,Sebzes.EgysegSebzesKiszamitasa(elso,masodik,jatekosHos,gepHos,egeszKor,mezo));
        jatekosHos.setSzerencse(20);
        assertEquals(304,Sebzes.EgysegSebzesKiszamitasa(elso,masodik,jatekosHos,gepHos,egeszKor,mezo));
        assertNotEquals(0,Sebzes.EgysegSebzesKiszamitasa(elso,masodik,jatekosHos,gepHos,egeszKor,mezo));
    }

    @Test
    public void testvisszatamadas(){
        jatekosHos.setSzerencse(0);
        gepHos.setSzerencse(0);
        Sebzes.visszatamadas(masodik,elso,gepHos,jatekosHos,egeszKor,mezo);
        int elsoHp = masodik.getMenyiseg();
        Sebzes.visszatamadas(masodik,elso,gepHos,jatekosHos,egeszKor,mezo);
        int masodikHp = masodik.getMenyiseg();
        assertEquals(elsoHp,masodikHp);

        Sebzes.visszatamadas(elso,masodik,jatekosHos,gepHos,egeszKor,mezo);
         elsoHp = elso.getMenyiseg();
        Sebzes.visszatamadas(elso,masodik,jatekosHos,gepHos,egeszKor,mezo);
         masodikHp = elso.getMenyiseg();
        assertEquals(elsoHp,masodikHp);

        Sebzes.visszatamadas(masodik,harmadik,gepHos,jatekosHos,egeszKor,mezo);
        elsoHp = masodik.getMenyiseg();
        //System.out.println("FGHFGHF: "+masodik.getMenyiseg());
        Sebzes.visszatamadas(masodik,harmadik,gepHos,jatekosHos,egeszKor,mezo);
        masodikHp = masodik.getMenyiseg();
        assertNotEquals(elsoHp,masodikHp);
        //System.out.println("FGHFGHF: "+masodik.getMenyiseg());
    }

}
