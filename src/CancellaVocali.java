public class CancellaVocali() {

    public static String Cancella(String str) {
        if (str.length() == 2) {
            return str + 'X';
        }
        char x;

        String new_str;
        new_str = str.replaceAll("[aeiouAEIOU]",
                "");


        if (new_str.length() == 3) {
            return new_str;
        } else if (new_str.length() < 3) {
            for (int i = 0; i < str.length(); i++) {
                x = str.charAt(i);
                if (str.charAt(i) == 'A' || str.charAt(i) == 'I' || str.charAt(i) == 'E' || str.charAt(i) == 'O' || str.charAt(i) == 'U')
                    break;
            }
            return str + "x";
            
        }
    }
}