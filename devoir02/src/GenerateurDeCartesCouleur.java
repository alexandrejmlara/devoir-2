import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class GenerateurDeCartesCouleur extends GenerateurDeCartes {
	
	Carte [] cartesCouleurs = new Carte [8];
	Boolean [] pickedCards = new Boolean[8];
	Color [] couleurs = {Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, 
							Color.MAGENTA, Color.YELLOW, Color.PINK, Color.ORANGE};
	
	public GenerateurDeCartesCouleur(){
		genereCartes();
		initializePickedCardsArray();
	}
	
	public void genereCartes(){
		CarteCouleur tempCouleur = null;
		Graphics g = null;
		for  ( int i = 0; i < cartesCouleurs.length; i++ ){
			tempCouleur = new CarteCouleur(true);
			g = tempCouleur.getGraphics();
			g.setColor(couleurs[i]);
			tempCouleur.paintRecto(g);
			cartesCouleurs[i] = tempCouleur;
		}
	}
	
	public Carte genereUneCarte(){
		Random rd = new Random();
		int carteIndex = rd.nextInt(cartesCouleurs.length);
		
		// In the case of all cards already were picked, reinitialize the array
		// to choose a repeated one randomly
		if( isAllCardsPicked() ) initializePickedCardsArray();
		
		while( pickedCards[carteIndex] ){
			carteIndex = rd.nextInt(cartesCouleurs.length);			
		}
		
		return cartesCouleurs[carteIndex];
		
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
		
	

}
