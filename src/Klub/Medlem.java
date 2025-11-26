package Klub;

import java.time.LocalDate;

public class Medlem {
    String navn;
    String adresse;
    LocalDate foedselsdag;
    int telefonNr;
    String medlemsType;

    public  Medlem(String navn, String adresse, LocalDate foedselsdag, int telefonNr, String medlemsType){
        this.navn=navn;
        this.adresse=adresse;
        this.foedselsdag=foedselsdag;
        this.telefonNr=telefonNr;
        this.medlemsType=medlemsType;
    }
}

class Passiv extends Medlem{
   public Passiv(String navn, String adresse, LocalDate foedselsdag, int telefonNr){
    super(navn,adresse,foedselsdag,telefonNr,"Klub.Passiv");
}
}

class Motionist extends Medlem{
    public Motionist (String navn, String adresse, LocalDate foedselsdag, int telefonNr){
        super(navn, adresse, foedselsdag,telefonNr,"Klub.Motionist");
    }
}

class KonkurrenceSvoemmer extends Medlem{
    String traeningstid;
    String konkurrencetid;
    public KonkurrenceSvoemmer (String navn,String adresse, LocalDate foedselsdag, int telefonNr, String traeningstid, String konkurrencetid){
        super(navn,adresse, foedselsdag,telefonNr,"KonkurrenceSvømmer");
        this.traeningstid=traeningstid;
        this.konkurrencetid=konkurrencetid;
    }
}
