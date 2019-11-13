package no.hiof.gruppe3.Modell;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InnstillingerTest {

    Innstillinger innstillinger = new Innstillinger();

    @Test
    void passord_sjekk_test(){
        assertFalse(innstillinger.passordSjekk("Drossap", "Drossap"));
        assertTrue(innstillinger.passordSjekk("112fab0fb33df288fa7961d4479c03d9", "drossap"));
    }

}