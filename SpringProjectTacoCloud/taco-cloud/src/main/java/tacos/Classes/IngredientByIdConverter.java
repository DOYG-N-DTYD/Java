package tacos.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.Interfaces.IngredientRepository;

@Component
//@ComponentScan(basePackages = "tacos.Classes")
public class IngredientByIdConverter implements Converter<String, Ingredient> {
	private IngredientRepository ingredientRepo;
	
	@Autowired
	public IngredientByIdConverter(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}

	@Override
	public Ingredient convert(String id) {
		return ingredientRepo.findById(id).orElse(null);
		//return ingredientMap.get(id);
	}
}