package mc437.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import mc437.bean.Results;
import mc437.bean.TestcaseExecutingOutput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TestResultDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<TestcaseExecutingOutput> getDeadTestCaseExecuting(
			Integer iTestResult) {
		return jdbcTemplate
				.query("SELECT * FROM test_case_executing_output_mutantlist WHERE id_i_test_results = ? AND dead = true",
						new Object[] { iTestResult },
						new TestcaseExecutingOutputRowMapper());

	}

	public List<TestcaseExecutingOutput> getNotDeadTestCaseExecuting(
			Integer iTestResult) {
		return jdbcTemplate
				.query("SELECT * FROM test_case_executing_output_mutantlist WHERE id_i_test_results = ? AND dead = false",
						new Object[] { iTestResult },
						new TestcaseExecutingOutputRowMapper());

	}
	
	public List<Results> getResults(Integer iTestResult) {
		return jdbcTemplate.query("SELECT ml.mutant_key, ml.dead, s.path as conjunto, c.path as caso "
				+ "FROM test_case_executing_output_mutantlist ml, I_Test_Result i, test_case_results c, "
				+ "test_set_results s WHERE ml.id_i_test_results = i.id AND c.id_i_test_results = i.id "
				+ "AND s.id_i_test_result = i.id AND i.id = ?;",
				new Object[] { iTestResult },
				new RowMapper<Results>() {

					@Override
					public Results mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Results result = new Results(rs.getString("mutant_key"), rs.getString("mutant_key"), rs
								.getInt("dead"), rs.getString("conjunto"), rs.getString("caso"));
						return result;
				}
		});
	}
	

	private class TestcaseExecutingOutputRowMapper implements
			RowMapper<TestcaseExecutingOutput> {

		@Override
		public TestcaseExecutingOutput mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			TestcaseExecutingOutput testcaseExecutingOutput = new TestcaseExecutingOutput();
			testcaseExecutingOutput.setCodSetResultsCaseResults(rs
					.getInt("id_test_case_results"));
			testcaseExecutingOutput.setDead(rs.getBoolean("dead"));
			testcaseExecutingOutput.setDeathIndex(rs.getInt("death_index"));

			testcaseExecutingOutput.setMutantKey(rs.getString("mutant_key"));
			testcaseExecutingOutput.setEvalFailed(rs.getBoolean("eval_failed"));
			testcaseExecutingOutput.setIdItrTestSetResultsCaseResults(rs
					.getInt("id_test_set_results"));

			testcaseExecutingOutput.setIdTestCaseRest(rs
					.getInt("id_i_test_results"));

			return testcaseExecutingOutput;

		}
	}
}
