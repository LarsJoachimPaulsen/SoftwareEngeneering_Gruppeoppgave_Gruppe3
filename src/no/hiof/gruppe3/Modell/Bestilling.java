package no.hiof.gruppe3.Modell;

// bytte ut SkrivTilFIl med Arrangement når pris fjernes fra egen fil
public abstract class Bestilling extends Arrangement {

    private long kortnr;
    private short cvc;
    private int antallBilletter = 100, pris;


    /* her bør vi senere også sende med noe som bruker? sende dette videre til en ekstern betalingsside, som returnerer
    en boolean (True for godkjent, False for ikke godkjent), bruker returverdien her til å sende billetter på mail/sms.
    At kort blir avvist vil vises hos tredjepart.
     */
    public String bestillBillet(int velgAntallBilleter) {

        Bruker testBruker = new Bruker("abc", "def","acc" ,"123@gmail.com", "drossap", 27);

        if(antallBilletter > 0){

            if(velgAntallBilleter > antallBilletter){
                return "Det finnes desverre ikke nok billetter";

            }
            else{
                antallBilletter -= velgAntallBilleter;

               //int pris = kalkulerPris(velgAntallBilleter);

                // !!!!! kan flyttes til kalkulerPris? !!!!!!!!!!!!!!!!!!!!!!!!!!!
                boolean godkjentBetaling = sendTilBankAccept(testBruker, pris);
                // sende til betalingsside, returnerer godkjent ikke godkjent
                if (godkjentBetaling){

                    // new Bruker er placeholder.
                    sendBekreftelse(testBruker);

                    // Send bekreftelse(bruker) <-- sender mail med billett/ evt sms.

                    return "Bestilling vellykket";
                }

                else {
                    // legger billettene tilbake for salg, om bestillingen ikke ble godkjent.
                    antallBilletter+= antallBilletter;
                    return "Noe gikk galt";

                }
                //  !!!!! kan flyttes til kalkulerPris? !!!!!!!!!!!!!!!!!!!!!!!!!!!
            }
        }
        else{
            return "Det er desverre tomt for billetter";
        }


    }

    /*public int kalkulerPris(int antallBilleter) {

        int prisPerBillet = Integer.parseInt(lesFraServer("CVC/billettinformasjon.cvc"));

        int totalPris = prisPerBillet * antallBilleter;

        return totalPris;


    }*/

    private void sendBekreftelse(Bruker bruker) {

        String epost = bruker.getEpost();

        // sender bekreftelse på mail
        // finne en gratis host vi kan bruke til å sende ut mailer?
    }

    private Boolean sendTilBankAccept(Bruker bruker, int pris){

        // sender brukeren videre til en sikker bankside. Denne vil returnere true dersom betalingen blir vellykket.

        return true;

    }

    public void setAntallBilletter(int antallBilletter){
        this.antallBilletter = antallBilletter;
    }
}
