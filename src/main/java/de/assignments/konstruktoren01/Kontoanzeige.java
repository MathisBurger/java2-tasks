package de.assignments.konstruktoren01;

public class Kontoanzeige {

    private final Konto[] konten;

    public Kontoanzeige(Girokonto giro, Tagesgeldkonto tagesgeld) {
        this.konten = new Konto[] {giro, tagesgeld};
    }

    public Konto[] getKonten() {
        return konten;
    }
}
