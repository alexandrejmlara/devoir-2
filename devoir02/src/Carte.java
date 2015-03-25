import javax.swing.JComponent;

public abstract class Carte extends JComponent {

	boolean imageFaceRecto;
	
	/**
	 * 
	 * @param imageFaceRecto
	 */
	protected Carte (boolean imageFaceRecto){
		this.imageFaceRecto=imageFaceRecto;
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
