
public abstract class GenerateurDeCartes {
	/**
	 * Une propriété nom comportant le nom du thème
	 */
	// couleur
	// motProvincesCanada
	// motVilleQuebec
	// imagePokemon
	// imageFiguresGeometriques
	// multiple
	private String nom;
	
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
		
	}
}
