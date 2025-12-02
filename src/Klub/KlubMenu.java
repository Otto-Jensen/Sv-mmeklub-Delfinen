package Klub;

import java.util.Scanner;

public class KlubMenu {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        int valg = 0;

        while (valg != 4) {
            System.out.println("Vælg rolle");
            System.out.println("1.Træner");
            System.out.println("2. Kasserer");
            System.out.println("3.Formand");
            System.out.println("4. Afslut");
            System.out.println("Valg:");

            valg = input.nextInt();
            System.out.println();

            if (valg == 1) {
                int trænerValg = 0;
                while (trænerValg != 3) {
                    System.out.println(" Træner Menu ");
                    System.out.println(" 1. Se alle medlemmer");
                    System.out.println("2.Søg medlem ");
                    System.out.println("3. Tilbage");
                    System.out.println(" Valg:");

                    trænerValg = input.nextInt();
                    System.out.println();

                    if (trænerValg == 1) {
                        System.out.println("træner: viser medlemmer ...");
                    } else if (trænerValg == 2) {
                        System.out.println(" træner: søger efter medlem... ");
                    }

                }
            }
            else if (valg==2){
                int kassererValg =0;
                while (kassererValg !=4){
                   System.out.println(" Kasserer Menu ");
                   System.out.println(" 1.Opret medlem");
                   System.out.println("2.Se medlem ");
                   System.out.println("3. Søg medlem");
                   System.out.println("Valg:");

                   kassererValg = input.nextInt();
                   System.out.println();

                   if (kassererValg ==1){
                       System.out.println(" Kasserer: opretter medlem...");
                   } else if (kassererValg ==2) {
                       System.out.println(" kasserer: viser medlemmer...");
                   } else if (kassererValg ==3);{
                        System.out.println(" Kasserer: søger medlem...");
                    }

                }
            }



            else if (valg ==3 ){
                int FormandValg=0;
                while ( FormandValg !=0){
                    System.out.println(" Formand Menu ");
                    System.out.println("1. Se Alt");
                    System.out.println("Tilbage");
                    System.out.println("Valg");

                    FormandValg = input.nextInt();
                    System.out.println();

                    if (FormandValg == 1 ){
                        System.out.println("Formand: kan se alle oplysninger...");
                    }

                }
            }
            else if ( valg !=4){
                System.out.println("ugydigt valg!");
            }
        }

        System.out.println("Programmet afluttes...");


    }
}