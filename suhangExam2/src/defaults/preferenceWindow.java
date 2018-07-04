package defaults;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class preferenceWindow extends JFrame implements KeyListener {

    private JPanel contentPane;
    static preferenceWindow framen;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    framen = new preferenceWindow();
                    framen.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public preferenceWindow() {
        JTabbedPane tabbedPane = new JTabbedPane();
        setBounds(100, 100, 400, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel scanningPanel = new JPanel();
        JPanel scanning_ThreadPanel = new JPanel();
        scanning_ThreadPanel.setPreferredSize(new Dimension(350,150));
        scanningPanel.add(scanning_ThreadPanel,BorderLayout.CENTER);
        JLabel threadLable = new JLabel("Thread");
        JPanel thread_TmpPanel = new JPanel(new FlowLayout(SwingConstants.LEFT));
        thread_TmpPanel.add(threadLable);
        scanning_ThreadPanel.add(thread_TmpPanel,BorderLayout.NORTH);
        add(scanningPanel,BorderLayout.NORTH);

        JButton okButton = new JButton("Done");
        okButton.setMnemonic('D');
        okButton.setPreferredSize(new Dimension(70, 20));
        panel.add(okButton, BorderLayout.EAST);
        addKeyListener(this);

        okButton.addActionListener(e -> framen.setVisible(false));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_Y) {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_Y) {
            System.exit(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_Y) {
            System.exit(0);
        }
    }
}
