import java.awt.Graphics;
import java.util.Random;


public class GenerateurDeCartesMot extends GenerateurDeCartes {

	/**
	 * declaration de trois tableaux et du String avec le non du theme. Le tableau nCartesMots nous donne n cartes de 
	 * mots aleatoires, le pickedCards est un tableau qui dit si les optionsDeMots était utilisé ou pas, et 
	 * optionsDeMot sont toutes les options de mot qu'il y a.
	 */
	Carte [] nCartesMots;
	Boolean [] pickedCards = new Boolean[nombreDeCartesDifferentes()]; //true : carte utilisé, false: carte pas utilisé
	String nomDuTheme;
	String[] optionsDeMot;
	
	/**
	 * Constructeur qui initialise le methode initializePickedCardsArray
	 * 
	 * @param nomDuTheme : String avec le nom du theme
	 * @param Tableau : tableau de String qui indique tous les mots possibles pour ce theme
	 */
	GenerateurDeCartesMot(String nomDuTheme, String[] Tableau){
		super(nomDuTheme);
		this.nomDuTheme=nomDuTheme;
		this.optionsDeMot=Tableau;
	}
	
	/**
	 * Méthode implementé de GenerateurDeCartes qui retourne un entier indiquant le nombre de 
	 * cartes différentes disponibles dans ce thème
	 * 
	 * @return un entier indiquant le nombre de cartes différentes disponibles dans ce thème
	 */
	@Override
	public int nombreDeCartesDifferentes() {
		return optionsDeMot.length;	
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
		nCartesMots = new Carte [n];
		CarteCouleur tempMot = null;
		Graphics g = null;
		for  ( int i = 0; i < nCartesMots.length; i++ ){
			nCartesMots[i] = genereUneCarte();
		}
		return nCartesMots;
	}
	
	/**
	 * Méthode implementé de GenerateurDeCartes qui retournera une référence de type Carte à une carte 
	 * choisie aléatoirement parmi celles du thème.
	 * 
	 * @return tempMot: de type CarteMot
	 */
	@Override
	public Carte genereUneCarte(){
		Random rd = new Random();
		int carteIndex = rd.nextInt(optionsDeMot.length);
		
		//Dans le cas où toutes les cartes étaient déjà  prises, réinitialiser le tableau pour répétée le procédure
		if( isAllCardsPicked() ) initializePickedCardsArray();
		
		//on verifié si l'option de carté était déjà utilisé
		while( pickedCards[carteIndex] ){
			carteIndex = rd.nextInt(nCartesMots.length);			
		}
		
		CarteMot tempMot = new CarteMot(true,optionsDeMot[carteIndex]);
		Graphics g = tempMot.getGraphics();
		tempMot.paintRecto(g);
		
		return tempMot;
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
	
	