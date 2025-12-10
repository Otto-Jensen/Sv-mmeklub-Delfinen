package Klub;

import java.util.ArrayList;
import java.util.Scanner;

public class Kassere {
private MedlemsListe medlemsListe;

public Kassere(MedlemsListe medlemsListe){
    this.medlemsListe=medlemsListe;
}

    public ArrayList<Medlem>oversigtRestance(){
        ArrayList<Medlem> restanceListe=new ArrayList<>();

        for(Medlem m:medlemsListe.getMedlemmer()){
            if(!m.isHarBetalt()){
                restanceListe.add(m);
            }
        }
        return restanceListe;
    }

    public void printOversigtRestance(){
    ArrayList<Medlem> liste=oversigtRestance();

    if (liste.isEmpty()){
        System.out.println("Der er ingen medlemmer i restance");
        return;
    }

        System.out.println("Medlemmer i restance");
        for (Medlem m:liste){
            System.out.println(m.getNavn()+"\n" + m.beregnKontingent());
        }
    }
    public void registrerBetaling() {
    Scanner input=new Scanner(System.in);
        System.out.println("Indtast navnet på medlem der skal betale");
        String navn= input.nextLine();
        Medlem medlem=medlemsListe.soegNavn(navn);
        if (medlem!=null){
            medlem.setHarBetalt(true);
            System.out.println(medlem.getNavn()+" Har nu betalt");
        }
        else{System.out.println("Medlem ikke fundet");}
    }

    public void fjernBetaling(Medlem medlem) {
        medlem.setHarBetalt(false);
        System.out.println(medlem.getNavn() + " står nu som ikke betalt.");
    }

}
