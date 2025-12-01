package Klub;

import java.time.LocalDate;
import java.time.Period;

public class Medlem {
    String navn;
    String adresse;
    LocalDate foedselsdag;
    int telefonNr;
    String medlemsType;
    boolean harBetalt;

    public Medlem(String navn, String adresse, LocalDate foedselsdag, int telefonNr, String medlemsType) {
        this.navn = navn;
        this.adresse = adresse;
        this.foedselsdag = foedselsdag;
        this.telefonNr = telefonNr;
        this.medlemsType = medlemsType;
        this.harBetalt = false;
    }

    public String getNavn() {
        return navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public LocalDate getFoedselsdag() {
        return foedselsdag;
    }

    public int getTelefonNr() {
        return telefonNr;
    }

    public String getMedlemsType() {
        return medlemsType;
    }

    public boolean isHarBetalt() {
        return harBetalt;
    }

    public void setHarBetalt(boolean harBetalt) {
        this.harBetalt = harBetalt;
    }

    public int getAlder() {
        return Period.between(foedselsdag, LocalDate.now()).getYears();
    }

    public double beregnKontingent() {
        if (medlemsType.equalsIgnoreCase("Passiv")) {
            return 500;
        }

        int alder = getAlder();
        if (alder < 18) {
            return 1000;
        }

        double seniorTakst = 1600;
        if (alder >= 60) {
            return seniorTakst * 0.75;
        }
        return seniorTakst;
    }

    public String toString() {
        return navn + " | Alder: " + getAlder() + " - " + medlemsType +
                " - Tlf: " + telefonNr +
                " - Betalt: " + (harBetalt ? "Ja" : "Nej");
    }

}
