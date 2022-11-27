public class Puissance4 {
    public final static int vide=0;
    public final static int nbreligne=6;
    public final static int nbrecolonne=7;

    private int nbrelignes;
    private int nbrecolonnes;
    private int[][] grille;


    public Puissance4(){
        this.nbrelignes=nbreligne;
        this.nbrecolonnes=nbrecolonne;
        initJeu(this.nbrelignes,this.nbrecolonnes);

    }
    public Puissance4(int nbrelignes, int nbrecolonnes, int[][] grille) {
        this.nbrelignes = nbrelignes;
        this.nbrecolonnes = nbrecolonnes;
        this.grille = grille;
    }


    public int getNbrelignes() {
        return nbrelignes;
    }

    public void setNbrelignes(int nbrelignes) {
        this.nbrelignes = nbrelignes;
    }

    public int getNbrecolonnes() {
        return nbrecolonnes;
    }

    public void setNbrecolonnes(int nbrecolonnes) {
        this.nbrecolonnes = nbrecolonnes;
    }

    public int[][] getGrille() {
        return grille;
    }

    public void setGrille(int i,int j,int pion) {
        this.grille[i][j] =pion;
    }

    private void initJeu(int nbreligne, int nbrecolumn){
        this.grille=new int[nbreligne][nbrecolumn];
        for(int i=0;i<nbreligne;i++){
            for(int j=0;j<nbrecolumn;j++){
                this.grille[i][j]=vide;
            }

        }
    }

    public boolean estplein(){
        int n=0;
        for(int i=0;i<this.nbrelignes;i++){
            for(int j=0;j<this.nbrecolonnes;j++){
                if(this.grille[i][j] !=0){
                    n+=1;
                }
            }
        }
        if(n==this.nbrecolonnes*this.nbrelignes){
            return true;
        }
        return false;
    }


    public boolean gagnevertical(){
        for(int i=this.nbrelignes-1;i>=3;i--){
            for(int j=this.nbrecolonnes-1;j>=0;j--){
                if(this.grille[i][j]!=0){
                    if(
                            this.grille[i][j]==this.grille[i-1][j]
                                    && this.grille[i][j]==this.grille[i-2][j]
                                    && this.grille[i][j]==this.grille[i-3][j]){
                        return true;

                    }
                }

            }
        }
        return false;
    }


    //alignement pour gagner horizontalement
    public boolean gagnehorizontal(){

        for(int i=this.nbrelignes-1;i>=0;i--){
            for(int j=this.nbrecolonnes-1;j>=3;j--){
                if(this.grille[i][j]!=0){
                    if(
                            this.grille[i][j]==this.grille[i][j-1]
                                    && this.grille[i][j]==this.grille[i][j-2]
                                    && this.grille[i][j]==this.grille[i][j-3]){
                        return true;

                    }
                }

            }
        }

        for(int i=this.nbrelignes-1;i>=0;i--){
            for(int j=0;j<4;j++){
                if(this.grille[i][j]!=0){
                    if(
                            this.grille[i][j]==this.grille[i][j+1]
                                    && this.grille[i][j]==this.grille[i][j+2]
                                    && this.grille[i][j]==this.grille[i][j+3]){
                        return true;

                    }
                }

            }
        }
        return false;

    }

    //gagner avec les diagonal
    public boolean gagneOblique(){
        for(int i=this.nbrelignes-1;i>=4;i--){
            for(int j=0;j<=this.nbrecolonnes-4;j++){
                if(this.grille[i][j]!=0){
                    if(this.grille[i][j]==this.grille[i-1][j+1]
                            && this.grille[i][j]==this.grille[i-2][j+2]
                            && this.grille[i][j]==this.grille[i-3][j+3]){

                        return true;
                    }
                }
            }
        }


        for(int i=0;i<3;i++){
            for(int j=this.nbrecolonnes-1;j>=3;j--){
                if(this.grille[i][j]!=0){
                    if(this.grille[i][j]==this.grille[i+1][j-1]
                            && this.grille[i][j]==this.grille[i+2][j-2]
                            && this.grille[i][j]==this.grille[i+3][j-3]){

                        return true;
                    }
                }

            }
        }

        for(int i=0;i<=2;i++){
            for(int j=0;j<=3;j++){
                if(this.grille[i][j]!=0){
                    if(this.grille[i][j]==this.grille[i+1][j+1]

                            && this.grille[i][j]==this.grille[i+2][j+2]
                            && this.grille[i][j]==this.grille[i+3][j+3]){

                        return true;
                    }
                }
            }
        }
        for(int i=this.nbrelignes-1;i>=4;i--){
            for(int j=this.nbrecolonnes-1;j>=3;j--){
                if(this.grille[i][j]!=0){
                    if(this.grille[i][j]==this.grille[i-1][j-1]
                            && this.grille[i][j]==this.grille[i-2][j-2]
                            && this.grille[i][j]==this.grille[i-3][j-3]){

                        return true;
                    }
                }

            }
        }

        return false;
    }

    public boolean gagner(){
        return gagnevertical() || gagnehorizontal()|| gagneOblique();
    }




}
