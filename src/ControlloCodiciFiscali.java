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





    private static void printElement(Document someNode) {
        NodeList nodeList = someNode.getElementsByTagName("codici");
        int q;
        for(int z=0,size= nodeList.getLength();z<size; z++) {

        }
    }
    /*try {
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

*/

}
