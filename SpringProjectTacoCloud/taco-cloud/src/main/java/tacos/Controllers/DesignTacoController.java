package tacos.Controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import tacos.Classes.Ingredient;
import tacos.Classes.Ingredient.Type;
import tacos.Classes.Taco;
import tacos.Classes.TacoOrder;
import tacos.Interfaces.IngredientRepository;

@Slf4j
//аннотация добавляет в класс
//private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DesignTacoController.class);

@Controller
//класс контроллер -> доступен для сканирования -> spring создаст экземпляр в виде bean-компонента в контексте приложения

@RequestMapping("/design")
//тип запросов которые обрабатывает даннйы контроллер (пути которые начинаются с /design`)

@SessionAttributes("tacoOrder")
//объект поддерживается на уровне сеанса

public class DesignTacoController {
	private static final org.slf4j.Logger log =
			 org.slf4j.LoggerFactory.getLogger(DesignTacoController.class);
	
	private final IngredientRepository ingredientRepo;
	
	@Autowired
	public DesignTacoController(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}
	
	@ModelAttribute
	public void addIngredientsToModel(Model model) {
//		List<Ingredient> ingredients = Arrays.asList(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
//				new Ingredient("COTO", "Corn Tortilla", Type.WRAP), new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
//				new Ingredient("CARN", "Carnitas", Type.PROTEIN),
//				new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES), new Ingredient("LETC", "Lettuce", Type.VEGGIES),
//				new Ingredient("CHED", "Cheddar", Type.CHEESE), new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
//				new Ingredient("SLSA", "Salsa", Type.SAUCE), new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
		Iterable<Ingredient> ingredients = ingredientRepo.findAll();
		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
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

	private Iterable<Ingredient> filterByType(Iterable<Ingredient> ingredients, Type type) {
		// Iterable has a spliterator() method, which can pass to StreamSupport.stream to create a stream:
		return StreamSupport.stream(ingredients.spliterator(), false).filter(x -> x.getType().equals(type)).collect(Collectors.toList());
		//return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
	}

	@PostMapping
	// @PostMapping -> сообщает @RequestMapping на уровне класса, что processTaco() обрабатывает запросы POST с путём /design
	public String processTaco(@Valid Taco taco,Errors errors, @ModelAttribute TacoOrder tacoOrder) {	// использовать объект TacoOrder, который был помещен в модель методом order() 
		if (errors.hasErrors()) {
			return "design";
			 }
		tacoOrder.addTaco(taco);
		log.info("Processing taco: {}", taco);
		return "redirect:/orders/current";
	}
}
//@PostMapping
////@PostMapping -> сообщает @RequestMapping на уровне класса, что processTaco() обрабатывает запросы POST с путём /design
//public String processTaco(@Valid Taco taco,Errors errors, SessionStatus sessionStatus) {	// использовать объект TacoOrder, который был помещен в модель методом order() 
//if (errors.hasErrors()) {
//	log.info("ERROR ! " + errors); 
//	return "design";
//	 }
////tacoOrder.addTaco(taco);
//log.info("Processing taco: {}", taco);
//sessionStatus.setComplete();
//return "redirect:/orders/current";
//}
