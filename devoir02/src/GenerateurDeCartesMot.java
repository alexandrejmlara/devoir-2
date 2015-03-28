import java.awt.Graphics;
import java.util.Random;


public class GenerateurDeCartesMot extends GenerateurDeCartes {

	Carte [] cartesMots;
	Boolean [] pickedCards = new Boolean[nombreDeCartesDifferentes()];
	String nomDuTheme;
	String[] optionsDeMot;
	
	
	GenerateurDeCartesMot(String nomDuTheme, String[] Tableau){
		super(nomDuTheme);
		this.nomDuTheme=nomDuTheme;
		this.optionsDeMot=Tableau;
	}
	
	public int nombreDeCartesDifferentes() {
		return optionsDeMot.length;	
	}

	
	public Carte[] genereCartes(int n){
		cartesMots = new Carte [n];
		CarteCouleur tempMot = null;
		Graphics g = null;
		for  ( int i = 0; i < cartesMots.length; i++ ){
			cartesMots[i] = genereUneCarte();
		}
		
		return cartesMots;
	}
	
	public Carte genereUneCarte(){
		Random rd = new Random();
		int carteIndex = rd.nextInt(optionsDeMot.length);
		
		// In the case of all cards already were picked, reinitialize the array
		// to choose a repeated one randomly
		if( isAllCardsPicked() ) initializePickedCardsArray();
		
		while( pickedCards[carteIndex] ){
			carteIndex = rd.nextInt(cartesMots.length);			
		}
		
		CarteMot tempMot = new CarteMot(true,optionsDeMot[carteIndex]);
		Graphics g = tempMot.getGraphics();
		tempMot.paintRecto(g);
		
		return tempMot;
		
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
	
	