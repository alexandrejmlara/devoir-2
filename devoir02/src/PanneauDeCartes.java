import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @author Gabriel Houle-Violette 1023967
 * @author Rodolpho Pinheiro D'Azevedo 20026356
 */
public class PanneauDeCartes {
	public Carte c;
	public Carte c1 = null; // Première carte retournée
	public Carte c2 = null; // Deuxième carte retournée
	
	public static int coup = 0; // Nombre de coups effectué par l'utilisateur
	public void setCoup(int c){coup += c;} // Permet d'incrémenter du nombre voulu
    public int getCoup(){return coup;} // Retourne le nombre de coups
	
    
    /**
     * delaiInitial: attribut gérant le délai avant de cacher toutes les cartes
     * delaiMauvaisePaire: attribut gérant le délai dans le cas d'une mauvaise paire
     */
    private int delaiInitial;
    private int delaiMauvaisePaire;
    public void setDelaiInitial(int a){delaiInitial = a;}
    public void setDelaiMauvaisePaire(int a){delaiMauvaisePaire = a;}
    public int getDelaiInitial(){return delaiInitial;}
    public int getDelaiMauvaisePaire(){return delaiMauvaisePaire;}
    
	public static void delai(long millisecondes)
    {
        try {
            Thread.sleep(millisecondes);
        }
        catch(InterruptedException e){
            System.out.println("Sleep interrompu");
        }
    }
    
    /**
     * 
     * @param nRangees : nombre de rangées de cartes
     * @param nColonnes : nombre de colonnes de cartes
     * @param delaiAffichageInitial : temps d'affichage initial des cartes
     * @param delaiAffichageMauvaisePaire : temps de délai lors d'une mauvaise paire
     */
	public void PanneauDeCartes(int nRangees, int nColonnes, Carte[] cartes,  int delaiAffichageInitial, int delaiAffichageMauvaisePaire)
	{
    	setDelaiInitial(delaiAffichageInitial);
    	setDelaiMauvaisePaire(delaiAffichageMauvaisePaire);
		
		JFrame frame = new JFrame("Jeu de cartes mémoire");
        
        GridLayout layout = new GridLayout(nRangees,nColonnes);
        layout.setHgap(10);
        layout.setVgap(10);
        frame.setLayout(layout);
        JPanel pane = new JPanel();
        
        for(int i=0; i < cartes.length; i++){
        	cartes[i].addMouseListener(new MyMouseListener());
        	pane.add(cartes[i]);
        }
        
        pane.setLayout(layout);
        
        
        frame.getContentPane().add(pane, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize (500, 500);
        
        
    }
    

    
    
    class MyMouseListener extends MouseAdapter
    {
        
        public void mouseClicked(MouseEvent event) // modifier ici pour action
        {
            Object source = event.getSource();
        	if(source instanceof Carte){
            	Carte card = (Carte) source;
            	if(card.estCachee()) card.retourne();
            	if(c1 == null) c1 = card;
            	else {
            		c2 = card; 
            		if(c2.rectoIdentique(c1)){
            			c1 = null; 
            			c2 = null;
            		} else {
            			delai(delaiMauvaisePaire);
            			c1.retourne();
            			c2.retourne();
            			c1 = null;
            			c2 = null;
            		}
            	}
            }
            
            
            setCoup(1);
        	System.out.println("Bravo, vous avez réussi en " + getCoup() + " coups!"); // À mettre dans une condition
        } 
    }
}
