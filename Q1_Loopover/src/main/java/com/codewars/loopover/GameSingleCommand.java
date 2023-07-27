package com.codewars.loopover;

public class GameSingleCommand {
	private char actionLetter;
	private int actionDigit;
	
	public GameSingleCommand(char actionLetter, int actionDigit) {
		this.actionLetter = actionLetter;
		this.actionDigit = actionDigit;
	}
	public char getActionLetter() {
		return actionLetter;
	}
	public void setActionLetter(char actionLetter) {
		this.actionLetter = actionLetter;
	}
	public int getActionDigit() {
		return actionDigit;
	}
	public void setActionDigit(int actionDigit) {
		this.actionDigit = actionDigit;
	}
	
	
}
