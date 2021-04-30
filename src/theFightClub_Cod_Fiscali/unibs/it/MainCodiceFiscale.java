package theFightClub_Cod_Fiscali.unibs.it;


import java.util.ArrayList;

public class MainCodiceFiscale {
   private static final ArrayList<Persona> listaPersone = LeggiDati.estraggoDati();

    public static void main(String[] args){

        for(Persona persona : listaPersone){
            Persona.setCF(CodiceFiscale.generaCodice(persona));
            System.out.println(persona.getCF());
        }
        //chiamo classe creaoutput con parametro lista persone
    }
}
