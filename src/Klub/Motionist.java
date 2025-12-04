package Klub;

import java.time.LocalDate;

public class Motionist extends Medlem {

    public Motionist(String fornavn, String efternavn, LocalDate fødselsdato, String adresse, String postnummer, String by, String telefonnummer, String email) {
        super(fornavn, efternavn, fødselsdato, adresse, postnummer, by, telefonnummer, email, true);
    }

    public String toString() {
        return super.toString() + " (Motionist)";
    }
}