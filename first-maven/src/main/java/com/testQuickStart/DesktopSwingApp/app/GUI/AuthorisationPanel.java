package com.testQuickStart.DesktopSwingApp.app.GUI;

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
	private JTextField messageTextField;
	private JTextArea chatTextArea;
	private JButton connectButton;
	private JButton sendButton;
	private JScrollPane scroll;
    private JPanel elementsBorderLayout;

	private Stack<String> chatStack;

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
		createChat();
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
		inputAndConnectPanel.add(new JLabel("Username:"));
		inputAndConnectPanel.add(usernameField);
		inputAndConnectPanel.add(new JLabel("Password:"));
		inputAndConnectPanel.add(passwordField);
		inputAndConnectPanel.add(connectButton);

		authorisationPanel.add(inputAndConnectPanel);

	}

	private void createChat() {

		authorisationPanel.setBorder(new TitledBorder("Main Panel"));

		elementsBorderLayout = new JPanel();
		elementsBorderLayout.setLayout(new BoxLayout(elementsBorderLayout, BoxLayout.Y_AXIS));
        elementsBorderLayout.setBorder(new TitledBorder("Chat"));

		chatTextArea = new JTextArea(10, 25);
		scroll = new JScrollPane(chatTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		chatTextArea.setEditable(true);
		elementsBorderLayout.add(scroll);
		sendButton = new JButton("Send");
		messageTextField = new JTextField(1);
		chatStack = new Stack<String>();

		addEventClickSend();
        createChatControls();

        authorisationPanel.add(elementsBorderLayout);
	}

	private void createChatControls() {
		Integer inputWidth = 600;
        Integer inputHeight = 22;

        JPanel chatControlsPanel = new JPanel();
        //chatControlsPanel.setBorder(new TitledBorder("Chat controls"));
        chatControlsPanel.setMinimumSize(new Dimension(inputWidth,inputHeight));
		chatControlsPanel.setLayout(new BoxLayout(chatControlsPanel ,BoxLayout.Y_AXIS));
		messageTextField.setMaximumSize(new Dimension(inputWidth, inputHeight));
        chatControlsPanel.add(messageTextField);
		chatControlsPanel.add(sendButton);
		
        elementsBorderLayout.add(chatControlsPanel);
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

	private void addEventClickSend() {
		sendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
		for (int j = 0; j < 20 - chatStack.size(); j++) {
			formattedMessageToString.append("\n");
		}
		for (int i = 0; i < chatStack.size(); i++) {
			StringBuilder chatMsg = new StringBuilder();
			if (chatStack.size() >= 20) {
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
