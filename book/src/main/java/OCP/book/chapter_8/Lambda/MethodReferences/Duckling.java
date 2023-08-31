package OCP.book.chapter_8.Lambda.MethodReferences;

public class Duckling {
	public static void makeSound(String sound) {
		//LearnToSpeak learner = s -> System.out.println(s);
		LearnToSpeak learner = System.out::println;
		DuckHelper.teacher(sound, learner);
	}
}
