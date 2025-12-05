package Klub;

import java.util.ArrayList;

public class konkurrencesvommertraeningstid {

    private ArrayList<Konkurrencesvoemmer> konkurrencesvommer;

    public konkurrencesvommertraeningstid(){

        konkurrencesvommer = new ArrayList<>();
    }

    public void addKonkurrencesvommer (Konkurrencesvoemmer konkurrencesvoemmer){
        konkurrencesvommer.add(konkurrencesvoemmer);
    }
}
