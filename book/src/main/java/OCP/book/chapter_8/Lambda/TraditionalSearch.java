package OCP.book.chapter_8.Lambda;

import java.security.PublicKey;
import java.util.*;

public class TraditionalSearch {

	public static void search() {
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("fish",false,true));
		animals.add(new Animal("rabbit",true,false));
		//print(animals, new CheckIfHooper());
		//print(animals, a -> a.canHoop());
		print(animals, a -> a.canSwim());	// (Animal a) -> {return a.canSwim;}
	}
	private static void print(List<Animal> animals, CheckTrait cheker) {
		for (Animal animal : animals) {
			if(cheker.test(animal)) {
				System.out.println(animal + " ");
			}
		}
	}
}
