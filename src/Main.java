import Distributori.DistributoreBevande;
import Distributori.DistributoreSnack;
import Prodotti.Bevande;
import Prodotti.Snack;

public class Main {

    public static void main(String[] args) {
        int[] numMonetePieno = {10,10,10,10};
        DistributoreSnack dsnack = new DistributoreSnack(numMonetePieno);
        DistributoreBevande dbev = new DistributoreBevande(numMonetePieno);

        Snack p1 = new Snack("PATA1","rustica san carlo",0.4);
        Bevande b1 = new Bevande("LON",20, "caffe lungo",0.45);

        dsnack.aggiungiProdotto(p1);
        dbev.aggiungiProdotto(b1);

        int[] monete = {0,2,0,0};

        System.out.println(dsnack.acquistaProdotto("PATA1", monete));

        int[] monete2 = {0,2,0,1};

        System.out.println(dbev.acquistaProdotto("LON", monete));

    }

}
