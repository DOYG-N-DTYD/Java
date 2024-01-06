package DesktopSwingApp.app.GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Stack;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.border.TitledBorder;

import DesktopSwingApp.Database.JDBCconnectionEngine;
import DesktopSwingApp.Database.MysqlConnectionEngine;
import DesktopSwingApp.app.SwingDesktopApplication;

public class Authorisation {
	private MainFrame mainFrame;
	
	private JPanel authorisationPanel;
	private JTextField usernameField;
	private JTextField passwordField;
	private JButton connectButton;

	private Integer panelWidth = 500;
	private Integer panelHeight = 300;

	private Integer inputWidth = 300;
	private Integer inputHeight = 22;
	private String connectButtonName = "Connect";

	private String usernameLabelString = "Username:";
	private String passwordLabelString = "Password:";

	private JComboBox databaseChoise;

	public Authorisation() {
		//mainFrame = frame;
		authorisationPanel = new JPanel();
		authorisationPanel.setLayout(new BoxLayout(authorisationPanel, BoxLayout.Y_AXIS));
		authorisationPanel.setMinimumSize(new Dimension(panelWidth, panelHeight));
		createButtons();
		addEventsToButtons();
		initAuthorisationPanel();
	}

	public JPanel getAuthorisationPanel() {
		return authorisationPanel;
	}

	private void initAuthorisationPanel() {
		createLoginFrame();
	}

	private void createLoginFrame() {
		JPanel inputAndConnectPanel = new JPanel();
		BoxLayout inputBoxLayout = new BoxLayout(inputAndConnectPanel, BoxLayout.Y_AXIS);
		inputAndConnectPanel.setLayout(inputBoxLayout);
		inputAndConnectPanel.setBorder(new TitledBorder("Database Connection"));
		inputAndConnectPanel.setMaximumSize(new Dimension(panelWidth, panelHeight));
		inputAndConnectPanel.setMinimumSize(new Dimension(panelWidth, panelHeight));

		JLabel usernameLabel = new JLabel(usernameLabelString);
		usernameLabel.setMinimumSize(new Dimension(panelWidth, panelHeight));
		usernameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

		inputAndConnectPanel.add(usernameLabel);

		usernameField.setAlignmentX(Component.LEFT_ALIGNMENT);
		inputAndConnectPanel.add(usernameField);

		inputAndConnectPanel.add(new JLabel(passwordLabelString));
		passwordField.setAlignmentX(Component.LEFT_ALIGNMENT);
		inputAndConnectPanel.add(passwordField);

		connectButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		inputAndConnectPanel.add(connectButton);

		JPanel connectAndChangeDB = new JPanel() {
			public Dimension getPreferredSize() {
				Dimension size = super.getPreferredSize();
				size.width += 100;// extraWindowWidth;
				return size;
			}
		};

		connectAndChangeDB.add(connectButton);
		String[] elementsOfComboBox = { "postgresql", "mysql" };
		databaseChoise = new JComboBox<String>(elementsOfComboBox);
		connectAndChangeDB.add(databaseChoise);
		inputAndConnectPanel.add(connectAndChangeDB);

		authorisationPanel.add(inputAndConnectPanel);
	}

	private void createButtons() {
		usernameField = new JTextField();
		usernameField.setMaximumSize(new Dimension(inputWidth, inputHeight));
		usernameField.setMinimumSize(new Dimension(inputWidth, inputHeight));
		passwordField = new JTextField();
		passwordField.setMaximumSize(new Dimension(inputWidth, inputHeight));
		passwordField.setMinimumSize(new Dimension(inputWidth, inputHeight));
		connectButton = new JButton(connectButtonName);
	}

	private void addEventsToButtons() {
		connectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: regexp Email, Pass
				// hash pass
				// 2 factor verification
				// forgot password
				String username = "mzdev_moderator"; 
						//usernameField.getText();
				String password = "stone11051996";
						//passwordField.getText();
				// JOptionPane.showMessageDialog(null, "This is even shorter");
				checkCredentials(username, password);
			}
		});
	}

	private void checkCredentials(String userEmail, String password) {
		String regex = "^(.+)@(.+)$"; // check email
		Pattern patternForEmail = Pattern.compile(regex);
		Matcher matchEmail = patternForEmail.matcher(userEmail);
		// TODO
		// if (matchEmail.matches()) {
		try {
			connectDB(userEmail, password);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
		// }else{
		// JOptionPane.showMessageDialog(null, "Email must be example@example.example");
		// }
	}

	private void connectDB(String emailString, String passwordString) throws SQLException {
		String dbType = databaseChoise.getSelectedItem().toString();
		System.out.println("databaseChoise.getSelectedIndex() = " + databaseChoise.getSelectedIndex());
		switch (databaseChoise.getSelectedIndex()) {
		case 0: // postgres
			System.out.println("TODO postges");
			// posgresConnectionEngine();
			break;
		case 1: // mysql
			connectMYSQL(emailString,passwordString);
			break;
		}
	}

	private void loadingFrameWhileDBconnection() {
		// TODO:
		JFrame loadingFrame = new JFrame("mysql database connection");

		ImageIcon loading = new ImageIcon("ajax-loader.gif");
		loadingFrame.add(new JLabel("Setting mysql database connection... ", loading, JLabel.CENTER));

		loadingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loadingFrame.setSize(panelWidth, panelHeight);
		loadingFrame.setVisible(true);
	}
	
	
	
	public void enableAuthorisationPanel() {
		Component[] AuthPanelComponents = authorisationPanel.getComponents();
		for (Component AuthPanelcomponent : AuthPanelComponents) {
			AuthPanelcomponent.setEnabled(true);
		}
	}
	public void disableAuthorisationPanel() {
		Component[] AuthPanelComponents = authorisationPanel.getComponents();
		for (Component AuthPanelcomponent : AuthPanelComponents) {
			AuthPanelcomponent.setEnabled(false);
		}
	}
	private void connectMYSQL(String emailString, String passwordString) {

		MysqlConnectionEngine mce = new MysqlConnectionEngine(emailString, passwordString);
		authorisationPanel.setVisible(false);
		mce.runConnectionInthread(mainFrame);
		// TODO block before future success connection (Wait untill thread finish)
		//authorisationPanel.setVisible(true);
		
		// TODO alert about success/false
	}
	
	public void setMainFrame(MainFrame frame) {
		this.mainFrame = frame;
	}
}
