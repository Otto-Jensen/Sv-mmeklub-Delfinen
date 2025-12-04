package Klub;

import java.util.ArrayList;
import java.util.List;

public class MedlemsListe {
    private List<Medlem> medlemmer;

    public MedlemsListe() {
        this.medlemmer = new ArrayList<>();
    }

    public void tilfoejMedlem(Medlem medlem) {
        medlemmer.add(medlem);
    }

    public List<Medlem> getMedlemmer() {
        return medlemmer;
    }

    public void visMedlemmer() {
        if (medlemmer.isEmpty()) {
            System.out.println("Der er ingen medlemmer i klubben endnu.");
        } else {
            for (Medlem medlem : medlemmer) {
                System.out.println(medlem);
            }
        }
    }
}