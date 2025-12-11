package Klub;
import java.util.ArrayList;
import java.util.Scanner;

public class Traener {
     private MedlemsListe medlemsListe;

    private ArrayList<Medlem> senior = new ArrayList<>();
    private ArrayList<Medlem> ung = new ArrayList<>();


    public Traener(MedlemsListe medlemsListe){
        this.medlemsListe = medlemsListe;
    }


    public ArrayList<Medlem>getSenior(){
        return senior;
    }

    public ArrayList<Medlem>getUng(){
        return ung;
    }

public void tildelHold(){//ændret fra m:medlemmer
        for (Medlem m: medlemsListe.getMedlemmer()){
            if (m instanceof Konkurrencesvoemmer){
                Konkurrencesvoemmer k = (Konkurrencesvoemmer) m;
                if(k.getAlder()<=18) {
                    ung.add(k);
                }else{
                    senior.add(k);
                    }
                }
            }
        }

public String toStringSenior(){
StringBuilder sb = new StringBuilder();
sb.append("Hold A:\n");

for (Medlem m: senior){
    sb.append(m.toString()).append("\n");
}
    return sb.toString();
    }

public String toStringUng(){
StringBuilder sb=new StringBuilder();
sb.append("Hold B:\n");

for (Medlem m: ung){
    sb.append(m.toString()).append("\n");
}

    return sb.toString();
}



}

