package com.codewars.loopover;

import java.util.Iterator;
import java.util.function.BiConsumer;

import com.codewars.loopover.GameField;
public class App {
	public static void main(String[] args) throws Exception {
		String[][] testInArray = {{"ABC"},{"DEF"},{"GHI"}};
		GameField gameField = new GameField();
		gameField.setGameFieldWithArray(testInArray);

		String[] commandStrings = {"U0","U1","U2","D0","D1","D2","R0","R1","R2","L0","L1","L2"};
		GameCommands gameCommands = new GameCommands(commandStrings);
		gameField.setGameCommands(gameCommands);
		//GF.getCommandsAndParse(GC.getArrayOfCommandsStrings());
		gameField.CreateHashMapForGameField();
		//gameField.showHashMap(); // Sorted by key, bad presentation
		//gameField.showHashMapByXYvalues();
		
		//CHANGES
		gameField.showHashMapByXYvalues();
		gameField.iterateCommands();
	}	
}
