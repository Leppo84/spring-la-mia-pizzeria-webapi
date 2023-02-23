package la.mia.pizzeria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import la.mia.pizzeria.model.Ingredient;
import la.mia.pizzeria.repository.IngredientRepository;
import la.mia.pizzeria.repository.OfferRepository;
import la.mia.pizzeria.repository.PizzaRepository;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {

	@Autowired
	PizzaRepository PizzaRepository;

	@Autowired
	OfferRepository OfferRepository;
	
	@Autowired
	IngredientRepository IngredientRepository;

	@GetMapping()
	public String index(Model model) {
		List<Ingredient> ingredientList = IngredientRepository.findAll();
		model.addAttribute("elencoIngredienti", ingredientList);

		return "ingredients/index";
	}

}
