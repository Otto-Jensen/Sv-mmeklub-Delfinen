package Klub;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

public class KlubMenu {
    private MedlemsListe medlemsListe;
    private Kassere kassere;
    private Scanner scanner;
    private Traener traener;
    private FilHaandtering filHaandtering;

    public KlubMenu() {
        this.medlemsListe = new MedlemsListe();
        this.kassere = new Kassere();
        this.scanner = new Scanner(System.in);
        this.filHaandtering = new FilHaandtering();
        this.traener = new Traener("Jens", "Jensen");
        
        List<Medlem> loadedMembers = filHaandtering.laesMedlemmer();
        for (Medlem medlem : loadedMembers) {
            medlemsListe.tilfoejMedlem(medlem);
        }
    }

    public void koer() {
        Menuer.hovedMenu();
        int valg = scanner.nextInt();
        scanner.nextLine();

        while (valg != 9) {
            switch (valg) {
                case 1:
                    formandMenu();
                    break;
                case 2:
                    kassererMenu();
                    break;
                case 3:
                    traenerMenu();
                    break;
                default:
                    System.out.println("Ugyldigt valg.");
            }
            Menuer.hovedMenu();
            valg = scanner.nextInt();
            scanner.nextLine();
        }
    }

    private void formandMenu() {
        Menuer.formandMenu();
        int valg = scanner.nextInt();
        scanner.nextLine();

        while (valg != 9) {
            switch (valg) {
                case 1:
                    opretMedlem();
                    break;
                case 2:
                    medlemsListe.visMedlemmer();
                    break;
                default:
                    System.out.println("Ugyldigt valg.");
            }
            Menuer.formandMenu();
            valg = scanner.nextInt();
            scanner.nextLine();
        }
    }

    private void kassererMenu() {
        Menuer.kassererMenu();
        int valg = scanner.nextInt();
        scanner.nextLine();

        while (valg != 9) {
            switch (valg) {
                case 1:
                    kassere.visRestance(medlemsListe.getMedlemmer());
                    break;
                case 2:
                    kassere.opkraevKontingent(medlemsListe.getMedlemmer(), scanner);
                    filHaandtering.gemMedlemmer(medlemsListe.getMedlemmer());
                    break;
                default:
                    System.out.println("Ugyldigt valg.");
            }
            Menuer.kassererMenu();
            valg = scanner.nextInt();
            scanner.nextLine();
        }
    }

    private void traenerMenu() {
        Menuer.traenerMenu();
        int valg = scanner.nextInt();
        scanner.nextLine();

        while (valg != 9) {
            switch (valg) {
                case 1:
                    registrerTraeningsResultat();
                    break;
                case 2:
                    registrerKonkurrenceResultat();
                    break;
                case 3:
                    visTop5Svoemmere();
                    break;
                default:
                    System.out.println("Ugyldigt valg.");
            }
            Menuer.traenerMenu();
            valg = scanner.nextInt();
            scanner.nextLine();
        }
    }

