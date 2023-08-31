package OCP.book.chapterLambdas8;

public class CheckIfHooper implements CheckTrait{
	public boolean test(Animal a) {
		return a.canHoop();
	}
}