import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Jeu implements Serializable {
    ArrayList<String> historique=new ArrayList<>();

    private static final long serialVersionUID = 1L;
    int x=0;
    int y=0;
    Scanner sc=new Scanner(System.in);
    Joueur[] tabjoueur;
    public Puissance4 plateau;
    public String nom;

    public Jeu(){
        this.plateau= new Puissance4();
        this.tabjoueur= new Joueur[2];
        debut();
    }
    public Jeu(String nom){
        this.nom=nom;
    }

    public String getNom() {
        return nom;
    }

    public void AttribuCouleur(){
        this.tabjoueur[0].setPion(1);
        this.tabjoueur[1].setPion(2);
    }

    public void HvsH(){
        Joueur j1=new Humain();
        Joueur j2=new Humain();
        System.out.println("Entrer Le nom du joueur 1");
        j1.setNom(sc.next());
        System.out.println("Entrer Le nom du joueur 2");
        j2.setNom(sc.next());
        historique.add("Joueur 1 est Humain:"+j1.getNom()+"\nJoueur 2 est Humain: "+j2.getNom()+"\n");
        this.tabjoueur[0]=j1;
        this.tabjoueur[1]=j2;
        AttribuCouleur();
        run();

    }

    public void HvsC(){
        Joueur j1=new Humain();
        Joueur j2=new Ordinateur();
        System.out.println("Entrer Le nom du joueur ");
        j1.setNom(sc.next());
        System.out.println("Entrer Le nom de l'ordinateur ");
        j2.setNom(sc.next());
        historique.add("Joueur 1 est Humain:"+j1.getNom()+"\nJoueur 2 est Humain: "+j2.getNom()+"\nManche commence");
        this.tabjoueur[0]=j1;
        this.tabjoueur[1]=j2;
        AttribuCouleur();
        run();
    }
    public void CvsC(){
        Joueur j1=new Ordinateur();
        Joueur j2=new Ordinateur();
        historique.add("Joueur 1 est Humain:"+j1.getNom()+"\nJoueur 2 est Humain: "+j2.getNom()+"\nManche commence");
        this.tabjoueur[0]=j1;
        this.tabjoueur[1]=j2;
        AttribuCouleur();
        run();
    }


    public void debut(){
        System.out.println();
        System.out.println();
        System.out.println("BIENVENUE DANS LE JEUX PUISSANCE 4");
        System.out.println("choisir le mode de jeux\n"
                + "1-Joueur vs Joueur\n"
                + "2-Joueur vs computer\n"
                + "3-Computer vs Computer\n" +
                 "4-Quitter");
        switch(sc.next()){
            case "1":
                HvsH();
                break;
            case "2":
                HvsC();
                break;
            case "3":
                CvsC();
                break;
            case "4":
                sortir();
                break;

        }

    }


    public void affichage(){
        for(int i=0;i<this.plateau.getNbrecolonnes();i++){
            System.out.print(" "+(i+1)+"  ");
        }
        System.out.println(" ");
        for(int i=0;i<this.plateau.getNbrelignes();i++){
            for(int j=0;j<this.plateau.getNbrecolonnes();j++){
                switch(this.plateau.getGrille()[i][j]){
                    case 0:
                        System.out.print(" . ");
                        System.out.print("|");
                        break;
                    case 1 :
                        System.out.print(" X ");
                        System.out.print("|");
                        break;
                    case 2:
                        System.out.print(" 0 ");
                        System.out.print("|");
                        break;
                }
            }
            System.out.println(" ");
        }

        for(int i=0;i<10;i++){
            System.out.print(" - ");
        }
    }




    public void scorenull(){
        if(plateau.estplein()){

            affichage();
            System.out.println("\n Score:" + x+"-"+y);
            historique.add("Egalite\n");
            historique.add("\nScore:"+String.valueOf(x)+"-"+String.valueOf(y)+"   ");
            this.plateau=new Puissance4();
            run();
        }
    }

    public int colonnepleine(int col){
        if(valide(col)==false){
            do{
                affichage();
                System.out.println();
                System.out.println("cette valeur n'est pas valide entrer une valeur comprise entre 0 et 7");
                col=Integer.parseInt(sc.next());
                return col;

            }while(valide(col)==false);
        }else if(this.plateau.getGrille()[0][col-1]!=0){
            do{
                affichage();
                System.out.println();
                System.out.println("cette colonne est deja pleine,choisir une autre:");
                col=Integer.parseInt(sc.next());
                return col;

            }while(this.plateau.getGrille()[0][col-1]!=0);
        }else{
            return col;
        }
    }
    public void relancer(){
        if(x==3 ||y==3){
            if (x==3) {
                System.out.println("\n le gagnant est " + tabjoueur[0].getNom());
                x=0;
                y=0;
            }else{
                System.out.println("\n le gagnant est " + tabjoueur[1].getNom());
                x=0;
                y=0;
            }
            System.out.println(
                    "\njouer une nouvelle partie :" +
                    "\n1-oui" +
                    "\n2-non" +
                    "\n3-QUITTER LE JEU");
            switch (sc.next()){
                case "1":
                    this.plateau=new Puissance4();
                    historique.add("Nouvelle partie");
                    run();
                    break;
                case "2":
                    debut();
                    break;
                case "3":
                    sortir();
                    break;


            }

        }
    }
    public boolean valide(int col){
        ArrayList<Integer> colonne=new ArrayList<Integer>();
        for(int i=0;i<= plateau.getNbrecolonnes();i++) {
            colonne.add(i);
        }
        if(colonne.contains(col)){
            return true;
        }
        return false;
    }
    public void joue(int col, Joueur joueur){
        try{
            if(joueur.getClass().getName().equals("Humain")){
                System.out.println("\n Joueur " + joueur.getNom() + " entrer le numero de la colonne\n" +
                        " 0-pour sauvegarder la partie en cour");
                col=Integer.parseInt(sc.next());
                // if(col==0){
                //     enregistrerPartie();
                // }
                col=colonnepleine( col);
                historique.add(joueur.getNom()+" joue "+String.valueOf(col)+"\n");
                System.out.println();
                joueur.jouer(col,joueur,this.plateau);
            }
            else{
                System.out.println();
                historique.add(joueur.getNom()+" joue "+String.valueOf(col)+"\n");
                joueur.jouer(null,joueur,this.plateau);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void gagnerManche(Joueur joueur){
        if(plateau.gagnevertical()==true | plateau.gagnehorizontal()==true | plateau.gagneOblique()==true){
            if(this.tabjoueur[0]==joueur){
                x=x+1;
            }else{
                y=y+1;

            }
            affichage();
            System.out.println("\n Joueur " + joueur.getNom() + " Vous avez gagner");
            System.out.println("\n Score " + x+"-"+y);
            historique.add(" \n"+joueur.getNom() +" gagne\n");
            historique.add("\n Score " + String.valueOf(x)+"-"+String.valueOf(y)+"\n");
            this.plateau=new Puissance4();
            run();
        }
    }

    public void run(){
        try {
            FileWriter histo=new FileWriter("E:\\DownloadHelper\\projetjava\\puissance\\historique.txt",true);
            int col = 0;
            while ((!plateau.gagner()) && x != 3 && y != 3) {
                for (Joueur joueur : this.tabjoueur) {
                    scorenull();
                    affichage();
                    joue(col, joueur);
                    gagnerManche(joueur);

                }
            }
            for (String str: historique) {
                histo.write(str);
            }
            histo.close();
            relancer();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void sortir(){
        System.exit(0);
    }
}
