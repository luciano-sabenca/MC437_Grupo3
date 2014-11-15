package mc437.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
				.query("SELECT * FROM test_case_executing_output_mutantlist WHERE id_itr_test_set_results_case_results = ? AND dead = true",
						new Object[] { iTestResult },
						new TestcaseExecutingOutputRowMapper());

	}

	public List<TestcaseExecutingOutput> getNotDeadTestCaseExecuting(
			Integer iTestResult) {
		return jdbcTemplate
				.query("SELECT * FROM test_case_executing_output_mutantlist WHERE id_itr_test_set_results_case_results = ? AND dead = false",
						new Object[] { iTestResult },
						new TestcaseExecutingOutputRowMapper());

	}

	private class TestcaseExecutingOutputRowMapper implements
			RowMapper<TestcaseExecutingOutput> {

		@Override
		public TestcaseExecutingOutput mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			TestcaseExecutingOutput testcaseExecutingOutput = new TestcaseExecutingOutput();
			testcaseExecutingOutput.setCodSetResultsCaseResults(rs
					.getInt("cod_set_results_case_results"));
			testcaseExecutingOutput.setDead(rs.getBoolean("dead"));
			testcaseExecutingOutput.setDeathIndex(rs.getInt("death_index"));

			testcaseExecutingOutput.setMutantKey(rs.getString("mutant_key"));
			testcaseExecutingOutput.setEvalFailed(rs.getBoolean("eval_failed"));
			testcaseExecutingOutput.setIdItrTestSetResultsCaseResults(rs
					.getInt("id_itr_test_set_results_case_results"));

			testcaseExecutingOutput.setIdTestCaseRest(rs
					.getInt("id_test_case_rests"));

			return testcaseExecutingOutput;

		}
	}
}
