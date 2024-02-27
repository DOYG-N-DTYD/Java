package tacos.Classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import tacos.Classes.Ingredient.Type;

@Data	
@Entity
public class Taco {

	@NotNull
	@Size(min = 5, message = "Name must be at least 5 characters long")
	private String name;

	@Size(min = 1, message = "You must choose at least 1 ingredient")
	@ManyToMany()
	private List<Ingredient> ingredients;

	private Date createdAt = new Date();
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public void addIngredient(Ingredient ingredient) {
		this.ingredients.add(ingredient);
	}

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
		// Из формы получаем массив строковых id, которые нужно переконвертировать
		Map<String, Ingredient> ingredientMap = new HashMap<>();

//		ingredientMap.put("FLTO", new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
//		ingredientMap.put("COTO", new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
//		ingredientMap.put("GRBF", new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
//		ingredientMap.put("CARN", new Ingredient("CARN", "Carnitas", Type.PROTEIN));
//		ingredientMap.put("TMTO", new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
//		ingredientMap.put("LETC", new Ingredient("LETC", "Lettuce", Type.VEGGIES));
//		ingredientMap.put("CHED", new Ingredient("CHED", "Cheddar", Type.CHEESE));
//		ingredientMap.put("JACK", new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
//		ingredientMap.put("SLSA", new Ingredient("SLSA", "Salsa", Type.SAUCE));
//		ingredientMap.put("SRCR", new Ingredient("SRCR", "Sour Cream", Type.SAUCE));

		List<Ingredient> convertedIngredients = new ArrayList<>();
		for (String ingredientIdstring : ingredients) {
			Ingredient newIngredient = ingredientMap.get(ingredientIdstring);
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

	public void setCreatedAt(Date date) {
		// TODO Auto-generated method stub
		this.createdAt = date;
	}

	public void setId(long tacoId) {
		// TODO Auto-generated method stub
		this.id = tacoId;
	}

}
