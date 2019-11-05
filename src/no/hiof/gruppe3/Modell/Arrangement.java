package no.hiof.gruppe3.Modell;

import java.time.LocalDate;
import java.util.ArrayList;

public class Arrangement {

    private String navnPaaArrangement, sted;
    private LocalDate tidspunktForArrangement;
    private Klubb arrangerendeKlubb;
    private int antallBilletter, prisPaaBilletter;
    private ArrayList<Klubb> deltakendeKlubberListe = new ArrayList<Klubb>();


    public String getNavnPaaArrangement() {
        return navnPaaArrangement;
    }

    public void setNavnPaaArrangement(String navnPaaArrangement) {
        this.navnPaaArrangement = navnPaaArrangement;
    }

    public String getSted() {
        return sted;
    }

    public void setSted(String sted) {
        this.sted = sted;
    }

    public LocalDate getTidspunktForArrangement() {
        return tidspunktForArrangement;
    }

    public void setTidspunktForArrangement(LocalDate tidspunktForArrangement) {
        this.tidspunktForArrangement = tidspunktForArrangement;
    }

    public Klubb getArrangerendeKlubb() {
        return arrangerendeKlubb;
    }

    public void setArrangerendeKlubb(Klubb arrangerendeKlubb) {
        this.arrangerendeKlubb = arrangerendeKlubb;
    }

    public int getAntallBilletter() {
        return antallBilletter;
    }

    public void setAntallBilletter(int antallBilletter) {
        this.antallBilletter = antallBilletter;
    }

    public int getPrisPaaBilletter() {
        return prisPaaBilletter;
    }

    public void setPrisPaaBilletter(int prisPaaBilletter) {
        this.prisPaaBilletter = prisPaaBilletter;
    }

    public ArrayList<Klubb> getDeltakendeKlubberListe() {
        return deltakendeKlubberListe;
    }

    public void setDeltakendeKlubberListe(ArrayList<Klubb> deltakendeKlubberListe) {
        this.deltakendeKlubberListe = deltakendeKlubberListe;
    }
}
