package DesktopSwingApp.app.GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

public class ChatShortcuts implements KeyListener {
	// ctrl + enter -> send message
	// ctrl + insert + enter -> send message
	// ctrl + del + enter-> clear message


	// com1 | null | com3
	// com1 | com2 | com3

	// com1 |- shift ---|- enter
	// |- insert
	// |- del

	// |- ctrl ----|- del

	private Stack shortcutsStack;
	private String reflectionMethodNameString;

	public ChatShortcuts() {
		// TODO Auto-generated constructor stub
		shortcutsStack = new Stack();
		reflectionMethodNameString = "";
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (		e.getKeyCode() == KeyEvent.VK_CONTROL
				|| 	e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_I
				|| 	e.getKeyCode() == KeyEvent.VK_ENTER) {
			
			System.out.println(shortcutsStack);	
			if (shortcutsStack.empty()) {
				shortcutsStack.add(e.getKeyCode());
			} else {
				if ((Integer) shortcutsStack.peek() != e.getKeyCode()) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_ENTER:
						runShortcuts();
						break;
					default:
						shortcutsStack.add(e.getKeyCode());
						System.out.println(reflectionMethodNameString);
						break;
					}
				}
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void runShortcuts() {
		while (!shortcutsStack.empty()) {
			switch ((Integer) shortcutsStack.firstElement()) {
			case KeyEvent.VK_SHIFT:
				reflectionMethodNameString += "shift";
				break;
			case KeyEvent.VK_CONTROL:
				reflectionMethodNameString += "control";
				break;
			case KeyEvent.VK_I:
				reflectionMethodNameString += "Insert";
				break;
			case KeyEvent.VK_D:
				reflectionMethodNameString += "Del";
				break;
			}

		}
		reflectionMethodNameString += "EnterShortcut";
		shortcutsStack.clear();
	}

	private void shiftEnterShortcut() {

	}

	private void shiftInsertEnterShortcut() {

	}

	private void shiftDelEnterShortcut() {

	}

	private void controlDelEnterShortcut() {

	}

}
