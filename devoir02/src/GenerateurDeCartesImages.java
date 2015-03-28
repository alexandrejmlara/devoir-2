import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;


public class GenerateurDeCartesImages extends GenerateurDeCartes {

	Carte [] cartesImages;
	Boolean [] pickedCards = new Boolean[nombreDeCartesDifferentes()];
	String nomDuTheme;
	String[] optionsDeImage;
	
	GenerateurDeCartesImages(String nomDuTheme, String[] Tableau){
		super(nomDuTheme);
		this.nomDuTheme=nomDuTheme;
		this.optionsDeImage=Tableau;
	}
	
	@Override
	public int nombreDeCartesDifferentes() {
		return optionsDeImage.length;	
	}

	public Carte[] genereCartes(int n){
		cartesImages = new Carte [n];
		CarteCouleur tempImage = null;
		Graphics g = null;
		for  ( int i = 0; i < cartesImages.length; i++ ){
			cartesImages[i] = genereUneCarte();
		}
		return cartesImages;
	}
	
	public Carte genereUneCarte(){
		Random rd = new Random();
		int carteIndex = rd.nextInt(optionsDeImage.length);
		
		// In the case of all cards already were picked, reinitialize the array
		// to choose a repeated one randomly
		if( isAllCardsPicked() ) initializePickedCardsArray();
		
		while( pickedCards[carteIndex] ){
			carteIndex = rd.nextInt(cartesImages.length);			
		}
		
		CarteImage tempImage = new CarteImage (true, optionsDeImage[carteIndex]);
		Graphics g = tempImage.getGraphics();
		
		ImageIcon image = new ImageIcon (getClass().getResource(optionsDeImage[carteIndex]));
		
		Image img = image.getImage();
		g.drawImage(img, 0,0, width, height, this);
		tempImage.paintRecto(g);
		
		return tempImage;
		
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
