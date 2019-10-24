package no.hiof.gruppe3.Modell;


// merge bruker og LagNyBruker, heller lage nyBruker som en metode.

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// passord må hashes! MD5?
public class Bruker  {

    private String etternavn, fornavn, epost, passord;
    private int alder;

    public Bruker(String etternavn, String fornavn, String epost, int alder){
        this.etternavn = etternavn;
        this.fornavn = fornavn;
        this.epost = epost;
        this.alder = alder;

    }

    public Bruker(){

    }

    // produserer en MD5Has av passordet.
    public String MD5Hashing (String passord){

        String passordMedSalt = passord + "t0¤+214";
        String md5Passord = null;
        try{

            MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(passordMedSalt.getBytes());

            byte[] bytes = md.digest();

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

    public String getEpost() {
        return epost;
    }

    public int getAlder() {
        return alder;
    }

    public String getPassord(){
        return passord;
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

    public void setPassord(String passord){

        this.passord = MD5Hashing(passord);
    }


}

