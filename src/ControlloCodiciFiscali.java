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

    try {
        //aggiungo i file xml
        File file3 = new File("codiciFiscali.xml");
        DocumentBuilderFactory dbf = DocumentBuilderDactory.newIstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc2 = db.parse(file3);

    catch(Exception e){
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }
    } catch (ParserConfigurationException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (SAXException e) {
        e.printStackTrace();
    }


    NodeList listaCodiciFiscali = doc.getElementsByTagName("codici");

    int quantiCodici = listaCodiciFiscali.getLength();

    for(int i=0; i < quantiCodici; i++){

    }



}
