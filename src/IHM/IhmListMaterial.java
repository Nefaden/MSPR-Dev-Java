package IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IhmListMaterial extends IhmGenericView implements ActionListener {

    public IhmListMaterial(){
        this.setTitle("Projet MSPR Java");
        this.setSize(800,600);
        this.setResizable(false);

        JPanel pan=new JPanel();
        pan.setLayout(null);

        /* Les boutons */
        JButton jButtonBack = new JButton("Retour");
        jButtonBack.addActionListener(this);

        JButton jButtonValidate = new JButton("Valider");
        jButtonValidate.addActionListener(this);

        /* Les CheckBox */
        Checkbox mousqueton=new Checkbox();
        Checkbox gant=new Checkbox();
        Checkbox ceinture=new Checkbox();
        Checkbox detecteur=new Checkbox();
        Checkbox brassard=new Checkbox();
        Checkbox lampe=new Checkbox();
        Checkbox gilet=new Checkbox();

        /* Les Labels */
        JLabel mousq=new JLabel("Mousqueton");
        JLabel gan=new JLabel("Gant d'intervention");
        JLabel ceint=new JLabel("Ceinture de sécurité tactique");
        JLabel detect=new JLabel("Détecteur de métaux");
        JLabel brass=new JLabel("Brassard de sécurité");
        JLabel lamp=new JLabel("Lampe torche");
        JLabel gil=new JLabel("Gilet pare balle");

        /* Image de profil */
        JLabel image=new JLabel(new ImageIcon("C:/Users/Perso/IdeaProjects/Projet_java/photodeprofil.jpg"));

        /* On ajoute le bouton */
        pan.add(jButtonBack);

        /* On ajoute les checkbox */
        pan.add(mousqueton);
        pan.add(gant);
        pan.add(ceinture);
        pan.add(detecteur);
        pan.add(brassard);
        pan.add(lampe);
        pan.add(gilet);

        /* On ajoute les Label */
        pan.add(mousq);
        pan.add(gan);
        pan.add(ceint);
        pan.add(detect);
        pan.add(brass);
        pan.add(lamp);
        pan.add(gil);

        /* On ajoute l'image */
        pan.add(image);



        mousqueton.setBounds(400,280,20,20);
        mousq.setBounds(307,237,100,100);

        gant.setBounds(400,310,20,20);
        gan.setBounds(270,267,200,100);

        ceinture.setBounds(400,340,20,20);
        ceint.setBounds(210,297,200,100);

        detecteur.setBounds(400,370,20,20);
        detect.setBounds(255,327,200,100);

        brassard.setBounds(400,400,20,20);
        brass.setBounds(255,357,200,100);

        lampe.setBounds(400,430,20,20);
        lamp.setBounds(295,387,200,100);

        gilet.setBounds(400,460,20,20);
        gil.setBounds(288,417,200,100);

        jButtonBack.setBounds(20,10,150,35);

        jButtonValidate.setBounds(700,0,150,35);

        image.setBounds(550,10,220,220);

        this.add(pan);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        IhmSnapshot fen=new IhmSnapshot();
        fen.setVisible(true);
        this.setVisible(false);
    }
}
