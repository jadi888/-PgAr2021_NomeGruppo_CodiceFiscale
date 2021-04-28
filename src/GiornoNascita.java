public class GiornoNascita(){

    public static String giornoN (String giorno, String genere) {
        if (genere.equals('F')){
            int g = Integer.parseInt(giorno);
            return String.valueOf(40 + g);
        }
        else if(genere.equals('M')){
            // se il giorno è compreso tra 1-9 aggiungo un zero davanti;
            if (((Integer.parseInt(giorno)) >= 1) && (Integer.parseInt(giorno)) <= 9) {
                return '0' + giorno;
            }
            else
                return giorno;
        }
        else return null;

    }
}