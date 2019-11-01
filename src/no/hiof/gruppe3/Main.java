package no.hiof.gruppe3;

import no.hiof.gruppe3.Modell.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Bruker> brukerListe = new ArrayList<Bruker>();
    private static ArrayList<Arrangement> arrangementListe = new ArrayList<Arrangement>();
    private static ArrayList<Klubb> klubbListe = new ArrayList<Klubb>();

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

        Arrangement r = new Arrangement("Løping","Fredrikstad", LocalDate.of(2019,11,10),150,200);

        //Arrangement r1 = new Arrangement("Ski","Fredrikstad", LocalDate.of(2019,10,10),150,200);

        System.out.println(r);
        //System.out.println(arr1);

        //***************** noen arrangementer og brukere for å teste skriving til filen. ***********//

        //legger til noen arrangementer til arrangementListe som ligger helt øverst i Main klasse.
        arrangementListe.add(new Arrangement("Playing","Halden",LocalDate.of(2019,11,27),200,170));
        arrangementListe.add(new Arrangement("ski","Mysen",LocalDate.of(2020,11,10),150,100));

        //lager noen bruker på den måten istenden for brukerListe.add(new Bruker) for å kunne bruke bruker navn til å legge til arrangementer.
        Bruker jon = new Bruker("AAA","Jon","Antonsen","az@gmail.com","12345",28);
        Bruker kent = new Bruker("MMM","Kent","Østby","ty@hotmail.com","9870",32);


        //**                            @@ LES MEG @@

        // jeg får null pointer exception når jeg ligger arrangement/er til bruker på denne måten(se nede)
        // når jeg kjører    System.out.println(arrangementListe.get(0)); så får jeg riktig/forventet svar
        //fint om noen kan komme på noe forslag.
        //
        //**


        //bruker jon skal ha 2 arrangementer som han skal på.

        //jon.getArrangementerBrukerSkalPaa().add(arrangementListe.get(0));
        //jon.getArrangementerBrukerSkalPaa().add(arrangementListe.get(1));


        //bruker kent skl ha 1 arrangement som ha skal på.

        //kent.getArrangementerBrukerSkalPaa().add(arrangementListe.get(1));

        //legger til noen bruker til brukerListe som ligger helt øverst i Main klasse.
        brukerListe.add(jon);
        brukerListe.add(kent);

        //lager en tøm arrayListe av Objekter som blir fylt med objekter fra arrangementListe.
        //viktig å merke at listene inneholder objekter og ikke arrangementer.
        ArrayList<Object> arrangementObjListe = new ArrayList<Object>();
        for(Arrangement arr: arrangementListe){
            arrangementObjListe.add(arr);
        }

        //lager en tøm arrayListe av Objekter som blir fylt med objekter fra brukerListe.
        //viktig å merke at listene inneholder objekter og ikke brukere.
        ArrayList<Object> brukerObjListe = new ArrayList<>();
        for(Bruker b: brukerListe){
            brukerObjListe.add(b);
        }


        new SkrivTilFil("arrangement.ser",arrangementObjListe);
        new SkrivTilFil("bruker.ser",brukerObjListe);


        //*** For å få testet om LesFraFil funker eller ikke kommenter/slett alle arrangementListe.add() og brukeListe.add() oppe.


        new LesFraFil("arrangement.ser"); //leser objekter fra arrangement.ser og legger dem i arrangementListe
        new LesFraFil("bruker.ser"); //leser objekter fra bruker.ser og legger dem i brukerListe.

        // etter at objektene ble lagt til i arrangementListe og brukerListe,
        // går vi gjennom for å skrive navn på arrangement.
        for(Arrangement a: arrangementListe){
            System.out.println(a.getNavnPaaArrangement());
        }
        for(Bruker b: brukerListe){
            System.out.println(b.getFornavn());
        }



    }

    public static ArrayList<Bruker> getBrukerListe() { return brukerListe; }

    public static ArrayList<Arrangement> getArrangementListe() {return arrangementListe;}

    public static ArrayList<Klubb> getKlubbListe() { return klubbListe; }

}
