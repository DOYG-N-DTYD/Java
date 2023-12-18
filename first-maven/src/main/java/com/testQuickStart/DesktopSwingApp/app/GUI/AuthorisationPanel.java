package com.testQuickStart.DesktopSwingApp.app.GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.util.Iterator;
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
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class AuthorisationPanel {
	private JPanel authorisationPanel;
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField messageTextField;
	private JTextArea chatTextArea;
	private JTextArea userMessageTextArea;
	private JButton connectButton;
	private JButton fetchDataButton;
	private JButton sendButton;
	private GroupLayout layout;
	private JScrollPane scroll;

	private Stack<String> chatStack;

	public AuthorisationPanel() {
		authorisationPanel = new JPanel(new BorderLayout(30, 30));

		createButtons();
		addEventsToButtons();
		initAuthorisationPanel();
	}
	
	public JPanel getAuthorisationPanel() {
		return authorisationPanel;
	}

	private void initAuthorisationPanel() {
		createLoginFrame();
		createChat();
		//createChatControls(); 
		//TODO: problem with chat controls 
	}

	private void createLoginFrame() {
		JPanel inputAndConnectPanel = new JPanel();
		inputAndConnectPanel.setLayout(new BoxLayout(inputAndConnectPanel, BoxLayout.Y_AXIS));
		inputAndConnectPanel.setBorder(new TitledBorder("Database Connection"));
		inputAndConnectPanel.add(new JLabel("Username:"));
		inputAndConnectPanel.add(usernameField);
		inputAndConnectPanel.add(new JLabel("Password:"));
		inputAndConnectPanel.add(passwordField);
		inputAndConnectPanel.add(connectButton);

		authorisationPanel.add(inputAndConnectPanel);

	}

	private void createChat() {

		authorisationPanel.setBorder(new TitledBorder("Authorisation Panel"));
		BorderLayout bordeLayout = new BorderLayout();
		JPanel elementsBorderLayout = new JPanel(new FlowLayout());// bordeLayout);
		elementsBorderLayout.setBorder(new TitledBorder("Chat"));

		chatTextArea = new JTextArea(10, 25);
		scroll = new JScrollPane(chatTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		chatTextArea.setEditable(true);
		elementsBorderLayout.add(scroll);

		sendButton = new JButton("Send");
		//elementsBorderLayout.add(sendButton, BorderLayout.SOUTH);
		authorisationPanel.add(elementsBorderLayout, BorderLayout.SOUTH);

		messageTextField = new JTextField(1);
		//elementsBorderLayout.add(messageTextField);
		
		chatStack = new Stack<String>();
		addEventClickSend();
	}

	private void createChatControls() {
		JPanel chatControlsPanel = new JPanel();
		chatControlsPanel.setLayout(new BoxLayout(chatControlsPanel ,BoxLayout.Y_AXIS));
		chatControlsPanel.add(messageTextField);
		chatControlsPanel.add(sendButton);
		authorisationPanel.add(chatControlsPanel);
	}
	
	private void createButtons() {
		Integer inputFieldsSize = 10;
		String connectButtonName = "Connect";
		String fetchButtonName = "Fetch Data";

		usernameField = new JTextField(inputFieldsSize);
		passwordField = new JTextField(inputFieldsSize);

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

	private void addEventClickSend() {
		// TODO: place for message
		sendButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO if chat stack < 10 add from bottom
				if (messageTextField.getText().length() == 0) {
					System.out.println("Empty msg");
				} else {
					addMessageToStack();
					displayMessagesFromStackInChat();
				}
			}
		});
	}

	private void addMessageToStack() {
		chatStack.add(messageTextField.getText());
	}

	private void displayMessagesFromStackInChat() {
		StringBuilder formattedMessageToString = new StringBuilder();
		for (int j = 0; j < 10 - chatStack.size(); j++) {
			formattedMessageToString.append("\n");
		}
		for (int i = 0; i < chatStack.size(); i++) {
			StringBuilder chatMsg = new StringBuilder();
			if (chatStack.size() >= 10) {
				chatMsg.append("\n" + chatStack.get(i));
			} else if (chatStack.size() == 1) {
				chatMsg.append(chatStack.get(i));
			}else{
				chatMsg.append("\n"+chatStack.get(i));
			}
			formattedMessageToString.append(chatMsg.toString());
		}
		chatTextArea.setText(formattedMessageToString.toString());
		messageTextField.setText("");
	}
}
