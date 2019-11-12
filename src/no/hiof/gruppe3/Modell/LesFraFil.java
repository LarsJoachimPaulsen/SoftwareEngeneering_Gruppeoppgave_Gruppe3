package no.hiof.gruppe3.Modell;
import no.hiof.gruppe3.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LesFraFil {

    private String filSti;

    public LesFraFil(String filSti){
        this.filSti = filSti;
        lesFraFila();
    }

    //leser objekter fra filene. metoden sjekker om objektet er av arrangement eller bruker type
    //om det er arrangement, blir objektet lagt til arrangementList som er opprette i Main klasse
    //om det er bruker, blir objektet lagt til brukerList som er opprette i Main klasse
    //spiller ingen rolle om brukeren har 1 eller flere arrangementer. metoden skal kunne lese forskjellige lengder.

    public void lesFraFila(){

        try {
            FileInputStream lesFraFila = new FileInputStream(filSti);
            ObjectInputStream objInStream = new ObjectInputStream(lesFraFila);

            Object o = null;

            while( (o = objInStream.readObject()) != null){

                if(o instanceof Bruker)
                    Main.getBrukerListe().add( (Bruker) o);
                else if (o instanceof Arrangement)
                    Main.getArrangementListe().add( (Arrangement) o);
                else if(o instanceof Klubb)
                    Main.getKlubbListe().add( (Klubb) o);
                else
                    System.out.println("Objektet er verken Bruker, Arrangement eller Klubb");

            }

            objInStream.close();
            lesFraFila.close();

        }catch (FileNotFoundException f){
            System.out.println("Error: filen finnes ikke objektstrøm til filen");
        }catch (ClassNotFoundException e) {
            System.out.println("Ingen flere objekter å lese");
        }catch (IOException i) {
        System.out.println("Error: feil på objektstrøm ");
        }


    }



}
