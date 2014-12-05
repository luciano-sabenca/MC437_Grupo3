package mc437.dao;

import java.sql.Types;

import javax.sql.DataSource;

import mc437.bean.TestCaseResults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestCaseResultsDAO {
	
	@Autowired
	DataSource datasource;
	
	public int save(TestCaseResults testCaseResults){
		String sql = "SELECT MAX(id_seq) FROM test_case_results";
		
		JdbcTemplate template = new JdbcTemplate(datasource);
		template.update(
				"INSERT INTO test_case_results(test_case_key"
				                           + ",path"
				                           + ",id_test_set_results"
				                           + ",id_i_test_results) VALUES (?, ?, ?, ?)",
				new Object[] { testCaseResults.getTestCaseKey()
					 	      ,testCaseResults.getPath()
					 	      ,testCaseResults.getIdTestSetResults()
					 	      ,testCaseResults.getIdITestResults()}
				              ,new int[] {Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.INTEGER });
		
		return template.queryForObject(sql, new Object[] {}, Integer.class);
	}
}
