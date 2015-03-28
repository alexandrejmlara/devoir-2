import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;


import javax.swing.JComponent;

public abstract class Carte extends JComponent {

	private boolean isFace; // true = recto, false = verso
	
	/**
	 * Un constructeur protected prenant un paramÃ¨tre boolÃ©en  indiquant si la carte est sur sa face recto 
	 * (cÃ´tÃ© image) ou verso (sur le dos, image cachÃ©e).
	 * @param isFace
	 */
	protected Carte (boolean isFace){
		this.isFace = isFace;
	}
	
	/**
	 * Un constructeur de copie protected prenant en paramÃ¨tre une autre instance de Carte
	 * @param c
	 */
	protected Carte (Carte c){
		this.isFace = c.isFace;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public boolean estMontree(){
		if(isFace)
			return true;
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean estCachee(){
		if(!isFace)
			return true;
		return false;
	}
	
	public void montre(){
		if(!isFace) isFace = true;
		repaint();
	}
	
	public void cache(){
		if(isFace) isFace = false;
		repaint();
	}
	
	public void retourne(){
		if(isFace) cache();
		else montre();
		repaint();
	}
	
	public void paintVerso(Graphics2D g){
		super.paintComponent(g);
		g.setPaint(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());	
	}
	
	public abstract void paintRecto(Graphics g);
	
	public abstract boolean rectoIdentique(Carte c);
	
	public abstract Object duplique();
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if(isFace) paintRecto(g2);
		else paintVerso(g2);
	}
	
	public static void melangeCartes(Carte[] cartes){
		Random random = new Random();
	    for (int i = cartes.length - 1; i > 0; i--)
	    {
	      int cartesIndex = random.nextInt(i + 1);
	      Carte carte = cartes[cartesIndex];
	      cartes[cartesIndex] = cartes[i];
	      cartes[i] = carte;
	    }
	}
	
	
	
}
