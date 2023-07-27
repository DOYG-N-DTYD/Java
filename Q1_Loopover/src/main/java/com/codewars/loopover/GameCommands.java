package com.codewars.loopover;

import java.util.ArrayList;
import java.util.List;

public class GameCommands {
	private String[] arrayOfCommandsStrings;
	private ArrayList<GameSingleCommand> commandsAsObjectsInArray;
	
	public GameCommands(String[] arrayOfCommandsStrings) {
		this.arrayOfCommandsStrings = arrayOfCommandsStrings;
		initializeArrayByCommandsAsObject();
	}

	public void initializeArrayByCommandsAsObject() {
		ArrayList<GameSingleCommand> tempGSC = new ArrayList<>();
		for (String command : arrayOfCommandsStrings) {
			char actionLetter = command.charAt(0); 
			int actionDigit = Character.getNumericValue(command.charAt(1));
			tempGSC.add(new GameSingleCommand(actionLetter, actionDigit));
			//commandsAsObjectsInArray.add(new GameSingleCommand(actionLetter, actionDigit));
		}
		commandsAsObjectsInArray = tempGSC;
	}
	
	public String[] getListOfCommandsStrings() {
		return arrayOfCommandsStrings;
	}

	public List<GameSingleCommand> getArrayOfCommandsAsObjectsInList() {
		return commandsAsObjectsInArray;
	}
	
	public void setListOfCommandsStrings(String[] arrayOfCommandsStrings) {
		this.arrayOfCommandsStrings = arrayOfCommandsStrings;
	}

	public void showCommands() {
		for (String stringCommand : arrayOfCommandsStrings) {
			System.out.println(stringCommand);
		}
	}
}
