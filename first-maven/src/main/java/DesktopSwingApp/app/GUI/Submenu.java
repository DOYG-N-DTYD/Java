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

public class Submenu extends JMenuBar {
	JMenuBar menubar;
	
	public Submenu() {
		initSubmenu();
		//initTestSubmenu();
	}
	public JMenuBar getMenuBar() {
		return menubar;
	}
	private void initSubmenu() {
		//JFrame frame = new JFrame("Test");

		menubar = new JMenuBar();
		menubar.setMinimumSize(new Dimension(100, 30));
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
//		frame.setJMenuBar(menubar);
//		frame.setLayout(null);
//		frame.setVisible(true);
	}

//	private void initTestSubmenu() {
//		JMenu menu, submenu;
//		JMenuItem i1, i2, i3, i4, i5;
////
////		JFrame f = new JFrame("Menu and MenuItem Example");
//		menubar = new JMenuBar();
//		menu = new JMenu("Menu");
//		submenu = new JMenu("Sub Menu");
//		i1 = new JMenuItem("Item 1");
//		i2 = new JMenuItem("Item 2");
//		i3 = new JMenuItem("Item 3");
//		i4 = new JMenuItem("Item 4");
//		i5 = new JMenuItem("Item 5");
//		menu.add(i1);
//		menu.add(i2);
//		menu.add(i3);
//		submenu.add(i4);
//		submenu.add(i5);
//		menu.add(submenu);
//		menubar.add(menu);
////		frame.setJMenuBar(menubar);
////		f.setSize(400, 400);
////		f.setLayout(null);
////		f.setVisible(true);
//	}
}
