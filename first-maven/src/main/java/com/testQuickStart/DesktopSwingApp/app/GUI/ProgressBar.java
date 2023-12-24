package com.testQuickStart.DesktopSwingApp.app.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ProgressBar extends JFrame{

	// create a frame
    static JFrame progressBarFrame;
 
    static JProgressBar progressBar;
 
    public ProgressBar()
    {
    	
        // create a frame
    	progressBarFrame = new JFrame("ProgressBar demo");
 
        // create a panel
        JPanel progresBarPanel = new JPanel();
 
        // create a progressbar
        progressBar = new JProgressBar();
 
        // set initial value
        progressBar.setValue(0);
 
        progressBar.setStringPainted(true);
 
        // add progressbar
        progressBarFrame.add(progressBar);
 
        // add panel
        progressBarFrame.add(progressBar);
 
        // set the size of the frame
        progressBarFrame.setSize(500, 70);
        progressBarFrame.setVisible(true);
 
    }
    
    //public static void runProgressBarInThread() {}
    
	public void runProgressBarInThread() {
		
		Runnable progresBaRunnable = () -> {
			int i = 0;
	        try {
	            while (i <= 100) {
	                // fill the menu bar
	            	progressBar.setValue(i);
	 
	                // delay the thread
	                Thread.sleep(200);
	                i += 1;
	            }
	        }
	        catch (Exception e) {
	        }
		};
		Thread progressBarThread = new Thread(progresBaRunnable);
		progressBarThread.start();	
	}
	
}
