package com.codewars.loopover;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import com.codewars.loopover.RandomNumbersQueue;

public class RandomShuffleStartEnd {
	private int startIntOfDiapason;
	private int endIntOfDiapason;
	private List<Integer> listOfIntegers;
	private RandomNumbersQueue<Integer> randomNumbersQueue;

	private List<List<Integer>> prePostLists;
	private List<List<Integer>> subLists;
	private HashMap<Integer, Boolean> randomNumHashMap;

	RandomShuffleStartEnd(int startIntOfDiapason, int endIntOfDiapason) {
		this.startIntOfDiapason = startIntOfDiapason;
		this.endIntOfDiapason = endIntOfDiapason;
		this.randomNumbersQueue = new RandomNumbersQueue<>();
		this.listOfIntegers = initList(startIntOfDiapason, endIntOfDiapason);
		this.prePostLists = new ArrayList<>();
		this.subLists = new LinkedList<>();
		this.randomNumHashMap = initHashMap(startIntOfDiapason, endIntOfDiapason);
	}

	private int getStartIntOfDiapason() {
		return startIntOfDiapason;
	}

	private void setStartIntOfDiapason(int startIntOfDiapason) {
		this.startIntOfDiapason = startIntOfDiapason;
	}

	private int getEndIntOfDiapason() {
		return endIntOfDiapason;
	}

	private void setEndIntOfDiapason(int endIntOfDiapason) {
		this.endIntOfDiapason = endIntOfDiapason;
	}

	private List<Integer> getListOfIntegers() {
		return listOfIntegers;
	}

	private void setListOfIntegers(List<Integer> listOfIntegers) {
		this.listOfIntegers = listOfIntegers;
	}

	private RandomNumbersQueue<Integer> getRandomNumbersQueue() {
		return randomNumbersQueue;
	}

	private void setRandomNumbersQueue(RandomNumbersQueue<Integer> randomNumbersQueue) {
		this.randomNumbersQueue = randomNumbersQueue;
	}

	private List<List<Integer>> getPrePostLists() {
		return prePostLists;
	}

	private void setPrePostLists(List<List<Integer>> prePostLists) {
		this.prePostLists = prePostLists;
	}

	private HashMap<Integer, Boolean> getRandomNumHashMap() {
		return randomNumHashMap;
	}

	private void setRandomNumHashMap(HashMap<Integer, Boolean> randomNumHashMap) {
		this.randomNumHashMap = randomNumHashMap;
	}

	private List<Integer> initList(int start, int end) {
		List<Integer> list = new LinkedList<Integer>();
		for (int i = start; i <= end; i++) {
			list.add(i);
		}
		return list;
	}

	private HashMap<Integer, Boolean> initHashMap(int start, int end) {
		HashMap<Integer, Boolean> randomNumHashMap = new HashMap<>();
		for (int i = start; i <= end; i++) {
			randomNumHashMap.put(i, false);
		}
		return randomNumHashMap;
	}
	
	public void divideMainListToSublists() {
		do {
			int middleOfListIndex;
			int middleElement;
			List<Integer> listOfPreIntegers = new LinkedList<>();
			List<Integer> listOfPostIntegers = new LinkedList<>();
			if (!subLists.isEmpty()) {
				listOfIntegers = subLists.get(subLists.size() - 1);
				subLists.remove(subLists.size() - 1);
			}
			if (listOfIntegers.size() == 2) {
				System.out.println("listUniq [1..2..3..+ size()-1, size()-2]");
				randomNumbersQueue.add(listOfIntegers.get(1));
				randomNumbersQueue.add(listOfIntegers.get(0));
			}else if(listOfIntegers.size() == 1 ){
					randomNumbersQueue.add(listOfIntegers.get(0));
				
			} else {
				middleOfListIndex = listOfIntegers.size() / 2;
				middleElement = listOfIntegers.get(middleOfListIndex);
				listOfPreIntegers = listOfIntegers.subList(0, middleOfListIndex);
				listOfPostIntegers = listOfIntegers.subList(middleOfListIndex, listOfIntegers.size());

				if (listOfPostIntegers.contains(middleElement)) {
					subLists.add(listOfPreIntegers);
					int idxMiddleElement = listOfPostIntegers.indexOf(middleElement);
					randomNumbersQueue.add(listOfPostIntegers.get(idxMiddleElement));
					LinkedList<Integer> buffList = new LinkedList<>();
					for (Integer integer : listOfPostIntegers) {
						if (integer != listOfPostIntegers.get(idxMiddleElement)) {
							buffList.add(integer);
						}
					}
					if (buffList.size() == 1) { // add to unique shuffled
						randomNumbersQueue.add(listOfPostIntegers.get(listOfPostIntegers.size() - 1));
					} else {
						subLists.add(buffList); // push stack
					}
				} else {
					System.out.println("ERROR IN prePostLists");
				}
			}
		} while (!subLists.isEmpty());
	}
	public void showShuffledElements(){
		for (Integer integer : randomNumbersQueue) {
			System.out.print(integer + " ");
		}
	}
}
