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
        Persona persona = new Persona();
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
            String elementoAttuale = "";
            while (xmlr.hasNext()) {
                switch (xmlr.getEventType()){
                    case XMLStreamConstants.START_ELEMENT:
                        elementoAttuale = xmlr.getLocalName();
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        if (elementoAttuale.equalsIgnoreCase("cognome")) {
                            String cognome = xmlr.getText();
                            persona.setCOGNOME(cognome);
                        }
                        if (elementoAttuale.equalsIgnoreCase("nome")) {
                            String nome = xmlr.getText();
                            persona.setNOME(nome);
                        }
                        if (elementoAttuale.equalsIgnoreCase("data_nascita")) {
                            String anno = xmlr.getText().substring(0, 3);
                                persona.setANNO(anno);
                            String mese = xmlr.getText().substring(5, 6);
                                persona.setMESE(mese);
                            String giorno = xmlr.getText().substring(8, 9);
                                persona.setGIORNO(giorno);
                        }
                        if (elementoAttuale.equalsIgnoreCase("sesso")) {
                            String sesso = xmlr.getText();
                            persona.setSESSO(sesso);
                        }
                        if (elementoAttuale.equalsIgnoreCase("comune")) {
                            String comune = xmlr.getText();
                            String codice = estraggoCodiceComune(comune);
                            persona.setCOMUNE(codice);
                        }
                        ListaPersone.add(persona);
                        break;
                }
            } xmlr.close();
            xmlr.next();
        } catch (Exception e) {
            e.printStackTrace();
    }

        return ListaPersone;
    }




    public static String estraggoCodiceComune(String comune) {
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr2 = null;
        String nomeComune;

        try {
            //aggiungo i file xml
            xmlif = XMLInputFactory.newInstance();
            xmlr2 = xmlif.createXMLStreamReader("comuni.xml", new FileInputStream("comuni.xml"));
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader: ");
            System.out.println(e.getMessage());
        }

        String codiceComune = null;
        try {
            String elementoAttuale = "";
            while (xmlr2.hasNext()) {

                switch (xmlr2.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        elementoAttuale = xmlr2.getLocalName();
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        if (elementoAttuale.equalsIgnoreCase("nome")) {
                            nomeComune = String.valueOf(xmlr2.getText());

                            if (nomeComune.equalsIgnoreCase(comune)) {
                                if (elementoAttuale.equalsIgnoreCase("codice")) {
                                    codiceComune = String.valueOf(xmlr2.getText());
                                }
                            }
                        }
                        break;
                }
                xmlr2.close();
                xmlr2.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return codiceComune;
    }



}





