package DesktopSwingApp.app.GUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Chat extends Component{
	
	private JPanel chatPanel;
	private JTextArea chatTextArea;
	private JScrollPane scrollPane;
	private JButton sendButton;
	private JTextField messageTextField;
	private Stack<String> chatStack;
 	
	private Integer parentFrameWidth;
	private Integer parentFrameHeight;
	
	private Integer inputWidth = 600;
	private Integer inputHeight = 22;
	
	public Chat(Integer _parentFrameWidth, Integer _parentFrameHeight) {
		// TODO: constructor
		parentFrameWidth = _parentFrameWidth;
		parentFrameHeight = _parentFrameHeight;
		chatStack = new Stack<String>();
		createChatGUI();
	}
	
	public JPanel getChatPanel() {
		return chatPanel;
	}
	
	private void createChatGUI() {
		createChatPanel();
        createTextArea();
        createChatControls();
		addEventClickSend(); 
	}

	private void createChatPanel() {
		chatPanel = new JPanel();
		chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));
        chatPanel.setBorder(new TitledBorder("Chat"));
	}
	
	private void createTextArea() {
		chatTextArea = new JTextArea(10, 25);
		scrollPane = new JScrollPane(chatTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		chatTextArea.setEditable(true);
		chatPanel.add(scrollPane);
	}
	
	private void createChatControls() {
        JPanel chatControlsPanel = new JPanel();
        
        sendButton = new JButton("Send");
        messageTextField = new JTextField(1);
        chatControlsPanel.setMinimumSize(new Dimension(inputWidth,inputHeight));
		chatControlsPanel.setLayout(new BoxLayout(chatControlsPanel ,BoxLayout.Y_AXIS));
		messageTextField.setMaximumSize(new Dimension(inputWidth, inputHeight));
        chatControlsPanel.add(messageTextField);
		chatControlsPanel.add(sendButton);
		
        chatPanel.add(chatControlsPanel);
	}
	
	private void addEventClickSend() {
		sendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (messageTextField.getText().length() == 0) {
					System.out.println("Empty msg"); //TODO: empy message alert to user && in user information panel
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
		Integer chatRows = Math.round( (float) (parentFrameHeight / 18.75));
		for (int j = 0; j < chatRows - chatStack.size(); j++) { // 800, 600 -> 32 rows
			// TODO: depends on app window size
			formattedMessageToString.append("\n");
		}
		for (int i = 0; i < chatStack.size(); i++) {
			StringBuilder chatMsg = new StringBuilder();
			if (chatStack.size() >= chatRows) {
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
