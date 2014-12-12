package mc437.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import mc437.bean.TestCaseResults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class TestCaseResultsDAO {
	
	@Autowired
	DataSource datasource;
	
	public int save(final TestCaseResults testCaseResults){
		KeyHolder holder = new GeneratedKeyHolder();
		JdbcTemplate template = new JdbcTemplate(datasource);
		template.update(
				new PreparedStatementCreator() {

					@Override
					public PreparedStatement createPreparedStatement(
							Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(
								"INSERT INTO test_case_results(test_case_key"
				                           + ",path"
				                           + ",id_test_set_results"
				                           + ",id_i_test_results) VALUES (?, ?, ?, ?)",
								Statement.RETURN_GENERATED_KEYS);

						ps.setString(1, testCaseResults.getTestCaseKey());
						ps.setString(2, testCaseResults.getPath());
						ps.setInt(3, testCaseResults.getIdTestSetResults());
						ps.setInt(4, testCaseResults.getIdITestResults());

						return ps;
					}
				}, holder);

				return holder.getKey().intValue();
	}
}
