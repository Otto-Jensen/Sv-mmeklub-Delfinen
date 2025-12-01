package Klub;

import java.util.ArrayList;
import java.util.Scanner;

public class Kassere {
private MedlemsListe medlemsListe;

public Kassere(MedlemsListe medlemsliste){
    this.medlemsListe=medlemsliste;
}

    public ArrayList<Medlem>oversigtRestance(){
        ArrayList<Medlem> restanceliste=new ArrayList<>();

        for(Medlem m:medlemsListe.getMedlemmer()){
            if(!m.isHarBetalt()){
                restanceliste.add(m);
            }
        }
        return restanceliste;
    }

    public void printOversigtRestance(){
    ArrayList<Medlem> liste=oversigtRestance();

    if (liste.isEmpty()){
        System.out.println("Der er ingen medlemmer i restance");
        return;
    }

        System.out.println("Medlemmer i restance");
        for (Medlem m:liste){
            System.out.println(m.getNavn()+"\n");
        }
    }
}
