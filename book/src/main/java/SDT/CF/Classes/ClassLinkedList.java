package SDT.CF.Classes;

import java.util.LinkedList;

import OCP.book.chapter_8.Lambda.Animal;

public class ClassLinkedList<P> {
	private LinkedList<P> testLinkedList= new LinkedList<P>();	
	
	public ClassLinkedList(){}
	
	public LinkedList getLinkedList() {
		return testLinkedList;
	};
	public void setLinkedList(LinkedList<P> testLinkedList) {
		this.testLinkedList = testLinkedList;
	};

}
//
//ClassLinkedList<Animal> classLinkedListAnimals = new ClassLinkedList<Animal>();
//LinkedList<Animal> tempLinkedList = classLinkedListAnimals.getLinkedList();
//tempLinkedList.add(new Animal("fish",false,true));
//tempLinkedList.add(new Animal("rabbit",true,false));
//classLinkedListAnimals.setLinkedList(tempLinkedList);
//System.out.println(classLinkedListAnimals.getLinkedList().toString());


//LinkedList<String> testLinkedList = new LinkedList<String>();
//testLinkedList.addFirst("A");
//testLinkedList.addLast("F");
//testLinkedList.addFirst("H");
//testLinkedList.addLast("H");
//System.out.println(testLinkedList.toString());
//System.out.println(testLinkedList.removeLastOccurrence("H"));
//System.out.println(testLinkedList.toString());