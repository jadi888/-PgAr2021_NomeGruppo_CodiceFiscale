package theFightClub_Cod_Fiscali.unibs.it;

import javax.annotation.processing.SupportedSourceVersion;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class LeggiDati {

    private static final ArrayList<Persona> ListaPersone = new ArrayList<>();

    public static ArrayList<Persona> estraggoDati() {
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;

        try {
            //aggiungo i file xml
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader("inputPersone.xml", new FileInputStream("inputPersone.xml"));
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader: ");
            System.out.println(e.getMessage());
        }

        try {
            while (true) {
                if (!xmlr.hasNext()) break;
                // continua a leggere finché ha eventi a disposizione
                if (xmlr.getEventType() == XMLStreamConstants.START_ELEMENT) {
                    String cognome = null;
                    String nome = null;
                    String anno=null;
                    String mese=null;
                    String giorno = null;
                    String sesso= null;
                    String comune = null;
                    String codice = null;
                        for (int i = 0; i < xmlr.getAttributeCount(); i++) {

                            if (xmlr.getAttributeLocalName(i).equals("cognome")) {
                                cognome = String.valueOf(xmlr.getAttributeValue(i));
                            }
                            if (xmlr.getAttributeLocalName(i).equals("nome")) {
                                nome = String.valueOf(xmlr.getAttributeValue(i));
                            }
                            if (xmlr.getAttributeLocalName(i).equals("data_nascita")) {
                                anno = String.valueOf(xmlr.getAttributeValue(i).substring(0, 3));
                                mese = String.valueOf(xmlr.getAttributeValue(i).substring(5, 6));
                                giorno = String.valueOf(xmlr.getAttributeValue(i).substring(8, 9));
                            }
                            if (xmlr.getAttributeLocalName(i).equals("sesso")) {
                                sesso = String.valueOf(xmlr.getAttributeValue(i));
                            }
                            if (xmlr.getAttributeLocalName(i).equals("comune_nascita")) {
                                comune = String.valueOf(xmlr.getAttributeValue(i));
                                codice = estraggoCodiceComune(comune);
                            }

                        }
                        Persona persona = new Persona(cognome, nome, anno, mese, sesso, giorno, codice);
                        ListaPersone.add(persona);
                }
                xmlr.next();
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    return ListaPersone;
    }



    public static String estraggoCodiceComune(String comune){
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr2 = null;
        String codiceComune = null;
        try {
            //aggiungo i file xml
            xmlif = XMLInputFactory.newInstance();
            xmlr2 = xmlif.createXMLStreamReader("comuni.xml", new FileInputStream("comuni.xml"));
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader: ");
            System.out.println(e.getMessage());
        }

        try{
        while(true){
            try {
                if (!xmlr2.hasNext()) break;
                if (xmlr2.getEventType() == XMLStreamConstants.START_ELEMENT) { ;
                    for (int i = 0; i < xmlr2.getAttributeCount(); i++) {
                        if (xmlr2.getAttributeLocalName(i).equals("codice"))
                            codiceComune = String.valueOf(xmlr2.getAttributeValue(i));
                    }
                }
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        }
    } catch (Exception e) {
            e.printStackTrace();
        }

        return codiceComune;
    }



}





