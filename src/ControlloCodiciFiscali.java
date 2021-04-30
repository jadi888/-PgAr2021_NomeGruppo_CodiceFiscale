import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.*;
import java.io.File;
import java.io.IOException;

public class ControlloCodiciFiscali {

    File xmlFile;
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder;
        try {
        xmlFile = new File("codiciFiscali.xml");
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = dBuilder.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();
        printElement(doc);
        System.out.println("XML file updated successfully");
    } catch(SAXException || ParserConfigurationException e1)

    {
        e1.printStackTrace();
    }

    NodeList listaCodice = doc.getElementsByTagName("Codice");
    int quantiCodici = listaCodice.getLength();
    String codice ;
    public static void controlloCodici(){
            for (int z = 0; z < quantiCodici; z++) {
                codice = listaCodice.item(z);
                if( controlloLunghezza(codice) ) //visualizziamo se il codice è corretto
                       System.out.println(codice + " è corretto");
                else
                       System.out.println(codice + "non è corretto");
            }
    }


    private static boolean controlloLunghezza(String codice) {
           boolean corretto = false;
               //estraggo codice e ne verifico l'effettiva lunghezza
               if (codice.length == 16)
                   corretto = true;
               else
                   return false;

               for (int i = 0; i < 6; i++) {
                   if (Character.isLetter(codice.charArt(i)))
                       corretto = true;   //Controllo che le prime 6 posizioni siano occupate da lettere
                   else
                       return false;
               }
               for (int i = 6; i < 8; i++) {
                   if (Character.isDigit(codice.charAt(i)))//controllo che l'anno sia formato da cifre
                       corretto = true;
                       //devo aggiugere la condizione che verifica se le due cifre sono naturali e comprese tra l'anno 0000 e il 2021
                   else
                       return false;
               }



               int giorno;
               if (Character.isDigit(codice.charAt(9)) && Character.isDigit(codice.charAt(10))) {
                   String EstraiMeseGiorno = String.valueOf(codice).substring(8,11);
                   if(controlloMeseGiorno(EstraiMeseGiorno))
                       corretto=true;
                   else
                       return false; //controllo che il giorno di nascita sia costituito da cifre
               } else
                   return false;


               //oltre a controllare che nella posizione 9 e 10 ci sia effettivamente una cifra è necessario controllare che la cifra appartenga ad un certo intervallo prestabilito dall'algoritmo del calcolo del codice fiscal


               //controllo il Codice del luogo di nascita che deve avere una lettera all'11 posizione e 3 cifre consecutive

               if ((codice.charAt(11) == 'A') || (codice.charAt(11) == 'B') ||
                       (codice.charAt(11) == 'C') || (codice.charAt(11) == 'D') ||
                       (codice.charAt(11) == 'E') || (codice.charAt(11) == 'F') ||
                       (codice.charAt(11) == 'G') || (codice.charAt(11) == 'H') ||
                       (codice.charAt(11) == 'I') || (codice.charAt(11) == 'L') ||
                       (codice.charAt(11) == 'M') || (codice.charAt(11) == 'Z'))
                   corretto = true;
               else
                   return false;

               for (int i = 12; i < 15; i++) {
                   if (Character.isDigit(codice.charAt(i)))
                       corretto = true;
                   else
                       return false;
               }



        return corretto;



    }

    private static boolean controlloMeseGiorno(String carattere) {
        char primoEl = carattere.charAt(0);
        int numeroMese = Integer.getInteger(String.valueOf(carattere).substring(1,3);

        if(     primoEl == 'A'|| primoEl == 'C' || primoEl== 'E' || primoEl== 'L' ||
                primoEl== 'M' || primoEl=='R' || primoEl== 'T' )
            return (numeroMese >=1 && numeroMese <=31) || (numeroMese >=41 && numeroMese <=71);
        if(primoEl == 'D'|| primoEl == 'H' || primoEl== 'P' || primoEl== 'S' )
            return (numeroMese >=1 && numeroMese <=30) || (numeroMese >=41 && numeroMese <=7O);
        if (primoEl == 'B')
            return (numeroMese >=1 && numeroMese <= 28) || (numeroMese >=41 && numeroMese <=68);

        return false; //mi ritorna false se la lettere che corrisponde al mese è errata

    }

}
