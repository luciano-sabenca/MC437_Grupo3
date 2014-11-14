package mc437.controller;

import java.util.List;

import mc437.bean.TestcaseExecutingOutput;
import mc437.dao.TestResultDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestResultController {

	@Autowired
	TestResultDAO testResultDAO;

	@RequestMapping("/testResults")
	public String index(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {

		return null; // TODO
	}

	@RequestMapping(value = "/testResult/{id}")
	public String index(@PathVariable Integer id, Model model) {

		List<TestcaseExecutingOutput> deadMutants = testResultDAO
				.getDeadTestCaseExecuting(id);
		List<TestcaseExecutingOutput> notDead = testResultDAO
				.getNotDeadTestCaseExecuting(id);

		int total = deadMutants.size() + notDead.size();

		model.addAttribute("notDeadMutantsQtd", notDead.size());
		model.addAttribute("notDeadMutants", notDead);

		model.addAttribute("id", id);
		model.addAttribute("totalMutants", total);
		model.addAttribute("deadMutantsQtd", deadMutants.size());
		model.addAttribute("deadMutants", deadMutants);
		return "testResult";
	}
}
