package BLL;

import IHM.IhmListMaterial;

/**
 * Controller about borrowing materila by agent
 * An agent can bring many tools per visit
 * The same agent has to get them back
 *
 * Methods list :
 * 1. [public void] borrowing material
 * 2. [public void] restitute material
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

    public void borrowingMaterial() {
    }

    public void restitureMaterial() {

    }
}
