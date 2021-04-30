package theFightClub_Cod_Fiscali.unibs.it;

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

    File xmlFile; //INCLUDO IL FILE XML codiciFiscali.xml
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
    } catch(SAXException || ParserConfigurationException e1);

    {
        e1.printStackTrace();
    }

    static NodeList  listaCodice = doc.getElementsByTagName("Codice");
    static int  quantiCodici = listaCodice.getLength();
    static String codice ;
    public static void controlloCodici(){
            for (int z = 0; z < quantiCodici; z++) {
                codice = listaCodice.item(z);
                if( controlloLunghezza(codice) ) //visualizziamo se il codice è
                       System.out.println(codice + " è corretto");
                else
                       System.out.println(codice + "non è corretto");
            }
    }


    private static boolean controlloLunghezza(String codice) { //CONTROLLO CHE LA LUNGHEZZA DEL CODICE SIA UGUALE A 16 E SE NON LO è ESCE DAL CICLO
           boolean corretto = false;
               //estraggo codice e ne verifico l'effettiva lunghezza
               if (codice.length() == 16)
                   corretto = true;
               else
                   return false;

               for (int i = 0; i < 6; i++) {
                   if (Character.isLetter(codice.charAt(i)))
                       corretto = true;   //CONTROLLO CHE I PRIMI SEI CARATTERI SIANO LETTERE
                   else
                       return false;
               }
               for (int i = 6; i < 8; i++) {
                   if (Character.isDigit(codice.charAt(i))) //CONTROLLO CHE L'ANNO SIA SCRITTO IN CIFRE
                       corretto = true;
                   else
                       return false;
               }




               if (Character.isDigit(codice.charAt(9)) && Character.isDigit(codice.charAt(10))) {
                   String EstraiMeseGiorno = String.valueOf(codice).substring(8,11);    //estraggo mese e giorno del codice fiscale
                   if(controlloMeseGiorno(EstraiMeseGiorno))
                       corretto=true;
                   else
                       return false; //CONTROLLO CHE L'ANNO SIA COSTITUITO DA CIFRE
               } else
                   return false;


               //oltre a controllare che nella posizione 9 e 10 ci sia effettivamente una cifra è necessario controllare
               //che la cifra appartenga ad un certo intervallo prestabilito dall'algoritmo del calcolo
               //del codice fiscale







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

               //CONTROLLO CHE IL CODICE A TRE CIFRE DEL LUOGO O COMUNE DI NASCITA SIA EFFETTIVAMENTE COSTITUITO DA CIFRE E NON
               // DA LETTERE

               for (int i = 12; i < 15; i++) {
                   if (Character.isDigit(codice.charAt(i)))
                       corretto = true;
                   else
                       return false;
               }
        //corretta del codice di controllo
        char ultimoCarattere = codice.charAt(15);
        char carattereSpeciale = CodiceFiscale.generaCarSpeciale(codice.substring(0,15)).charAt(0);
        if (ultimoCarattere == carattereSpeciale)
            corretto = true;
        else
            return false;

        return corretto;


    }

    //METODO PER CONTROLLARE LA CORRETTEZZA DEL MESE E DEL Giorno
    private static boolean controlloMeseGiorno(String carattere) {
        char primoEl = carattere.charAt(0);
        int numeroMese = Integer.getInteger(carattere.substring(1,3));

        if(     primoEl == 'A'|| primoEl == 'C' || primoEl== 'E' || primoEl== 'L' ||
                primoEl== 'M' || primoEl=='R' || primoEl== 'T' )
            return (numeroMese >=1 && numeroMese <=31) || (numeroMese >=41 && numeroMese <=71);
        if(primoEl == 'D'|| primoEl == 'H' || primoEl== 'P' || primoEl== 'S' )
            return (numeroMese >=1 && numeroMese <=30) || (numeroMese >=41 && numeroMese <=70);
        if (primoEl == 'B')
            return (numeroMese >=1 && numeroMese <= 28) || (numeroMese >=41 && numeroMese <=68);

        return false; //mi ritorna false se la lettere che corrisponde al mese è errata

    }

}
