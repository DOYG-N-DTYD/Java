package com.testQuickStart.TestFiles;

public class RobotHuman extends Robot{
	public RobotHuman(){
		
	}
	public RobotHuman(String _name){
		this.robotName = _name;
	}
	@Override
	public void ShowRobotName() {
		// TODO Auto-generated method stub
		System.out.println("ROBOT HUMAN NAME " + robotName);
	}
	@Override
	public void Shoot() {
		// TODO Auto-generated method stub
		System.out.println("ROBOT HUMAN SHOOT");
	}
}

//RobotHuman rh1 = new RobotHuman();
//rh1.ShowRobotName();
//rh1.Shoot();