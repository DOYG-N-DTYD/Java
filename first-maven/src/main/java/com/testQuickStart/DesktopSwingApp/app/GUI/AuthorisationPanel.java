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
		createChat();
        createLoginFrame();
	    }
    private void createLoginFrame(){
        //create login pass area
        JPanel inputAndConnectPanel = new JPanel();
        inputAndConnectPanel.setLayout(new BoxLayout(inputAndConnectPanel, BoxLayout.Y_AXIS));
        
        inputAndConnectPanel.setSize(400,400); //TODO

        inputAndConnectPanel.setBorder(new TitledBorder("Database Connection"));
        // as single component added w/no constraint, will be centered
        inputAndConnectPanel.add(new JLabel("Username:"));
        inputAndConnectPanel.add(usernameField);
        inputAndConnectPanel.add(new JLabel("Password:"));
        inputAndConnectPanel.add(passwordField);
        inputAndConnectPanel.add(connectButton);
        authorisationPanel.add(inputAndConnectPanel);
        
    }

    private void createChat(){
        //Create chat in mainFrame with send button
        authorisationPanel.setBorder(new TitledBorder("Authorisation Panel"));;
		BorderLayout bordeLayout = new BorderLayout();
        JPanel elementsBorderLayout = new JPanel(bordeLayout);
        elementsBorderLayout.setBorder(new TitledBorder("Chat"));
        
        JTextArea textArea = new JTextArea(10,25);
        elementsBorderLayout.add(textArea);
        
        JButton sendButton = new JButton("Send");
        elementsBorderLayout.add(sendButton,BorderLayout.SOUTH);
        authorisationPanel.add(elementsBorderLayout, BorderLayout.SOUTH);
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
	}
}
