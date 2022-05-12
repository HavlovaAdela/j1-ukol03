package cz.czechitas.ukol3.model;

import static java.lang.System.err;

public class Pocitac {
    public Boolean jeZapnuty;
    private Procesor cpu;
    private Pamet ram;
    private Disk pevnyDisk;
    private Disk druhyDisk;

    public Disk getDruhyDisk() {
        return druhyDisk;
    }

    public void setDruhyDisk(Disk druhyDisk) {
        this.druhyDisk = druhyDisk;
    }

    public boolean jeZapnuty() {
        return this.jeZapnuty;
    }

    public Procesor getCpu() {
        return cpu;
    }

    public void setCpu(Procesor cpu) {
        this.cpu = cpu;
    }

    public Pamet getRam() {
        return ram;
    }

    public void setRam(Pamet ram) {
        this.ram = ram;
    }

    public Disk getPevnyDisk() {
        return pevnyDisk;
    }

    public void setPevnyDisk(Disk pevnyDisk) {
        this.pevnyDisk = pevnyDisk;
    }

    @Override
    public String toString() {
        return "Adélky počítač - Cpu=" + cpu +
                ", ram=" + ram +
                ", pevneDisky=" + pevnyDisk +", "+ druhyDisk;
    }


    public void zapniSe() {
        if (jeZapnuty) {
            err.println("Počítač je už zapnutý, nezapínej ho podruhé, je zapnutý = " + jeZapnuty);

        } else if (cpu == null || ram == null || pevnyDisk == null) {
            err.println("Počítači chybí minimálně jedna z těcto součástí - pevný disk, procesor,paměť. Proto nelze zapnout.");
        } else {
            jeZapnuty = true;
            System.out.println("Počítač se zapnul, je zapnutý = " + jeZapnuty);

        }

    }

    public void vypniSe() {
        if (jeZapnuty) {
            jeZapnuty = false;
            System.out.println("Počítač se vypnul, je zapnutý = " + jeZapnuty);
        } else {
            System.out.println("Počítač je už vypnutý, je zapnutý = " + jeZapnuty);
        }
    }

    public void vytvorSouborOVelikosti(long velikost) {
        if (jeZapnuty) {
            if (velikost > (pevnyDisk.getKapacitaDisku() - pevnyDisk.getVyuziteMisto()) && velikost > (druhyDisk.getKapacitaDisku() - druhyDisk.getVyuziteMisto())) {
                err.println("Ani na jednom disku není dost místa.");
            } else if (velikost <= pevnyDisk.getKapacitaDisku() - pevnyDisk.getVyuziteMisto()) {
                pevnyDisk.setVyuziteMisto(pevnyDisk.getVyuziteMisto() + velikost);
            } else {
                druhyDisk.setVyuziteMisto(druhyDisk.getVyuziteMisto() + velikost);
            }
        } else {
            System.err.println("Počítač není zapnutý, žádný soubor na disk nepřidám");
        }
    }

    public void vymazSouboroVelikosti(long velikost) {
        if (jeZapnuty) {
            if ((pevnyDisk.getVyuziteMisto() - velikost) < 0 && (druhyDisk.getVyuziteMisto() - velikost) < 0) {
                err.println("Nemůžu vymazat soubor větší než kolik mám zapsáno dat.");
            } else if (velikost <= pevnyDisk.getVyuziteMisto()) {
                pevnyDisk.setVyuziteMisto(pevnyDisk.getVyuziteMisto() - velikost);
            } else {
                druhyDisk.setVyuziteMisto(druhyDisk.getVyuziteMisto() - velikost);
            }
        } else {
            err.println("Počítač není zapnutý, žádný soubor z disku nevymažu");
        }
    }
}


