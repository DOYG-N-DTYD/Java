package OCP.book.chapter_9.Collections;

import java.util.ArrayList;

public class ListLesson<A,U> {
// List (interface) <---------implements |
//										 |<--------- ArrayList 	(class)
//										 |<--------- Vector		(class)
//										 |<--------- Stack		(class)
//										 |<--------- LinkedList	(class)	----------> implements ----------> DeQueuee (Interface)
	private A dataA;// = new ArrayList<>();
	private U dataU;
	

	public ListLesson(A a, U u) {
		this.dataA = a;
		this.dataU = u;
	}
	
	private A getTestArrayList() {
		return dataA;
	}

	private void setTestArrayList(A dataA) {
		this.dataA = dataA;
	}

	private U getTestUser() {
		return dataU;
	}

	private void setTestUser(U dataU) {
		this.dataU = dataU;
	}
	
}
