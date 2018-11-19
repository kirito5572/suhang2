package defaults;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class errorWindow extends JFrame implements KeyListener {
    private JPanel contentPane;
    static errorWindow framen;
    private static int error;
    private static String errorTmp;
    /**
     * Launch the application.
     */
    public errorWindow(int error) {
        this.error = error;
        errorScreen();
    }
    public void errorScreen() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    framen = new errorWindow();
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
    public errorWindow() {
        setBounds(100, 100, 500, 150);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        panel.setLayout(new BorderLayout(0, 0));

        JButton okButton = new JButton("OK(Y)");
        okButton.setMnemonic('Y');
        okButton.setPreferredSize(new Dimension(70, 20));
        panel.add(okButton, BorderLayout.EAST);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.NORTH);

        Font myFonts = new Font("Serif", Font.BOLD, 25);

        JLabel doneLabel = new JLabel("Error");
        panel_1.add(doneLabel);
        doneLabel.setFont(myFonts);
        JPanel panel_2 = new JPanel(new GridLayout(2,1));
        contentPane.add(panel_2, BorderLayout.CENTER);

        errorTmp = errorCode.errorCode(error);

        JLabel lblAllIpScan = new JLabel("An Error Occurred");
        JPanel lblAllIpScanTmp = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel IbIAllIpScan = new JLabel("ErrorCode:" + errorTmp);
        JPanel IbIAllIpScanTmp = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblAllIpScanTmp.add(lblAllIpScan);
        panel_2.add(lblAllIpScanTmp);
        IbIAllIpScanTmp.add(IbIAllIpScan);
        panel_2.add(IbIAllIpScanTmp);
        contentPane.addKeyListener(this);
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

