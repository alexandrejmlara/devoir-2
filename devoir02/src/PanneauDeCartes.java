import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class PanneauDeCartes {
	public Carte c;
	
	
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
	public void PanneauDeCartes(int nRangees, int nColonnes,  int delaiAffichageInitial, int delaiAffichageMauvaisePaire)
    {
    	JFrame frame = new JFrame("Jeu de cartes mémoire");
        
        GridLayout layout = new GridLayout(nRangees,nColonnes);
        layout.setHgap(10);
        layout.setVgap(10);
        frame.setLayout(layout);
        JPanel pane = new JPanel();
        
        for (int row = 0; row < nRangees; row++){
            for (int col = 0; col < nColonnes; col++){
                
            	c = new CarteCouleur(false);
            	c.addMouseListener(new MyMouseListener());
                pane.add(c);
            }
        }
        pane.setLayout(layout);
        
        
        frame.getContentPane().add(pane, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.show();
        frame.setSize (500, 500);
        
        
    }
    

    
    
    class MyMouseListener extends MouseAdapter
    {
        // coup : compteur pour le nombre de coups effectué par le joueur
    	private int coup = 0;
        public void setCoup(int c){coup += c;} // Permet d'incrémenter du nombre voulu
        public int getCoup(){return coup;} // Retourne le nombre de coups
        
        public void mouseClicked(MouseEvent event) // modifier ici pour action
        {
            if(event.getSource()== c){
            	c.retourne();
            };
            
            
            setCoup(1);
        	System.out.println("Bravo, vous avez réussi en " + this.getCoup() + " coups!"); // À mettre dans une condition
        } 
    }
}
