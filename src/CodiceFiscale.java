public class CodiceFiscale {

    public static String generaCodice(Persona persona){
        String cognome1 = per
        String nome1 = Persona.getNome(String.valueOf(xmlPersone.item(i).getAttributes().getNamedItem("name")));

        /* prendo l'anno di nascita e considero solo le ultime due cifre */
        String annoNascita = Persona.getAnno(String.valueOf(xmlPersone.item(i).getAttributes().getNamedItem("data_nascita")));
        //prendo il mese di nascita e lo converto nella lettera corrispondente secondo Wikipedia
        String meseNascita = Persona.getMese(String.valueOf(xmlPersone.item(i).getAttributes().getNamedItem("data_nascita")).substring(5, 6));

        //prendo il giorno di nascita e lo converto a seconda che sia maschio o femmina
        String giornoNascita = Persona.getGiorno(String.valueOf(xmlPersone.item(i).getAttributes().getNamedItem("data_nascita")).substring(5,6),
                String.valueOf(xmlPersone.item(i).getAttributes().getNamedItem("sesso")));


                /*prendo il comune di inputPersone  e li assegno il codice composto
                    da una lettera e 3 cifre dal file comuni.xml, se c'è*/
        String comune = String.valueOf(xmlPersone.item(i).getAttributes().getNamedItem("comune_nascita"));



        //creo un codice fiscale temporaneo perchè non ha ancora il carattere di controllo finale;
        Persona codice_temp = new Persona(cognome1, nome1, annoNascita, meseNascita, giornoNascita);

        //dopo varia manipolazioni ottengo il codice identificativo finale e cosi' posso comporre il mio codice fiscale vero
        String codice_identificativo = Persona.getCarattereSpeciale(codice_temp.toStringIniziale());

        //compongo finalmente il codice fiscale da aggiungere alla listacodici
        Persona codice_fiscale = new Persona(cognome1, nome1, annoNascita, meseNascita, giornoNascita, codiceComune, codice_identificativo);
    }
}
