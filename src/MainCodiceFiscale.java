import java.util.ArrayList;

public class MainCodiceFiscale {
   private static ArrayList<Persona> listaPersone = LeggiDati.estraggoDati();

    public static void main(){

        for(Persona persona : listaPersone){
            persona.setCF(CodiceFiscale.generaCodice(persona));
            System.out.println(persona.getCF());
        }
    }
}
