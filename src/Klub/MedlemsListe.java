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


//    public static void main(String[] args) {
//        MedlemsListe liste=new MedlemsListe();
//        Kassere kassere=new Kassere(liste);
//        Passiv p=new Passiv("Lars", "Dirchsvej 45", LocalDate.of(1990,4,5),12312312);
//        liste.tilfoejMedlem(p);
//        for (Medlem medlem:liste.getMedlemmer()){
//            System.out.println(p.toString());
//        }
//        kassere.printOversigtRestance();
//    }
}
