package App;

import BLL.BllMainController;

import java.sql.SQLException;

public class Main {

    public static void main(String [] args) throws SQLException {
        BllMainController bllMainController = new BllMainController();
        bllMainController.action();
//
//        Webcam webcam = null;
//        if (webcam != null) {
//            webcam.close();
//        } else {
//            webcam = Webcam.getDefault();
//            webcam.setViewSize(WebcamResolution.VGA.getSize());
//
//            WebcamPanel panel = new WebcamPanel(webcam);
//            panel.setFPSDisplayed(true);
//            panel.setDisplayDebugInfo(true);
//            panel.setImageSizeDisplayed(true);
//            panel.setMirrored(true);
//
//            JFrame window = new JFrame("Test webcam panel");
//            window.add(panel);
//            window.setResizable(true);
//            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            window.pack();
//            window.setVisible(true)
//            }
    }
}
