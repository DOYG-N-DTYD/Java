package com.testQuickStart.DesktopSwingApp.app.GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class MainFrame{
	private JFrame mainFrame;
	
	public MainFrame() {
		Integer mainFrameWidth = 800;
		Integer mainFrameHeight = 600;
		
		JFrame frame = new JFrame("Canvas with Database Connection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(mainFrameWidth, mainFrameHeight);
        frame.setVisible(true);
        this.mainFrame = frame; 
	}

	public void loadCanvas(Canvas canvas) {
		//Create a canvas for drawing on the right side
        mainFrame.add(canvas, BorderLayout.CENTER);
	}
	
	public void loadChat(Chat chat) {
		//Create chat
		mainFrame.add(chat.getChatPanel(), BorderLayout.CENTER);
	}
	
	public JFrame getFrame() {
		return mainFrame;
	}
}
