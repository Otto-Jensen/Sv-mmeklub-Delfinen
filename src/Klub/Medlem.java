package Klub;

import java.time.LocalDate;

public class Medlem {
    String navn;
    String adresse;
    LocalDate foedselsdag;
    int telefonNr;
    String medlemsType;

    public Medlem(String navn, String adresse, LocalDate foedselsdag, int telefonNr, String medlemsType){
        this.navn=navn;
        this.adresse=adresse;
        this.foedselsdag=foedselsdag;
        this.telefonNr=telefonNr;
        this.medlemsType=medlemsType;
    }
}
