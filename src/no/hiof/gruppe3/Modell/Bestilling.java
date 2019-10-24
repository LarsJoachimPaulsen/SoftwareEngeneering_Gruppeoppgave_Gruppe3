package no.hiof.gruppe3.Modell;

public class Bestilling extends SkrivTilServer {

    private long kortnr;
    private short cvc;
    private int antallBilletter = 100, pris;


    /* her bør vi senere også sende med noe som bruker? sende dette videre til en ekstern betalingsside, som returnerer
    en boolean (True for godkjent, False for ikke godkjent), bruker returverdien her til å sende billetter på mail/sms.
    At kort blir avvist vil vises hos tredjepart.
     */
    public String bestillBillet(int velgAntallBilleter) {

        if(antallBilletter > 0){

            if(velgAntallBilleter > antallBilletter){
                return "Det finnes desverre ikke nok billetter";

            }
            else{
                antallBilletter -= velgAntallBilleter;

                kalkulerPris(velgAntallBilleter);

                // kan flyttes til kalkulerPris?
                boolean godkjentBetaling = sendTilBankAccept(new Bruker("abs", "def", "123@gmail.com" ,27));
                // sende til betalingsside, returnerer godkjent ikke godkjent
                if (godkjentBetaling){

                    // new Bruker er placeholder.
                    sendBekreftelse(new Bruker("abs", "def", "123@gmail.com", 27));

                    // Send bekreftelse(bruker) <-- sender mail med billett/ evt sms.

                    return "Bestilling vellykket";
                }

                else {
                    return "Noe gikk galt";

                }

            }
        }
        else{
            return "Det er desverre tomt for billetter";
        }


    }

    public int kalkulerPris(int antallBilleter) {

        int prisPerBillet = lesFraServer("CVC/billettinformasjon.cvc");

        int totalPris = prisPerBillet * antallBilleter;

        return totalPris;


    }

    private void sendBekreftelse(Bruker bruker) {

        String epost = bruker.getEpost();

        // sender bekreftelse på mail
        // finne en gratis host vi kan bruke til å sende ut mailer?
    }

    private Boolean sendTilBankAccept(Bruker bruker){

        // sender brukeren videre til en sikker bankside. Denne vil returnere true dersom betalingen blir vellykket.

        return true;

    }

    public void setAntallBilletter(int antallBilletter){
        this.antallBilletter = antallBilletter;
    }
}
