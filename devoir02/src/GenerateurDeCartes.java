
public abstract class GenerateurDeCartes {
	/**
	 * Une propriété nom comportant le nom du thème
	 * thèmes possibles: couleur, motProvincesCanada, motVillesQuebec, imagePokemon, imageDrapeau,multiple. 
	 */
	private String nom;
	
	/**
	 * Tableaux des Strings avec les noms des mots et les localizations relatives des themes.
	 */
	String[] motProvincesCanadaArray= {"Alberta","Colombie-Britannique", "Ile-du-Prince-Edouard","Manitoba",
			"Nouveau-Brunswick","Nouvelle-Ecosse","Ontario","Quebec","Saskatchewan","Terre-Neuve-et-Labrador",
			"Nunavut","Territoires du Nord-Ouest","Yukon"};
	String[]motVillesQuebecArray={"Quebec","Montreal","Laval","Gatineau","Longueuil","Serbrooke","Saguenay",
			"Trois-Rivieres","Terrebonne","Rimouski"};
	String[]imagePokemonArray={"devoir02/resources/Pokemon/pokemon1.jpg","devoir02/resources/Pokemon/pokemon2.jpg",
			"devoir02/resources/Pokemon/pokemon3.jpg","devoir02/resources/Pokemon/pokemon4.jpg","devoir02/resources/Pokemon/pokemon5.jpg",
			"devoir02/resources/Pokemon/pokemon6.jpg","devoir02/resources/Pokemon/pokemon7.jpg","devoir02/resources/Pokemon/pokemon8.jpg",
			"devoir02/resources/Pokemon/pokemon9.jpg","devoir02/resources/Pokemon/pokemon10.jpg","devoir02/resources/Pokemon/pokemon11.jpg",
			"devoir02/resources/Pokemon/pokemon12.jpg","devoir02/resources/Pokemon/pokemon13.jpg","devoir02/resources/Pokemon/pokemon14.jpg",
			"devoir02/resources/Pokemon/pokemon15.jpg","devoir02/resources/Pokemon/pokemon16.jpg","devoir02/resources/Pokemon/pokemon17.jpg",
			"devoir02/resources/Pokemon/pokemon18.jpg","devoir02/resources/Pokemon/pokemon19.jpg","devoir02/resources/Pokemon/pokemon20.jpg"};
	String[]imageDrapeauArray={"resources/drapeaux/drapeau1.jpg","resources/drapeaux/drapeau2.jpg",
			"devoir02/resources/drapeaux/drapeau3.jpg","devoir02/resources/drapeaux/drapeau4.jpg","devoir02/resources/drapeaux/drapeau5.jpg",
			"devoir02/resources/drapeaux/drapeau6.jpg","devoir02/resources/drapeaux/drapeau7.jpg","devoir02/resources/drapeaux/drapeau8.jpg",
			"devoir02/resources/drapeaux/drapeau9.jpg","devoir02/resources/drapeaux/drapeau10.jpg","devoir02/resources/drapeaux/drapeau11.jpg",
			"devoir02/resources/drapeaux/drapeau12.jpg","devoir02/resources/drapeaux/drapeau12.jpg","devoir02/resources/drapeaux/drapeau14.jpg",
			"devoir02/resources/drapeaux/drapeau15.jpg","devoir02/resources/drapeaux/drapeau16.jpg","devoir02/resources/drapeaux/drapeau17.jpg",
			"devoir02/resources/drapeaux/drapeau18.jpg","devoir02/resources/drapeaux/drapeau19.jpg","devoir02/resources/drapeaux/drapeau20.jpg",
			"devoir02/resources/drapeaux/drapeau21.jpg","devoir02/resources/drapeaux/drapeau22.jpg","devoir02/resources/drapeaux/drapeau23.jpg",
			"devoir02/resources/drapeaux/drapeau24.jpg","devoir02/resources/drapeaux/drapeau25.jpg"};
	
