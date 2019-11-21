package no.hiof.gruppe3.Modell;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.util.Properties;

// bytte ut SkrivTilFIl med Arrangement når pris fjernes fra egen fil
public class Bestilling extends Arrangement {



    int antallBilletter = 250;

    //for å sende en epost.
    private Properties mailServerProperties;
    private Session getMailSession;
    private MimeMessage generateMailMessage;

    Klubb fredrikstadKlubb = new Klubb("Fredrikstad Klubb","Fredrikstad sentrum",16000);

    Arrangement arr = new Arrangement("Ski",fredrikstadKlubb,"Fredrikstad", LocalDate.of(2020,11,5),250,200, 100);

    Bruker bruker = new Bruker("abc", "def","acc" ,"setProjectOppgave@gmail.com", "drossap", 27);


    public String bestillBillet(int velgAntallBilleter) {


        if(antallBilletter > 0){

            if(velgAntallBilleter > antallBilletter){
                return "Det finnes desverre ikke nok billetter";

            }
            else{
                antallBilletter -= velgAntallBilleter;


                int pris = kalkulerPris(velgAntallBilleter);

                boolean godkjentBetaling = sendTilBankAccept(bruker, pris);
                if (godkjentBetaling){


                    //senere vil vi bytte setProjectOppgave@gmail.com ut med brukeren sin epost bruker.getEpost()
                    sendBekreftelse("setProjectOppgave@gmail.com");

                    return "Bestilling vellykket";
                }

                else {
                    antallBilletter+= antallBilletter;
                    return "Noe gikk galt";
                }
            }
        }
        else{
            return "Det er desverre tomt for billetter";
        }
    }

    public int kalkulerPris(int antallBilletter){
        int prisPerBillet = arr.getPrisPaaBilletter();
        int totalPris = antallBilletter * prisPerBillet;
        return totalPris;

    }

    public void sendBekreftelse(String brukerEpost){

        try {

            //setup Mail Server Properties
            mailServerProperties = System.getProperties();
            mailServerProperties.put("mail.smtp.port", "587");
            mailServerProperties.put("mail.smtp.auth", "true");
            mailServerProperties.put("mail.smtp.starttls.enable", "true");
            System.out.println("Mail Server Properties have been setup successfully..");

            //lager en mail Session
            getMailSession = Session.getDefaultInstance(mailServerProperties, null);
            generateMailMessage = new MimeMessage(getMailSession);
            //her må vi bruke brukerensepost isteden for vår epost, brukt setProjectOppgave@gmail.com bare for å teste. Dere kan teste med en annen epost om dere vil.
            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("setProjectOppgave@gmail.com"));
            generateMailMessage.setSubject("Orderebekreftelse");
            String emailBody = "Her er Billettene. " + "<br><br> Mvh, <br> Gruppe 3";
            generateMailMessage.setContent(emailBody, "text/html");
            System.out.println("Mail Session has been created successfully..");

            //Get Session and Send mail
            Transport transport = getMailSession.getTransport("smtp");
            // e-postadresse og passord for vår sportsside brukes til å sende bekreftelse til brukeren.
            transport.connect("smtp.gmail.com", "setProjectOppgave@gmail.com", "software2019");
            transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
            transport.close();
        }
        catch(MessagingException ME){
            ME.printStackTrace();
        }

    }



    private Boolean sendTilBankAccept(Bruker bruker, int pris){

        // sender brukeren videre til en sikker bankside. Denne vil returnere true dersom betalingen blir vellykket.

        return true;

    }

    public void setAntallBilletter(int antallBilletter){
        this.antallBilletter = antallBilletter;
    }


}
