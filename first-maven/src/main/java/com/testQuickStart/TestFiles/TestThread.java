package com.testQuickStart.TestFiles;

//public class TestThread extends Thread{ // ONLY EXTENDENDS
	public class TestThread implements Runnable{ // INTERFACE RUNNABLE
		/*
		 * TestThread(String _threadName){ super(_threadName); }
		 */
	
	TestNum tn;
	TestThread(){
		this.tn = new TestNum();
	}
	public void run() {
		//synchronized(tn) {
		//System.out.println("THREAD " + Thread.currentThread().getName() + "STARTED");
		tn.x = 1;
		for(byte i=0;i<10;i++) {
			System.out.printf("%s %d \\n\"",Thread.currentThread().getName(), tn.x);
			tn.x++;
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				//System.out.println("THREAD " + Thread.currentThread().getName() + "INTERRUPT");
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		//System.out.println("THREAD " + Thread.currentThread().getName() + "FINISHED" ); 
	//}
}
	}

	class TestNum{
		int x = 0;
	}

//--------------MAIN------------
//	Thread t1 = new TestThread("THR_111"); Thread t2 = new TestThread("THR_222"); 
//	t1.start();
//	t2.start();
//	try {
//		t1.join();
//		t2.join();
//	}catch(InterruptedException e){
//		 System.out.printf("%s has been interrupted", t1.getName());
//		 System.out.printf("%s has been interrupted", t2.getName());
//	}
//	
//	
//	  //Interface runnable IMPLEMENTATION TestNum tn = new TestNum(); Thread
//	  testThread1 = new Thread(new TestThread(tn),"TH1"); Thread testThread2 = new
//	  Thread(new TestThread(tn),"TH2"); testThread1.start(); testThread2.start();
//	  System.out.println("MAIN THREAD FINISHED");
//	 