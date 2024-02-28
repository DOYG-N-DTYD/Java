package tacos.Interfaces;

import org.springframework.data.repository.CrudRepository;

import tacos.Classes.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}