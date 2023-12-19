package com.testQuickStart.DesktopSwingApp.app;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.testQuickStart.DesktopSwingApp.app.GUI.*;

public class SwingDesktopApplication {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    public static void createAndShowGUI() {
        
        //MainFrame applicationFrame = new MainFrame(); 
        //applicationFrame.loadCanvas(new Canvas());
        //applicationFrame.mainFrame.add((new AuthorisationPanel()).getAuthorisationPanel(),BorderLayout.WEST);
        
        //applicationFrame.loadChat(new Chat());
        //applicationFrame.add();
    	
    	MainFrame mainFrame = new MainFrame();
    	mainFrame.loadChat(new Chat());
    	//mainFrame.loadCanvas(new Canvas());
    }

}
