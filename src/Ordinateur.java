

import java.util.Random;

public class Ordinateur extends Joueur {

    static int ligne=0;
    static int colonne=0;

    public Ordinateur(){
        super();
    }
    public Ordinateur(String nom,int couleur){

        super(nom,couleur);
    }

    @Override
    public void jouer(Integer colonne, Joueur joueur, Puissance4 plateau) {

        niveauMoyen(joueur,plateau);
    }



    public static void niveauFacile(Joueur joueur, Puissance4 plateau){
        Random random = new Random();
        int n;
        n = random.nextInt(7);
        for(int i=plateau.nbreligne-1;i>=0;i--){
            if(plateau.getGrille()[i][n]==0){
                plateau.setGrille(i,n,joueur.getPion());
                break;
            }else{
                continue;
            }
        }
    }
    public static boolean condition1( Puissance4 plateau){
        for(int i= plateau.getNbrelignes()-1;i>=3;i--) {
            for (int j = plateau.getNbrecolonnes() - 1; j >= 0; j--) {
                if (plateau.getGrille()[i][j] != 0) {
                    if (
                            plateau.getGrille()[i][j] == plateau.getGrille()[i - 1][j]
                                    && plateau.getGrille()[i][j] == plateau.getGrille()[i - 2][j]
                                    && 0 == plateau.getGrille()[i - 3][j]) {
                        ligne=i-3;
                        colonne=j;
                        return true;
                    }
                }

            }
        }
        return false;
    }
    public static boolean condition2( Puissance4 plateau){
        for(int i= plateau.getNbrelignes()-1;i>=0;i--){
            for(int j= plateau.getNbrecolonnes()-1;j>=3;j--){
                if(plateau.getGrille()[i][j]!=0){
                    if(
                            plateau.getGrille()[i][j]==plateau.getGrille()[i][j-1]
                                    && plateau.getGrille()[i][j]==plateau.getGrille()[i][j-2]
                                    && 0==plateau.getGrille()[i][j-3]){
                        ligne=i;
                        colonne=j-3;
                        return true;
                    }
                }

            }
        }
        return false;
    }
    public static boolean condition3(Puissance4 plateau){

        for(int i= plateau.getNbrelignes()-1;i>=0;i--){
            for(int j=0;j<4;j++){
                if(plateau.getGrille()[i][j]!=0){
                    if(
                            plateau.getGrille()[i][j]==plateau.getGrille()[i][j+1]
                                    && plateau.getGrille()[i][j]==plateau.getGrille()[i][j+2]
                                    && 0==plateau.getGrille()[i][j+3]){
                        ligne=i;
                        colonne=j+3;
                        return true;

                    }
                }

            }
        }
        return false;
    }
    public static boolean condition4(Puissance4 plateau){
        for(int i= plateau.getNbrelignes()-1;i>=4;i--){
            for(int j=0;j<= plateau.getNbrecolonnes()-4;j++){
                if(plateau.getGrille()[i][j]!=0){
                    if(plateau.getGrille()[i][j]==plateau.getGrille()[i-1][j+1]
                            && plateau.getGrille()[i][j]==plateau.getGrille()[i-2][j+2]
                            && 0==plateau.getGrille()[i-3][j+3]){

                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean condition5(Puissance4 plateau){
        for(int i=0;i<3;i++){
            for(int j= plateau.getNbrecolonnes()-1;j>=3;j--){
                if(plateau.getGrille()[i][j]!=0){
                    if(plateau.getGrille()[i][j]==plateau.getGrille()[i+1][j-1]
                            && plateau.getGrille()[i][j]==plateau.getGrille()[i+2][j-2]
                            && 0==plateau.getGrille()[i+3][j-3]){
                        return true;
                    }
                }

            }
        }
        return false;
    }
    public static boolean condition6(Puissance4 plateau){
        for(int i=0;i<=2;i++){
            for(int j=0;j<=3;j++){
                if(plateau.getGrille()[i][j]!=0){
                    if(plateau.getGrille()[i][j]==plateau.getGrille()[i+1][j+1]

                            && plateau.getGrille()[i][j]==plateau.getGrille()[i+2][j+2]
                            && 0==plateau.getGrille()[i+3][j+3]){

                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean condition7(Puissance4 plateau){
        for(int i= plateau.getNbrelignes()-1;i>=4;i--){
            for(int j= plateau.getNbrecolonnes()-1;j>=3;j--){
                if(plateau.getGrille()[i][j]!=0){
                    if(plateau.getGrille()[i][j]==plateau.getGrille()[i-1][j-1]
                            && plateau.getGrille()[i][j]==plateau.getGrille()[i-2][j-2]
                            && plateau.getGrille()[i][j]==plateau.getGrille()[i-3][j-3]){

                        return true;
                    }
                }

            }
        }
        return false;
    }



    public static void niveauMoyen(Joueur joueur, Puissance4 plateau){

        if(condition1(plateau)){
            plateau.setGrille(ligne, colonne, joueur.getPion());
        }else if(condition2(plateau)){
            plateau.setGrille(ligne,colonne,joueur.getPion());
        } else if(condition3(plateau)){
            plateau.setGrille(ligne,colonne,joueur.getPion());
        } else if(condition4(plateau)){
            plateau.setGrille(ligne,colonne,joueur.getPion());
        }else if(condition5(plateau)){
            plateau.setGrille(ligne,colonne,joueur.getPion());
        } else if(condition6(plateau)){
            plateau.setGrille(ligne,colonne,joueur.getPion());
        } else if(condition7(plateau)){
            plateau.setGrille(ligne,colonne,joueur.getPion());
        }else{
            niveauFacile(joueur, plateau);
        }




    }

}
