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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
