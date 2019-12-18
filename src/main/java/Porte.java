public class Porte {
    private int numeroDePorte;

    public Porte(int numeroDePorte) {
        this.numeroDePorte = numeroDePorte;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Porte numéro " + numeroDePorte;
    }

    public int getNumeroDePorte() {
        return numeroDePorte;
    }

    public void setNumeroDePorte(int numeroDePorte) {
        this.numeroDePorte = numeroDePorte;
    }
}
