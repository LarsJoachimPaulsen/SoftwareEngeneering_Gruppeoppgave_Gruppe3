package no.hiof.gruppe3.Modell;

import java.util.ArrayList;

public class Klubb {

    private String navn;

    //Muligheter for flere kontakpersoner, en liste her istedenfor?
    private Bruker kontaktperson;
    private ArrayList<Bruker> brukerliste = new ArrayList<Bruker>();
    private ArrayList<String> sportsliste = new ArrayList<String>();





    public void leggTilSport(String nySport){

        sportsliste.add(nySport);

    }

    public void leggTilBruker(Bruker nyBruker){

        brukerliste.add(nyBruker);

    }


}
