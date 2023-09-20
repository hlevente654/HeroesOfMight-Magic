package Teszt;

import CsataMezo.Kor;
import Egysegek.Egyseg;
import Egysegek.Foldmuves;
import Egysegek.Hos;
import Egysegek.Unit;
import Kiegeszitok.Ellenorok;
import Player.Jatekos;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class TestEllenorok {



    @Test
    public void testIsHoleNumber(){
        assertFalse(Ellenorok.isHoleNumber("56.84"));
        assertTrue(Ellenorok.isHoleNumber("75"));
        assertFalse(Ellenorok.isHoleNumber("5fgh"));
    }
    @Test
    public void testVaneIlyenKordinata(){
        assertFalse(Ellenorok.vaneIlyenKordinata("0-5"));
        assertFalse(Ellenorok.vaneIlyenKordinata("fgh5\n"));
        assertTrue(Ellenorok.vaneIlyenKordinata("10-12"));
        assertFalse(Ellenorok.vaneIlyenKordinata("11-12"));
    }
    private ArrayList<Kor> egeszKor;
    private Unit elso,masodik;
    private Jatekos jatekos1,enemy;
    private Hos jatekosHos, gepHos;

    @BeforeEach
    public void setUp() {
        enemy = new Jatekos("m");
        jatekos1 = new Jatekos("e");
        jatekosHos = new Hos(jatekos1);
        gepHos = new Hos(enemy);
        Egyseg Foldmuves = new Foldmuves();
        Unit foldmuves = new Unit(Foldmuves,100);
        elso = new Unit(Foldmuves,100);
        masodik = new Unit(Foldmuves,200);
        egeszKor = new ArrayList<Kor>();

        elso.setEgyseg(Foldmuves);
        masodik.setEgyseg(Foldmuves);
        elso.setCurrentSpeed(5);
        elso.setSor(1);
        elso.setOszlop(1);
        elso.setMenyiseg(100);

        elso.setMenyiseg(100);
        elso.setJatekosEe(true);
        masodik.setCurrentSpeed(5);
        masodik.setOszlop(10);
        masodik.setSor(12);
        masodik.setMenyiseg(100);

        masodik.setMenyiseg(100);
        masodik.setJatekosEe(false);
        egeszKor.add(new Kor(9,elso));
        egeszKor.add(new Kor(9,masodik));
    }
    @Test
    public void testvaneOttAIEgyseg(){
        assertFalse(Ellenorok.vaneOttAIEgyseg("1-1",egeszKor));
        assertFalse(Ellenorok.vaneOttAIEgyseg("1-2",egeszKor));
        assertTrue(Ellenorok.vaneOttAIEgyseg("10-12",egeszKor));
        assertFalse(Ellenorok.vaneOttAIEgyseg("0-12",egeszKor));
        assertFalse(Ellenorok.vaneOttAIEgyseg("fgh-f-gh-fg",egeszKor));
    }

    @Test
    public void testVaneOttJatekosEgyseg(){
        assertTrue(Ellenorok.vaneOttJatekosEgyseg("1-1",egeszKor));
        assertFalse(Ellenorok.vaneOttJatekosEgyseg("1-2",egeszKor));
        assertFalse(Ellenorok.vaneOttJatekosEgyseg("10-12",egeszKor));
        assertFalse(Ellenorok.vaneOttJatekosEgyseg("0-12",egeszKor));
        assertFalse(Ellenorok.vaneOttJatekosEgyseg("fgh-f-gh-fg",egeszKor));
    }

    @Test
    public void testVaeRaPenz(){
        assertTrue(Ellenorok.vanerapenz(500,1,jatekos1));
        assertFalse(Ellenorok.vanerapenz(500,3,jatekos1));
        assertFalse(Ellenorok.vanerapenz(-50,3,jatekos1));
        assertFalse(Ellenorok.vanerapenz(50,-3,jatekos1));
        assertFalse(Ellenorok.vanerapenz(-50,-3,jatekos1));
    }


}
