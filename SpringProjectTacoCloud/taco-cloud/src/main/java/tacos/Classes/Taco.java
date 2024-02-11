package tacos.Classes;

import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ListModel;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Taco {

	@NotNull
	@Size(min = 5, message = "Name must be at least 5 characters long")
	private String name;
	@NotNull
	@Size(min = 1, message = "You must choose at least 1 ingredient")
	private List<Ingredient> ingredients;

	private Date createdAt = new Date();
	
	public String getName() {
		return name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}

	public void setName(String name) {
		System.out.println("SetName !!!");
		this.name = name;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(String[] ingredients) {
		//Из формы получаем массив строковых id, которые нужно переконвертировать
		List<Ingredient> convertedIngredients = new ArrayList<>();
		IngredientByIdConverter converter = new IngredientByIdConverter();
		for (String ingredientIdstring : ingredients) {
			Ingredient newIngredient = converter.convert(ingredientIdstring);
			convertedIngredients.add(newIngredient);
		}
		this.ingredients = convertedIngredients;
	}
	
	public String name() {
		return this.name;
	}

	public List<Ingredient> ingredients() {
		return this.ingredients;
	}

}
