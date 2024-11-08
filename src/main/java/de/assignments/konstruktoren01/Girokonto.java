package de.assignments.konstruktoren01;

public class Girokonto extends Konto {

    private boolean ueberziehbar;
    private double dispokredit;

    public Girokonto(double kontostand, boolean ueberziehbar) {
        super(kontostand);
        this.ueberziehbar = ueberziehbar;
        this.dispokredit = 0;
    }

    public Girokonto(double kontostand, double dispokredit) {
        super(kontostand);
        this.ueberziehbar = true;
        this.dispokredit = dispokredit;
    }

    public Girokonto() {
        super();
        this.dispokredit = 0;
        this.ueberziehbar = false;
    }

    public boolean isUeberziehbar() {
        return ueberziehbar;
    }

    public double getDispokredit() {
        return dispokredit;
    }
}
