package Klub;

import java.time.LocalDate;

public class Passiv extends Medlem {
        public Passiv(String navn, String adresse, LocalDate foedselsdag, int telefonNr){
            super(navn,adresse,foedselsdag,telefonNr,"Passiv");
        }
}
