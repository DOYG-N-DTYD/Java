package tacos.Classes;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.Classes.Ingredient.Type;
import tacos.Interfaces.IngredientRepository;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
	private static Map<String, Ingredient> ingredientMap = new HashMap<>() {{
		put("FLTO", new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
		put("COTO", new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
		put("GRBF", new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
		put("CARN", new Ingredient("CARN", "Carnitas", Type.PROTEIN));
		put("TMTO", new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
		put("LETC", new Ingredient("LETC", "Lettuce", Type.VEGGIES));
		put("CHED", new Ingredient("CHED", "Cheddar", Type.CHEESE));
		put("JACK", new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
		put("SLSA", new Ingredient("SLSA", "Salsa", Type.SAUCE));
		put("SRCR", new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
	}};
	private IngredientRepository ingredientRepo;
	
	public IngredientByIdConverter(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}

	@Override
	public Ingredient convert(String id) {
		return ingredientRepo.findById(id).orElse(null);
		//return ingredientMap.get(id);
	}
	
	public static Ingredient staticConvert(String id) {
		return ingredientMap.get(id);
	}
}