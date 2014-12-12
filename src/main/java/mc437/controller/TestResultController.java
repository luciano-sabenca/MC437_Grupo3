package mc437.controller;

import java.util.List;

import mc437.bean.Results;
import mc437.bean.TestcaseExecutingOutput;
import mc437.dao.TestResultDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestResultController {

	@Autowired
	TestResultDAO testResultDAO;

	@RequestMapping(value = "/testResult/{id}")
	public String index(@PathVariable Integer id, Model model) {

		List<TestcaseExecutingOutput> deadMutants = testResultDAO
				.getDeadTestCaseExecuting(id);
		List<TestcaseExecutingOutput> notDead = testResultDAO
				.getNotDeadTestCaseExecuting(id);

		List<Results> testes = testResultDAO.getResults(id);
		String mutant;
		String op_mutant_split[];
		
		int dead;
		for (Results result : testes) {
			mutant = result.getOperador_Mutante();
			op_mutant_split = mutant.split("\\$");
			mutant = "$" + op_mutant_split[1] + "$" + op_mutant_split[2];
			result.setOperador_Mutante(op_mutant_split[1]);
			result.setMutante(mutant);
			dead = result.getDead();
			if (dead == 1)
				result.setVivo("Sim");
			else if (dead == 0)
				result.setVivo("Não");
		}

		model.addAttribute("valores", testes);

		if (deadMutants.isEmpty() && notDead.isEmpty()) {
			model.addAttribute("element", id);
			return "error";
		}

		int total = deadMutants.size() + notDead.size();

		model.addAttribute("notDeadMutantsQtd", notDead.size());
		model.addAttribute("notDeadMutants", notDead);
		double score = (double) deadMutants.size() / total;
		model.addAttribute("score", score);
		model.addAttribute("id", id);
		model.addAttribute("totalMutants", total);
		model.addAttribute("deadMutantsQtd", deadMutants.size());
		model.addAttribute("deadMutants", deadMutants);
		return "testResult";
	}

}
