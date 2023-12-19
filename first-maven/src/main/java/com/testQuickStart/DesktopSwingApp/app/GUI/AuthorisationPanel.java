package com.testQuickStart.DesktopSwingApp.app.GUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class AuthorisationPanel {
	private JPanel authorisationPanel;
	private JTextField usernameField;
	private JTextField passwordField;
	private JButton connectButton;

	public AuthorisationPanel() {
		authorisationPanel = new JPanel();
        authorisationPanel.setLayout(new BoxLayout(authorisationPanel,BoxLayout.Y_AXIS));
		createButtons();
		addEventsToButtons();
		initAuthorisationPanel();
	}
	
	public JPanel getAuthorisationPanel() {
		return authorisationPanel;
	}

	private void initAuthorisationPanel() {
		createLoginFrame();
		//createChat();
	}

	private void createLoginFrame() {
		Integer panelWidth = 500;
        Integer panelHeight = 100 ;
        
        JPanel inputAndConnectPanel = new JPanel();
        //inputAndConnectPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		BoxLayout inputBoxLayout = new BoxLayout(inputAndConnectPanel, BoxLayout.Y_AXIS);
        inputAndConnectPanel.setLayout(inputBoxLayout);
		inputAndConnectPanel.setBorder(new TitledBorder("Database Connection"));
        inputAndConnectPanel.setMaximumSize(new Dimension(panelWidth,panelHeight));
        inputAndConnectPanel.setMinimumSize(new Dimension(panelWidth,panelHeight));
        
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setMinimumSize(new Dimension(panelWidth,panelHeight));
        inputAndConnectPanel.add(usernameLabel);
		inputAndConnectPanel.add(usernameField);
        inputAndConnectPanel.add(new JLabel("Password:"));
		inputAndConnectPanel.add(passwordField);
		inputAndConnectPanel.add(connectButton);

		authorisationPanel.add(inputAndConnectPanel);

	}

	private void createButtons() {
		Integer inputWidth = 500;
        Integer inputHeight = 22;
		String connectButtonName = "Connect";

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
				String username = usernameField.getText();
				String password = passwordField.getText();
				// Implement your database connection logic here
				// You can use username and password to establish a connection
				// to your database (e.g., MySQL, PostgreSQL, etc.).
				System.out.println(username);
				System.out.println(password);
			}
		});
	}
}
