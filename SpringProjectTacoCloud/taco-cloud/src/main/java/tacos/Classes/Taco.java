package tacos.Classes;

import javax.swing.ListModel;

import lombok.Data;

@Data
public class Taco {
	
	private String name;
	private ListModel<Ingredient> ingredients;
	
	public String name() {
		return this.name;
	}
	
	public ListModel<Ingredient> ingredients(){
		return this.ingredients;
	}
}
