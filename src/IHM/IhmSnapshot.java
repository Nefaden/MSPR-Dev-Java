package IHM;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IhmSnapshot extends IhmGenericView implements ActionListener {

    public IhmSnapshot()  {

        this.setTitle("IhmListMaterial Projet Java");
        this.setSize(800,600);
        this.setResizable(false);

        
        JPanel pan=new JPanel();
        pan.setLayout(null);

        /* Les boutons */
        JButton id=new JButton("S'Identifier");
        id.addActionListener(this);

        /* Image de profil */
        JLabel image=new JLabel(new ImageIcon("C:/Users/Perso/IdeaProjects/Projet_java/photodeprofil.jpg"));

        /* On ajoute le bouton */
        pan.add(id);
        /* On ajoute l'image */
        pan.add(image);

        id.setBounds(600,50,150,35);

        image.setBounds(0,0,550,550);

        this.add(pan);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        IhmListMaterial fen=new IhmListMaterial();
        fen.setVisible(true);
        this.setVisible(false);
    }
}
