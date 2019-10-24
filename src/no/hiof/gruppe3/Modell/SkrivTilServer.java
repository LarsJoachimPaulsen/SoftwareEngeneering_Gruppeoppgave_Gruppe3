package no.hiof.gruppe3.Modell;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class SkrivTilServer {

    public int lesFraServer(String filsti){
        String linje = " ";
        String cvsSplittVed = ";";

        try{
            BufferedReader lesFraFil = new BufferedReader(new FileReader(filsti));

            while (( linje = lesFraFil.readLine()) != null){

                String[] output = linje.split(cvsSplittVed);

                return Integer.parseInt(output[0]);
            }

        }
        catch(FileNotFoundException FNFE){
            FNFE.printStackTrace();

            return 0;
        }
        catch (IOException IOE){
            IOE.printStackTrace();

            return 0;
        }
        return 0;
    }

    /*
    public void skrivTilServer(String filsti){

        try{
            BufferedWriter skrivTilServer = new BufferedWriter(new FileWriter());

            skrivTilServer.write();

        }
        catch(FileNotFoundException FNFE){
            FNFE.printStackTrace();
        }

    } */

}
