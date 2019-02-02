package BLL;

import IHM.IhmGenericView;

/**
 * ihmGenericView
 * Main model for all controller
 * Need to be import in others controllers to be fully used
 *
 * @version 0.1
 * @author ydurand
 */
abstract class BllGenericController {

    protected IhmGenericView view = null;
    private BllMainController bllMainController;

    // Constructeur du controller générique
    protected BllGenericController (BllMainController bllMainController) {
        this.bllMainController = bllMainController;
    }

    /**
     *
     * @return view : Getter de la view Générique
     */
    public IhmGenericView getView() {
        return view;
    }

    /**
     *
     * @param view : la view Générique lié au controller
     */
    public void setView(IhmGenericView view) {
        this.view = view;
    }

    /**
     *
     * @return CtrlPrincipal : Getter du controller principal
     */
    public BllMainController getMainController() {
        return bllMainController;
    }

    /**
     *
     * @param bllMainController : Setter du controller principal
     */
    public void setMainController(BllMainController bllMainController) {
        this.bllMainController = bllMainController;
    }

}