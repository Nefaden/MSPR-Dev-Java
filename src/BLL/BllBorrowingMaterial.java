package BLL;

import BO.BoMaterial;
import DAL.DalMaterial;
import IHM.IhmListMaterial;

import java.sql.SQLException;

/**
 * Controller about borrowing materila by agent
 * An agent can bring many tools per visit
 * The same agent has to get them back
 *
 * Methods list :
 * 1. [public int] borrowing material
 * 2. [public boolean] isAvailable
 *
 * @version 0.1
 * @author ydurand
 */

public class BllBorrowingMaterial extends BllGenericController{

    private static final BllMainController bllMainController = new BllMainController();

    public BllBorrowingMaterial() {
        super(bllMainController);
        this.view = new IhmListMaterial();
    }

    public IhmListMaterial getView() {
        return(IhmListMaterial) view;
    }

    public int borrowingMaterial(int idMaterial) throws SQLException {
        BoMaterial objMaterial = DalMaterial.getOneById(idMaterial);
        int actualAmount = objMaterial.getI_MaxAmount() - 1;
        return actualAmount;
    }

    public boolean isAvailable(int idMaterial) throws SQLException {
        BoMaterial objMaterial = DalMaterial.getOneById(idMaterial);
        Boolean response = false;
        if (objMaterial.getI_MaxAmount() - borrowingMaterial(idMaterial) > 0) {
            response = true;
        }
        return response;
    }
}
