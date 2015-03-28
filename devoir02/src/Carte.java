import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JComponent;

public abstract class Carte extends JComponent {

	private boolean isFace; // true = recto, false = verso
	
	/**
	 * Un constructeur protected prenant un parametre un booleen  indiquant si la carte est sur sa face recto 
	 * (cote image) ou verso (sur le dos, image cachee).
	 * @param isFace : true = recto, false = verso.
	 */
	protected Carte (boolean isFace){
		this.isFace = isFace;
	}
	
	/**
	 * Un constructeur de copie protected prenant en parametre une autre instance de Carte
	 * @param c : une autre instance de Carte
	 */
	protected Carte (Carte c){
		this.isFace = c.isFace;
	}
	
	/**
	 * Methode qui retourne un booleen qui indique si la carte est sur son côté recto
	 * @return true si la carte est sur son coté recto
	 */
	public boolean estMontree(){
		if(isFace)
			return true;
		return false;
	}
	
	/**
	 * Methode qui retourne un booleen qui indique si la carte est sur son côté verso
	 * @return true si la carte est sur son coté verso
	 */
	public boolean estCachee(){
		if(!isFace)
			return true;
		return false;
	}
	
	/**
	 * Méthode qui au besoin changent la face de la carte a son côté recto
	 */
	public void montre(){
		if(!isFace) isFace = true;
		repaint();
	}
	
	/**
	 * Méthode qui au besoin changent la face de la carte a son côté verso
	 */
	public void cache(){
		if(isFace) isFace = false;
		repaint();
	}
	
	/**
	 * Méthode qui change la face de la carte (si elle est dans son cote verso, elle change a son cote verso
	 * et vice-versa).
	 */
	public void retourne(){
		if(isFace) cache();
		else montre();
		repaint();
	}
	
	/**
	 * Méthode qui peint avec la couleur noir le verso d'une carte dans un contexte graphique g
	 * @param g
	 */
	public void paintVerso(Graphics2D g){
		super.paintComponent(g);
		g.setPaint(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());	
	}
	
	/**
	 * Méthode abstraite qui peint le recto d'une carte, mais dont l'implémentation est laissée aux sous-classes de Carte.
	 * @param g
	 */
	public abstract void paintRecto(Graphics g);
	
	
	/**
	 * Une redéfinition de la méthode paintComponent héritée de JComponent. 
	 * Elle devra appeler paintRecto ou paintVerso selon ce qui est approprié d'après l'état de la carte.
	 */
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if(isFace) paintRecto(g2);
		else paintVerso(g2);
	}
	
	/**
	 * Méthode abstraite prenant une autre Carte en paramètre et retournant un booléen indiquant si les deux 
	 * cartes ont le même recto . Remarque: le rôle d
	 * @param c : tipe Carte
	 * @return true si les cartes sont identiques
	 */
	public abstract boolean rectoIdentique(Carte c);
	
	
	/**
	 * Méthode abstraite qui sera redéfinie dans les sous-classes. 
	 * @return une nouvelle copie identique de l'objet.
	 */
	public abstract Object duplique();
	
	
	/**
	 * Méthode utilitaire qui mélange dans un ordre aléatoire un tableau de cartes passées en paramètre
	 * @param cartes : tableau de cartes
	 */
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
