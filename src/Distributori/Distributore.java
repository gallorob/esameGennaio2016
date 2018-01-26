package Distributori;

import Prodotti.Prodotto;

public abstract class Distributore {

    private final int tipoMonete = 4;

    private double[] valMonete = {0.5, 0.2, 0.1, 0.05};
    protected double monete;

    protected Distributore(double monete) {
        this.monete = monete;
    }

    protected abstract void aggiungiProdotto(Prodotto prodotto);

    public void svuotaDistributore() {
        this.monete = 0.0;
    }

    public abstract void ricaricaProdotto();

    protected abstract boolean controllaProdotto(Prodotto prodotto);

    protected boolean monetePrezzo(int[] monete, Prodotto prodotto) {
        double importo = 0;
        for(int i=0; i<monete.length; i++) {
            importo += monete[i]*valMonete[i];
        }
        return (importo==prodotto.getPrezzoProdotto());
    }

    public abstract boolean acquistaProdotto(String key, int[] monete);

    public void aggiungiDaFile(String filename) {

    }

}
