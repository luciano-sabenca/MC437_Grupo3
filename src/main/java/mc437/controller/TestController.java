package mc437.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import mc437.bean.Teste;
import mc437.dao.TesteDAO;
import mc437.service.TesteInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String provideUploadInfo() {
		return "upload";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String handleFileUpload(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(name + "-uploaded")));
				stream.write(bytes);
				stream.close();
				return "You successfully uploaded " + name + " into " + name
						+ "-uploaded !";
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name
					+ " because the file was empty.";
		}
	}
}
