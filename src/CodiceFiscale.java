public class CodiceFiscale {

    public static String generaCodice(Persona persona){
        String cognome = String.valueOf(persona.getCognome());
        String nome1 = String.valueOf(persona.getNome());
