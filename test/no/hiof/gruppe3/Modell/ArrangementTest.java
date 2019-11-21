package no.hiof.gruppe3.Modell;

import no.hiof.gruppe3.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArrangementTest {

    Arrangement arr;

    @BeforeEach
    void init(){
        arr = new Arrangement();
    }


    @DisplayName("sjekker om arrangementsdato er like datoen for i dag.")
    @Test
    void testOmArrangemetsdatoErLikDatoForIdag(){
        arr.setTidspunktForArrangement(LocalDate.now());

        assertEquals(LocalDate.now(), arr.getTidspunktForArrangement() );
    }

    @DisplayName("sjekker om arrangementsdato settes til null om arrangementsdato settes til å være en dato som er tildigere enn dagensdato.")
    @Test
    void testArrangemetsdatoMedEnDatoSomErTildigereEnnDagensdato(){
        arr.setTidspunktForArrangement(LocalDate.of(2018,10,4));

        assertEquals(null, arr.getTidspunktForArrangement() );
    }

    @DisplayName("sjekker om arrangementsdato settes til den datoen vi velger om den er nyere en dagensdato .")
    @Test
    void testArrangemetsdatoMedEnDatoSomErNyereEnnDagensdato(){
        arr.setTidspunktForArrangement(LocalDate.of(2020,11,5));

        assertEquals(LocalDate.of(2020,11,5), arr.getTidspunktForArrangement() );
    }

    @DisplayName("sjekker om at arrangementsdato ikke settes til å være lik null om den er nyere dato enn dagensdato.")
    @Test
    void testNotEquals(){
        arr.setTidspunktForArrangement(LocalDate.of(2020,11,5));
        assertNotEquals(null,arr.getTidspunktForArrangement());
    }








}