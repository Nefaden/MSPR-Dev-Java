package BLL;

import java.sql.SQLException;

/**
 * Main controller who manage all actions between others controllers and view (IHM)
 * Got a main method "actions" who orchestrate the user's travel in this app
 * Main controller is assist by an abstract class "EnumAction" ou enumerate all possible action in the app
 *
 * List of methods :
 *
 * 1. [public void] action
 *
 * @version 0.1
 * @author ydurand
 */

public class BllMainController {

    private BllSnapshot bllSnapshot = null;
    private BllFaceChecking bllFaceChecking = null;
    private BllBorrowingMaterial bllBorrowingMaterial = null;

    /**
     * action par défaut action au démarrage de l'application
     */
    public void action() throws SQLException {
        if (bllSnapshot == null) {
            bllSnapshot = new BllSnapshot(this);
        }
        bllSnapshot.getView().setEnabled(true);
        bllSnapshot.getView().setVisible(true);
    }

    public void action(EnumAction action) throws SQLException {
        switch (action) {
            /*case ACCESS_GRANTED:
                accessGranted();
                break;*/
            case DISPLAY_LIST_MATERIAL:
                displayMaterials();
                break;
            /*case BORROWING_MATERIAL:
                borrowMaterial();
            case RESTITUTE_MATERIAL:
                restituteMaterail();
                break;*/
            case DISCONNECT:
                disconnect();
                break;
        }
    }

    /*private void  accessGranted() throws SQLException {
        if (bllBorrowingMaterial == null) {
            bllBorrowingMaterial = new BllBorrowingMaterial();
        }
        bllSnapshot.getView().setEnabled(false);
        bllSnapshot.getView().setVisible(false);
        bllBorrowingMaterial.getView().setVisible(true);
        bllBorrowingMaterial.getView().setEnabled(true);
    }*/

    private void displayMaterials() {
        if (bllBorrowingMaterial == null) {
            bllBorrowingMaterial = new BllBorrowingMaterial();
        }
        bllSnapshot.getView().setEnabled(false);
        bllSnapshot.getView().setVisible(false);
        bllBorrowingMaterial.getView().setVisible(true);
        bllBorrowingMaterial.getView().setEnabled(true);
    }

    private void disconnect() throws SQLException {
        /*try {
            Jdbc.getInstance().deconnecter();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "CtrlPrincipal - fermeture connexion BD", JOptionPane.ERROR_MESSAGE);
        } finally {*/
            System.exit(0);
        }
    }


