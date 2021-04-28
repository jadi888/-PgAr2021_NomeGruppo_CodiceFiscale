import java.*;

public class CarattereControllo extends Codici{

    /*a partire dai 15 caratteri alfanumerici ricavati, determiniamo il carattere di controllo in base all'algoritmo
    che opera nel seguente modo:
    1. mettiamo da una parte i caratteri alfanumerici che si trovano in posizione dispari e da un'altra
    quelli che si trovano in posizione pari.
    2. fatto questo, i carattteri vengono convertiti secondo speciali regolo.
    (per dettagli vedi wikipedia);
     */

    public static String controllo (String cod) {
        int codice_finale=0;
        int totale = 0;
        int totale_pari=0;
        int totale_dispari=0;


        /* le stringhe in cui salvo rispettivamente i caratteri con indice pari o dispari*/
        String pari = "";
        String dispari = "";
        for (int j = 0; j < cod.; j++) {
            if (j % 2 == 0) {
                pari += cod.charAt(j);
            } else {
                dispari += cod.charAt(j);
                 }
            }

        //per i caratteri con indice pari procedo nel seguente modo:
        final String alphabet = "ABCDEFGHIJKLMNOPQRST";
        for(int i = 0; i < pari.length(); i++){
            /*se il carattere è un intero lo sommo al totale dei pari*/
            if(Character.isDigit(pari.charAt(i)))
                totale_pari+=pari.indexOf(i);
            /*se il carattere è un char allora li assegno il numero in base all'ordine che occupa nell'alfabeto*/
            else
                totale_pari+=(alphabet.indexOf(pari.charAt(i)));
        }

        //per i caratteri con indice DISPARI procedo nel seguente modo:
        for(int i=0; i < dispari.length(); i++){
            //verifico se in quella posizione c'è un intero, 0 o 1;
            if(Character.isDigit(dispari.charAt(i)) && dispari.indexOf(i) != 0 && dispari.indexOf(i) != 1){
                if(dispari.indexOf(i)%2==0)
                    totale_dispari += dispari.indexOf(i)+1;
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
            else if(dispari.indexOf(i)=='H')
                totale_dispari+=17;
            else if(dispari.indexOf(i)=='I')
                totale_dispari+=19;
            else if(dispari.indexOf(i)=='J')
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
            else if(dispari.charAt()=='U')
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
        return Character.toString(alphabet1[codice_finale]);

        }
    }