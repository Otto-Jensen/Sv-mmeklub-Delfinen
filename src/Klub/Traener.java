package Klub;
import java.util.ArrayList;
import java.util.Scanner;

public class Traener {
     private MedlemsListe medlemsListe;

    private ArrayList<Medlem> holdA = new ArrayList<>();
    private ArrayList<Medlem> holdB = new ArrayList<>();


    public Traener(MedlemsListe medlemsListe){
        this.medlemsListe = medlemsListe;
    }


    public ArrayList<Medlem>getHoldA(){
        return holdA;
    }

    public ArrayList<Medlem>getHoldB(){
        return holdB;
    }

public void tildelHold(){//ændret fra m:medlemmer
        for (Medlem m: medlemsListe.getMedlemmer()){
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

for (Medlem m: holdA){
    sb.append(m.toString()).append("\n");
}
    return sb.toString();
    }

public String toStringHoldB(){
StringBuilder sb=new StringBuilder();
sb.append("Hold B:\n");

for (Medlem m: holdB){
    sb.append(m.toString()).append("\n");
}

    return sb.toString();
}



}

