public class Humain extends Joueur {

    public Humain() {

        super();
    }

    public Humain(String nom,int couleur) {

        super(nom,couleur);
    }

    @Override
    public void jouer(Integer colonne, Joueur joueur, Puissance4 plateau) {
        for(int i=plateau.getNbrelignes()-1;i>=0;i--){
            if(plateau.getGrille()[i][colonne-1]==0){
                plateau.setGrille(i,colonne-1,joueur.getPion());
                break;
            }else{
                continue;
            }
        }
    }

}
