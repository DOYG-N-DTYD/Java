package com.testQuickStart.DesktopSwingApp.app.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.rmi.server.LoaderHandler;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class MainFrame extends JFrame{
	private JFrame mainFrame;
	
	public MainFrame() {
		Integer minimumWidth = 300;
		Integer minimumHeight = 160;
		
		JFrame frame = new JFrame("Canvas with Database Connection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(minimumWidth, minimumHeight));
        frame.setVisible(true);
        this.mainFrame = frame; 
	}

	public void loadCanvas(Canvas canvas) {
		//Create a canvas for drawing on the right side
        mainFrame.add(canvas, BorderLayout.CENTER);
	}
	
	public void loadChat(Chat chat) {
		//Create chat
		mainFrame.add(chat.getChatPanel(),BorderLayout.WEST);
	}
	
	public void loadAuthorisationPanel(AuthorisationPanel authorisationPanel) {
		//Create log pass panel
		mainFrame.add(authorisationPanel.getAuthorisationPanel());
	}
	
	public JFrame getFrame() {
		return mainFrame;
	}
}
