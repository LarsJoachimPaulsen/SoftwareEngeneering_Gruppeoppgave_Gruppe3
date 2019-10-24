package no.hiof.gruppe3.Modell;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BestillingTest {

    Bestilling bestilling = new Bestilling();

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 9 })
    void en_bestilling_skal_gi_tilbakemelding_om_at_den_er_vellykket_test(int antallBilletter){
        assertEquals("Bestilling vellykket", bestilling.bestillBillet(antallBilletter));

    }

    @ParameterizedTest
    @ValueSource(ints = {101, 103, 109, 134})
    void en_bestilling_skal_si_ifra_om_det_ikke_er_nok_billetter_test(int antallBilleter){
        assertEquals("Det finnes desverre ikke nok billetter", bestilling.bestillBillet(antallBilleter));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 6, 99})
    void en_bestilling_skal_si_ifra_om_det_er_tomt_for_billetter_test(int antallBilleter){
        bestilling.setAntallBilletter(0);
        assertEquals("Det er desverre tomt for billetter", bestilling.bestillBillet(antallBilleter));

    }

    @Test
    void bestillinger_av_et_antall_billetter_gir_riktig_pris_test(){
        assertEquals(200, bestilling.kalkulerPris(1));
        assertEquals(400, bestilling.kalkulerPris(2));
        assertEquals(1000, bestilling.kalkulerPris(5));
    }


}