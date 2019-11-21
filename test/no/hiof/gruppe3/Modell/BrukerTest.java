package no.hiof.gruppe3.Modell;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrukerTest {

    Bruker bruker = new Bruker();

    @Test
    void passord_skal_gis_en_spesifik_hash_test(){
        assertEquals("112fab0fb33df288fa7961d4479c03d9", bruker.MD5Hashing("drossap"));
    }



}