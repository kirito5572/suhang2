package defaults;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class preferenceWindowKeyEvent implements KeyListener {
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_D) {
            try {
                PingOutline.ThreadCount = Integer.parseInt(preferenceWindow.inThreadCountTextField.getText());
                preferenceWindow.framen.setVisible(false);
            } catch (Exception e5) {
                new errorWindow(501);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_D) {
            try {
                PingOutline.ThreadCount = Integer.parseInt(preferenceWindow.inThreadCountTextField.getText());
                preferenceWindow.framen.setVisible(false);
            } catch (Exception e5) {
                new errorWindow(501);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_D) {
            try {
                PingOutline.ThreadCount = Integer.parseInt(preferenceWindow.inThreadCountTextField.getText());
                preferenceWindow.framen.setVisible(false);
            } catch (Exception e5) {
                new errorWindow(501);
            }
        }
    }
}
