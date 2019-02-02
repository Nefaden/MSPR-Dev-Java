package BLL;

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

import java.sql.SQLException;

public class BllMainController extends BllGenericController {

    public BllMainController(BllMainController bllMainController) {
        super(bllMainController);

        BllSnapshot bllSnapshot = null;
        BllFaceChecking bllFaceChecking = null;
        BllBorrowingMaterial bllBorrowingMaterial = null;


        //public void action {
            if (bllSnapshot == null) {
                bllSnapshot = new BllSnapshot(this);
            }
            bllSnapshot.getView().setVisible(true);
            bllSnapshot.getView().setEnabled(true);
        }
    }

