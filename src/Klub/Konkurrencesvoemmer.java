package Klub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Konkurrencesvoemmer extends Medlem {
    Traeningstid traeningstid;


    public Konkurrencesvoemmer(String navn, String adresse, LocalDate foedselsdag, int telefonNr, Traeningstid traeningstid) {
        super(navn, adresse, foedselsdag, telefonNr, "KonkurrenceSvømmer");
        this.traeningstid = traeningstid;

    }

    public Konkurrencesvoemmer(String navn, String adresse, LocalDate foedselsdag, int telefonNr){
        super(navn, adresse, foedselsdag, telefonNr, "KonkurrenceSvømmer");
    }

    public void setTraeningstid(Traeningstid traeningstid){
        this.traeningstid=traeningstid;
    }

    public Traeningstid getTraeningstid(){
        return traeningstid;
    }


//    public void indberetTraeningstid(){
//        Scanner input= new Scanner(System.in);
//        System.out.println("Indtast svømmers navn");
//        String navn= input.nextLine();
//        for (Medlem m:medlemmer){
//            if(m instanceof Konkurrencesvoemmer k && m.getNavn().equalsIgnoreCase(navn)){
//                System.out.println("Indtast diciplin");
//               String diciplin=input.nextLine();
//               System.out.println("Indtast træningstid (minutter)");
//               int tid= input.nextInt();
//               k.setTraeningstid(new Traeningstid(diciplin, tid));
//               return;
//
//            }
//        }
//        System.out.println("Svømmer ikke fundet.");
//    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Navn: ").append(getNavn()).append("\n");
        sb.append("Adresse: ").append(getAdresse()).append("\n");
        sb.append("Telefon: ").append(getTelefonNr()).append("\n");
        sb.append("MedlemsType: ").append(getMedlemsType()).append("\n");

        if (traeningstid != null) {
            sb.append("Disciplin: ").append(traeningstid.getDiciplin()).append("\n");
            sb.append("Træningstid: ").append(traeningstid.getTid()).append(" min\n");
        }
        return sb.toString();
    }
}

enum Diciplin{
    CRAWL,FREESTYLE, BRYST, BUTTERFLY;

    public static Diciplin fromString(String input){
        for (Diciplin d:Diciplin.values()){
            if (d.name().equalsIgnoreCase(input)){
                return d;
            }
        }
        System.out.println("Ugyldig diciplin");
        return null;
    }
}
class Traeningstid{
    private Diciplin diciplin;
    private int tid;

    public Traeningstid(Diciplin diciplin, int tid){
        this.diciplin=diciplin;
        this.tid=tid;
    }

    public Diciplin getDiciplin(){
        return diciplin;
    }
    public int getTid(){
        return tid;
    }

    public void setTraeningstid(Diciplin diciplin, int tid){
        this.diciplin=diciplin;
        this.tid=tid;
        System.out.println("Træningstiden for "+diciplin+" er sat til "+tid+ "minutter");
    }

}
