package com.DesktopSwingApp.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;

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

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import com.DesktopSwingApp.Database.JDBCconnectionEngine;
import com.DesktopSwingApp.FileEngine.FileEngine;
import com.DesktopSwingApp.app.GUI.*;

public class SwingDesktopApplication {

    public static void main(String[] args) throws SQLException {
    	SwingUtilities.invokeLater(() -> {
    		//MainFrame mainFrame = new MainFrame();
        });
    	FileEngine fEngine = new FileEngine();
    }
}
