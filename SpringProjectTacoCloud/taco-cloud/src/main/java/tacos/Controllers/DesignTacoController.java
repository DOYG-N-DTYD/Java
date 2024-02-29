package tacos.Controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
import tacos.Classes.Ingredient;
import tacos.Classes.Ingredient.Type;
import tacos.Classes.Taco;
import tacos.Classes.TacoOrder;
import tacos.Classes.User;
import tacos.Interfaces.IngredientRepository;
import tacos.Interfaces.TacoRepository;
import tacos.Interfaces.UserRepository;

@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

	private final IngredientRepository ingredientRepo;

	private TacoRepository tacoRepo;

	private UserRepository userRepo;

	@Autowired
	public DesignTacoController(IngredientRepository ingredientRepo, TacoRepository tacoRepo, UserRepository userRepo) {
		System.out.println("1");
		this.ingredientRepo = ingredientRepo;
		this.tacoRepo = tacoRepo;
		this.userRepo = userRepo;
	}

	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		System.out.println("2");
		List<Ingredient> ingredients = new ArrayList<>();
		ingredientRepo.findAll().forEach(i -> ingredients.add(i));

		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
		}
	}

	@ModelAttribute(name = "order")
	public TacoOrder order() {
		System.out.println("3");
		return new TacoOrder();
	}

	@ModelAttribute(name = "taco")
	public Taco taco() {
		System.out.println("4");
		return new Taco();
	}

	@ModelAttribute(name = "user")
	public User user(Principal principal) {
		System.out.println("5");
		String username = principal.getName();
		User user = userRepo.findByUsername(username);
		return user;
	}

	@GetMapping
	public String showDesignForm() {
		System.out.println("6");
		return "design";
	}

	@PostMapping
	public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder order) {
		System.out.println("7");
		if (errors.hasErrors()) {
			return "design";
		}
		Taco saved = tacoRepo.save(taco);
		order.addTaco(saved);

		return "redirect:/orders/current";
	}

	private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
	}

}