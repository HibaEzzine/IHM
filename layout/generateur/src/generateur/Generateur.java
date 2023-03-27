package generateur;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Generateur  extends JFrame {
    private JButton boutonCreerFenetre;
    
    public Generateur() {
        super("Fenetre principale");
        
        // Créer un bouton pour créer une nouvelle fenêtre
        boutonCreerFenetre = new JButton("Créer nouvelle fenêtre");
        boutonCreerFenetre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                creerNouvelleFenetre();
            }
        });
        add(boutonCreerFenetre, BorderLayout.CENTER);
        
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private void creerNouvelleFenetre() {
        JFrame nouvelleFenetre = new JFrame("Nouvelle fenêtre");
        
        // Demander à l'utilisateur de définir les layouts pour la nouvelle fenêtre
        String[] options = {"FlowLayout", "GridLayout", "BoxLayout"};
        int choix = JOptionPane.showOptionDialog(this, "Choisir un layout pour la nouvelle fenêtre", 
            "Nouveau layout", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        
        // Créer le layout pour la nouvelle fenêtre en fonction de l'option sélectionnée
        LayoutManager layout = null;
        switch(choix) {
            case 0:
                layout = new FlowLayout();
                break;
            case 1:
                int nbColonnes = Integer.parseInt(JOptionPane.showInputDialog("Nombre de colonnes :"));
                int nbLignes = Integer.parseInt(JOptionPane.showInputDialog("Nombre de lignes :"));
                layout = new GridLayout(nbLignes, nbColonnes);
                break;
            case 2:
                String direction = JOptionPane.showInputDialog("Direction (horizontal/vertical) :");
                int alignement = Integer.parseInt(JOptionPane.showInputDialog("Alignement (left/center/right) :"));
                layout = new BoxLayout(nouvelleFenetre.getContentPane(), alignement);
                if(direction.equals("horizontal")) {
                    nouvelleFenetre.getContentPane().setLayout(new BoxLayout(nouvelleFenetre.getContentPane(), BoxLayout.X_AXIS));
                }
                else {
                    nouvelleFenetre.getContentPane().setLayout(new BoxLayout(nouvelleFenetre.getContentPane(), BoxLayout.Y_AXIS));
                }
                break;
        }
        nouvelleFenetre.getContentPane().setLayout(layout);
        
        // Ajouter des éléments à la nouvelle fenêtre
        for(int i = 0; i < 5; i++) {
            JLabel label = new JLabel("Label " + (i+1));
            nouvelleFenetre.getContentPane().add(label);
        }
        
        nouvelleFenetre.pack();
        nouvelleFenetre.setLocationRelativeTo(null);
        nouvelleFenetre.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Generateur();
    }
}

