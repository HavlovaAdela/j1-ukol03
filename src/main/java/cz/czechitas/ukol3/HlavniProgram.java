package cz.czechitas.ukol3;

import cz.czechitas.ukol3.model.Disk;
import cz.czechitas.ukol3.model.Pamet;
import cz.czechitas.ukol3.model.Pocitac;
import cz.czechitas.ukol3.model.Procesor;

import java.sql.SQLOutput;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {
        Procesor adelkyProcesor = new Procesor("Intel Core", 2_100_000_000L);
        Disk adelkyDisk = new Disk(237_000_000_000L, 236_000_000_000L);
        Pamet adelkyPamet = new Pamet(8_000_000_000_000L);
        Disk adelkyDruhyDisk = new Disk(237_000_000_000L, 1_000_000_000L);

        Pocitac adelkyPocitac = new Pocitac();
        adelkyPocitac.setCpu(adelkyProcesor);
        adelkyPocitac.setRam(adelkyPamet);
        adelkyPocitac.setPevnyDisk(adelkyDisk);
        adelkyPocitac.setDruhyDisk(adelkyDruhyDisk);


        adelkyPocitac.jeZapnuty = false;
        adelkyPocitac.zapniSe();
        adelkyPocitac.vypniSe();
        adelkyPocitac.vypniSe(); //kontrola pro druhé vypnutí
        adelkyPocitac.zapniSe();
        adelkyPocitac.zapniSe(); //kontrola pro druhé zapnutí

        //zapíše na první disk
        adelkyPocitac.vytvorSouborOVelikosti(1_000_0000_000L);
        //zapíše na druhý disk, na prvním není místo na tak velký soubor
        adelkyPocitac.vytvorSouborOVelikosti(2_000_0000_000L);
        //kontrola pro chybovou hlášku - na discích není dost místa na tak velký soubor
        adelkyPocitac.vytvorSouborOVelikosti(1_000_000_000_000_000L);

        //vymaže soubor z prvního disku
        adelkyPocitac.vymazSouboroVelikosti(236_000_000_000L);
//vymaže soubor z druhého disku
        adelkyPocitac.vymazSouboroVelikosti(1_000_000_000L);
//chybová hláška, když mažu větší soubor než lze vymazat
        adelkyPocitac.vymazSouboroVelikosti(1_000);

        System.out.println(adelkyProcesor);
        System.out.println(adelkyDisk);
        System.out.println(adelkyDruhyDisk);
        System.out.println(adelkyPamet);
        System.out.println(adelkyPocitac);

    }

}
