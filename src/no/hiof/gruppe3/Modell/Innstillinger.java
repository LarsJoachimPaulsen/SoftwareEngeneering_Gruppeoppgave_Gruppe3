package no.hiof.gruppe3.Modell;

public class Innstillinger extends Bruker {

    public void endrePassord(Bruker bruker, String passord, String nyttPassord, String bekreftNyttPassord){

        if(passordSjekk(bruker.getPassord(), bruker.MD5Hashing(passord))){

            if (nyttPassord.equals(bekreftNyttPassord)){

                bruker.setPassord(nyttPassord);
            }
            else{
                System.out.println("passordene er ikke like");
            }

        }
        else{
            System.out.println("Passordet er feil");
        }

    }

    public void endreEpost (Bruker bruker, String passord, String nyEpost, String bekreftEpost){

        if(passordSjekk(bruker.getPassord(), passord)){

            if (nyEpost.equals(bekreftEpost)){

                bruker.setEpost(nyEpost);

            }
            else{
                System.out.println("Epostene er ikke like");
            }
        }
        else{
            System.out.println("Feil passord");
        }

    }

    public void endreBrukernavn(Bruker bruker, String passord, String nyttBrukernavn){

        if (passordSjekk(bruker.getPassord(), passord)){

                bruker.setBrukernavn(nyttBrukernavn);
        }
        else{
            System.out.println("Feil passord");
        }

    }

    private Boolean passordSjekk(String faktiskPassord, String tastetPassord){

        boolean passordLikt = false;

        if (tastetPassord.equals(faktiskPassord)){
            passordLikt = true;
        }

        return passordLikt;


    }

}
