import java.*;

public class CancellaVocali() {

    public static String Cancella(String str) {
        if (str.length() == 2) {
            return str + 'X';
        }

            for (int i = 0; i < str.length(); i++) {
            if (str(i) == 'A' || str(i) == 'E' || str(i) == 'I' || str(i) == 'O' || str(i) == 'U')
                char x = str(i);
            break;
        }

        String new_str;
        new_str = str.replaceAll("[aeiouAEIOU]",
                "");


        if (new_str.length() == 3) {
            return new_str;
        } else if (new_str.length() < 3) {
            return str + x;
        }
    }
}