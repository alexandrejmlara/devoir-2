import java.awt.Graphics;

public class CarteImage extends Carte{
	
	private String carteNom;
	
	/**
	 * * Constructeur protected prenant un parametre un booleen  indiquant si la carte est sur sa face recto 
	 * (cote image) ou verso (sur le dos, image cachee) et un String avec le nom de la carte
	 * @param isFace : true = recto, false = verso.
	 * @param carteNom
	 */
    protected CarteImage(boolean isFace, String carteNom) {
		super(isFace);
		this.carteNom=carteNom;
	}
    
    /**
	 * Constructeur de copie recevant en paramètre une autre instance de ce type
	 * @param c : autre instance de CarteImage
	 */
    public CarteImage(CarteImage c) {
		super(false);
		this.carteNom = c.carteNom;
	}

    /**
	 * Methode implementé de Carte qui peint le recto d'une carte
	 * @param g
	 */
	@Override
	public void paintRecto(Graphics g) {
		
		
	}

	/**
	 * Méthode implementé de Carte qui prend une autre Carte en paramètre et retournant un booléen indiquant si les deux 
	 * cartes ont le même recto.
	 * @param c : tipe Carte
	 * @return true si les cartes sont identiques
	 */
	@Override
	public boolean rectoIdentique(Carte c) {
		CarteImage c2 = (CarteImage) c;
		if ( carteNom.equals(c2.carteNom) ) return true;
		return false;
	}

	/**
	 * Méthode implementé de Carte 
	 * @return une nouvelle copie identique de l'objet.
	 */
	@Override
	public Object duplique() {
		return new CarteImage(this);
	}
}
