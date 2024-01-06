package DesktopSwingApp.app.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Submenu extends JPanel {
	public Submenu(){
		initSubmenu();
	}
	
	private void initSubmenu() {
		JFrame frame = new JFrame("Test");
		frame.setLayout(new BorderLayout());
		frame.setMinimumSize(new Dimension(200,200));
		JMenuBar menubar = new JMenuBar();
		menubar.setMinimumSize(new Dimension(100,30));
		ImageIcon iconNew = new ImageIcon("new.png");
		JMenu file = new JMenu("File");
		
		JMenuItem fileNew = new JMenuItem("New", iconNew);
		fileNew.setMnemonic(KeyEvent.VK_N);
		
		JMenuItem fileRead = new JMenuItem("Read", iconNew);
		fileRead.setMnemonic(KeyEvent.VK_R);
		
		JMenuItem fileSave = new JMenuItem("Save", iconNew);
		fileNew.setMnemonic(KeyEvent.VK_S);
		
		file.add(fileNew);
		file.add(fileRead);
		file.add(fileSave);
		
		menubar.add(file);
		frame.add(menubar);
		frame.setVisible(true);
	}
}
