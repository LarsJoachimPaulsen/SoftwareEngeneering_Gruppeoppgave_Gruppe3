package no.hiof.gruppe3.Modell;


// merge bruker og LagNyBruker, heller lage nyBruker som en metode.

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Bruker implements Serializable {

    private String etternavn, fornavn, epost, passord, brukernavn;
    private int alder;
    private long telefonnummer;
    private boolean brukerErKlubb;
    private ArrayList<Arrangement> arrangementerBrukerSkalPaa;

    // telefonnummer må legges inn i konstruktør
    public Bruker(String brukernavn, String fornavn, String etternavn, String epost, String passord, int alder){
        this.etternavn = etternavn;
        this.fornavn = fornavn;
        this.brukernavn = brukernavn;
        this.epost = epost;
        this.passord = MD5Hashing(passord);
        this.alder = alder;
    }

    public Bruker(){

    }


    // produserer en MD5Has av passordet.
    public String MD5Hashing (String passord){

        String passordMedSalt = passord + "t0¤+214";
        String md5Passord = null;

        try{

            MessageDigest brytNedPassord = MessageDigest.getInstance("MD5");

            brytNedPassord.update(passordMedSalt.getBytes());

            byte[] bytes = brytNedPassord.digest();

            StringBuilder byggMD5 = new StringBuilder();

            for(int i = 0; i < bytes.length; i++){

                byggMD5.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            md5Passord = byggMD5.toString();


        }
        catch (NoSuchAlgorithmException NSAE){
            NSAE.printStackTrace();
        }

        return md5Passord;
    }


    public String getEtternavn() {
        return etternavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getBrukernavn(){
        return brukernavn;
    }

    public String getEpost() {
        return epost;
    }

    public int getAlder() {
        return alder;
    }

    public String getPassord(){
        return passord;
    }

    public long getTelefonnummer() {
        return telefonnummer;
    }


    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public void setBrukernavn(String brukernavn){
        this.brukernavn = brukernavn;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public void setTelefonnummer(long telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public void setPassord(String passord){

        this.passord = MD5Hashing(passord);
    }

    public ArrayList<Arrangement> getArrangementerBrukerSkalPaa() {
        return arrangementerBrukerSkalPaa;
    }

    public void setArrangementerBrukerSkalPaa(ArrayList<Arrangement> arrangementerBrukerSkalPaa) {
        this.arrangementerBrukerSkalPaa = arrangementerBrukerSkalPaa;
    }

}

