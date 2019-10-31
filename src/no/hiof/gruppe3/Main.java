package no.hiof.gruppe3;

import no.hiof.gruppe3.Modell.Arrangement;
import no.hiof.gruppe3.Modell.Bruker;
import no.hiof.gruppe3.Modell.Innstillinger;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args){


        System.out.println("Funker");

        Bruker nyBruker = new Bruker();

        nyBruker.setPassord("abcd123");

        System.out.println(nyBruker.getPassord());

        Bruker nyBruker2 = new Bruker();

        nyBruker2.setPassord("abcd123");

        System.out.println(nyBruker2.getPassord());

        Innstillinger innstillingerForBruker = new Innstillinger();

        innstillingerForBruker.endrePassord(nyBruker, "abcd123", "drossap", "drossap");

        System.out.println(nyBruker.getPassord());


        //*************demo************//

        Arrangement arr = new Arrangement("Løping","Fredrikstad", LocalDate.of(2019,11,10),150,200);

        //Arrangement arr1 = new Arrangement("Ski","Fredrikstad", LocalDate.of(2019,10,10),150,200);

        System.out.println(arr);
        //System.out.println(arr1);


    }
}
