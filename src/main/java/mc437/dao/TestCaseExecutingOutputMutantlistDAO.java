package mc437.dao;

import mc437.bean.TestCaseExecutingOutputMutantlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestCaseExecutingOutputMutantlistDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void save(TestCaseExecutingOutputMutantlist testCaseExecutingOutputMutantlist, int idItestResults){
		String insert = "";
	}

}
