public abstract class Joueur {
    protected String nom;
    protected int pion;

    public Joueur(){
        this.nom=null;
        this.pion =0;
    }
    public Joueur(String nom,int couleur){
        this.nom=nom;
        this.pion =couleur;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPion() {
        return pion;
    }

    public void setPion(int pion) {
        this.pion = pion;
    }

    public  abstract void jouer(Integer i, Joueur joueur, Puissance4 plateau);

}

