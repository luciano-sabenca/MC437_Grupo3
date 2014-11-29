package mc437.dao;

import mc437.bean.TestCaseResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestCaseResultsDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void save(TestCaseResults testCaseResults, int idItestResults){
		String insert = "";
	}
}
