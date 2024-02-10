package tacos.Classes;

import lombok.Data;

@Data
public class Ingredient {
	private String id;
	private String name;
	private Type type;
	
	public Ingredient(String idString, String nameString, Type ingridientType) {
		this.id = idString;
		this.name = nameString;
		this.type = ingridientType;
	}
	
	public enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}

	public Type getType() {
		// TODO Auto-generated method stub
		return this.type;
	}
	
	public String id() {
		return this.id;
	}
	public String name() {
		return this.name;
	}
}
