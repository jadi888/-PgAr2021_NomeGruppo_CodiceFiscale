import java.*;

public class GiornoNascita(){

    public static int giornoN (int giorno, char genere) {
        if( genere == 'M') {
            if (giorno >= 1 && giorno <= 9)
                return '0' + giorno;
            else return giorno;
        }
        else if(genere == 'F') {
            return 40 + giorno;
        }
        else {
            return;
        }
         }
    }