import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Tarif {
    private Porte entree;
    private Porte sortie;
    private LocalDateTime dateValidite;
    private BigDecimal prix;

    public Tarif(Porte entree, Porte sortie, BigDecimal prix) {
        this.entree = entree;
        this.sortie = sortie;
        this.prix = prix;
    }

    public Porte getEntree() {
        return entree;
    }

    public Porte getSortie() {
        return sortie;
    }

    public LocalDateTime getDateValidite() {
        return dateValidite;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setEntree(Porte entree) {
        this.entree = entree;
    }

    public void setSortie(Porte sortie) {
        this.sortie = sortie;
    }

    public void setDateValidite(LocalDateTime dateValidite) {
        this.dateValidite = dateValidite;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }
}
