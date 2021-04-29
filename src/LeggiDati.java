import java.*;
import javax.xml.crypto.Data;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import jdk.internal.icu.text.UnicodeSet;
import jdk.jshell.execution.Util;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LeggiDati<DocumentBuilderDactory, ListaCodici> {

    private static ArrayList<Persona> ListaPersone = new ArrayList<>();
    private static ArrayList<Persona> ListaComuni = new ArrayList<>();


    public ArrayList<Persona> estraggoDati() {
        Document doc1 = null;
        Document doc = null;
        try {
            //aggiungo i file xml
            File file = new File("inputPersone.xml");
            File file1 = new File("comuni.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(file);
            doc1 = db.parse(file1);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        //prendo il numero di elementi del file xml "inputPersone"
        assert doc != null;
        NodeList xmlPersone = doc.getElementsByTagName("persone");
        NodeList xmlComuni = doc1.getElementsByTagName("comuni");
        int quantePersone = xmlPersone.getLength();
        int quantiComuni = xmlComuni.getLength();

        //per ogni elemento di xmlPersone estraggo i vari dati per generare poi i codici fiscali
        for (int i = 0; i < quantePersone; i++) {
            //estraggo nome  e cancello vocali
            String cognome1 = String.valueOf(xmlPersone.item(i).getAttributes().getNamedItem("cognome"));
            String nome1 = String.valueOf(xmlPersone.item(i).getAttributes().getNamedItem("name"));

            /* prendo l'anno di nascita e considero solo le ultime due cifre */
            String annoNascita = String.valueOf(xmlPersone.item(i).getAttributes().getNamedItem("data_nascita"));

            //prendo il mese di nascita e lo converto nella lettera corrispondente secondo Wikipedia
            String meseNascita = String.valueOf(xmlPersone.item(i).getAttributes().getNamedItem("data_nascita")).substring(5, 6);

            //prendo il giorno di nascita e lo converto a seconda che sia maschio o femmina
            String giornoNascita = String.valueOf(xmlPersone.item(i).getAttributes().getNamedItem("data_nascita")).substring(8, 9);

            String sesso = String.valueOf(xmlPersone.item(i).getAttributes().getNamedItem("sesso"));


                /*prendo il comune di inputPersone  e li assegno il codice composto
                    da una lettera e 3 cifre dal file comuni.xml, se c'è*/
            String comune = String.valueOf(xmlPersone.item(i).getAttributes().getNamedItem("comune_nascita"));
            String codiceComune = null;
            quantiComuni = xmlComuni.getLength();
            for (int k = 0; k < quantiComuni; k++) {
                if (xmlComuni.item(k).getAttributes().getNamedItem("nome").equals(comune))
                    codiceComune = String.valueOf(xmlComuni.item(i).getAttributes().getNamedItem("codice"));
            }

            Persona persona = new Persona(cognome1, nome1, annoNascita, meseNascita, giornoNascita, sesso, codiceComune);
            ListaPersone.add(persona);

        }
        return ListaPersone;

    }

}