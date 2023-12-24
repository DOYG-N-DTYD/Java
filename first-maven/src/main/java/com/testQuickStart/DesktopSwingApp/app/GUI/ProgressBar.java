package com.testQuickStart.DesktopSwingApp.app.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ProgressBar extends JFrame{
    static JFrame progressBarFrame;
    static JProgressBar progressBar;
 
    private Thread threadToServe;
    private Thread progressBarThread ;
    
    public ProgressBar(String progresBarNameString, Thread servedThread)
    {
    	initProgressBarFrame(progresBarNameString);
    	this.threadToServe = servedThread;
    	runProgressBarInThread();
    }
    
    private void initProgressBarFrame(String progresBarNameString) {
    	Integer progresBarWidthInteger = 500;
    	Integer progresBarHeightInteger = 70;
    	progressBarFrame = new JFrame(progresBarNameString);
    	progressBarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel progresBarPanel = new JPanel();
        progressBar = new JProgressBar();
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBarFrame.add(progressBar);
        progressBarFrame.add(progressBar);
        progressBarFrame.setSize(progresBarWidthInteger, progresBarHeightInteger);
        progressBarFrame.setVisible(true);
    }
    
	private  void runProgressBarInThread() {
		
		Runnable progresBarRunnable = () -> {
			int i = 0;
	        try {
	            while (i <= 99) {
	                // fill the menu bar
	            	progressBar.setValue(i);
	 
	                // delay the thread
	            	progressBarThread.sleep(200);
	                i += 1;
	                // if connected and served thread ended then notify
	                if (!threadToServe.isAlive()) {
						System.out.println("THREAD INTERRUPTED");
						progressBar.setValue(100);
						
						System.gc();
						progressBarFrame.dispose();
						progressBarThread.interrupt();
					}
	            }
	        }
	        catch (Exception e) {
	        }
		};
		progressBarThread = new Thread(progresBarRunnable);
		progressBarThread.start();	
	}
	
}
