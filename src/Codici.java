public class Codici {

    private static String COGNOME = null;
    private static String NOME = null;
    private static String ANNO = null;
    private static String MESE = null;
    private static String GIORNO = null;
    private static String COMUNE = null;
    private static String CHAR_CONTROLLO = null;


    public Codici(String COGNOME, String NOME, String ANNO, String MESE, String GIORNO, String COMUNE, String CHAR_CONTROLLO) {
        this.COGNOME = COGNOME;
        this.NOME = NOME;
        this.ANNO = ANNO;
        this.MESE = MESE;
        this.GIORNO = GIORNO;
        this.COMUNE = COMUNE;
        this.CHAR_CONTROLLO = CHAR_CONTROLLO;
    }


    @Override
    public String toString() {
        final String s = COGNOME + NOME + ANNO + MESE + GIORNO + COMUNE + CHAR_CONTROLLO;
        return s;
    }
}