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
		// Create a panel for database connection controls on the left side
		authorisationPanel = new JPanel(new BorderLayout(15, 0));
		// authorisationPanel.setLayout(new BoxLayout(authorisationPanel,
		// BoxLayout.Y_AXIS));
		// authorisationPanel.setLayout(new GroupLayout(authorisationPanel));
		// dbPanel.setPreferredSize(new Dimension(25, 10));
		createButtons();
		addEventsToButtons();
		initAuthorisationPanel();

	}

	public JPanel getAuthorisationPanel() {
		return authorisationPanel;
	}

	private void initAuthorisationPanel() {
		createChat();
		createLoginFrame();
	}

	private void createLoginFrame() {
		// create login pass area
		JPanel inputAndConnectPanel = new JPanel();
		inputAndConnectPanel.setLayout(new BoxLayout(inputAndConnectPanel, BoxLayout.Y_AXIS));

		inputAndConnectPanel.setSize(400, 400); // TODO

		inputAndConnectPanel.setBorder(new TitledBorder("Database Connection"));
		// as single component added w/no constraint, will be centered
		inputAndConnectPanel.add(new JLabel("Username:"));
		inputAndConnectPanel.add(usernameField);
		inputAndConnectPanel.add(new JLabel("Password:"));
		inputAndConnectPanel.add(passwordField);
		inputAndConnectPanel.add(connectButton);

		messageTextField = new JTextField(1);
		inputAndConnectPanel.add(messageTextField);
		// TODO add sending after send click
		addEventClickSend();

		authorisationPanel.add(inputAndConnectPanel);

	}

	// panel.setLayout(new FlowLayout());
	// JTextArea tArea = new JTextArea(10,10);
	// JScrollPane scrollPane = new JScrollPane(tArea);
	// panel.add(scrollPane);
	// frame.setContentPane(panel);
	// frame.setSize(500, 500);
	// frame.setLocationByPlatform(true);
	// frame.setVisible(true);

	private void createChat() {
		// Create chat in mainFrame with send button
		authorisationPanel.setBorder(new TitledBorder("Authorisation Panel"));
		;
		BorderLayout bordeLayout = new BorderLayout();
		JPanel elementsBorderLayout = new JPanel(new FlowLayout());// bordeLayout);
		elementsBorderLayout.setBorder(new TitledBorder("Chat"));

		chatTextArea = new JTextArea(10, 25);
		scroll = new JScrollPane(chatTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		chatTextArea.setEditable(true);

		// userMessageTextArea = new JTextArea(1,25);
		// elementsBorderLayout.add(chatTextArea);
		elementsBorderLayout.add(scroll);
		// elementsBorderLayout.add(userMessageTextArea);

		sendButton = new JButton("Send");
		elementsBorderLayout.add(sendButton, BorderLayout.SOUTH);
		authorisationPanel.add(elementsBorderLayout, BorderLayout.SOUTH);

		chatStack = new Stack<String>(); // TODO:
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
	}
}
