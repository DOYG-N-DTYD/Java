package tacos.Classes;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.Interfaces.IngredientRepository;

@Component
//@ComponentScan(basePackages = "tacos.Classes")
public class IngredientByIdConverter implements Converter<String, Ingredient> {
	private IngredientRepository ingredientRepo;
	
	public IngredientByIdConverter(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}

	@Override
	public Ingredient convert(String id) {
		return ingredientRepo.findById(id).orElse(null);
		//return ingredientMap.get(id);
	}
}