package no.hiof.gruppe3.Modell;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Arrangement implements Serializable, Comparable<Arrangement>{

    private String navnPaaArrangement, sted;
    private LocalDate tidspunktForArrangement;
    private Klubb arrangerendeKlubb;
    private int antallBilletter, prisPaaBilletter, antallDeltakere;
    private ArrayList<Klubb> deltakendeKlubberListe = new ArrayList<>();
    private ArrayList<Bruker> deltakendeBrukereListe = new ArrayList<>();

    public Arrangement(){};

    public Arrangement(String navnPaaArrangement,Klubb arrangerendeKlubb ,String sted, LocalDate tidspunktForArrangement,int antallBilletter
            , int prisPaaBilletter, int antallDeltakere){

        this.navnPaaArrangement = navnPaaArrangement;
        this.arrangerendeKlubb = arrangerendeKlubb;
        this.sted = sted;
        this.antallBilletter = antallBilletter;
        this.prisPaaBilletter = prisPaaBilletter;
        this.antallDeltakere = antallDeltakere;

        //Kaller på metoden som sjekker om arrangementsdato som settes i konstruktøren er gyldig eller ikke.
        //hvis datoen er ugyldig, får arrangører en feilmelding.

        setTidspunktForArrangement(tidspunktForArrangement);
    }


    public void leggTilDeltakerIListe(Bruker bruker){

        if(antallDeltakere > 0){
            deltakendeBrukereListe.add(bruker);
            antallDeltakere--;
        }
        else{
            System.out.println("Det er ikke nok plass");
        }
    }

    public void leggTilDeltakendeKlubber(Klubb klubb){
        deltakendeKlubberListe.add(klubb);
    }

    public void leggTilFlereDeltakere(ArrayList<Bruker> listeMedBrukere){

        if(antallDeltakere > listeMedBrukere.size()) {
            for (int i = 0; i < listeMedBrukere.size(); i++) {

                leggTilDeltakerIListe(listeMedBrukere.get(i));
            }
        }
        else{
            System.out.println("Det er ikke nok plass til alle brukerne");
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

    public int getAntallDeltakere() {
        return antallDeltakere;
    }

    public void setDeltakendeKlubberListe(ArrayList<Klubb> deltakendeKlubberListe) {
        this.deltakendeKlubberListe = deltakendeKlubberListe;
    }

    public ArrayList<Bruker> getDeltakendeBrukerListe() {
        return deltakendeBrukereListe;
    }

    public void setDeltakendeBrukereListe(ArrayList<Bruker> deltakendeBrukereListe) {
        this.deltakendeBrukereListe = deltakendeBrukereListe;
    }

    public void setAntallDeltakere(int antallDeltakere) {
        this.antallDeltakere = antallDeltakere;
    }


    public ArrayList<Arrangement> arrangementerDenSøkteKlubbenSkalArrangere(ArrayList<Arrangement> arr, String klubbNavn){

        ArrayList<Arrangement> arrangementliste = new ArrayList<>();

        for(Arrangement r : arr){
            if(r.getArrangerendeKlubb().getNavn() == klubbNavn) arrangementliste.add(r);
        }

        return arrangementliste;
    }

    @Override
    public int compareTo(Arrangement arrangement) {
        return getTidspunktForArrangement().compareTo(arrangement.getTidspunktForArrangement());
    }

    public String convertToNorsk(){

        String day = tidspunktForArrangement.getDayOfWeek().toString();

        if( day.equals("MONDAY")) day = "Mandag";
        if( day.equals("TUESDAY")) day = "Tirsdag";
        if( day.equals("WEDNESDAY")) day = "Onsdag";
        if( day.equals("THURSDAY")) day = "Tirsdag";
        if( day.equals("FRIDAY")) day = "Fredag";
        if( day.equals("SATURDAY")) day = "Lørdag";
        if( day.equals("SUNDAY")) day = "Søndag";

        return day;
    }


    @Override
    public String toString(){

        return navnPaaArrangement+" vil bli arrangert i "+sted+" på "+convertToNorsk()
                + " \""+tidspunktForArrangement.getDayOfMonth() +"-"+tidspunktForArrangement.getMonth()
                +"-"+tidspunktForArrangement.getYear()+" pris per billett: "+ prisPaaBilletter+"kr\n";
    }



}
