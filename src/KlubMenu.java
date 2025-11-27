import java.util.Scanner;

public class KlubMenu {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        int valg = 0;

        while (valg != 4) {
            System.out.println("vælg rolle");
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
                    System.out.println(" ------ Træner Meun------");
                    System.out.println(" 1. se medlem");
                    System.out.println("2.søg medlem ");
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
                int kassererVlag =0;
                while (kassererVlag !=4){
                   System.out.println(" ------Kasserer Meun------");
                   System.out.println(" 1.Opret medlem");
                   System.out.println("2.Se medlem ");
                   System.out.println("3. søg medlem");
                   System.out.println("valg:");

                   kassererVlag = input.nextInt();
                   System.out.println();

                   if (kassererVlag ==1){
                       System.out.println(" Kasserer: opretter medlem...");
                   } else if (kassererVlag ==2) {
                       System.out.println(" kasserer: viser medlemmer...");
                   } else if (kassererVlag ==3);{
                        System.out.println(" Kasserer: søger medlem...");
                    }

                }
            }



            else if (valg ==3 ){
                int FormandValg=0;
                while ( FormandValg !=0){
                    System.out.println("------- formand Meun------");
                    System.out.println(" 1. Se Alt");
                    System.out.println("Tibage");
                    System.out.println(" Valg");

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