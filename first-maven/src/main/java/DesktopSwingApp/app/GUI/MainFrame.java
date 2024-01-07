package DesktopSwingApp.app.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame{
	private Authorisation authorisation;
	private JFrame mainFrame;

	public MainFrame() {
		notifyFrame();
	}
//	public MainFrame() {
//		Integer minimumWidth = 500;
//		Integer minimumHeight = 160;
//		JFrame frame = new JFrame("Canvas with Database Connection");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(new BorderLayout());
//        frame.setMinimumSize(new Dimension(minimumWidth, minimumHeight));
//        frame.setVisible(true);
//        this.mainFrame = frame;
//        loadAuthorisationPanel(new Authorisation());
//		//submenu();
//	}
	public void loadSubmenu(Submenu submenu) {
		mainFrame.add(submenu, BorderLayout.NORTH);
	}
	
	public void loadCanvas(Canvas canvas) {
		//Create a canvas for drawing on the right side
		mainFrame.add(canvas, BorderLayout.CENTER);
	}
	
	public void loadChat(Chat chat) {
		//Create chat
		mainFrame.add(chat.getChatPanel(),BorderLayout.WEST);
	}
	
	public void loadAuthorisationPanel(Authorisation authPanel) {
		//Create log pass panel
		authPanel.setMainFrame(this);
		authorisation = authPanel;
		mainFrame.add(authorisation.getAuthorisationPanel());
	}
	
	public void notifyFrame() {
		// TODO open in new frame, close old authorisation panel
		System.out.println("Authorisation panel notified !!!");
		System.out.println("All threads are finished for loading main frame, loading main...");
		//authorisation.getAuthorisationPanel().setVisible(true);
		//mainFrame.dispose();
		JFrame frame = new JFrame("Canvas with Database Connection");
		Submenu submenu = new Submenu();
		frame.setJMenuBar(submenu.getMenuBar());
		
		Integer frameWidthInteger = 800;
		Integer frameHeightInteger = 600;
		frame.setMinimumSize(new Dimension(frameWidthInteger,frameHeightInteger));
		frame.setLayout(new BorderLayout());
		frame.add((new Chat(frameWidthInteger,frameHeightInteger)).getChatPanel(),BorderLayout.WEST);
		frame.add(new Canvas(),BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	public JFrame getFrame() {
		return this;
	}
	
	public Authorisation getAuthorisation() {
		return authorisation;
	}
}
