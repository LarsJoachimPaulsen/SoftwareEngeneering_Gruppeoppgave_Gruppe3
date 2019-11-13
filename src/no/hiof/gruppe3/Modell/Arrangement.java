package no.hiof.gruppe3.Modell;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Arrangement implements Serializable, Comparable<Arrangement>{

    private String navnPaaArrangement, sted;
    private LocalDate tidspunktForArrangement;
    private Klubb arrangerendeKlubb;
    private int antallBilletter = 100, prisPaaBilletter = 200;
    private ArrayList<Klubb> deltakendeKlubberListe = new ArrayList<>();
    private ArrayList<Bruker> deltakendeBrukereListe = new ArrayList<>();

    public Arrangement(){};

    public Arrangement(String navnPaaArrangement,Klubb arrangerendeKlubb ,String sted, LocalDate tidspunktForArrangement,int antallBilletter
            , int prisPaaBilletter){

        this.navnPaaArrangement = navnPaaArrangement;
        this.arrangerendeKlubb = arrangerendeKlubb;
        this.sted = sted;
        this.antallBilletter = antallBilletter;
        this.prisPaaBilletter = prisPaaBilletter;

        //Kaller på metoden som sjekker om arrangementsdato som settes i konstruktøren er gyldig eller ikke.
        //hvis datoen er ugyldig, får arrangører en feilmelding.

        setTidspunktForArrangement(tidspunktForArrangement);
    };


    public void leggTilDeltakerIListe(Bruker bruker){

        deltakendeBrukereListe.add(bruker);
    }

    public void leggTilDeltakendeKlubber(Klubb klubb){
        deltakendeKlubberListe.add(klubb);
    }

    public void leggTilFlereDeltakere(ArrayList<Bruker> listeMedBrukere){

        for(int i = 0; i<listeMedBrukere.size(); i++){

            leggTilDeltakerIListe(listeMedBrukere.get(i));
        }

    }

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


    //ikke lov å sette arrangementsdato til en dato som er før dagensdato.
    // Dvs. at arrangement kan ikke settes til 15.10.2019 når i dag er 16.10.2019

    public void setTidspunktForArrangement(LocalDate tidspunktForArrangement) {


            if (tidspunktForArrangement.compareTo(LocalDate.now()) == 1)
                this.tidspunktForArrangement = tidspunktForArrangement;

            else if (tidspunktForArrangement.compareTo(LocalDate.now()) == 0)
                this.tidspunktForArrangement = tidspunktForArrangement;

            else
                System.out.println("arrangemtsdato du bruker er ugylidg.");
            }


    public Klubb getArrangerendeKlubb() { return arrangerendeKlubb; }

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

    public ArrayList<Bruker> getDeltakendeBrukereListe() {
        return deltakendeBrukereListe;
    }

    public void setDeltakendeBrukereListe(ArrayList<Bruker> deltakendeBrukereListe) {
        this.deltakendeBrukereListe = deltakendeBrukereListe;
    }

    @Override
    public int compareTo(Arrangement arrangement) {
        return getTidspunktForArrangement().compareTo(arrangement.getTidspunktForArrangement());
    }

    public String convertToNorsk(){

        String day = tidspunktForArrangement.getDayOfWeek().toString();

        if( day == "MANDAY") day = "Mandag";
        if( day == "TUESDAY") day = "Tirsdag";
        if( day == "WEDNESDAY") day = "Onsdag";
        if( day == "THURSDAY") day = "Tirsdag";
        if( day == "FRIDAY") day = "Fredag";
        if( day == "SATURDAY") day = "Lørdag";
        if( day == "SUNDAY") day = "Søndag";

        return day;
    }


    @Override
    public String toString(){

        return navnPaaArrangement+" vil bli arrangert i "+sted+" på "+convertToNorsk()
                + " \""+tidspunktForArrangement.getDayOfMonth() +"-"+tidspunktForArrangement.getMonth()
                +"-"+tidspunktForArrangement.getYear()+" pris per billett: "+ prisPaaBilletter+"kr\n";
    }



}
