package la.mia.pizzeria.controller.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import la.mia.pizzeria.model.Pizza;
import la.mia.pizzeria.repository.IngredientRepository;
import la.mia.pizzeria.repository.PizzaRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiPizzasController {

	@Autowired
	PizzaRepository PizzaRepository;
	
	@Autowired
	IngredientRepository IngredientRepository;
	
//	@GetMapping
//	public String index(@RequestParam(name = "input", required = false) String input, Model model) {
//		List<Pizza> elencoPizze;	
//		if (input != null && !input.isEmpty()) {
//			elencoPizze = PizzaRepository.findByNameLike("%" + input + "%");
//		} else {
//			elencoPizze = PizzaRepository.findAll();
//		}
//		model.addAttribute("elencoPizze", elencoPizze);
//		return "index";
//	}
	
	@GetMapping()
	public List<Pizza> index() {
		return PizzaRepository.findAll();
	}
	
//	@GetMapping("/{id}")
//	public String singlePizza(@PathVariable("id") Integer id, Model model) {
//		Pizza detailPizza = PizzaRepository.getReferenceById(id);
//		
//		model.addAttribute("pizza", detailPizza);
//
//		return "show";
//
//	}

	@GetMapping("{id}")
	public ResponseEntity<Pizza> detail(@PathVariable("id") Integer id) {
		Optional<Pizza> res=PizzaRepository.findById(id);
		if (res.isPresent()) 
			return new ResponseEntity<Pizza>(res.get(), HttpStatus.OK);
	    else
	    	return new ResponseEntity<Pizza>(HttpStatus.NOT_FOUND);
	}
	
	
//	@GetMapping("/create")		//gestirà le richieste GET di tipo /create
//	public String create(Model model) {
//		Pizza pizza=new Pizza();	//non esiste ancora sul DB
//		pizza.setPhoto("https://upload.wikimedia.org/wikipedia/commons/a/a3/Eq_it-na_pizza-margherita_sep2005_sml.jpg");
//		model.addAttribute("pizza", pizza);
//		
//		return "/create";
//	}
	
//	@PostMapping("/create")  	//gestirà le richieste di tipo POST di tipo /create
//	public String store(
//		@Valid @ModelAttribute("pizza") Pizza formPizza, 
//		BindingResult bindingResult,
//		Model model){
//		
//		if (bindingResult.hasErrors()) {
//			model.addAttribute("error", "Qualcosa è andato storto :(");
//			return "/create";
//			}
//		
//		PizzaRepository.save(formPizza);
//		
//		return "redirect:/"; //genera un altro get
//		
//	}
	
//	@GetMapping("/edit/{id}")		//richieste GET del tipo /edit/xx
//	public String edit(@PathVariable("id") Integer id, Model model) {		
//		Pizza pizza=PizzaRepository.getReferenceById(id);  //lo recupero dal DB
//
//		List<Ingredient> elencoIngredienti=IngredientRepository.findAll();
//		
//		model.addAttribute("pizza", pizza);
//		model.addAttribute("elencoIngredienti", elencoIngredienti);
//		model.addAttribute("edit", true);
//		return "/edit";
//	}
		
//	@PostMapping("/edit/{id}")		//richieste POST del tipo /edit/n
//	public String update(
//			@Valid @ModelAttribute Pizza formPizza,
//			BindingResult bindingResult,
//			Model model) {
//		
//		if (bindingResult.hasErrors())
//			return "/edit";
//		
////		if (PizzaRepository.findByName(formPizza.getName()).size()>0)
////			System.out.println("Pizza già esistente");
//		
//		else
//			PizzaRepository.save(formPizza);
//		
//		return "redirect:/";
//	}
	
	@DeleteMapping("{id}")	//eliminazione   Richiesta DELETE /xx
	public void delete(
			@PathVariable("id") Integer id) {
		PizzaRepository.deleteById(id);
	}

//	------------------------------------------------
	
//	@PostMapping()
//	public Book create(@RequestBody Book book) {
//		return bookRepository.save(book);
//	}
//	
//	@PutMapping("{id}")	//aggiornamento   Richiesta PUT /books/xx
//	public Book update(@RequestBody Book book,
//			@PathVariable("id") Integer id) {
//		Book b=bookRepository.getReferenceById(id);
//		b.setTitle(book.getTitle());
//		//....
//		return bookRepository.save(b);
//	}
	
	
}
