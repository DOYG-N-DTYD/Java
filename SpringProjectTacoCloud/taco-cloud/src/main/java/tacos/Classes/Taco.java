package tacos.Classes;

import javax.swing.ListModel;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Taco {

//	@NotNull
//	@Size(min = 5, message = "Name must be at least 5 characters long")
	private String name;
//	@NotNull
//	@Size(min = 1, message = "You must choose at least 1 ingredient")
	private ListModel<Ingredient> ingredients;

	public String name() {
		return this.name;
	}

	public ListModel<Ingredient> ingredients() {
		return this.ingredients;
	}

}
