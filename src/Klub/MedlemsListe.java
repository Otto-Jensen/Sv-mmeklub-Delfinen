package Klub;

import java.util.ArrayList;

public class MedlemsListe {
    private ArrayList<Medlem> medlemmer=new ArrayList<>();

    public void tilfoejMedlem(Medlem x){
        medlemmer.add(x);
    }

    public ArrayList<Medlem> getMedlemmer() {
        return medlemmer;
    }
}
