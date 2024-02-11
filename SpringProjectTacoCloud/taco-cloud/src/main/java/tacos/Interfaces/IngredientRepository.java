package tacos.Interfaces;

import java.util.Optional;

import tacos.Classes.Ingredient;

public interface IngredientRepository {
	Iterable<Ingredient> findAll();
	Optional<Ingredient> findById(String id);
	Ingredient save(Ingredient ingredient);
}
