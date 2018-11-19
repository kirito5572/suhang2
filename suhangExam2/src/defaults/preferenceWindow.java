package defaults;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static javafx.scene.input.KeyCode.U;
import static javax.swing.SwingConstants.*;

class preferenceWindow extends JFrame {

    static JTextField inThreadCountTextField;
    static JTextField inThreadMsTextField;
    static preferenceWindow framen;
    static JComboBox languageBox;
    /**
     * Launch the application.
     */
    static void preferenceScreen() {
        EventQueue.invokeLater(() -> {
            try {
                framen = new preferenceWindow();
                framen.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    private preferenceWindow() {
        JTabbedPane tabbedPane = new JTabbedPane();
        setBounds(100, 100, 400, 500);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel scanningPanel = new JPanel();
        JPanel scanning_ThreadPanel = new JPanel(new BorderLayout());
        scanning_ThreadPanel.setPreferredSize(new Dimension(350, 150));
        scanningPanel.add(scanning_ThreadPanel, BorderLayout.CENTER);
        JLabel threadLabel = new JLabel("Thread");
        JPanel thread_TmpPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        thread_TmpPanel.add(threadLabel);
        scanning_ThreadPanel.add(thread_TmpPanel, BorderLayout.NORTH);
        tabbedPane.add(scanningPanel,"Scanning");
        add(tabbedPane, BorderLayout.NORTH);


        JPanel displayPanel = new JPanel();
        JPanel display_LanguagePanel = new JPanel();
        display_LanguagePanel.setPreferredSize(new Dimension(350,150));
        scanningPanel.add(display_LanguagePanel,BorderLayout.CENTER);
        JLabel languageLabel = new JLabel("Language");
        JPanel language_TmpPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        language_TmpPanel.add(languageLabel);
        display_LanguagePanel.add(language_TmpPanel,BorderLayout.NORTH);
        displayPanel.add(display_LanguagePanel);
        tabbedPane.add(displayPanel,"Display");

        JPanel scanning_ThreadPanelTmp = new JPanel();


        JPanel inThreadCountPanel = new JPanel();
        JLabel inThreadCountLabel = new JLabel("Maximum number of thread:");
        inThreadCountLabel.setPreferredSize(new Dimension(250,25));
        inThreadCountTextField = new JTextField(5);
        inThreadCountPanel.add(inThreadCountLabel);
        inThreadCountPanel.add(inThreadCountTextField);
        scanning_ThreadPanelTmp.add(inThreadCountPanel);

        JPanel inThreadMsPanel = new JPanel();
        JLabel inThreadMsLabel = new JLabel("Delay between starting threads(in ms)");
        inThreadMsLabel.setPreferredSize(new Dimension(250,25));
        inThreadMsTextField = new JTextField(5);
        inThreadMsPanel.add(inThreadMsLabel);
        inThreadMsPanel.add(inThreadMsTextField);
        scanning_ThreadPanelTmp.add(inThreadMsPanel);

        scanning_ThreadPanel.add(scanning_ThreadPanelTmp, BorderLayout.CENTER);
        JPanel setLanguagePanel = new JPanel();
        JLabel setLanguageLabel = new JLabel("Language");
        setLanguageLabel.setPreferredSize(new Dimension(200, 25));
        languageBox = new JComboBox();
        String addItemStringTmp = null;
        languageBox.addItem(addItemStringTmp);
        languageBox.addItem("English");
        languageBox.setSelectedIndex(1);
        setLanguagePanel.add(inThreadCountLabel);
        setLanguagePanel.add(languageBox);
        display_LanguagePanel.add(setLanguagePanel);

        languageBox.addActionListener(new LanguageChangeClass());

        JButton okButton = new JButton("Done");
        okButton.setMnemonic('D');
        okButton.setPreferredSize(new Dimension(70, 20));
        panel.add(okButton, BorderLayout.EAST);

        inThreadCountTextField.setText(Integer.toString(PingOutline.ThreadCount));
        inThreadMsTextField.setText(Integer.toString(PingOutline.BetweenThreadMs));
        okButton.addActionListener(e -> {
            try {
                PingOutline.ThreadCount = Integer.parseInt(inThreadCountTextField.getText());
                PingOutline.BetweenThreadMs = Integer.parseInt(inThreadMsTextField.getText());
                framen.setVisible(false);
            } catch (Exception e5) {
                new errorWindow(501);
            }
        });

        contentPane.addKeyListener(new preferenceWindowKeyEvent());
        okButton.addKeyListener(new preferenceWindowKeyEvent());
        inThreadCountTextField.addKeyListener(new preferenceWindowKeyEvent());
        inThreadMsTextField.addKeyListener(new preferenceWindowKeyEvent());
    }
}
