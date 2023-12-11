package com.testQuickStart.DesktopSwingApp.app;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.testQuickStart.DesktopSwingApp.app.GUI.*;

public class SwingDesktopApplication {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        
        MainFrame applicationFrame = new MainFrame(); 
        applicationFrame.loadCanvas(new Canvas());
       
        
        // Create a table for displaying database data
//        DefaultTableModel tableModel = new DefaultTableModel();
//        JTable table = new JTable(tableModel);
//        JScrollPane tableScrollPane = new JScrollPane(table);
//        tableScrollPane.setPreferredSize(new Dimension(100, 100));
//        frame.add(tableScrollPane, BorderLayout.SOUTH);
//
//        connectButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String username = usernameField.getText();
//                String password = passwordField.getText();
//                // Implement your database connection logic here
//                // You can use username and password to establish a connection
//                // to your database (e.g., MySQL, PostgreSQL, etc.).
//            }
//        });
//
//        fetchDataButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Implement your data retrieval logic here
//                // You can use the established database connection to fetch data
//                // and display it in the table.
//            }
//        });
    }

}
