package mc437.controller;

import mc437.bean.Teste;
import mc437.dao.TesteDAO;
import mc437.service.TesteInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

	@Autowired
	TesteInterface testeService;

	@Autowired
	TesteDAO testeDAO;

	@RequestMapping("/greeting")
	public String greeting(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		testeService.helloWorld();

		for (Teste teste : testeDAO.getAllTests()) {
			System.out.println(teste);
		}
		testeDAO.bla();
		return "greeting";
	}

	@RequestMapping("/banana")
	public String banana(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			@RequestParam(value = "type", required = false, defaultValue = "prata") String banana,
			Model model) {
		model.addAttribute("type", banana);
		model.addAttribute("name", name);

		return "banana";
	}
}