    private void opretMedlem() {
        System.out.println("Opret nyt medlem");
        System.out.print("Fornavn: ");
        String fornavn = scanner.nextLine();
        System.out.print("Efternavn: ");
        String efternavn = scanner.nextLine();
        System.out.print("Fødselsdato (dd-MM-yyyy): ");
        String fodselsdatoString = scanner.nextLine();
        LocalDate fodselsdato = LocalDate.parse(fodselsdatoString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.print("Adresse: ");
        String adresse = scanner.nextLine();
        System.out.print("Postnummer: ");
        String postnummer = scanner.nextLine();
        System.out.print("By: ");
        String by = scanner.nextLine();
        System.out.print("Telefonnummer: ");
        String telefonnummer = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Aktivt eller passivt medlemskab? (a/p): ");
        String medlemskabstype = scanner.nextLine();
        boolean isAktiv = medlemskabstype.equalsIgnoreCase("a");

        Medlem nytMedlem = null;
        if (isAktiv) {
            System.out.print("Motionist eller konkurrencesvømmer? (m/k): ");
            String aktivType = scanner.nextLine();
            if (aktivType.equalsIgnoreCase("m")) {
                nytMedlem = new Motionist(fornavn, efternavn, fodselsdato, adresse, postnummer, by, telefonnummer, email);
            } else if (aktivType.equalsIgnoreCase("k")) {
                nytMedlem = new Konkurrencesvoemmer(fornavn, efternavn, fodselsdato, adresse, postnummer, by, telefonnummer, email, traener);
            }
        } else {
            nytMedlem = new Medlem(fornavn, efternavn, fodselsdato, adresse, postnummer, by, telefonnummer, email, false);
        }
        
        if (nytMedlem != null) {
            medlemsListe.tilfoejMedlem(nytMedlem);
            filHaandtering.gemMedlemmer(medlemsListe.getMedlemmer());
            System.out.println("Medlem oprettet.");
        }
    }

    private Konkurrencesvoemmer findKonkurrencesvoemmer() {
        List<Konkurrencesvoemmer> konkurrencesvoemmere = new ArrayList<>();
        for (Medlem medlem : medlemsListe.getMedlemmer()) {
            if (medlem instanceof Konkurrencesvoemmer) {
                konkurrencesvoemmere.add((Konkurrencesvoemmer) medlem);
            }
        }

        if (konkurrencesvoemmere.isEmpty()) {
            System.out.println("Der er ingen konkurrencesvømmere.");
            return null;
        }

        System.out.println("Vælg en konkurrencesvømmer:");
        for (int i = 0; i < konkurrencesvoemmere.size(); i++) {
            System.out.println((i + 1) + ". " + konkurrencesvoemmere.get(i).getFornavn() + " " + konkurrencesvoemmere.get(i).getEfternavn());
        }
        System.out.print("Vælg et nummer: ");
        int valg = scanner.nextInt();
        scanner.nextLine();

        if (valg > 0 && valg <= konkurrencesvoemmere.size()) {
            return konkurrencesvoemmere.get(valg - 1);
        } else {
            System.out.println("Ugyldigt valg.");
            return null;
        }
    }

    private void registrerTraeningsResultat() {
        Konkurrencesvoemmer svoemmer = findKonkurrencesvoemmer();
        if (svoemmer != null) {
            System.out.print("Disciplin: ");
            String disciplin = scanner.nextLine();
            System.out.print("Dato (dd-MM-yyyy): ");
            String datoString = scanner.nextLine();
            LocalDate dato = LocalDate.parse(datoString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            System.out.print("Tid (sekunder): ");
            double tid = scanner.nextDouble();
            scanner.nextLine();

            svoemmer.registrerTraeningsResultat(disciplin, dato, tid);
            filHaandtering.gemMedlemmer(medlemsListe.getMedlemmer());
            System.out.println("Træningsresultat registreret.");
        }
    }

    private void registrerKonkurrenceResultat() {
        Konkurrencesvoemmer svoemmer = findKonkurrencesvoemmer();
        if (svoemmer != null) {
            System.out.print("Stævne: ");
            String staevne = scanner.nextLine();
            System.out.print("Disciplin: ");
            String disciplin = scanner.nextLine();
            System.out.print("Placering: ");
            int placering = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Tid (sekunder): ");
            double tid = scanner.nextDouble();
            scanner.nextLine();

            svoemmer.registrerKonkurrenceResultat(staevne, disciplin, placering, tid);
            filHaandtering.gemKonkurrenceResultater(medlemsListe.getMedlemmer());
            System.out.println("Konkurrenceresultat registreret.");
        }
    }

    private void visTop5Svoemmere() {
        System.out.println("Top 5 svømmere:");

        Map<String, List<Konkurrencesvoemmer>> topSvoemmere = new HashMap<>();

        for (Medlem medlem : medlemsListe.getMedlemmer()) {
            if (medlem instanceof Konkurrencesvoemmer) {
                Konkurrencesvoemmer svoemmer = (Konkurrencesvoemmer) medlem;
                
                for (String disciplin : svoemmer.getDiscipliner()) {
                    topSvoemmere.computeIfAbsent(disciplin, k -> new ArrayList<>()).add(svoemmer);
                }
            }
        }

        for (Map.Entry<String, List<Konkurrencesvoemmer>> entry : topSvoemmere.entrySet()) {
            String disciplin = entry.getKey();
            List<Konkurrencesvoemmer> svoemmere = entry.getValue();
            
            svoemmere.sort(Comparator.comparingDouble(s -> s.getBedsteTid(disciplin)));

            System.out.println("\nDisciplin: " + disciplin);
            int count = 0;
            for (Konkurrencesvoemmer svoemmer : svoemmere) {
                if (count < 5) {
                    System.out.println("  " + (count + 1) + ". " + svoemmer.getFornavn() + " " + svoemmer.getEfternavn() + " - Tid: " + svoemmer.getBedsteTid(disciplin));
                    count++;
                }
            }
        }
    }
}

class SvoemmerTid {
    private Konkurrencesvoemmer svoemmer;
    private double tid;

    public SvoemmerTid(Konkurrencesvoemmer svoemmer, double tid) {
        this.svoemmer = svoemmer;
        this.tid = tid;
    }

    public Konkurrencesvoemmer getSvoemmer() {
        return svoemmer;
    }

    public double getTid() {
        return tid;
    }
}