package tacos.Interfaces;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import tacos.Classes.Ingredient;

@Service
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
	Iterable<Ingredient> findAll();
	Optional<Ingredient> findById(String id);
	Ingredient save(Ingredient ingredient);
}
