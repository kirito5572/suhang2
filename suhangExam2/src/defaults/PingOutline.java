package defaults;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;

public class PingOutline extends JFrame {

	private String[] titles;
	private Object[][] stats;
	private int fixedIPStartlast;
	private int fixedIPEndlast;
	private int fixedIPStartrd;
	private int fixedIPEndrd;

	public PingOutline() {
		super("Network Scanner");

		// myIP and myHostname
		String myIP;
		String myHostname;

		InetAddress ia = null;
		try {
			ia = InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		myIP = ia.getHostAddress();
		myHostname = ia.getHostName();

		String fixedIP = myIP.substring(0, myIP.lastIndexOf(".") + 1);
		// menu begin
		JMenuBar menuBar = new JMenuBar();

		setJMenuBar(menuBar);

		JMenu scanMenu = new JMenu("Scan");
		JMenu gotoMenu = new JMenu("Goto");
		JMenu cmdMenu = new JMenu("Command");
		JMenu favoriteMenu = new JMenu("Favorite");
		JMenu toolsMenu = new JMenu("Tools");
		JMenu helpMenu = new JMenu("Help");

		menuBar.add(scanMenu);
		menuBar.add(gotoMenu);
		menuBar.add(cmdMenu);
		menuBar.add(favoriteMenu);
		menuBar.add(toolsMenu);
		menuBar.add(helpMenu);

		JMenuItem loadFromFileAction = new JMenuItem("Load From File");
		JMenuItem exportAllAction = new JMenuItem("Export All");
		JMenuItem exportSelectioAction = new JMenuItem("Export Selection");
		JMenuItem quitAction = new JMenuItem("Quit");

		scanMenu.add(loadFromFileAction);
		scanMenu.add(exportAllAction);
		scanMenu.add(exportSelectioAction);
		scanMenu.addSeparator();
		scanMenu.add(quitAction);

		JMenuItem nextAliveHostAction = new JMenuItem("next alive host");
		JMenuItem nextOpenPortAction = new JMenuItem("next open port");
		JMenuItem nextDeadHostAction = new JMenuItem("next dead host");
		JMenuItem previousAliveHostAction = new JMenuItem("previous alive host");
		JMenuItem previousOpenPortAction = new JMenuItem("previous open port");
		JMenuItem previousDeadHostAction = new JMenuItem("previous dead host");
		JMenuItem findAction = new JMenuItem("Find");

		gotoMenu.add(nextAliveHostAction);
		gotoMenu.add(nextOpenPortAction);
		gotoMenu.add(nextDeadHostAction);
		gotoMenu.addSeparator();
		gotoMenu.add(previousAliveHostAction);
		gotoMenu.add(previousOpenPortAction);
		gotoMenu.add(previousDeadHostAction);
		gotoMenu.addSeparator();
		gotoMenu.add(findAction);

		JMenuItem showDetailsAction = new JMenuItem("Show details");
		JMenuItem rescanIpAction = new JMenuItem("Rescan IP");
		JMenuItem deleteIpAction = new JMenuItem("Delete IP");
		JMenuItem copyIpAction = new JMenuItem("Copy IP");
		JMenuItem copyDetailsAction = new JMenuItem("Copy details");
		JMenuItem openAction = new JMenuItem("Open");

		cmdMenu.add(showDetailsAction);
		cmdMenu.addSeparator();
		cmdMenu.add(rescanIpAction);
		cmdMenu.add(deleteIpAction);
		cmdMenu.addSeparator();
		cmdMenu.add(copyIpAction);
		cmdMenu.add(copyDetailsAction);
		cmdMenu.addSeparator();
		cmdMenu.add(openAction);

		JMenuItem addCurrentAction = new JMenuItem("Add current");
		JMenuItem manageFavoriteAction = new JMenuItem("Manage Favorite");

		favoriteMenu.add(addCurrentAction);
		favoriteMenu.add(manageFavoriteAction);

		JMenuItem preferenceAction = new JMenuItem("Preference");
		JMenuItem fetchersAction = new JMenuItem("Fetchers");
		JMenuItem selectionAction = new JMenuItem("Selection");
		JMenuItem scanStaticsAction = new JMenuItem("Scan statics");

		toolsMenu.add(preferenceAction);
		toolsMenu.add(fetchersAction);
		toolsMenu.addSeparator();
		toolsMenu.add(selectionAction);
		toolsMenu.add(scanStaticsAction);

		JMenuItem gettingStartedAction = new JMenuItem("Getting started");
		JMenuItem officialWebsiteAction = new JMenuItem("Official Website");
		JMenuItem faqAction = new JMenuItem("FAQ");
		JMenuItem reportAnIssueAction = new JMenuItem("Report an issue");
		JMenuItem pluginsAction = new JMenuItem("plug-ins");
		JMenuItem commandLineUsageAction = new JMenuItem("command-line usage");
		JMenuItem checkfornewversionAction = new JMenuItem("Check for new version");
		JMenuItem aboutAction = new JMenuItem("About");

		helpMenu.add(gettingStartedAction);
		helpMenu.addSeparator();
		helpMenu.add(officialWebsiteAction);
		helpMenu.add(faqAction);
		helpMenu.add(reportAnIssueAction);
		helpMenu.add(pluginsAction);
		helpMenu.addSeparator();
		helpMenu.add(commandLineUsageAction);
		helpMenu.add(checkfornewversionAction);
		helpMenu.addSeparator();
		helpMenu.add(aboutAction);

		// menu end

		// Toolbar begin
		Font myFont = new Font("Serif", Font.BOLD, 16);
		JToolBar toolbar1 = new JToolBar();
		toolbar1.setLayout(new FlowLayout(FlowLayout.LEFT, 4, 2));
		JToolBar toolbar2 = new JToolBar();
		toolbar2.setLayout(new FlowLayout(FlowLayout.LEFT, 4, 2));

		JLabel ipRangeLabel = new JLabel("IP Range:");
		JTextField ipStartTF = new JTextField(10);
		JLabel toLabel = new JLabel("to");
		JTextField ipEndTF = new JTextField(10);
		JComboBox sourceSelectionComboBox = new JComboBox();
		sourceSelectionComboBox.addItem("IP Range");
		sourceSelectionComboBox.addItem("Random");
		sourceSelectionComboBox.addItem("File");
		ipRangeLabel.setFont(myFont);
		toLabel.setFont(myFont);
		ipRangeLabel.setPreferredSize(new Dimension(75, 30));
		toLabel.setPreferredSize(new Dimension(13, 30));
		sourceSelectionComboBox.setPreferredSize(new Dimension(80, 22));

		toolbar1.add(ipRangeLabel);
		toolbar1.add(ipStartTF);
		toolbar1.add(toLabel);
		toolbar1.add(ipEndTF);
		toolbar1.add(sourceSelectionComboBox);

		JLabel hostNameLabel = new JLabel("Hostname:");
		JTextField hostNameTF = new JTextField(myHostname, 10);
		JButton ipButton = new JButton("IP");
		JComboBox ipSelectionComboBox = new JComboBox();
		ipSelectionComboBox.addItem("Netmask");
		ipSelectionComboBox.addItem("/24");
		ipSelectionComboBox.addItem("/16");
		ImageIcon originIcon = new ImageIcon(System.getProperty("user.dir") + "\\src\\Start-icon.png");
		Image originImg = originIcon.getImage();
		Image changedImg = originImg.getScaledInstance(12, 12, Image.SCALE_SMOOTH);
		ImageIcon startIcon = new ImageIcon(changedImg);
		JButton startButton = new JButton(startIcon);
		startButton.setText(" START");
		ImageIcon originIcon2 = new ImageIcon(System.getProperty("user.dir") + "\\src\\Stop-icon.png");
		Image originImg2 = originIcon2.getImage();
		Image changedImg2 = originImg2.getScaledInstance(12, 12, Image.SCALE_SMOOTH);
		ImageIcon stopIcon = new ImageIcon(changedImg2);
		JButton stopButton = new JButton(stopIcon);
		stopButton.setText(" STOP");
		hostNameLabel.setFont(myFont);
		hostNameLabel.setPreferredSize(new Dimension(75, 30));
		ipButton.setPreferredSize(new Dimension(40, 22));
		ipSelectionComboBox.setPreferredSize(new Dimension(86, 22));
		startButton.setPreferredSize(new Dimension(82, 22));
		stopButton.setPreferredSize(new Dimension(82, 22));
		toolbar2.add(hostNameLabel);
		toolbar2.add(hostNameTF);
		toolbar2.add(ipButton);
		toolbar2.add(ipSelectionComboBox);
		toolbar2.add(startButton);

		JPanel pane = new JPanel(new BorderLayout());
		pane.add(toolbar1, BorderLayout.NORTH);
		pane.add(toolbar2, BorderLayout.SOUTH);

		getContentPane().add(pane, BorderLayout.NORTH);
		// Toolbar end

		// Table begin

		titles = new String[] { "IP", "Ping", "TTL", "Hostname", "Ports" };
		stats = initializeTable();

		JTable jTable = new JTable(stats, titles);

		JScrollPane jScrollPane = new JScrollPane(jTable);
		add(jScrollPane, BorderLayout.CENTER);

		// Table end

		// status bar begin

		JPanel statusmainPanel = new JPanel();
		JPanel statusPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		statusPanel1.setPreferredSize(new Dimension(160, 20));
		JPanel statusPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		statusPanel2.setPreferredSize(new Dimension(60, 20));
		JPanel statusPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		statusPanel3.setPreferredSize(new Dimension(60, 20));
		statusPanel1.setBorder(new BevelBorder(BevelBorder.LOWERED));
		statusPanel2.setBorder(new BevelBorder(BevelBorder.LOWERED));
		statusPanel3.setBorder(new BevelBorder(BevelBorder.LOWERED));
		getContentPane().add(statusmainPanel, BorderLayout.SOUTH);
		JLabel currentStatusLabel = new JLabel("Ready");
		JLabel displayStatusLabel = new JLabel("Display: All");
		JLabel threadStatusLabel = new JLabel("Threads:0");
		statusPanel1.add(currentStatusLabel);
		statusPanel2.add(displayStatusLabel);
		statusPanel3.add(threadStatusLabel);
		statusmainPanel.setLayout(new BoxLayout(statusmainPanel, BoxLayout.X_AXIS));
		statusmainPanel.add(statusPanel1);
		statusmainPanel.add(statusPanel2);
		statusmainPanel.add(statusPanel3);
		JProgressBar progressBar = new JProgressBar();
		progressBar.setPreferredSize(new Dimension(150, 20));
		statusmainPanel.add(progressBar);
		progressBar.setIndeterminate(false);

		// status bar end
		quitAction.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String tmp = null;
				fixedIPStartlast = Integer
						.parseInt(ipStartTF.getText().substring(ipStartTF.getText().lastIndexOf(".") + 1));
				tmp = ipStartTF.getText().substring(0,ipStartTF.getText().lastIndexOf("."));
				fixedIPStartrd = Integer.parseInt(tmp.substring(tmp.lastIndexOf(".") + 1));
				tmp = ipEndTF.getText().substring(0,ipEndTF.getText().lastIndexOf("."));
				fixedIPEndrd = Integer.parseInt(tmp.substring(tmp.lastIndexOf(".") + 1));
				fixedIPEndlast = Integer.parseInt(ipEndTF.getText().substring(ipEndTF.getText().lastIndexOf(".") + 1));
				System.out.println(tmp + "," + fixedIPStartrd + fixedIPStartlast + "," + fixedIPEndrd + fixedIPEndlast);
				progressBar.setIndeterminate(true);
				toolbar2.remove(startButton);
				toolbar2.add(stopButton);
				currentStatusLabel.setText("Running");
				jTable.repaint();
				statusmainPanel.repaint();

				//ping, TTL, Hostname Thread start
				
				new Thread(() -> {
					
						Pinging[] pg = new Pinging[fixedIPEndlast];
						for (int i = fixedIPStartlast; i < fixedIPEndlast; i++) {
							Object[] msg = stats[i];
							pg[i] = new Pinging(fixedIP +(i), msg);
							pg[i].start();
						}
						while (Thread.activeCount() > 3) {
							try {
								Thread.sleep(200);
								jTable.repaint();
								threadStatusLabel.setText("Threads: " + (Thread.activeCount()-3));
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					//Ports Thread start
					new Thread(() -> {
						for (int i = fixedIPStartlast; i < fixedIPEndlast; i++) {
							if (stats[i][1] != "[n/a]" || stats[i][2] != "[n/s]" || stats[i][3] != "[n/s]") {
								PortScanner ps = new PortScanner();
								final ExecutorService es = Executors.newFixedThreadPool(500);
								final int timeout = 200;
								final List<Future<ScanResult>> futures = new ArrayList<>();
								
								for (int port = 1; port <= 1024; port++) {
									futures.add(ps.portIsOpen(es, fixedIP + i, port, timeout));
								}
								try {
									es.awaitTermination(200L, TimeUnit.MICROSECONDS);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							
								int openPorts = 0;
								for (final Future<ScanResult> f : futures) {
									try {
										if (f.get().isOpen()) {
											openPorts++;
											stats[i][4] = (stats[i][4] == null)?f.get().getPort(): (stats[i][4].toString() + "," +f.get().getPort());
											jTable.repaint();
										}
									} catch (InterruptedException | ExecutionException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							} else {
								stats[i][4] = "[n/s]";
								jTable.repaint();
							}
							if(stats[i][4] == null) {
								stats[i][4] = "Nothing";
							}
						}
					}).start();
					
					//Ports Thread end
					
				jTable.repaint();
				
				progressBar.setIndeterminate(false);
				toolbar2.remove(stopButton);
				toolbar2.add(startButton);
				currentStatusLabel.setText("Ready");
				jTable.repaint();
				
				}).start();
				
				//ping, TTL, Hostname Thread end	
			}
		});
		stopButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == stopButton) {
					progressBar.setIndeterminate(false);
					toolbar2.remove(stopButton);
					toolbar2.add(startButton);
					currentStatusLabel.setText("Ready");
					jTable.repaint();
				}
			}
		});
		ipStartTF.setText(fixedIP + 0);
		fixedIPStartlast = Integer.parseInt(ipStartTF.getText().substring(ipStartTF.getText().lastIndexOf(".") + 1));
		ipEndTF.setText(fixedIP + 254);
		fixedIPEndlast = Integer.parseInt(ipEndTF.getText().substring(ipEndTF.getText().lastIndexOf(".") + 1));
		hostNameTF.setText(myHostname);
		setSize(700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private Object[][] initializeTable() {
		Object[][] results = new Object[254][titles.length];
		return results;
	}

	private Object[][] getPingStats(String string) {
		Object[][] results = new Object[254][titles.length];
		for (int i = 0; i < 254; i++) {
			results[i][0] = string + (i + 1);
			results[i][1] = "[n/a]";
			results[i][2] = "[n/s]";
			results[i][3] = "[n/s]";
			results[i][4] = "[n/s]";
		}
		return results;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PingOutline po = new PingOutline();
	}

}