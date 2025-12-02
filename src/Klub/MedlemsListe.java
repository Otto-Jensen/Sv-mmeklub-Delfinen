package Klub;

import java.time.LocalDate;
import java.util.ArrayList;

public class MedlemsListe {
    private ArrayList<Medlem> medlemmer=new ArrayList<>();

    public void tilfoejMedlem(Medlem x){
        medlemmer.add(x);
    }

    public ArrayList<Medlem> getMedlemmer() {
        return medlemmer;
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
