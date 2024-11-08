package de.assignments.konstruktoren01;

public abstract class Konto {

    protected double kontostand;

    public Konto(double kontostand) {
        this.kontostand = kontostand;
    }

    public Konto() {
        this.kontostand = 0;
    }

    public double getKontostand() {
        return kontostand;
    }
}
