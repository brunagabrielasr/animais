package br.com.bruna.animais.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.bruna.animais.model.Animal;

@Controller
@RequestMapping("/animais")
public class AnimaisController {

	private static final Logger logger = LoggerFactory
			.getLogger(AnimaisController.class);

	@RequestMapping("/cadastrar")
	public String novo(Animal animal) {
		logger.error("Aqui ocorreu um erro!");
		return "animal/CadastroAnimal";
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String cadastrar(@Valid Animal animal, BindingResult result,
			Model model, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return novo(animal);
		}

		// Salvar no banco de dados...
		attributes.addFlashAttribute("mensagem", "Animalzinho cadastrado com sucesso!");

		//System.out.println(">>> sku: " + cerveja.getSku());

		return "redirect:/animais/cadastrar";
	}

	@GetMapping("/pesquisar")
	public ModelAndView pesquisar() {
		ModelAndView mv = new ModelAndView("animal/PesquisarAnimal");
		return mv;
	}
}
