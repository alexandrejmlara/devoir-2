import javax.swing.JComponent;

public abstract class Carte extends JComponent {

	private boolean imageFaceRecto;
	
	/**
	 * Un constructeur protected prenant un paramètre booléen  indiquant si la carte est sur sa face recto 
	 * (côté image) ou verso (sur le dos, image cachée).
	 * @param imageFaceRecto
	 */
	protected Carte (boolean imageFaceRecto){
		this.imageFaceRecto=imageFaceRecto;
	}
	
	/**
	 * Un constructeur de copie protected prenant en paramètre une autre instance de Carte
	 * @param c
	 */
	protected Carte (Carte c){
		this.imageFaceRecto=c.imageFaceRecto;
	}
	
	
	/**
	 * 
	 * @return
	 */
	boolean estMontree(){
		if(imageFaceRecto==true)
			return true;
		else
			return false;
	}
	
	/**
	 * 
	 * @return
	 */
	boolean estCachee(){
		if(imageFaceRecto==false)
			return true;
		else
			return false;
	}
	
	
	
	
}
