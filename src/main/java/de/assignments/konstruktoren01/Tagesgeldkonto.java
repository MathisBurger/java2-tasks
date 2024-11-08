package de.assignments.konstruktoren01;

public class Tagesgeldkonto extends Konto {

    private double zinssatz;

    public Tagesgeldkonto(double zinssatz) {
        super();
        this.zinssatz = zinssatz;
    }

    public Tagesgeldkonto() {
        super();
        this.zinssatz = 0;
    }

    public Tagesgeldkonto(double kontostand, double zinssatz) {
        super(kontostand);
        this.zinssatz = zinssatz;
    }

    public double getZinssatz() {
        return zinssatz;
    }
}
