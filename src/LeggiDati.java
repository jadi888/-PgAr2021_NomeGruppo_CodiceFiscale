import java.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import jdk.internal.icu.text.UnicodeSet;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LeggiDati<DocumentBuilderDactory, ListaCodici> {
    private static static DocumentBuilderDactory;
    private static static ListaCodici;

    private ArrayList<Codici> ListaCodici = new ArrayList<Codici>();

    public <Nodelist> void main(){
        try {
            //aggiungo i file xml
            File file = new File("inputPersone.xml");
            File file1 = new File("comuni.xml");
            DocumentBuilderFactory dbf = DocumentBuilderDactory.newIstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            Document doc1 = db.parse(file1);
            NodeList listaPersone = doc.getElementsByTagName("persona");
            NodeList listaComuni = doc.getElementsByTagName("comuni");
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

        //prendo il numero di elementi del file xml "inputPersone"
            int quantePersone = listaPersone.getLenght();
            int quantiComuni =listaComuni.getLenght();

            //istanzio le due classi DataNascita e MeseNascita per utilizzare i rispettivi metodi
            DataNascita anno = new DataNascita();
            MeseNascita mese = new MeseNascita();
            GiornoNascita giorni = new GiornoNascita();
            CancellaVocali canc = new CancellaVocali();
            CarattereControllo car_control = new CarattereControllo();

            //per ogni elemento di listaPersone estraggo i vari dati per generare poi i codici fiscali
            for(int i=0; i < quantePersone; i++) {
                String cognome1; //estraggo cognome e cancello vocali
                cognome1 = CancellaVocali.Cancella(listaPersone(i).getAttribute("cognome"));
                String nome1 = CancellaVocali.Cancella(listaPersone(i).getAttribute("nome"));//estraggo nome  e cancello vocali

                /* prendo l'anno di nascita e considero solo le ultime due cifre */
                String annoNascita = DataNascita.UltimeDueCifre(listaPersone(i).getAttribute("data_nascita").substring(0, 3));

                //prendo il mese di nascita e lo converto nella lettera corrispondente secondo Wikipedia
                String meseNascita = MeseNascita.ConvertiMese(listaPersone(i).getAttribute("data_nascita").substring(5, 6));

                //prendo il giorno di nascita e lo converto a seconda che sia maschio o femmina
                String giornoNascita = (int) GiornoNascita.giornoN(listaPersone(i).getAttribute("data_nascita").substring(9, 10),
                        listaPersone(i).getAttribute("sesso"));

                /*prendo il comune di inputPersone  e li assegno il codice composto
                    da una lettera e 3 cifre dal file comuni.xml, se c'è*/
                String comune = listaPersone(i).getAttribute("comune_nascita");

                for(int k=0; k < quantiComuni; k++)
                    if(listaComuni(k).getAttribute("nome").equals(comune))
                       String codiceComune = listaComuni(k).getAttribute("codice");
                    else return;


                //creo un codice fiscale temporaneo perchè non ha ancora il carattere di controllo finale;
                String codiceComune = null;

               String codice_temp = (String) new Codici(cognome1,nome1, annoNascita, meseNascita, giornoNascita, codiceComune, "");

                //dopo varia manipolazioni ottengo il codice identificativo finale e cosi' posso comporre il mio codice fiscale vero
                String codice_identificativo = CarattereControllo.controllo(codice_temp);

                //compongo finalmente il codice fiscale da aggiungere alla listacodici
                Codici codice_fiscale = new Codici(cognome1,nome1, annoNascita, meseNascita, giornoNascita, codiceComune, codice_identificativo);

                //ho creato il CF con i vari pezzi di sopra e lo aggiungo all'ArrayList ListaCodici
                ListaCodici.add(codice_fiscale);

                }


            }









        }
    }
