package theFightClub_Cod_Fiscali.unibs.it;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LeggiDati {

    private static final ArrayList<Persona> ListaPersone = new ArrayList<>();


    public static ArrayList<Persona> estraggoDati() {
        Document doc1 = null;
        Document doc = null;
        try {
            //aggiungo i file xml
            File file = new File("theFightClub_Cod_Fiscali/unibs/it/inputPersone.xml");
            File file1 = new File("theFightClub_Cod_Fiscali/unibs/it/comuni.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(file);
            doc1 = db.parse(file1);

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        //prendo il numero di elementi del file xml "inputPersone"
        assert doc != null;
        NodeList xmlPersone = doc.getElementsByTagName("persone");
        assert doc1 != null;
        NodeList xmlComuni = doc1.getElementsByTagName("comuni");

        //prendo il numero di eventi dei file xml , persone e comuni.
        int quantePersone = xmlPersone.getLength();
        int quantiComuni = xmlComuni.getLength();

        //per ogni elemento di xmlPersone estraggo i vari dati per generare poi i codici fiscali
        for (int i = 0; i < quantePersone; i++) {
            //estraggo nome
            String cognome1 = String.valueOf(xmlPersone.item(i).getAttributes().getNamedItem("cognome"));

            //estraggo cognome
            String nome1 = String.valueOf(xmlPersone.item(i).getAttributes().getNamedItem("name"));

            // prendo l'anno di nascita
            String annoNascita = String.valueOf(xmlPersone.item(i).getAttributes().getNamedItem("data_nascita"));

            /*prendo il mese di nascita, uso substring per prendere solo la parte che serve es 1976-05-15
            (indici 5,6 sono riferiti proprio al mese)
             */
            String meseNascita = String.valueOf(xmlPersone.item(i).getAttributes().getNamedItem("data_nascita")).substring(5, 6);

            /*prendo il giorno di nascita, uso substring per prendere solo la parte che serve es 1976-05-15
            (indici 8,9 sono riferiti proprio al giorno)
             */
            String giornoNascita = String.valueOf(xmlPersone.item(i).getAttributes().getNamedItem("data_nascita")).substring(8, 9);

            //prendo il sesso M o F
            String sesso = String.valueOf(xmlPersone.item(i).getAttributes().getNamedItem("sesso"));


                /*prendo il comune di inputPersone  e li assegno il codice composto
                    da una lettera e 3 cifre dal file comuni.xml, se c'è*/

            String comune = String.valueOf(xmlPersone.item(i).getAttributes().getNamedItem("comune_nascita"));
            String codiceComune = null;
            for (int k = 0; k < quantiComuni; k++) {
                /*confronto il comune della persona con i comuni della lista comuni del file comuni.xml per
                trovare il codice del comune ched mi serve
                 */
                if (String.valueOf(xmlComuni.item(k).getAttributes().getNamedItem("nome")).equals(comune))
                    codiceComune = String.valueOf(xmlComuni.item(i).getAttributes().getNamedItem("codice"));
            }


            //aggiungo tutte le info raccolte dai file xml alla persona e aggiungo la persona all'ArrayList;
            Persona persona = new Persona(cognome1, nome1, annoNascita, meseNascita, giornoNascita, sesso, codiceComune);
            ListaPersone.add(persona);

        }
        return ListaPersone;

    }

}