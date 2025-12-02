package Klub;

import java.util.Scanner;

public class Menuer {
    private MedlemsListe medlemsListe = new MedlemsListe();
    private Kassere kassere = new Kassere(medlemsListe);
    private Scanner input=new Scanner(System.in);


    public void start() {
    boolean going = true;
    while (going) {
        System.out.println("Vælg rolle");
        System.out.println("1.Træner");
        System.out.println("2. Kasserer");
        System.out.println("3.Formand");
        System.out.println("4. Afslut");
        System.out.println("Valg:");

        int valg = input.nextInt();

        switch (valg) {
            case 1:
                traenerMenu();
                break;

            case 2:
                kassereMenu();
                break;

            case 3:
                formandMenu();
                break;

            case 0:
                System.out.println("Programmet lukker ned");
                going = false;
                break;

            default:
                System.out.println("Ugyldigt valg");
                break;
        }
    }
}
     public void traenerMenu(){
        System.out.println("1. se Konkurrencesvømmere");
        System.out.println("2. Indberet træningstid");
        System.out.println("3.Indberet Konkurrencetid");
    }

     public void kassereMenu(){
        System.out.println("1. Se medlemmer i restance");
        System.out.println("2. Modtag betaling");
        int valg= input.nextInt();
        if(valg==1){
            kassere.printOversigtRestance();
        }else if(valg==2){
            System.out.println("ændre til metodekald inde fra kassere der håndtere betalinger.");
        }
    }

     public void formandMenu(){
        System.out.println("1. Opret medlem");
        int valg= input.nextInt();
        if(valg==1){
//        opretMedlem();
        }else{
            System.out.println("Ugyldigt valg");
            return;
        }
    }

}
