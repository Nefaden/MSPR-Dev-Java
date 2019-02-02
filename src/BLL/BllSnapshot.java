package BLL;

/**
 * This controller manage the webcam to take photo (helped by the IHM IhmSnapshot)
 * List of methods :
 *
 * 1. [public void or boolean] take picture
 * 2. [public void] switch to Face checking
 */

import IHM.IhmSnapshot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class BllSnapshot extends BllGenericController implements ActionListener, WindowListener {

    protected BllSnapshot(BllMainController bllMainController) {
        super(bllMainController);
        this.view = new IhmSnapshot();

    }

    public IhmSnapshot getView() {
        return(IhmSnapshot) view;
    }

    public void takePicture() {

    }

    public void faceChecking() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
