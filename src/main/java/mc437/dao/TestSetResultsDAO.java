package mc437.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import mc437.bean.TestSetResults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class TestSetResultsDAO {

	@Autowired
	DataSource datasource;

	public int save(final TestSetResults testSetResults) {
		JdbcTemplate template = new JdbcTemplate(datasource);
		KeyHolder holder = new GeneratedKeyHolder();
		template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(
						"INSERT INTO test_set_results(cod" + ",path" + ",id"
								+ ",id_i_test_result) VALUES (?, ?, ?, ?)",
						Statement.RETURN_GENERATED_KEYS);

				ps.setString(1, testSetResults.getCod());
				ps.setString(2, testSetResults.getPath());
				ps.setString(3, testSetResults.getId());
				ps.setInt(4, testSetResults.getIdItestResult());

				return ps;
			}
		}, holder);

		return holder.getKey().intValue();
	}
}
