package BLL;

import java.sql.SQLException;

public class BllMainController extends BllGenericController {

    public BllMainController(BllMainController bllMainController) {
        super(bllMainController);

        BllSnapshot bllSnapshot = null;
        BllFaceChecking bllFaceChecking = null;
        BllBorrowingMaterial bllBorrowingMaterial = null;


        public void action {
            if (bllSnapshot == null) {
                bllSnapshot = new BllSnapshot(this);
            }
            //bllSnapshot.getView().setVisible(true);
            //bllSnapshot.getView().setEnabled(true);
        }
    }
}
