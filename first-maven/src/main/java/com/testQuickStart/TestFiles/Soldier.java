package com.testQuickStart.TestFiles;

public class Soldier extends Human{
	private String kindOfWeapon;
	{kindOfWeapon = "NULL";}
	Soldier(){}
	// Soldier(String _name, Integer _age, String _sex, String _kindOfWeapon) throws Exception{
	Soldier(Integer _age ,String _kindOfWeapon) throws Exception{
	/*
		 * this.name = _name; this.age = _age; this.sex = _sex;
		 */
		if(_age < 18) {
			throw new Exception("Error AGE must be > 18");
		}
		this.kindOfWeapon = _kindOfWeapon;
	}
	public String getKindOfWeapon() {
		return kindOfWeapon;
	}
	public void setKindOfWeapon(String _kindOfWeapon) {
		System.out.println("Soldier KINDOFWEAPON was setted");
		this.kindOfWeapon = _kindOfWeapon;
	}
	@Override
	public void showHumanInfo() {
		System.out.println("NAME " + this.getHumanName() + 
				" AGE " + this.getHumanAge() + 
				" SEX " + this.getHumanSex() + 
				" KINDOFWEAPON " + this.getKindOfWeapon());
	}
}


//// Human h1 = new Human(); h1.showHumanInfo(); 
//try {
//	  Soldier s1 = new Soldier();
//	  s1.showHumanInfo();
//} catch (Exception e) {
//	System.out.println(e);
//	// TODO: handle exception
//}