import java.security.PublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.function.IntPredicate;

public class App {
	public static void main(String[] args) {
		String[] inArrayOfWords = {"abode", "abC"};
		//initAlphabet();
		int[] outTestArray =  arrayOfAcceptedPositions(inArrayOfWords);
		
		for (Integer i : outTestArray) {
			System.out.println(i);
		}
	}
	
	//Разбиваем на слова
	public static int[] arrayOfAcceptedPositions(String[] inArray) {
		int[] outArrayOfAcceptedPositions = new int[inArray.length];
		int index = 0;
		for (String word : inArray) {
			outArrayOfAcceptedPositions[index] = checkWord(word, initAlphabet());
			index++;
		}
		return outArrayOfAcceptedPositions;	
	}
	// Проверяем в каждом слове буквы в HashMap если индексы совпадают то увеличиваем счётчик
	public static int checkWord(String inWord, HashMap<Character, Integer> alphabetAscii) {
		int counterOfGoodPositionOfLetters = 0;
		inWord = inWord.toUpperCase();
		for (int i = 0; i< inWord.length(); i++) {
			//System.out.println(alphabetAscii.get(inWord.charAt(i)) - 65 +" "+ inWord.charAt(i) + " " + i);
			if((alphabetAscii.get(inWord.charAt(i)) - 65) == i) counterOfGoodPositionOfLetters++;
		}
		return counterOfGoodPositionOfLetters;
	}
	//Таблица ascii
	public static HashMap<Character, Integer> initAlphabet() {
		HashMap<Character, Integer> alphabetAsciiHashMap = new HashMap<>();
		for (int i = 65; i < 91; i++) {
			alphabetAsciiHashMap.put((char)i, i);
			//System.out.println((char)i + " " + i);
		}
		return alphabetAsciiHashMap;
	}
}

/*
 * Consider the word "abode". We can see that the letter a is in position 1 and
 * b is in position 2. In the alphabet, a and b are also in positions 1 and 2.
 * Notice also that d and e in abode occupy the positions they would occupy in
 * the alphabet, which are positions 4 and 5.
 * 
 * Given an array of words, return an array of the number of letters that occupy
 * their positions in the alphabet for each word. For example,
 * 
 * solve(["abode","ABc","xyzD"]) = [4, 3, 1]
 */



