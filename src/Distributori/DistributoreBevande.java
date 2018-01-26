package Distributori;

import Prodotti.Bevande;
import Prodotti.Prodotto;

import java.util.HashMap;

public class DistributoreBevande extends Distributore {

    private int quantitàCaffé;
    private HashMap<String,Prodotto> bevande = new HashMap<>();

    public DistributoreBevande(double monete) {
        super(monete);
        this.quantitàCaffé = 500;
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        if(!this.controllaProdotto(prodotto)) return;
        bevande.put(prodotto.getCodiceProdotto(), prodotto);
    }

    protected boolean controllaProdotto(Prodotto prodotto) {
        return(prodotto instanceof Bevande);
    }

    private boolean abbastanzaCaffé(String key) {
        return(this.quantitàCaffé > ((Bevande)bevande.get(key)).getCafféNecessario());
    }

    @Override
    public boolean acquistaProdotto(String key, int[] monete) {
        Prodotto b = bevande.get(key);
        if(super.monetePrezzo(monete,b) && abbastanzaCaffé(key)) {
            this.quantitàCaffé -= ((Bevande)bevande.get(key)).getCafféNecessario();
            for (int i=0; i<monete.length; i++) {
                monete[i] += monete[i];
            }
            return true;
        }
        return false;
    }

    @Override
    public void ricaricaProdotto() {
        this.quantitàCaffé = 500;
    }
}