	/**
	 * Constructeur prenant un parametre le non du theme
	 * @param nom
	 */
	public GenerateurDeCartes(String nom){
		this.nom = nom;
	}
	
	/**
	 * Méthode retournant le nom du thème
	 * @return le nom du thème
	 */
	public String getNom(){
		return nom;
	}
	
	/**
	 * Méthode abstraite qui retournera une référence de type Carte à une carte 
	 * choisie aléatoirement parmi celles du thème.
	 * 
	 * @return une référence de type Carte
	 */
	public abstract Carte genereUneCarte();
	
	/**
	 * Méthode abstraite qui retournera un entier indiquant le nombre de 
	 * cartes différentes disponibles dans ce thème
	 * 
	 * @return un entier indiquant le nombre de cartes différentes disponibles 
	 * dans ce thème
	 */
	public abstract int nombreDeCartesDifferentes();
	
	/**
	 * Méthode qui générera un tableau de n cartes selon le thème (si possible toutes différentes) en faisant des 
	 * appels répétés à genereUneCarte.
	 * 
	 * @param n nombre de cartes dans le tableau
	 * @return un tableau de cartes
	 */
	public Carte[] genereCartes(int n){
		
		Carte [] cartes = null;
		
		// Appel les sous-classes de GenerateurDeClasses selon le besoin
		if ( nom.equals("couleur") ) cartes = new GenerateurDeCartesCouleur().genereCartes(n);
		else if ( nom.equals("motProvincesCanada") ) new GenerateurDeCartesMot(nom,motProvincesCanadaArray);
		else if ( nom.equals("motVillesQuebec") ) new GenerateurDeCartesMot(nom,motVillesQuebecArray);
		else if ( nom.equals("imagePokemon") ) new GenerateurDeCartesImages(nom,imagePokemonArray);
		else if ( nom.equals("imageDrapeau") ) new GenerateurDeCartesImages(nom,imageDrapeauArray);
		else if ( nom.equals("multiple") ) new GenerateurDeCartesMultiples(nom, motProvincesCanadaArray, motVillesQuebecArray,imagePokemonArray,imageDrapeauArray);
		
		return cartes;
	}
	
	/**
	 * Méthode qui générera 2n cartes par paires identiques, selon le thème, et les mélangera. Cette méthode 
	 * fait appel à genereCartes, et aux méthodes duplique et Carte.melangeCartes
	 * 
	 * @param n number of cards in an array
	 * @return an array of cards
	 */
	public Carte[] generePairesDeCartesMelangees(int n){
		
		Carte [] cartes = null;
		Carte [] cartesDouble = new Carte[n*2];
		
		int i;
		
		
		if ( nom.equals("couleur") ) cartes = new GenerateurDeCartesCouleur().genereCartes(n);
		else if ( nom.equals("motProvincesCanada") ) new GenerateurDeCartesMot(nom,motProvincesCanadaArray).genereCartes(n);
		else if ( nom.equals("motVillesQuebec") ) new GenerateurDeCartesMot(nom,motVillesQuebecArray).genereCartes(n);
		else if ( nom.equals("imagePokemon") ) new GenerateurDeCartesImages(nom,imagePokemonArray).genereCartes(n);
		else if ( nom.equals("imageDrapeau") ) new GenerateurDeCartesImages(nom,imageDrapeauArray).genereCartes(n);
		else if ( nom.equals("multiple") ) new GenerateurDeCartesMultiples(nom, motProvincesCanadaArray, motVillesQuebecArray,imagePokemonArray,imageDrapeauArray).genereCartes(n);
		
		for( i = 0; i < n; i++ ){
			cartesDouble[i] = cartes[i];
		}
		
		int j = 0;
		for( ; i < n*2; i++ ){
			cartesDouble[i] = cartes[j];
			j++;
		}
		return cartesDouble;	
	}
}
