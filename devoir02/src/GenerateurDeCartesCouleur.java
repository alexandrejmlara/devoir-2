import java.awt.Color;
import java.awt.Graphics;


public class GenerateurDeCartesCouleur extends GenerateurDeCartes {
	
	Carte [] couleurs = new Carte [8];
	
	
	CarteCouleur red = new CarteCouleur(true);
	Graphics r = red.getGraphics();
	
	CarteCouleur blue = new CarteCouleur(true);
	Graphics b = blue.getGraphics();
	
	public GenerateurDeCartesCouleur(){
		r.setColor(Color.RED);
		red.paintRecto(r);
		couleurs[0]=red;
		
		b.setColor(Color.BLUE);
		
		
	}
	
	
		
	

}
