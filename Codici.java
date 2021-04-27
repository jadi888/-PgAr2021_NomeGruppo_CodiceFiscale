public class Codici {

    private static final String COGNOME;
    private static final String NOME;
    private static final String ANNO;
    private static final char MESE;
    private static final String GIORNO;
    private static final String COMUNE;
    private static final char CHAR_CONTROLLO;


    public Codici(String COGNOME, String NOME, String ANNO, char MESE, string GIORNO, String COMUNE, char CHAR_CONTROLLO) {
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
        return COGNOME+NOME+ANNO+MESE+COMUNE+CHAR_CONTROLLO;
    }