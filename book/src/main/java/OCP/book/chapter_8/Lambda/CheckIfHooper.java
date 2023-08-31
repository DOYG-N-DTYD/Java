package OCP.book.chapter_8.Lambda;

public class CheckIfHooper implements CheckTrait{
	public boolean test(Animal a) {
		return a.canHoop();
	}
}