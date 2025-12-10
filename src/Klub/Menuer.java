package Klub;

import java.util.Scanner;

public class Menuer {
    private MedlemsListe medlemsListe=new MedlemsListe();
    private Traener traener=new Traener(medlemsListe);
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
        System.out.println("3.Bedste svømmere i klubben");
        int valg = input.nextInt();
        if(valg==1){
            System.out.println(traener.toStringHoldA()+"\t\t\t\t\t\t");
            System.out.println(traener.toStringHoldB());
        }else if(valg==2){
           medlemsListe.indberetTraeningstid();
        }else if (valg ==3){
            System.out.println("1. Top 5 Bryst");
            System.out.println("2. Top 5 Crawl");
            System.out.println("3. Top 5 Freestyle");
            System.out.println("4. Top 5 Butterfly");
            input.nextLine();
            switch (valg){
                case 1:
                    medlemsListe.top5(Diciplin.BRYST);
                    break;

                case 2:
                    medlemsListe.top5(Diciplin.CRAWL);
                    break;

                case 3:
                    medlemsListe.top5(Diciplin.FREESTYLE);
                    break;

                case 4:
                  medlemsListe.top5(Diciplin.BUTTERFLY);
                    break;
            }
        }
    }

     public void kassereMenu(){
        System.out.println("1. Se medlemmer i restance");
        System.out.println("2. Modtag betaling");
        int valg= input.nextInt();
        if(valg==1){
            kassere.printOversigtRestance();
        }else if(valg==2){
            kassere.registrerBetaling();
        }
    }

     public void formandMenu(){
        System.out.println("1. Opret medlem");
        int valg= input.nextInt();
        if(valg==1){
        medlemsListe.opretMedlem();
        traener.tildelHold();
        }else{
            System.out.println("Ugyldigt valg");
            return;
        }
    }

}
