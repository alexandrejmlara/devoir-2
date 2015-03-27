
public class JeuMemory {
	 /**
	 * coup : compteur pour le nombre de coups effectu� par le joueur
	 */
    private int coup = 0;
    public void setCoup(int c){coup += c;} // Permet d'incrémenter du nombre voulu
    public int getCoup(){return coup;} // Retourne le nombre de coups
    
    
    
    /** 
     * 
     * @param nR : nombre de rang�es de cartes
     * @param nC : nombre de colonnes de cartes
     * @param delaiAI : temps d'affichage initial des cartes
     * @param delaiMP : temps de d�lai lors d'une mauvaise paire
     * @param theme : num�ro du thème choisi pour la partie
     */
    public void partie(int nR, int nC, int delaiAI, int delaiMP, int theme)
    {
        
    	
    	// Choix du theme
    	/*
    	Carte carte;
    	switch (theme) {
	        case 0: carte = new CarteCouleur();
	        case 1: carte = new Carte.CarteMot();
	        case 2: carte = new Carte.CarteImage(); 	
        }
        */
    	
    	PanneauDeCartes p = new PanneauDeCartes();
        p.PanneauDeCartes(nR, nC, delaiAI, delaiMP); // Il manque le tableau de cartes dans les arguments
        
    }
    
    /**
     * 
     * @param args : va contenir les valeurs n�c�ssaire pour la cr�ation et le d�roulement du jeu
     */
    public static void main(String[] args)
    {
        JeuMemory jeu = new JeuMemory();

        int nRangees = 0;
        int nColonnes = 0;
        int delaiAffichageInitial = 0;
        int delaiAffichageMauvaisePaire = 0;
        int numeroDeTheme = 0;
         
        try{
            nRangees = Integer.parseInt(args[0]);
            nColonnes = Integer.parseInt(args[1]);
            delaiAffichageInitial = Integer.parseInt(args[2]);
            delaiAffichageMauvaisePaire = Integer.parseInt(args[3]);
            numeroDeTheme = Integer.parseInt(args[4]);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Nombre de param�tres insuffisants");
            System.out.println("Utilisation: java Laby <nRangees> <nColonnes> <delaiAffichageInitial> <delaiAffichageMauvaisePaire> <numeroDeTheme>");
            System.out.println("Ex: java JeuMemory 4 2 3 2 2 1");
            System.exit(1);
        }catch (IllegalArgumentException e){
            System.out.println("Param�tres inad�quats");
            System.out.println("Utilisation: java Laby <nRangees> <nColonnes> <delaiAffichageInitial> <delaiAffichageMauvaisePaire> <numeroDeTheme>");
            System.out.println("Ex: java JeuMemory 4 2 3 2 2 1");
            System.exit(1);
        }
        
        // Condition pour s'assurer d'un nombre paire de cartes
        if((nRangees*nColonnes)%2 != 0){
        	System.out.println("Le nombre de cases doit donner un nombre pair! Ex: 2 x 4");
        	System.exit(0);
        }
        // Appel de la m�thode partie pour cr�er la partie et la g�rer
        jeu.partie(nRangees, nColonnes, delaiAffichageInitial, delaiAffichageMauvaisePaire, numeroDeTheme);

    }
}
