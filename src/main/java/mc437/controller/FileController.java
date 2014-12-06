package mc437.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import mc437.bean.ITestResultBean;
import mc437.dao.TesteDAO;
import mc437.service.XMLService;
import mc437.service.Interface.TesteInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

	@Autowired
	TesteInterface testeService;
	
	@Autowired
	XMLService xmlService;
	
	@Autowired
	TesteDAO testeDAO;

	@RequestMapping("/")
	public String xml_files(Model model) {

		List<ITestResultBean> testes = testeDAO.getFiles();

		model.addAttribute("valores", testes);

		return "index";

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

	@RequestMapping("/xmlVisualization")
	public String banana() {

		return "xmlVisualization";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String provideUploadInfo() {
		return "upload";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String handleFileUpload(@RequestParam("file") MultipartFile file) {
		String name = file.getOriginalFilename();

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(name + "-uploaded")));
				stream.write(bytes);
				stream.close();
				
				ITestResultBean xmlFile = new ITestResultBean(file.getOriginalFilename(),
						          file.getSize(), new Date(), new File(name + "-uploaded"));

				xmlService.parserXml(xmlFile);
				
				return "fileUploaded";
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name
					+ " because the file was empty.";
		}
	}
}
