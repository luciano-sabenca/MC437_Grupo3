package mc437.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import mc437.bean.TestCaseExecutingOutputMutantlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class TestCaseExecutingOutputMutantlistDAO {

	@Autowired
	DataSource datasource;

	public int save(
			final TestCaseExecutingOutputMutantlist testCaseExecutingOutputMutantlist) {

		JdbcTemplate template = new JdbcTemplate(datasource);
		KeyHolder holder = new GeneratedKeyHolder();
		template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(
						"INSERT INTO test_case_executing_output_mutantlist(mutant_key"
								+ ",dead" + ",death_index" + ",eval_failed"
								+ ",id_test_case_results"
								+ ",id_test_set_results"
								+ ",id_i_test_results)"
								+ " VALUES (?, ?, ?, ?, ?, ?, ?)",
						Statement.RETURN_GENERATED_KEYS);

				ps.setString(1,
						testCaseExecutingOutputMutantlist.getMutantKey());
				ps.setBoolean(2, testCaseExecutingOutputMutantlist.isDead());
				ps.setInt(3, testCaseExecutingOutputMutantlist.getDeathIndex());
				ps.setBoolean(4,
						testCaseExecutingOutputMutantlist.isEvalFailed());
				ps.setInt(5, testCaseExecutingOutputMutantlist
						.getIdTestCaseResults());
				ps.setInt(6,
						testCaseExecutingOutputMutantlist.getIdTestSetResults());
				ps.setInt(7,
						testCaseExecutingOutputMutantlist.getIdITestResults());

				return ps;
			}
		}, holder);

		return holder.getKey().intValue();
	}
}
