import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class GenerateurDeCartesCouleur extends GenerateurDeCartes {
	
	Carte [] cartesCouleurs;
	Boolean [] pickedCards = new Boolean[8];
	Color [] optionsDeCouleurs = {Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, 
							Color.MAGENTA, Color.YELLOW, Color.PINK, Color.ORANGE};
	
	public GenerateurDeCartesCouleur(){
		super("couleur");
		initializePickedCardsArray();
	}
	
	@Override
	public Carte[] genereCartes(int n){
		cartesCouleurs = new Carte [n];
		CarteCouleur tempCouleur = null;
		Graphics g = null;
		for  ( int i = 0; i < cartesCouleurs.length; i++ ){
			cartesCouleurs[i] = genereUneCarte();
		}
		
		return cartesCouleurs;
	}
	
	public Carte genereUneCarte(){
		Random rd = new Random();
		int carteIndex = rd.nextInt(optionsDeCouleurs.length);
		
		// In the case of all cards already were picked, reinitialize the array
		// to choose a repeated one randomly
		if( isAllCardsPicked() ) initializePickedCardsArray();
		
		while( pickedCards[carteIndex] ){
			carteIndex = rd.nextInt(cartesCouleurs.length);			
		}
		
		CarteCouleur tempCouleur = new CarteCouleur(true);
		Graphics g = tempCouleur.getGraphics();
		g.setColor(optionsDeCouleurs[carteIndex]);
		tempCouleur.paintRecto(g);
		
		return tempCouleur;
		
	}
	
	private void initializePickedCardsArray(){
		
		for ( int i = 0; i < pickedCards.length; i++ ){
			pickedCards[i] = false;
		}
		
	}
	
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

	@Override
	public int nombreDeCartesDifferentes() {
		// TODO Auto-generated method stub
		return 8;
	}
		
	

}
