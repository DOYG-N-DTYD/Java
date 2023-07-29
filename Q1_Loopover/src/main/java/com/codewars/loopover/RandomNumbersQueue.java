package com.codewars.loopover;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;

public class RandomNumbersQueue<E> extends AbstractQueue<E> {
private LinkedList<E> elements;
	
	public RandomNumbersQueue(){
		this.elements = new LinkedList<E>();
	}
	
	@Override
	public boolean offer(E e) {
		// TODO Auto-generated method stub
		System.out.println("QUEUE MTHOD offer()");
		if(e == null) return false;
	    elements.add(e);
	    return true;
	}

	@Override
	public E poll() {
		// TODO Auto-generated method stub
		System.out.println("QUEUE MTHOD poll() ");
		Iterator<E> iter = elements.iterator();
	    E e = iter.next();
	    if(e != null){
	        iter.remove();
	        System.out.println("QUEUE MTHOD poll() " + e);
	        return e;
	    }
	    System.out.println("QUEUE MTHOD poll() " + "NULL");
	    return null;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		System.out.println("QUEUE MTHOD peek() " + elements.getFirst());
		return elements.getFirst();
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		System.out.println("QUEUE MTHOD iterator");
		return elements.iterator();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		System.out.println("QUEUE MTHOD size() " + elements.size());
		return elements.size();
	}
	
	public void printAllElements() {
		Iterator<E> iterator = elements.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}
}
