package Prodotti;

public class Bevande extends Prodotto {

    private int cafféNecessario;

    public Bevande(String codiceProdotto, int cafféNecessario, String nomeProdotto, double prezzoProdotto) {
        super(codiceProdotto, nomeProdotto, prezzoProdotto);
        this.cafféNecessario = cafféNecessario;
    }

    public int getCafféNecessario() {
        return cafféNecessario;
    }
}
