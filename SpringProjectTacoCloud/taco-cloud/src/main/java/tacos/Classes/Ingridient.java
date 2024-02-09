package tacos.Classes;

import lombok.Data;

@Data
public class Ingridient {
	private final String id = "";
	private final String name = "";
	private final Type type = null;
	
	public enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}
}
