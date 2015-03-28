
public abstract class GenerateurDeCartes {
	/**
	 * Une propriété nom comportant le nom du thème
	 */
	// couleur
	// motProvincesCanada
	// motVillesQuebec
	// imagePokemon
	// imageFiguresGeometriques
	// multiple
	private String nom;
	
	public GenerateurDeCartes(String nom){
		this.nom = nom;
	}
	
	/**
	 * Une méthode retournant le nom du thème
	 * @return le nom du thème
	 */
	public String getNom(){
		return nom;
	}
	
	/**
	 * Une méthode abstraite qui retournera une référence 
	 * de type Carte à une carte choisie aléatoirement parmi celles du thème.
	 * 
	 * @return une référence de type Carte
	 */
	public abstract Carte genereUneCarte();
	
	/**
	 * Une méthode abstraite qui retournera un entier indiquant le nombre de 
	 * cartes différentes disponibles dans ce thème
	 * 
	 * @return un entier indiquant le nombre de cartes différentes disponibles 
	 * dans ce thème
	 */
	public abstract int nombreDeCartesDifferentes();
	
	/**
	 * Une méthode Carte[] genereCartes(int n) qui générera un tableau de n 
	 * cartes selon le thème, si possible toutes différentes, en faisant des 
	 * appels répétés à genereUneCarte.
	 * 
	 * @param n number of cards in an array
	 * @return an array of cards
	 */
	public Carte[] genereCartes(int n){
		// couleur
		// motProvincesCanada
		// motVillesQuebec
		// imagePokemon
		// imageFiguresGeometriques
		// multiple
		Carte [] cartes = null;
		
		// Return a tableau of cartes couleur
		if ( nom.equals("couleur") ) cartes = new GenerateurDeCartesCouleur().genereCartes(n);
		else if ( nom.equals("motProvincesCanada") || nom.equals("motVillesQuebec") ) = new GenerateurDeCartesMot(nom);
		else if ( nom.equals("imagePokemon") ) = new GenerateurDeCartesImage(nom);
		else if ( nom.equals("multiple") ) = new GenerateurDeCartesMultiple();
		
		return cartes;
	}
	
	/**
	 * Une méthode Carte[] generePairesDeCartesMelangees(int n) qui générera 2n 
	 * cartes par paires identiques, selon le thème, et les mélangera (cette méthode 
	 * devrait faire appel à genereCartes , et aux méthodes duplique et Carte.melangeCartes).
	 * 
	 * @param n number of cards in an array
	 * @return an array of cards
	 */
	public Carte[] generePairesDeCartesMelangees(int n){
		
		Carte [] cartes = null;
		Carte [] cartesDouble = new Carte[n*2];
		
		int i;
		
		if ( nom.equals("couleur") ) cartes = new GenerateurDeCartesCouleur().genereCartes(n);
		else if ( nom.equals("motProvincesCanada") || nom.equals("motVillesQuebec") ) = new GenerateurDeCartesMot(nom).genereCartes(n);
		else if ( nom.equals("imagePokemon") ) = new GenerateurDeCartesImage(nom).genereCartes(n);
		else if ( nom.equals("multiple") ) = new GenerateurDeCartesMultiple().genereCartes(n);
		
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
