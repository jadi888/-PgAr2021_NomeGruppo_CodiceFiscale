public class Persona {

    private static String COGNOME = null;
    private static String NOME = null;
    private static String ANNO = null;
    private static String MESE = null;
    private static String GIORNO = null;
    private static String COMUNE = null;
    private static String CHAR_CONTROLLO = null;



    public Persona(String COGNOME, String NOME, String ANNO, String MESE, String GIORNO, String COMUNE, String CHAR_CONTROLLO) {
        this.COGNOME = COGNOME;
        this.NOME = NOME;
        this.ANNO = ANNO;
        this.MESE = MESE;
        this.GIORNO = GIORNO;
        this.COMUNE = COMUNE;
        this.CHAR_CONTROLLO = CHAR_CONTROLLO;
    }

    public static String getCognome(String cognome) {
        if (COGNOME.length() == 2) {
            return COGNOME + 'X';
        }
        char x;
        String new_Cognome;
        new_Cognome = COGNOME.replaceAll("[aeiouAEIOU]",
                "");
        if (new_Cognome.length() == 3) {
            return new_Cognome;
        } else if (new_Cognome.length() < 3) {
            for (int i = 0; i < COGNOME.length(); i++) {
                x = COGNOME.charAt(i);
                if (COGNOME.charAt(i) == 'A' || COGNOME.charAt(i) == 'I' || COGNOME.charAt(i) == 'E'
                        || COGNOME.charAt(i) == 'O' || COGNOME.charAt(i) == 'U')
                    break;
            }
        }
        return COGNOME + "x";
    }

    public static String getNome(String nome) {
        if (NOME.length() == 2) {
            return NOME + 'X';
        }
        char x;
        String new_Nome;
        new_Nome = NOME.replaceAll("[aeiouAEIOU]",
                "");
        if (new_Nome.length() == 3) {
            return new_Nome;
        } else if (new_Nome.length() < 3) {
            for (int i = 0; i < NOME.length(); i++) {
                x = NOME.charAt(i);
                if (NOME.charAt(i) == 'A' || NOME.charAt(i) == 'I' || NOME.charAt(i) == 'E' ||
                        NOME.charAt(i) == 'O' || NOME.charAt(i) == 'U')
                    break;
            }
        }
        return NOME + "x";
    }

    public static String getAnno(String anno){
        String ANNO = anno.substring(2,3);
        return ANNO;
    }


    public static String getMese(String mese) {
        if (mese.equals("01")) {
            String MESE = "A";
            return MESE;
        }
        if (mese.equals("02")) {
            String b = "B";
            return b;
        }
        if (mese.equals("03")) {
            String c = "C";
            return c;
        }
        if (mese.equals("04")) {
            String d = "D";
            return d;
        }
        if (mese.equals("05")) {
            String e = "E";
            return e;
        }
        if (mese.equals("06")) {
            String h = "H";
            return h;
        }
        if (mese.equals("07")) {
            String l = "L";
            return l;
        }
        if (mese.equals("08")) {
            String m = "M";
            return m;
        }
        if (mese.equals("09")) {
            String p = "P";
            return p;
        }
        if (mese.equals("10")) {
            String r = "R";
            return r;
        }
        if (mese.equals("11")) {
            String s = "S";
            return s;
        }
        if (mese.equals("12")) {
            String t = "T";
            return t;
        }
        return null;
    }


    public static String getGiorno (String giorno, String genere) {
        if (genere.equals('F')){
            int g = Integer.parseInt(giorno);
            GIORNO = String.valueOf(40 + g);
            return GIORNO;
        }
        else if(genere.equals('M')){
            // se il giorno è compreso tra 1-9 aggiungo un zero davanti;
            if (((Integer.parseInt(GIORNO)) >= 1) && (Integer.parseInt(GIORNO)) <= 9) {
                return '0' + GIORNO;
            }
            else
                return GIORNO;
        }
        else return null;
    }

    /*a partire dai 15 caratteri alfanumerici ricavati, determiniamo il carattere di controllo in base all'algoritmo
    che opera nel seguente modo:
    1. mettiamo da una parte i caratteri alfanumerici che si trovano in posizione dispari e da un'altra
    quelli che si trovano in posizione pari.
    2. fatto questo, i carattteri vengono convertiti secondo speciali regolo.
    (per dettagli vedi wikipedia);
     */

    public static String getCarattereSpeciale (String cod) {
        int codice_finale;
        int totale = 0;
        int totale_pari=0;
        int totale_dispari=0;


        /* le stringhe in cui salvo rispettivamente i caratteri con indice pari o dispari*/
        StringBuffer pari = new StringBuffer();
        StringBuffer dispari = new StringBuffer();
        for (int j = 0; j < cod.length(); j++) {
            if (j % 2 == 0) {
                pari.append(cod.charAt(j));
            } else {
                dispari.append(cod.charAt(j));
            }
        }

        //per i caratteri con indice pari procedo nel seguente modo:
        final String alphabet = "ABCDEFGHIJKLMNOPQRST";
        for(int i = 0; i < pari.length(); i++){
            /*se il carattere è un intero lo sommo al totale dei pari*/
            if(Character.isDigit(pari.charAt(i)))
                totale_pari+=(int)pari.charAt(i);
                /*se il carattere è un char allora li assegno il numero in base all'ordine che occupa nell'alfabeto*/
            else
                totale_pari+=(alphabet.indexOf(pari.charAt(i)));
        }

        //per i caratteri con indice DISPARI procedo nel seguente modo:
        for(int i=0; i < dispari.length(); i++){
            //verifico se in quella posizione c'è un intero, 0 o 1;
            if(Character.isDigit(dispari.charAt(i)) && dispari.charAt(i) != 0 && dispari.charAt(i) != 1){
                if((dispari.charAt(i))%2==0)
                    totale_dispari += dispari.charAt(i)+1;
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
            else if(dispari.charAt(i)=='H')
                totale_dispari+=17;
            else if(dispari.charAt(i)=='I')
                totale_dispari+=19;
            else if(dispari.charAt(i)=='J')
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
        CHAR_CONTROLLO = Character.toString(alphabet1[codice_finale]);
        return CHAR_CONTROLLO;

    }

    public String toStringIniziale() {
        final String s = COGNOME + NOME + ANNO + MESE + GIORNO + COMUNE;
        return s;
    }
    public String toString() {
        final String s = COGNOME + NOME + ANNO + MESE + GIORNO + COMUNE + CHAR_CONTROLLO;
        return s;
    }

}