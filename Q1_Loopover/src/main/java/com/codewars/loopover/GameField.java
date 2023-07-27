package com.codewars.loopover;

import java.awt.RenderingHints.Key;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GameField {

	private String[][] gameField;
	private GameCommands gameCommands;
	private HashMap<String, Character> XYLetterHashMap;

	public GameField() {
	}

	public GameField(String[][] inDataArray) {
		this.gameField = inDataArray;
	}
	// additionaly constructor for lists ?

	public void setGameFieldWithArray(String[][] inArrayGameField) {
		this.gameField = inArrayGameField;
	}

	public void setGameCommands(GameCommands gameCommands) {
		this.gameCommands = gameCommands;
	}

	public void iterateCommands() {
		gameCommands.getArrayOfCommandsAsObjectsInList();
		for (GameSingleCommand objectSingleCommand : gameCommands.getArrayOfCommandsAsObjectsInList()) {
			changeFieldByCommands(objectSingleCommand.getActionLetter(), objectSingleCommand.getActionDigit());
		}
	}

	public void changeFieldByCommands(char actionLetter, int actionDigit) {
		switch (actionLetter) { // LO -> O ROW move LEFT in 1 position
		case 'L': // X - actionDigit
			actionL(actionDigit);
			showHashMapByXYvalues();
			break;
		case 'R': // X + actionDigit
			actionR(actionDigit);
			showHashMapByXYvalues();
			break;
		case 'U': // Y + actionDigit
			actionU(actionDigit);
			showHashMapByXYvalues();
			break;
		case 'D': // Y - actionDigit
			actionD(actionDigit);
			showHashMapByXYvalues();
			break;
		default:
			break;
		}
	}

	public void actionL(int actionForRowNumber) { // actionForRowNumber = yCONSTANT
		int sizeOfRow = gameField.length;
		Character buffCharacterValue = getKeyByValueFromHashGameField(0,actionForRowNumber);
		char oldValue;
		for (int x = 1; x < sizeOfRow; x++) {
			oldValue = getKeyByValueFromHashGameField(x,actionForRowNumber);
			putKeyByValueInHashGameField(x-1, actionForRowNumber,oldValue);
		}
		putKeyByValueInHashGameField(sizeOfRow-1, actionForRowNumber, buffCharacterValue);
	}

	public void actionR(int actionForRowNumber) {
		int sizeOfRow = gameField.length;
		Character buffCharacterValue = getKeyByValueFromHashGameField(sizeOfRow-1,actionForRowNumber);
		char oldValue;
		for (int x = sizeOfRow-1; x > 0; x--) {
			oldValue = getKeyByValueFromHashGameField(x-1,actionForRowNumber);
			System.out.println(x +"  " +oldValue);
			putKeyByValueInHashGameField(x, actionForRowNumber,oldValue);
		}
		putKeyByValueInHashGameField(0, actionForRowNumber, buffCharacterValue);
	}

	public void actionU(int actionForColumnNumber) {
		int sizeOfColumn = gameField.length;
		Character buffCharacterValue = getKeyByValueFromHashGameField(actionForColumnNumber,0);
		char oldValue;
		for (int y = 1; y < sizeOfColumn; y++) {
			oldValue = getKeyByValueFromHashGameField(actionForColumnNumber,y);
			putKeyByValueInHashGameField(actionForColumnNumber,y-1 ,oldValue);
		}
		putKeyByValueInHashGameField(actionForColumnNumber,sizeOfColumn-1, buffCharacterValue);
	}

	public void actionD(int actionForColumnNumber) {
		int sizeOfColumn = gameField.length;
		Character buffCharacterValue = getKeyByValueFromHashGameField(actionForColumnNumber,sizeOfColumn-1);
		char oldValue;
		for (int y = sizeOfColumn-1; y > 0; y--) {
			oldValue = getKeyByValueFromHashGameField(actionForColumnNumber,y-1);
			System.out.println(y +"  " +oldValue);
			putKeyByValueInHashGameField(actionForColumnNumber,y,oldValue);
		}
		putKeyByValueInHashGameField(actionForColumnNumber,0, buffCharacterValue);
	}

	public void showGameField() throws Exception {
		if (this.gameField == null) {
			System.out.println("gameBoard is empty, no data shown");
		} else {
			for (int i = 0; i < this.gameField.length; i++) {
				for (int j = 0; j < this.gameField[i].length; j++) {
					System.out.println(this.gameField[i][j]);
				}
			}
		}
	}

	public void CreateHashMapForGameField() {
		HashMap<String, Character> tempHashMap = new HashMap<>();
		for (int i = 0; i < this.gameField.length; i++) {
			for (int j = 0; j < this.gameField[i].length; j++) {
				// System.out.println(this.gameField[i][j] +" "+ "i:"+i+ "j:"+j);
				for (int idxLetter = 0; idxLetter < this.gameField[i][j].length(); idxLetter++) {
					System.out.println(this.gameField[i][j].charAt(idxLetter) + " XY: " + idxLetter + i);
					tempHashMap.put(Integer.toString(idxLetter).concat(Integer.toString(i)),
							this.gameField[i][j].charAt(idxLetter)); // String: xy Char: letter
					// При инициализации Null pointer ex. нужно создавать Temp
				}
			}
		}
		XYLetterHashMap = tempHashMap;
	}

	public void showHashMap() {
		// :D SORT BY KEY FUNNY MOVE
		for (Map.Entry<String, Character> entry : XYLetterHashMap.entrySet()) {
			String key = entry.getKey();
			Character val = entry.getValue();
			System.out.println("KEY: " + key + " VALUE: " + val);
		}
	}

	public void showHashMapByXYvalues() { // TODO Board size
		String keyString;
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				keyString = Integer.toString(x).concat(Integer.toString(y));
				System.out.print(XYLetterHashMap.get(keyString));
			}
			System.out.print("\n");
		}
		System.out.println();
	}
	
	public char getKeyByValueFromHashGameField(int x, int y) {
		System.out.println(x + " "+ y);
		return XYLetterHashMap.get(Integer.toString(x).concat(Integer.toString(y)));
	}
	public void putKeyByValueInHashGameField(int x, int y, char value) {
		XYLetterHashMap.put(Integer.toString(x).concat(Integer.toString(y)), value);
	}
}
