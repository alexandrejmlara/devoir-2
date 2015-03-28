
public class JeuMemory {
    /** 
     * 
     * @param nR : nombre de rangées de cartes
     * @param nC : nombre de colonnes de cartes
     * @param delaiAI : temps d'affichage initial des cartes
     * @param delaiMP : temps de délai lors d'une mauvaise paire
     * @param theme : numéro du thÃ¨me choisi pour la partie
     */
    public void partie(int nR, int nC, int delaiAI, int delaiMP, int theme)
    {
        
    	
    	// Choix du theme de carte
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
     * @param args : va contenir les valeurs nécéssaire pour la création et le déroulement du jeu
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
            System.out.println("Nombre de paramètres insuffisants");
            System.out.println("Utilisation: java Laby <nRangees> <nColonnes> <delaiAffichageInitial> <delaiAffichageMauvaisePaire> <numeroDeTheme>");
            System.out.println("Ex: java JeuMemory 4 2 3 2 2 1");
            System.exit(1);
        }catch (IllegalArgumentException e){
            System.out.println("Paramètres inadéquats");
            System.out.println("Utilisation: java Laby <nRangees> <nColonnes> <delaiAffichageInitial> <delaiAffichageMauvaisePaire> <numeroDeTheme>");
            System.out.println("Ex: java JeuMemory 4 2 3 2 2 1");
            System.exit(1);
        }
        
        // Condition pour s'assurer d'un nombre paire de cartes
        if((nRangees*nColonnes)%2 != 0){
        	System.out.println("Le nombre de cases doit donner un nombre pair! Ex: 2 x 4");
        	System.exit(0);
        }
        // Appel de la méthode partie pour créer la partie et la gérer
        jeu.partie(nRangees, nColonnes, delaiAffichageInitial, delaiAffichageMauvaisePaire, numeroDeTheme);

    }
}
