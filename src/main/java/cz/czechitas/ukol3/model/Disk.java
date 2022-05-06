package cz.czechitas.ukol3.model;

public class Disk {
    private long kapacitaDisku;
    private long vyuziteMisto;

    public Disk (long kapacitaDisku, long vyuziteMisto){
        this.kapacitaDisku=kapacitaDisku;
        this.vyuziteMisto=vyuziteMisto;
    }
    public long getKapacitaDisku() {
        return kapacitaDisku;
    }

    public void setKapacitaDisku(long kapacitaDisku) {
        this.kapacitaDisku = kapacitaDisku;
    }

    public long getVyuziteMisto() {
        return vyuziteMisto;
    }

    public void setVyuziteMisto(long vyuziteMisto) {
        this.vyuziteMisto = vyuziteMisto;
    }

    @Override
    public String toString() {
        return "kapacita Disku je " + kapacitaDisku + " b, "+ "vyuziteMisto je " + vyuziteMisto + " b";
    }
}
