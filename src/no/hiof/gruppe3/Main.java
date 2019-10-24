package no.hiof.gruppe3;

import no.hiof.gruppe3.Modell.Bruker;

public class Main {

    public static void main(String[] args){


        System.out.println("Funker");

        Bruker nyBruker = new Bruker();

        nyBruker.setPassord("abcd123");

        System.out.println(nyBruker.getPassord());

        Bruker nyBruker2 = new Bruker();

        nyBruker2.setPassord("abcd123");

        System.out.println(nyBruker2.getPassord());
    }
}
