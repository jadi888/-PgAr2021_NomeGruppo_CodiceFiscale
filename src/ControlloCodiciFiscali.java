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


               if ((codice.charAt(8) == 'A') || (codice.charAt(8) == 'B') ||
                       (codice.charAt(8) == 'C') || (codice.charAt(8) == 'D') ||
                       (codice.charAt(8) == 'E') || (codice.charAt(8) == 'H') ||
                       (codice.charAt(8) == 'L') || (codice.charAt(8) == 'M') ||
                       (codice.charAt(8) == 'P') || (codice.charAt(8) == 'R') ||
                       (codice.charAt(8) == 'S') || (codice.charAt(8) == 'T'))
                   corretto = true; //controllo la validità del mese
               else
                   return false;

               int giorno;
               if (Character.isDigit(codice.charAt(9)) && Character.isDigit(codice.charAt(10))) {
                   giorno = Integer.parseInt(codice.substring(9, 11));
                   if ((giorno >= 1 && giorno <= 31) || (giorno >= 41 && giorno <= 71))
                       corretto = true;
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

               return true;

               //controllo ultimo carattere

        int codice_finale;
        int totale = 0;
        int totale_pari=0;
        int totale_dispari=0;


        /* le stringhe in cui salvo rispettivamente i caratteri con indice pari o dispari*/
        String pari = "";
        String dispari = "";
        for (int j = 0; j < cod.length(); j++) {
            if (j % 2 == 0) {
                pari += cod.charAt(j);
            } else {
                dispari += cod.charAt(j);
            }
        }

        //per i caratteri con indice pari procedo nel seguente modo:
        final String alphabet = "ABCDEFGHIJKLMNOPQRST";
        for(int i = 0; i < pari.length(); i++){
            /*se il carattere è un intero lo sommo al totale dei pari*/
            if(Character.isDigit(pari.charAt(i)))
                totale_pari+=pari.indexOf(i);
                /*se il carattere è un char allora li assegno il numero in base all'ordine che occupa nell'alfabeto*/
            else
                totale_pari+=(alphabet.indexOf(pari.charAt(i)));
        }

        //per i caratteri con indice DISPARI procedo nel seguente modo:
        for(int i=0; i < dispari.length(); i++){
            //verifico se in quella posizione c'è un intero, 0 o 1;
            if(Character.isDigit(dispari.charAt(i)) && dispari.indexOf(i) != 0 && dispari.indexOf(i) != 1){
                if(dispari.indexOf(i)%2==0)
                    totale_dispari += dispari.indexOf(i)+1;
            }
            else if(dispari.charAt(i)=='1')
                totale_dispari+=0;
            else if(dispari.charAt(i) == '0')
                totale_dispari+=1;
            else if(dispari.charAt(i)=='A')
                totale_dispari+=1;
            else if(dispari.charAt(i)=='B')
                totale_dispari+=0;
            else if(dispari.charAt(i)=='C')
                totale_dispari+=5;
            else if(dispari.charAt(i)=='D')
                totale_dispari+=7;
            else if(dispari.charAt(i)=='E')
                totale_dispari+=9;
            else if(dispari.charAt(i)=='F')
                totale_dispari+=13;
            else if(dispari.charAt(i)=='G')
                totale_dispari+=15;
            else if(dispari.indexOf(i)=='H')
                totale_dispari+=17;
            else if(dispari.indexOf(i)=='I')
                totale_dispari+=19;
            else if(dispari.indexOf(i)=='J')
                totale_dispari+=21;
            else if(dispari.charAt(i)=='K')
                totale_dispari+=2;
            else if(dispari.charAt(i)=='L')
                totale_dispari+=4;
            else if(dispari.charAt(i)=='M')
                totale_dispari+=18;
            else if(dispari.charAt(i)=='N')
                totale_dispari+=20;
            else if(dispari.charAt(i)=='O')
                totale_dispari+=11;
            else if(dispari.charAt(i)=='P')
                totale_dispari+=3;
            else if(dispari.charAt(i)=='Q')
                totale_dispari+=6;
            else if(dispari.charAt(i)=='R')
                totale_dispari+=8;
            else if(dispari.charAt(i)=='S')
                totale_dispari+=12;
            else if(dispari.charAt(i)=='T')
                totale_dispari+=14;
            else if(dispari.charAt(i)=='U')
                totale_dispari+=16;
            else if(dispari.charAt(i)=='V')
                totale_dispari+=10;
            else if(dispari.charAt(i)=='W')
                totale_dispari+=22;
            else if(dispari.charAt(i)=='X')
                totale_dispari+=25;
            else if(dispari.charAt(i)=='Y')
                totale_dispari+=24;
            else if(dispari.charAt(i)=='Z')
                totale_dispari+=23;
        }

        totale = totale_dispari+totale_pari;
        codice_finale=totale%26;

        char[] alphabet1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        if (codice_finale > 25) {
            return null;
        }
        return Character.toString(alphabet1[codice_finale]);

        if (Character.toString(alphabet1[codice_finale]) == codice.charAt(11))
            corretto = true;
        else
            return false;


           }



}
