package com.testQuickStart.DesktopSwingApp.app.GUI;

import java.awt.Dimension;
import java.security.PublicKey;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AuthorisationPanel {
	public JPanel authorisationPanel;
	
	public AuthorisationPanel(){
	//  Create a panel for database connection controls on the left side
	    JPanel dbPanel = new JPanel();
	    //dbPanel.setLayout(new BoxLayout(dbPanel, BoxLayout.Y_AXIS));
	    //dbPanel.setPreferredSize(new Dimension(25, 10));

	    JTextField usernameField = new JTextField(10);
	    JTextField passwordField = new JTextField(10);

	    JButton connectButton = new JButton("Connect");
	    JButton fetchDataButton = new JButton("Fetch Data");

	    dbPanel.add(new JLabel("Database Connection"));
	    dbPanel.add(new JLabel("Username:"));
	    dbPanel.add(usernameField);
	    dbPanel.add(new JLabel("Password:"));
	    dbPanel.add(passwordField);
	    dbPanel.add(connectButton);
	    dbPanel.add(fetchDataButton);
	    
	    authorisationPanel = dbPanel;
	    
	}
}
