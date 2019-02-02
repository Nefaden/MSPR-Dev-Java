package IHM;

import javax.swing.*;
import java.awt.*;

public class IhmSnapshot extends IhmGenericView{

    private JButton jButtonSnapshot;
    private JPanel panel1;

    public IhmSnapshot() throws HeadlessException {
        frameInit();
    }

    public JButton getjButtonSnapshot() {
        return jButtonSnapshot;
    }
}
