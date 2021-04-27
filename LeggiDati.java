import java.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class LeggiDati{
    private ArrayList <Codici> ListaCodici = new ArrayList<Codici>();

    public static void main(){
        try {
            //aggiungo i file xml
            File file = new File("inputPersone.xml");
            File file1 = new File("comuni.xml");
            DocumentBuilderFactory dbf = DocumentBuilderDactory.newIstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            Document doc = db.parse(file1);
            Nodelist listaPersone = doc.getElementsByTagName("persona");
            Nodelist listaComuni = doc.getElementsByTagName("comuni");
    catch(Exception e){
                System.out.println("Errore nell'inizializzazione del reader:");
                System.out.println(e.getMessage());
            }
        }

            //prendo il numero di elementi del file xml "inputPersone"
            int quantePersone = listaPersone.getLenght();
            int quantiComuni =listaComuni.getLenght();

            //istanzio le due classi DataNascita e MeseNascita per utilizzare i rispettivi metodi
            DataNascita anno = new DataNascita();
            MeseNascita mese = new MeseNascita();
            GiornoNascita giorni = new GiornoNascita();
            CancellaVocali canc = new CancellaVocali();

            //per ogni elemento di listaPersone estraggo i vari dati per generare poi i codici fiscali
            for(int i=0; i < quantePersone; i++) {
                String cognome = canc.CancellaVocali(listaPersone(i).getAttribute("cognome")); //estraggo cognome e cancello vocali
                String nome = canc.CancellaVocali(listaPersone(i).getAttribute("nome"));//estraggo nome  e cancello vocali

                //prendo l'anno di nascita e considero solo le ultime due cifre
                String annoNascita = anno.UltimeDueCifre(listaPersone(i).getAttribute("data_nascita").substring(0, 3));

                //prendo il mese di nascita e lo converto nella lettera corrispondente secondo Wikipedia
                char meseNascita = mese.ConvertiMese(listaPersone(i).getAttribute("data_nascita").substring(5, 6));

                //prendo il giorno di nascita e lo converto a seconda che sia maschio o femmina
                int giornoNascita = g.giornoN(listaPersone(i).getAttribute("data_nascita").substring(9, 10),
                        listaPersone(i).getAttribute("sesso"));

                /*prendo il comune di inputPersone  e li assegno il codice composto
                    da una lettera e 3 cifre dal file comuni.xml, se c'è*/
                String comune = listaPersone(i).getAttribute("comune_nascita");
                for(int k=0; k < quantiComuni; k++){
                    if(listaComuni(k).getAttribute("nome").equals(comune))
                        String codiceComune = listaComuni(k).getAttribute("codice");
                    else return;
                }


                Codici codice_fiscale = new Codici(cognome,nome, annoNascita, meseNascita, giornoNascita, comune, codiceControllo);


                }


            }









        }
    }
