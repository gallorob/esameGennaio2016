package Distributori;

import Prodotti.Prodotto;

public abstract class Distributore {

    private final int tipoMonete = 4;

    private double[] valMonete = {0.5, 0.2, 0.1, 0.05};
    protected int[] numMonete;


    protected Distributore(int[] numMonete) {
        this.numMonete = numMonete;
    }

    protected abstract void aggiungiProdotto(Prodotto prodotto);

    public void svuotaDistributore() {
        for(int i=0;i<this.numMonete.length;i++) {
            this.numMonete[i] = 0;
        }
    }

    protected abstract boolean controllaProdotto(Prodotto prodotto);

    protected boolean monetePrezzo(int[] monete, Prodotto prodotto) {
        double importo = 0;
        for(int i=0; i<monete.length; i++) {
            importo += monete[i]*valMonete[i];
        }
        return (importo==prodotto.getPrezzoProdotto());
    }

    protected boolean moneteMonete(int[] monete) {
        int flag = 0;
        for(int i=0; i<monete.length; i++) {
            if(this.numMonete[i] < monete[i]) {
                flag = 1;
                break;
            }
        }
        return (flag==0);
    }

    public abstract boolean acquistaProdotto(String key, int[] monete);

}
