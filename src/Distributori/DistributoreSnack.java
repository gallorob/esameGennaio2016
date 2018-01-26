package Distributori;

import Prodotti.Prodotto;
import Prodotti.Snack;

import java.util.HashMap;

public class DistributoreSnack extends Distributore {

    private HashMap<String,Prodotto> snacks = new HashMap<>();
    private HashMap<String,Integer> cassetti = new HashMap<>();

    public DistributoreSnack(double monete) {
        super(monete);
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        if(!this.controllaProdotto(prodotto)) return;
        snacks.put(prodotto.getCodiceProdotto(), prodotto);
        cassetti.put(prodotto.getCodiceProdotto(),20);
    }

    protected boolean controllaProdotto(Prodotto prodotto) {
        return(prodotto instanceof Snack);
    }

    @Override
    public boolean acquistaProdotto(String key, int[] monete) {
        Prodotto p = snacks.get(key);
        if(super.monetePrezzo(monete,p)) {
            cassetti.put(key, cassetti.get(key)-1);
            for (int i=0; i<monete.length; i++) {
                super.monete += monete[i];
            }
            return true;
        }
        return false;
    }

    @Override
    public void ricaricaProdotto() {
        for(String k :cassetti.keySet()) {
            cassetti.put(k, 20);
        }
    }
}
