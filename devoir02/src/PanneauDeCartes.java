import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanneauDeCartes {
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
     * @param nRangees : nombre de rang�es de cartes
     * @param nColonnes : nombre de colonnes de cartes
     * @param delaiAffichageInitial : temps d'affichage initial des cartes
     * @param delaiAffichageMauvaisePaire : temps de d�lai lors d'une mauvaise paire
     */
	public void PanneauDeCartes(int nRangees, int nColonnes,  int delaiAffichageInitial, int delaiAffichageMauvaisePaire)
    {
    	JFrame frame = new JFrame("Jeu de cartes m�moire");
        
        GridLayout layout = new GridLayout(nRangees,nColonnes);
        layout.setHgap(10);
        layout.setVgap(10);
        frame.setLayout(layout);
        JPanel pane = new JPanel();
        
        for (int row = 0; row < nRangees; row++){
            for (int col = 0; col < nColonnes; col++){
                JButton b = new JButton();
                pane.add(b);
                b.addMouseListener(new MyMouseListener());
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
        private int coup = 0;
        public void setCoup(int c){coup += c;} // Permet d'incr�menter du nombre voulu
        public int getCoup(){return coup;} // Retourne le nombre de coups
        
        public void mouseClicked(MouseEvent event) // modifier ici pour action
        {
            //event.getSource();
            System.out.println("Bravo, vous avez r�ussi en " + this.getCoup() + " coups!"); // � mettre dans une condition
        } 
    }
}
