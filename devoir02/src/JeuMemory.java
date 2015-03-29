
public class JeuMemory {
    /** 
     * 
     * @param nR : nombre de rangées de cartes
     * @param nC : nombre de colonnes de cartes
     * @param delaiAI : temps d'affichage initial des cartes
     * @param delaiMP : temps de délai lors d'une mauvaise paire
     * @param theme : numéro du thème choisi pour la partie
     */
    public void partie(int nR, int nC, int delaiAI, int delaiMP, int theme)
    {
        Carte[] cards = null;
        GenerateurDeCartesCouleur gdc1;
        GenerateurDeCartesMot gdc2; 
    	
    	// Choix du theme de carte
    	
    	switch (theme) {
	        case 0: gdc1 = new GenerateurDeCartesCouleur();
	        		cards = gdc1.genereCartes(nR*nC);
	        //case 1: gdc2 = new GenerateurDeCartesMot("motProvincesCanada", gdc2.motProvincesCanadaArray);
	        		//cards = gdc2.genereCartes(nR*nC);
	        //case 2: gdc = new GenerateurDeCartesMot("motVillesQuebec", gdc.motVillesQuebecArray);
	        //case 3: gdc = new GenerateurDeCartesImages("imagePokemon", gdc.imagePokemonArray);
	        //case 4: gdc = new GenerateurDeCartesImages("imageDrapeau", gdc.imageDrapeauArray);
	        //case 5: gdc = 
	        default: gdc1 = new GenerateurDeCartesCouleur();
        }
    	
    	
    	
    	
    	PanneauDeCartes p = new PanneauDeCartes();
        p.PanneauDeCartes(nR, nC, cards, delaiAI, delaiMP); // Il manque le tableau de cartes dans les arguments
        
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
            System.out.println("Ex: java JeuMemory 4 2 3000 2000 2");
            System.out.println("Liste des thèmes:");
            System.out.println("0: Couleurs");
            System.out.println("1: Provinces du Canada");
            System.out.println("2: Ville du Québec");
            System.out.println("3: Pokemon");
            System.out.println("4: Drapeau");
            System.out.println("5: Mélange des thèmes 0 à 4");
            System.exit(1);
        }catch (IllegalArgumentException e){
            System.out.println("Paramètres inadéquats");
            System.out.println("Utilisation: java Laby <nRangees> <nColonnes> <delaiAffichageInitial> <delaiAffichageMauvaisePaire> <numeroDeTheme>");
            System.out.println("Ex: java JeuMemory 4 2 3000 2000 2");
            System.out.println("Liste des thèmes:");
            System.out.println("0: Couleurs");
            System.out.println("1: Provinces du Canada");
            System.out.println("2: Ville du Québec");
            System.out.println("3: Pokemon");
            System.out.println("4: Drapeau");
            System.out.println("5: Mélange des thèmes 0 à 4");
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
