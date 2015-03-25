import javax.swing.JComponent;

public abstract class Carte extends JComponent {

	private boolean isFace; // true = recto, false = verso
	
	/**
	 * Un constructeur protected prenant un paramètre booléen  indiquant si la carte est sur sa face recto 
	 * (côté image) ou verso (sur le dos, image cachée).
	 * @param isFace
	 */
	protected Carte (boolean isFace){
		this.isFace = isFace;
	}
	
	/**
	 * Un constructeur de copie protected prenant en paramètre une autre instance de Carte
	 * @param c
	 */
	protected Carte (Carte c){
		this.isFace = c.isFace;
	}
	
	
	/**
	 * 
	 * @return
	 */
	boolean estMontree(){
		if(isFace)
			return true;
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	boolean estCachee(){
		if(!isFace)
			return true;
		return false;
	}
	
	
	
	
}
