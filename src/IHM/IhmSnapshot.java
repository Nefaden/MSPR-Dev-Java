package IHM;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

import javax.swing.*;

public class IhmSnapshot extends IhmGenericView {

    public IhmSnapshot() {
        initComponents();
        this.setTitle("Projet MSPR Java");
        this.setResizable(false);

        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());

        WebcamPanel jPanelVisionCheck = new WebcamPanel(webcam);
        jPanelVisionCheck.setFPSDisplayed(true);
        jPanelVisionCheck.setDisplayDebugInfo(true);
        jPanelVisionCheck.setImageSizeDisplayed(true);
        jPanelVisionCheck.setMirrored(true);

        JFrame mainWindow = new JFrame();
        mainWindow.add(jPanelVisionCheck);
        mainWindow.add(jButtonAuth);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.pack();
        mainWindow.setVisible(true);
        mainWindow.setSize(800,600);

        jButtonAuth.setBounds(600,50,150,35);

        jPanelVisionCheck.setBounds(0,0,600,400);
    }

    private void initComponents() {
        jButtonAuth = new javax.swing.JButton();
        jPanelVisionCheck = new javax.swing.JPanel();
        mainWindow = new javax.swing.JFrame();
    }

    public JPanel getjPanelVisionCheck() {
        return jPanelVisionCheck;
    }

    public JFrame getMainWindow() {
        return mainWindow;
    }

    public JButton getjButtonAuth() {
        return jButtonAuth;
    }

    private javax.swing.JPanel jPanelVisionCheck;
    private javax.swing.JFrame mainWindow;
    private javax.swing.JButton jButtonAuth;

}
