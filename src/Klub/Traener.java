package Klub;

public class Traener {
    private String fornavn;
    private String efternavn;

    public Traener(String fornavn, String efternavn) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public String toString() {
        return "Træner: " + fornavn + " " + efternavn;
    }
}
