import java.awt.Graphics;

public class CarteMot extends Carte {

	private static final long serialVersionUID = 1L;
	private String carteNom;
  
	protected CarteMot(boolean isFace,String carteNom) {
		super(isFace);
		this.carteNom=carteNom;
		
	}
	
	protected CarteMot(CarteMot c) {
		super(false);
		this.carteNom = c.carteNom;
	}

	@Override
	public void paintRecto(Graphics g) {
		super.paintComponent(g);
		g.drawString(carteNom, 0, 0);
	}

	@Override
	public boolean rectoIdentique(Carte c) {
		CarteMot c2 = (CarteMot) c;
		if ( carteNom.equals(c2.carteNom) ) return true;
		return false;
	}

	@Override
	public Object duplique() {
		return new CarteMot(this);
	}

}
