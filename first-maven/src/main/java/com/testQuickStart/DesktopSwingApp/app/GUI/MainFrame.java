package com.testQuickStart.DesktopSwingApp.app.GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame {
	private JFrame mainFrame;
	
	public MainFrame() {
		JFrame frame = new JFrame("Canvas with Database Connection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(800, 600);
        frame.setVisible(true);
        mainFrame = frame;
	}

	public void loadCanvas(Canvas canvas) {
		//Create a canvas for drawing on the right side
        mainFrame.add(canvas, BorderLayout.CENTER);
	}
}
