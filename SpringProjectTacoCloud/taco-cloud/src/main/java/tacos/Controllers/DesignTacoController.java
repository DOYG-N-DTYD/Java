package tacos.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import tacos.Classes.Ingredient;
import tacos.Classes.Ingredient.Type;
import tacos.Classes.Taco;
import tacos.Classes.TacoOrder;
import tacos.Interfaces.IngredientRepository;

//@Slf4j
//аннотация добавляет в класс
//private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DesignTacoController.class);

@Controller
//класс контроллер -> доступен для сканирования -> spring создаст экземпляр в виде bean-компонента в контексте приложения

@RequestMapping("/design")
//тип запросов которые обрабатывает даннйы контроллер (пути которые начинаются с /design`)

@SessionAttributes("tacoOrder")
//объект поддерживается на уровне сеанса

public class DesignTacoController {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DesignTacoController.class);

	private final IngredientRepository ingredientRepo;
	//private TacoRepository tacoRepo;

	public DesignTacoController(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}

	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		//Iterable<Ingredient> ingredients = ingredientRepo.findAll();
		 List<Ingredient> ingredients = new ArrayList<>();
		 ingredientRepo.findAll().forEach(i -> ingredients.add(i));
		 
		for (Ingredient ingredient : ingredients) {
			System.out.println("#ingredient# "+ingredient);
		}
//		List<Ingredient> ingredients = Arrays.asList(
//				new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
//				new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
//				new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
//				new Ingredient("CARN", "Carnitas", Type.PROTEIN),
//				new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
//				new Ingredient("LETC", "Lettuce", Type.VEGGIES),
//				new Ingredient("CHED", "Cheddar", Type.CHEESE),
//				new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
//				new Ingredient("SLSA", "Salsa", Type.SAUCE),
//				new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
//				);
		
		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			//model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));  
			System.out.println(ingredients + "   " + type);
		}
	}

	@ModelAttribute(name = "tacoOrder")
	public TacoOrder order() {
		return new TacoOrder();
	}

	@ModelAttribute(name = "taco")
	public Taco taco() {
		return new Taco();
	}

	@GetMapping
	public String showDesignForm() {
		return "design";
	}

	private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		// Iterable has a spliterator() method, which can pass to StreamSupport.stream
		// to create a stream:
		return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
	}

	@PostMapping
	// @PostMapping -> сообщает @RequestMapping на уровне класса, что processTaco()
	// обрабатывает запросы POST с путём /design
	public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder) { 
		if (errors.hasErrors()) {
			return "design";
		}
		tacoOrder.addTaco(taco);
		log.info("Processing taco: {}", taco);
		return "redirect:/orders/current";
	}
}
