package Klub;

public class Menuer {
    public static void hovedMenu() {
        System.out.println("\nVelkommen til Svømmeklubben Delfinen");
        System.out.println("1. Formand");
        System.out.println("2. Kasserer");
        System.out.println("3. Træner");
        System.out.println("9. Afslut");
        System.out.print("Vælg en mulighed: ");
    }

    public static void formandMenu() {
        System.out.println("\nFormand Menu");
        System.out.println("1. Opret medlem");
        System.out.println("2. Vis medlemsliste");
        System.out.println("9. Tilbage til hovedmenu");
        System.out.print("Vælg en mulighed: ");
    }

    public static void kassererMenu() {
        System.out.println("\nKasserer Menu");
        System.out.println("1. Vis medlemmer i restance");
        System.out.println("2. Opkræv kontingent");
        System.out.println("9. Tilbage til hovedmenu");
        System.out.print("Vælg en mulighed: ");
    }

    public static void traenerMenu() {
        System.out.println("\nTræner Menu");
        System.out.println("1. Registrer træningsresultat");
        System.out.println("2. Registrer konkurrenceresultat");
        System.out.println("3. Vis top 5 svømmere");
        System.out.println("9. Tilbage til hovedmenu");
        System.out.print("Vælg en mulighed: ");
    }

    public static void filMenu() {
        System.out.println("\nFilhåndtering Menu");
        System.out.println("1. Gem alle medlemmer");
        System.out.println("2. Gem medlemmer i restance");
        System.out.println("3. Gem konkurrencesvømmere");
        System.out.println("9. Tilbage til hovedmenu");
        System.out.print("Vælg en mulighed: ");
    }
}
