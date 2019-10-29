package no.hiof.gruppe3.Modell;

import java.io.*;
import java.util.ArrayList;

public abstract class SkrivTilFil {


    // finne en måte å lage en generell filleser, som kan lese variernde størrelser på filer.
    public String lesFraServer(String filsti){
        String linje = " ";
        String cvsSplittVed = "¤";

        String fraFil = "";

        try{
            BufferedReader lesFraFil = new BufferedReader(new FileReader(filsti));

            while (( linje = lesFraFil.readLine()) != null){

                String[] output = linje.split(cvsSplittVed);

                fraFil += output[0];

                // en metode som går gjennom fila og teller antall cvsSplittVed, og endrer hvor mye
                // og hva som skrives, etter behov.

            }

        }
        catch(FileNotFoundException FNFE){
            FNFE.printStackTrace();


        }
        catch (IOException IOE){
            IOE.printStackTrace();


        }
        return fraFil;
    }

 /*
    public void skrivTilServer(String filsti, ArrayList<Object> liste){

        try{
            BufferedWriter skrivTilServer = new BufferedWriter(new FileWriter(filsti));

            StringBuilder byggStrenger = new StringBuilder();

            for(int i = 0; i<= liste.size(); i++){

                //Løkke som går gjennom ArrayList, og løkke som går gjennom objektet og skriver til fil.      //
                for(int j = 0; j < liste.indexOf(i).size(); j++ ) {
                    byggStrenger.append(j);
                }
                byggStrenger.append("¤");

            }


            skrivTilServer.write(byggStrenger.toString());

        }
        catch(FileNotFoundException FNFE){
            FNFE.printStackTrace();
        }
        catch (IOException IOE){
            IOE.printStackTrace();
        }

    } */

}
