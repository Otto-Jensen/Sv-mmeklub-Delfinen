package Klub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Konkurrencesvoemmer extends Medlem {
    private MedlemsListe medlemsListe;
    private ArrayList<Medlem> medlemmer;
//    static String[]dicipliner={"Bryst","Ryg","Butterfly","Freestyle"};
    Traeningstid traeningstid;
    int konkurrencetid;

    public Konkurrencesvoemmer(String navn, String adresse, LocalDate foedselsdag, int telefonNr, Traeningstid traeningstid, int konkurrencetid) {
        super(navn, adresse, foedselsdag, telefonNr, "KonkurrenceSvømmer");
        this.traeningstid = traeningstid;
        this.konkurrencetid = konkurrencetid;

    }

    public Konkurrencesvoemmer(String navn, String adresse, LocalDate foedselsdag, int telefonNr){
        super(navn, adresse, foedselsdag, telefonNr, "KonkurrenceSvømmer");
    }

    public void setTraeningstid(Traeningstid traeningstid){
        this.traeningstid=traeningstid;
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
        sb.append("Konkurrencetid: ").append(konkurrencetid).append("\n");
        return sb.toString();
    }
}
class Traeningstid{
    private String diciplin;
    private int tid;

    public Traeningstid(String diciplin, int tid){
        this.diciplin=diciplin;
        this.tid=tid;
    }

    public String getDiciplin(){
        return diciplin;
    }
    public int getTid(){
        return tid;
    }

    public void setTraeningstid(String diciplin, int tid){
        this.diciplin=diciplin;
        this.tid=tid;
        System.out.println("Træningstiden for "+diciplin+" er sat til "+tid+ "minutter");
    }

}
