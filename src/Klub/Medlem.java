package Klub;

import java.time.LocalDate;
import java.time.Period;

public class Medlem {
    private String fornavn;
    private String efternavn;
    private LocalDate fødselsdato;
    private String adresse;
    private String postnummer;
    private String by;
    private String telefonnummer;
    private String email;
    private boolean isAktiv;
    private boolean harBetalt;

    public Medlem(String fornavn, String efternavn, LocalDate fødselsdato, String adresse, String postnummer, String by, String telefonnummer, String email, boolean isAktiv) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.fødselsdato = fødselsdato;
        this.adresse = adresse;
        this.postnummer = postnummer;
        this.by = by;
        this.telefonnummer = telefonnummer;
        this.email = email;
        this.isAktiv = isAktiv;
        this.harBetalt = false;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }
    
    public LocalDate getFødselsdato() {
        return fødselsdato;
    }

    public int getAlder() {
        return Period.between(fødselsdato, LocalDate.now()).getYears();
    }

    public String getAdresse() {
        return adresse;
    }

    public String getPostnummer() {
        return postnummer;
    }

    public String getBy() {
        return by;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAktiv() {
        return isAktiv;
    }

    public boolean harBetalt() {
        return harBetalt;
    }

    public void setHarBetalt(boolean harBetalt) {
        this.harBetalt = harBetalt;
    }

    public double beregnKontingent() {
        if (!isAktiv) {
            return 500;
        } else {
            int alder = getAlder();
            if (alder < 18) {
                return 1000;
            } else if (alder >= 60) {
                return 1600 * 0.75;
            } else {
                return 1600;
            }
        }
    }

    public String toString() {
        return "Navn: " + fornavn + " " + efternavn +
                ", Alder: " + getAlder() +
                ", Adresse: " + adresse + ", " + postnummer + " " + by +
                ", Telefon: " + telefonnummer +
                ", Email: " + email +
                ", Medlemsskab: " + (isAktiv ? "Aktiv" : "Passiv") +
                ", Betalingsstatus: " + (harBetalt ? "Betalt" : "Restance");
    }
}
