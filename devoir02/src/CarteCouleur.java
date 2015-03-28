import java.awt.*;

public class CarteCouleur extends Carte {
	private static final long serialVersionUID = 1L;
	String carteNom;
	private Color couleur;

	public CarteCouleur(boolean isFace) {
		super(isFace);
	}
	
	public CarteCouleur(CarteCouleur c) {
		super(false);
		this.carteNom = c.carteNom;
	}

	
	public void paintRecto(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(0, 0, getWidth(), getHeight());
	};

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
