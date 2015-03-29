import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
/**
 * @author Gabriel Houle-Violette 1023967
 * @author Rodolpho Pinheiro D'Azevedo 20026356
 */
public class GenerateurDeCartesCouleur extends GenerateurDeCartes {
	/**
	 * declaration de trois tableaux. Le tableau nCartesCouleur nous donne n cartes de couleur aleatoires, le 
	 * pickedCards est un tableau qui dit si les optionsDecouleurs était utilisé ou pas, et optionsDeCouleur sont 
	 * toutes les options de couleurs qu'il y a.
	 */
	Carte [] nCartesCouleurs;
	Boolean [] pickedCards = new Boolean[8]; //true : carte utilisé, false: carte pas utilisé
	Color [] optionsDeCouleurs = {Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, 
							Color.MAGENTA, Color.YELLOW, Color.PINK, Color.ORANGE};
	
	/**
	 * Constructeur sans parametre qui initialise le methode initializePickedCardsArray
	 */
	public GenerateurDeCartesCouleur(){
		super("couleur");
		initializePickedCardsArray();
	}
	
	/**
	 * Méthode implementé de GenerateurDeCartes qui retourne un entier indiquant le nombre de 
	 * cartes différentes disponibles dans ce thème
	 * 
	 * @return 8 : nombre de cartes différentes disponibles dans ce thème
	 */
	@Override
	public int nombreDeCartesDifferentes() {
		return 8;
		}
	
	/**
	 * Méthode qui générere un tableau de n cartes selon le thème (si possible toutes différentes) en faisant des 
	 * appels répétés à genereUneCarte.
	 * 
	 * @param n : quantité de cartes a generer
	 * @return nCartesCouleurs : un tableau avec n cartes selon le thème (si possible toutes différentes)
	 */
	@Override
	public Carte[] genereCartes(int n){
		nCartesCouleurs = new Carte [n];
		CarteCouleur tempCouleur = null;
		Graphics g = null;
		for  ( int i = 0; i < nCartesCouleurs.length; i++ ){
			nCartesCouleurs[i] = genereUneCarte();
		}
		return nCartesCouleurs;
	}
	
	/**
	 * Méthode implementé de GenerateurDeCartes qui retournera une référence de type Carte à une carte 
	 * choisie aléatoirement parmi celles du thème.
	 * 
	 * @return tempCouleur: de type CarteCouleur
	 */
	@Override
	public Carte genereUneCarte(){
		Random rd = new Random();
		int carteIndex = rd.nextInt(optionsDeCouleurs.length);
		
		//Dans le cas où toutes les cartes étaient déjà  prises, réinitialiser le tableau pour répétée le procédure
		if( isAllCardsPicked() ) initializePickedCardsArray();
		
		//on verifié si l'option de carté était déjà utilisé
		while( pickedCards[carteIndex] ){
			carteIndex = rd.nextInt(nCartesCouleurs.length);			
		}
		
		CarteCouleur tempCouleur = new CarteCouleur(true);
		Graphics g = tempCouleur.getGraphics();
		g.setColor(optionsDeCouleurs[carteIndex]);
		tempCouleur.paintRecto(g);
		
		return tempCouleur;
	}
	
	/**
	 * Methode qui initialise le tableau pickedCards avec des boleen false, pour indiqué que les cartes n'étaient pas
	 * utilisé
	 */
	private void initializePickedCardsArray(){
		
		for ( int i = 0; i < pickedCards.length; i++ ){
			pickedCards[i] = false;
		}	
	}
	
	/**
	 * on verifie si toutes les options de cartes son prises.
	 * 
	 * @return true: si toutes les options de cartes sont prises, false: sinon.
	 */
	private boolean isAllCardsPicked(){
		
		boolean isCardsPicked = true;
		for ( int i = 0; i < pickedCards.length; i++ ){
			if(!pickedCards[i]) {
				isCardsPicked = false;
				break;
			}
		}
		return isCardsPicked;
	}
}
