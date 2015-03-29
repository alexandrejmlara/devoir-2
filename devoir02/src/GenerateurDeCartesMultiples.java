/**
 * @author Gabriel Houle-Violette 1023967
 * @author Rodolpho Pinheiro D'Azevedo 20026356
 */
public class GenerateurDeCartesMultiples extends GenerateurDeCartes {

	/**
	 * declaration de trois tableaux et du String avec le non du theme. Le tableau nCartesImages nous donne n cartes de 
	 * images aleatoires, le pickedCards est un tableau qui dit si les optionsDeImages était utilisé ou pas, et 
	 * optionsDeImage sont toutes les options de images qu'il y a.
	 */
	
	String[] optionsDeThemes; 
	String[] motProvincesCanadaArray;
	String[]motVillesQuebecArray;
	String[]imagePokemonArray;
	String[]imageDrapeauArray;
	String nomDuTheme;
	
	/**
	 * Constructeur qui initialise le methode initializePickedCardsArray
	 * 
	 * @param nomDuTheme : String avec le nom du theme
	 */
	GenerateurDeCartesMultiples(String nomDuTheme, String[] motProvincesCanadaArray, String[]motVillesQuebecArray,String[]imagePokemonArray,String[]imageDrapeauArray){
		super(nomDuTheme);
		this.nomDuTheme=nomDuTheme;
	}
	
	@Override
	public Carte genereUneCarte() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nombreDeCartesDifferentes() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
