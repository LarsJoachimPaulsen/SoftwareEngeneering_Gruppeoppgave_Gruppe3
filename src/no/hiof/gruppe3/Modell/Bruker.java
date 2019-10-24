package no.hiof.gruppe3.Modell;


// merge bruker og LagNyBruker, heller lage nyBruker som en metode.

// passord må hashes! MD5?
public class Bruker  {

    private String etternavn, fornavn, epost;
    private int alder;

    public Bruker(String etternavn, String fornavn, String epost, int alder){
        this.etternavn = etternavn;
        this.fornavn = fornavn;
        this.epost = epost;
        this.alder = alder;

    }

    public Bruker(){

    }

    public String getEtternavn() {
        return etternavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEpost() {
        return epost;
    }

    public int getAlder() {
        return alder;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }


}

