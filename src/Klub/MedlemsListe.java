package Klub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MedlemsListe {
    Scanner input = new Scanner(System.in);
    private ArrayList<Medlem> medlemmer=new ArrayList<>();

    public void tilfoejMedlem(Medlem x){
        medlemmer.add(x);
    }

    public ArrayList<Medlem> getMedlemmer() {
        return medlemmer;
    }

  public void opretMedlem(){
      System.out.println("Indstast kundens navn");
      String name =input.nextLine();

      System.out.println("Indtast fødselsdato (YYYY-MM-DD");
      String fd = input.nextLine();
      LocalDate foedselsdag=LocalDate.parse(fd);

      System.out.println("Indtast vejnavn");
      String vejnavn = input.nextLine();
      System.out.println("Indtast hus nummer");
      int husNr=input.nextInt();
      input.nextLine();//noget med at enter tæller som en \n, som bliver læst næste gang.
      String adresse=vejnavn+String.valueOf(husNr);

      System.out.println("Indtast telefon nummer");
      int telefonNr=input.nextInt();
      input.nextLine();

      System.out.println("Indtast medlemstype");
      String medlemstype=input.nextLine().toLowerCase();


      Medlem medlem;

      switch(medlemstype){
          case "passiv":
              medlem = new Passiv(name,adresse,foedselsdag,telefonNr);
              break;
          case "motionist":
              medlem=new Motionist(name,adresse,foedselsdag,telefonNr);
              break;
          case "konkurrencesvømmer":
              medlem=new Konkurrencesvoemmer(name,adresse,foedselsdag,telefonNr);
              break;
          default:
              boolean Betalt=false;
              System.out.println("Ukendt medlemtype - oprettes som standard medlem");
              medlem = new Medlem(name,adresse,foedselsdag,telefonNr,medlemstype);
      }
      tilfoejMedlem(medlem);
      System.out.println(medlem+" Er oprettet som medlem");
  }


    public void indberetTraeningstid(){
        Scanner input= new Scanner(System.in);
        System.out.println("Indtast svømmers navn");
        String navn= input.nextLine();
        for (Medlem m:medlemmer){
            if(m instanceof Konkurrencesvoemmer k && m.getNavn().equalsIgnoreCase(navn)){
                System.out.println("Indtast diciplin");
                String diciplin=input.nextLine();
                System.out.println("Indtast træningstid (minutter)");
                int tid= input.nextInt();
                k.setTraeningstid(new Traeningstid(diciplin, tid));
                return;

            }
        }
        System.out.println("Svømmer ikke fundet.");
    }
}
