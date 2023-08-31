package OCP.book;

import java.util.ArrayList;
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
    	
    	Duckling duckling = new Duckling();
    	duckling.makeSound("Kr kr");
    	
    }
}
