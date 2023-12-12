package com.testQuickStart.DesktopSwingApp.app.GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class AuthorisationPanel {
	private JPanel authorisationPanel;
	private JTextField usernameField;
	private JTextField passwordField;
	private JButton connectButton;
	private JButton fetchDataButton;
	private GroupLayout layout;
	
	public AuthorisationPanel(){
	//  Create a panel for database connection controls on the left side
		authorisationPanel =  new JPanel(new BorderLayout(10,0));	
		//authorisationPanel.setLayout(new BoxLayout(authorisationPanel, BoxLayout.Y_AXIS));
		//authorisationPanel.setLayout(new GroupLayout(authorisationPanel));
	    //dbPanel.setPreferredSize(new Dimension(25, 10));
	    createButtons();
		addEventsToButtons();
		initAuthorisationPanel();

	}
	public JPanel getAuthorisationPanel() {
		return authorisationPanel;
	}
	private void initAuthorisationPanel(){
		authorisationPanel.setBorder(new TitledBorder("MainFrameLayout"));;
		CardLayout cardLayout = new CardLayout(150,1);
        JPanel cards = new JPanel(cardLayout);
        cards.setBorder(new TitledBorder("CardLayout"));
        
        JTextArea textArea = new JTextArea(50,50);	//TODO
        cards.add(textArea);
        
        authorisationPanel.add(cards);
        
        JPanel lineStart = new JPanel();
        lineStart.setLayout(new GridBagLayout());
        lineStart.setBorder(new TitledBorder("GridBagLayout"));
        // will appear on the left, in a LTR text orientation locale
        authorisationPanel.add(lineStart, BorderLayout.LINE_START);
        
        
        JPanel inputAndConnectPanel = new JPanel();
        inputAndConnectPanel.setLayout(new BoxLayout(inputAndConnectPanel, BoxLayout.Y_AXIS));
        inputAndConnectPanel.setBorder(new TitledBorder("Database Connection"));
        // as single component added w/no constraint, will be centered
        inputAndConnectPanel.add(new JLabel("Username:"));
        inputAndConnectPanel.add(usernameField);
        inputAndConnectPanel.add(new JLabel("Password:"));
        inputAndConnectPanel.add(passwordField);
        inputAndConnectPanel.add(connectButton);
        lineStart.add(inputAndConnectPanel); 
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
