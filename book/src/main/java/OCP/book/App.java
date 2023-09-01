package OCP.book;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import OCP.book.chapter_8.Lambda.Animal;
import OCP.book.chapter_8.Lambda.CheckIfHooper;
import OCP.book.chapter_8.Lambda.CheckTrait;
import OCP.book.chapter_8.Lambda.TraditionalSearch;
import OCP.book.chapter_8.Lambda.MethodReferences.Duckling;

public class App 
{
    public static void main( String[] args )
    {
    	//TraditionalSearch.search();
    	
//    	Duckling duckling = new Duckling();
//    	duckling.makeSound("Kr kr");
    	
    	ArrayList<String> humansNameStrings = new ArrayList<>();
    	humansNameStrings.add("Jack");
    	humansNameStrings.add("Bob");
    	humansNameStrings.add("Jimmy");
    	humansNameStrings.removeIf(n -> n.startsWith("J"));
    	for (String name : humansNameStrings) {
			System.out.println(name);
		}
    }
}