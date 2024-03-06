// Создаётся анонимный класс которые реализует методы интерфеса
package AnonimousClasses;

public class TryIt {	
	public void TryIt() {
		IAction shopAction = new IAction() {

			@Override
			public void doWork() {
				System.out.println("doWork");
			}

			@Override
			public void doRelax() {
				System.out.println("doRelax");
			}
			
		};
		
		shopAction.doRelax();
		shopAction.doWork();
	}
}
