import java.util.Random;


public class GenerateurDeCartesMot extends GenerateurDeCartes {

	String nomDuTheme;
	String[] provincesCanada= {"Alberta","Colombie-Britannique", "Ile-du-Prince-Edouard","Manitoba",
			"Nouveau-Brunswick","Nouvelle-Ecosse","Ontario","Quebec", "Saskatchewan","Terre-Neuve-et-Labrador",
			"Nunavut","Territoires du Nord-Ouest","Yukon"};
	
	String[] villesQuebec={"Quebec","Montreal","Laval","Gatineau","Longueuil","Sherbrooke","Saguenay","Trois-Rivieres",
			"Terrebonne","Rimouski"};
	
	
	GenerateurDeCartesMot(String nomDuTheme){
		super(nomDuTheme);
		this.nomDuTheme=nomDuTheme;
	}
	
	
	/**
	 * @return 13 : si nomDuTheme=="motProvincesCanada" : cest le total de provinces dans provincesCanada
	 * @return 10 : si nomDuTheme1="motProvincesCanada", alors nomDuTheme=="motVillesQuebec" : cest le total de villes dans villesQuebec
	 */
	public int nombreDeCartesDifferentes() {
		if(nomDuTheme=="motProvincesCanada")
			return 13;
		else 
			return 10;	
	}


	@Override
	public Carte genereUneCarte() {
		// TODO Auto-generated method stub
		return null;
	}
	
	