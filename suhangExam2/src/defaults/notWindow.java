package defaults;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class notWindow extends JFrame implements KeyListener {

	private JPanel contentPane;
	static notWindow framen;
	/**
	 * Launch the application.
	 */
	public static void notScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					framen = new notWindow();
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
	public notWindow() {
		setBounds(100, 100, 300, 150);
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
		
		JLabel doneLabel = new JLabel("Sorry");
		panel_1.add(doneLabel);
		doneLabel.setFont(myFonts);
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		
		JLabel lblAllIpScan = new JLabel("This feature is not implemented yet.");
		panel_2.add(lblAllIpScan);
		contentPane.addKeyListener(this);
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				framen.setVisible(false);
			}
		});
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