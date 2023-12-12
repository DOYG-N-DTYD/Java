package com.testQuickStart.DesktopSwingApp.app.GUI;

import java.awt.Dimension;
import java.security.PublicKey;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AuthorisationPanel {
	private JPanel authorisationPanel;
	private JTextField usernameField;
	private JTextField passwordField;
	private JButton connectButton;
	private JButton fetchDataButton;

	public AuthorisationPanel(){
	//  Create a panel for database connection controls on the left side
		authorisationPanel =  new JPanel();
	    //dbPanel.setLayout(new BoxLayout(dbPanel, BoxLayout.Y_AXIS));
	    //dbPanel.setPreferredSize(new Dimension(25, 10));

	    createButtons();
		addEventsToButtons();
		initAuthorisationPanel();
	}
	private void initAuthorisationPanel(){
		authorisationPanel.add(new JLabel("Database Connection"));
	    authorisationPanel.add(new JLabel("Username:"));
	    authorisationPanel.add(usernameField);
	    authorisationPanel.add(new JLabel("Password:"));
	    authorisationPanel.add(passwordField);
	    authorisationPanel.add(connectButton);
	    authorisationPanel.add(fetchDataButton);
	}

	private void createButtons(){
		Integer inputFieldsSize = 10;
		String connectButtonName = "Connect";
		String fetchButtonName = "Fetch Data";

		usernameField = new JTextField(inputFieldsSize);
		passwordField = new JTextField(inputFieldsSize);
		
	    connectButton = new JButton(connectButtonName);
	    fetchDataButton = new JButton(fetchButtonName);
	}
	private void addEventsToButtons(){
		       connectButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String username = usernameField.getText();
               String password = passwordField.getText();
               // Implement your database connection logic here
               // You can use username and password to establish a connection
               // to your database (e.g., MySQL, PostgreSQL, etc.).
           }
       });

       fetchDataButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               // Implement your data retrieval logic here
               // You can use the established database connection to fetch data
               // and display it in the table.
           }
       });
	}
}
