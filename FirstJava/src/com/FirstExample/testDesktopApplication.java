package com.FirstExample;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.*;

public class testDesktopApplication {
	JLabel jlab;
	
	testDesktopApplication() {
		JFrame jfrm = new JFrame("First swing application");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(300, 300);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setVisible(true);
		JButton jbtnAlpha = new JButton("Alpha 1");
		JButton jbtnBeta = new JButton("Beta 2");
		jbtnAlpha.addActionListener((ae) -> jlab.setText("ALPHA"));
		jbtnBeta.addActionListener((ae) -> jlab.setText("BETA"));

		jfrm.add(jbtnAlpha);
		jfrm.add(jbtnBeta);
		jlab = new JLabel("Press Button");
		jfrm.add(jlab);
		
		JCheckBox jcheckbox1 = new JCheckBox("CheckBox1"); 
		jfrm.add(jcheckbox1);
		jcheckbox1.addActionListener((ae)->jlab.setText(new Boolean(jcheckbox1.isSelected()).toString()));
		
		JRadioButton jradiobutton1 = new JRadioButton("RadioButton1");
		jfrm.add(jradiobutton1);
		jradiobutton1.addActionListener((ae)->jlab.setText(new Boolean(jradiobutton1.isSelected()).toString()));

		//Interesting if use previous construction println 2times / WHY ?
		String days[] = {"aaa","bbb","ccc"};
		JList list = new JList(days);
		jfrm.add(list);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				if (!evt.getValueIsAdjusting()) {
					System.out.println(list.getSelectedValue());
				}
			}
		});
		//list.addListSelectionListener((ae)->System.out.println(list.getSelectedValue()));
		
		JPasswordField jpf1 = new JPasswordField(16);
		jpf1.setBounds(100,100,100,30);
		jpf1.addActionListener((ae)->System.out.println(jpf1.getText()));
		jfrm.add(jpf1);
		
		JComboBox jcb1 = new JComboBox(days);
		jcb1.addActionListener((ae)->System.out.println(jcb1.getSelectedItem()));
		jfrm.add(jcb1);
		
		JTextField jtxf1 = new JTextField(16);
		jtxf1.addActionListener((ae)->System.out.println(jtxf1.getText()));
		jtxf1.setBounds(100,100,100,30);
		jfrm.add(jtxf1);
		
		JTextArea jtxa1 = new JTextArea(5,5);
		jtxa1.addCaretListener((ae)->System.out.println(jtxa1.getText()));
		jtxa1.setBounds(100,100,100,30);
		jfrm.add(jtxa1);
		
		JFileChooser jfch1 = new JFileChooser();
		jfch1.showOpenDialog(null);
		//if (jfch1 == JFileChooser.APPROVE_OPTION) {
			File file = jfch1.getSelectedFile();
		//}
			System.out.println(file);
			
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new testDesktopApplication();
			}
		});
	}
	
	public static void test() throws IOException {
		Socket socket = new Socket();
		ServerSocket serverSocket = new ServerSocket();
	}
}
