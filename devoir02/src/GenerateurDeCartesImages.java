import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;


public class GenerateurDeCartesImages extends GenerateurDeCartes {

	/**
	 * declaration de trois tableaux et du String avec le non du theme. Le tableau nCartesImages nous donne n cartes de 
	 * images aleatoires, le pickedCards est un tableau qui dit si les optionsDeImages était utilisé ou pas, et 
	 * optionsDeImage sont toutes les options de images qu'il y a.
	 */
	Carte [] nCartesImages;
	Boolean [] pickedCards = new Boolean[nombreDeCartesDifferentes()]; //true : carte utilisé, false: carte pas utilisé
	String[] optionsDeImage;
	String nomDuTheme;
	
	/**
	 * Constructeur qui initialise le methode initializePickedCardsArray
	 * 
	 * @param nomDuTheme : String avec le nom du theme
	 * @param Tableau : tableau de String qui indique tous les mots possibles pour ce theme
	 */
	GenerateurDeCartesImages(String nomDuTheme, String[] Tableau){
		super(nomDuTheme);
		this.nomDuTheme=nomDuTheme;
		this.optionsDeImage=Tableau;
	}
	
	/**
	 * Méthode implementé de GenerateurDeCartes qui retourne un entier indiquant le nombre de 
	 * cartes différentes disponibles dans ce thème
	 * 
	 * @return un entier indiquant le nombre de cartes différentes disponibles dans ce thème
	 */
	@Override
	public int nombreDeCartesDifferentes() {
		return optionsDeImage.length;	
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
		nCartesImages = new Carte [n];
		CarteCouleur tempImage = null;
		Graphics g = null;
		for  ( int i = 0; i < nCartesImages.length; i++ ){
			nCartesImages[i] = genereUneCarte();
		}
		return nCartesImages;
	}
	
	/**
	 * Méthode implementé de GenerateurDeCartes qui retournera une référence de type Carte à une carte 
	 * choisie aléatoirement parmi celles du thème.
	 * 
	 * @return tempImage: de type CarteImage
	 */
	@Override
	public Carte genereUneCarte(){
		Random rd = new Random();
		int carteIndex = rd.nextInt(optionsDeImage.length);
		
		//Dans le cas où toutes les cartes étaient déjà  prises, réinitialiser le tableau pour répétée le procédure
		if( isAllCardsPicked() ) initializePickedCardsArray();
		
		//on verifié si l'option de carté était déjà utilisé
		while( pickedCards[carteIndex] ){
			carteIndex = rd.nextInt(nCartesImages.length);			
		}
		
		CarteImage tempImage = new CarteImage (true, optionsDeImage[carteIndex]);
		Graphics g = tempImage.getGraphics();
		ImageIcon image = new ImageIcon (getClass().getResource(optionsDeImage[carteIndex]));
		Image img = image.getImage();
		g.drawImage(img, 0,0, width, height, this);
		tempImage.paintRecto(g);
		
		return tempImage;
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
