package SDT.CF.Classes;

import java.util.ArrayList;

import OCP.book.chapter_8.Lambda.Animal;

public class ClassArrayList<P> {
private ArrayList<P> testArrayList = new ArrayList<P>();
	
	public ClassArrayList(){	}

	public ArrayList<P> getTestArrayList() {
		return testArrayList;
	}

	public void setTestArrayList(ArrayList<P> testArrayList) {
		this.testArrayList = testArrayList;
	}
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}
}
//ClassArrayList<Animal> arrayListAnimals = new ClassArrayList<>();
//ArrayList<Animal> tempArrayList = arrayListAnimals.getTestArrayList();
////arrayListAnimals.getTestArrayList().add(new Animal("fish",false,true));
////arrayListAnimals.getTestArrayList().add(new Animal("rabbit",true,false));
//tempArrayList.add(new Animal("fish",false,true));
//tempArrayList.add(new Animal("rabbit",true,false));
//arrayListAnimals.setTestArrayList(tempArrayList);
//System.out.println(arrayListAnimals.getTestArrayList().toString());