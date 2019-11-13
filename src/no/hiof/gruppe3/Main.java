package no.hiof.gruppe3;

import no.hiof.gruppe3.Modell.*;
import javax.mail.MessagingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.mail.internet.*;

public class Main {

    private static ArrayList<Bruker> brukerListe = new ArrayList<Bruker>();
    private static ArrayList<Arrangement> arrangementListe = new ArrayList<Arrangement>();
    private static ArrayList<Klubb> klubbListe = new ArrayList<Klubb>();

    public static void main(String[] args) throws AddressException, MessagingException{

        //kaller på sendBekreftelse i main. Det tar litt tid når den kjøres
        Bestilling bekreftelse = new Bestilling();
        bekreftelse.sendBekreftelse("setProjectOppgave@gmail.com");
        System.out.println(" ===> Orderebekreftelsen har blitt sendt til eposten du valgt..");


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



        //***************** noen arrangementer og brukere for å teste skriving til filen. ***********//

        Klubb fredrikstadKlubb = new Klubb("Fredrikstad Klubb","Fredrikstad sentrum",16000);
        Klubb haldenKlubb = new Klubb("Halden Klubb","Halden sentrum",17000);
        Klubb mossKlubb = new Klubb("Moss Klubb","Moss sentrum",18000);

        klubbListe.add(fredrikstadKlubb);
        klubbListe.add(haldenKlubb);
        klubbListe.add(mossKlubb);

        //legger til noen arrangementer til arrangementListe som ligger helt øverst i Main klasse.
        Arrangement sykkelritt = new Arrangement("sykkelritt",haldenKlubb,"Halden",LocalDate.of(2019,12,27),200,170);
        Arrangement skirenn = new Arrangement("skirenn",fredrikstadKlubb,"Fredrikstad",LocalDate.of(2020,11,10),150,100);
        Arrangement løp = new Arrangement("løp",fredrikstadKlubb,"Fredrikstad",LocalDate.of(2020,12,9),370,100);
        Arrangement riding = new Arrangement("riding",fredrikstadKlubb,"Moss",LocalDate.of(2020,10,04),370,100);
        Arrangement roing = new Arrangement("roing",fredrikstadKlubb,"Fredrikstad",LocalDate.of(2020,10,11),370,100);
        Arrangement adventureRacing = new Arrangement("Adventure Racing",mossKlubb,"Moss",LocalDate.of(2020,9,5),275,200);

        //lager noen bruker på den måten istenden for brukerListe.add(new Bruker) for å kunne bruke bruker navn til å legge til arrangementer.
        Bruker jon = new Bruker("AAA","Jon","Antonsen","setProjectOppgave@gmail.com","12345",28);
        Bruker kent = new Bruker("MMM","Kent","Østby","setProjectOppgave@gmail.com","9870",32);
        Bruker liza = new Bruker("LLL","Liza","Henning","setProjectOppgave@gmail.com","9870",32);


        arrangementListe.add(sykkelritt);
        arrangementListe.add(skirenn);
        arrangementListe.add(løp);
        arrangementListe.add(riding);
        arrangementListe.add(roing);
        arrangementListe.add(adventureRacing);


        //bruker jon skal ha 2 arrangementer som han skal på.

        jon.getArrangementerBrukerSkalPaa().add(arrangementListe.get(0));
        jon.getArrangementerBrukerSkalPaa().add(arrangementListe.get(1));


        //bruker kent skal ha 2 arrangement som han skal på.

        kent.getArrangementerBrukerSkalPaa().add(arrangementListe.get(1));
        kent.getArrangementerBrukerSkalPaa().add(arrangementListe.get(4));

        //bruker liza skal ha 3 arrangement som hun skal på.
        liza.getArrangementerBrukerSkalPaa().add(arrangementListe.get(2));
        liza.getArrangementerBrukerSkalPaa().add(arrangementListe.get(3));
        liza.getArrangementerBrukerSkalPaa().add(arrangementListe.get(1));


        //legger til noen bruker til brukerListe som ligger helt øverst i Main klasse.

        brukerListe.add(jon);
        brukerListe.add(kent);
        brukerListe.add(liza);

        System.out.println("***** Klubber som registrert seg i systemet *****");
        System.out.println("");
        //lager en tøm arrayListe av Objekter som blir fylt med objekter fra klubbListe.
        //viktig å merke at listene inneholder objekter og ikke brukere.
        ArrayList<Object> klubbObjListe = new ArrayList<>();
        for(Klubb k: klubbListe){
            klubbObjListe.add(k);
            System.out.println(k.getNavn()+"\n");
        }

        System.out.println("**********************************");

        System.out.println("***** Arrangementer klubbene skal arrangere *****");
        System.out.println("");
        //lager en tøm arrayListe av Objekter som blir fylt med objekter fra arrangementListe.
        //viktig å merke at listene inneholder objekter og ikke arrangementer.
        ArrayList<Object> arrangementObjListe = new ArrayList<Object>();
        for(Arrangement arr: arrangementListe){
            arrangementObjListe.add(arr);
            System.out.println(arr.getNavnPaaArrangement() + " skal bli arrangert av " + arr.getArrangerendeKlubb() +"\n");
        }

        System.out.println("**********************************");

        System.out.println("***** Brukere som registrert seg i systemet *****");
        System.out.println("");
        //lager en tøm arrayListe av Objekter som blir fylt med objekter fra brukerListe.
        //viktig å merke at listene inneholder objekter og ikke brukere.
        ArrayList<Object> brukerObjListe = new ArrayList<>();
        for(Bruker b: brukerListe){
            brukerObjListe.add(b);
            System.out.println(b.getFornavn() +" "+ b.getEtternavn() + "\n");
        }

       System.out.println("**********************************");


        System.out.println("***** Data(Klubb/Arrangement/Bruker) ble lagret i database(fil) *****");
        System.out.println("");
        new SkrivTilFil("klubb.ser",klubbObjListe);
        new SkrivTilFil("arrangement.ser",arrangementObjListe);
        new SkrivTilFil("bruker.ser",brukerObjListe);

        System.out.println("**********************************");


        //*** For å få testet om LesFraFil funker eller ikke kommenter/slett alle arrangementListe.add() og brukeListe.add() oppe.

        new LesFraFil("arrangement.ser"); //leser objekter fra arrangement.ser og legger dem i arrangementListe
        new LesFraFil("bruker.ser"); //leser objekter fra bruker.ser og legger dem i brukerListe.

        // etter at objektene ble lagt til i arrangementListe og brukerListe,
        // går vi gjennom for å skrive navn på arrangement.

        System.out.println("@***** Brukeren kan sortere arrangementene slik *****@");
        System.out.println("***** ArrangementListe sortert med dato stigende *****");
        System.out.println("");
        Collections.sort(arrangementListe);
        for(Arrangement a: arrangementListe){
           System.out.println(a.getNavnPaaArrangement() + a.getTidspunktForArrangement() );
        }

        System.out.println("**********************************");

        System.out.println("***** ArrangementListe sortert Alfabetisk *****");

      arrangementListe.sort(new Comparator<Arrangement>() {
            @Override
            public int compare(Arrangement r1, Arrangement r2) {

                String arrangementNavn1 = r1.getNavnPaaArrangement();
                String arrangementNavn2 = r2.getNavnPaaArrangement();
                return arrangementNavn1.compareTo(arrangementNavn2);
            }});

        for(Arrangement a: arrangementListe){
            System.out.println(a.getNavnPaaArrangement() + a.getTidspunktForArrangement() );
        }

        System.out.println("**********************************");

        for(Bruker b: brukerListe){
            System.out.println(b.getFornavn()+ " skal på"+b.getArrangementNavnPaaArrangementerBrukerSkalPaa(b.getArrangementerBrukerSkalPaa()));
        }
    }

    public static ArrayList<Bruker> getBrukerListe() { return brukerListe; }

    public static ArrayList<Arrangement> getArrangementListe() {return arrangementListe;}

    public static ArrayList<Klubb> getKlubbListe() { return klubbListe; }

}
