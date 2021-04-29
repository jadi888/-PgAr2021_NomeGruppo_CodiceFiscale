public class Persona {

    private static String COGNOME = null;
    private static String NOME = null;
    private static String ANNO = null;
    private static String MESE = null;
    private static String SESSO = null;
    private static String GIORNO = null;
    private static String COMUNE = null;
    private static String CF =  null;




    public Persona(String COGNOME, String NOME, String ANNO, String MESE, String SESSO ,String GIORNO, String COMUNE) {
        this.COGNOME = COGNOME;
        this.NOME = NOME;
        this.ANNO = ANNO;
        this.MESE = MESE;
        this.SESSO = SESSO;
        this.GIORNO = GIORNO;
        this.COMUNE = COMUNE;

    }

public String getCOGNOME(){
        return COGNOME;
}

public String getNOME(){
        return NOME;
}

public String getANNO(){
        return ANNO;
}

public String getMESE(){
        return MESE;
}

public String getGIORNO(){
        return GIORNO;
}

public String getSESSO(){
        return SESSO;
}

public String getCOMUNE(){
        return COMUNE;
}

public String getCF(){
        return CF;
}

public static void setCF(String CF){
        Persona.CF = CF;
}



    }

