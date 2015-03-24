import javax.swing.JComponent;

public abstract class Carte extends JComponent {

	boolean imageCache;
	
	protected Carte (boolean imageCache){
		this.imageCache=imageCache;
	}
	
	boolean estMontree(){
		if(imageCache==false)
			return true;
		else
			return false;
	}
	
	boolean estCachee(){
		if(imageCache==true)
			return true;
		else
			return false;
	}
	
	
}
