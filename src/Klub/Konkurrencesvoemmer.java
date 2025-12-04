package Klub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Konkurrencesvoemmer extends Medlem {

    private Traener traener;
    private List<String> discipliner;
    private Map<String, List<TraeningsResultat>> traeningsResultater;
    private List<KonkurrenceResultat> konkurrenceResultater;

    public Konkurrencesvoemmer(String fornavn, String efternavn, LocalDate fødselsdato, String adresse, String postnummer, String by, String telefonnummer, String email, Traener traener) {
        super(fornavn, efternavn, fødselsdato, adresse, postnummer, by, telefonnummer, email, true);
        this.traener = traener;
        this.discipliner = new ArrayList<>();
        this.traeningsResultater = new HashMap<>();
        this.konkurrenceResultater = new ArrayList<>();
    }

    public Traener getTraener() {
        return traener;
    }

    public void tilfoejDisciplin(String disciplin) {
        discipliner.add(disciplin);
    }

    public List<String> getDiscipliner() {
        return discipliner;
    }

    public void registrerTraeningsResultat(String disciplin, LocalDate dato, double tid) {
        if (!discipliner.contains(disciplin)) {
            discipliner.add(disciplin);
        }
        traeningsResultater.computeIfAbsent(disciplin, k -> new ArrayList<>()).add(new TraeningsResultat(dato, tid));
    }

    public Map<String, List<TraeningsResultat>> getTraeningsResultater() {
        return traeningsResultater;
    }

    public void registrerKonkurrenceResultat(String staevne, String disciplin, int placering, double tid) {
        konkurrenceResultater.add(new KonkurrenceResultat(staevne, disciplin, placering, tid));
    }

    public List<KonkurrenceResultat> getKonkurrenceResultater() {
        return konkurrenceResultater;
    }
    
    public double getBedsteTid(String disciplin) {
        Optional<TraeningsResultat> bedsteTid = traeningsResultater.getOrDefault(disciplin, new ArrayList<>())
                .stream()
                .min(Comparator.comparingDouble(TraeningsResultat::getTid));
        return bedsteTid.map(TraeningsResultat::getTid).orElse(Double.MAX_VALUE);
    }


    @Override
    public String toString() {
        return super.toString() + " (Konkurrencesvømmer)";
    }
}

class TraeningsResultat {
    private LocalDate dato;
    private double tid;

    public TraeningsResultat(LocalDate dato, double tid) {
        this.dato = dato;
        this.tid = tid;
    }

    public LocalDate getDato() {
        return dato;
    }

    public double getTid() {
        return tid;
    }
}

class KonkurrenceResultat {
    private String staevne;
    private String disciplin;
    private int placering;
    private double tid;

    public KonkurrenceResultat(String staevne, String disciplin, int placering, double tid) {
        this.staevne = staevne;
        this.disciplin = disciplin;
        this.placering = placering;
        this.tid = tid;
    }

    public String getStaevne() {
        return staevne;
    }

    public String getDisciplin() {
        return disciplin;
    }

    public int getPlacering() {
        return placering;
    }

    public double getTid() {
        return tid;
    }
}