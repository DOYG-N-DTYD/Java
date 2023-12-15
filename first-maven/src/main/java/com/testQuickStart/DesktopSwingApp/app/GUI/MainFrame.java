package com.testQuickStart.DesktopSwingApp.app.GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame{
	public JFrame mainFrame;
	
	public MainFrame() {
		JFrame frame = new JFrame("Canvas with Database Connection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(512, 384);
        frame.setVisible(true);
        this.mainFrame = frame;
        
	}

	public void loadCanvas(Canvas canvas) {
		//Create a canvas for drawing on the right side
        mainFrame.add(canvas, BorderLayout.CENTER);
	}
	
	public JFrame getFrame() {
		return mainFrame;
	}
}
