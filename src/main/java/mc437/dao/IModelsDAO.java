package mc437.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import mc437.bean.IModels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class IModelsDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<IModels> getIModels(Integer iTestResult) {
		return jdbcTemplate.query(
				"SELECT * FROM IModels WHERE id_i_test_result = ?",
				new Object[] { iTestResult }, new IModelsRowMapper());
	}

	public void save(IModels iModels) {
		// TODO

	}

	private class IModelsRowMapper implements RowMapper<IModels> {

		@Override
		public IModels mapRow(ResultSet rs, int rowNum) throws SQLException {

			IModels iModels = new IModels();
			iModels.setInitialState(rs.getString("initial_state"));
			iModels.setId(rs.getInt("id"));
			iModels.setIdSeq(rs.getInt("id_seq"));
			iModels.setIsMutante(rs.getBoolean("is_mutante"));
			iModels.setBuildFlag(rs.getBoolean("build_flag"));
			iModels.setContextId(rs.getString("context_id"));
			iModels.setConvFlag(rs.getBoolean("conv_flag"));
			iModels.setName(rs.getString("name"));
			iModels.setPath(rs.getString("path"));
			iModels.setIdITestResult(rs.getInt("id_i_test_result"));

			return iModels;

		}
	}
}
