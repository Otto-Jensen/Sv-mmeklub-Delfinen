package Klub;
import java.util.ArrayList;
import java.util.Scanner;

public class Traener {
//    private String navn;
     private MedlemsListe medlemsListe;
     private ArrayList<Medlem>medlemmer;

    private ArrayList<Konkurrencesvoemmer> holdA = new ArrayList<>();
    private ArrayList<Konkurrencesvoemmer> holdB = new ArrayList<>();


    public Traener(MedlemsListe medlemsListe){
        this.medlemsListe = medlemsListe;
        this.medlemmer=medlemsListe.getMedlemmer();
    }

//    public String getNavn(){
//        return navn;
//    }

    public ArrayList<Konkurrencesvoemmer>getHoldA(){
        return holdA;
    }

    public ArrayList<Konkurrencesvoemmer>getHoldB(){
        return holdB;
    }

public void tildelHold(){
        for (Medlem m: medlemmer){
            if (m instanceof Konkurrencesvoemmer){
                Konkurrencesvoemmer k = (Konkurrencesvoemmer) m;
                if(k.getAlder()<=18) {
                    holdB.add(k);
                }else{
                    holdA.add(k);
                    }
                }
            }
        }

public String toStringHoldA(){
StringBuilder sb = new StringBuilder();
sb.append("Hold A:\n");

for (Konkurrencesvoemmer k: holdA){
    sb.append(k.toString()).append("\n");
}
    return sb.toString();
    }

public String toStringHoldB(){
StringBuilder sb=new StringBuilder();
sb.append("Hold B:\n");

for (Konkurrencesvoemmer k: holdB){
    sb.append(k.toString()).append("\n");
}

    return sb.toString();
}



}

