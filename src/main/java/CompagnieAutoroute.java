import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Représente une compagnie d'autoroute en France
 */
public class CompagnieAutoroute {
    private List<Route> routes = new ArrayList<Route>();
    private List<Tarif> tarifs = new ArrayList<Tarif>();;

    public CompagnieAutoroute() {}

    /**
     * Retourne le tarif d'un voyage entre une porte d'entrée
     * et une porte de sortie
     * @param p1 : la porte d'entrée
     * @param p2 : la porte de sortie
     * @return le tarif du voyage
     */
    public BigDecimal obtenirTarif(Porte p1, Porte p2) {
        Tarif t = getTarifExacte(p1, p2);
        if(t != null) {
            return t.getPrix();
        } else {
            return getTarifCalcule(p1, p2).getPrix();
        }
    }

    /**
     * Retour le tarif calculé d'un voyage entre deux portes
     * @param p1 : porte d'entrée
     * @param p2 : porte de sortie
     * @return le tarif calculé
     */
    private Tarif getTarifCalcule(Porte p1, Porte p2) {
        Tarif tarif = new Tarif(p1, p2, BigDecimal.valueOf(0));
        for (Route r:
             routes) {
            for (Porte p:
                 r.portes) {
                Tarif t = getTarifExacte(p, p2);
                if( t != null )
                    tarif.setPrix(t.getPrix().add(tarif.getPrix()));
                t = getTarifExacte(p1, p);
                if( t != null )
                    tarif.setPrix(t.getPrix().add(tarif.getPrix()));
            }
        }
        /* Retourne le bon résultat lors du test mais uniquement dans ce cas de test
        for (Tarif t:
             tarifs) {
            BigDecimal prix = t.getPrix();
            tarif.setPrix(tarif.getPrix().add(prix));
        }
        */
        return tarif;
    }

    /**
     * Retourne un tarif existant d'un voyage entre deux portes
     * @param p1 : porte entrée
     * @param p2 : porte sortie
     * @return le tarif
     */
    private Tarif getTarifExacte(Porte p1, Porte p2) {
        Tarif tarif = null;
        for (Tarif t:
             tarifs) {
            if( t.getEntree().equals(p1) && t.getSortie().equals(p2) ) {
                tarif = t;
                break;
            }
        }
        return tarif;
    }

    /**
     * Ajoute un tarif à la liste
     * @param t : le tarif
     */
    public void ajouterTarif(Tarif t) {
        tarifs.add(t);
    }

    /**
     * Ajoute une route à la liste
     * @param r : la route
     */
    public void ajouterRoute(Route r) {
        routes.add(r);
    }
}
