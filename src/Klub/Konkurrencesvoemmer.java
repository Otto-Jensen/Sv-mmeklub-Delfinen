package Klub;

import java.time.LocalDate;

public class Konkurrencesvoemmer extends Medlem {
    String traeningstid;
    String konkurrencetid;

    public Konkurrencesvoemmer(String navn, String adresse, LocalDate foedselsdag, int telefonNr, String traeningstid, String konkurrencetid) {
        super(navn, adresse, foedselsdag, telefonNr, "KonkurrenceSvømmer");
        this.traeningstid = traeningstid;
        this.konkurrencetid = konkurrencetid;
    }
}
