package OCP.book.chapterLambdas8;

import java.security.PublicKey;
import java.util.*;

public class TraditionalSearch {

	public static void search() {
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("fish",false,true));
		animals.add(new Animal("rabbit",true,false));
		print(animals, new CheckIfHooper());
	}
	private static void print(List<Animal> animals, CheckTrait cheker) {
		for (Animal animal : animals) {
			if(cheker.test(animal)) {
				System.out.println(animal + " ");
			}
		}
	}
}
