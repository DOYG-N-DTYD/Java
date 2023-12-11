package com.testQuickStart.TestFiles;

public class Human {
private String name;
private Integer age;
private String sex;

{	name = "NULL";
	age = -1;
	sex = "NULL";
	}
	Human(){}
	Human(String _name){
		this.name = _name;
	}
	Human(String _name, Integer _age){
		this.name = _name;
		this.age = _age;
	}
	Human(String _name, Integer _age, String _sex){
		this.name = _name;
		this.age = _age;
		this.sex = _sex;
	}
	public String getHumanName() {
		return name;
	}
	public int getHumanAge() {
		return age;
	}
	public String getHumanSex() {
		return sex;
	}
	public void setHumanName(String _name) {
		System.out.println("Human NAME was setted");
		this.name = _name;
	}
	public void setHumanAge(Integer _age) {
		System.out.println("Human AGE was setted");
		this.age = _age;
	}
	public String setHumanSex(String _sex) {
		System.out.println("Human SEX was setted");
		return sex;
	}
	public void showHumanInfo() {
		System.out.println("NAME " + name + " AGE " + age + " SEX " + sex);
	}
}
