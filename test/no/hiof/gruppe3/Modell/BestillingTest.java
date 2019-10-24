package no.hiof.gruppe3.Modell;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestillingTest {

    Bestilling bestilling = new Bestilling();

    @Test
    void en_bestilling_skal_redusere_antall_billetter_tiljengelig_test(){

        assertEquals("Det finnes desverre ikke nok billetter", bestilling.bestillBillet(103));
        assertEquals("Bestilling vellykket", bestilling.bestillBillet(100));
        assertEquals("Det er desverre tomt for billetter", bestilling.bestillBillet(2));

    }

    @Test
    void pris_for_alle_billetter_valgt_er_korrekt_test(){

        assertEquals(400, bestilling.kalkulerPris(2));
        assertEquals(600, bestilling.kalkulerPris(3));
        assertEquals(1000, bestilling.kalkulerPris(5));

    }

}