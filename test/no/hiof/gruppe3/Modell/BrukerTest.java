package no.hiof.gruppe3.Modell;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrukerTest {

    Bruker bruker = new Bruker();

    @Test
    void passord_skal_gis_en_spesifik_hash_test(){
        assertEquals("112fab0fb33df288fa7961d4479c03d9", bruker.MD5Hashing("drossap"));
    }

    @Test
    void ny_bruker_blir_laget_riktig_test(){

        //assertEquals(("123", "abc", "def", "123@ert.no","112fab0fb33df288fa7961d4479c03d9", 25), bruker.lagNyBruker("123", "abc", "def", "123@ert.no","123@ert.no", "drossap", "drossap", 27));

    }

}