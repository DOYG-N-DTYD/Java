package DesktopSwingApp.FileEngine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;

//FileEngine fe = new FileEngine();
//fe.createFile();
//fe.showFileInfo();
//fe.showMenu();
//  	getUserCommand("-rf");
//  	getUserCommand("-cf");
//  	getUserCommand("-wf");
//  	getUserCommand("--------rf");
//  	getUserCommand("-rff");
//  	getUserCommand("--rff");

//  	FileEngine fe = new FileEngine();
//  	fe.menu();

public class FileEngine {
	public FileEngine() {
		try {
			menu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showProperties() {
		Properties properties = System.getProperties();
		properties.list(System.out);
	}

	public void createFile(String _dir) {
		try {
			File file = new File(_dir + ".txt");
			file.createNewFile();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}

	public void readFile() throws FileNotFoundException {
		try {
			String lineString;
			FileReader freader = new FileReader(fileChooser());
			BufferedReader bufferedReader = new BufferedReader(freader);
			while ((lineString = bufferedReader.readLine()) != null) {
				System.out.println(lineString);
			}
			bufferedReader.close();
		} catch (Exception e) {
			System.out.println("Error, file not found");
		}
	}

	public void writeFile() {
		try {
			String lineString;
			FileWriter fWriter = new FileWriter(fileChooser());
			BufferedWriter bufferedWriter = new BufferedWriter(fWriter);
			System.out.println("Type exit for end");
			while (true) {
				if ((lineString = userInput()).toLowerCase().equals("exit")) {
					bufferedWriter.close();
					return;
				} else {
					bufferedWriter.write(lineString + "\n");
				}

			}
		} catch (Exception e) {

		}
	}

	public File fileChooser() {
		JFileChooser f = new JFileChooser();
		// f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		f.showSaveDialog(null);
		return f.getSelectedFile();
	}

	public void menu() throws Exception {
		final String dir = System.getProperty("user.dir");
		// File fileMain;
		boolean applicationWorking = true;
		showMenu();
		while (applicationWorking) {
			try {
				switch (getUserCommand(userInput())) {
				case "-cf":
					System.out.println("Creating file");
					String pathToCreateFile = fileChooser().getPath();
					System.out.println(pathToCreateFile);
					createFile(pathToCreateFile);
					break;
				case "-rf":
					System.out.println("Reading file");
					readFile();
					break;
				case "-wf":
					System.out.println("Writing file");
					writeFile();
					break;
				case "exit":
					System.out.println("EXIT, Program closed !");
					applicationWorking = false;
					break;
				default:
					System.out.println("HMM REGEXP ");
					break;
				}
				//Runtime.getRuntime().exec("clear");
				showMenu();
			} catch (Exception e) {
				// TODO: handle exception
				// clearConsole();
				// Runtime.getRuntime().exec("clear");
				System.out.println(e);
			}

		}
	}

	public void showMenu() {
		System.out.println("COMMANDS " + "\nCreate File: -cf" + "\nRead File: -rf" + "\nWriteFile -wf\n");
	}

	public String getUserCommand(String _command) throws Exception {
		String lowCommand = _command.toLowerCase();
		String regexString = "^+-?[crw]+f$"; // only one - , only one symbol from [..], only one f
		Pattern pattern = Pattern.compile(regexString);
		Matcher matcher = pattern.matcher(lowCommand);
		if (lowCommand.equals("exit")) {
			return "exit";
		} else if (matcher.find()) {
			return lowCommand;
		} else {
			throw new Exception("Unknown Command");
		}
	}

	public String userInput() {
		Scanner keyboard = new Scanner(System.in);
		String userString = keyboard.nextLine();
		return userString;
	}

//	public void showFileInfo() {
//		System.out.println("FILE NAME: " + fileMain.getName() + "\nFILE PATH: " + fileMain.getPath());
//	}
}
