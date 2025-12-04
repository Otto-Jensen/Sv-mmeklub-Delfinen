package Klub;

import java.util.List;
import java.util.Scanner;

public class Kassere {

    public void visRestance(List<Medlem> medlemsliste) {
        System.out.println("Følgende medlemmer er i restance:");
        boolean ingenIRestance = true;
        for (Medlem medlem : medlemsliste) {
            if (!medlem.harBetalt()) {
                System.out.println("- " + medlem.getFornavn() + " " + medlem.getEfternavn() +
                        " (Kontingent: " + medlem.beregnKontingent() + " kr)");
                ingenIRestance = false;
            }
        }
        if (ingenIRestance) {
            System.out.println("Ingen medlemmer er i restance.");
        }
    }

    public void opkraevKontingent(List<Medlem> medlemsliste, Scanner scanner) {
        System.out.println("Hvilket medlem vil du opkræve kontingent for?");
        for (int i = 0; i < medlemsliste.size(); i++) {
            System.out.println((i + 1) + ". " + medlemsliste.get(i).getFornavn() + " " + medlemsliste.get(i).getEfternavn());
        }
        System.out.print("Vælg et nummer: ");
        int valg = scanner.nextInt();
        scanner.nextLine();

        if (valg > 0 && valg <= medlemsliste.size()) {
            Medlem valgtMedlem = medlemsliste.get(valg - 1);
            if (!valgtMedlem.harBetalt()) {
                valgtMedlem.setHarBetalt(true);
                System.out.println("Kontingent opkrævet for " + valgtMedlem.getFornavn() + " " + valgtMedlem.getEfternavn());
            } else {
                System.out.println(valgtMedlem.getFornavn() + " " + valgtMedlem.getEfternavn() + " har allerede betalt.");
            }
        } else {
            System.out.println("Ugyldigt valg.");
        }
    }
}