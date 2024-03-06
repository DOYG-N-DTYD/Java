package Main;

import Shop.IAction;

public class Main {

	public static void main(String[] args) {
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
