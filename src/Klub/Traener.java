package Klub;
import java.util.ArrayList;


public class Traener {
    private String navn;
    private ArrayList<Konkurrencesvoemmer> hold;


    public Traener(String navn){
        this.navn = navn;
        this.hold = new ArrayList<>();
    }

    public String getNavn(){
        return navn;
    }

    public void tilfojeSvommer (Konkurrencesvoemmer svommer){
        hold.add(svommer);
    }

    public ArrayList<Konkurrencesvoemmer>getHold(){
        return hold;

    }

}
