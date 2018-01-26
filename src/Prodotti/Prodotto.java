package Prodotti;

public abstract class Prodotto {

    private String codiceProdotto;
    private String nomeProdotto;
    private double prezzoProdotto;

    public Prodotto(String codiceProdotto, String nomeProdotto, double prezzoProdotto) {
        this.codiceProdotto = codiceProdotto;
        this.nomeProdotto = nomeProdotto;
        this.prezzoProdotto = prezzoProdotto;
    }

    public String getCodiceProdotto() {
        return codiceProdotto;
    }

    public double getPrezzoProdotto() {
        return prezzoProdotto;
    }
}
