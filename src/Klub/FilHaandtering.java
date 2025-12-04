package Klub;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FilHaandtering {

    private static final String MEDLEMMER_FIL = "medlemmer.txt";
    private static final String KONKURRENCE_RESULTATER_FIL = "konkurrenceresultater.txt";

    public void gemMedlemmer(List<Medlem> medlemmer) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(MEDLEMMER_FIL))) {
            for (Medlem medlem : medlemmer) {
                writer.println(medlemToCsv(medlem));
            }
        } catch (IOException e) {
            System.out.println("Fejl ved skrivning til medlemsfil: " + e.getMessage());
        }
    }

    public List<Medlem> laesMedlemmer() {
        List<Medlem> medlemmer = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(MEDLEMMER_FIL))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                Medlem medlem = csvToMedlem(line);
                if (medlem != null) {
                    medlemmer.add(medlem);
                }
            }
        } catch (IOException e) {
        }
        return medlemmer;
    }
    
    public void gemKonkurrenceResultater(List<Medlem> medlemmer) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(KONKURRENCE_RESULTATER_FIL))) {
            for (Medlem medlem : medlemmer) {
                if (medlem instanceof Konkurrencesvoemmer) {
                    Konkurrencesvoemmer svoemmer = (Konkurrencesvoemmer) medlem;
                    for (KonkurrenceResultat resultat : svoemmer.getKonkurrenceResultater()) {
                        writer.println(konkurrenceResultatToCsv(svoemmer, resultat));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Fejl ved skrivning til konkurrenceresultatfil: " + e.getMessage());
        }
    }

    private String medlemToCsv(Medlem medlem) {
        String type;
        if (medlem instanceof Konkurrencesvoemmer) {
            type = "Konkurrencesvoemmer";
        } else if (medlem instanceof Motionist) {
            type = "Motionist";
        } else {
            type = "Medlem";
        }

        return String.join(";",
                type,
                medlem.getFornavn(),
                medlem.getEfternavn(),
                medlem.getFødselsdato().toString(),
                medlem.getAdresse(),
                medlem.getPostnummer(),
                medlem.getBy(),
                medlem.getTelefonnummer(),
                medlem.getEmail(),
                String.valueOf(medlem.isAktiv()),
                String.valueOf(medlem.harBetalt())
        );
    }
    
    private String konkurrenceResultatToCsv(Konkurrencesvoemmer svoemmer, KonkurrenceResultat resultat) {
        return String.join(";",
                svoemmer.getEmail(),
                resultat.getStaevne(),
                resultat.getDisciplin(),
                String.valueOf(resultat.getPlacering()),
                String.valueOf(resultat.getTid())
        );
    }

    private Medlem csvToMedlem(String csvLine) {
        String[] parts = csvLine.split(";");
        if (parts.length < 11) {
            return null;
        }

        String type = parts[0];
        String fornavn = parts[1];
        String efternavn = parts[2];
        LocalDate fodselsdato = LocalDate.parse(parts[3]);
        String adresse = parts[4];
        String postnummer = parts[5];
        String by = parts[6];
        String telefonnummer = parts[7];
        String email = parts[8];
        boolean isAktiv = Boolean.parseBoolean(parts[9]);
        boolean harBetalt = Boolean.parseBoolean(parts[10]);

        Medlem medlem = null;
        switch (type) {
            case "Konkurrencesvoemmer":
                medlem = new Konkurrencesvoemmer(fornavn, efternavn, fodselsdato, adresse, postnummer, by, telefonnummer, email, new Traener("Default", "Trainer"));
                break;
            case "Motionist":
                medlem = new Motionist(fornavn, efternavn, fodselsdato, adresse, postnummer, by, telefonnummer, email);
                break;
            case "Medlem":
                medlem = new Medlem(fornavn, efternavn, fodselsdato, adresse, postnummer, by, telefonnummer, email, isAktiv);
                break;
        }

        if (medlem != null) {
            medlem.setHarBetalt(harBetalt);
        }

        return medlem;
    }
}