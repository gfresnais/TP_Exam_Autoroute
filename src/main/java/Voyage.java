import java.math.BigDecimal;

public class Voyage {
    private Porte entree;
    private Porte sortie;
    private CompagnieAutoroute autoroute;

    public Voyage(Porte entree, Porte sortie, CompagnieAutoroute autoroute) {
        this.entree = entree;
        this.sortie = sortie;
        this.autoroute = autoroute;
    }

    public Porte getEntree() {
        return entree;
    }

    public Porte getSortie() {
        return sortie;
    }

    public CompagnieAutoroute getAutoroute() {
        return autoroute;
    }

    public void setEntree(Porte entree) {
        this.entree = entree;
    }

    public void setSortie(Porte sortie) {
        this.sortie = sortie;
    }

    public void setAutoroute(CompagnieAutoroute autoroute) {
        this.autoroute = autoroute;
    }

    public BigDecimal getTarif() {
        return autoroute.obtenirTarif(entree, sortie);
    }
}
