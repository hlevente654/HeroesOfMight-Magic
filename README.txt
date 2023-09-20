A program belépési pontja a Main package-ben a Main class-ban van.
-------------------------------------------------------------------

A Játék indulásakor a konzolon kiírt módon kell nehézséget választani.
Ezitán lehet a hős pontjait elosztani. Elősször megadjuk hogy melyik tulajdonságot szeretnénk beállítani aztán kötőjel után
hogy mennyire akarjuk azt állítani.
Például 'AT-6' parancs hatra állítja a támadást.
Ha már elégedett vagy a pontjaiddal akkor írd be hogy 'tovabb'.

Ezután lehet varázslatot vásárolni a konzolon jelölt módon. Például a harmadik mágia megvételéhez írjuk be hogy '3'.
Ha már elégedett vagy a meglévő varázslataidal akkor írd be hogy 'tovabb'.

Ekkor tudunk egységeket venni. Megadjuk hogy miből és mennyit szeretnénk. Például '2-50'. Ennek hatására a kettes azonosítójú
egységből veszünk ötvenet. Ha nincs rá elég pénzünk akkor egyszerűen nem fognak csatlakozni hozzánk a harcosok. Kell hogy legyen legalább
egy egységed. Ha nincs elég pénzed egy egységre sem akkor egy darab Földműves megszán és csatlakozik hozzád ingyen.
Ha már elégedett vagy az egységeiddel akkor írd be hogy 'tovabb'.

Most láthatod a saját és az ellenfeled egységeit, pontjait és varázslatait.
Ekkor tudod elhelyezni a salyát egységeidet. Csak a 1-1 és 10-2 kórdináta között tudsz egységet elhelyezni.
Például ha a ball felső sarokba akarod rakni a második számú egységedet írd be hogy '1-1:2'

Ekkor kezdődik a csata fázis.A csata folyamán mindig amikor te rád kerül a sor tudsz választani hogy mit akarsz csinálni.
Ha eldöntötted add meg az annak megfelelő inputot amit a konzolon látsz. Ha egy egységgel mozogsz akkor az egységnek megadhatod
hogy hova mennyen. Ha a cél túl messzevan akkor egyszerűen addig megy ameddig van mozgása de célul megadni már foglalt
helyet nem lehet.


Egységek:
---------------------------------------------------------------------------------------------------------------------

Név            Ár   Sebzés  Életerő    Sebesség   Kezdeményezés Speciális_képesség
Földműves(F)   2     1-1      3          4            8               nincs

Íjász(I)          6     2-4      7          4            9               lövés 
								(ha egy ellenség a lövő mellett 
								áll akkor a lövő nem tud lőni és 
							      mive csak íllya van így támadni sem tud)

Griff(G)          15    5-10     30         7            15      végtelen visszatámadás

Kenntaur(L)       10    4-8      15         10           10      mozgas uttan ha van mellette ellenfel(vagy ellenfelek)
								akkor megtamad eggyet

Pit Fiend(P)      60   30-50     70           4           2         Cleav: amikor az egyseg tamad a célpontja 
								melletti egységeket is megüti legyen az ellenfel vagy barát

Varázslatok:
---------------------------------------------------------------------------------------------------------------------

Név              Ár         Manna                                 Varázslat_leírása
Villámcsapás     60           5				Egy kiválasztott ellenséges egységre
								(varázserő * 30) sebzés okozása

Tűzlabda         120          9
                                                   Egy kiválasztott mezőt körüli 3x3-as területen lévő
                                                       összes (saját, illetve ellenséges) egységre
                                                          (varázserő * 20) sebzés okozása

Feltámasztás     120          6                      Egy kiválasztott saját egység feltámasztása.
                                                     Maximális gyógyítás mértéke: (varázserő * 50)
                                                     (de az eredeti egységszámnál több nem lehet)

Net of Amyntok   150          10                     Egy kiválasztott mezőt körüli 3x3-as területen lévő 
						   összes egységet behálóz amitől nem tudnak mozogni 2 körig

A Túlvilág Átka  50           9                       A páján lévő összes egységet sebzi (varázserő * 10) kivéve 
							    a démonokat például a Pit Fiend
