package Klub;

import java.time.LocalDate;

public class Konkurrencesvoemmer extends Medlem {
    int traeningstid;
    int konkurrencetid;

    public Konkurrencesvoemmer(String navn, String adresse, LocalDate foedselsdag, int telefonNr, int traeningstid, int konkurrencetid) {
        super(navn, adresse, foedselsdag, telefonNr, "KonkurrenceSvømmer");
        this.traeningstid = traeningstid;
        this.konkurrencetid = konkurrencetid;



    }

    public Konkurrencesvoemmer(String navn, String adresse, LocalDate foedselsdag, int telefonNr){
        super(navn, adresse, foedselsdag, telefonNr, "KonkurrenceSvømmer");
    }
}
