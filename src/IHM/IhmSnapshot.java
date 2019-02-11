package IHM;

import javax.swing.*;

public class IhmSnapshot extends IhmGenericView {

    public IhmSnapshot() {
        initComponents();
        this.setTitle("Projet MSPR Java");
        this.setSize(800, 600);
        this.setResizable(false);


        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        JPanel jPanelVisionCheck = new JPanel();
        jPanelVisionCheck.setLayout(null);

        /* Les boutons */
        JButton jButtonAuth = new JButton("S'Identifier");

        /* Image de profil */
        JLabel image=new JLabel(new ImageIcon("../MSPR-Dev-Java/photodeprofil.jpg"));

        /* On ajoute le bouton */
        jPanel.add(jButtonAuth);
        /* On ajoute l'image */
        jPanel.add(image);

        jButtonAuth.setBounds(600,50,150,35);

        image.setBounds(0,0,550,550);

        jPanelVisionCheck.setBounds(10, 50, 500, 400);

        this.add(jPanel);
    }

    private void initComponents() {
        jButtonAuth = new javax.swing.JButton();
        jPanelVisionCheck = new javax.swing.JPanel();
        jPanel = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
    }

    public JPanel getjPanelVisionCheck() {
        return jPanelVisionCheck;
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public JButton getjButtonAuth() {
        return jButtonAuth;
    }

    public JLabel getImage() {
        return image;
    }

    private javax.swing.JPanel jPanelVisionCheck;
    private javax.swing.JPanel jPanel;
    private javax.swing.JButton jButtonAuth;
    private javax.swing.JLabel image;

}
