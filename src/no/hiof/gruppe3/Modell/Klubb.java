package no.hiof.gruppe3.Modell;

import java.io.Serializable;
import java.util.ArrayList;

public class Klubb implements Serializable {

    private String navn, addresse;
    private int postnummer;
    private ArrayList<Bruker> klubbmedlemmer;

    //Muligheter for flere kontakpersoner, en liste her istedenfor?
    private Bruker kontaktperson;
    private ArrayList<Bruker> brukerliste = new ArrayList<Bruker>();
    private ArrayList<String> sportsliste = new ArrayList<String>();

    public Klubb(){};
    public Klubb(String navn, String addresse, int postnummer){
        this.navn = navn;
        this.addresse = addresse;
        this.postnummer = postnummer;
    }


    public void leggTilSport(String nySport){

        sportsliste.add(nySport);

    }

    public void leggTilBruker(Bruker nyBruker){

        brukerliste.add(nyBruker);

    }


    public void setNavn(String navn) { this.navn = navn; }

    public void setAddresse(String addresse) { this.addresse = addresse; }

    public void setPostnummer(int postnummer) { this.postnummer = postnummer; }

    public void setKlubbmedlemmer(ArrayList<Bruker> klubbmedlemmer) { this.klubbmedlemmer = klubbmedlemmer; }

    public void setKontaktperson(Bruker kontaktperson) { this.kontaktperson = kontaktperson; }

    public String getNavn() { return navn; }

    public String getAddresse() { return addresse; }

    public int getPostnummer() { return postnummer; }

    public ArrayList<Bruker> getKlubbmedlemmer() { return klubbmedlemmer; }

    public Bruker getKontaktperson() { return kontaktperson; }

    @Override
    public String toString(){

        return navn;
    }

}
