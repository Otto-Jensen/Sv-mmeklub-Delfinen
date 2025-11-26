package Klub;

import java.time.LocalDate;

public class Motionist extends Medlem {
    public Motionist(String navn, String adresse, LocalDate foedselsdag, int telefonNr) {
        super(navn, adresse, foedselsdag, telefonNr, "Motionist");
    }
}