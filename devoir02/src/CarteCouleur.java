import java.awt.Color;
import java.awt.Graphics2D;


public class CarteCouleur extends Carte {
	private static final long serialVersionUID = 1L;
	String carteNom;
	
	protected CarteCouleur(boolean isFace) {
		super(isFace);	
	}
	
	protected CarteCouleur(CarteCouleur c) {
		super(false);
		this.carteNom = c.carteNom;
	}
	
	@Override
	public void paintRecto(Graphics2D g) {
		super.paintComponent(g);
		//g.setPaint(Color.BLACK); ça doit être fais apès dans une autre classe
		g.fillRect(0, 0, getWidth(), getHeight());
		
	}

	@Override
	public boolean rectoIdentique(Carte c) {
		CarteCouleur c2 = (CarteCouleur) c;
		if ( carteNom.equals(c2.carteNom) ) return true;
		return false;
	}

	@Override
	public Object duplique() {
		return new CarteCouleur(this);
	}

	

}
