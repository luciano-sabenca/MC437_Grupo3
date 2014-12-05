package mc437.dao;

import java.sql.Types;

import javax.sql.DataSource;

import mc437.bean.TestCaseExecutingOutputMutantlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestCaseExecutingOutputMutantlistDAO {
	
	@Autowired
	DataSource datasource;
	
	public int save(TestCaseExecutingOutputMutantlist testCaseExecutingOutputMutantlist){
		String sql = "SELECT MAX(id_seq) FROM test_case_executing_output_mutantlist";
		
		JdbcTemplate template = new JdbcTemplate(datasource);
		template.update(
				"INSERT INTO test_case_executing_output_mutantlist(mutant_key"
				                           + ",dead"
				                           + ",death_index"
				                           + ",eval_failed"
				                           + ",id_test_case_results"
				                           + ",id_test_set_results"
				                           + ",id_i_test_results)"
				                           + " VALUES (?, ?, ?, ?, ?, ?, ?)",
				new Object[] { testCaseExecutingOutputMutantlist.getMutantKey()
				              ,testCaseExecutingOutputMutantlist.isDead()
					 	      ,testCaseExecutingOutputMutantlist.getDeathIndex()
					 	      ,testCaseExecutingOutputMutantlist.isEvalFailed()
					 	      ,testCaseExecutingOutputMutantlist.getIdTestCaseResults()
					 	      ,testCaseExecutingOutputMutantlist.getIdTestSetResults()
					 	      ,testCaseExecutingOutputMutantlist.getIdITestResults() }
				              ,new int[] { Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER } );

		return template.queryForObject(sql, new Object[] {}, Integer.class);
	}

}
